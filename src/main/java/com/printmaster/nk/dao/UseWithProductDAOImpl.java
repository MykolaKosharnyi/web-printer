package com.printmaster.nk.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.UseWithProduct;
import com.printmaster.nk.modelwork.SearchUseWithProducts;
import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.Scanner;

@Repository
public class UseWithProductDAOImpl  implements UseWithProductDAO{

	 private Logger logger = Logger.getLogger(UseWithProductDAOImpl.class);
	 
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 
	    @Override
	    public long addProduct(UseWithProduct c) {
	        Session session = this.sessionFactory.getCurrentSession();
	        long id = (Long) session.save(c);
	        logger.info("UseWithProduct saved successfully, UseWithProduct details=" + c);
	        return id;
	    }
	 
	    @Override
	    public void updateProduct(UseWithProduct c) {
	        Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        logger.info("UseWithProduct updated successfully, UseWithProduct Details=" + c);
	    }
	 
	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    @Override
	    public Set<UseWithProduct> listProducts(String sortCriteria) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Criteria cr = session.createCriteria(UseWithProduct.class);
			cr.addOrder( Order.desc(sortCriteria));
			Set<UseWithProduct> useWithProductList = new LinkedHashSet(cr.list());
	        for(UseWithProduct c : useWithProductList){
	            logger.info("UseWithProduct List::" + c);
	        }
	        return useWithProductList;
	    }
	 
	    @Override
	    public UseWithProduct getProductById(long id) {
	        Session session = this.sessionFactory.getCurrentSession();      
	        UseWithProduct c = (UseWithProduct) session.load(UseWithProduct.class, new Long(id));
	        logger.info("UseWithProduct loaded successfully, UseWithProduct details=" + c);
	        return c;
	    }
	 
	    @SuppressWarnings("unchecked")
		@Override
	    public void removeProduct(long id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        UseWithProduct c = (UseWithProduct) session.load(UseWithProduct.class, new Long(id));
	        if(null != c){
	            session.delete(c);
	        }
	        
	        //check PRINTETS
	        Criteria cr = session.createCriteria(Printer.class);
	        Set<Printer> result = new HashSet<Printer>(cr.list());
	        for(Printer product : result){
	        	p1:
	        	for(long i : product.getIdUseWithProduct()){
	        		if(i==id){
	        			long[] outputInt = new long[product.getIdUseWithProduct().length-1];

	        			int index = 0;
	        			for(long k : product.getIdUseWithProduct()){
	        				if(k!=i){
	        					outputInt[index]=k;
	        					index++;
	        				}
	        			}
	        			product.setIdUseWithProduct(outputInt);
	        			session.update(product);
	        			break p1;
	        		}
	        			
	        	}
	        }
	        
	      //check 3D PRINTETS
	        cr = session.createCriteria(Printer3D.class);
	        Set<Printer3D> result3d = new HashSet<Printer3D>(cr.list());
	        for(Printer3D product : result3d){
	        	p1:
	        	for(long i : product.getIdUseWithProduct()){
	        		if(i==id){
	        			long[] outputInt = new long[product.getIdUseWithProduct().length-1];

	        			int index = 0;
	        			for(long k : product.getIdUseWithProduct()){
	        				if(k!=i){
	        					outputInt[index]=k;
	        					index++;
	        				}
	        			}
	        			product.setIdUseWithProduct(outputInt);
	        			session.update(product);
	        			break p1;
	        		}
	        			
	        	}
	        }
	        
	      //check DIGITAL PRINTETS
	        cr = session.createCriteria(DigitalPrinter.class);
	        Set<DigitalPrinter> resultDP = new HashSet<DigitalPrinter>(cr.list());
	        for(DigitalPrinter product : resultDP){
	        	p1:
	        	for(long i : product.getIdUseWithProduct()){
	        		if(i==id){
	        			long[] outputInt = new long[product.getIdUseWithProduct().length-1];

	        			int index = 0;
	        			for(long k : product.getIdUseWithProduct()){
	        				if(k!=i){
	        					outputInt[index]=k;
	        					index++;
	        				}
	        			}
	        			product.setIdUseWithProduct(outputInt);
	        			session.update(product);
	        			break p1;
	        		}
	        			
	        	}
	        }
	        
	      //check LASERS
	        cr = session.createCriteria(Laser.class);
	        Set<Laser> resultLaser = new HashSet<Laser>(cr.list());
	        for(Laser product : resultLaser){
	        	p1:
	        	for(long i : product.getIdUseWithProduct()){
	        		if(i==id){
	        			long[] outputInt = new long[product.getIdUseWithProduct().length-1];

	        			int index = 0;
	        			for(long k : product.getIdUseWithProduct()){
	        				if(k!=i){
	        					outputInt[index]=k;
	        					index++;
	        				}
	        			}
	        			product.setIdUseWithProduct(outputInt);
	        			session.update(product);
	        			break p1;
	        		}
	        			
	        	}
	        }
	        
	      //check LAMINATORS
	        cr = session.createCriteria(Laminator.class);
	        Set<Laminator> resultLaminator = new HashSet<Laminator>(cr.list());
	        for(Laminator product : resultLaminator){
	        	p1:
	        	for(long i : product.getIdUseWithProduct()){
	        		if(i==id){
	        			long[] outputInt = new long[product.getIdUseWithProduct().length-1];

	        			int index = 0;
	        			for(long k : product.getIdUseWithProduct()){
	        				if(k!=i){
	        					outputInt[index]=k;
	        					index++;
	        				}
	        			}
	        			product.setIdUseWithProduct(outputInt);
	        			session.update(product);
	        			break p1;
	        		}
	        			
	        	}
	        }
	        
	      //check CUTTERS
	        cr = session.createCriteria(Cutter.class);
	        Set<Cutter> resultCutter = new HashSet<Cutter>(cr.list());
	        for(Cutter product : resultCutter){
	        	p1:
	        	for(long i : product.getIdUseWithProduct()){
	        		if(i==id){
	        			long[] outputInt = new long[product.getIdUseWithProduct().length-1];

	        			int index = 0;
	        			for(long k : product.getIdUseWithProduct()){
	        				if(k!=i){
	        					outputInt[index]=k;
	        					index++;
	        				}
	        			}
	        			product.setIdUseWithProduct(outputInt);
	        			session.update(product);
	        			break p1;
	        		}
	        			
	        	}
	        }
	        
	      //check SCANNERS
	        cr = session.createCriteria(Scanner.class);
	        Set<Scanner> resultScanner = new HashSet<Scanner>(cr.list());
	        for(Scanner product : resultScanner){
	        	p1:
	        	for(long i : product.getIdUseWithProduct()){
	        		if(i==id){
	        			long[] outputInt = new long[product.getIdUseWithProduct().length-1];

	        			int index = 0;
	        			for(long k : product.getIdUseWithProduct()){
	        				if(k!=i){
	        					outputInt[index]=k;
	        					index++;
	        				}
	        			}
	        			product.setIdUseWithProduct(outputInt);
	        			session.update(product);
	        			break p1;
	        		}
	        			
	        	}
	        }
	        
	        
	        logger.info("UseWithProduct deleted successfully, UseWithProduct details=" + c);
	    }

		@SuppressWarnings("unchecked")
		@Override
		public Set<UseWithProduct> listSearchProducts(SearchUseWithProducts searchUsedWithProduct) {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(UseWithProduct.class);
			
			if(searchUsedWithProduct.getPrise0()!=searchUsedWithProduct.getPrise1()){
				cr.add(Restrictions.between("prise", searchUsedWithProduct.getPrise0(), searchUsedWithProduct.getPrise1()));
			}
			
			if(searchUsedWithProduct.getTypeProduct()!= null){
			Junction typeGroup = Restrictions.disjunction();
			for(String typeProduct : searchUsedWithProduct.getTypeProduct()){
				typeGroup.add(Restrictions.eq("typeProduct",typeProduct));
			}
			cr.add(typeGroup);
			}
			
			cr.add(Restrictions.eq("showOnSite", true));
			
			Set<UseWithProduct> result = new LinkedHashSet<UseWithProduct>(cr.list());
			
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<UseWithProduct> listShowOnSite() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(UseWithProduct.class);
			cr.add(Restrictions.eq("showOnSite", true));
			
			Set<UseWithProduct> result = new LinkedHashSet<UseWithProduct>(cr.list());
	        for(UseWithProduct c : result){
	            logger.info("UseWithProduct List::" + c);
	        }
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<UseWithProduct> listShowOnHomePage() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(UseWithProduct.class);
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.eq("showOnHomePage", true));
			
			Set<UseWithProduct> result = new LinkedHashSet<UseWithProduct>(cr.list());
	        for(UseWithProduct c : result){
	            logger.info("UseWithProduct list::" + c);
	        }
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<UseWithProduct> getProductsByIds(long[] p) {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(UseWithProduct.class);
			cr.add(Restrictions.eq("showOnSite", true));
			
			List<Long> list = new ArrayList<Long>();
			for(long l : p)
				list.add(l);

			cr.add(Restrictions.in("id", list));
			
			return new LinkedHashSet<UseWithProduct>(cr.list());
		}
	
}
