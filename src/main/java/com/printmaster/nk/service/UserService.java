package com.printmaster.nk.service;

import java.util.List;

import com.printmaster.nk.model.User;

public interface UserService {
	
	public void save(User user);
    public void updateUser(User user);
    public User findByUsername(String username);
    public List<User> listUsers();
    public User getUserById(long id);
    public void removeUser(long id);
}
