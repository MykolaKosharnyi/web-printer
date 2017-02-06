package com.printmaster.nk.dao;

import java.util.List;

import com.printmaster.nk.model.entity.User;

public interface UserDAO {
	long save(User user);
	void updateUser(User user);
	User findByUserName(String username);    
    List<User> listUsers();
    User getUserById(long id);
    void removeUser(long id);
}
