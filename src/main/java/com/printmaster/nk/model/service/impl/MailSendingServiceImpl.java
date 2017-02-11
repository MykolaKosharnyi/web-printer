package com.printmaster.nk.model.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.MailSendingDAO;
import com.printmaster.nk.model.entity.MailSendingMessage;
import com.printmaster.nk.model.service.MailSendingService;

public class MailSendingServiceImpl implements MailSendingService{
	private MailSendingDAO mailSendingDAO;
	
    public void setMailSendingDAO(MailSendingDAO mailSendingDAO) {
		this.mailSendingDAO = mailSendingDAO;
	}

    @Override
	@Transactional
    public long save(MailSendingMessage mailMessage){
    	return mailSendingDAO.save(mailMessage);
    }
    
    @Override
    @Transactional
    public MailSendingMessage getById(long id){
    	return mailSendingDAO.getById(id);
    }
    
    @Override
    @Transactional
    public List<MailSendingMessage> getAll(){
    	return mailSendingDAO.getAll();
    }
    
    @Override
    @Transactional
    public void update(MailSendingMessage mailMessage){
    	mailSendingDAO.update(mailMessage);
    }
    
    @Override
    @Transactional
    public void delete(long id){
    	mailSendingDAO.delete(id);
    }
}
