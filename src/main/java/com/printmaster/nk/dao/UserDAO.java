package com.printmaster.nk.dao;

import java.util.List;

import com.printmaster.nk.model.User;

public interface UserDAO {
	long save(User user);
	User findByUserName(String username);
    void updateUser(User user);
    List<User> listUsers();
    User getUserById(long id);
    void removeUser(long id);
}
