package com.printmaster.nk.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.User;

@Transactional
public interface UserService {
	
	public void save(User user);
    public void updateUser(User user);
    public User findByUserName(String username);
    public List<User> listUsers();
    public User getUserById(long id);
    public void removeUser(long id);
}
