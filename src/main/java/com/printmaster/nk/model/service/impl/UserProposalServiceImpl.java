package com.printmaster.nk.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.UserProposalDAO;
import com.printmaster.nk.model.entity.UserProposal;
import com.printmaster.nk.model.service.UserProposalService;

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
