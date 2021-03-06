package com.printmaster.nk.model.dao;

import java.util.List;

import com.printmaster.nk.model.entity.MailSendingMessage;

public interface MailSendingDAO {
	long save(MailSendingMessage mailMessage);
	List<MailSendingMessage> getMessagesReadySend();
	MailSendingMessage getById(long id);
	List<MailSendingMessage> getAll();
	void update(MailSendingMessage mailMessage);
	void delete(long id);
}
