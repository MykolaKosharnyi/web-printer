package com.printmaster.nk.dao;

import java.util.Set;

import com.printmaster.nk.model.SearchUseWithProducts;
import com.printmaster.nk.model.UseWithProduct;

public interface UseWithProductDAO {

	public long addProduct(UseWithProduct p);
    public void updateProduct(UseWithProduct p);
    public Set<UseWithProduct> listProducts(String sortCriteria);
    public Set<UseWithProduct> listShowOnSite();
    public Set<UseWithProduct> listShowOnHomePage();
    public Set<UseWithProduct> listSearchProducts(SearchUseWithProducts searchProductCriteria);
    public UseWithProduct getProductById(long id);
    public Set<UseWithProduct> getProductsByIds(long[] p);
    public void removeProduct(long id);
}
