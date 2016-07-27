package com.printmaster.nk.service;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.modelwork.SearchLaminators;

public class LaminatorServiceImpl implements LaminatorService {
	private ProductDAO<Laminator, SearchLaminators> productDAO;
	
	public void setProductDAO(ProductDAO<Laminator,SearchLaminators> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addLaminator(Laminator p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateLaminator(Laminator p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Laminator> listLaminators(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Laminator getLaminatorById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeLaminator(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Laminator> listSearchLaminators(SearchLaminators searchLaminators) {
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

}