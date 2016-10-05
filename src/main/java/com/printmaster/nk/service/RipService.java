package com.printmaster.nk.service;

import java.util.Set;

import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.SearchRips;

public interface RipService {

	public long addRip(Rip p);
    public void updateRip(Rip p);
    public Set<Rip> listRips(String sortCriteria);
    public Set<Rip> listShowOnSite();
    public Set<Rip> listShowOnHomePage();
    public Set<Rip> listSearchRips(SearchRips searchRips);
    public Set<Rip> listSearchByPhrase(String phrase);
    public Rip getRipById(long id);
    public void removeRip(long id);
	
}
