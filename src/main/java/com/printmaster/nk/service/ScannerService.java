package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import com.printmaster.nk.model.Scanner;
import com.printmaster.nk.model.SearchScanners;

public interface ScannerService {

	public long addScanner(Scanner p);
    public void updateScanner(Scanner p);
    public List<Scanner> listScanners();
    public Set<Scanner> listShowOnSite();
    public Set<Scanner> listShowOnHomePage();
    public Set<Scanner> listSearchScanners(SearchScanners searchScanners);
    public Scanner getScannerById(long id);
    public void removeScanner(long id);
	
}
