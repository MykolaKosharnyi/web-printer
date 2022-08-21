package com.mykoshar.shop.api.model.service;

import java.util.Set;

import com.mykoshar.shop.api.model.entity.UseWithProduct;
import com.mykoshar.shop.api.model.entity.search.SearchUseWithProducts;

public interface UseWithProductService{

	public long addProduct(UseWithProduct p);
    public void updateProduct(UseWithProduct p);
    public Set<UseWithProduct> listProducts(String sortCriteria);
    public Set<UseWithProduct> listShowOnSite();
    public Set<UseWithProduct> listShowOnHomePage();
    public Set<UseWithProduct> listSearchProducts(SearchUseWithProducts searchUseWithProducts);
    public Set<UseWithProduct> listSearchByPhrase(String phrase);
    public UseWithProduct getProductById(long id);
    public Set<UseWithProduct> getProductsByIds(long[] p);
    public void removeProduct(long id);
    public Set<UseWithProduct> getPrintersByTypeInk(String[] typeInk);
	
}
