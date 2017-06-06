package com.printmaster.nk.controller;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.components.MailSendingComponent;
import com.printmaster.nk.components.RecipientNotification;
import com.printmaster.nk.model.entity.Comment;
import com.printmaster.nk.model.service.CommentService;

@Controller
public class CommentsController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	MailSendingComponent mailSendingComponent;
	
	@Autowired
    ComponentsForControllers componets;

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
	
	@RequestMapping(value="/comment/add", method = RequestMethod.POST)
    public @ResponseBody Comment addNewComment(@ModelAttribute("addComment") @Valid Comment comment) {	
		commentService.add(comment);
		
		switch(comment.getTypeComment()){
		case COMMENT:
			mailSendingComponent.observeRecipients("Добавлен новый комментарий", getCommentBody(comment), 
					mailSendingComponent.getRecipients(RecipientNotification.NOTIFICATION_COMMENT.getTypeNotification()));
			break;
		case INACCURACY_IN_DESCRIPTION:
			mailSendingComponent.observeRecipients("Добавлен новый комментарий по уточнению описания", getCommentBody(comment), 
					mailSendingComponent.getRecipients(RecipientNotification.NOTIFICATION_INACCURACY.getTypeNotification()));
			break;
		}
		
    	return comment;
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
    		switch(commentWichWillBeDeleted.getTypeComment()){
			case COMMENT:
				mailSendingComponent.observeRecipients("Удален комментарий", getCommentBody( commentWichWillBeDeleted ),
	    				mailSendingComponent.getRecipients(RecipientNotification.NOTIFICATION_COMMENT.getTypeNotification()));
				break;
			case INACCURACY_IN_DESCRIPTION:
				mailSendingComponent.observeRecipients("Удален комментарий по уточнению описания", getCommentBody( commentWichWillBeDeleted ),
	    				mailSendingComponent.getRecipients(RecipientNotification.NOTIFICATION_INACCURACY.getTypeNotification()));
				break;
    		}
    		
    		
    	}
    	return result;
    }

	private String getCommentBody(Comment comment){
		StringBuilder result = new StringBuilder();
		result.append("Содержимое:");
		result.append("<<");
		
		String optionTabOnPage = "";
		switch(comment.getTypeComment()){
			case COMMENT:
				optionTabOnPage = "?option=2";
				break;
			case INACCURACY_IN_DESCRIPTION:
				optionTabOnPage = "?option=4";
				break;
		}

		result.append(String.format("<a href='http://e-machine.com.ua/%s/%s%s'>%s</a>", comment.getProductType(),
				comment.getProductId(), optionTabOnPage, comment.getMessage()));
		result.append(">>");
		result.append("<br/>");
		result.append(String.format("Прокомментировал: %s %s, id=%d.", comment.getSecondName(), comment.getNameUser(),
				comment.getUserId()));
		return result.toString();
	}

}
