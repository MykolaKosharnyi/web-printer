package com.printmaster.nk.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.entity.Printer;
import com.printmaster.nk.model.entity.search.SearchPrinters;
import com.printmaster.nk.service.PrinterService;

@Service
public class PrinterServiceImpl implements PrinterService {
     
    private ProductDAO<Printer, SearchPrinters> productDAO;
    
    public void setProductDAO(ProductDAO<Printer,SearchPrinters> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addProduct(Printer p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateProduct(Printer p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Printer> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Printer getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Printer> listSearchProducts(SearchPrinters searchPrinters) {
		return this.productDAO.listSearchProducts(searchPrinters);
	}

	@Override
	@Transactional
	public Set<Printer> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<Printer> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	@Transactional
	public Set<Printer> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}
 
}
