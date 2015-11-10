package com.printmaster.nk.dao;

import java.util.List;
import java.util.Set;

import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.SearchPrinters3D;

public interface Printer3dDAO {
	 
	public int addPrinter(Printer3D p);
    public void updatePrinter(Printer3D p);
    public List<Printer3D> listPrinters();
    public Set<Printer3D> listSearchPrinters(SearchPrinters3D searchPrinters);
    public Printer3D getPrinterById(long id);
    public void removePrinter(long id);
     
}