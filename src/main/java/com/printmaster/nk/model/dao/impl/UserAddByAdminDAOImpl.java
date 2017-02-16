package com.printmaster.nk.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.dao.UserAddByAdminDAO;
import com.printmaster.nk.model.entity.MailSendingMessage;
import com.printmaster.nk.model.entity.UserAddByAdmin;

@Repository
public class UserAddByAdminDAOImpl implements UserAddByAdminDAO{

	private Logger logger = Logger.getLogger(UserAddByAdminDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public long save(UserAddByAdmin user) {
		Session session = this.sessionFactory.getCurrentSession();
		long id = (Long) session.save(user);
		logger.info("UserAddByAdmin saved successfully, UserAddByAdmin details: " + user);
		return id;
	}

	@Override
	public void updateUser(UserAddByAdmin user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("UserAddByAdmin updated successfully, UserAddByAdmin details: " + user);

	}

	@Override
	public List<UserAddByAdmin> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<UserAddByAdmin> userList = session.createQuery("from UserAddByAdmin").list();
		return userList;
	}

	@Override
	public UserAddByAdmin getUserById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserAddByAdmin user = (UserAddByAdmin) session.load(UserAddByAdmin.class, new Long(id));
		logger.info("UserAddByAdmin loaded successfully, UserAddByAdmin details=" + user);
		return user;
	}

	@Override
	public void removeUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		UserAddByAdmin user = (UserAddByAdmin) session.load(UserAddByAdmin.class, new Long(id));
		if (null != user) {
			session.delete(user);
		}
		logger.info("UserAddByAdmin deleted successfully, UserAddByAdmin details=" + user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public UserAddByAdmin findByUserName(String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UserAddByAdmin.class);

		cr.add(Restrictions.eq("username", username));

		ArrayList<UserAddByAdmin> result = new ArrayList<UserAddByAdmin>(cr.list());

		if (result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserAddByAdmin> getUserBySubscription(String[] subscriptionTypes) {
		Session session = this.sessionFactory.getCurrentSession();
//		Criteria cr = session.createCriteria(UserAddByAdmin.class, "user");
//		cr.createAlias("user.subscription", "subscription");
//		
//		if(subscriptionTypes!= null){
//			Junction subscriptionGroup = Restrictions.disjunction();
//			for(String subscription : subscriptionTypes){
//				subscriptionGroup.add(Restrictions.eq("subscription",subscription));
//			}
//			cr.add(subscriptionGroup);
//		}
//		
//		cr.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
		
//		
//		Criteria c = session.createCriteria(Owner.class, "owner");
//		c.createAlias("owner.cats", "cat");
//		c.add(Restrictions.eq("cat.eyeColor", "blue");
//		c.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		
		return session.createQuery("from UserAddByAdmin").list();		
	}
}
