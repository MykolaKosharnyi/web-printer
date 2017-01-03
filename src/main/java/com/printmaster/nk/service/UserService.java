package com.printmaster.nk.service;

import java.util.List;

import com.printmaster.nk.model.User;

public interface UserService {
	
	public long save(User user);
    public void updateUser(User user);
    public User findByUserName(String username);
    public List<User> listUsers();
    public User getUserById(long id);
    public void removeUser(long id);
}
