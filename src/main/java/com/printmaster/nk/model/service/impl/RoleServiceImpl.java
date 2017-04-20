package com.printmaster.nk.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.RoleDAO;
import com.printmaster.nk.model.entity.Role;
import com.printmaster.nk.model.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	private RoleDAO roleDAO;
	
	public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }
	
	@Override
	public long save(Role role) {
		return this.roleDAO.saveRole(role);
	}

	@Override
	public void update(Role role) {
		this.roleDAO.updateRole(role);
	}

	@Override
	public List<Role> listRoles() {
		return this.roleDAO.listRoles();
	}

	@Override
	public Role getById(long id) {
		return this.roleDAO.getRoleById(id);
	}

	@Override
	public void remove(long id) {
		this.roleDAO.removeRole(id);
	}

}
