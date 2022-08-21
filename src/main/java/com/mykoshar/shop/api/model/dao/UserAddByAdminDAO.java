package com.mykoshar.shop.api.model.dao;

import java.util.List;

import com.mykoshar.shop.api.model.entity.UserAddByAdmin;

public interface UserAddByAdminDAO {
	List<UserAddByAdmin> getUserBySubscription(List<String> subscriptionTypes, List<String> scopeOfActivities);
	long save(UserAddByAdmin user);
    void updateUser(UserAddByAdmin user);
    UserAddByAdmin findByUserName(String username);
    List<UserAddByAdmin> listUsers();
    UserAddByAdmin getUserById(long id);
    void removeUser(long id);
    boolean isEmailAlreadyExist(String emailToCheck);
}
