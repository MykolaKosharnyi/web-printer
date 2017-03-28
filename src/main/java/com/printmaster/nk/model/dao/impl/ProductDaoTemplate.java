package com.printmaster.nk.model.dao.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.printmaster.nk.model.dao.ProductDAO;

public abstract class ProductDaoTemplate<T, SC> implements ProductDAO<T, SC>{
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
	
}
