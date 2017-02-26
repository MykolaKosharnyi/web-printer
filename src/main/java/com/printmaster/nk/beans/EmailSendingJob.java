package com.printmaster.nk.beans;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
    private JavaMailSenderImpl mailSender;
	
	@Autowired
    private UserAddByAdminService userAddByAdminService;

	private final static String HOST_EMAIL = "noreplay@forprint.net.ua";
	private final static String ADMIN_EMAIL = "nikolay.kosharniy@gmail.com";

	public void executeInternal() {
		try{
			for(MailSendingMessage message : mailSendingService.getMessagesReadySend()){
				sendEmail(message);
			}
		} catch(Exception ex){
			exceptionMailSender(ex);
		}
	}
	
	/**
	 * Send message with error to admin
	 * @param ex from place where we get error
	 */
	private void exceptionMailSender(Exception ex){
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(HOST_EMAIL);
		email.setTo(ADMIN_EMAIL);
		email.setSubject("Error!");
		email.setText(getStackTrace(ex));

		mailSender.send(email);
	}
	
	/**
	 * Get all stack trace about error which we get during work
	 * @param throwable from which we get output message
	 * @return all stack trace where we get error
	 */
	private String getStackTrace(final Throwable throwable) {
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	}

	private void sendEmail(MailSendingMessage message) throws UnsupportedEncodingException, MessagingException {
		String subject = message.getTitle();
		String messageBody = message.getMessage();

		List<UserAddByAdmin> usersList = userAddByAdminService.getUserBySubscription(message.getSubscription());

		for (UserAddByAdmin user : usersList) {

			MimeMessage msg = mailSender.createMimeMessage();

			Address adresFrom = new InternetAddress(HOST_EMAIL, "e-machine.com.ua");

			msg.setContent("Mail contect", "text/html");
			msg.setFrom(adresFrom);
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(getConcatedEmails(user)));
			msg.setSubject(subject, "UTF-8");
			msg.setText(messageBody.replace("../..", "http://e-machine.com.ua"), "UTF-8", "html");

			mailSender.send(msg);
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
