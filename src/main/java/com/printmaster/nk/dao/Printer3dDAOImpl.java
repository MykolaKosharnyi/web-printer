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

import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.SearchPrinters3D;

@Repository
public class Printer3dDAOImpl implements ProductDAO<Printer3D, SearchPrinters3D> {
     
	 private Logger logger = Logger.getLogger(Printer3dDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public long addProduct(Printer3D p) {
        Session session = this.sessionFactory.getCurrentSession();
       long id = (Long) session.save(p);
        logger.info("Printer3D saved successfully, Printer Details="+p);
        return id;
    }
 
    @Override
    public void updateProduct(Printer3D p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Printer3D updated successfully, Printer Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public Set<Printer3D> listProducts(String sortCriteria) {
        Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Printer3D.class);
		cr.addOrder( Order.desc(sortCriteria));
        @SuppressWarnings("rawtypes")
		Set<Printer3D> printerList = new LinkedHashSet(cr.list());
        for(Printer3D p : printerList){
            logger.info("Printer3D List::"+p);
        }
        return printerList;
    }
 
    @Override
    public Printer3D getProductById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Printer3D p = (Printer3D) session.load(Printer3D.class, new Long(id));
        logger.info("Printer3D loaded successfully, Printer3D details="+p);
        return p;
    }
 
