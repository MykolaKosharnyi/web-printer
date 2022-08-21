package com.mykoshar.shop.api.model.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mykoshar.shop.api.model.entity.MailSendingMessage;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

import com.mykoshar.shop.api.model.dao.MailSendingDAO;

@Slf4j
public class MailSendingDAOImpl implements MailSendingDAO {
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	@Override
	public long save(MailSendingMessage mailMessage) {
		Session session = this.sessionFactory.getCurrentSession();
		mailMessage.setStatus(MailSendingMessage.StatusOfSending.WAITING);
        long id = (Long) session.save(mailMessage);
        log.info("MailSendindMessage saved successfully, details = " + mailMessage);
        return id;
	}

	@Override
	public MailSendingMessage getById(long id) {
		Session session = this.sessionFactory.getCurrentSession();      
		MailSendingMessage msm = (MailSendingMessage) session.load(MailSendingMessage.class, new Long(id));
        log.info("MailSendindMessage loaded successfully, details = " + msm);
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
        log.info("MailSendingMessage updated successfully, details = " + mailMessage);
	}

	@Override
	public void delete(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		MailSendingMessage msm = (MailSendingMessage) session.load(MailSendingMessage.class, new Long(id));
        if(null != msm){
            session.delete(msm);
        }
        log.info("MailSendingMessage deleted successfully, details = " + msm);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<MailSendingMessage> getMessagesReadySend() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(MailSendingMessage.class);
		
//		cr.add(Restrictions.eq("id", 4l));
		cr.add(Restrictions.eq("status", MailSendingMessage.StatusOfSending.WAITING));
		cr.add(Restrictions.le("dateSending", new Date()));
		cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
				
		return new ArrayList<MailSendingMessage>(cr.list());
	}

}
