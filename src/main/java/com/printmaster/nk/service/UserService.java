package com.printmaster.nk.service;

import java.util.List;

import com.printmaster.nk.model.User;

public interface UserService {
	
	public long addUser(User user);
    public void updateUser(User user);
    public List<User> listUsers();
    public User getUserById(long id);
    public void removeUser(long id);
	public User loginUser(String userId, String password);
}
