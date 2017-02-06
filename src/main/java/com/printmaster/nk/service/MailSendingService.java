package com.printmaster.nk.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.MailSendingDAO;
import com.printmaster.nk.model.entity.MailSendingMessage;

public class MailSendingService {
	private MailSendingDAO mailSendingDAO;
	
    public void setMailSendingDAO(MailSendingDAO mailSendingDAO) {
		this.mailSendingDAO = mailSendingDAO;
	}

	@Transactional
    public long save(MailSendingMessage mailMessage){
    	return mailSendingDAO.save(mailMessage);
    }
    
    @Transactional
    public MailSendingMessage getById(long id){
    	return mailSendingDAO.getById(id);
    }
    
    @Transactional
    public List<MailSendingMessage> getAll(){
    	return mailSendingDAO.getAll();
    }
    
    @Transactional
    public void update(MailSendingMessage mailMessage){
    	mailSendingDAO.update(mailMessage);
    }
    
    @Transactional
    public void delete(long id){
    	mailSendingDAO.delete(id);
    }
}
