package com.mykoshar.shop.api.model.dao;

import java.util.List;

import com.mykoshar.shop.api.model.entity.Role;

public interface RoleDAO {
	long saveRole(Role role);
    void updateRole(Role role);
    List<Role> listRoles();
    Role getRoleById(long id);
    void removeRole(long id);
}
