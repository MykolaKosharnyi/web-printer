package com.printmaster.nk.model.dao;

import java.util.List;

import com.printmaster.nk.model.entity.UserProposal;

public interface UserProposalDAO {
	UserProposal getById(long id);
	long create(UserProposal userProposal);
	void delete(long id);
	List<UserProposal> listUserProposal(UserProposal.TypeProposal typeProposal);
}
