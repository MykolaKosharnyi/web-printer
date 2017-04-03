package com.printmaster.nk.controller;

import java.util.Collections;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.components.MailSendingComponent;

@Controller
public class RecipientMailNotification {
	
	@Autowired
    ComponentsForControllers componets;
	
	@Autowired
	MailSendingComponent mailSendingComponent;
	
	private final static String JSON_FILE_NAME_USER_MAIL_RECEIVER = "user_mail_receiver";
	
	@RequestMapping(value="/admin/recipient_notification/{typeNotification}", method = RequestMethod.GET)
    public String changeRecipientNotification(@PathVariable("typeNotification") String typeNotification,
    		Model model){
		JSONObject objectWithReceivers = componets.jsonObjectParser(JSON_FILE_NAME_USER_MAIL_RECEIVER);
		JSONArray array = (JSONArray) objectWithReceivers.get(typeNotification);
		model.addAttribute("emails", array);
		model.addAttribute("typeNotification", typeNotification);
		
		if("comment".equals(typeNotification)){
			model.addAttribute("headerOfNotification", "Подписчики на добавление комментов к товару");
		}
		
        return "admin/recipient_notification";
    } 
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/recipient_notification/add/{typeNotification}", method = RequestMethod.POST)
	public String addRecipientNotificationEmail(@PathVariable("typeNotification") String typeNotification,
			@RequestParam(value = "new_email") String email) {
		JSONObject objectWithReceivers = componets.jsonObjectParser(JSON_FILE_NAME_USER_MAIL_RECEIVER);
		JSONArray array = (JSONArray) objectWithReceivers.get(typeNotification);
		array.add(email);	
		Collections.sort(array);
		objectWithReceivers.put(typeNotification, array);
		componets.saveObject(objectWithReceivers, JSON_FILE_NAME_USER_MAIL_RECEIVER);
	    return "redirect:/admin/recipient_notification/" + typeNotification;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/recipient_notification/remove/{typeNotification}", method = RequestMethod.POST,
    		consumes = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody void removeRecipientNotificationEmail(@PathVariable("typeNotification") String typeNotification,
			@RequestBody String email) {
		JSONObject objectWithReceivers = componets.jsonObjectParser(JSON_FILE_NAME_USER_MAIL_RECEIVER);
		JSONArray array = (JSONArray) objectWithReceivers.get(typeNotification);
		array.remove(email);	
		objectWithReceivers.put(typeNotification, array);
		componets.saveObject(objectWithReceivers, JSON_FILE_NAME_USER_MAIL_RECEIVER);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/recipient_notification/check_email/{typeNotification}", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody JSONObject checkEmail(@PathVariable("typeNotification") String typeNotification,
    		@RequestBody String email) {
    	JSONObject result = new JSONObject();
    	JSONObject objectWithReceivers = componets.jsonObjectParser(JSON_FILE_NAME_USER_MAIL_RECEIVER);
    	JSONArray array = (JSONArray) objectWithReceivers.get(typeNotification);
    	result.put("result", mailSendingComponent.checkEmail(array, email));
    	return result;
    }
}
