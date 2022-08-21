package com.mykoshar.shop.api.model.dao;

import java.util.List;

import com.mykoshar.shop.api.model.entity.MailSendingMessageOption;

public interface MailSendingOptionDAO {
	int createSendingOption(MailSendingMessageOption mailSendingMessageOption);
	MailSendingMessageOption getById(int id);
	List<MailSendingMessageOption> allMessageOption();
	void setShowing(int id, boolean showing);
	void updateSendingOption(MailSendingMessageOption mailSendingMessageOption);
	void removeMessageOption(int id);
	List<MailSendingMessageOption> messageOptionForHead();
	List<MailSendingMessageOption> messageOptionForFooter();
}
