package com.printmaster.nk.service.impl;

import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.UseWithProductDAO;
import com.printmaster.nk.model.entity.UseWithProduct;
import com.printmaster.nk.model.entity.search.SearchUseWithProducts;
import com.printmaster.nk.service.UseWithProductService;

public class UseWithProductServiceImpl implements UseWithProductService {
	private UseWithProductDAO productDAO;
	
	public void setProductDAO(UseWithProductDAO productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addProduct(UseWithProduct p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateProduct(UseWithProduct p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public Set<UseWithProduct> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    @Transactional
    public UseWithProduct getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<UseWithProduct> listSearchProducts(SearchUseWithProducts searchUseWithProducts) {
		return this.productDAO.listSearchProducts(searchUseWithProducts);
	}

	@Override
	@Transactional
	public Set<UseWithProduct> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	@Transactional
	public Set<UseWithProduct> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}
	
	@Override
	@Transactional
	public Set<UseWithProduct> getProductsByIds(long[] p) {
		return this.productDAO.getProductsByIds(p);
	}
	
	@Override
	@Transactional
	public Set<UseWithProduct> getPrintersByTypeInk(String[] typeInk){
		return this.productDAO.getPrintersByTypeInk(typeInk);
	}

	@Override
	@Transactional
	public Set<UseWithProduct> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}