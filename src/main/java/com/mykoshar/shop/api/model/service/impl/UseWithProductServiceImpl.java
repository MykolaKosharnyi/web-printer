package com.mykoshar.shop.api.model.service.impl;

import java.util.Set;

import com.mykoshar.shop.api.model.dao.UseWithProductDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.UseWithProduct;
import com.mykoshar.shop.api.model.entity.search.SearchUseWithProducts;
import com.mykoshar.shop.api.model.service.UseWithProductService;

@Service
@Transactional
public class UseWithProductServiceImpl implements UseWithProductService {
	private UseWithProductDAO productDAO;
	
	public void setProductDAO(UseWithProductDAO productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    public long addProduct(UseWithProduct p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    public void updateProduct(UseWithProduct p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    public Set<UseWithProduct> listProducts(String sortCriteria) {
        return this.productDAO.listProducts(sortCriteria);
    }
 
    @Override
    public UseWithProduct getProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    public void removeProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	public Set<UseWithProduct> listSearchProducts(SearchUseWithProducts searchUseWithProducts) {
		return this.productDAO.listSearchProducts(searchUseWithProducts);
	}

	@Override
	public Set<UseWithProduct> listShowOnSite() {
		return this.productDAO.listShowOnSite();
	}

	@Override
	public Set<UseWithProduct> listShowOnHomePage() {
		return this.productDAO.listShowOnHomePage();
	}
	
	@Override
	public Set<UseWithProduct> getProductsByIds(long[] p) {
		return this.productDAO.getProductsByIds(p);
	}
	
	@Override
	public Set<UseWithProduct> getPrintersByTypeInk(String[] typeInk){
		return this.productDAO.getPrintersByTypeInk(typeInk);
	}

	@Override
	public Set<UseWithProduct> listSearchByPhrase(String phrase) {
		return this.productDAO.listSearchByPhrase(phrase);
	}

}