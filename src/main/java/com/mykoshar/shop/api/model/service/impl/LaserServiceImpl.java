package com.mykoshar.shop.api.model.service.impl;

import java.util.Set;

import com.mykoshar.shop.api.model.dao.ProductDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.Laser;
import com.mykoshar.shop.api.model.entity.search.SearchLasers;
import com.mykoshar.shop.api.model.service.LaserService;

@Service
@Transactional
public class LaserServiceImpl implements LaserService {
	private ProductDAO<Laser, SearchLasers> productDAO;
	
	public void setProductDAO(ProductDAO<Laser,SearchLasers> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    public long addProduct(Laser p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(Laser p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<Laser> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public Laser getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	public Set<Laser> listSearchProducts(SearchLasers searchLasers) {
		return this.productDAO.listSearchProducts(searchLasers);
	}

	@Override
	public Set<Laser> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<Laser> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	public Set<Laser> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}
