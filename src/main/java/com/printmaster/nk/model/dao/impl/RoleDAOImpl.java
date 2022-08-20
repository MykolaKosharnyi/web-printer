package com.printmaster.nk.model.dao.impl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.printmaster.nk.model.dao.RoleDAO;
import com.printmaster.nk.model.entity.Role;

@Slf4j
public class RoleDAOImpl implements RoleDAO {
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	@Override
	public long saveRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
        long id = (Long) session.save(role);
        log.info("Role saved successfully, Role details: " + role);
        return id;
	}

	@Override
	public void updateRole(Role role) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(role);
        log.info("Role updated successfully, Role details: " + role);
	}

	@Override
	public List<Role> listRoles() {
		Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
		List<Role> roleList = session.createQuery("from Role").list();
        for(Role role : roleList){
            log.info("Role List::" + role);
        }
        return roleList;
	}

	@Override
	public Role getRoleById(long id) {
		Session session = this.sessionFactory.getCurrentSession();      
        Role role = (Role) session.load(Role.class, new Long(id));
        log.info("Role loaded successfully, Role details=" + role);
        return role;
	}

	@Override
	public void removeRole(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Role role = (Role) session.load(Role.class, new Long(id));
        if(null != role){
            session.delete(role);
        }
        log.info("Role deleted successfully, Role details=" + role);
	}

}
