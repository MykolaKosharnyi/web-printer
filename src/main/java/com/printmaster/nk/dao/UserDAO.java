package com.printmaster.nk.dao;

import java.util.List;

import com.printmaster.nk.model.User;

public interface UserDAO {

	public long save(User user);
	public User findByUsername(String username);
    public void updateUser(User user);
    public List<User> listUsers();
    public User getUserById(long id);
    public void removeUser(long id);
	
}
