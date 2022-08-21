package com.mykoshar.shop.api.model.dao;

import java.util.List;

import com.mykoshar.shop.api.model.entity.MailSendingMessage;

public interface MailSendingDAO {
	long save(MailSendingMessage mailMessage);
	List<MailSendingMessage> getMessagesReadySend();
	MailSendingMessage getById(long id);
	List<MailSendingMessage> getAll();
	void update(MailSendingMessage mailMessage);
	void delete(long id);
}
