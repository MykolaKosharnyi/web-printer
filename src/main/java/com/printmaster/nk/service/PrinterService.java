package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;

public interface PrinterService {
	 
    public long addPrinter(Printer p);
    public void updatePrinter(Printer p);
    public List<Printer> listPrinters();
    public Set<Printer> listSearchPrinters(SearchPrinters searchPrinters);
    public Printer getPrinterById(long id);
    public void removePrinter(long id);
     
}
