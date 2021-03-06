package com.printmaster.nk.model.service;

import java.util.List;

import com.printmaster.nk.model.entity.Comment;

public interface CommentService {
	void add(Comment comment);
	void edit(Comment comment);
	boolean delete(long id);
	Comment findById(long id);
	List<Comment> getAllComments();
	List<Comment> getAllForProduct(String type, long id);
	List<Comment> getAllForUser(long id);
}
