package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.model.SearchDigitalPrinters;

public interface DigitalPrinterService {
	 
    public long addPrinter(DigitalPrinter p);
    public void updatePrinter(DigitalPrinter p);
    public List<DigitalPrinter> listPrinters();
    public Set<DigitalPrinter> listShowOnSite();
    public Set<DigitalPrinter> listShowOnHomePage();
    public Set<DigitalPrinter> listSearchDigitalPrinters(SearchDigitalPrinters searchPrinters);
    public DigitalPrinter getPrinterById(long id);
    public void removePrinter(long id);
     
}
