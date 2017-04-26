package com.printmaster.nk.model.service;

import java.util.List;

import com.printmaster.nk.model.entity.UserProposal;

public interface UserProposalService {
	UserProposal getById(long id);
	long create(UserProposal userProposal);
	void delete(long id);
	List<UserProposal> listUserProposal();
}
