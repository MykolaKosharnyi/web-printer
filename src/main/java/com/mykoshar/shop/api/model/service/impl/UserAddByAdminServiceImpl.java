package com.mykoshar.shop.api.model.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mykoshar.shop.api.model.dao.UserAddByAdminDAO;
import com.mykoshar.shop.api.model.entity.UserAddByAdmin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.service.UserAddByAdminService;

@Service
@Transactional
public class UserAddByAdminServiceImpl implements UserAddByAdminService {

    private UserAddByAdminDAO userAddByAdminDAO;

	public void setUserAddByAdminDAO(UserAddByAdminDAO userAddByAdminDAO) {
		this.userAddByAdminDAO = userAddByAdminDAO;
	}

	@Override
	public long save(UserAddByAdmin user) {
       return userAddByAdminDAO.save(user);
	}

	@Override
	public void updateUser(UserAddByAdmin user) {
		this.userAddByAdminDAO.updateUser(user);
	}

	@Override
	public List<UserAddByAdmin> listUsers() {
		return this.userAddByAdminDAO.listUsers();
	}

	@Override
	public UserAddByAdmin getUserById(long id) {
		return this.userAddByAdminDAO.getUserById(id);
	}

	@Override
	public void removeUser(long id) {
		this.userAddByAdminDAO.removeUser(id);
	}

	@Override
	public UserAddByAdmin findByUserName(String username) {
		return this.userAddByAdminDAO.findByUserName(username);
	}

	@Override
	public List<UserAddByAdmin> getUserBySubscription(List<String> subscriptionTypes, List<String> scopeOfActivities) {
		return this.userAddByAdminDAO.getUserBySubscription(subscriptionTypes, scopeOfActivities);
	}

	@Override
	public boolean isEmailAlreadyExist(String emailToCheck) {
		return isEmailCorrect(emailToCheck) && userAddByAdminDAO.isEmailAlreadyExist(emailToCheck);
	}
	
	private static final String EMAIL_PATTERN =
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	/**
	 * Validate email with regular expression
	 *
	 * @param email for validation
	 * @return true valid email, false invalid email
	 */
	private boolean isEmailCorrect(String email){
		String result = email.trim();
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(result);
		return matcher.matches();
	}
	
}
