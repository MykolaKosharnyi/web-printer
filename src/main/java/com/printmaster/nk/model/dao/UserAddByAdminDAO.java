package com.printmaster.nk.model.dao;

import java.util.List;

import com.printmaster.nk.model.entity.UserAddByAdmin;

public interface UserAddByAdminDAO {
	List<UserAddByAdmin> getUserBySubscription(String[] subscriptionTypes);
	long save(UserAddByAdmin user);
    void updateUser(UserAddByAdmin user);
    UserAddByAdmin findByUserName(String username);
    List<UserAddByAdmin> listUsers();
    UserAddByAdmin getUserById(long id);
    void removeUser(long id);
}
