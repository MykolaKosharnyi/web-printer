package com.mykoshar.shop.api.model.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mykoshar.shop.api.model.entity.Laminator;
import com.mykoshar.shop.api.model.entity.search.SearchLaminators;

@Repository
public class LaminatorDAOImpl extends ProductDaoTemplate<Laminator, SearchLaminators>{
	
	 public LaminatorDAOImpl() {
		super(Laminator.class);
	}

	    @SuppressWarnings("unchecked")
		@Override
		public Set<Laminator> listSearchByPhrase(String phrase) {
			Session session = getSessionFactory().getCurrentSession();
			Criteria cr = session.createCriteria(Laminator.class);
			
			cr.add(Restrictions.eq("showOnSite", true));
			cr.add(Restrictions.like("name", phrase, MatchMode.ANYWHERE));
			
			return new HashSet<Laminator>(cr.list());
		}

		@SuppressWarnings("unchecked")
		@Override
		public Set<Laminator> listSearchProducts(SearchLaminators searchLaminators) {
			Session session = getSessionFactory().getCurrentSession();
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
	
}
