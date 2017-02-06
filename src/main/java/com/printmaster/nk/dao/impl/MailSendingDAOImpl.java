package com.printmaster.nk.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.printmaster.nk.dao.MailSendingDAO;
import com.printmaster.nk.model.entity.MailSendingMessage;

public class MailSendingDAOImpl implements MailSendingDAO {
	
	private Logger logger = Logger.getLogger(MailSendingDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	@Override
	public long save(MailSendingMessage mailMessage) {
		Session session = this.sessionFactory.getCurrentSession();
        long id = (Long) session.save(mailMessage);
        logger.info("MailSendindMessage saved successfully, details = " + mailMessage);
        return id;
	}

	@Override
	public MailSendingMessage getById(long id) {
		Session session = this.sessionFactory.getCurrentSession();      
		MailSendingMessage msm = (MailSendingMessage) session.load(MailSendingMessage.class, new Long(id));
        logger.info("MailSendindMessage loaded successfully, details = " + msm);
        return msm;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MailSendingMessage> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(MailSendingMessage.class);
		
		List<MailSendingMessage> result = new ArrayList<MailSendingMessage>(cr.list());
        for(MailSendingMessage p : result){
            logger.info("MailSendingMessage list::"+p);
        }
        return result;
	}

	@Override
	public void update(MailSendingMessage mailMessage) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(mailMessage);
        logger.info("MailSendingMessage updated successfully, details = " + mailMessage);
	}

	@Override
	public void delete(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		MailSendingMessage msm = (MailSendingMessage) session.load(MailSendingMessage.class, new Long(id));
        if(null != msm){
            session.delete(msm);
        }
        logger.info("MailSendingMessage deleted successfully, details = " + msm);
	}

}
