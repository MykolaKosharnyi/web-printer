package com.printmaster.nk.service;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.SearchRips;

public class RipServiceImpl implements RipService {
	private ProductDAO<Rip, SearchRips> productDAO;
	
	public void setProductDAO(ProductDAO<Rip,SearchRips> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addProduct(Rip p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateProduct(Rip p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Rip> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Rip getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Rip> listSearchProducts(SearchRips searchRips) {
		return this.productDAO.listSearchProducts(searchRips);
	}

	@Override
	@Transactional
	public Set<Rip> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<Rip> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	@Transactional
	public Set<Rip> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}