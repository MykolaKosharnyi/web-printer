package com.printmaster.nk.model.service;

import java.util.List;

import com.printmaster.nk.model.entity.MailSendingMessage;

public interface MailSendingService {
    long save(MailSendingMessage mailMessage);    
    MailSendingMessage getById(long id);
    List<MailSendingMessage> getAll();
    void update(MailSendingMessage mailMessage);
    void delete(long id);
}
