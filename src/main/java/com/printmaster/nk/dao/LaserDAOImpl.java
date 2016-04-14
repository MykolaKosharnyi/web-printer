package com.printmaster.nk.dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.SearchLasers;

@Repository
public class LaserDAOImpl implements ProductDAO<Laser, SearchLasers>{

	 private Logger logger = Logger.getLogger(LaserDAOImpl.class);
	 
	    private SessionFactory sessionFactory;
	     
	    public void setSessionFactory(SessionFactory sf){
	        this.sessionFactory = sf;
	    }
	 
	    @Override
	    public long addProduct(Laser l) {
	        Session session = this.sessionFactory.getCurrentSession();
	        long id = (Long) session.save(l);
	        logger.info("Laser saved successfully, Laser Details=" + l);
	        return id;
	    }
	 
	    @Override
	    public void updateProduct(Laser l) {
	        Session session = this.sessionFactory.getCurrentSession();
	        session.update(l);
	        logger.info("Laser updated successfully, Laser Details="+l);
	    }
	 
	    @SuppressWarnings("unchecked")
	    @Override
	    public List<Laser> listProducts() {
	        Session session = this.sessionFactory.getCurrentSession();
	        List<Laser> laserList = session.createQuery("from Laser").list();
	        for(Laser l : laserList){
	            logger.info("Laser List::" + l);
	        }
	        return laserList;
	    }
	 
	    @Override
	    public Laser getProductById(long id) {
	        Session session = this.sessionFactory.getCurrentSession();      
	        Laser l = (Laser) session.load(Laser.class, new Long(id));
	        logger.info("Laser loaded successfully, Laser details=" + l);
	        return l;
	    }
	 
	    @Override
	    public void removeProduct(long id) {
	        Session session = this.sessionFactory.getCurrentSession();
	        Laser l = (Laser) session.load(Laser.class, new Long(id));
	        if(null != l){
	            session.delete(l);
	        }
	        logger.info("Laser deleted successfully, laser details=" + l);
	    }

		@SuppressWarnings("unchecked")
		@Override
		public Set<Laser> listSearchProducts(SearchLasers searchLasers) {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Laser.class);
			
			if(searchLasers.getPrise0()!=searchLasers.getPrise1()){
				cr.add(Restrictions.between("prise", searchLasers.getPrise0(), searchLasers.getPrise1()));
			}
			
			if(searchLasers.getTypeLaser()!= null){
			Junction typeLaserGroup = Restrictions.disjunction();
			for(String typeLaser : searchLasers.getTypeLaser()){
				typeLaserGroup.add(Restrictions.eq("typeLaser",typeLaser));
			}
			cr.add(typeLaserGroup);
			}
			
			if(searchLasers.getTypeOfCooling()!= null){
				Junction typeOfCoolingGroup = Restrictions.disjunction();
				for(String typeOfCooling : searchLasers.getTypeOfCooling()){
					typeOfCoolingGroup.add(Restrictions.eq("typeOfCooling",typeOfCooling));
				}
				cr.add(typeOfCoolingGroup);
				}
			
			if(searchLasers.getColorSeparation()!= null){
				Junction colorSeparationGroup = Restrictions.disjunction();
				for(String colorSeparation : searchLasers.getColorSeparation()){
					colorSeparationGroup.add(Restrictions.eq("colorSeparation",colorSeparation));
				}
				cr.add(colorSeparationGroup);
				}
			
			if(searchLasers.getTypeTheDisplayedImage()!= null){
				Junction typeTheDisplayedImageGroup = Restrictions.disjunction();
				for(String typeTheDisplayedImage : searchLasers.getTypeTheDisplayedImage()){
					typeTheDisplayedImageGroup.add(Restrictions.eq("typeTheDisplayedImage",typeTheDisplayedImage));
				}
				cr.add(typeTheDisplayedImageGroup);
				}
			
