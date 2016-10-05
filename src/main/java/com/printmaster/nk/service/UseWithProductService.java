package com.printmaster.nk.service;

import java.util.Set;

import com.printmaster.nk.model.SearchUseWithProducts;
import com.printmaster.nk.model.UseWithProduct;

public interface UseWithProductService {

	public long addUseWithProduct(UseWithProduct p);
    public void updateUseWithProduct(UseWithProduct p);
    public Set<UseWithProduct> listUseWithProducts(String sortCriteria);
    public Set<UseWithProduct> listShowOnSite();
    public Set<UseWithProduct> listShowOnHomePage();
    public Set<UseWithProduct> listSearchUseWithProducts(SearchUseWithProducts searchUseWithProducts);
    public Set<UseWithProduct> listSearchByPhrase(String phrase);
    public UseWithProduct getUseWithProductById(long id);
    public Set<UseWithProduct> getUseWithProductsByIds(long[] p);
    public void removeUseWithProduct(long id);
    public Set<UseWithProduct> getPrintersByTypeInk(String[] typeInk);
	
}
