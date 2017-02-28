package com.printmaster.nk.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.model.entity.Comment;
import com.printmaster.nk.model.entity.Printer;
import com.printmaster.nk.model.service.CommentService;

@Controller
public class CommentsController {

	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/comment/add", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Comment addNewComment(@ModelAttribute("addComment") @Valid Comment comment) {
		

		commentService.add(comment);
    	return comment;
    }
	
}
