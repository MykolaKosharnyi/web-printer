package com.printmaster.nk.service;

import java.util.Set;

import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.modelwork.SearchDigitalPrinters;

public interface DigitalPrinterService {
	 
    public long addPrinter(DigitalPrinter p);
    public void updatePrinter(DigitalPrinter p);
    public Set<DigitalPrinter> listPrinters(String sortCriteria);
    public Set<DigitalPrinter> listShowOnSite();
    public Set<DigitalPrinter> listShowOnHomePage();
    public Set<DigitalPrinter> listSearchDigitalPrinters(SearchDigitalPrinters searchPrinters);
    public DigitalPrinter getPrinterById(long id);
    public void removePrinter(long id);
     
}
