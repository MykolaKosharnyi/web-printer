package com.printmaster.nk.dao;

import java.util.List;

import com.printmaster.nk.model.Printer;

public interface PrinterDAO {
	 
	public void addPrinter(Printer p);
    public void updatePrinter(Printer p);
    public List<Printer> listPrinters();
    public Printer getPrinterById(int id);
    public void removePrinter(int id);
     
}