    @Override
    public void removeProduct(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        Printer3D p = (Printer3D) session.load(Printer3D.class, new Long(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Printer3D deleted successfully, printer_3d details="+p);
    }

	@SuppressWarnings("unchecked")
	@Override
	public Set<Printer3D> listSearchProducts(SearchPrinters3D searchPrinters) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Printer3D.class);
		
		if(searchPrinters.getPrise0()!=searchPrinters.getPrise1()){
			cr.add(Restrictions.between("prise", searchPrinters.getPrise0(), searchPrinters.getPrise1()));
		}
		
		if(searchPrinters.getTypePrinter3D()!= null){
		Junction typePrinterGroup = Restrictions.disjunction();
		for(String tp : searchPrinters.getTypePrinter3D()){
			typePrinterGroup.add(Restrictions.eq("typePrinter3D",tp));
		}
		cr.add(typePrinterGroup);
		}		
		
		if(searchPrinters.getSizePrintableAreaX0()!=searchPrinters.getSizePrintableAreaX1()){
			cr.add(Restrictions.between("sizePrintableAreaX", searchPrinters.getSizePrintableAreaX0(), searchPrinters.getSizePrintableAreaX1()));
		}
		
		if(searchPrinters.getSizePrintableAreaY0()!=searchPrinters.getSizePrintableAreaY1()){
			cr.add(Restrictions.between("sizePrintableAreaY", searchPrinters.getSizePrintableAreaY0(), searchPrinters.getSizePrintableAreaY1()));
		}		
		
		if(searchPrinters.getSizePrintableAreaZ0()!=searchPrinters.getSizePrintableAreaZ1()){
			cr.add(Restrictions.between("sizePrintableAreaZ", searchPrinters.getSizePrintableAreaZ0(), searchPrinters.getSizePrintableAreaZ1()));
		}		
		
		if(searchPrinters.getTypeExtruder()!= null){
			Junction typeExtruderGroup = Restrictions.disjunction();
			for(String tp : searchPrinters.getTypeExtruder()){
				typeExtruderGroup.add(Restrictions.eq("typeExtruder",tp));
			}
			cr.add(typeExtruderGroup);
		}	
		
		if(searchPrinters.getExtruderNumber()!= null){
			Junction extruderNumberGroup = Restrictions.disjunction();
			for(int tp : searchPrinters.getExtruderNumber()){
				extruderNumberGroup.add(Restrictions.eq("extruderNumber",tp));
			}
			cr.add(extruderNumberGroup);
		}
		
		if(searchPrinters.getSpeedOfMovingThePrintHead0()!=searchPrinters.getSpeedOfMovingThePrintHead1()){
			cr.add(Restrictions.between("speedOfMovingThePrintHead", searchPrinters.getSpeedOfMovingThePrintHead0(), searchPrinters.getSpeedOfMovingThePrintHead1()));
		}
		
		if(searchPrinters.getPositioningAccuracyOfThePrintHead0()!=searchPrinters.getPositioningAccuracyOfThePrintHead1()){
			cr.add(Restrictions.between("positioningAccuracyOfThePrintHead", searchPrinters.getPositioningAccuracyOfThePrintHead0(), searchPrinters.getPositioningAccuracyOfThePrintHead1()));
		}
		
		if(searchPrinters.getAirflowModels()!= null){
			Junction airflowModelsGroup = Restrictions.disjunction();
			for(String tp : searchPrinters.getAirflowModels()){
				airflowModelsGroup.add(Restrictions.eq("airflowModels",tp));
			}
			cr.add(airflowModelsGroup);
			}
		
		if(searchPrinters.getNumberOfFansForBlowingModels0()!=searchPrinters.getNumberOfFansForBlowingModels1()){
			cr.add(Restrictions.between("numberOfFansForBlowingModels", searchPrinters.getNumberOfFansForBlowingModels0(), searchPrinters.getNumberOfFansForBlowingModels1()));
		}
		
		if(searchPrinters.getPrintTechnology()!= null){
		Junction typePrinterGroup = Restrictions.disjunction();
		for(String tp : searchPrinters.getPrintTechnology()){
			typePrinterGroup.add(Restrictions.eq("printTechnology",tp));
		}
		cr.add(typePrinterGroup);
		}		
		
		if(searchPrinters.getPreviouslyUsed()!= null){
		Junction typePrinterGroup = Restrictions.disjunction();
		for(String tp : searchPrinters.getPreviouslyUsed()){
			typePrinterGroup.add(Restrictions.eq("previouslyUsed",tp));
		}
		cr.add(typePrinterGroup);
		}		
		
		if(searchPrinters.getTypeOfPrinthead()!= null){
		Junction typePrinterGroup = Restrictions.disjunction();
		for(String tp : searchPrinters.getTypeOfPrinthead()){
			typePrinterGroup.add(Restrictions.eq("typeOfPrinthead",tp));
		}
		cr.add(typePrinterGroup);
		}		
		
		if(searchPrinters.getMeltingPointOfThePrintingMaterial0()!=searchPrinters.getMeltingPointOfThePrintingMaterial1()){
			cr.add(Restrictions.between("meltingPointOfThePrintingMaterial", searchPrinters.getMeltingPointOfThePrintingMaterial0(), searchPrinters.getMeltingPointOfThePrintingMaterial1()));
		}		
		
		if(searchPrinters.getSizeExtruder0()!=searchPrinters.getSizeExtruder1()){
			cr.add(Restrictions.between("sizeExtruder", searchPrinters.getSizeExtruder0(), searchPrinters.getSizeExtruder1()));
		}		
		
		if(searchPrinters.getSpeedPrint0()!=searchPrinters.getSpeedPrint1()){
			cr.add(Restrictions.between("speedPrint", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
		}		
		
		if(searchPrinters.getThicknessOfThePrintingLayer0()!=searchPrinters.getThicknessOfThePrintingLayer1()){
			cr.add(Restrictions.between("thicknessOfThePrintingLayer", searchPrinters.getThicknessOfThePrintingLayer0(), searchPrinters.getThicknessOfThePrintingLayer1()));
		}		
		
		if(searchPrinters.getMaximumWeightOfThePrintedModel0()!=searchPrinters.getMaximumWeightOfThePrintedModel1()){
			cr.add(Restrictions.between("maximumWeightOfThePrintedModel", searchPrinters.getMaximumWeightOfThePrintedModel0(), searchPrinters.getMaximumWeightOfThePrintedModel1()));
		}		
		
		if(searchPrinters.getEquipmentManufacturer()!= null){
		Junction typePrinterGroup = Restrictions.disjunction();
		for(String tp : searchPrinters.getEquipmentManufacturer()){
			typePrinterGroup.add(Restrictions.eq("equipmentManufacturer",tp));
		}
		cr.add(typePrinterGroup);
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
		
		cr.add(Restrictions.eq("showOnSite", true));
		HashSet<Printer3D> result = new HashSet<Printer3D>(cr.list());
	
		Iterator<Printer3D> itPrinters = result.iterator();
		
		while(itPrinters.hasNext()){
			Printer3D currentPrinter = itPrinters.next();
			boolean isPrinterWeNeed = false;
			
			if (searchPrinters.getChromaticity()!=null)
			if (searchPrinters.getChromaticity().length > 0 ) {
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
			
			if(!isPrinterWeNeed)
			if (searchPrinters.getMedia()!=null)
			if (searchPrinters.getMedia().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getMedia()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getMedia()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}	
			
			if(!isPrinterWeNeed)
			if(searchPrinters.getInterfaceConnection()!=null)
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
			if (searchPrinters.getTypesOfFiles()!=null)
			if (searchPrinters.getTypesOfFiles().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getTypesOfFiles()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getTypesOfFiles()) {
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
					(searchPrinters.getTypesOfFiles()!=null && searchPrinters.getTypesOfFiles().length > 0) || 
					(searchPrinters.getMedia()!=null && searchPrinters.getMedia().length > 0) ||
					(searchPrinters.getChromaticity()!=null && searchPrinters.getChromaticity().length > 0)))
				itPrinters.remove();
		}
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Printer3D> listShowOnSite() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Printer3D.class);
		cr.add(Restrictions.eq("showOnSite", true));
		
		HashSet<Printer3D> result = new HashSet<Printer3D>(cr.list());
        for(Printer3D p : result){
            logger.info("Printer3D List::" + p);
        }
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Printer3D> listShowOnHomePage() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(Printer3D.class);
		cr.add(Restrictions.eq("showOnSite", true));
		cr.add(Restrictions.eq("showOnHomePage", true));
		
		HashSet<Printer3D> result = new HashSet<Printer3D>(cr.list());
        for(Printer3D p : result){
            logger.info("Printer3D List::" + p);
        }
        return result;
	}
 
}

