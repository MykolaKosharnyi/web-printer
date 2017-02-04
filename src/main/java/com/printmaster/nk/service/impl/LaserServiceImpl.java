package com.printmaster.nk.service.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.SearchLasers;
import com.printmaster.nk.service.LaserService;

public class LaserServiceImpl implements LaserService {
	private ProductDAO<Laser, SearchLasers> productDAO;
	
	public void setProductDAO(ProductDAO<Laser,SearchLasers> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addProduct(Laser p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateProduct(Laser p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Laser> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Laser getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Laser> listSearchProducts(SearchLasers searchLasers) {
		return this.productDAO.listSearchProducts(searchLasers);
	}

	@Override
	@Transactional
	public Set<Laser> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<Laser> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	@Transactional
	public Set<Laser> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}
