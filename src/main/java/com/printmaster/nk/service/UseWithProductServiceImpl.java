package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.UseWithProductDAO;
import com.printmaster.nk.model.UseWithProduct;
import com.printmaster.nk.model.SearchUseWithProducts;

public class UseWithProductServiceImpl implements UseWithProductService {
	private UseWithProductDAO productDAO;
	
	public void setProductDAO(UseWithProductDAO productDAO) {
        this.productDAO = productDAO;
    }
 
    @Override
    @Transactional
    public long addUseWithProduct(UseWithProduct p) {
        return this.productDAO.addProduct(p);
    }
 
    @Override
    @Transactional
    public void updateUseWithProduct(UseWithProduct p) {
        this.productDAO.updateProduct(p);
    }
 
    @Override
    @Transactional
    public List<UseWithProduct> listUseWithProducts() {
        return this.productDAO.listProducts();
    }
 
    @Override
    @Transactional
    public UseWithProduct getUseWithProductById(long id) {
        return this.productDAO.getProductById(id);
    }
 
    @Override
    @Transactional
    public void removeUseWithProduct(long id) {
        this.productDAO.removeProduct(id);
    }

	@Override
	@Transactional
	public Set<UseWithProduct> listSearchUseWithProducts(SearchUseWithProducts searchUseWithProducts) {
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
	public Set<UseWithProduct> getUseWithProductsByIds(long[] p) {
		return this.productDAO.getProductsByIds(p);
	}

}