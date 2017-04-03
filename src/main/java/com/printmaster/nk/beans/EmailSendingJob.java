package com.printmaster.nk.beans;

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
		List<UserAddByAdmin> usersList = userAddByAdminService.getUserBySubscription(message.getSubscription());
		for (UserAddByAdmin user : usersList) {			
			mailSendingComponent.observeRecipients(message, getConcatedEmails(user));
		}
		
		message.setStatus(StatusOfSending.SENDED);
		mailSendingService.update(message);
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
		for(int i=0; i<emails.length; i++){
			if(emails[i]!=null && !emails[i].isEmpty()){
				result.append(emails[i]);
				if(i!=emails.length-1){//check if not last element
					result.append(",");
				}
			}
		}
		return result.toString();
	}
}
