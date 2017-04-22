package com.printmaster.nk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.components.MailSendingComponent;
import com.printmaster.nk.components.RecipientNotification;
import com.printmaster.nk.model.entity.User;
import com.printmaster.nk.model.entity.UserProposal;
import com.printmaster.nk.model.service.UserProposalService;
import com.printmaster.nk.model.service.UserService;

@Controller
public class UserProposalController {
	
	@Autowired
	private UserProposalService userProposalService;
	
	@Autowired
	MailSendingComponent mailSendingComponent;
	
	@Autowired
    private UserService userService;
	
	@RequestMapping(value="/send_proposal", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void getUserProposal(@RequestBody UserProposal userProposal) {
		if(userProposal.isLogined()){
			User user = getUser();
			if(user!=null){
				userProposal.setIdUser(user.getId());
				userProposal.setName(user.getFirstName() + " " + user.getLastname());
				userProposal.setPhoneNumber(user.getTelephone());
				userProposal.setEmail(user.getEmail());
			}
		} 
		
//		long idOfProposal = userProposalService.create(userProposal);
//		userProposal.setId(idOfProposal);
		
		mailSendingComponent.observeRecipients("Отправлен запрос на уточнение цены", createProposalBody(userProposal), 
				mailSendingComponent.getRecipients(RecipientNotification.NOTIFICATION_PROPOSAL_PRICE.getTypeNotification()));
    }
	
	private String createProposalBody(UserProposal userProposal){
		StringBuilder result = new StringBuilder();
		result.append("Предложенная цена: ");
		result.append(userProposal.getPrice());
		result.append("<br/>");
		result.append("<br/>");
		
		if(userProposal.getDescription()!=null && userProposal.getDescription().trim()!=""){
			result.append("Описание к цене: ");
			result.append(userProposal.getDescription());
			result.append("<br/>");
			result.append("<br/>");
		}
		
		result.append(String.format("<a href='http://e-machine.com.ua/%s/%s'><---Уточнение по товару---></a>", userProposal.getTypeProduct(),
				userProposal.getIdProduct()));
		result.append("<br/>");
		result.append("<br/>");
		
		result.append("<hr/><br/>");
		
		result.append("<strong>Информация об просителе</strong>");
		result.append("<br/>");
		
		if(userProposal.getIdUser()!=0){
			result.append("Это зарегистрированный пользователь");	
			result.append("<br/>");
			result.append(String.format("Id пользователя: %s", userProposal.getIdUser()));
		} else {
			result.append("Это <strong>не</strong> зарегистрированный пользователь");
		}
		
		result.append("<br/>");
		result.append("<br/>");
		
		result.append("Имя: ");
		result.append(userProposal.getName());
		result.append("<br/>");
		result.append("<br/>");
		
		result.append("E-mail: ");
		result.append(userProposal.getEmail());
		result.append("<br/>");
		result.append("<br/>");
		
		result.append("Телефон: ");
		result.append(userProposal.getPhoneNumber());
				
		return result.toString();
	}
	
	private User getUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	String username = null;
    	if (principal instanceof UserDetails) {
    		username = ((UserDetails)principal).getUsername();
    	} else {
    		username = (String) principal;
    	}
    	return userService.findByUserName(username);
	}
}
