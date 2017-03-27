package com.printmaster.nk.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.components.MailSendingComponent;
import com.printmaster.nk.model.entity.MailSendingMessage;
import com.printmaster.nk.model.entity.MailSendingMessage.StatusOfSending;
import com.printmaster.nk.model.service.MailSendingService;

import static com.printmaster.nk.controller.ConstUsedInContr.*;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MailSenderController {
	
	@Autowired
	private MailSendingService mailSendingService;
	
	@Autowired
	MailSendingComponent mailSendingComponent;
	
	@Autowired
    ComponentsForControllers componets;
	
	private final static String RECIPIENT_WHEN_MESSAGE_UPDATED = "alise@forprint.net.ua,nikolay.kosharniy@gmail.com";
	private final static String RECIPIENT_WHEN_ASKING_ABOUT_PRODUCT = "alise@forprint.net.ua,nikolay.kosharniy@gmail.com";
	private final static String USERS_JSON_FILE_NAME = "user_mail_receiver";
	
	@RequestMapping(value="/ask/product", method = RequestMethod.POST, consumes=JSON_CONSUMES, headers = JSON_HEADERS)
    public @ResponseBody void askProductPage(HttpServletRequest request) {
		String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        
		mailSendingComponent.observeRecipients(subject, message, RECIPIENT_WHEN_ASKING_ABOUT_PRODUCT);
    }

	@RequestMapping(value = "/admin/all_sended_messages", method = RequestMethod.GET)
	public String getAllSendedMessages(Model model){			
		model.addAttribute("allMessages", mailSendingService.getAll());
	    return "admin/all_sended_messages";
	}
	
	@RequestMapping(value = "/admin/message/new", method = RequestMethod.GET)
	public String getCreateNewMessage(Model model) {
		return putMessagePageParameters(model, new MailSendingMessage());
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/message/"+ PATH_CREATE, method = RequestMethod.POST) 
	public String saveUserAddByAdmin(@ModelAttribute("mailMessage") @Valid MailSendingMessage mailMessage,
			BindingResult result, Model model){
		if (result.hasErrors()){
			return putMessagePageParameters(model, mailMessage);
		}		
		mailSendingService.save(mailMessage);
		return "redirect:/admin/all_sended_messages";
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/message/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String changeUserAddByAdmin(@ModelAttribute("mailMessage") @Valid MailSendingMessage mailMessage,
			BindingResult result, Model model){
		if (result.hasErrors()){
		    return putMessagePageParameters(model, mailMessage);
		}		
		mailSendingService.update(mailMessage);
		if(mailMessage.getStatus().equals(StatusOfSending.MODIFICATION_PROCESS)){
			mailSendingComponent.observeRecipients(mailMessage.getTitle(), mailMessage.getMessage(),
					RECIPIENT_WHEN_MESSAGE_UPDATED);
		}
		return "redirect:/admin/all_sended_messages";
	}
	
	@RequestMapping(value = "/admin/message/{id}", method = RequestMethod.GET)
	public String getCreateNewMessage(@PathVariable("id") long id, Model model) {
	    return putMessagePageParameters(model, mailSendingService.getById(id));
	}
	
	@RequestMapping(value = "/admin/message/deny/{id}", method = RequestMethod.GET)
	public String denyMessage(@PathVariable("id") long id, Model model) {
		mailSendingService.denyMassage(id);
		return "redirect:/admin/all_sended_messages";
	}
	
	@RequestMapping(value = "/admin/message/copy/{id}", method = RequestMethod.GET)
	public String copyMessage(@PathVariable("id") long id, Model model) {
		MailSendingMessage result = mailSendingService.copyMassage(id);
		result.setId(0l);
		result.setStatus(null);
		return putMessagePageParameters(model, result);
	}
	
	@RequestMapping(value = "/admin/message/remove/{id}", method = RequestMethod.GET)
	public String removeMessage(@PathVariable("id") long id, Model model) {
		mailSendingService.delete(id);
		return "redirect:/admin/all_sended_messages";
	}
	
	private String putMessagePageParameters(Model model, MailSendingMessage mailMessage){
		model.addAttribute("mailMessage", mailMessage);
		model.addAttribute("listSubscription", listSubscription);
		return "admin/message";
	}
	
	
	
	/*-------------------------  Part for adding mails recipients ----------------------------------------- */
	
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
    	result.put("result", mailSendingComponent.checkEmail(array, email));
    	return result;
    }
}
