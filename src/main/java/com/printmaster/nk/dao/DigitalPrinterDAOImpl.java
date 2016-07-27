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

import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.modelwork.SearchDigitalPrinters;

public class DigitalPrinterDAOImpl implements ProductDAO<DigitalPrinter, SearchDigitalPrinters> {
	private Logger logger = Logger.getLogger(DigitalPrinterDAOImpl.class);
	 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public long addProduct(DigitalPrinter p) {
        Session session = this.sessionFactory.getCurrentSession();
        long id = (Long) session.save(p);
        logger.info("Printer saved successfully, Printer Details="+p);
        return id;
    }
 
    @Override
    public void updateProduct(DigitalPrinter p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Printer updated successfully, Printer Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public Set<DigitalPrinter> listProducts(String sortCriteria) {
        Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(DigitalPrinter.class);
		cr.addOrder( Order.desc(sortCriteria));
        @SuppressWarnings("rawtypes")
		Set<DigitalPrinter> printerList = new LinkedHashSet(cr.list());
        for(DigitalPrinter p : printerList){
            logger.info("Printer List::"+p);
        }
        return printerList;
    }
 
    @Override
    public DigitalPrinter getProductById(long id) {
        Session session = this.sessionFactory.getCurrentSession();      
        DigitalPrinter p = (DigitalPrinter) session.load(DigitalPrinter.class, new Long(id));
        logger.info("Printer loaded successfully, Printer details="+p);
        return p;
    }
 
    @Override
    public void removeProduct(long id) {
        Session session = this.sessionFactory.getCurrentSession();
        DigitalPrinter p = (DigitalPrinter) session.load(DigitalPrinter.class, new Long(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Printer deleted successfully, printer details="+p);
    }

	@SuppressWarnings("unchecked")
	@Override
	public Set<DigitalPrinter> listSearchProducts(SearchDigitalPrinters searchPrinters) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(DigitalPrinter.class);
		
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
		
		if(searchPrinters.getPreviouslyUsed()!= null){
			Junction previouslyUsedGroup = Restrictions.disjunction();
			for(String pu : searchPrinters.getPreviouslyUsed()){
				previouslyUsedGroup.add(Restrictions.eq("previouslyUsed",pu));
			}
			cr.add(previouslyUsedGroup);
			}
		
		if(searchPrinters.getEquipmentManufacturer()!= null){
			Junction equipmentManufacturerGroup = Restrictions.disjunction();
			for(String equipmentManufacturer : searchPrinters.getEquipmentManufacturer()){
				equipmentManufacturerGroup.add(Restrictions.eq("equipmentManufacturer",equipmentManufacturer));
			}
			cr.add(equipmentManufacturerGroup);
			}
		
		if(searchPrinters.getDevice()!= null){
			Junction deviceGroup = Restrictions.disjunction();
			for(String device : searchPrinters.getDevice()){
				deviceGroup.add(Restrictions.eq("device",device));
			}
			cr.add(deviceGroup);
			}
		
		if(searchPrinters.getTypeOfPrinting()!= null){
			Junction typeOfPrintingGroup = Restrictions.disjunction();
			for(String typeOfPrinting : searchPrinters.getTypeOfPrinting()){
				typeOfPrintingGroup.add(Restrictions.eq("typeOfPrinting",typeOfPrinting));
			}
			cr.add(typeOfPrintingGroup);
			}
		
		if(searchPrinters.getPrintTechnology()!= null){
			Junction printTechnologyGroup = Restrictions.disjunction();
			for(String printTechnology : searchPrinters.getPrintTechnology()){
				printTechnologyGroup.add(Restrictions.eq("printTechnology",printTechnology));
			}
			cr.add(printTechnologyGroup);
			}
		
		if(searchPrinters.getAccommodation()!= null){
			Junction accommodationGroup = Restrictions.disjunction();
			for(String accommodation : searchPrinters.getAccommodation()){
				accommodationGroup.add(Restrictions.eq("accommodation",accommodation));
			}
			cr.add(accommodationGroup);
			}
		
		if(searchPrinters.getApplicationArea()!= null){
			Junction applicationAreaGroup = Restrictions.disjunction();
			for(String applicationArea : searchPrinters.getApplicationArea()){
				applicationAreaGroup.add(Restrictions.eq("applicationArea",applicationArea));
			}
			cr.add(applicationAreaGroup);
			}
		
		if(searchPrinters.getNumberOfPagesPerMonth0()!=searchPrinters.getNumberOfPagesPerMonth1()){
			cr.add(Restrictions.between("numberOfPagesPerMonth", searchPrinters.getNumberOfPagesPerMonth0(), searchPrinters.getNumberOfPagesPerMonth1()));
		}
		
		if(searchPrinters.getMaximumFormat()!= null){
			Junction maximumFormatGroup = Restrictions.disjunction();
			for(String maximumFormat : searchPrinters.getMaximumFormat()){
				maximumFormatGroup.add(Restrictions.eq("maximumFormat",maximumFormat));
			}
			cr.add(maximumFormatGroup);
			}
		
		if(searchPrinters.getAutomaticTwoSidedPrinting()!= null){
			Junction automaticTwoSidedPrintingGroup = Restrictions.disjunction();
			for(String automaticTwoSidedPrinting : searchPrinters.getAutomaticTwoSidedPrinting()){
				automaticTwoSidedPrintingGroup.add(Restrictions.eq("automaticTwoSidedPrinting",automaticTwoSidedPrinting));
			}
			cr.add(automaticTwoSidedPrintingGroup);
			}
		
		if(searchPrinters.getTheMaximumResolutionForColorPrinting()!= null){
			Junction theMaximumResolutionForColorPrintingGroup = Restrictions.disjunction();
			for(String theMaximumResolutionForColorPrinting : searchPrinters.getTheMaximumResolutionForColorPrinting()){
				theMaximumResolutionForColorPrintingGroup.add(Restrictions.eq("theMaximumResolutionForColorPrinting",theMaximumResolutionForColorPrinting));
			}
			cr.add(theMaximumResolutionForColorPrintingGroup);
			}
		
		if(searchPrinters.getTheMaximumResolutionForBWPrinting()!= null){
			Junction theMaximumResolutionForBWPrintingGroup = Restrictions.disjunction();
			for(String theMaximumResolutionForBWPrinting : searchPrinters.getTheMaximumResolutionForBWPrinting()){
				theMaximumResolutionForBWPrintingGroup.add(Restrictions.eq("theMaximumResolutionForBWPrinting",theMaximumResolutionForBWPrinting));
			}
			cr.add(theMaximumResolutionForBWPrintingGroup);
			}
		
		if(searchPrinters.getWarmUpTime0()!=searchPrinters.getWarmUpTime1()){
			cr.add(Restrictions.between("warmUpTime", searchPrinters.getWarmUpTime0(), searchPrinters.getWarmUpTime1()));
		}
		
		if(searchPrinters.getSpeedPrintBW0()!=searchPrinters.getSpeedPrintBW1()){
			Junction speedPrintGroup = Restrictions.disjunction();
			speedPrintGroup.add(Restrictions.between("speedPrintBWA4", searchPrinters.getSpeedPrintBW0(), searchPrinters.getSpeedPrintBW1()));
			speedPrintGroup.add(Restrictions.between("speedPrintBWA3", searchPrinters.getSpeedPrintBW0(), searchPrinters.getSpeedPrintBW1()));
			speedPrintGroup.add(Restrictions.between("speedPrintBWA2", searchPrinters.getSpeedPrintBW0(), searchPrinters.getSpeedPrintBW1()));
			speedPrintGroup.add(Restrictions.between("speedPrintBWA1", searchPrinters.getSpeedPrintBW0(), searchPrinters.getSpeedPrintBW1()));
			speedPrintGroup.add(Restrictions.between("speedPrintBWA0", searchPrinters.getSpeedPrintBW0(), searchPrinters.getSpeedPrintBW1()));
			
			cr.add(speedPrintGroup);
		}
		
		if(searchPrinters.getSpeedPrintColor0()!=searchPrinters.getSpeedPrintColor1()){
			Junction speedPrintGroup = Restrictions.disjunction();
			speedPrintGroup.add(Restrictions.between("speedPrintColorA4", searchPrinters.getSpeedPrintColor0(), searchPrinters.getSpeedPrintColor1()));
			speedPrintGroup.add(Restrictions.between("speedPrintColorA3", searchPrinters.getSpeedPrintColor0(), searchPrinters.getSpeedPrintColor1()));
			speedPrintGroup.add(Restrictions.between("speedPrintColorA2", searchPrinters.getSpeedPrintColor0(), searchPrinters.getSpeedPrintColor1()));
			speedPrintGroup.add(Restrictions.between("speedPrintColorA1", searchPrinters.getSpeedPrintColor0(), searchPrinters.getSpeedPrintColor1()));
			speedPrintGroup.add(Restrictions.between("speedPrintColorA0", searchPrinters.getSpeedPrintColor0(), searchPrinters.getSpeedPrintColor1()));
			
			cr.add(speedPrintGroup);
		}
		
		if(searchPrinters.getSpeedCopyBW0()!=searchPrinters.getSpeedCopyBW1()){
			Junction speedPrintGroup = Restrictions.disjunction();
			speedPrintGroup.add(Restrictions.between("speedCopyBWA4", searchPrinters.getSpeedCopyBW0(), searchPrinters.getSpeedCopyBW1()));
			speedPrintGroup.add(Restrictions.between("speedCopyBWA3", searchPrinters.getSpeedCopyBW0(), searchPrinters.getSpeedCopyBW1()));
			speedPrintGroup.add(Restrictions.between("speedCopyBWA2", searchPrinters.getSpeedCopyBW0(), searchPrinters.getSpeedCopyBW1()));
			speedPrintGroup.add(Restrictions.between("speedCopyBWA1", searchPrinters.getSpeedCopyBW0(), searchPrinters.getSpeedCopyBW1()));
			speedPrintGroup.add(Restrictions.between("speedCopyBWA0", searchPrinters.getSpeedCopyBW0(), searchPrinters.getSpeedCopyBW1()));
			
			cr.add(speedPrintGroup);
		}
		
		if(searchPrinters.getSpeedCopyColor0()!=searchPrinters.getSpeedCopyColor1()){
			Junction speedPrintGroup = Restrictions.disjunction();
			speedPrintGroup.add(Restrictions.between("speedCopyColorA4", searchPrinters.getSpeedCopyColor0(), searchPrinters.getSpeedCopyColor1()));
			speedPrintGroup.add(Restrictions.between("speedCopyColorA3", searchPrinters.getSpeedCopyColor0(), searchPrinters.getSpeedCopyColor1()));
			speedPrintGroup.add(Restrictions.between("speedCopyColorA2", searchPrinters.getSpeedCopyColor0(), searchPrinters.getSpeedCopyColor1()));
			speedPrintGroup.add(Restrictions.between("speedCopyColorA1", searchPrinters.getSpeedCopyColor0(), searchPrinters.getSpeedCopyColor1()));
			speedPrintGroup.add(Restrictions.between("speedCopyColorA0", searchPrinters.getSpeedCopyColor0(), searchPrinters.getSpeedCopyColor1()));
			
			cr.add(speedPrintGroup);
		}
		
		if(searchPrinters.getFirstPrintColor0()!=searchPrinters.getFirstPrintColor1()){
			cr.add(Restrictions.between("firstPrintColor", searchPrinters.getFirstPrintColor0(), searchPrinters.getFirstPrintColor1()));
		}
		
		if(searchPrinters.getFirstPrintBW0()!=searchPrinters.getFirstPrintBW1()){
			cr.add(Restrictions.between("firstPrintBW", searchPrinters.getFirstPrintBW0(), searchPrinters.getFirstPrintBW1()));
		}
		
		if(searchPrinters.getTheMaximumSizeOfTheOriginal()!= null){
			Junction theMaximumSizeOfTheOriginalGroup = Restrictions.disjunction();
			for(String theMaximumSizeOfTheOriginal : searchPrinters.getTheMaximumSizeOfTheOriginal()){
				theMaximumSizeOfTheOriginalGroup.add(Restrictions.eq("theMaximumSizeOfTheOriginal",theMaximumSizeOfTheOriginal));
			}
			cr.add(theMaximumSizeOfTheOriginalGroup);
			}
		
		if(searchPrinters.getMaximumScanSize()!= null){
			Junction maximumScanSizeGroup = Restrictions.disjunction();
			for(String maximumScanSize : searchPrinters.getMaximumScanSize()){
				maximumScanSizeGroup.add(Restrictions.eq("maximumScanSize",maximumScanSize));
			}
			cr.add(maximumScanSizeGroup);
			}
		
		if(searchPrinters.getScannerResolution()!= null){
			Junction scannerResolutionGroup = Restrictions.disjunction();
			for(String scannerResolution : searchPrinters.getScannerResolution()){
				scannerResolutionGroup.add(Restrictions.eq("scannerResolution",scannerResolution));
			}
			cr.add(scannerResolutionGroup);
			}
		
		if(searchPrinters.getScanSpeedColor0()!=searchPrinters.getScanSpeedColor1()){
			cr.add(Restrictions.between("scanSpeedColor", searchPrinters.getScanSpeedColor0(), searchPrinters.getScanSpeedColor1()));
		}
		
		if(searchPrinters.getScanSpeedBW0()!=searchPrinters.getScanSpeedBW1()){
			cr.add(Restrictions.between("scanSpeedBW", searchPrinters.getScanSpeedBW0(), searchPrinters.getScanSpeedBW1()));
		}
		
		if(searchPrinters.getSendingImagesByEmail()!= null){
			Junction sendingImagesByEmailGroup = Restrictions.disjunction();
			for(String sendingImagesByEmail : searchPrinters.getSendingImagesByEmail()){
				sendingImagesByEmailGroup.add(Restrictions.eq("sendingImagesByEmail",sendingImagesByEmail));
			}
			cr.add(sendingImagesByEmailGroup);
			}
		
		if(searchPrinters.getMaximumResolutionCopierBW()!= null){
			Junction maximumResolutionCopierBWGroup = Restrictions.disjunction();
			for(String maximumResolutionCopierBW : searchPrinters.getMaximumResolutionCopierBW()){
				maximumResolutionCopierBWGroup.add(Restrictions.eq("maximumResolutionCopierBW",maximumResolutionCopierBW));
			}
			cr.add(maximumResolutionCopierBWGroup);
			}
		
		if(searchPrinters.getFirstCopyOutTime0()!=searchPrinters.getFirstCopyOutTime1()){
			cr.add(Restrictions.between("firstCopyOutTime", searchPrinters.getFirstCopyOutTime0(), searchPrinters.getFirstCopyOutTime1()));
		}
		
		if(searchPrinters.getZooming0()!=searchPrinters.getZooming1()){
			cr.add(Restrictions.between("zooming", searchPrinters.getZooming0(), searchPrinters.getZooming1()));
		}
		
		if(searchPrinters.getStepZoom0()!=searchPrinters.getStepZoom1()){
			cr.add(Restrictions.between("stepZoom", searchPrinters.getStepZoom0(), searchPrinters.getStepZoom1()));
		}
		
		if(searchPrinters.getTheMaximumNumberOfCopiesPerCycle0()!=searchPrinters.getTheMaximumNumberOfCopiesPerCycle1()){
			cr.add(Restrictions.between("theMaximumNumberOfCopiesPerCycle", searchPrinters.getTheMaximumNumberOfCopiesPerCycle0(), searchPrinters.getTheMaximumNumberOfCopiesPerCycle1()));
		}
		
		if(searchPrinters.getPaperFeedStandart0()!=searchPrinters.getPaperFeedStandart1()){
			cr.add(Restrictions.between("paperFeedStandart", searchPrinters.getPaperFeedStandart0(), searchPrinters.getPaperFeedStandart1()));
		}
		
		if(searchPrinters.getPaperFeedMax0()!=searchPrinters.getPaperFeedMax1()){
			cr.add(Restrictions.between("paperFeedMax", searchPrinters.getPaperFeedMax0(), searchPrinters.getPaperFeedMax1()));
		}
		
		if(searchPrinters.getPaperOutputStandart0()!=searchPrinters.getPaperOutputStandart1()){
			cr.add(Restrictions.between("paperOutputStandart", searchPrinters.getPaperOutputStandart0(), searchPrinters.getPaperOutputStandart1()));
		}
		
		if(searchPrinters.getPaperOutputMax0()!=searchPrinters.getPaperOutputMax1()){
			cr.add(Restrictions.between("paperOutputMax", searchPrinters.getPaperOutputMax0(), searchPrinters.getPaperOutputMax1()));
		}
		
		if(searchPrinters.getTheCapacityOfTheBypassTray0()!=searchPrinters.getTheCapacityOfTheBypassTray1()){
			cr.add(Restrictions.between("theCapacityOfTheBypassTray", searchPrinters.getTheCapacityOfTheBypassTray0(), searchPrinters.getTheCapacityOfTheBypassTray1()));
		}
		
		if(searchPrinters.getElectronicSorting()!= null){
			Junction electronicSortingGroup = Restrictions.disjunction();
			for(String electronicSorting : searchPrinters.getElectronicSorting()){
				electronicSortingGroup.add(Restrictions.eq("electronicSorting",electronicSorting));
			}
			cr.add(electronicSortingGroup);
			}

		if(searchPrinters.getStapler()!= null){
			Junction staplerGroup = Restrictions.disjunction();
			for(String stapler : searchPrinters.getStapler()){
				staplerGroup.add(Restrictions.eq("stapler",stapler));
			}
			cr.add(staplerGroup);
			}
		
		if(searchPrinters.getPaperDensity0()!=searchPrinters.getPaperDensity1()){
			cr.add(Restrictions.between("paperDensity", searchPrinters.getPaperDensity0(), searchPrinters.getPaperDensity1()));
		}
		
		if(searchPrinters.getResourceDeveloper0()!=searchPrinters.getResourceDeveloper1()){
			cr.add(Restrictions.between("resourceDeveloper", searchPrinters.getResourceDeveloper0(), searchPrinters.getResourceDeveloper1()));
		}
		
		if(searchPrinters.getResourceDrum0()!=searchPrinters.getResourceDrum1()){
			cr.add(Restrictions.between("resourceDrum", searchPrinters.getResourceDrum0(), searchPrinters.getResourceDrum1()));
		}
		
		if(searchPrinters.getResourceBWCartridgeToner0()!=searchPrinters.getResourceBWCartridgeToner1()){
			cr.add(Restrictions.between("resourceBWCartridgeToner", searchPrinters.getResourceBWCartridgeToner0(), searchPrinters.getResourceBWCartridgeToner1()));
		}
		
		if(searchPrinters.getNumberOfCartridges0()!=searchPrinters.getNumberOfCartridges1()){
			cr.add(Restrictions.between("numberOfCartridges", searchPrinters.getNumberOfCartridges0(), searchPrinters.getNumberOfCartridges1()));
		}
		
		if(searchPrinters.getMemory0()!=searchPrinters.getMemory1()){
			cr.add(Restrictions.between("memory", searchPrinters.getMemory0(), searchPrinters.getMemory1()));
		}
		
		if(searchPrinters.getHardDriveCapacity0()!=searchPrinters.getHardDriveCapacity1()){
			cr.add(Restrictions.between("hardDriveCapacity", searchPrinters.getHardDriveCapacity0(), searchPrinters.getHardDriveCapacity1()));
		}
		
		if(searchPrinters.getDirectPrinting()!= null){
			Junction directPrintingGroup = Restrictions.disjunction();
			for(String directPrinting : searchPrinters.getDirectPrinting()){
				directPrintingGroup.add(Restrictions.eq("directPrinting",directPrinting));
			}
			cr.add(directPrintingGroup);
			}

		if(searchPrinters.getWebInterface()!= null){
			Junction webInterfaceGroup = Restrictions.disjunction();
			for(String webInterface : searchPrinters.getWebInterface()){
				webInterfaceGroup.add(Restrictions.eq("webInterface",webInterface));
			}
			cr.add(webInterfaceGroup);
			}

		if(searchPrinters.getSupportPostScript()!= null){
			Junction supportPostScriptGroup = Restrictions.disjunction();
			for(String supportPostScript : searchPrinters.getSupportPostScript()){
				supportPostScriptGroup.add(Restrictions.eq("supportPostScript",supportPostScript));
			}
			cr.add(supportPostScriptGroup);
			}
		
		if(searchPrinters.getTheNumberOfInstalledPostScriptFonts0()!=searchPrinters.getTheNumberOfInstalledPostScriptFonts1()){
			cr.add(Restrictions.between("theNumberOfInstalledPostScriptFonts", searchPrinters.getTheNumberOfInstalledPostScriptFonts0(), searchPrinters.getTheNumberOfInstalledPostScriptFonts1()));
		}
		
		if(searchPrinters.getTheNumberOfInstalledPCLFonts0()!=searchPrinters.getTheNumberOfInstalledPCLFonts1()){
			cr.add(Restrictions.between("theNumberOfInstalledPCLFonts", searchPrinters.getTheNumberOfInstalledPCLFonts0(), searchPrinters.getTheNumberOfInstalledPCLFonts1()));
		}
		
		if(searchPrinters.getDisplayInformation()!= null){
			Junction displayInformationGroup = Restrictions.disjunction();
			for(String displayInformation : searchPrinters.getDisplayInformation()){
				displayInformationGroup.add(Restrictions.eq("displayInformation",displayInformation));
			}
			cr.add(displayInformationGroup);
			}
		
		if(!new Double(searchPrinters.getDisplaySize0()).equals(searchPrinters.getDisplaySize1())){
			cr.add(Restrictions.between("displaySize", searchPrinters.getDisplaySize0(), searchPrinters.getDisplaySize1()));
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
		
		HashSet<DigitalPrinter> result = new HashSet<DigitalPrinter>(cr.list());
		
		Iterator<DigitalPrinter> itPrinters = result.iterator();
		
		while(itPrinters.hasNext()){
			DigitalPrinter currentPrinter = itPrinters.next();
			boolean isPrinterWeNeed = false;
			
			if (searchPrinters.getPrintingOn()!=null)
			if (searchPrinters.getPrintingOn().length > 0) {
				print:
				for (String currentPrinterPropertyValue : currentPrinter.getPrintingOn()) {
					for (String searchedPrinterPropertyValue : searchPrinters.getPrintingOn()) {
						if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
							isPrinterWeNeed = true;
							break print;
						}
					}
				}
			} 
			
			if(!isPrinterWeNeed)
			if (searchPrinters.getInterfaces()!=null)
			if (searchPrinters.getInterfaces().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getInterfaces()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getInterfaces()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}	
			
			if(!isPrinterWeNeed)
			if(searchPrinters.getSupport()!=null)
			if (searchPrinters.getSupport().length > 0 ) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getSupport()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getSupport()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}		
			
			if(!isPrinterWeNeed)
			if (searchPrinters.getoSSupport()!=null)
			if (searchPrinters.getoSSupport().length > 0) {
				if(itPrinters.hasNext()){
					print:
					for (String currentPrinterPropertyValue : currentPrinter.getoSSupport()) {
						for (String searchedPrinterPropertyValue : searchPrinters.getoSSupport()) {
							if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
								isPrinterWeNeed = true;
								break print;
							}
						}
					}
				}
			}	
			
			if(!isPrinterWeNeed)
				if (searchPrinters.getScannerType()!=null)
				if (searchPrinters.getScannerType().length > 0) {
					if(itPrinters.hasNext()){
						print:
						for (String currentPrinterPropertyValue : currentPrinter.getScannerType()) {
							for (String searchedPrinterPropertyValue : searchPrinters.getScannerType()) {
								if (currentPrinterPropertyValue.equals(searchedPrinterPropertyValue)) {
									isPrinterWeNeed = true;
									break print;
								}
							}
						}
					}
				}
			
			if((!isPrinterWeNeed) && ((searchPrinters.getPrintingOn()!=null && searchPrinters.getPrintingOn().length > 0) ||
					(searchPrinters.getInterfaces()!=null && searchPrinters.getInterfaces().length > 0) ||
					(searchPrinters.getSupport()!=null && searchPrinters.getSupport().length > 0) || 
					(searchPrinters.getScannerType()!=null && searchPrinters.getScannerType().length > 0) ||
					(searchPrinters.getoSSupport()!=null && searchPrinters.getoSSupport().length > 0) ))
				itPrinters.remove();
		}
		
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<DigitalPrinter> listShowOnSite() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(DigitalPrinter.class);
		cr.add(Restrictions.eq("showOnSite", true));
		
		HashSet<DigitalPrinter> result = new HashSet<DigitalPrinter>(cr.list());
        for(DigitalPrinter p : result){
            logger.info("Printer List::"+p);
        }
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<DigitalPrinter> listShowOnHomePage() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria cr = session.createCriteria(DigitalPrinter.class);
		cr.add(Restrictions.eq("showOnSite", true));
		cr.add(Restrictions.eq("showOnHomePage", true));
		
		HashSet<DigitalPrinter> result = new HashSet<DigitalPrinter>(cr.list());
        for(DigitalPrinter p : result){
            logger.info("Printer List::"+p);
        }
        return result;
	}
 
}

