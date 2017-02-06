package com.printmaster.nk.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.entity.Printer3D;
import com.printmaster.nk.model.entity.search.SearchPrinters3D;
import com.printmaster.nk.service.Printer3DService;

@Service
public class Printer3DServiceImpl implements Printer3DService {
     
	private ProductDAO<Printer3D, SearchPrinters3D> productDAO;
    
    public void setProductDAO(ProductDAO<Printer3D,SearchPrinters3D> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addProduct(Printer3D p) {
    	return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateProduct(Printer3D p) {
    	this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Printer3D> listProducts(String sortCriteria) {
    	 return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Printer3D getProductById(long id) {
    	return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeProduct(long id) {
    	this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Printer3D> listSearchProducts(SearchPrinters3D searchPrinters) {
		return this.productDAO.listSearchProducts(searchPrinters);
	}

	@Override
	@Transactional
	public Set<Printer3D> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<Printer3D> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	@Transactional
	public Set<Printer3D> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}
 
}

