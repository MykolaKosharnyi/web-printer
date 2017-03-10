package com.printmaster.nk.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.model.entity.Comment;
import com.printmaster.nk.model.service.CommentService;

@Controller
public class CommentsController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
    private JavaMailSenderImpl mailSender;
	
	@Autowired
    ComponentsForControllers componets;
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private final static String USERS_JSON_FILE_NAME = "user_mail_receiver";
	
	private final static String HOST_EMAIL = "noreplay@forprint.net.ua";
	private final static String ADMIN_EMAIL = "nikolay.kosharniy@gmail.com";
	
	@RequestMapping(value="/admin/comments", method = RequestMethod.GET)
    public String allComments(Model model) {	
		model.addAttribute("comments", commentService.getAllComments());
    	return "admin/comments";
    }
	
	@RequestMapping(value="/admin/comment/remove/{id}", method = RequestMethod.GET)
    public String removeComment(@PathVariable("id") long id){
		commentService.delete(id);	
        return "redirect:/admin/comments";
    }  
	
	@RequestMapping(value="/admin/change_comment_recipient_notification", method = RequestMethod.GET)
    public String changeCommentRecipientNotification(Model model){
		model.addAttribute("emails", componets.jsonArrayParser(USERS_JSON_FILE_NAME));
        return "admin/change_comment_recipient_notification";
    } 
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/comments/add_recipient_notification", method = RequestMethod.POST)
	public String addRecipientNotificationEmail(@RequestParam(value = "new_email") String email) {
		JSONArray array = componets.jsonArrayParser(USERS_JSON_FILE_NAME);
		array.add(email);	
		Collections.sort(array);
		componets.saveObject(array, USERS_JSON_FILE_NAME);
	    return "redirect:/admin/change_comment_recipient_notification";
	}
	
	@RequestMapping(value = "/admin/comments/remove_recipient_notification", method = RequestMethod.POST,
    		consumes = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody void removeRecipientNotificationEmail(@RequestBody String email) {
		JSONArray array = componets.jsonArrayParser(USERS_JSON_FILE_NAME);
		array.remove(email);	
		componets.saveObject(array, USERS_JSON_FILE_NAME);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/comments/check_email", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody JSONObject checkEmailC(@RequestBody String email) {
    	JSONObject result = new JSONObject();
    	JSONArray array = componets.jsonArrayParser(USERS_JSON_FILE_NAME);
    	result.put("result", checkEmail(array, email));
    	return result;
    }
	
	private boolean checkEmail(JSONArray array, String email){		
		return !isParameterRepeated(array, email) && isEmailCorrect(email);
	}
	
	private boolean isParameterRepeated(JSONArray array, String email){
		return array.contains(email);
	}
	
	/**
	 * Validate email with regular expression
	 *
	 * @param email
	 *            email for validation
	 * @return true valid email, false invalid email
	 */
	private boolean isEmailCorrect(String email){
		String result = email.trim();
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(result);
		return matcher.matches();
	}
	
	@RequestMapping(value="/comment/add", method = RequestMethod.POST)
    public @ResponseBody Comment addNewComment(@ModelAttribute("addComment") @Valid Comment comment) {	
		commentService.add(comment);
		observeSendedMessage("Добавлен новый комментарий", getCommentBody(comment));
    	return comment;
    }
	
	private String getCommentBody(Comment comment){
		StringBuilder result = new StringBuilder();
		result.append("Содержимое:");
		result.append("<<");
		result.append(String.format("<a href='http://e-machine.com.ua/%s/%s'>%s</a>", comment.getProductType(),
				comment.getProductId(),comment.getMessage()));
		result.append(">>");
		result.append("<br/>");
		result.append(String.format("Прокомментировал: %s %s, id=%d.", comment.getSecondName(), comment.getNameUser(),
				comment.getUserId()));
		return result.toString();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/comment/delete", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody JSONObject deleteComment(@RequestBody String data) {	
		Long id = Long.parseLong(data);
    	JSONObject result = new JSONObject();
    	Comment commentWichWillBeDeleted = commentService.findById(id);
    	boolean isDeleted = commentService.delete(id);
    	result.put("result", isDeleted);
    	
    	if(isDeleted){
    		observeSendedMessage("Удален комментарий", getCommentBody( commentWichWillBeDeleted ));
    	}
    	
    	return result;
    }
	
	private void observeSendedMessage(String subject, String messageBody){
		
		MimeMessage msg = mailSender.createMimeMessage();
		
		JSONArray array = componets.jsonArrayParser(USERS_JSON_FILE_NAME);
		@SuppressWarnings("unchecked")
		Iterator<String> iterator = array.iterator();
		
		while(iterator.hasNext()){
			try {
				Address adresFrom = new InternetAddress(HOST_EMAIL, "e-machine.com.ua");
		        
		        msg.setContent("Mail contect", "text/html");
		        msg.setFrom(adresFrom);
		        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(iterator.next()));

		        msg.setSubject(subject, "UTF-8");
		       
		        msg.setText(messageBody.replace("../..", "http://e-machine.com.ua"), "UTF-8", "html");
			} catch (UnsupportedEncodingException | MessagingException e) {
				exceptionMailSender(e);
			}
		}

		mailSender.send(msg);
	}
	
	private void exceptionMailSender(Exception ex){
		SimpleMailMessage email = new SimpleMailMessage();
		email.setFrom(HOST_EMAIL);
		email.setTo(ADMIN_EMAIL);
		email.setSubject("Error!");
		email.setText(getStackTrace(ex));

		mailSender.send(email);
	}
	
	private String getStackTrace(final Throwable throwable) {
	     final StringWriter sw = new StringWriter();
	     final PrintWriter pw = new PrintWriter(sw, true);
	     throwable.printStackTrace(pw);
	     return sw.getBuffer().toString();
	}
	
}
