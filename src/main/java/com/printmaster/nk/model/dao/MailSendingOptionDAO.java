package com.printmaster.nk.model.dao;

import java.util.List;

import com.printmaster.nk.model.entity.MailSendingMessageOption;

public interface MailSendingOptionDAO {
	int createSendingOption(MailSendingMessageOption mailSendingMessageOption);
	List<MailSendingMessageOption> allMessageOption();
	void setShowing(int id, boolean showing);
	void updateSendingOption(MailSendingMessageOption mailSendingMessageOption);
	void removeMessageOption(int id);
}
