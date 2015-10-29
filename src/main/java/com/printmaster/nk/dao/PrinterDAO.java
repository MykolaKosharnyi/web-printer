package com.printmaster.nk.dao;

import java.util.List;
import java.util.Set;

import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;

public interface PrinterDAO {
	 
	public int addPrinter(Printer p);
    public void updatePrinter(Printer p);
    public List<Printer> listPrinters();
    public Set<Printer> listSearchPrinters(SearchPrinters searchPrinters);
    public Printer getPrinterById(int id);
    public void removePrinter(int id);
     
}
