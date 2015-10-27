package com.printmaster.nk.service;

import java.util.List;

import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;

public interface PrinterService {
	 
    public int addPrinter(Printer p);
    public void updatePrinter(Printer p);
    public List<Printer> listPrinters();
    public List<Printer> listSearchPrinters(SearchPrinters searchPrinters);
    public Printer getPrinterById(int id);
    public void removePrinter(int id);
     
}
