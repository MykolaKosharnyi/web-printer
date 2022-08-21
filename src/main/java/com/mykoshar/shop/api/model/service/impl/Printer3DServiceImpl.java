package com.mykoshar.shop.api.model.service.impl;

import java.util.Set;

import com.mykoshar.shop.api.model.dao.ProductDAO;
import com.mykoshar.shop.api.model.entity.Printer3D;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.search.SearchPrinters3D;
import com.mykoshar.shop.api.model.service.Printer3DService;

@Service
@Transactional
public class Printer3DServiceImpl implements Printer3DService {
     
	private ProductDAO<Printer3D, SearchPrinters3D> productDAO;
    
    public void setProductDAO(ProductDAO<Printer3D,SearchPrinters3D> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    public long addProduct(Printer3D p) {
    	return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(Printer3D p) {
    	this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<Printer3D> listProducts(String sortCriteria) {
    	 return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public Printer3D getProductById(long id) {
    	return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
    	this.productDAO.removeProduct(id);
    }

	@Override
	public Set<Printer3D> listSearchProducts(SearchPrinters3D searchPrinters) {
		return this.productDAO.listSearchProducts(searchPrinters);
	}

	@Override
	public Set<Printer3D> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<Printer3D> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	public Set<Printer3D> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}
 
}

