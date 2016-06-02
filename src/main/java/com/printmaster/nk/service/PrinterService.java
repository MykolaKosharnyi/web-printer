package com.printmaster.nk.service;

import java.util.Set;

import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;

public interface PrinterService {
	 
    public long addPrinter(Printer p);
    public void updatePrinter(Printer p);
    public Set<Printer> listPrinters(String sortCriteria);
    public Set<Printer> listShowOnSite();
    public Set<Printer> listShowOnHomePage();
    public Set<Printer> listSearchPrinters(SearchPrinters searchPrinters);
    public Printer getPrinterById(long id);
    public void removePrinter(long id);
     
}
