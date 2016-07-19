package com.printmaster.nk.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.printmaster.nk.model.User;

public class UserDAOImpl implements UserDAO{

	 private Logger logger = Logger.getLogger(UserDAOImpl.class);
    
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	public long save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        long id = (Long) session.save(user);
        logger.info("User saved successfully, User details: " + user);
        return id;
	}

	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User updated successfully, User details: " + user);
		
	}

	public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User").list();
        for(User user : userList){
            logger.info("User List::" + user);
        }
        return userList;
	}

	public User getUserById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        User user = (User) session.load(User.class, new Long(id));
        logger.info("User loaded successfully, User details=" + user);
        return user;
	}

	public void removeUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Long(id));
        if(null != user){
            session.delete(user);
        }
        logger.info("User deleted successfully, User details=" + user);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public User findByUsername(String username) {
		Session session = this.sessionFactory.getCurrentSession();	
		Criteria cr = session.createCriteria(User.class);
		cr.add(Restrictions.eq("username",username));
		cr.uniqueResult();
		ArrayList<User> result = new ArrayList<User>(cr.list());
		return result.get(0);
	}

}
