package com.mykoshar.shop.api.model.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.mykoshar.shop.api.model.entity.DigitalPrinter;
import com.mykoshar.shop.api.model.entity.Printer3D;
import com.mykoshar.shop.api.model.entity.Scanner;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mykoshar.shop.api.model.dao.UseWithProductDAO;
import com.mykoshar.shop.api.model.entity.Cutter;
import com.mykoshar.shop.api.model.entity.Laminator;
import com.mykoshar.shop.api.model.entity.Laser;
import com.mykoshar.shop.api.model.entity.Printer;
import com.mykoshar.shop.api.model.entity.UseWithProduct;
import com.mykoshar.shop.api.model.entity.search.SearchUseWithProducts;

@Slf4j
@Repository
public class UseWithProductDAOImpl implements UseWithProductDAO{

	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 
	    @Override
	    public long addProduct(UseWithProduct c) {
	        Session session = this.sessionFactory.getCurrentSession();
	        long id = (Long) session.save(c);
	        log.info("SAVE UseWithProduct, id=" + id);
	        return id;
	    }
	 
	    @SuppressWarnings("unchecked")
		@Override
		public Set<UseWithProduct> listSearchByPhrase(String phrase) {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(UseWithProduct.class);
			
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.like("name", phrase, MatchMode.ANYWHERE));
			
			Set<UseWithProduct> result = new HashSet<UseWithProduct>(cr.list());
			log.info(getIdFromArray(result));
			return result;
		}
	    	
	    @Override
	    public void updateProduct(UseWithProduct c) {
	        Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        log.info("UPDATE UseWithProduct, id=" + c.getId());
	    }
	 
	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    @Override
	    public Set<UseWithProduct> listProducts(String sortCriteria) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Criteria cr = session.createCriteria(UseWithProduct.class);
	        
	        if("id".equals(sortCriteria) || "prise".equals(sortCriteria) || "top".equals(sortCriteria)){		
				cr.addOrder(Order.desc(sortCriteria));
			} else {
				cr.addOrder(Order.asc(sortCriteria));
			}
	        	        
			Set<UseWithProduct> useWithProductList = new LinkedHashSet(cr.list());
			log.info(getIdFromArray(useWithProductList));
	        return useWithProductList;
	    }

	    @Override
	    public UseWithProduct getProductById(long id) {
	        Session session = this.sessionFactory.getCurrentSession();      
	        UseWithProduct c = (UseWithProduct) session.load(UseWithProduct.class, new Long(id));
	        log.info("LOAD UseWithProduct, id=" + id);
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
	        
	        
	        log.info("DELETE UseWithProduct, id=" + id);
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
			log.info(getIdFromArray(result));
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<UseWithProduct> listShowOnSite() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(UseWithProduct.class);
			cr.add(Restrictions.eq("showOnSite", true));
			
			Set<UseWithProduct> result = new LinkedHashSet<UseWithProduct>(cr.list());
			
			log.info(getIdFromArray(result));
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
			
			log.info(getIdFromArray(result));
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
			
			Set<UseWithProduct> result = new LinkedHashSet<UseWithProduct>(cr.list());
			log.info(getIdFromArray(result));
			return result;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Set<UseWithProduct> getPrintersByTypeInk(String[] typeInk){
			
			if(typeInk!= null && (typeInk.length > 0)){
				
				Session session = this.sessionFactory.getCurrentSession();
				Criteria cr = session.createCriteria(UseWithProduct.class);
				
				cr.add(Restrictions.eq("typeProduct", "Чернила для струйной печати"));
				
				Junction searchForTypeInk = Restrictions.disjunction();
				for(String ink : typeInk){
					searchForTypeInk.add(Restrictions.eq("typeInk", ink));
				}
				cr.add(searchForTypeInk);
				
				Set<UseWithProduct> result = new LinkedHashSet<UseWithProduct>(cr.list());
				log.info(getIdFromArray(result));
				return result;
			} else {
				log.info("UseWithProduct list is empty!");
				return new LinkedHashSet<UseWithProduct>();
			}
			
		}
		
		private String getIdFromArray(Set<UseWithProduct> list){
	    	StringBuilder result = new StringBuilder();
	    	result.append("UseWithProduct list[");
	    	
	    	for(UseWithProduct current:list){
	    		result.append(" " + current.getId());
	    	}
	    	
	    	result.append(" ]");
	    	return result.toString();
	    }
	    
}
