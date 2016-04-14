package com.printmaster.nk.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.SearchRips;

@Repository
public class RipDAOImpl implements ProductDAO<Rip, SearchRips>{

	 private Logger logger = Logger.getLogger(RipDAOImpl.class);
	 
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 
	    @Override
	    public long addProduct(Rip c) {
	        Session session = this.sessionFactory.getCurrentSession();
	        long id = (Long) session.save(c);
	        logger.info("Rip saved successfully, Rip Details=" + c);
	        return id;
	    }
	 
	    @Override
	    public void updateProduct(Rip c) {
	        Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        logger.info("Rip updated successfully, Rip Details="+c);
	    }
	 
	    @SuppressWarnings("unchecked")
	    @Override
	    public List<Rip> listProducts() {
	        Session session = this.sessionFactory.getCurrentSession();
	        List<Rip> ripList = session.createQuery("from Rip").list();
	        for(Rip c : ripList){
	            logger.info("Rip List::" + c);
	        }
	        return ripList;
	    }
	 
	    @Override
	    public Rip getProductById(long id) {
	        Session session = this.sessionFactory.getCurrentSession();      
	        Rip c = (Rip) session.load(Rip.class, new Long(id));
	        logger.info("Rip loaded successfully, Rip details=" + c);
	        return c;
	    }
	 
	    @Override
	    public void removeProduct(long id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Rip c = (Rip) session.load(Rip.class, new Long(id));
	        if(null != c){
	            session.delete(c);
	        }
	        logger.info("Rip deleted successfully, Rip details=" + c);
	    }

		@SuppressWarnings("unchecked")
		@Override
		public Set<Rip> listSearchProducts(SearchRips searchRips) {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Rip.class);
			
			if(searchRips.getPrise0()!=searchRips.getPrise1()){
				cr.add(Restrictions.between("prise", searchRips.getPrise0(), searchRips.getPrise1()));
			}
			
			if(searchRips.getTypeEquipment()!= null){
				Junction typeEquipmentGroup = Restrictions.disjunction();
				for(String typeEquipment : searchRips.getTypeEquipment()){
					typeEquipmentGroup.add(Restrictions.eq("typeEquipment",typeEquipment));
				}
				cr.add(typeEquipmentGroup);
				}
			
			if(searchRips.getSoftwareMaker()!= null){
				Junction softwareMakerGroup = Restrictions.disjunction();
				for(String softwareMaker : searchRips.getSoftwareMaker()){
					softwareMakerGroup.add(Restrictions.eq("softwareMaker",softwareMaker));
				}
				cr.add(softwareMakerGroup);
			}
			
			if(searchRips.getSoftwareClass()!= null){
				Junction softwareClassGroup = Restrictions.disjunction();
				for(String softwareClass : searchRips.getSoftwareClass()){
					softwareClassGroup.add(Restrictions.eq("softwareClass",softwareClass));
				}
				cr.add(softwareClassGroup);
			}
			
			if(searchRips.getSoftwareVersion()!= null){
				Junction softwareVersionGroup = Restrictions.disjunction();
				for(String softwareVersion : searchRips.getSoftwareVersion()){
					softwareVersionGroup.add(Restrictions.eq("softwareVersion",softwareVersion));
				}
				cr.add(softwareVersionGroup);
			}
	        
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Rip> result = new HashSet<Rip>(cr.list());
			
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Rip> listShowOnSite() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Rip.class);
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Rip> result = new HashSet<Rip>(cr.list());
	        for(Rip c : result){
	            logger.info("Rip List::" + c);
	        }
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Rip> listShowOnHomePage() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Rip.class);
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.eq("showOnHomePage", true));
			
			HashSet<Rip> result = new HashSet<Rip>(cr.list());
	        for(Rip c : result){
	            logger.info("Rip list::" + c);
	        }
	        return result;
		}
	
}
