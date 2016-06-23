package com.printmaster.nk.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;

@Repository
public class PrinterDAOImpl implements ProductDAO<Printer, SearchPrinters> {
     
    private Logger logger = Logger.getLogger(PrinterDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public long addProduct(Printer p) {
        Session session = this.sessionFactory.getCurrentSession();
        long id = (Long) session.save(p);
        logger.info("Printer saved successfully, Printer Details="+p);
        return id;
    }
 
    @Override
    public void updateProduct(Printer p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Printer updated successfully, Printer Details=" + p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public Set<Printer> listProducts(String sortCriteria) {
    	Session session = this.sessionFactory.getCurrentSession();
    	
		Criteria cr = session.createCriteria(Printer.class);
		cr.addOrder( Order.desc(sortCriteria));
        @SuppressWarnings("rawtypes")
		Set<Printer> printerList = new LinkedHashSet(cr.list());
        
        for(Printer p : printerList){
            logger.info("Printer List::" + p);
        }
        return printerList;
    }
 
    @Override
    public Printer getProductById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Printer p = (Printer) session.load(Printer.class, new Long(id));
        logger.info("Printer loaded successfully, Printer details="+p);
        return p;
    }
 
    @Override
    public void removeProduct(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Printer p = (Printer) session.load(Printer.class, new Long(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Printer deleted successfully, printer details="+p);
    }

	@SuppressWarnings("unchecked")
	@Override
	public Set<Printer> listSearchProducts(SearchPrinters searchPrinters) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Printer.class);
		
		if(searchPrinters.getPrise0()!=searchPrinters.getPrise1()){
			cr.add(Restrictions.between("prise", searchPrinters.getPrise0(), searchPrinters.getPrise1()));
		}
		
		if(searchPrinters.getTypePrinter()!= null){
		Junction typePrinterGroup = Restrictions.disjunction();
		for(String tp : searchPrinters.getTypePrinter()){
			typePrinterGroup.add(Restrictions.eq("typePrinter",tp));
		}
		cr.add(typePrinterGroup);
		}
		
		if((searchPrinters.getWeightPrintMM()!= null) || 
				((searchPrinters.getWeightPrintMMRangeUntil() > 0) && (searchPrinters.getWeightPrintMMRangeFrom() < searchPrinters.getWeightPrintMMRangeUntil()))
				){
		Junction weightPrintMMGroup = Restrictions.disjunction();
		
		if((searchPrinters.getWeightPrintMM()!= null))
		for(String wp : searchPrinters.getWeightPrintMM()){
			weightPrintMMGroup.add(Restrictions.eq("weightPrintMM",Integer.parseInt(wp)));
		}
		
		if((searchPrinters.getWeightPrintMMRangeUntil() > 0) && (searchPrinters.getWeightPrintMMRangeFrom() < searchPrinters.getWeightPrintMMRangeUntil())){
			weightPrintMMGroup.add(Restrictions.between("weightPrintMM", searchPrinters.getWeightPrintMMRangeFrom(), searchPrinters.getWeightPrintMMRangeUntil()));

			weightPrintMMGroup.add(Restrictions.between("inputFirstWeightPrintMM", searchPrinters.getWeightPrintMMRangeFrom(), searchPrinters.getWeightPrintMMRangeUntil()));

		}
		cr.add(weightPrintMMGroup);
		}
		
		if(searchPrinters.getPreviouslyUsed()!= null){
		Junction previouslyUsedGroup = Restrictions.disjunction();
		for(String pu : searchPrinters.getPreviouslyUsed()){
			previouslyUsedGroup.add(Restrictions.eq("previouslyUsed",pu));
		}
		cr.add(previouslyUsedGroup);
		}
		
		if(searchPrinters.getManufacturerPrinthead()!= null){
		Junction manufacturerPrintheadGroup = Restrictions.disjunction();
		for(String manufacturerPrinthead : searchPrinters.getManufacturerPrinthead()){
			manufacturerPrintheadGroup.add(Restrictions.eq("manufacturerPrinthead",manufacturerPrinthead));
		}
		cr.add(manufacturerPrintheadGroup);
		}
		
		ArrayList<String> arrayTypeOfPrintHead = checkTypeOfPringheadUsingSeries(searchPrinters.getTypeOfPrinthead(), searchPrinters.getTypeOfPrintheadSeries());
		if(arrayTypeOfPrintHead!= null){
		Junction typeOfPrintheadGroup = Restrictions.disjunction();
		for(String typeOfPrinthead : arrayTypeOfPrintHead){
			typeOfPrintheadGroup.add(Restrictions.eq("typeOfPrinthead",typeOfPrinthead));	
		}
		cr.add(typeOfPrintheadGroup);
		}
		
		if(searchPrinters.getTypePrint()!= null){
			Junction typePrintGroup = Restrictions.disjunction();
			for(String typePrint : searchPrinters.getTypePrint()){
				typePrintGroup.add(Restrictions.eq("typePrint",typePrint));
			}
			cr.add(typePrintGroup);
			}
		
		if( (searchPrinters.getSizeDropRangeUntil() > 0.1) 
				&& (searchPrinters.getSizeDropRangeFrom() < searchPrinters.getSizeDropRangeUntil())){
			Junction sizeDropGroup = Restrictions.disjunction();
			sizeDropGroup.add(Restrictions.le("sizeDropRangeFrom", searchPrinters.getSizeDropRangeFrom()));
			sizeDropGroup.add(Restrictions.between("sizeDropRangeFrom", searchPrinters.getSizeDropRangeFrom(), searchPrinters.getSizeDropRangeUntil()));
			sizeDropGroup.add(Restrictions.between("sizeDropRangeUntil", searchPrinters.getSizeDropRangeFrom(), searchPrinters.getSizeDropRangeUntil()));
			sizeDropGroup.add(Restrictions.between("sizeDropStatic", searchPrinters.getSizeDropRangeFrom(), searchPrinters.getSizeDropRangeUntil()));
			sizeDropGroup.add(Restrictions.between("valueOfNewTypeDrop", searchPrinters.getSizeDropRangeFrom(), searchPrinters.getSizeDropRangeUntil()));
			sizeDropGroup.add(Restrictions.ge("sizeDropRangeUntil", searchPrinters.getSizeDropRangeUntil()));
			
			cr.add(sizeDropGroup);
		}
		
		if(searchPrinters.getSpeedPrint0()!=searchPrinters.getSpeedPrint1()){
			Junction speedPrintGroup = Restrictions.disjunction();
			speedPrintGroup.add(Restrictions.between("speedPrintDraft", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrintFast", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrintNormal", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrintQuality", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrintHiQual", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrint1", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrint2", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrint3", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrint4", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			speedPrintGroup.add(Restrictions.between("speedPrint5", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
			
			cr.add(speedPrintGroup);
		}
		
		if(searchPrinters.getEquipmentManufacturer()!= null){
		Junction equipmentManufacturerGroup = Restrictions.disjunction();
		for(String equipmentManufacturer : searchPrinters.getEquipmentManufacturer()){
			equipmentManufacturerGroup.add(Restrictions.eq("equipmentManufacturer",equipmentManufacturer));
		}
		cr.add(equipmentManufacturerGroup);
		}
		
		if(searchPrinters.getMaximumMediaThickness60_0()!=searchPrinters.getMaximumMediaThickness60_1() ||
		   searchPrinters.getMaximumMediaThickness500_0()!=searchPrinters.getMaximumMediaThickness500_1()){
			Junction maximumMediaThicknessGroup = Restrictions.disjunction();
				maximumMediaThicknessGroup.add(Restrictions.between("maximumMediaThickness", searchPrinters.getMaximumMediaThickness60_0(), searchPrinters.getMaximumMediaThickness60_1()));
				maximumMediaThicknessGroup.add(Restrictions.between("maximumMediaThickness", searchPrinters.getMaximumMediaThickness500_0(), searchPrinters.getMaximumMediaThickness500_1()));
			cr.add(maximumMediaThicknessGroup);
			}
		
		if(searchPrinters.getMaximumWeightOfVehicle0()!=searchPrinters.getMaximumWeightOfVehicle1()){
			cr.add(Restrictions.between("maximumWeightOfVehicle", searchPrinters.getMaximumWeightOfVehicle0(), searchPrinters.getMaximumWeightOfVehicle1()));
		}
		
		if(searchPrinters.getAveragePowerConsumption0()!=searchPrinters.getAveragePowerConsumption1()){
			cr.add(Restrictions.between("averagePowerConsumption", searchPrinters.getAveragePowerConsumption0(), searchPrinters.getAveragePowerConsumption1()));
		}
		
		if(searchPrinters.getMaxPowerConsumption0()!=searchPrinters.getMaxPowerConsumption1()){
			cr.add(Restrictions.between("maxPowerConsumption", searchPrinters.getMaxPowerConsumption0(), searchPrinters.getMaxPowerConsumption1()));
		}
		
		if(!new Double(searchPrinters.getWeight0()).equals(searchPrinters.getWeight1())){
			cr.add(Restrictions.between("weight", searchPrinters.getWeight0(), searchPrinters.getWeight1()));
		}
		
		if(searchPrinters.getWidth0()!=searchPrinters.getWidth1()){
			cr.add(Restrictions.between("width", searchPrinters.getWidth0(), searchPrinters.getWidth1()));
		}
		
		if(searchPrinters.getHeigth0()!=searchPrinters.getHeigth1()){
			cr.add(Restrictions.between("heigth", searchPrinters.getHeigth0(), searchPrinters.getHeigth1()));
		}
		
		if(searchPrinters.getDepth0()!=searchPrinters.getDepth1()){
			cr.add(Restrictions.between("depth", searchPrinters.getDepth0(), searchPrinters.getDepth1()));
		}
        //List<Printer> printerList = cr.list();
		cr.add(Restrictions.eq("showOnSite", true));
		
		HashSet<Printer> result = new HashSet<Printer>(cr.list());
		
		Iterator<Printer> itPrinters = result.iterator();
		
		while(itPrinters.hasNext()){
			Printer currentPrinter = itPrinters.next();
			boolean isPrinterWeNeed = false;
			
			if (searchPrinters.getFeed()!=null)
			if (searchPrinters.getFeed().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getFeed()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getFeed()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}	
			
			if(!isPrinterWeNeed)
			if(searchPrinters.getChromaticity()!=null)
			if (searchPrinters.getChromaticity().length > 0 ) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getChromaticity()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getChromaticity()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}		
			
			if(!isPrinterWeNeed)
			if (searchPrinters.getCompatibleInk()!=null)
			if (searchPrinters.getCompatibleInk().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getCompatibleInk()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getCompatibleInk()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}	
			
			if(!isPrinterWeNeed)
			if (searchPrinters.getTypeDrops()!=null)
			if (searchPrinters.getTypeDrops().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getTypeDrops()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getTypeDrops()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}
			
			if(!isPrinterWeNeed)
			if((searchPrinters.getSizeDropRangeFrom() < 0.01) || (searchPrinters.getSizeDropRangeUntil() < 0.01) 
					|| (searchPrinters.getSizeDropRangeFrom() > searchPrinters.getSizeDropRangeUntil()))
			if (searchPrinters.getSizeDrops()!=null){
			if (searchPrinters.getSizeDrops().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getSizeDrops()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getSizeDrops()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}
		}
			
			if(!isPrinterWeNeed)
			if (searchPrinters.getPrintResolution()!=null)
			if (searchPrinters.getPrintResolution().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getPrintResolution()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getPrintResolution()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}
			
			if(!isPrinterWeNeed)
			if (searchPrinters.getInterfaceConnection()!=null)
			if (searchPrinters.getInterfaceConnection().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getInterfaceConnection()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getInterfaceConnection()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}
			
			if(!isPrinterWeNeed)
			if (searchPrinters.getRip()!=null)
			if (searchPrinters.getRip().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getRip()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getRip()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}
			
			if((!isPrinterWeNeed) && ((searchPrinters.getRip()!=null && searchPrinters.getRip().length > 0) ||
					(searchPrinters.getInterfaceConnection()!=null && searchPrinters.getInterfaceConnection().length > 0) ||
					(searchPrinters.getPrintResolution()!=null && searchPrinters.getPrintResolution().length > 0) || 
					(searchPrinters.getTypeDrops()!=null && searchPrinters.getTypeDrops().length > 0) ||
					(searchPrinters.getCompatibleInk()!=null && searchPrinters.getCompatibleInk().length > 0) ||
					(searchPrinters.getChromaticity()!=null &&searchPrinters.getChromaticity().length > 0) ||
					(searchPrinters.getFeed()!=null && searchPrinters.getFeed().length > 0) ||  
					(searchPrinters.getSizeDrops()!=null && searchPrinters.getSizeDrops().length > 0)))
				itPrinters.remove();
		}
		
        return result;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<String> checkTypeOfPringheadUsingSeries(String[] printHead, String[] printHeadSeries){
		
		ArrayList<String> printHeadArray = new ArrayList<String>();
		ArrayList<String> printHeadSeriesArray = new ArrayList<String>();
		
		if(printHead != null)
		printHeadArray = new ArrayList<String>(Arrays.asList(printHead));
		
		if(printHeadSeries != null)
		printHeadSeriesArray = new ArrayList<String>(Arrays.asList(printHeadSeries));

		JSONObject usedDate = null;
		try {
			usedDate = (JSONObject) new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
				
		JSONArray listPrintHeads = (JSONArray) usedDate.get("type_of_printhead");		
		Iterator<JSONObject> listEquipmentTypeHead = listPrintHeads.iterator();
				
		while(listEquipmentTypeHead.hasNext()){
			JSONArray heads =  (JSONArray) listEquipmentTypeHead.next().get("values");
			Iterator<JSONObject> arrayOfHeads = heads.iterator();
					
			while(arrayOfHeads.hasNext()){
				Object series = arrayOfHeads.next();
				if(!series.getClass().equals(String.class)){
					
					JSONObject headsWithSeries = (JSONObject) series;
					JSONArray finalArrayOfHead = (JSONArray) headsWithSeries.get("values");
					Iterator<String> arrayOfConcreatHeads = finalArrayOfHead.iterator();
					int countHeadsNotInArray = 0;
					
					while(arrayOfConcreatHeads.hasNext()){
						String concreatValue = arrayOfConcreatHeads.next();
						if(printHeadArray.contains(concreatValue)){
							if(printHeadSeriesArray.contains(headsWithSeries.get("series"))){} else {printHeadArray.remove(concreatValue);}
						} else {
							if(printHeadSeriesArray.contains(headsWithSeries.get("series"))){countHeadsNotInArray++;}
						}
					}
					
					if(countHeadsNotInArray == finalArrayOfHead.size()){
						printHeadArray.addAll(finalArrayOfHead);
					}
							
				}	
			}
		}

			
		
		return printHeadArray;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Printer> listShowOnSite() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Printer.class);
		cr.add(Restrictions.eq("showOnSite", true));
		
		HashSet<Printer> result = new HashSet<Printer>(cr.list());
        for(Printer p : result){
            logger.info("Printer List::"+p);
        }
        
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Printer> listShowOnHomePage() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Printer.class);
		cr.add(Restrictions.eq("showOnSite", true));
		cr.add(Restrictions.eq("showOnHomePage", true));
		
		HashSet<Printer> result = new HashSet<Printer>(cr.list());
        for(Printer p : result){
            logger.info("Printer List::"+p);
        }
        return result;
	}
 
}
