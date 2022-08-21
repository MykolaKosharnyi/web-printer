package com.mykoshar.shop.api.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mykoshar.shop.api.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mykoshar.shop.api.model.dao.UserDAO;

@Slf4j
@Repository
public class UserDAOImpl implements UserDAO{
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
    @Override
	public long save(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        long id = (Long) session.save(user);
        log.info("User saved successfully, User details: " + user);
        return id;
	}
    
    @Override
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        log.info("User updated successfully, User details: " + user);
		
	}

    @Override
	public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<User> userList = session.createQuery("from User").list();
        for(User user : userList){
            log.info("User List::" + user);
        }
        return userList;
	}

    @Override
	public User getUserById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        User user = (User) session.load(User.class, new Long(id));
        log.info("User loaded successfully, User details=" + user);
        return user;
	}

    @Override
	public void removeUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Long(id));
        if(null != user){
            session.delete(user);
        }
        log.info("User deleted successfully, User details=" + user);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public User findByEmail(String email) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(User.class);
		
		cr.add(Restrictions.eq("email", email));
		
		ArrayList<User> result = new ArrayList<User>(cr.list());
		
		if(result.size()>0){
			return result.get(0);
		} else {
			return null;
		}
		
	/*	
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
*/
	}

}
