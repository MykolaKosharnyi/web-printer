package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.SearchPrinters3D;

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
    public List<Printer3D> listPrinters3D() {
    	 return this.productDAO.listProducts();
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
 
}

