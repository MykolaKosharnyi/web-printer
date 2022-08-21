package com.mykoshar.shop.api.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mykoshar.shop.api.model.entity.MailSendingMessage;
import com.mykoshar.shop.api.model.entity.UserAddByAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mykoshar.shop.api.components.MailSendingComponent;
import com.mykoshar.shop.api.components.RecipientNotification;
import com.mykoshar.shop.api.model.service.MailSendingService;
import com.mykoshar.shop.api.model.service.UserAddByAdminService;

@Component("emailSendingJob")
public class EmailSendingJob{
	
	@Autowired
	private MailSendingService mailSendingService;
	
	@Autowired
    private UserAddByAdminService userAddByAdminService;
	
	@Autowired
	MailSendingComponent mailSendingComponent;

	public void executeInternal() {
		for(MailSendingMessage message : mailSendingService.getMessagesReadySend()){
			sendEmail(message);			
		}
	}

	private void sendEmail(MailSendingMessage message) {
		if(!message.getSubscription().isEmpty()){
			int quantityOfPeopleWhoGetMessage = 0;
			List<String> emailsListWhoNotGetMessage = new ArrayList<>();
			
			List<UserAddByAdmin> usersList = null;
			try{
				if(message.getSubscription()!=null)
				mailSendingComponent.observeRecipients("List subscription:", message.getSubscription().toString(), "nikolay.kosharniy@gmail.com");
				
				if(message.getScopeOfActivities()!=null)
				mailSendingComponent.observeRecipients("List scope of activities:", message.getScopeOfActivities().toString(), "nikolay.kosharniy@gmail.com");
				
				usersList = userAddByAdminService.getUserBySubscription(message.getSubscription(), 
						message.getScopeOfActivities());
			} catch (Exception ex){
				mailSendingComponent.exceptionMailSender(ex);
			}
			
			for (UserAddByAdmin user : usersList) {	
				try{
					mailSendingComponent.observeRecipients(message, getConcatedEmails(user), user.getId());
					quantityOfPeopleWhoGetMessage++;
				} catch (Exception ex){
					mailSendingComponent.exceptionMailSender(ex);
					emailsListWhoNotGetMessage.add(getConcatedEmails(user));
				}	
			}
			
			sendReportAboutMailSending(message, quantityOfPeopleWhoGetMessage, emailsListWhoNotGetMessage);
			
			message.setStatus(MailSendingMessage.StatusOfSending.SENDED);
			mailSendingService.update(message);
		}		
	}
	
	private void sendReportAboutMailSending(MailSendingMessage message, int quantityOfPeopleWhoGetMessage,
			List<String> emailsListWhoNotGetMessage){
		
		try{
			mailSendingComponent.observeRecipients("Отчет об рассылке сообщения, c id=" + message.getId(), 
					createReport(quantityOfPeopleWhoGetMessage, emailsListWhoNotGetMessage),
					mailSendingComponent.getRecipients(RecipientNotification.NOTIFICATION_REPORT_ABOUT_MAIL_SENDING.getTypeNotification()));
		} catch(Exception ex){
			mailSendingComponent.exceptionMailSender(ex);
		}
		
	}
	
	private String createReport(int quantityOfPeopleWhoGetMessage, List<String> emailsListWhoNotGetMessage){
		StringBuilder result = new StringBuilder();
		result.append(String.format("Отчет: %d добавленных пользователей успешно получили письма.", quantityOfPeopleWhoGetMessage));
		if(emailsListWhoNotGetMessage.size() > 0){
			result.append("<br/>");
			result.append("<br/>");
			
			result.append("Електронные адреса при отправке сообщения на которые произошла ошибка:");
			result.append("<br/>");
			
			int index = 0;
			for(Iterator<String> iterator = emailsListWhoNotGetMessage.iterator(); iterator.hasNext();){
				result.append(index + ". ").append(iterator.next()).append(";");
				if(iterator.hasNext()){
					result.append("<br/>");
				}
			}
		}
		
		return result.toString();
	}
	
	/**
	 * For concatenating e-mails from user
	 * @param user from which we get e-mails
	 * @return one string which contain concatenated e-mails
	 */
	private String getConcatedEmails(UserAddByAdmin user){
		return getConcatedEmails(user.getEmail(), user.getEmail2(), user.getEmail3());
	}
	
	/**
	 * For concatenating input e-mails to one string
	 * @param emails which to concatenate
	 * @return one string which contain concatenated e-mails
	 */
	private String getConcatedEmails(String... emails){
		StringBuilder result = new StringBuilder();
		List<String> cleanEmailList = getNotEmptyEmailList(emails);
		
		for(int i=0; i<cleanEmailList.size(); i++){
			if(cleanEmailList.get(i)!=null && !cleanEmailList.get(i).isEmpty()){
				result.append(cleanEmailList.get(i));
				if(i!=cleanEmailList.size()-1){//check if not last element
					result.append(",");
				}
			}
		}
		return result.toString();
	}
	
	private List<String> getNotEmptyEmailList(String... emails){
		List<String> result = new ArrayList<>();
		
		for(int i=0; i<emails.length; i++){
			if(emails[i]!=null && !emails[i].isEmpty()){
				result.add(emails[i]);
			}
		}
		return result;
	}
}
