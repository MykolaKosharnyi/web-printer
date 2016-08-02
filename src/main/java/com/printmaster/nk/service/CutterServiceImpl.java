package com.printmaster.nk.service;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.model.SearchCutters;

public class CutterServiceImpl implements CutterService {
	private ProductDAO<Cutter, SearchCutters> productDAO;
	
	public void setProductDAO(ProductDAO<Cutter,SearchCutters> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addCutter(Cutter p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateCutter(Cutter p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Cutter> listCutters(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Cutter getCutterById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeCutter(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Cutter> listSearchCutters(SearchCutters searchCutters) {
		return this.productDAO.listSearchProducts(searchCutters);
	}

	@Override
	@Transactional
	public Set<Cutter> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<Cutter> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

}