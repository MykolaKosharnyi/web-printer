package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;

@Service
public class PrinterServiceImpl implements PrinterService {
     
    private ProductDAO<Printer, SearchPrinters> productDAO;
    
    public void setProductDAO(ProductDAO<Printer,SearchPrinters> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addPrinter(Printer p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updatePrinter(Printer p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public List<Printer> listPrinters() {
        return this.productDAO.listProducts();
    }
 
    @Override
    @Transactional
    public Printer getPrinterById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removePrinter(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Printer> listSearchPrinters(SearchPrinters searchPrinters) {
		return this.productDAO.listSearchProducts(searchPrinters);
	}
 
}
