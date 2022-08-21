package com.mykoshar.shop.api.model.service;

import java.util.List;

import com.mykoshar.shop.api.model.entity.Role;

public interface RoleService {
	public long save(Role role);
    public void update(Role role);
    public List<Role> listRoles();
    public Role getById(long id);
    public void remove(long id);
}
