package com.printmaster.nk.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.PrinterDAO;
import com.printmaster.nk.model.Printer;

@Service
public class PrinterServiceImpl implements PrinterService {
     
    private PrinterDAO printerDAO;
 
    public void setPrinterDAO(PrinterDAO printerDAO) {
        this.printerDAO = printerDAO;
    }
 
    @Override
    @Transactional
    public int addPrinter(Printer p) {
        return this.printerDAO.addPrinter(p);
    }
 
    @Override
    @Transactional
    public void updatePrinter(Printer p) {
        this.printerDAO.updatePrinter(p);
    }
 
    @Override
    @Transactional
    public List<Printer> listPrinters() {
        return this.printerDAO.listPrinters();
    }
 
    @Override
    @Transactional
    public Printer getPrinterById(int id) {
        return this.printerDAO.getPrinterById(id);
    }
 
    @Override
    @Transactional
    public void removePrinter(int id) {
        this.printerDAO.removePrinter(id);
    }
 
}
