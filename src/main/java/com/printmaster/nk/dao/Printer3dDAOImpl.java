package com.printmaster.nk.dao;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.SearchPrinters3D;

@Repository
public class Printer3dDAOImpl implements ProductDAO<Printer3D, SearchPrinters3D> {
     
    private static final Logger logger = LoggerFactory.getLogger(Printer3dDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public long addProduct(Printer3D p) {
        Session session = this.sessionFactory.getCurrentSession();
       long id = (Long) session.save(p);
        logger.info("Printer3D saved successfully, Printer Details="+p);
        return id;
    }
 
    @Override
    public void updateProduct(Printer3D p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Printer3D updated successfully, Printer Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Printer3D> listProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Printer3D> printerList = session.createQuery("from Printer3D").list();
        for(Printer3D p : printerList){
            logger.info("Printer3D List::"+p);
        }
        return printerList;
    }
 
    @Override
    public Printer3D getProductById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Printer3D p = (Printer3D) session.load(Printer3D.class, new Long(id));
        logger.info("Printer3D loaded successfully, Printer3D details="+p);
        return p;
    }
 
    @Override
    public void removeProduct(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Printer3D p = (Printer3D) session.load(Printer3D.class, new Long(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Printer3D deleted successfully, printer_3d details="+p);
    }

	@SuppressWarnings("unchecked")
	@Override
	public Set<Printer3D> listSearchProducts(SearchPrinters3D searchPrinters) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Printer3D.class);
		
		LinkedHashSet<Printer3D> result = new LinkedHashSet<Printer3D>(cr.list());
		
        return result;
	}
 
}

