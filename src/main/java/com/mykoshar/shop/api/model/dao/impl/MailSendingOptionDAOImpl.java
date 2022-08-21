package com.mykoshar.shop.api.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mykoshar.shop.api.model.entity.MailSendingMessageOption;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mykoshar.shop.api.model.dao.MailSendingOptionDAO;

public class MailSendingOptionDAOImpl implements MailSendingOptionDAO {    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@Override
	public MailSendingMessageOption getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();      
		
		Criteria cr = session.createCriteria(MailSendingMessageOption.class);	
		cr.add(Restrictions.eq("id", id));		
		return (MailSendingMessageOption) cr.uniqueResult();
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
		Criteria cr = session.createCriteria(MailSendingMessageOption.class);	
		cr.addOrder(Order.asc("optionType"));		
        return new ArrayList<MailSendingMessageOption>(cr.list());
	}

	@Override
	public void setShowing(int id, boolean showing) {
		Session session = this.sessionFactory.getCurrentSession();
		MailSendingMessageOption option = (MailSendingMessageOption) session.load(MailSendingMessageOption.class, new Integer(id));
		option.setShowOnMailLetter(showing);
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

	@Override
	public List<MailSendingMessageOption> messageOptionForHead() {
        return messageOptionTemplate(MailSendingMessageOption.OptionType.HEADER);
	}
	
	@Override
	public List<MailSendingMessageOption> messageOptionForFooter() {
		return messageOptionTemplate(MailSendingMessageOption.OptionType.FOOTER);
	}
	
	@SuppressWarnings("unchecked")
	private List<MailSendingMessageOption> messageOptionTemplate(MailSendingMessageOption.OptionType optionType){
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(MailSendingMessageOption.class);	
		cr.add(Restrictions.eq("showOnMailLetter", true));	
		cr.add(Restrictions.eq("optionType", optionType));
        return new ArrayList<MailSendingMessageOption>(cr.list());
	}

}