			if(searchLasers.getMaximumResolution0()!=searchLasers.getMaximumResolution1()){
				cr.add(Restrictions.between("maximumResolution", searchLasers.getMaximumResolution0(), searchLasers.getMaximumResolution1()));
			}
			
			if((searchLasers.getFirstPartAdjustingTheLaserPower() > 0) && (searchLasers.getSecondPartAdjustingTheLaserPower() > 0) 
					&& (searchLasers.getFirstPartAdjustingTheLaserPower() < searchLasers.getSecondPartAdjustingTheLaserPower())){
				Junction sizeDropGroup = Restrictions.disjunction();
				sizeDropGroup.add(Restrictions.le("firstPartAdjustingTheLaserPower", searchLasers.getFirstPartAdjustingTheLaserPower()));
				sizeDropGroup.add(Restrictions.between("firstPartAdjustingTheLaserPower", searchLasers.getFirstPartAdjustingTheLaserPower(), searchLasers.getSecondPartAdjustingTheLaserPower()));
				sizeDropGroup.add(Restrictions.between("secondPartAdjustingTheLaserPower", searchLasers.getFirstPartAdjustingTheLaserPower(), searchLasers.getSecondPartAdjustingTheLaserPower()));
				sizeDropGroup.add(Restrictions.ge("secondPartAdjustingTheLaserPower", searchLasers.getSecondPartAdjustingTheLaserPower()));
				
				cr.add(sizeDropGroup);
			}
			
			if(searchLasers.getLaserWavelength0()!=searchLasers.getLaserWavelength1()){
				cr.add(Restrictions.between("laserWavelength", searchLasers.getLaserWavelength0(), searchLasers.getLaserWavelength1()));
			}
			
			if((searchLasers.getLaserPulse0() > 0) && (searchLasers.getLaserPulse1() > 0) 
					&& (searchLasers.getLaserPulse0() < searchLasers.getLaserPulse1())){
				Junction sizeDropGroup = Restrictions.disjunction();
				sizeDropGroup.add(Restrictions.le("laserPulse0", searchLasers.getLaserPulse0()));
				sizeDropGroup.add(Restrictions.between("laserPulse0", searchLasers.getLaserPulse0(), searchLasers.getLaserPulse1()));
				sizeDropGroup.add(Restrictions.between("laserPulse1", searchLasers.getLaserPulse0(), searchLasers.getLaserPulse1()));
				sizeDropGroup.add(Restrictions.ge("laserPulse1", searchLasers.getLaserPulse1()));
				
				cr.add(sizeDropGroup);
			}
			
			if(searchLasers.getTheDiameterOfTheLaser0()!=searchLasers.getTheDiameterOfTheLaser1()){
				cr.add(Restrictions.between("theDiameterOfTheLaser", searchLasers.getTheDiameterOfTheLaser0(), searchLasers.getTheDiameterOfTheLaser1()));
			}
			
			if(searchLasers.getEngravingDepth0()!=searchLasers.getEngravingDepth1()){
				cr.add(Restrictions.between("engravingDepth", searchLasers.getEngravingDepth0(), searchLasers.getEngravingDepth1()));
			}
			
			if(searchLasers.getLaserSource0()!=searchLasers.getLaserSource1()){
				cr.add(Restrictions.between("laserSource", searchLasers.getLaserSource0(), searchLasers.getLaserSource1()));
			}
			
			if(searchLasers.getSizeWorkAreaX0()!=searchLasers.getSizeWorkAreaX1()){
				cr.add(Restrictions.between("sizeWorkAreaX", searchLasers.getSizeWorkAreaX0(), searchLasers.getSizeWorkAreaX1()));
			}
			
			if(searchLasers.getSizeWorkAreaY0()!=searchLasers.getSizeWorkAreaY1()){
				cr.add(Restrictions.between("sizeWorkAreaY", searchLasers.getSizeWorkAreaY0(), searchLasers.getSizeWorkAreaY1()));
			}		
			
