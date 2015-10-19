package com.printmaster.nk.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.printmaster.nk.model.Printer;

@Repository
public class PrinterDAOImpl implements PrinterDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(PrinterDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addPrinter(Printer p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Printer saved successfully, Printer Details="+p);
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
 
}
