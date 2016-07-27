package com.printmaster.nk.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.modelwork.SearchCutters;

@Repository
public class CutterDAOImpl implements ProductDAO<Cutter, SearchCutters>{

	 private Logger logger = Logger.getLogger(CutterDAOImpl.class);
	 
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 
	    @Override
	    public long addProduct(Cutter c) {
	        Session session = this.sessionFactory.getCurrentSession();
	        long id = (Long) session.save(c);
	        logger.info("Cutter saved successfully, Cutter Details=" + c);
	        return id;
	    }
	 
	    @Override
	    public void updateProduct(Cutter c) {
	        Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        logger.info("Cutter updated successfully, Cutter Details="+c);
	    }
	 
	    @SuppressWarnings({ "unchecked", "rawtypes" })
	    @Override
	    public Set<Cutter> listProducts(String sortCriteria) {
	        Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Cutter.class);
			cr.addOrder( Order.desc(sortCriteria));
			Set<Cutter> cutterList = new LinkedHashSet(cr.list());
	        for(Cutter c : cutterList){
	            logger.info("Cutter List::" + c);
	        }
	        return cutterList;
	    }
	 
	    @Override
	    public Cutter getProductById(long id) {
	        Session session = this.sessionFactory.getCurrentSession();      
	        Cutter c = (Cutter) session.load(Cutter.class, new Long(id));
	        logger.info("Cutter loaded successfully, Cutter details=" + c);
	        return c;
	    }
	 
	    @Override
	    public void removeProduct(long id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Cutter c = (Cutter) session.load(Cutter.class, new Long(id));
	        if(null != c){
	            session.delete(c);
	        }
	        logger.info("Cutter deleted successfully, Cutter details=" + c);
	    }

		@SuppressWarnings("unchecked")
		@Override
		public Set<Cutter> listSearchProducts(SearchCutters searchCutters) {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Cutter.class);
			
			if(searchCutters.getPrise0()!=searchCutters.getPrise1()){
				cr.add(Restrictions.between("prise", searchCutters.getPrise0(), searchCutters.getPrise1()));
			}
			
			if(searchCutters.getTypeCutter()!= null){
			Junction typeCutterGroup = Restrictions.disjunction();
			for(String typeCutter : searchCutters.getTypeCutter()){
				typeCutterGroup.add(Restrictions.eq("typeCutter",typeCutter));
			}
			cr.add(typeCutterGroup);
			}
			
			if(searchCutters.getTypeOfCooling()!= null){
				Junction typeOfCoolingGroup = Restrictions.disjunction();
				for(String typeOfCooling : searchCutters.getTypeOfCooling()){
					typeOfCoolingGroup.add(Restrictions.eq("typeOfCooling",typeOfCooling));
				}
				cr.add(typeOfCoolingGroup);
				}
			
			if(searchCutters.getSizeWorkAreaX0()!=searchCutters.getSizeWorkAreaX1()){
				cr.add(Restrictions.between("sizeWorkAreaX", searchCutters.getSizeWorkAreaX0(), searchCutters.getSizeWorkAreaX1()));
			}
			
			if(searchCutters.getSizeWorkAreaY0()!=searchCutters.getSizeWorkAreaY1()){
				cr.add(Restrictions.between("sizeWorkAreaY", searchCutters.getSizeWorkAreaY0(), searchCutters.getSizeWorkAreaY1()));
			}		
			
			if(searchCutters.getSizeWorkAreaZ0()!=searchCutters.getSizeWorkAreaZ1()){
				cr.add(Restrictions.between("sizeWorkAreaZ", searchCutters.getSizeWorkAreaZ0(), searchCutters.getSizeWorkAreaZ1()));
			}
			
			if(searchCutters.getPreviouslyUsed()!= null){
				Junction previouslyUsedGroup = Restrictions.disjunction();
				for(String pu : searchCutters.getPreviouslyUsed()){
					previouslyUsedGroup.add(Restrictions.eq("previouslyUsed",pu));
				}
				cr.add(previouslyUsedGroup);
			}
			
			if(searchCutters.getTypeEngine()!= null){
				Junction typeEngineGroup = Restrictions.disjunction();
				for(String typeEngine : searchCutters.getTypeEngine()){
					typeEngineGroup.add(Restrictions.eq("typeEngine", typeEngine));
				}
				cr.add(typeEngineGroup);
			}
			
			if(searchCutters.getMechanicalResolution0()!=searchCutters.getMechanicalResolution1()){
				cr.add(Restrictions.between("mechanicalResolution", searchCutters.getMechanicalResolution0(), searchCutters.getMechanicalResolution1()));
			}
			
			if(searchCutters.getSoftwareResolution0()!=searchCutters.getSoftwareResolution1()){
				cr.add(Restrictions.between("softwareResolution", searchCutters.getSoftwareResolution0(), searchCutters.getSoftwareResolution1()));
			}
			
			if(searchCutters.getFrequencySpindle0()!=searchCutters.getFrequencySpindle1()){
				cr.add(Restrictions.between("frequencySpindle", searchCutters.getFrequencySpindle0(), searchCutters.getFrequencySpindle1()));
			}
			
			if(searchCutters.getProcessingSpeedXY0()!=searchCutters.getProcessingSpeedXY1()){
				cr.add(Restrictions.between("processingSpeedXY", searchCutters.getProcessingSpeedXY0(), searchCutters.getProcessingSpeedXY1()));
			}
			
			if(searchCutters.getProcessingSpeedZ0()!=searchCutters.getProcessingSpeedZ1()){
				cr.add(Restrictions.between("processingSpeedZ", searchCutters.getProcessingSpeedZ0(), searchCutters.getProcessingSpeedZ1()));
			}
			
			if(searchCutters.getMountingTool()!= null){
				Junction mountingToolGroup = Restrictions.disjunction();
				for(String mountingTool : searchCutters.getMountingTool()){
					mountingToolGroup.add(Restrictions.eq("mountingTool",mountingTool));
				}
				cr.add(mountingToolGroup);
				}
			
			if(searchCutters.getEquipmentManufacturer()!= null){
			Junction equipmentManufacturerGroup = Restrictions.disjunction();
			for(String equipmentManufacturer : searchCutters.getEquipmentManufacturer()){
				equipmentManufacturerGroup.add(Restrictions.eq("equipmentManufacturer",equipmentManufacturer));
			}
			cr.add(equipmentManufacturerGroup);
			}
			
			if(searchCutters.getAveragePowerConsumption0()!=searchCutters.getAveragePowerConsumption1()){
				cr.add(Restrictions.between("averagePowerConsumption", searchCutters.getAveragePowerConsumption0(), searchCutters.getAveragePowerConsumption1()));
			}
			
			if(searchCutters.getMaxPowerConsumption0()!=searchCutters.getMaxPowerConsumption1()){
				cr.add(Restrictions.between("maxPowerConsumption", searchCutters.getMaxPowerConsumption0(), searchCutters.getMaxPowerConsumption1()));
			}
			
			if(!new Double(searchCutters.getWeight0()).equals(searchCutters.getWeight1())){
				cr.add(Restrictions.between("weight", searchCutters.getWeight0(), searchCutters.getWeight1()));
			}
			
			if(searchCutters.getWidth0()!=searchCutters.getWidth1()){
				cr.add(Restrictions.between("width", searchCutters.getWidth0(), searchCutters.getWidth1()));
			}
			
			if(searchCutters.getHeigth0()!=searchCutters.getHeigth1()){
				cr.add(Restrictions.between("heigth", searchCutters.getHeigth0(), searchCutters.getHeigth1()));
			}
			
			if(searchCutters.getDepth0()!=searchCutters.getDepth1()){
				cr.add(Restrictions.between("depth", searchCutters.getDepth0(), searchCutters.getDepth1()));
			}
	        
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Cutter> result = new HashSet<Cutter>(cr.list());
			
			Iterator<Cutter> itCutters = result.iterator();
			
			while(itCutters.hasNext()){
				Cutter currentCutter = itCutters.next();
				boolean isCutterWeNeed = false;
				
				if (searchCutters.getConnectionInterface()!=null)
				if (searchCutters.getConnectionInterface().length > 0) {
					print:
					for (String currentCutterPropertyValue : currentCutter.getConnectionInterface()) {
						for (String searchedCutterPropertyValue : searchCutters.getConnectionInterface()) {
							if (currentCutterPropertyValue.equals(searchedCutterPropertyValue)) {
								isCutterWeNeed = true;
								break print;
							}
						}
					}
				} 	
				
				if(!isCutterWeNeed)
				if(searchCutters.getSoftware()!=null)
				if (searchCutters.getSoftware().length > 0 ) {
					if(itCutters.hasNext()){
						print:
						for (String currentCutterPropertyValue : currentCutter.getSoftware()) {
							for (String searchedCutterPropertyValue : searchCutters.getSoftware()) {
								if (currentCutterPropertyValue.equals(searchedCutterPropertyValue)) {
									isCutterWeNeed = true;
									break print;
								}
							}
						}
					}
				}		
				
				if((!isCutterWeNeed) && ((searchCutters.getConnectionInterface()!=null && searchCutters.getConnectionInterface().length > 0) ||
						(searchCutters.getSoftware()!=null && searchCutters.getSoftware().length > 0)))
					itCutters.remove();
			}
			
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Cutter> listShowOnSite() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Cutter.class);
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Cutter> result = new HashSet<Cutter>(cr.list());
	        for(Cutter c : result){
	            logger.info("Cutter List::" + c);
	        }
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Cutter> listShowOnHomePage() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Cutter.class);
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.eq("showOnHomePage", true));
			
			HashSet<Cutter> result = new HashSet<Cutter>(cr.list());
	        for(Cutter c : result){
	            logger.info("Cutter list::" + c);
	        }
	        return result;
		}
	
}
