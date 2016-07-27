package com.printmaster.nk.service;

import java.util.Set;

import com.printmaster.nk.model.Laser;
import com.printmaster.nk.modelwork.SearchLasers;

public interface LaserService {

	public long addLaser(Laser p);
    public void updateLaser(Laser p);
    public Set<Laser> listLasers(String sortCriteria);
    public Set<Laser> listShowOnSite();
    public Set<Laser> listShowOnHomePage();
    public Set<Laser> listSearchLasers(SearchLasers searchLasers);
    public Laser getLaserById(long id);
    public void removeLaser(long id);
	
}
