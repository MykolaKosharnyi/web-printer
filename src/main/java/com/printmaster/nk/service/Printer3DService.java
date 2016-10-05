package com.printmaster.nk.service;

import java.util.Set;

import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.SearchPrinters3D;

public interface Printer3DService {
	 
    public long addPrinter3D(Printer3D p);
    public void updatePrinter3D(Printer3D p);
    public Set<Printer3D> listPrinters3D(String sortCriteria);
    public Set<Printer3D> listShowOnSite();
    public Set<Printer3D> listShowOnHomePage();
    public Set<Printer3D> listSearchPrinters3D(SearchPrinters3D searchPrinters);
    public Set<Printer3D> listSearchByPhrase(String phrase);
    public Printer3D getPrinter3DById(long id);
    public void removePrinter3D(long id);
     
}
