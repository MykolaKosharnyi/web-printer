package com.mykoshar.shop.api.model.service;

import java.util.List;

import com.mykoshar.shop.api.model.entity.UserProposal;

public interface UserProposalService {
	UserProposal getById(long id);
	long create(UserProposal userProposal);
	void delete(long id);
	List<UserProposal> listUserProposal();
}
