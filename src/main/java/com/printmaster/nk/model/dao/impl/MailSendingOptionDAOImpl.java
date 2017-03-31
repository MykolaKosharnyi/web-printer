package com.printmaster.nk.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.printmaster.nk.model.dao.MailSendingOptionDAO;
import com.printmaster.nk.model.entity.MailSendingMessageOption;

public class MailSendingOptionDAOImpl implements MailSendingOptionDAO {    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@Override
	public int createSendingOption(MailSendingMessageOption mailSendingMessageOption) {
		Session session = this.sessionFactory.getCurrentSession();
        int id = (Integer) session.save(mailSendingMessageOption);
        return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MailSendingMessageOption> allMessageOption() {
		Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from MailSendingMessageOption").list();
	}

	@Override
	public void setShowing(int id, boolean showing) {
		Session session = this.sessionFactory.getCurrentSession();
		MailSendingMessageOption option = (MailSendingMessageOption) session.load(MailSendingMessageOption.class, new Integer(id));
		option.setShowOnSite(showing);
		session.update(option);
	}

	@Override
	public void updateSendingOption(MailSendingMessageOption mailSendingMessageOption) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(mailSendingMessageOption);
	}

	@Override
	public void removeMessageOption(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		MailSendingMessageOption option = (MailSendingMessageOption) session.load(MailSendingMessageOption.class, new Integer(id));
        if(null != option){
            session.delete(option);
        }
	}

}
