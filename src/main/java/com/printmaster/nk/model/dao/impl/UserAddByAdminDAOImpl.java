package com.printmaster.nk.model.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.dao.UserAddByAdminDAO;
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
	public List<UserAddByAdmin> getUserBySubscription(List<String> subscriptionTypes, List<String> scopeOfActivities) {
		Session session = this.sessionFactory.getCurrentSession();
		
		String query =	null;
		
		if(subscriptionTypes.size()>0 && scopeOfActivities.size()>0){
			query =	String.format("select distinct user from UserAddByAdmin user "+
					"inner join user.subscription subscription "+
					"inner join user.scopeOfActivities scopeOfActivities "+
					"where subscription in (%s) or scopeOfActivities in (%s)",
					listToSqlString(subscriptionTypes), listToSqlString(scopeOfActivities));
			
		} else if(subscriptionTypes.size()>0){
			query =	String.format("select distinct user from UserAddByAdmin user "+
					"inner join user.subscription subscription "+
					"where subscription in (%s) ",
					listToSqlString(subscriptionTypes));
			
		} else if(scopeOfActivities.size()>0){
			query =	String.format("select distinct user from UserAddByAdmin user "+
					"inner join user.scopeOfActivities scopeOfActivities "+
					"where scopeOfActivities in (%s)",
					listToSqlString(scopeOfActivities));
		}
		
		return session.createQuery(query).list();		
	}

	private String listToSqlString(List<String> list){
		StringBuilder sqlListBuffer = new StringBuilder();
		
		Iterator<String> iterator = new ArrayList<String>(list).iterator();
		while(iterator.hasNext()){
			sqlListBuffer.append("'")
			.append(iterator.next())
			.append("'");
			if(iterator.hasNext()){
				sqlListBuffer.append(",");
			}
		}
		return sqlListBuffer.toString();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean isEmailAlreadyExist(String emailToCheck) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(UserAddByAdmin.class);
		
		Junction emailGroup = Restrictions.disjunction();
		emailGroup.add(Restrictions.eq("email", emailToCheck));
		emailGroup.add(Restrictions.eq("email2", emailToCheck));
		emailGroup.add(Restrictions.eq("email3", emailToCheck));
		cr.add(emailGroup);

		ArrayList<UserAddByAdmin> result = new ArrayList<UserAddByAdmin>(cr.list());
		return result.size() == 0 ? true : false;
	}
}