			if(searchLasers.getSizeWorkAreaZ0()!=searchLasers.getSizeWorkAreaZ1()){
				cr.add(Restrictions.between("sizeWorkAreaZ", searchLasers.getSizeWorkAreaZ0(), searchLasers.getSizeWorkAreaZ1()));
			}
			
			if(searchLasers.getPreviouslyUsed()!= null){
				Junction previouslyUsedGroup = Restrictions.disjunction();
				for(String pu : searchLasers.getPreviouslyUsed()){
					previouslyUsedGroup.add(Restrictions.eq("previouslyUsed",pu));
				}
				cr.add(previouslyUsedGroup);
			}
			
			if(searchLasers.getPowerOfLaser0()!=searchLasers.getPowerOfLaser1()){
				cr.add(Restrictions.between("powerOfLaser", searchLasers.getPowerOfLaser0(), searchLasers.getPowerOfLaser1()));
			}
			
			if(searchLasers.getTypeEngine()!= null){
				Junction typeEngineGroup = Restrictions.disjunction();
				for(String typeEngine : searchLasers.getTypeEngine()){
					typeEngineGroup.add(Restrictions.eq("typeEngine", typeEngine));
				}
				cr.add(typeEngineGroup);
			}
			
			if(searchLasers.getMechanicalResolution0()!=searchLasers.getMechanicalResolution1()){
				cr.add(Restrictions.between("mechanicalResolution", searchLasers.getMechanicalResolution0(), searchLasers.getMechanicalResolution1()));
			}
			
			if(searchLasers.getSoftwareResolution0()!=searchLasers.getSoftwareResolution1()){
				cr.add(Restrictions.between("softwareResolution", searchLasers.getSoftwareResolution0(), searchLasers.getSoftwareResolution1()));
			}
			
			if(!new Double(searchLasers.getMinimumThicknessOfCut0()).equals(searchLasers.getMinimumThicknessOfCut1())){
				cr.add(Restrictions.between("minimumThicknessOfCut", searchLasers.getMinimumThicknessOfCut0(), searchLasers.getMinimumThicknessOfCut1()));
			}
			
			if(searchLasers.getEngravingSpeed0()!=searchLasers.getEngravingSpeed1()){
				cr.add(Restrictions.between("engravingSpeed", searchLasers.getEngravingSpeed0(), searchLasers.getEngravingSpeed1()));
			}
			
			if(searchLasers.getCuttingSpeed0()!=searchLasers.getCuttingSpeed1()){
				cr.add(Restrictions.between("cuttingSpeed", searchLasers.getCuttingSpeed0(), searchLasers.getCuttingSpeed1()));
			}
			
			if(searchLasers.getEquipmentManufacturer()!= null){
			Junction equipmentManufacturerGroup = Restrictions.disjunction();
			for(String equipmentManufacturer : searchLasers.getEquipmentManufacturer()){
				equipmentManufacturerGroup.add(Restrictions.eq("equipmentManufacturer",equipmentManufacturer));
			}
			cr.add(equipmentManufacturerGroup);
			}
			
			if(searchLasers.getAveragePowerConsumption0()!=searchLasers.getAveragePowerConsumption1()){
				cr.add(Restrictions.between("averagePowerConsumption", searchLasers.getAveragePowerConsumption0(), searchLasers.getAveragePowerConsumption1()));
			}
			
			if(searchLasers.getMaxPowerConsumption0()!=searchLasers.getMaxPowerConsumption1()){
				cr.add(Restrictions.between("maxPowerConsumption", searchLasers.getMaxPowerConsumption0(), searchLasers.getMaxPowerConsumption1()));
			}
			
			if(!new Double(searchLasers.getWeight0()).equals(searchLasers.getWeight1())){
				cr.add(Restrictions.between("weight", searchLasers.getWeight0(), searchLasers.getWeight1()));
			}
			
			if(searchLasers.getWidth0()!=searchLasers.getWidth1()){
				cr.add(Restrictions.between("width", searchLasers.getWidth0(), searchLasers.getWidth1()));
			}
			
