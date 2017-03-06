package com.printmaster.nk.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.dao.CommentDAO;
import com.printmaster.nk.model.entity.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO{
	
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	@Override
	public long add(Comment comment) {
		Session session = this.sessionFactory.getCurrentSession();
         return (Long) session.save(comment);    
	}

	@Override
	public void edit(Comment comment) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(comment);
	}

	@Override
	public void delete(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Comment comment = (Comment) session.load(Comment.class, new Long(id));
        if(null != comment){
            session.delete(comment);
        }
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllComments() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Comment.class);
        return cr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllForProduct(String type, long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Comment.class);
		cr.add(Restrictions.eq("productType", type));
		cr.add(Restrictions.eq("productId", id));
		return cr.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAllForUser(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Comment.class);
		cr.add(Restrictions.eq("userId", id));
		return cr.list();
	}

	@Override
	public Comment findById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Comment.class);
		cr.add(Restrictions.eq("id", id));
		return (Comment) cr.uniqueResult();
	}

}
