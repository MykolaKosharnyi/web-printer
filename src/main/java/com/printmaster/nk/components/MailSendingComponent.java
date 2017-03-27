package com.printmaster.nk.components;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.printmaster.nk.beans.ComponentsForControllers;

@Component
public class MailSendingComponent {
	
	@Autowired
    ComponentsForControllers componets;
	
	@Autowired
    private JavaMailSenderImpl mailSender;
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private final static String HOST_EMAIL = "noreplay@forprint.net.ua";
	private final static String ADMIN_EMAIL = "nikolay.kosharniy@gmail.com";
	
	@SuppressWarnings("unchecked")
	public void observeRecipients(String subject, String messageBody, JSONArray recipientsFromJSON){
		Iterator<String> iterator = recipientsFromJSON.iterator();
		
		while(iterator.hasNext()){
			sendMessageTemplate(subject, messageBody, iterator.next());
		}	
	}
	
	public void observeRecipients(String subject, String messageBody, String concatenatedInStringRecipiets){
		sendMessageTemplate(subject, messageBody, concatenatedInStringRecipiets);		
	}
	
	private void sendMessageTemplate(String subject, String messageBody, String recipiets){
		MimeMessage msg = mailSender.createMimeMessage();

		try {
			Address adresFrom = new InternetAddress(HOST_EMAIL, "e-machine.com.ua");
		        
		    msg.setContent("Mail contect", "text/html");
		    msg.setFrom(adresFrom);
		    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipiets));

		    msg.setSubject(subject, "UTF-8");	       
		    msg.setText(messageBody.replace("../..", "http://e-machine.com.ua"), "UTF-8", "html");
		    
		} catch (UnsupportedEncodingException | MessagingException e) {
			exceptionMailSender(e);
		}
		mailSender.send(msg);
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

	public boolean checkEmail(JSONArray array, String email){		
		return !isParameterRepeated(array, email) && isEmailCorrect(email);
	}
	
	/**
	 * Validate email with regular expression
	 *
	 * @param email for validation
	 * @return true valid email, false invalid email
	 */
	private boolean isEmailCorrect(String email){
		String result = email.trim();
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(result);
		return matcher.matches();
	}
	
	private boolean isParameterRepeated(JSONArray array, String email){
		return array.contains(email);
	}
	
}
