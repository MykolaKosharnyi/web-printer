package com.printmaster.nk.service;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.model.SearchDigitalPrinters;

public class DigitalPrinterServiceImpl implements DigitalPrinterService {
	private ProductDAO<DigitalPrinter, SearchDigitalPrinters> productDAO;
	
	public void setProductDAO(ProductDAO<DigitalPrinter,SearchDigitalPrinters> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addPrinter(DigitalPrinter p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updatePrinter(DigitalPrinter p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<DigitalPrinter> listPrinters(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public DigitalPrinter getPrinterById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removePrinter(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<DigitalPrinter> listSearchDigitalPrinters(SearchDigitalPrinters searchPrinters) {
		return this.productDAO.listSearchProducts(searchPrinters);
	}

	@Override
	@Transactional
	public Set<DigitalPrinter> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<DigitalPrinter> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	@Transactional
	public Set<DigitalPrinter> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}
