package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.SearchRips;

public interface RipService {

	public long addRip(Rip p);
    public void updateRip(Rip p);
    public List<Rip> listRips();
    public Set<Rip> listShowOnSite();
    public Set<Rip> listShowOnHomePage();
    public Set<Rip> listSearchRips(SearchRips searchRips);
    public Rip getRipById(long id);
    public void removeRip(long id);
	
}
