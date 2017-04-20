package com.printmaster.nk.model.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.ProductDAO;
import com.printmaster.nk.model.entity.Printer;
import com.printmaster.nk.model.entity.search.SearchPrinters;
import com.printmaster.nk.model.service.PrinterService;

@Service
@Transactional
public class PrinterServiceImpl implements PrinterService {
     
    private ProductDAO<Printer, SearchPrinters> productDAO;
    
    public void setProductDAO(ProductDAO<Printer,SearchPrinters> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    public long addProduct(Printer p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(Printer p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<Printer> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public Printer getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	public Set<Printer> listSearchProducts(SearchPrinters searchPrinters) {
		return this.productDAO.listSearchProducts(searchPrinters);
	}

	@Override
	public Set<Printer> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<Printer> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	public Set<Printer> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}
 
}
