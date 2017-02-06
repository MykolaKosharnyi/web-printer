package com.printmaster.nk.dao;

import java.util.List;

import com.printmaster.nk.model.entity.Role;

public interface RoleDAO {
	long saveRole(Role role);
    void updateRole(Role role);
    List<Role> listRoles();
    Role getRoleById(long id);
    void removeRole(long id);
}
