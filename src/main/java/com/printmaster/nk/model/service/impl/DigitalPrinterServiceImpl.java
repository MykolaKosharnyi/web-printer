package com.printmaster.nk.model.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.ProductDAO;
import com.printmaster.nk.model.entity.DigitalPrinter;
import com.printmaster.nk.model.entity.search.SearchDigitalPrinters;
import com.printmaster.nk.model.service.DigitalPrinterService;

@Service
@Transactional
public class DigitalPrinterServiceImpl implements DigitalPrinterService {
	private ProductDAO<DigitalPrinter, SearchDigitalPrinters> productDAO;
	
	public void setProductDAO(ProductDAO<DigitalPrinter,SearchDigitalPrinters> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    public long addProduct(DigitalPrinter p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(DigitalPrinter p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<DigitalPrinter> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public DigitalPrinter getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	public Set<DigitalPrinter> listSearchProducts(SearchDigitalPrinters searchPrinters) {
		return this.productDAO.listSearchProducts(searchPrinters);
	}

	@Override
	public Set<DigitalPrinter> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<DigitalPrinter> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	public Set<DigitalPrinter> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}
