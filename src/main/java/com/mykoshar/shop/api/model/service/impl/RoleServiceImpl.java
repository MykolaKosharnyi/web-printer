package com.mykoshar.shop.api.model.service.impl;

import java.util.List;

import com.mykoshar.shop.api.model.dao.RoleDAO;
import com.mykoshar.shop.api.model.service.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.Role;

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
