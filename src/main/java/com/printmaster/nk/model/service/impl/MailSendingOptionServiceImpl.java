package com.printmaster.nk.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.MailSendingOptionDAO;
import com.printmaster.nk.model.entity.MailSendingMessageOption;
import com.printmaster.nk.model.service.MailSendingOptionService;

@Transactional
public class MailSendingOptionServiceImpl implements MailSendingOptionService {

	private MailSendingOptionDAO mailSendingOptionDAO;
	
	@Override
	public void createSendingOption(MailSendingMessageOption mailSendingMessageOption) {
		mailSendingOptionDAO.createSendingOption(mailSendingMessageOption);
	}

	@Override
	public List<MailSendingMessageOption> allMessageOption() {
		return mailSendingOptionDAO.allMessageOption();
	}

	@Override
	public void setShowing(int id, boolean showing) {
		mailSendingOptionDAO.setShowing(id, showing);
	}

	@Override
	public void updateSendingOption(MailSendingMessageOption mailSendingMessageOption) {
		mailSendingMessageOption.setDateLastChanging(new Date());
		mailSendingOptionDAO.updateSendingOption(mailSendingMessageOption);
	}

	@Override
	public void removeMessageOption(int id) {
		mailSendingOptionDAO.removeMessageOption(id);
	}

}
