package com.printmaster.nk.model.dao;

import java.util.List;

import com.printmaster.nk.model.entity.Comment;

public interface CommentDAO {
	long add(Comment comment);
	void edit(Comment comment);
	void delete(long id);
	Comment findById(long id);
	List<Comment> getAllComments();
	List<Comment> getAllForProduct(String type, long id);
	List<Comment> getAllForUser(long id);
}
