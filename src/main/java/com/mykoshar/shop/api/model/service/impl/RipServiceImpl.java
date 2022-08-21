package com.mykoshar.shop.api.model.service.impl;

import java.util.Set;

import com.mykoshar.shop.api.model.dao.ProductDAO;
import com.mykoshar.shop.api.model.entity.Rip;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.search.SearchRips;
import com.mykoshar.shop.api.model.service.RipService;

@Service
@Transactional
public class RipServiceImpl implements RipService {
	private ProductDAO<Rip, SearchRips> productDAO;
	
	public void setProductDAO(ProductDAO<Rip,SearchRips> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    public long addProduct(Rip p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(Rip p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<Rip> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public Rip getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	public Set<Rip> listSearchProducts(SearchRips searchRips) {
		return this.productDAO.listSearchProducts(searchRips);
	}

	@Override
	public Set<Rip> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<Rip> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	public Set<Rip> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}