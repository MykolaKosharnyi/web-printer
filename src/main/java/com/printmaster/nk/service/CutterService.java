package com.printmaster.nk.service;

import java.util.Set;

import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.modelwork.SearchCutters;

public interface CutterService {

	public long addCutter(Cutter p);
    public void updateCutter(Cutter p);
    public Set<Cutter> listCutters(String sortCriteria);
    public Set<Cutter> listShowOnSite();
    public Set<Cutter> listShowOnHomePage();
    public Set<Cutter> listSearchCutters(SearchCutters searchCutters);
    public Cutter getCutterById(long id);
    public void removeCutter(long id);
	
}
