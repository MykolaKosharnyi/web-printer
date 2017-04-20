package com.printmaster.nk.model.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.ProductDAO;
import com.printmaster.nk.model.entity.Laminator;
import com.printmaster.nk.model.entity.search.SearchLaminators;
import com.printmaster.nk.model.service.LaminatorService;

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