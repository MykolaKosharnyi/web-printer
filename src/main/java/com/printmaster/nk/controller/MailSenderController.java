package com.printmaster.nk.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.components.MailSendingComponent;
import com.printmaster.nk.components.RecipientNotification;
import com.printmaster.nk.model.entity.MailSendingMessage;
import com.printmaster.nk.model.entity.MailSendingMessageOption;
import com.printmaster.nk.model.service.MailSendingOptionService;
import com.printmaster.nk.model.service.MailSendingService;

import static com.printmaster.nk.controller.ConstUsedInContr.*;

import javax.validation.Valid;

@Controller
public class MailSenderController {
	
	@Autowired
	private MailSendingService mailSendingService;
	
	@Autowired
	MailSendingComponent mailSendingComponent;
	
	@Autowired
	MailSendingOptionService mailSendingOptionService;
	
	public final static String LABEL_CHECK_MAIL = " (черновой вариант)";

	@RequestMapping(value = "/admin/all_sended_messages", method = RequestMethod.GET)
	public String getAllSendedMessages(Model model){			
		model.addAttribute("allMessages", mailSendingService.getAll());
	    return "admin/all_sended_messages";
	}
	
	@RequestMapping(value = "/admin/message/new", method = RequestMethod.GET)
	public String getCreateNewMessage(Model model){
		return putMessagePageParameters(model, new MailSendingMessage());
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/message/"+ PATH_CREATE, method = RequestMethod.POST) 
	public String createMessage(@ModelAttribute("mailMessage") @Valid MailSendingMessage mailMessage,
			BindingResult result, Model model){
		if (result.hasErrors()){
			return putMessagePageParameters(model, mailMessage);
		}		
		mailSendingService.save(mailMessage);
		return "redirect:/admin/all_sended_messages";
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/message/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String updateMessage(@ModelAttribute("mailMessage") @Valid MailSendingMessage mailMessage,
			BindingResult result, Model model){
		if (result.hasErrors()){
		    return putMessagePageParameters(model, mailMessage);
		}		
		mailSendingService.update(mailMessage);
		return "redirect:/admin/all_sended_messages";
	}
	
	@RequestMapping(value = "/admin/message/get_black_version_of_letter", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void sendBlackVersion(@RequestBody MailSendingMessage mailMessage) {
		mailMessage.setTitle(mailMessage.getTitle() + LABEL_CHECK_MAIL);
		
		try{
			mailSendingComponent.observeRecipients(mailMessage,
					mailSendingComponent.getRecipients(RecipientNotification.NOTIFICATION_MAIL_UPDATING.getTypeNotification()));
		} catch(Exception ex){
			mailSendingComponent.exceptionMailSender(ex);
		}
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
		model.addAttribute("listHeaderOption", mailSendingOptionService.messageOptionForHead());
		model.addAttribute("listFooterOption", mailSendingOptionService.messageOptionForFooter());
		return "admin/message";
	}
	
	/*------ Mail sending option -------*/
	@RequestMapping(value = "/admin/message/options", method = RequestMethod.GET)
	public String allOptions(Model model) {
		model.addAttribute("options", mailSendingOptionService.allMessageOption());
		return "admin/message/options";
	}
	
	@RequestMapping(value = "/admin/message/option/new", method = RequestMethod.GET)
	public String createNewMailOption(Model model) {
		model.addAttribute("option", new MailSendingMessageOption());
		return "admin/message/option";
	}
	
	@RequestMapping(value = "/admin/message/option/new", method = RequestMethod.POST) 
	public String createNewMailOption(@ModelAttribute("option") @Valid MailSendingMessageOption mailSendingMessageOption,
			BindingResult result, Model model){
		if (result.hasErrors()){
			model.addAttribute("option", mailSendingMessageOption);
		    return "admin/message/option";
		}		
		mailSendingOptionService.createSendingOption(mailSendingMessageOption);
		return "redirect:/admin/message/options";
	}
	
	@RequestMapping(value = "/admin/message/option/{id}", method = RequestMethod.GET)
	public String getMailOption(@PathVariable("id") int id, Model model) {
		model.addAttribute("option", mailSendingOptionService.getById(id));
		return "admin/message/option";
	}
	
	@RequestMapping(value = "/admin/message/option", method = RequestMethod.POST)
	public String editMailOption(@ModelAttribute("option") @Valid MailSendingMessageOption mailSendingMessageOption,
			BindingResult result, Model model) {
		if (result.hasErrors()){
			model.addAttribute("option", mailSendingMessageOption);
		    return "admin/message/option";
		}
		mailSendingOptionService.updateSendingOption(mailSendingMessageOption);
		return "redirect:/admin/message/options";
	}
	
	@RequestMapping(value = "/admin/message/option/remove/{id}", method = RequestMethod.GET)
	public String removeMailOption(@PathVariable("id") int id, Model model) {
		mailSendingOptionService.removeMessageOption(id);
		return "redirect:/admin/message/options";
	}
	
	@RequestMapping(value="/admin/message/option/showOnMailLetter/{id}",
			method = RequestMethod.POST,consumes=JSON_CONSUMES,headers = JSON_HEADERS)
    public @ResponseBody void setShowOnMailLetter(@PathVariable("id") int id, @RequestBody boolean value) {
		mailSendingOptionService.setShowing(id, value);
    }

}
