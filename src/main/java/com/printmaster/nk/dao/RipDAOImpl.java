package com.printmaster.nk.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.SearchRips;

@Repository
public class RipDAOImpl implements ProductDAO<Rip, SearchRips> {

	private Logger logger = Logger.getLogger(RipDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public long addProduct(Rip c) {
		Session session = this.sessionFactory.getCurrentSession();
		long id = (Long) session.save(c);
		logger.info("Rip saved successfully, Rip Details=" + c);
		return id;
	}

    @SuppressWarnings("unchecked")
	@Override
	public Set<Rip> listSearchByPhrase(String phrase) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Rip.class);
		
		cr.add(Restrictions.eq("showOnSite", true));
		cr.add(Restrictions.like("name", phrase, MatchMode.ANYWHERE));
		
		return new HashSet<Rip>(cr.list());
	}
	
	@Override
	public void updateProduct(Rip c) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(c);
		logger.info("Rip updated successfully, Rip Details=" + c);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Set<Rip> listProducts(String sortCriteria) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Rip.class);
		cr.addOrder( Order.desc(sortCriteria));
		Set<Rip> ripList = new LinkedHashSet(cr.list());
		for (Rip c : ripList) {
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
		if (null != c) {
			session.delete(c);
		}
		logger.info("Rip deleted successfully, Rip details=" + c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Rip> listSearchProducts(SearchRips searchRips) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Rip.class);

		JSONArray usedDate = null;
		try {
			usedDate = (JSONArray) new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/images/rip.json"), "UTF-8"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}

		if (searchRips.getPrise0() != searchRips.getPrise1()) {
			cr.add(Restrictions.between("prise", searchRips.getPrise0(), searchRips.getPrise1()));
		}

		cr.add(Restrictions.eq("showOnSite", true));

		HashSet<Rip> result = new HashSet<Rip>(cr.list());

		Iterator<Rip> itRip = result.iterator();

		while (itRip.hasNext()) {
			Rip currentRip = itRip.next();
			boolean isRipWeNeed = false;

			if (searchRips.getTypeEquipment() != null) {
				if (searchRips.getTypeEquipment().length > 0) {

					rip: for (String typeEquipment : searchRips.getTypeEquipment()) {
						if (currentRip.getTypeEquipment().equals(typeEquipment)) {

							if (searchRips.getSoftwareMaker() != null) {
								if (searchRips.getSoftwareMaker().length > 0) {

									Iterator<JSONObject> typeEquipmetnJson = usedDate.iterator();

									while (typeEquipmetnJson.hasNext()) {
										JSONObject concreteEquipment = typeEquipmetnJson.next();
										if (concreteEquipment.get("type_equipment").equals(typeEquipment)) {

											JSONArray arrayEquipment = (JSONArray) concreteEquipment.get("software_maker");

											// Checking if type equipment no has checked position, in this case we
											// output all product in this checked type equip.
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

											if (countSuitableSoftware <= 0) {
												isRipWeNeed = true;
												break rip;
											}

											Iterator<JSONObject> itSoftware = arrayEquipment.iterator();
											while (itSoftware.hasNext()) {
												JSONObject concreteSoftware = itSoftware.next();

												for (String softwareMaker : searchRips.getSoftwareMaker()) {

													if (concreteSoftware.get("name").equals(softwareMaker)
														&& currentRip.getSoftwareMaker().equals(softwareMaker)) {

															if (searchRips.getSoftwareClass() != null) {
																if (searchRips.getSoftwareClass().length > 0) {
																	JSONArray arraySoftClass = (JSONArray) concreteSoftware.get("software_class");

																	// Check if software class has checked in place we need
																	int countSuitableSoftwareClass = 0;
																	for (String softwareClass : searchRips.getSoftwareClass()) {
																		if (arraySoftClass.contains(softwareClass))
																			countSuitableSoftwareClass++;
																	}

																	if (countSuitableSoftwareClass <= 0) {
																		isRipWeNeed = true;
																		break rip;
																	}

																			for (String softwareClass : searchRips.getSoftwareClass()) {
																				if (arraySoftClass.contains(softwareClass)
																						&& currentRip.getSoftwareClass().equals(softwareClass)) {
	
																					isRipWeNeed = true;
																					break rip;
																			}
																			}
																		
																	
																} else {
																	isRipWeNeed = true;
																	break rip;
																}
															} else {
																isRipWeNeed = true;
																break rip;
															}
															break rip;
														}
												}

											}
											break rip;
										}
									}
								} else {
									isRipWeNeed = true;
									break rip;
								}
							} else {
								isRipWeNeed = true;
								break rip;
							}
							break rip;
						}
					}
				} else {
					isRipWeNeed = true;
				}

			} else {
				isRipWeNeed = true;
			}

			if ((!isRipWeNeed))
				itRip.remove();
		}

		// if(searchRips.getSoftwareVersion()!= null){
		// Junction softwareVersionGroup = Restrictions.disjunction();
		// for(String softwareVersion : searchRips.getSoftwareVersion()){
		// softwareVersionGroup.add(Restrictions.eq("softwareVersion",softwareVersion));
		// }
		// cr.add(softwareVersionGroup);
		// }

		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Rip> listShowOnSite() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Rip.class);
		cr.add(Restrictions.eq("showOnSite", true));

		HashSet<Rip> result = new HashSet<Rip>(cr.list());
		for (Rip c : result) {
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
		for (Rip c : result) {
			logger.info("Rip list::" + c);
		}
		return result;
	}

}
