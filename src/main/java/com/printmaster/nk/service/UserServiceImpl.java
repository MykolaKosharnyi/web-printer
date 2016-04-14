package com.printmaster.nk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.UserDAO;
import com.printmaster.nk.model.User;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

	@Override
	@Transactional
	public long addUser(User user) {
		return this.userDAO.addUser(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		this.userDAO.updateUser(user);
	}

	@Override
	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Override
	@Transactional
	public User getUserById(long id) {
		return this.userDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(long id) {
		this.userDAO.removeUser(id);
	}

	@Override
	@Transactional
	public User loginUser(String userId, String password) {
		if(!userId.equals(password)){
			User newUser = new User();
			newUser.setFirstName(userId);
			newUser.setPassword(password);
			return newUser;
		}
		
		return null;
	}
    
}
