package com.printmaster.nk.service.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.model.SearchLaminators;
import com.printmaster.nk.service.LaminatorService;

public class LaminatorServiceImpl implements LaminatorService {
	private ProductDAO<Laminator, SearchLaminators> productDAO;
	
	public void setProductDAO(ProductDAO<Laminator,SearchLaminators> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addProduct(Laminator p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateProduct(Laminator p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Laminator> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Laminator getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Laminator> listSearchProducts(SearchLaminators searchLaminators) {
		return this.productDAO.listSearchProducts(searchLaminators);
	}

	@Override
	@Transactional
	public Set<Laminator> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<Laminator> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	@Transactional
	public Set<Laminator> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}