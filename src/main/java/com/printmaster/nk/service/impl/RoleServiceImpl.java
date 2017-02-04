package com.printmaster.nk.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.RoleDAO;
import com.printmaster.nk.model.Role;
import com.printmaster.nk.service.RoleService;

public class RoleServiceImpl implements RoleService {
	private RoleDAO roleDAO;
	
	public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
	
	@Override
	@Transactional
	public long save(Role role) {
		return this.roleDAO.saveRole(role);
	}

	@Override
	@Transactional
	public void update(Role role) {
		this.roleDAO.updateRole(role);
	}

	@Override
	@Transactional
	public List<Role> listRoles() {
		return this.roleDAO.listRoles();
	}

	@Override
	@Transactional
	public Role getById(long id) {
		return this.roleDAO.getRoleById(id);
	}

	@Override
	@Transactional
	public void remove(long id) {
		this.roleDAO.removeRole(id);
	}

}
