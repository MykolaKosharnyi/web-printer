package com.printmaster.nk.dao;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Junction;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;

@Repository
public class PrinterDAOImpl implements PrinterDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(PrinterDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public int addPrinter(Printer p) {
        Session session = this.sessionFactory.getCurrentSession();
       int id = (Integer) session.save(p);
        logger.info("Printer saved successfully, Printer Details="+p);
        return id;
    }
 
    @Override
    public void updatePrinter(Printer p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Printer updated successfully, Printer Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<Printer> listPrinters() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Printer> printerList = session.createQuery("from Printer").list();
        for(Printer p : printerList){
            logger.info("Printer List::"+p);
        }
        return printerList;
    }
 
    @Override
    public Printer getPrinterById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Printer p = (Printer) session.load(Printer.class, new Long(id));
        logger.info("Printer loaded successfully, Printer details="+p);
        return p;
    }
 
    @Override
    public void removePrinter(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Printer p = (Printer) session.load(Printer.class, new Long(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Printer deleted successfully, printer details="+p);
    }

	@SuppressWarnings("unchecked")
	@Override
	public Set<Printer> listSearchPrinters(SearchPrinters searchPrinters) {
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
		
		if(searchPrinters.getWeightPrintMM()!= null){
		Junction weightPrintMMGroup = Restrictions.disjunction();
		for(String wp : searchPrinters.getWeightPrintMM()){
			weightPrintMMGroup.add(Restrictions.eq("weightPrintMM",Integer.parseInt(wp)));
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
		
		if(searchPrinters.getTypeOfPrinthead()!= null){
		Junction typeOfPrintheadGroup = Restrictions.disjunction();
		for(String typeOfPrinthead : searchPrinters.getTypeOfPrinthead()){
			typeOfPrintheadGroup.add(Restrictions.eq("typeOfPrinthead",typeOfPrinthead));
		}
		cr.add(typeOfPrintheadGroup);
		}
		
		if(searchPrinters.getSpeedPrint0()!=searchPrinters.getSpeedPrint1()){
			cr.add(Restrictions.between("speedPrint", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
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
		
		if(searchPrinters.getMaxPowerConsumption0()!=searchPrinters.getMaxPowerConsumption1()){
			cr.add(Restrictions.between("maxPowerConsumption", searchPrinters.getMaxPowerConsumption0(), searchPrinters.getMaxPowerConsumption1()));
		}
		
		if(searchPrinters.getWeight0()!=searchPrinters.getWeight1()){
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
		
		LinkedHashSet<Printer> result = new LinkedHashSet<Printer>(cr.list());
		
		Iterator<Printer> itPrinters = result.iterator();
		
		while(itPrinters.hasNext()){
			Printer currentPrinter = itPrinters.next();
			
			if (searchPrinters.getTypePrint()!=null)
			if (searchPrinters.getTypePrint().length > 0 ) {
				boolean isPrinterWeNeed = false;
				print:
				for (String currentPrinterPropertyValue : currentPrinter.getTypePrint()) {
					for (String searchedPrinterPropertyValue : searchPrinters.getTypePrint()) {
						if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
							isPrinterWeNeed = true;
							break print;
						}
					}
				}
				if(!isPrinterWeNeed){
					itPrinters.remove();
					if(itPrinters.hasNext()){
						currentPrinter = itPrinters.next();
					}
				}
			} 
			
			if (searchPrinters.getFeed()!=null)
			if (searchPrinters.getFeed().length > 0) {
				if(itPrinters.hasNext()){
					boolean isPrinterWeNeed = false;
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getFeed()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getFeed()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
					if(!isPrinterWeNeed){
						itPrinters.remove();
						if(itPrinters.hasNext()){
							currentPrinter = itPrinters.next();
						}
					}
				}
			}	
			
			if(searchPrinters.getChromaticity()!=null)
			if (searchPrinters.getChromaticity().length > 0) {
				if(itPrinters.hasNext()){
					boolean isPrinterWeNeed = false;
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getChromaticity()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getChromaticity()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
					if(!isPrinterWeNeed){
						itPrinters.remove();
						if(itPrinters.hasNext()){
							currentPrinter = itPrinters.next();
						}
					}
				}
			}		
			
			if (searchPrinters.getCompatibleInk()!=null)
			if (searchPrinters.getCompatibleInk().length > 0) {
				if(itPrinters.hasNext()){
					boolean isPrinterWeNeed = false;
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getCompatibleInk()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getCompatibleInk()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
					if(!isPrinterWeNeed){
						itPrinters.remove();
						if(itPrinters.hasNext()){
							currentPrinter = itPrinters.next();
						}
					}
				}
			}	
			
			if (searchPrinters.getTypeDrops()!=null)
			if (searchPrinters.getTypeDrops().length > 0) {
				if(itPrinters.hasNext()){
					boolean isPrinterWeNeed = false;
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getTypeDrops()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getTypeDrops()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
					if(!isPrinterWeNeed){
						itPrinters.remove();
						if(itPrinters.hasNext()){
							currentPrinter = itPrinters.next();
						}
					}
				}
			}
			
			if (searchPrinters.getSizeDrops()!=null)
			if (searchPrinters.getSizeDrops().length > 0) {
				if(itPrinters.hasNext()){
					boolean isPrinterWeNeed = false;
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getSizeDrops()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getSizeDrops()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
					if(!isPrinterWeNeed){
						itPrinters.remove();
						if(itPrinters.hasNext()){
							currentPrinter = itPrinters.next();
						}
					}
				}
			}
			
			if (searchPrinters.getPrintResolution()!=null)
			if (searchPrinters.getPrintResolution().length > 0) {
				if(itPrinters.hasNext()){
					boolean isPrinterWeNeed = false;
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getPrintResolution()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getPrintResolution()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
					if(!isPrinterWeNeed){
						itPrinters.remove();
						if(itPrinters.hasNext()){
							currentPrinter = itPrinters.next();
						}
					}
				}
			}
			
			if (searchPrinters.getInterfaceConnection()!=null)
			if (searchPrinters.getInterfaceConnection().length > 0) {
				if(itPrinters.hasNext()){
					boolean isPrinterWeNeed = false;
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getInterfaceConnection()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getInterfaceConnection()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
					if(!isPrinterWeNeed){
						itPrinters.remove();
						if(itPrinters.hasNext()){
							currentPrinter = itPrinters.next();
						}
					}
				}
			}
			
			if (searchPrinters.getRip()!=null)
			if (searchPrinters.getRip().length > 0) {
				if(itPrinters.hasNext()){
					boolean isPrinterWeNeed = false;
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getRip()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getRip()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
					if(!isPrinterWeNeed){
						itPrinters.remove();
						if(itPrinters.hasNext()){
							currentPrinter = itPrinters.next();
						}
					}
				}
			}
		}
		
        return result;
	}
 
}
