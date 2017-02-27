package com.printmaster.nk.model.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.CommentDAO;
import com.printmaster.nk.model.entity.Comment;
import com.printmaster.nk.model.service.CommentService;

public class CommentServiceImpl implements CommentService{
	
	private CommentDAO commentDAO;

	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Override
	@Transactional
	public void add(Comment comment) {
		commentDAO.add(comment);
	}

	@Override
	@Transactional
	public void edit(Comment comment) {
		commentDAO.edit(comment);
	}

	@Override
	@Transactional
	public void delete(long id) {
		commentDAO.delete(id);
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

}
