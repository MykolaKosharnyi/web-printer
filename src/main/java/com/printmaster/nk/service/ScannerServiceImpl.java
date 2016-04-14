package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Scanner;
import com.printmaster.nk.model.SearchScanners;

public class ScannerServiceImpl implements ScannerService {
	private ProductDAO<Scanner, SearchScanners> productDAO;
	
	public void setProductDAO(ProductDAO<Scanner,SearchScanners> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addScanner(Scanner p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateScanner(Scanner p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public List<Scanner> listScanners() {
        return this.productDAO.listProducts();
    }
 
    @Override
    @Transactional
    public Scanner getScannerById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeScanner(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Scanner> listSearchScanners(SearchScanners searchScanners) {
		return this.productDAO.listSearchProducts(searchScanners);
	}

	@Override
	@Transactional
	public Set<Scanner> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<Scanner> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

}