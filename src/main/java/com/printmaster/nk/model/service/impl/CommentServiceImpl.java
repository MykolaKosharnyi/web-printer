package com.printmaster.nk.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.CommentDAO;
import com.printmaster.nk.model.entity.Comment;
import com.printmaster.nk.model.entity.User;
import com.printmaster.nk.model.service.CommentService;
import com.printmaster.nk.model.service.UserService;

public class CommentServiceImpl implements CommentService{
	
	private CommentDAO commentDAO;
	
	@Autowired
    private UserService userService;

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Override
	@Transactional
	public void add(Comment comment) {
		
		User userLivedComment = getUser();
		comment.setDateWriting(new Date());
		comment.setUserId( userLivedComment.getId() );
		comment.setPathUserPicture(userLivedComment.getNameUserPicture());
		comment.setNameUser(userLivedComment.getFirstName());
		comment.setSecondName(userLivedComment.getLastname());
		comment.setId( commentDAO.add(comment) );
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

	@Override
	@Transactional
	public void edit(Comment comment) {
		commentDAO.edit(comment);
	}

	@Override
	@Transactional
	public boolean delete(long id) {
		
		if(checkCommentBelongCurrentUser(id)){
			commentDAO.delete(id);
			return true;
		} else {
			return false;
		}
		
	}
	
	private boolean checkCommentBelongCurrentUser(long id){
		Comment comment = commentDAO.findById(id);
		return new Long(comment.getUserId()).equals(new Long(getUser().getId()));
	}

	@Override
	@Transactional
	public List<Comment> getAllComments() {
		return commentDAO.getAllComments();
	}

	@Override
	@Transactional
	public List<Comment> getAllForProduct(String type, long id) {
		return commentDAO.getAllForProduct(type, id);
	}

	@Override
	@Transactional
	public List<Comment> getAllForUser(long id) {
		return commentDAO.getAllForUser(id);
	}

	@Override
	@Transactional
	public Comment findById(long id) {
		return commentDAO.findById(id);
	}

}
