package com.printmaster.nk.dao;

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
    public Printer getPrinterById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Printer p = (Printer) session.load(Printer.class, new Integer(id));
        logger.info("Printer loaded successfully, Printer details="+p);
        return p;
    }
 
    @Override
    public void removePrinter(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Printer p = (Printer) session.load(Printer.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Printer deleted successfully, printer details="+p);
    }

//	@SuppressWarnings("unchecked")
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
		
		if(searchPrinters.getTypePrint()!= null){
		Junction typePrintGroup = Restrictions.disjunction();
		for(String typePrint : searchPrinters.getTypePrint()){
			typePrintGroup.add(Restrictions.eq("typePrint",typePrint));
		}
		cr.add(typePrintGroup);
		}
		
		if(searchPrinters.getFeed()!= null){
		Junction feedGroup = Restrictions.disjunction();
		for(String feed : searchPrinters.getFeed()){
			feedGroup.add(Restrictions.eq("feed",feed));
		}
		cr.add(feedGroup);
		}
		
		if(searchPrinters.getChromaticity()!= null){
		Junction chromaticityGroup = Restrictions.disjunction();
		for(String chromaticity : searchPrinters.getChromaticity()){
			chromaticityGroup.add(Restrictions.eq("chromaticity",chromaticity));
		}
		cr.add(chromaticityGroup);
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
		
		if(searchPrinters.getCompatibleInk()!= null){
		Junction compatibleInkGroup = Restrictions.disjunction();
		for(String compatibleInk : searchPrinters.getCompatibleInk()){
			compatibleInkGroup.add(Restrictions.eq("compatibleInk",compatibleInk));
		}
		cr.add(compatibleInkGroup);
		}
		
		if(searchPrinters.getTypeDrops()!= null){
		Junction typeDropsGroup = Restrictions.disjunction();
		for(String typeDrops : searchPrinters.getTypeDrops()){
			typeDropsGroup.add(Restrictions.eq("typeDrops",typeDrops));
		}
		cr.add(typeDropsGroup);
		}
		
		if(searchPrinters.getSizeDrops()!= null){
		Junction sizeDropsGroup = Restrictions.disjunction();
		for(String sizeDrops : searchPrinters.getSizeDrops()){
			sizeDropsGroup.add(Restrictions.eq("sizeDrops",sizeDrops));
		}
		cr.add(sizeDropsGroup);
		}
		
		if(searchPrinters.getSpeedPrint0()!=searchPrinters.getSpeedPrint1()){
			cr.add(Restrictions.between("speedPrint", searchPrinters.getSpeedPrint0(), searchPrinters.getSpeedPrint1()));
		}
		
		if(searchPrinters.getPrintResolution()!= null){
		Junction printResolutionGroup = Restrictions.disjunction();
		for(String printResolution : searchPrinters.getPrintResolution()){
			printResolutionGroup.add(Restrictions.eq("printResolution",printResolution));
		}
		cr.add(printResolutionGroup);
		}
		
		if(searchPrinters.getEquipmentManufacturer()!= null){
		Junction equipmentManufacturerGroup = Restrictions.disjunction();
		for(String equipmentManufacturer : searchPrinters.getEquipmentManufacturer()){
			equipmentManufacturerGroup.add(Restrictions.eq("equipmentManufacturer",equipmentManufacturer));
		}
		cr.add(equipmentManufacturerGroup);
		}
		
		if(searchPrinters.getInterfaceConnection()!= null){
		Junction interfaceConnectionGroup = Restrictions.disjunction();
		for(String interfaceConnection : searchPrinters.getInterfaceConnection()){
			interfaceConnectionGroup.add(Restrictions.eq("interfaceConnection",interfaceConnection));
		}
		cr.add(interfaceConnectionGroup);
		}
		
		if(searchPrinters.getMaximumMediaThickness60_0()!=searchPrinters.getMaximumMediaThickness60_1()){
			cr.add(Restrictions.between("maximumMediaThickness", searchPrinters.getMaximumMediaThickness60_0(), searchPrinters.getMaximumMediaThickness60_1()));
		}
		
		if(searchPrinters.getMaximumMediaThickness500_0()!=searchPrinters.getMaximumMediaThickness500_1()){
			cr.add(Restrictions.between("maximumMediaThickness", searchPrinters.getMaximumMediaThickness500_0(), searchPrinters.getMaximumMediaThickness500_1()));
		}
		
		if(searchPrinters.getMaximumWeightOfVehicle0()!=searchPrinters.getMaximumWeightOfVehicle1()){
			cr.add(Restrictions.between("maximumWeightOfVehicle", searchPrinters.getMaximumWeightOfVehicle0(), searchPrinters.getMaximumWeightOfVehicle1()));
		}
		
		if(searchPrinters.getRip()!= null){
		Junction ripGroup = Restrictions.disjunction();
		for(String rip : searchPrinters.getRip()){
			ripGroup.add(Restrictions.eq("rip",rip));
		}
		cr.add(ripGroup);
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

//		List<Printer> printerList = Collections.checkedList(cr.list(), Printer.class);
//		Set<Printer> result = new LinkedHashSet<Printer>(cr.list());
//		System.out.println("Size of array!!! -----   " + printerList.size());
//        for(Printer p : printerList){
//            logger.info("Printer List with searching::" + p);
//        }
        return new LinkedHashSet<Printer>(cr.list());
	}
 
}
