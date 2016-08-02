package com.printmaster.nk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.UserDAO;
import com.printmaster.nk.model.Role;
import com.printmaster.nk.model.User;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;
    
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Autowired
    private RoleService roleService;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	@Transactional
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Role role = roleService.getById(1);
        user.setRole(role);
        userDAO.save(user);
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
	public User findByUserName(String username) {
		return this.userDAO.findByUserName(username);
	}
    
}
