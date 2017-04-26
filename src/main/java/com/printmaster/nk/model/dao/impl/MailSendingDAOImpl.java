package com.printmaster.nk.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.printmaster.nk.model.dao.MailSendingDAO;
import com.printmaster.nk.model.entity.MailSendingMessage;
import com.printmaster.nk.model.entity.MailSendingMessage.StatusOfSending;

public class MailSendingDAOImpl implements MailSendingDAO {
	
	private Logger logger = Logger.getLogger(MailSendingDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	@Override
	public long save(MailSendingMessage mailMessage) {
		Session session = this.sessionFactory.getCurrentSession();
		mailMessage.setStatus(StatusOfSending.WAITING);
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

		cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
        return new ArrayList<MailSendingMessage>(cr.list());
	}

	@Override
	public void update(MailSendingMessage mailMessage) {
		Session session = this.sessionFactory.getCurrentSession();
		mailMessage.setDateLastChanging(new Date());
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


	@SuppressWarnings("unchecked")
	@Override
	public List<MailSendingMessage> getMessagesReadySend() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(MailSendingMessage.class);
		
//		cr.add(Restrictions.eq("id", 4l));
		cr.add(Restrictions.eq("status", StatusOfSending.WAITING));
		cr.add(Restrictions.le("dateSending", new Date()));
		cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
				
		return new ArrayList<MailSendingMessage>(cr.list());
	}

}
