package com.mykoshar.shop.api.model.service.impl;

import java.util.Date;
import java.util.List;

import com.mykoshar.shop.api.model.dao.MailSendingOptionDAO;
import com.mykoshar.shop.api.model.entity.MailSendingMessageOption;
import com.mykoshar.shop.api.model.service.MailSendingOptionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MailSendingOptionServiceImpl implements MailSendingOptionService {

	private MailSendingOptionDAO mailSendingOptionDAO;

	@Override
	public MailSendingMessageOption getById(int id) {
		return mailSendingOptionDAO.getById(id);
	}
	
	public void setMailSendingOptionDAO(MailSendingOptionDAO mailSendingOptionDAO) {
		this.mailSendingOptionDAO = mailSendingOptionDAO;
	}

	@Override
	public void createSendingOption(MailSendingMessageOption mailSendingMessageOption) {
		mailSendingMessageOption.setDateLastChanging(new Date());
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

	@Override
	public List<MailSendingMessageOption> messageOptionForHead() {
		return mailSendingOptionDAO.messageOptionForHead();
	}

	@Override
	public List<MailSendingMessageOption> messageOptionForFooter() {
		return mailSendingOptionDAO.messageOptionForFooter();
	}

}
