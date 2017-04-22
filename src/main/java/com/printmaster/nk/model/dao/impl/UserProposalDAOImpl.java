package com.printmaster.nk.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.dao.UserProposalDAO;
import com.printmaster.nk.model.entity.UserProposal;
import com.printmaster.nk.model.entity.UserProposal.TypeProposal;

@Repository
public class UserProposalDAOImpl implements UserProposalDAO{

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@Override
	public UserProposal getById(long id) {
		Session session = this.sessionFactory.getCurrentSession();      
        return (UserProposal) session.load(UserProposal.class, new Long(id));
	}

	@Override
	public long create(UserProposal userProposal) {
		Session session = this.sessionFactory.getCurrentSession();
        return (Long) session.save(userProposal);
	}

	@Override
	public void delete(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserProposal userProposal = (UserProposal) session.load(UserProposal.class, new Long(id));
        if(null != userProposal){
            session.delete(userProposal);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserProposal> listUserProposal(TypeProposal typeProposal) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UserProposal.class);	
		cr.add(Restrictions.eq("typeProposal", typeProposal));				
		return new ArrayList<UserProposal>(cr.list());
	}

}
