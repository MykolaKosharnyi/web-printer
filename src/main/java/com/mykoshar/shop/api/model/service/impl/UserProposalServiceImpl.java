package com.mykoshar.shop.api.model.service.impl;

import java.util.Date;
import java.util.List;

import com.mykoshar.shop.api.model.dao.UserProposalDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.UserProposal;
import com.mykoshar.shop.api.model.service.UserProposalService;

@Service
@Transactional
public class UserProposalServiceImpl implements UserProposalService {

	private UserProposalDAO userProposalDAO;
	
	public void setUserProposalDAO(UserProposalDAO userProposalDAO) {
		this.userProposalDAO = userProposalDAO;
	}

	@Override
	public UserProposal getById(long id) {
		return userProposalDAO.getById(id);
	}

	@Override
	public long create(UserProposal userProposal) {
		userProposal.setDateCreation(new Date());
		return userProposalDAO.create(userProposal);
	}

	@Override
	public void delete(long id) {
		userProposalDAO.delete(id);
	}

	@Override
	public List<UserProposal> listUserProposal() {
		return userProposalDAO.listUserProposal();
	}

}
