package com.printmaster.nk.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.printmaster.nk.components.MailSendingComponent;
import com.printmaster.nk.model.entity.MailSendingMessage;
import com.printmaster.nk.model.entity.MailSendingMessage.StatusOfSending;
import com.printmaster.nk.model.entity.UserAddByAdmin;
import com.printmaster.nk.model.service.MailSendingService;
import com.printmaster.nk.model.service.UserAddByAdminService;

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
			List<UserAddByAdmin> usersList = userAddByAdminService.getUserBySubscription(message.getSubscription());
			for (UserAddByAdmin user : usersList) {	
				try{
					mailSendingComponent.observeRecipients(message, getConcatedEmails(user));
				} catch (Exception ex){
					mailSendingComponent.exceptionMailSender(ex);
				}	
			}
			
			message.setStatus(StatusOfSending.SENDED);
			mailSendingService.update(message);
		}		
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
