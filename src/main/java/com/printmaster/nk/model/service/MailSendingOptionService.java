package com.printmaster.nk.model.service;

import java.util.List;

import com.printmaster.nk.model.entity.MailSendingMessageOption;

public interface MailSendingOptionService {
	void createSendingOption(MailSendingMessageOption mailSendingMessageOption);
	List<MailSendingMessageOption> allMessageOption();
	void setShowing(int id, boolean showing);
	void updateSendingOption(MailSendingMessageOption mailSendingMessageOption);
	void removeMessageOption(int id);
}
