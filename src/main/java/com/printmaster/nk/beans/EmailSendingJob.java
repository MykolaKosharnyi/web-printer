package com.printmaster.nk.beans;

import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.printmaster.nk.model.entity.MailSendingMessage;
import com.printmaster.nk.model.entity.MailSendingMessage.StatusOfSending;
import com.printmaster.nk.model.entity.UserAddByAdmin;
import com.printmaster.nk.model.service.MailSendingService;
import com.printmaster.nk.model.service.UserAddByAdminService;

public class EmailSendingJob extends QuartzJobBean{
	
	private MailSendingService mailSendingService;
	
	@Autowired
    private MailSender mailSender;
	
	@Autowired
    private UserAddByAdminService userAddByAdminService;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		List<MailSendingMessage> listMessages = mailSendingService.getMessagesReadySend();
		for(MailSendingMessage message : listMessages){
			sendEmail(message);
		}
	}

	private void sendEmail(MailSendingMessage message) {
		String subject = message.getTitle();
		String messageBody = message.getMessage();
		
		List<UserAddByAdmin> usersList = userAddByAdminService.getUserBySubscription(message.getSubscription());
		
		for(UserAddByAdmin user : usersList){
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo( user.getEmail() );
			email.setSubject(subject);
			email.setText(messageBody);

			mailSender.send(email);
		}
		
		message.setStatus(StatusOfSending.SENDED);
		mailSendingService.update(message);
	}
	
	public void setMailSendingService(MailSendingService mailSendingService) {
		this.mailSendingService = mailSendingService;
	}
}
