package com.printmaster.nk.model.service;

import java.util.List;

import com.printmaster.nk.model.entity.User;

public interface UserService {	
	long save(User user);
    void updateUser(User user);
    User findByUserName(String username);
    List<User> listUsers();
    User getUserById(long id);
    void removeUser(long id);
}
