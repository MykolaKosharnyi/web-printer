package com.printmaster.nk.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.printmaster.nk.model.User;

public class UserDAOImpl implements UserDAO{

	 private Logger logger = Logger.getLogger(UserDAOImpl.class);
    
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	public void save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(user);
        logger.info("User saved successfully, User details: " + user);

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

//	@Override
//	public User findByUsername(String username) {
//		User result = null;
//		Iterator<User> iterator = listUsers().iterator();
//		
//		while(iterator.hasNext()){
//			User current = iterator.next();
//			if(current.getUsername().equals(username)){
//				result = current;
//				break;
//			}
//		}
//		
//		return result;
//	}
	
	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();

		users = sessionFactory.getCurrentSession()
			.createQuery("from User where username=?")
			.setParameter(0, username)
			.list();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}

	}

}
