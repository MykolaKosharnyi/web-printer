package com.printmaster.nk.service;

import java.util.Set;

import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.modelwork.SearchLaminators;

public interface LaminatorService {

	public long addLaminator(Laminator p);
    public void updateLaminator(Laminator p);
    public Set<Laminator> listLaminators(String sortCriteria);
    public Set<Laminator> listShowOnSite();
    public Set<Laminator> listShowOnHomePage();
    public Set<Laminator> listSearchLaminators(SearchLaminators searchLaminators);
    public Laminator getLaminatorById(long id);
    public void removeLaminator(long id);
	
}
