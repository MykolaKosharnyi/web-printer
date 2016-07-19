package com.printmaster.nk.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.printmaster.nk.model.Role;

public class RoleDAOImpl implements RoleDAO{

private Logger logger = Logger.getLogger(RoleDAOImpl.class);
    
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@Override
	public long saveRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
        long id = (Long) session.save(role);
        logger.info("Role saved successfully, Role details: " + role);
        return id;
	}

	@Override
	public void updateRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
        logger.info("Role updated successfully, Role details: " + role);
	}

	@Override
	public List<Role> listRoles() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Role> roleList = session.createQuery("from Role").list();
        for(Role role : roleList){
            logger.info("Role List::" + role);
        }
        return roleList;
	}

	@Override
	public Role getRoleById(long id) {
		Session session = this.sessionFactory.getCurrentSession();      
        Role role = (Role) session.load(Role.class, new Long(id));
        logger.info("Role loaded successfully, Role details=" + role);
        return role;
	}

	@Override
	public void removeRole(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role role = (Role) session.load(Role.class, new Long(id));
        if(null != role){
            session.delete(role);
        }
        logger.info("Role deleted successfully, Role details=" + role);	
	}

}
