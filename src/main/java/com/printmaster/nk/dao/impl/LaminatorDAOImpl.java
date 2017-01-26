package com.printmaster.nk.dao.impl;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.model.SearchLaminators;

@Repository
public class LaminatorDAOImpl implements ProductDAO<Laminator, SearchLaminators>{

	 private Logger logger = Logger.getLogger(LaminatorDAOImpl.class);
	 
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 
	    @SuppressWarnings("unchecked")
		@Override
		public Set<Laminator> listSearchByPhrase(String phrase) {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Laminator.class);
			
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.like("name", phrase, MatchMode.ANYWHERE));
			
			return new HashSet<Laminator>(cr.list());
		}
	    
	    @Override
	    public long addProduct(Laminator l) {
	        Session session = this.sessionFactory.getCurrentSession();
	        long id = (Long) session.save(l);
	        logger.info("Laminator saved successfully, Laminator Details=" + l);
	        return id;
	    }
	 
	    @Override
	    public void updateProduct(Laminator l) {
	        Session session = this.sessionFactory.getCurrentSession();
	        session.update(l);
	        logger.info("Laminator updated successfully, Laminator Details=" + l);
	    }
	 
	    @SuppressWarnings("unchecked")
	    @Override
	    public Set<Laminator> listProducts(String sortCriteria) {
	        Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Laminator.class);
			cr.addOrder( Order.desc(sortCriteria));
	        @SuppressWarnings("rawtypes")
			Set<Laminator> laminatorList = new LinkedHashSet(cr.list());
	        for(Laminator l : laminatorList){
	            logger.info("Laminator List::" + l);
	        }
	        return laminatorList;
	    }
	 
	    @Override
	    public Laminator getProductById(long id) {
	        Session session = this.sessionFactory.getCurrentSession();      
	        Laminator l = (Laminator) session.load(Laminator.class, new Long(id));
	        logger.info("Laminator loaded successfully, Laminator details=" + l);
	        return l;
	    }
	 
	    @Override
	    public void removeProduct(long id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Laminator l = (Laminator) session.load(Laminator.class, new Long(id));
	        if(null != l){
	            session.delete(l);
	        }
	        logger.info("Laminator deleted successfully, Laminator details=" + l);
	    }

		@SuppressWarnings("unchecked")
		@Override
		public Set<Laminator> listSearchProducts(SearchLaminators searchLaminators) {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Laminator.class);
			
			if(searchLaminators.getPrise0()!=searchLaminators.getPrise1()){
				cr.add(Restrictions.between("prise", searchLaminators.getPrise0(), searchLaminators.getPrise1()));
			}
			
			if(searchLaminators.getTypeProduct()!= null){
			Junction typeLaminatorGroup = Restrictions.disjunction();
			for(String typeProduct : searchLaminators.getTypeProduct()){
				typeLaminatorGroup.add(Restrictions.eq("typeProduct",typeProduct));
			}
			cr.add(typeLaminatorGroup);
			}
			
			if(searchLaminators.getLaminatingWidth()!= null){
				Junction laminatingWidthGroup = Restrictions.disjunction();
				for(String laminatingWidth : searchLaminators.getLaminatingWidth()){
					laminatingWidthGroup.add(Restrictions.eq("laminatingWidth",laminatingWidth));
				}
				cr.add(laminatingWidthGroup);
				}
			
			if(searchLaminators.getInnings()!= null){
				Junction inningsGroup = Restrictions.disjunction();
				for(String innings : searchLaminators.getInnings()){
					inningsGroup.add(Restrictions.eq("innings",innings));
				}
				cr.add(inningsGroup);
				}
			
			if(searchLaminators.getNumberOfShafts0()!=searchLaminators.getNumberOfShafts1()){
				cr.add(Restrictions.between("numberOfShafts", searchLaminators.getNumberOfShafts0(), searchLaminators.getNumberOfShafts1()));
			}
			
			if(searchLaminators.getShaftDiameter0()!=searchLaminators.getShaftDiameter1()){
				cr.add(Restrictions.between("shaftDiameter", searchLaminators.getShaftDiameter0(), searchLaminators.getShaftDiameter1()));
			}		
			
			if(searchLaminators.getFilmThickness0()!=searchLaminators.getFilmThickness1()){
				cr.add(Restrictions.between("filmThickness", searchLaminators.getFilmThickness0(), searchLaminators.getFilmThickness1()));
			}
			
			if(searchLaminators.getWarmUpTime0()!=searchLaminators.getWarmUpTime1()){
				cr.add(Restrictions.between("warmUpTime", searchLaminators.getWarmUpTime0(), searchLaminators.getWarmUpTime1()));
			}
			if(searchLaminators.getLaminationTemperature0()!=searchLaminators.getLaminationTemperature1()){
				cr.add(Restrictions.between("laminationTemperature", searchLaminators.getLaminationTemperature0(), searchLaminators.getLaminationTemperature1()));
			}
			
			if(searchLaminators.getLaminatingSpeed0()!=searchLaminators.getLaminatingSpeed1()){
				cr.add(Restrictions.between("laminatingSpeed", searchLaminators.getLaminatingSpeed0(), searchLaminators.getLaminatingSpeed1()));
			}
			
			if(searchLaminators.getPreviouslyUsed()!= null){
				Junction previouslyUsedGroup = Restrictions.disjunction();
				for(String pu : searchLaminators.getPreviouslyUsed()){
					previouslyUsedGroup.add(Restrictions.eq("previouslyUsed",pu));
				}
				cr.add(previouslyUsedGroup);
			}
			
			if(searchLaminators.getEquipmentManufacturer()!= null){
			Junction equipmentManufacturerGroup = Restrictions.disjunction();
			for(String equipmentManufacturer : searchLaminators.getEquipmentManufacturer()){
				equipmentManufacturerGroup.add(Restrictions.eq("equipmentManufacturer",equipmentManufacturer));
			}
			cr.add(equipmentManufacturerGroup);
			}
			
			if(searchLaminators.getAveragePowerConsumption0()!=searchLaminators.getAveragePowerConsumption1()){
				cr.add(Restrictions.between("averagePowerConsumption", searchLaminators.getAveragePowerConsumption0(), searchLaminators.getAveragePowerConsumption1()));
			}
			
			if(searchLaminators.getMaxPowerConsumption0()!=searchLaminators.getMaxPowerConsumption1()){
				cr.add(Restrictions.between("maxPowerConsumption", searchLaminators.getMaxPowerConsumption0(), searchLaminators.getMaxPowerConsumption1()));
			}
			
			if(!new Double(searchLaminators.getWeight0()).equals(searchLaminators.getWeight1())){
				cr.add(Restrictions.between("weight", searchLaminators.getWeight0(), searchLaminators.getWeight1()));
			}
			
			if(searchLaminators.getWidth0()!=searchLaminators.getWidth1()){
				cr.add(Restrictions.between("width", searchLaminators.getWidth0(), searchLaminators.getWidth1()));
			}
			
			if(searchLaminators.getHeigth0()!=searchLaminators.getHeigth1()){
				cr.add(Restrictions.between("heigth", searchLaminators.getHeigth0(), searchLaminators.getHeigth1()));
			}
			
			if(searchLaminators.getDepth0()!=searchLaminators.getDepth1()){
				cr.add(Restrictions.between("depth", searchLaminators.getDepth0(), searchLaminators.getDepth1()));
			}
	        
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Laminator> result = new HashSet<Laminator>(cr.list());
			
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Laminator> listShowOnSite() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Laminator.class);
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Laminator> result = new HashSet<Laminator>(cr.list());
	        for(Laminator l : result){
	            logger.info("Laminator List::" + l);
	        }
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Laminator> listShowOnHomePage() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Laminator.class);
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.eq("showOnHomePage", true));
			
			HashSet<Laminator> result = new HashSet<Laminator>(cr.list());
	        for(Laminator l : result){
	            logger.info("Laminator list::" + l);
	        }
	        return result;
		}
	
}
