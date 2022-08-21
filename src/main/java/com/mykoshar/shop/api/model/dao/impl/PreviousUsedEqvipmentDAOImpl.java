package com.mykoshar.shop.api.model.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;

import com.mykoshar.shop.api.model.entity.DigitalPrinter;
import com.mykoshar.shop.api.model.entity.Printer3D;
import com.mykoshar.shop.api.model.entity.Scanner;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mykoshar.shop.api.beans.ComponentsForControllers;
import com.mykoshar.shop.api.model.entity.Cutter;
import com.mykoshar.shop.api.model.entity.Laminator;
import com.mykoshar.shop.api.model.entity.Laser;
import com.mykoshar.shop.api.model.entity.Printer;
import com.mykoshar.shop.api.model.entity.search.SearchPUE;

@Repository
public class PreviousUsedEqvipmentDAOImpl {
	
	@Autowired
    ComponentsForControllers componets;

	private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
    @SuppressWarnings("unchecked")
	public ArrayList<JSONObject> listProduct(SearchPUE searchProduct) {
    	
    	ArrayList<JSONObject> result = new ArrayList<JSONObject>();
		Session session = this.sessionFactory.getCurrentSession();
		
		Criteria cr = session.createCriteria(Printer.class);
		searchProduct(searchProduct, cr, "typePrinter", searchProduct.getTypePrinter(), searchProduct.getPrinterEquipment());
		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Printer>(cr.list())));
		
		cr = session.createCriteria(Printer3D.class);
		searchProduct(searchProduct, cr, "typePrinter3D", searchProduct.getType3dPrinter(), searchProduct.getD3PrinterEquipment());
		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Printer3D>(cr.list())));
		
		cr = session.createCriteria(DigitalPrinter.class);
		searchProduct(searchProduct, cr, "typePrinter", searchProduct.getTypeDigitalPrinter(), searchProduct.getDigitalPrinterEquipment());
		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<DigitalPrinter>(cr.list())));
		
		cr = session.createCriteria(Laminator.class);
		searchProduct(searchProduct, cr, "typeProduct", searchProduct.getTypeLaminator(), searchProduct.getLaminatorEquipment());
		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Laminator>(cr.list())));
		
		cr = session.createCriteria(Laser.class);
		searchProduct(searchProduct, cr, "typeLaser", searchProduct.getTypeLaser(), searchProduct.getLaserEquipment());
		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Laser>(cr.list())));
		
		cr = session.createCriteria(Cutter.class);
		searchProduct(searchProduct, cr, "typeCutter", searchProduct.getTypeCutter(), searchProduct.getCutterEquipment());
		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Cutter>(cr.list())));
		
		cr = session.createCriteria(Scanner.class);
		searchProduct(searchProduct, cr, "typeProduct", searchProduct.getTypeScanner(), searchProduct.getScannerEquipment());
		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Scanner>(cr.list())));
		
        return result;
	}
    
    @SuppressWarnings("unchecked")
	public ArrayList<JSONObject> listSearchProduct(SearchPUE searchProduct) {
    	
    	ArrayList<JSONObject> result = new ArrayList<JSONObject>();
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = null;
		
		if ((searchProduct.getType() != null) && (searchProduct.getType().length > 0)) {
			for (String type : searchProduct.getType()) {

				if (type.equals("printer")) {
					cr = session.createCriteria(Printer.class);
					searchProduct(searchProduct, cr, "typePrinter", searchProduct.getTypePrinter(),searchProduct.getPrinterEquipment());
					result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Printer>(cr.list())));
				}

				if (type.equals("3d_printer")) {
					cr = session.createCriteria(Printer3D.class);
					searchProduct(searchProduct, cr, "typePrinter3D", searchProduct.getType3dPrinter(),searchProduct.getD3PrinterEquipment());
					result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Printer3D>(cr.list())));
				}

				if (type.equals("digital_printer")) {
					cr = session.createCriteria(DigitalPrinter.class);
					searchProduct(searchProduct, cr, "typePrinter", searchProduct.getTypeDigitalPrinter(),searchProduct.getDigitalPrinterEquipment());
					result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<DigitalPrinter>(cr.list())));
				}

				if (type.equals("laminator")) {
					cr = session.createCriteria(Laminator.class);
					searchProduct(searchProduct, cr, "typeProduct", searchProduct.getTypeLaminator(),searchProduct.getLaminatorEquipment());
					result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Laminator>(cr.list())));
				}

				if (type.equals("laser")) {
					cr = session.createCriteria(Laser.class);
					searchProduct(searchProduct, cr, "typeLaser", searchProduct.getTypeLaser(),searchProduct.getLaserEquipment());
					result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Laser>(cr.list())));
				}

				if (type.equals("cutter")) {
					cr = session.createCriteria(Cutter.class);
					searchProduct(searchProduct, cr, "typeCutter", searchProduct.getTypeCutter(),searchProduct.getCutterEquipment());
					result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Cutter>(cr.list())));
				}

				if (type.equals("scanner")) {
					cr = session.createCriteria(Scanner.class);
					searchProduct(searchProduct, cr, "typeProduct", searchProduct.getTypeScanner(),searchProduct.getScannerEquipment());
					result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Scanner>(cr.list())));
				}

			}
		} else {

			cr = session.createCriteria(Printer.class);
			searchProduct(searchProduct, cr, "typePrinter", searchProduct.getTypePrinter(),searchProduct.getPrinterEquipment());
			result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Printer>(cr.list())));

			cr = session.createCriteria(Printer3D.class);
			searchProduct(searchProduct, cr, "typePrinter3D", searchProduct.getType3dPrinter(),searchProduct.getD3PrinterEquipment());
			result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Printer3D>(cr.list())));

			cr = session.createCriteria(DigitalPrinter.class);
			searchProduct(searchProduct, cr, "typePrinter", searchProduct.getTypeDigitalPrinter(),searchProduct.getDigitalPrinterEquipment());
			result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<DigitalPrinter>(cr.list())));

			cr = session.createCriteria(Laminator.class);
			searchProduct(searchProduct, cr, "typeProduct", searchProduct.getTypeLaminator(),searchProduct.getLaminatorEquipment());
			result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Laminator>(cr.list())));

			cr = session.createCriteria(Laser.class);
			searchProduct(searchProduct, cr, "typeLaser", searchProduct.getTypeLaser(),searchProduct.getLaserEquipment());
			result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Laser>(cr.list())));

			cr = session.createCriteria(Cutter.class);
			searchProduct(searchProduct, cr, "typeCutter", searchProduct.getTypeCutter(),searchProduct.getCutterEquipment());
			result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Cutter>(cr.list())));

			cr = session.createCriteria(Scanner.class);
			searchProduct(searchProduct, cr, "typeProduct", searchProduct.getTypeScanner(),searchProduct.getScannerEquipment());
			result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Scanner>(cr.list())));
		}
        return result;
	}

    @SuppressWarnings("unchecked")
   	public ArrayList<JSONObject> listProductForHomePage() {
       	
       	ArrayList<JSONObject> result = new ArrayList<JSONObject>();
   		Session session = this.sessionFactory.getCurrentSession();
   		
   		Criteria cr = session.createCriteria(Printer.class);
   		searchProductForHomePage(cr);
   		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Printer>(cr.list())));
   		
   		cr = session.createCriteria(Printer3D.class);
   		searchProductForHomePage(cr);
   		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Printer3D>(cr.list())));
   		
   		cr = session.createCriteria(DigitalPrinter.class);
   		searchProductForHomePage(cr);
   		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<DigitalPrinter>(cr.list())));
   		
   		cr = session.createCriteria(Laminator.class);
   		searchProductForHomePage(cr);
   		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Laminator>(cr.list())));
   		
   		cr = session.createCriteria(Laser.class);
   		searchProductForHomePage(cr);
   		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Laser>(cr.list())));
   		
   		cr = session.createCriteria(Cutter.class);
   		searchProductForHomePage(cr);
   		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Cutter>(cr.list())));
   		
   		cr = session.createCriteria(Scanner.class);
   		searchProductForHomePage(cr);
   		result.addAll(componets.makeLightWeightCollectionOfProduct(new HashSet<Scanner>(cr.list())));
   		
           return result;
   	}
    
    @SuppressWarnings("unchecked")
   	public ArrayList<JSONObject> listAllProduct() {
       	
       	ArrayList<JSONObject> result = new ArrayList<JSONObject>();
   		Session session = this.sessionFactory.getCurrentSession();
   		
   		Criteria cr = session.createCriteria(Printer.class);
   		cr.add(Restrictions.eq("previouslyUsed","б/у"));
   		result.addAll(componets.showSimplestArrayWichCheckboxes(new HashSet<Printer>(cr.list()), "printer"));
   		
   		cr = session.createCriteria(Printer3D.class);
   		cr.add(Restrictions.eq("previouslyUsed","б/у"));
   		result.addAll(componets.showSimplestArrayWichCheckboxes(new HashSet<Printer3D>(cr.list()), "3d_printer"));
   		
   		cr = session.createCriteria(DigitalPrinter.class);
   		cr.add(Restrictions.eq("previouslyUsed","б/у"));
   		result.addAll(componets.showSimplestArrayWichCheckboxes(new HashSet<DigitalPrinter>(cr.list()), "digital_printer"));
   		
   		cr = session.createCriteria(Laminator.class);
   		cr.add(Restrictions.eq("previouslyUsed","б/у"));
   		result.addAll(componets.showSimplestArrayWichCheckboxes(new HashSet<Laminator>(cr.list()), "laminator"));
   		
   		cr = session.createCriteria(Laser.class);
   		cr.add(Restrictions.eq("previouslyUsed","б/у"));
   		result.addAll(componets.showSimplestArrayWichCheckboxes(new HashSet<Laser>(cr.list()), "laser"));
   		
   		cr = session.createCriteria(Cutter.class);
   		cr.add(Restrictions.eq("previouslyUsed","б/у"));
   		result.addAll(componets.showSimplestArrayWichCheckboxes(new HashSet<Cutter>(cr.list()), "cutter"));
   		
   		cr = session.createCriteria(Scanner.class);
   		cr.add(Restrictions.eq("previouslyUsed","б/у"));
   		result.addAll(componets.showSimplestArrayWichCheckboxes(new HashSet<Scanner>(cr.list()), "scanner"));
   		
           return result;
   	}
    
	private void searchProduct(SearchPUE searchProduct, Criteria cr, String typeProduct, String[] types, String[] equipments) {
		
		cr.add(Restrictions.eq("previouslyUsed","б/у"));
		
		if(searchProduct.getPrise0()!=searchProduct.getPrise1()){
			cr.add(Restrictions.between("prise", searchProduct.getPrise0(), searchProduct.getPrise1()));
		}
		
		if((types!= null) && (types.length > 0)){
		Junction typePrinterGroup = Restrictions.disjunction();
		for(String type : types){
			typePrinterGroup.add(Restrictions.eq(typeProduct, type));
		}
		cr.add(typePrinterGroup);
		}		
		
		if((equipments!= null) && (equipments.length > 0)){
		Junction equipmentGroup = Restrictions.disjunction();
		for(String equipmentManufacturer : equipments){
			equipmentGroup.add(Restrictions.eq("equipmentManufacturer",equipmentManufacturer));
		}
		cr.add(equipmentGroup);
		}
        
		cr.add(Restrictions.eq("showOnSite", true));
	}
	
	private void searchProductForHomePage(Criteria cr) {
		
		cr.add(Restrictions.eq("previouslyUsed","б/у")); 
		cr.add(Restrictions.eq("showOnSite", true));
		cr.add(Restrictions.eq("showOnHomePage", true));
	}
}
