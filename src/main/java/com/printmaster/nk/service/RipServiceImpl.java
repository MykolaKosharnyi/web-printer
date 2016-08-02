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
    public long addRip(Rip p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateRip(Rip p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Rip> listRips(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Rip getRipById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeRip(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Rip> listSearchRips(SearchRips searchRips) {
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

}