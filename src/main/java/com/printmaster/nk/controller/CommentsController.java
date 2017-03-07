package com.printmaster.nk.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.model.entity.Comment;
import com.printmaster.nk.model.service.CommentService;

@Controller
public class CommentsController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
    private JavaMailSenderImpl mailSender;
	
	private final static String HOST_EMAIL = "noreplay@forprint.net.ua";
	private final static String ADMIN_EMAIL = "nikolay.kosharniy@gmail.com";
	
	@RequestMapping(value="/admin/comments", method = RequestMethod.GET)
    public String allComments(Model model) {	
		model.addAttribute("comments", commentService.getAllComments());
    	return "admin/comments";
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
    	boolean isDeleted = commentService.delete(id);
    	result.put("result", isDeleted);
    	
    	if(isDeleted){
    		observeSendedMessage("Удален комментарий", getCommentBody(commentService.findById(id)));
    	}
    	
    	return result;
    }
	
	private void observeSendedMessage(String subject, String messageBody){
		
		MimeMessage msg = mailSender.createMimeMessage();

		try {
			Address adresFrom = new InternetAddress(HOST_EMAIL, "e-machine.com.ua");
	        
	        msg.setContent("Mail contect", "text/html");
	        msg.setFrom(adresFrom);
	        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("elvis_patriot@ukr.net,nikolay.kosharniy@gmail.com"));

	        msg.setSubject(subject, "UTF-8");
	       
	        msg.setText(messageBody.replace("../..", "http://e-machine.com.ua"), "UTF-8", "html");
		} catch (UnsupportedEncodingException | MessagingException e) {
			exceptionMailSender(e);
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
