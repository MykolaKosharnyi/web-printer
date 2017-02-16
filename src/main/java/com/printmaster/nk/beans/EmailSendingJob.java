package com.printmaster.nk.beans;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

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
    private MailSender mailSender;
	
	@Autowired
    private UserAddByAdminService userAddByAdminService;


	public void executeInternal() {
		try{
			List<MailSendingMessage> listMessages = mailSendingService.getMessagesReadySend();
			for(MailSendingMessage message : listMessages){
				sendEmail(message);
			}
		} catch(Exception ex){
			SimpleMailMessage email = new SimpleMailMessage();
			email.setFrom("noreplay@forprint.net.ua");
			email.setTo("nikolay.kosharniy@gmail.com");
			email.setSubject("Error!");
			email.setText(getStackTrace(ex));

			mailSender.send(email);
		}
	}
	
	private String getStackTrace(final Throwable throwable) {
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	}

	private void sendEmail(MailSendingMessage message) {
		String subject = message.getTitle();
		String messageBody = message.getMessage();
		
		List<UserAddByAdmin> usersList = userAddByAdminService.getUserBySubscription(message.getSubscription());
		
		for(UserAddByAdmin user : usersList){
			SimpleMailMessage email = new SimpleMailMessage();
			email.setFrom("noreplay@forprint.net.ua");
			email.setTo( user.getEmail() );
			email.setSubject(subject);
			email.setText(messageBody);

			mailSender.send(email);
		}
		
//		message.setStatus(StatusOfSending.SENDED);
//		mailSendingService.update(message);
	}
	
	public void setMailSendingService(MailSendingService mailSendingService) {
		this.mailSendingService = mailSendingService;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void setUserAddByAdminService(UserAddByAdminService userAddByAdminService) {
		this.userAddByAdminService = userAddByAdminService;
	}
}
