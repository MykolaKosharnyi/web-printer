package com.mykoshar.shop.api.model.service.impl;

import java.util.Set;

import com.mykoshar.shop.api.model.dao.ProductDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.Laminator;
import com.mykoshar.shop.api.model.entity.search.SearchLaminators;
import com.mykoshar.shop.api.model.service.LaminatorService;

@Service
@Transactional
public class LaminatorServiceImpl implements LaminatorService {
	private ProductDAO<Laminator, SearchLaminators> productDAO;
	
	public void setProductDAO(ProductDAO<Laminator,SearchLaminators> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    public long addProduct(Laminator p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(Laminator p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<Laminator> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public Laminator getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	public Set<Laminator> listSearchProducts(SearchLaminators searchLaminators) {
		return this.productDAO.listSearchProducts(searchLaminators);
	}

	@Override
	public Set<Laminator> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<Laminator> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	public Set<Laminator> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}