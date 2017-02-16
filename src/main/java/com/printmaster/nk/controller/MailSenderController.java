package com.printmaster.nk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.model.entity.MailSendingMessage;
import com.printmaster.nk.model.service.MailSendingService;

import static com.printmaster.nk.controller.ConstUsedInContr.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class MailSenderController {
	
	@Autowired
    private MailSender mailSender;
	
	@Autowired
	private MailSendingService mailSendingService;
	
	@RequestMapping(value="/ask/product", method = RequestMethod.POST, consumes=JSON_CONSUMES,
			headers = JSON_HEADERS)
    public @ResponseBody void askProductPage(HttpServletRequest request) {

        String recipientAddress = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setFrom("noreplay@forprint.net.ua");
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
         
        // sends the e-mail
        mailSender.send(email);

    }

	@RequestMapping(value = "/admin/all_sended_messages", method = RequestMethod.GET)
	public String getAllSendedMessages(Model model) {			
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
}
