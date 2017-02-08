package com.printmaster.nk.model.service.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.ProductDAO;
import com.printmaster.nk.model.entity.Cutter;
import com.printmaster.nk.model.entity.search.SearchCutters;
import com.printmaster.nk.model.service.CutterService;

public class CutterServiceImpl implements CutterService {
	private ProductDAO<Cutter, SearchCutters> productDAO;
	
	public void setProductDAO(ProductDAO<Cutter,SearchCutters> productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
    public long addProduct(Cutter p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateProduct(Cutter p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Cutter> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Cutter getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Cutter> listSearchProducts(SearchCutters searchCutters) {
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

	@Override
	@Transactional
	public Set<Cutter> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}