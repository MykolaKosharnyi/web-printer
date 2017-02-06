package com.printmaster.nk.dao;

import java.util.List;

import com.printmaster.nk.model.entity.UserAddByAdmin;

public interface UserAddByAdminDAO {
	long save(UserAddByAdmin user);
    void updateUser(UserAddByAdmin user);
    UserAddByAdmin findByUserName(String username);
    List<UserAddByAdmin> listUsers();
    UserAddByAdmin getUserById(long id);
    void removeUser(long id);
}
