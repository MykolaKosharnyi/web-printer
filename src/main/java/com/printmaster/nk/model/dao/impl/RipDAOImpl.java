package com.printmaster.nk.model.dao.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.entity.Rip;
import com.printmaster.nk.model.entity.search.SearchRips;

@Repository
public class RipDAOImpl extends ProductDaoTemplate<Rip, SearchRips> {
	
	public RipDAOImpl() {
		super(Rip.class);
	}

    @SuppressWarnings("unchecked")
	@Override
	public Set<Rip> listSearchByPhrase(String phrase) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria cr = session.createCriteria(Rip.class);
		
		cr.add(Restrictions.eq("showOnSite", true));
		cr.add(Restrictions.like("name", phrase, MatchMode.ANYWHERE));
		
		return new HashSet<Rip>(cr.list());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Rip> listSearchProducts(SearchRips searchRips) {
		Session session = getSessionFactory().getCurrentSession();
		Criteria cr = session.createCriteria(Rip.class);

		if (searchRips.getPrise0() != searchRips.getPrise1()) {
			cr.add(Restrictions.between("prise", searchRips.getPrise0(), searchRips.getPrise1()));
		}

		cr.add(Restrictions.eq("showOnSite", true));

		return deleteUncheckedRip(new HashSet<Rip>(cr.list()), searchRips);
	}

	private HashSet<Rip> deleteUncheckedRip(HashSet<Rip> result, SearchRips searchRips){
		//get all program product with which can showed to consumer
		Iterator<Rip> itRip = result.iterator();

		while (itRip.hasNext()) {
			if ((!checkByTypeEquipmentLevel(itRip.next(), searchRips)))
				itRip.remove();
		}
		return result;
	}
	
	/**
	 * Check program product to search criteria (begin from type equipment level)
	 * 
	 * @param currentRip given to check
	 * @param searchRips criteria to search program product
	 * @return true if currentRip required searchRips criteria
	 */
	private boolean checkByTypeEquipmentLevel(Rip currentRip, SearchRips searchRips){
		boolean isRipWeNeed = false;

		// check if user checked any of TYPE EQUIPMENT if don't so out all
		// products
		if ((searchRips.getTypeEquipment() != null) && (searchRips.getTypeEquipment().length > 0)) {

			for (String typeEquipment : searchRips.getTypeEquipment()) 
				if (currentRip.getTypeEquipment().equals(typeEquipment))
					return checkBySoftwareMakerLevel(currentRip, searchRips, isRipWeNeed, typeEquipment);

		} else {
			return true;
		}
		return isRipWeNeed;
	}

	/**
	 * Check program product to search criteria (work on software maker level)
	 * 
	 * @param currentRip given to check
	 * @param searchRips criteria to search program product
	 * @param isRipWeNeed default value (if given product don't respond given criteria so delete this product)
	 * @param typeEquipment concrete checked equipment from searchRips
	 * @return true if currentRip required searchRips criteria
	 */
	@SuppressWarnings("unchecked")
	private boolean checkBySoftwareMakerLevel(Rip currentRip, SearchRips searchRips,
			boolean isRipWeNeed, String typeEquipment) {
		
		JSONArray usedDate = null;
		try {
			usedDate = (JSONArray) new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/rip.json"), "UTF-8"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}		
		
		if ( (searchRips.getSoftwareMaker() != null) && (searchRips.getSoftwareMaker().length > 0) ) {

			Iterator<JSONObject> typeEquipmetnJson = usedDate.iterator();

			while (typeEquipmetnJson.hasNext()) {
				JSONObject concreteEquipment = typeEquipmetnJson.next();
				if (concreteEquipment.get("type_equipment").equals(typeEquipment)) {

					JSONArray arrayEquipment = (JSONArray) concreteEquipment.get("software_maker");

					if(isNotCheckedSoftwareForThisEquipment(searchRips, arrayEquipment)) return true;

					Iterator<JSONObject> itSoftware = arrayEquipment.iterator();
					while (itSoftware.hasNext()) {
						JSONObject concreteSoftware = itSoftware.next();

						for (String softwareMaker : searchRips.getSoftwareMaker()) 
							if (concreteSoftware.get("name").equals(softwareMaker)
									&& currentRip.getSoftwareMaker().equals(softwareMaker)) 
								return checkBySoftwareClassLevel(currentRip, searchRips, isRipWeNeed, concreteSoftware);
					}
					return isRipWeNeed;
				}
			}

		} else {
			return true;
		}
		return isRipWeNeed;
	}

	/**
	 * Check program product to search criteria (work on software class level)
	 * @param currentRip given to check
	 * @param searchRips criteria to search program product
	 * @param isRipWeNeed default value (if given product don't respond given criteria so delete this product)
	 * @param concreteSoftware - software maker which contain these software classes
	 * @return true if currentRip required searchRips criteria
	 */
	private boolean checkBySoftwareClassLevel(Rip currentRip, SearchRips searchRips, boolean isRipWeNeed,
			JSONObject concreteSoftware) {
		if ( (searchRips.getSoftwareClass() != null) && (searchRips.getSoftwareClass().length > 0) ) {
				JSONArray arraySoftClass = (JSONArray) concreteSoftware.get("software_class");

				if(isNotCheckeSoftwareClassesForThisSoftwareMaker(searchRips, arraySoftClass)) return true;

				for (String softwareClass : searchRips.getSoftwareClass()) {
					if (arraySoftClass.contains(softwareClass) && currentRip.getSoftwareClass().equals(softwareClass)) 
						return true;														
				}

		} else {
			return true;
		}
		return isRipWeNeed;
	}

	/**
	 * Checking if software classes was checked for this concrete software maker
	 * @param searchRips
	 * @param arraySoftClass
	 * @return if nothing checked than add this product
	 */
	private boolean isNotCheckeSoftwareClassesForThisSoftwareMaker(SearchRips searchRips, JSONArray arraySoftClass) {
		for (String softwareClass : searchRips.getSoftwareClass()) 
			if (arraySoftClass.contains(softwareClass))
				return false;
		
		return true;
	}

	/**
	 * 	Checking if type equipment no has checked position,
	 *  in this case we output all product in this checked type equip.
	 * @param searchRips
	 * @param arrayEquipment
	 * @return if nothing checked than add this product
	 */
	@SuppressWarnings("unchecked")
	private boolean isNotCheckedSoftwareForThisEquipment(SearchRips searchRips, JSONArray arrayEquipment) {

		Iterator<JSONObject> itSoftwareCheck = arrayEquipment.iterator();

		JSONArray checkedSoftware = new JSONArray();
		while (itSoftwareCheck.hasNext()) {
			checkedSoftware.add(itSoftwareCheck.next().get("name"));
		}

		int countSuitableSoftware = 0;
		for (String softwareMaker : searchRips.getSoftwareMaker()) {
			if (checkedSoftware.contains(softwareMaker))
				countSuitableSoftware++;
		}

		return (countSuitableSoftware <= 0) ? true:false;
	}

}
