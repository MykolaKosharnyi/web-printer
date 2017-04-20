package com.printmaster.nk.model.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.ProductDAO;
import com.printmaster.nk.model.entity.Cutter;
import com.printmaster.nk.model.entity.search.SearchCutters;
import com.printmaster.nk.model.service.CutterService;

@Service
@Transactional
public class CutterServiceImpl implements CutterService {
	private ProductDAO<Cutter, SearchCutters> productDAO;
	
	public void setProductDAO(ProductDAO<Cutter,SearchCutters> productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public long addProduct(Cutter p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(Cutter p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<Cutter> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public Cutter getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	public Set<Cutter> listSearchProducts(SearchCutters searchCutters) {
		return this.productDAO.listSearchProducts(searchCutters);
	}

	@Override
	public Set<Cutter> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<Cutter> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	public Set<Cutter> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}