			if(searchLasers.getHeigth0()!=searchLasers.getHeigth1()){
				cr.add(Restrictions.between("heigth", searchLasers.getHeigth0(), searchLasers.getHeigth1()));
			}
			
			if(searchLasers.getDepth0()!=searchLasers.getDepth1()){
				cr.add(Restrictions.between("depth", searchLasers.getDepth0(), searchLasers.getDepth1()));
			}
	        
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Laser> result = new HashSet<Laser>(cr.list());
			
			Iterator<Laser> itLasers = result.iterator();
			
			while(itLasers.hasNext()){
				Laser currentLaser = itLasers.next();
				boolean isLaserWeNeed = false;
				
				if (searchLasers.getConnectionInterface()!=null)
				if (searchLasers.getConnectionInterface().length > 0) {
					print:
					for (String currentLaserPropertyValue : currentLaser.getConnectionInterface()) {
						for (String searchedLaserPropertyValue : searchLasers.getConnectionInterface()) {
							if (currentLaserPropertyValue.equals(searchedLaserPropertyValue)) {
								isLaserWeNeed = true;
								break print;
							}
						}
					}
				} 
				
				if(!isLaserWeNeed)
				if (searchLasers.getFileTypes()!=null)
				if (searchLasers.getFileTypes().length > 0) {
					if(itLasers.hasNext()){
						print:
						for (String currentLaserPropertyValue : currentLaser.getFileTypes()) {
							for (String searchedLaserPropertyValue : searchLasers.getFileTypes()) {
								if (currentLaserPropertyValue.equals(searchedLaserPropertyValue)) {
									isLaserWeNeed = true;
									break print;
								}
							}
						}
					}
				}	
				
				if(!isLaserWeNeed)
				if(searchLasers.getSoftware()!=null)
				if (searchLasers.getSoftware().length > 0 ) {
					if(itLasers.hasNext()){
						print:
						for (String currentLaserPropertyValue : currentLaser.getSoftware()) {
							for (String searchedLaserPropertyValue : searchLasers.getSoftware()) {
								if (currentLaserPropertyValue.equals(searchedLaserPropertyValue)) {
									isLaserWeNeed = true;
									break print;
								}
							}
						}
					}
				}	
				
				if(!isLaserWeNeed)
					if(searchLasers.getSpecialPurpose()!=null)
					if (searchLasers.getSpecialPurpose().length > 0 ) {
						if(itLasers.hasNext()){
							print:
							for (String currentLaserPropertyValue : currentLaser.getSpecialPurpose()) {
								for (String searchedLaserPropertyValue : searchLasers.getSpecialPurpose()) {
									if (currentLaserPropertyValue.equals(searchedLaserPropertyValue)) {
										isLaserWeNeed = true;
										break print;
									}
								}
							}
						}
					}
				
				if((!isLaserWeNeed) && ((searchLasers.getConnectionInterface()!=null && searchLasers.getConnectionInterface().length > 0) ||
						(searchLasers.getFileTypes()!=null && searchLasers.getFileTypes().length > 0) ||
						(searchLasers.getSoftware()!=null && searchLasers.getSoftware().length > 0) || 
						(searchLasers.getSpecialPurpose()!=null && searchLasers.getSpecialPurpose().length > 0)))
					itLasers.remove();
			}
			
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Laser> listShowOnSite() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Laser.class);
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Laser> result = new HashSet<Laser>(cr.list());
	        for(Laser l : result){
	            logger.info("Laser List::" + l);
	        }
	        return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Laser> listShowOnHomePage() {
			Session session = this.sessionFactory.getCurrentSession();
			Criteria cr = session.createCriteria(Laser.class);
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.eq("showOnHomePage", true));
			
			HashSet<Laser> result = new HashSet<Laser>(cr.list());
	        for(Laser l : result){
	            logger.info("Laser list::" + l);
	        }
	        return result;
		}
	
}
