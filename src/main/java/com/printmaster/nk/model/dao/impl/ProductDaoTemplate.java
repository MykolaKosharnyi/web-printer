package com.printmaster.nk.model.dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.printmaster.nk.model.dao.ProductDAO;
import com.printmaster.nk.model.entity.Product;

public abstract class ProductDaoTemplate<T extends Product, SC> implements ProductDAO<T, SC>{
	private Class<T> productType;
	
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
    
    public ProductDaoTemplate(Class<T> cls){
    	this.productType = cls;
    }

    @Override
    public long addProduct(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        long id = (Long) session.save(t);
        return id;
    }
 
    @Override
    public void updateProduct(T t) {
        Session session = this.sessionFactory.getCurrentSession();
        t.setDateLastChanging(new Date());
        session.update(t);
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public T getProductById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        T t = (T) session.load(productType, new Long(id));
        return t;
    }
 
    @SuppressWarnings("unchecked")
	@Override
    public void removeProduct(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        T t = (T) session.load(productType, new Long(id));
        if(null != t){
            session.delete(t);
        }
    }
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public Set<T> listProducts(String sortCriteria) {
        Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(productType);
		
		if("id".equals(sortCriteria) || "prise".equals(sortCriteria) || "top".equals(sortCriteria)){		
			cr.addOrder(Order.desc(sortCriteria));
		} else {
			cr.addOrder(Order.asc(sortCriteria));
		}
		
		Set<T> productList = new LinkedHashSet(cr.list());
        return productList;
    }
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<T> listShowOnSite() {
		Session session = getSessionFactory().getCurrentSession();
		Criteria cr = session.createCriteria(productType);
		cr.add(Restrictions.eq("showOnSite", true)); 
        return new HashSet<T>(cr.list());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<T> listShowOnHomePage() {
		Session session = getSessionFactory().getCurrentSession();
		Criteria cr = session.createCriteria(productType);
		cr.add(Restrictions.eq("showOnSite", true));
		cr.add(Restrictions.eq("showOnHomePage", true));
        return new HashSet<T>(cr.list());
	}
	
}
