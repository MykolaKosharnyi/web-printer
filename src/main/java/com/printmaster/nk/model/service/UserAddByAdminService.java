package com.printmaster.nk.model.service;

import java.util.List;

import com.printmaster.nk.model.entity.UserAddByAdmin;

public interface UserAddByAdminService {
	List<UserAddByAdmin> getUserBySubscription(List<String> subscriptionTypes);
	long save(UserAddByAdmin user);
    void updateUser(UserAddByAdmin user);
    UserAddByAdmin findByUserName(String username);
    List<UserAddByAdmin> listUsers();
    UserAddByAdmin getUserById(long id);
    void removeUser(long id);
}
