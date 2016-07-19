package com.printmaster.nk.dao;

import java.util.List;

import com.printmaster.nk.model.Role;

public interface RoleDAO {
	public long saveRole(Role role);
    public void updateRole(Role role);
    public List<Role> listRoles();
    public Role getRoleById(long id);
    public void removeRole(long id);
}
