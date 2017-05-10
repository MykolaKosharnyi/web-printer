package com.printmaster.nk.model.dao;

import java.util.List;

import com.printmaster.nk.model.entity.User;

public interface UserDAO {
	long save(User user);
	void updateUser(User user);
	User findByEmail(String email);    
    List<User> listUsers();
    User getUserById(long id);
    void removeUser(long id);
}
