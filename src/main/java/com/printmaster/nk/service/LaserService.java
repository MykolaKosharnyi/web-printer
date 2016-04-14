package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.SearchLasers;

public interface LaserService {

	public long addLaser(Laser p);
    public void updateLaser(Laser p);
    public List<Laser> listLasers();
    public Set<Laser> listShowOnSite();
    public Set<Laser> listShowOnHomePage();
    public Set<Laser> listSearchLasers(SearchLasers searchLasers);
    public Laser getLaserById(long id);
    public void removeLaser(long id);
	
}
