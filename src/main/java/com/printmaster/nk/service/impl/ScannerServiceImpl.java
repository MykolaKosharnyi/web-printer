package com.printmaster.nk.service.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.ProductDAO;
import com.printmaster.nk.model.Scanner;
import com.printmaster.nk.model.SearchScanners;
import com.printmaster.nk.service.ScannerService;

public class ScannerServiceImpl implements ScannerService {
	private ProductDAO<Scanner, SearchScanners> productDAO;
	
	public void setProductDAO(ProductDAO<Scanner,SearchScanners> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addProduct(Scanner p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateProduct(Scanner p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<Scanner> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public Scanner getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<Scanner> listSearchProducts(SearchScanners searchScanners) {
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

	@Override
	@Transactional
	public Set<Scanner> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}