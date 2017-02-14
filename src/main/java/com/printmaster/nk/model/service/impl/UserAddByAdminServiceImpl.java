package com.printmaster.nk.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.UserAddByAdminDAO;
import com.printmaster.nk.model.entity.UserAddByAdmin;
import com.printmaster.nk.model.service.UserAddByAdminService;

@Service
@Transactional
public class UserAddByAdminServiceImpl implements UserAddByAdminService {

    private UserAddByAdminDAO userAddByAdminDAO;

	public void setUserAddByAdminDAO(UserAddByAdminDAO userAddByAdminDAO) {
		this.userAddByAdminDAO = userAddByAdminDAO;
	}

	@Override
	@Transactional
	public long save(UserAddByAdmin user) {
       return userAddByAdminDAO.save(user);
	}

	@Override
	@Transactional
	public void updateUser(UserAddByAdmin user) {
		this.userAddByAdminDAO.updateUser(user);
	}

	@Override
	@Transactional
	public List<UserAddByAdmin> listUsers() {
		return this.userAddByAdminDAO.listUsers();
	}

	@Override
	@Transactional
	public UserAddByAdmin getUserById(long id) {
		return this.userAddByAdminDAO.getUserById(id);
	}

	@Override
	@Transactional
	public void removeUser(long id) {
		this.userAddByAdminDAO.removeUser(id);
	}

	@Override
	@Transactional
	public UserAddByAdmin findByUserName(String username) {
		return this.userAddByAdminDAO.findByUserName(username);
	}

	@Override
	public List<UserAddByAdmin> getUserBySubscription(String[] subscriptionTypes) {
		return this.userAddByAdminDAO.getUserBySubscription(subscriptionTypes);
	}
}
