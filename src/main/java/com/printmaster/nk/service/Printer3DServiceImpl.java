package com.printmaster.nk.service;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.modelwork.SearchPrinters3D;

@Service
public class Printer3DServiceImpl implements Printer3DService {
     
	private ProductDAO<Printer3D, SearchPrinters3D> productDAO;
    
    public void setProductDAO(ProductDAO<Printer3D,SearchPrinters3D> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addPrinter3D(Printer3D p) {
    	return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updatePrinter3D(Printer3D p) {
    	this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Printer3D> listPrinters3D(String sortCriteria) {
    	 return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Printer3D getPrinter3DById(long id) {
    	return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removePrinter3D(long id) {
    	this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Printer3D> listSearchPrinters3D(SearchPrinters3D searchPrinters) {
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
 
}

