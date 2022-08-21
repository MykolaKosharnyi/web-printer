package com.mykoshar.shop.api.model.service.impl;

import java.util.Set;

import com.mykoshar.shop.api.model.dao.ProductDAO;
import com.mykoshar.shop.api.model.entity.Scanner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.search.SearchScanners;
import com.mykoshar.shop.api.model.service.ScannerService;

@Service
@Transactional
public class ScannerServiceImpl implements ScannerService {
	private ProductDAO<Scanner, SearchScanners> productDAO;
	
	public void setProductDAO(ProductDAO<Scanner,SearchScanners> productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    public long addProduct(Scanner p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(Scanner p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<Scanner> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public Scanner getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	public Set<Scanner> listSearchProducts(SearchScanners searchScanners) {
		return this.productDAO.listSearchProducts(searchScanners);
	}

	@Override
	public Set<Scanner> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<Scanner> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}

	@Override
	public Set<Scanner> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}