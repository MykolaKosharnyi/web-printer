package com.mykoshar.shop.api.model.service;

import java.util.List;

import com.mykoshar.shop.api.model.entity.MailSendingMessage;

public interface MailSendingService {
	void denyMassage(long id);
	MailSendingMessage copyMassage(long id);
    long save(MailSendingMessage mailMessage);    
    List<MailSendingMessage> getMessagesReadySend();
    MailSendingMessage getById(long id);
    List<MailSendingMessage> getAll();
    void update(MailSendingMessage mailMessage);
    void delete(long id);
}
