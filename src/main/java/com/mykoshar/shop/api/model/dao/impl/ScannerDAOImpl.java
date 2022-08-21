package com.mykoshar.shop.api.model.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.mykoshar.shop.api.model.entity.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mykoshar.shop.api.model.entity.search.SearchScanners;

@Repository
public class ScannerDAOImpl extends ProductDaoTemplate<Scanner, SearchScanners>{
	
	public ScannerDAOImpl() {
		super(Scanner.class);
	}

	    @SuppressWarnings("unchecked")
		@Override
		public Set<Scanner> listSearchByPhrase(String phrase) {
			Session session = getSessionFactory().getCurrentSession();
			Criteria cr = session.createCriteria(Scanner.class);
			
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.like("name", phrase, MatchMode.ANYWHERE));
			
			return new HashSet<Scanner>(cr.list());
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Scanner> listSearchProducts(SearchScanners searchScanners) {
			Session session = getSessionFactory().getCurrentSession();
			Criteria cr = session.createCriteria(Scanner.class);
			
			if(searchScanners.getPrise0()!=searchScanners.getPrise1()){
				cr.add(Restrictions.between("prise", searchScanners.getPrise0(), searchScanners.getPrise1()));
			}
			
			if(searchScanners.getTypeProduct()!= null){
			Junction typeScannerGroup = Restrictions.disjunction();
			for(String typeProduct : searchScanners.getTypeProduct()){
				typeScannerGroup.add(Restrictions.eq("typeProduct", typeProduct));
			}
			cr.add(typeScannerGroup);
			}
			
			if(searchScanners.getScanningWidth()!= null){
				Junction scanningWidthGroup = Restrictions.disjunction();
				for(String scanningWidth : searchScanners.getScanningWidth()){
					scanningWidthGroup.add(Restrictions.eq("scanningWidth", scanningWidth));
				}
				cr.add(scanningWidthGroup);
				}
			
			if(searchScanners.getPreviouslyUsed()!= null){
				Junction previouslyUsedGroup = Restrictions.disjunction();
				for(String pu : searchScanners.getPreviouslyUsed()){
					previouslyUsedGroup.add(Restrictions.eq("previouslyUsed",pu));
				}
				cr.add(previouslyUsedGroup);
			}
			
			if(searchScanners.getInnings()!= null){
				Junction inningsGroup = Restrictions.disjunction();
				for(String innings : searchScanners.getInnings()){
					inningsGroup.add(Restrictions.eq("innings", innings));
				}
				cr.add(inningsGroup);
				}
			
			if(searchScanners.getChromaticity()!= null){
				Junction chromaticityGroup = Restrictions.disjunction();
				for(String chromaticity : searchScanners.getChromaticity()){
					chromaticityGroup.add(Restrictions.eq("chromaticity", chromaticity));
				}
				cr.add(chromaticityGroup);
				}
			
			if(searchScanners.getScanningElement()!= null){
				Junction scanningElementGroup = Restrictions.disjunction();
				for(String scanningElement : searchScanners.getScanningElement()){
					scanningElementGroup.add(Restrictions.eq("scanningElement", scanningElement));
				}
				cr.add(scanningElementGroup);
				}
			
			if(searchScanners.getLightSource()!= null){
				Junction lightSourceGroup = Restrictions.disjunction();
				for(String lightSource : searchScanners.getLightSource()){
					lightSourceGroup.add(Restrictions.eq("lightSource", lightSource));
				}
				cr.add(lightSourceGroup);
				}
			
			if(searchScanners.getBitColorScanning()!= null){
				Junction bitColorScanningGroup = Restrictions.disjunction();
				for(String bitColorScanning : searchScanners.getBitColorScanning()){
					bitColorScanningGroup.add(Restrictions.eq("bitColorScanning", bitColorScanning));
				}
				cr.add(bitColorScanningGroup);
				}
			
			if(searchScanners.getBitScanningGrayscale()!= null){
				Junction bitScanningGrayscaleGroup = Restrictions.disjunction();
				for(String bitScanningGrayscale : searchScanners.getBitScanningGrayscale()){
					bitScanningGrayscaleGroup.add(Restrictions.eq("bitScanningGrayscale", bitScanningGrayscale));
				}
				cr.add(bitScanningGrayscaleGroup);
				}
			
			if(searchScanners.getSoftwareResolution0()!=searchScanners.getSoftwareResolution1()){
				cr.add(Restrictions.between("softwareResolution", searchScanners.getSoftwareResolution0(), searchScanners.getSoftwareResolution1()));
			}
			
			if(searchScanners.getScanSpeed0()!=searchScanners.getScanSpeed1()){
				cr.add(Restrictions.between("scanSpeed", searchScanners.getScanSpeed0(), searchScanners.getScanSpeed1()));
			}
			
			if(searchScanners.getOpticalResolution()!= null){
				Junction opticalResolutionGroup = Restrictions.disjunction();
				for(String opticalResolution : searchScanners.getOpticalResolution()){
					opticalResolutionGroup.add(Restrictions.eq("opticalResolution", opticalResolution));
				}
				cr.add(opticalResolutionGroup);
				}
			
			if(searchScanners.getTheMaximumThicknessOfTheCarrier0()!=searchScanners.getTheMaximumThicknessOfTheCarrier1()){
				cr.add(Restrictions.between("theMaximumThicknessOfTheCarrier", searchScanners.getTheMaximumThicknessOfTheCarrier0(),
						searchScanners.getTheMaximumThicknessOfTheCarrier1()));
			}
						
			if(searchScanners.getEquipmentManufacturer()!= null){
			Junction equipmentManufacturerGroup = Restrictions.disjunction();
			for(String equipmentManufacturer : searchScanners.getEquipmentManufacturer()){
				equipmentManufacturerGroup.add(Restrictions.eq("equipmentManufacturer",equipmentManufacturer));
			}
			cr.add(equipmentManufacturerGroup);
			}
			
			if(searchScanners.getAveragePowerConsumption0()!=searchScanners.getAveragePowerConsumption1()){
				cr.add(Restrictions.between("averagePowerConsumption", searchScanners.getAveragePowerConsumption0(), searchScanners.getAveragePowerConsumption1()));
			}
			
			if(searchScanners.getMaxPowerConsumption0()!=searchScanners.getMaxPowerConsumption1()){
				cr.add(Restrictions.between("maxPowerConsumption", searchScanners.getMaxPowerConsumption0(), searchScanners.getMaxPowerConsumption1()));
			}
			
			if(!new Double(searchScanners.getWeight0()).equals(searchScanners.getWeight1())){
				cr.add(Restrictions.between("weight", searchScanners.getWeight0(), searchScanners.getWeight1()));
			}
			
			if(searchScanners.getWidth0()!=searchScanners.getWidth1()){
				cr.add(Restrictions.between("width", searchScanners.getWidth0(), searchScanners.getWidth1()));
			}
			
			if(searchScanners.getHeigth0()!=searchScanners.getHeigth1()){
				cr.add(Restrictions.between("heigth", searchScanners.getHeigth0(), searchScanners.getHeigth1()));
			}
			
			if(searchScanners.getDepth0()!=searchScanners.getDepth1()){
				cr.add(Restrictions.between("depth", searchScanners.getDepth0(), searchScanners.getDepth1()));
			}
	        
			cr.add(Restrictions.eq("showOnSite", true));
			
			HashSet<Scanner> result = new HashSet<Scanner>(cr.list());
			
			Iterator<Scanner> iScanners = result.iterator();
			
			while(iScanners.hasNext()){
				Scanner currentScanner = iScanners.next();
				boolean isScannerWeNeed = false;
				
				if (searchScanners.getConnectionInterface()!=null)
				if (searchScanners.getConnectionInterface().length > 0) {
					print:
					for (String currentScannerPropertyValue : currentScanner.getConnectionInterface()) {
						for (String searchedScannerPropertyValue : searchScanners.getConnectionInterface()) {
							if (currentScannerPropertyValue.equals(searchedScannerPropertyValue)) {
								isScannerWeNeed = true;
								break print;
							}
						}
					}
				} 	
				
				if(!isScannerWeNeed)
				if(searchScanners.getSoftware()!=null)
				if (searchScanners.getSoftware().length > 0 ) {
					if(iScanners.hasNext()){
						print:
						for (String currentScannerPropertyValue : currentScanner.getSoftware()) {
							for (String searchedScannerPropertyValue : searchScanners.getSoftware()) {
								if (currentScannerPropertyValue.equals(searchedScannerPropertyValue)) {
									isScannerWeNeed = true;
									break print;
								}
							}
						}
					}
				}		
				
				if((!isScannerWeNeed) && ((searchScanners.getConnectionInterface()!=null && searchScanners.getConnectionInterface().length > 0) ||
						(searchScanners.getSoftware()!=null && searchScanners.getSoftware().length > 0)))
					iScanners.remove();
			}
			
	        return result;
		}
	
}
