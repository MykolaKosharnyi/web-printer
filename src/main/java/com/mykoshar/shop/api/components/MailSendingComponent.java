package com.mykoshar.shop.api.components;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.mykoshar.shop.api.model.entity.MailSendingMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.mykoshar.shop.api.beans.ComponentsForControllers;
import com.mykoshar.shop.api.model.service.MailSendingOptionService;

@Slf4j
@RequiredArgsConstructor

@Component
public class MailSendingComponent {
    private final ComponentsForControllers componets;
    private final JavaMailSenderImpl mailSender;
	private final MailSendingOptionService mailSendingOptionService;
	
	@Value( "${magic.number}" )
	private int magicNumber;
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private final static String HOST_EMAIL = "noreplay@forprint.net.ua";
	private final static String ADMIN_EMAIL = "nikolay.kosharniy@gmail.com";
	
	public final static String JSON_FILE_NAME_USER_MAIL_RECEIVER = "user_mail_receiver";
//	public final static String NOTIFICATION_COMMENT = "comment";
//	public final static String NOTIFICATION_MAIL_UPDATING = "mail_sending";
//	public final static String USER_PROPOSAL_PRICE = "user_proposal_price";
	
	public JSONArray getRecipients(String typeNotification){
		JSONObject objectWithReceivers = componets.jsonObjectParser(JSON_FILE_NAME_USER_MAIL_RECEIVER);
		return (JSONArray) objectWithReceivers.get(typeNotification);
	}
	
	@SuppressWarnings("unchecked")
	public void observeRecipients(String subject, String messageBody, JSONArray recipientsFromJSON){
		Iterator<String> iterator = recipientsFromJSON.iterator();
		
		while(iterator.hasNext()){
			sendMessageTemplate(subject, messageBody, iterator.next());
		}	
	}
	
	@SuppressWarnings("unchecked")
	public void observeRecipients(MailSendingMessage mailMessage, JSONArray recipientsFromJSON){
		Iterator<String> iterator = recipientsFromJSON.iterator();
		
		while(iterator.hasNext()){
			sendMessageTemplate(mailMessage.getTitle(), createMessageBody(mailMessage), iterator.next());
		}	
	}
	
	public void observeRecipients(MailSendingMessage mailMessage, String concatenatedInStringRecipiets, long id){
		sendMessageTemplate(mailMessage.getTitle(), addUnsubscriber( createMessageBody(mailMessage), id),
				concatenatedInStringRecipiets);		
	}
	
	public void observeRecipients(String subject, String messageBody, String concatenatedInStringRecipiets){
		sendMessageTemplate(subject, messageBody, concatenatedInStringRecipiets);		
	}
	
	private String addUnsubscriber(String messageBody, long id){
		return messageBody.replace("/subscription/{id}", "/subscription/" + encodeId(id));
	}
	
	private String encodeId(Long id){
        long xor = 0;
        xor = Long.reverseBytes(id) ^ magicNumber;
		return Long.toBinaryString(xor);
	}
	
	private String createMessageBody(MailSendingMessage mailMessage){
		StringBuilder messageBody = new StringBuilder();
		if(mailMessage.getHeaderOption()!=0){
			messageBody.append(mailSendingOptionService.getById(mailMessage.getHeaderOption()).getText());
		}
		
		messageBody.append(mailMessage.getMessage());
		
		if(mailMessage.getFooterOption()!=0){
			messageBody.append(mailSendingOptionService.getById(mailMessage.getFooterOption()).getText());
		}
		return messageBody.toString();
	}
	
	private void sendMessageTemplate(String subject, String messageBody, String recipiets){
		MimeMessage msg = mailSender.createMimeMessage();

		try {
			Address adresFrom = new InternetAddress(HOST_EMAIL, "e-machine.com.ua");
		        
		    msg.setContent("Mail contect", "text/html");
		    msg.setFrom(adresFrom);
		    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipiets));

		    msg.setSubject(subject, "UTF-8");	
		    messageBody = messageBody.replace("../../..", "http://e-machine.com.ua")
		    		.replace("../..", "http://e-machine.com.ua");
		    msg.setText(createWrapperForBodyMessage(messageBody), "UTF-8", "html");
		    
		} catch (UnsupportedEncodingException | MessagingException e) {
			exceptionMailSender(e);
		} catch (Exception e){
			exceptionMailSender(e);
		}
		mailSender.send(msg);
	}
	
	public void sendExcelOrderFromCart(JSONArray recipientsFromJSON, File order){
		@SuppressWarnings("unchecked")
		Iterator<String> iterator = recipientsFromJSON.iterator();
		
		while(iterator.hasNext()){
			MimeMessage msg = mailSender.createMimeMessage();

			try {
				Address adresFrom = new InternetAddress(HOST_EMAIL, "e-machine.com.ua");		        
			    msg.setFrom(adresFrom);
			    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(iterator.next()));
			    msg.setSubject("Оформлено замовлення", "UTF-8");	
			    
			    //Add attachments 
			    MimeMultipart multipart = new MimeMultipart("related");
				BodyPart messageBodyPart = new MimeBodyPart();
				messageBodyPart.setContent("У вкладенні до цього листа Ви знайдете оформлений звіт на покупку товару(Пароль:1111).", "text/html; charset=utf-8");
				multipart.addBodyPart(messageBodyPart);

				messageBodyPart = new MimeBodyPart();
				DataSource attachReportDS = new FileDataSource(order);			
				messageBodyPart.setDataHandler(new DataHandler(attachReportDS));
				messageBodyPart.setFileName(MimeUtility.encodeWord("Order_" + new SimpleDateFormat("HH:mm_dd:MM:yyyy").format(new Date())));

				multipart.addBodyPart(messageBodyPart);

				msg.setContent(multipart);
			    
				log.info("Order was sended to manager successfully!");
			} catch (UnsupportedEncodingException | MessagingException e) {
				exceptionMailSender(e);
			} catch (Exception e){
				exceptionMailSender(e);
			}
			mailSender.send(msg);
		}
	}
	
	private String createWrapperForBodyMessage(String messageBody){
		StringBuilder result = new StringBuilder();
		result.append("<div style='display: block; margin: 0px auto; max-width: 1000px; width: inherit;'>");
		result.append(messageBody);
		result.append("</div>");
		return result.toString();
	}
	
	/**
	 * Send message with error to admin
	 * @param ex from place where we get error
	 */
	public void exceptionMailSender(Exception ex){
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
	
	public boolean checkEmail(String email){		
		return isEmailCorrect(email);
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
