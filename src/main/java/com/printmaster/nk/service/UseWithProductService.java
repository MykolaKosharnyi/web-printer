package com.printmaster.nk.service;

import java.util.List;
import java.util.Set;

import com.printmaster.nk.model.UseWithProduct;
import com.printmaster.nk.model.SearchUseWithProducts;

public interface UseWithProductService {

	public long addUseWithProduct(UseWithProduct p);
    public void updateUseWithProduct(UseWithProduct p);
    public List<UseWithProduct> listUseWithProducts();
    public Set<UseWithProduct> listShowOnSite();
    public Set<UseWithProduct> listShowOnHomePage();
    public Set<UseWithProduct> listSearchUseWithProducts(SearchUseWithProducts searchUseWithProducts);
    public UseWithProduct getUseWithProductById(long id);
    public Set<UseWithProduct> getUseWithProductsByIds(long[] p);
    public void removeUseWithProduct(long id);
	
}
