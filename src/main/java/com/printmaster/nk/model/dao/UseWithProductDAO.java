package com.printmaster.nk.model.dao;

import java.util.Set;

import com.printmaster.nk.model.entity.UseWithProduct;
import com.printmaster.nk.model.entity.search.SearchUseWithProducts;

public interface UseWithProductDAO {
	long addProduct(UseWithProduct p);
    void updateProduct(UseWithProduct p);
    Set<UseWithProduct> listProducts(String sortCriteria);
    Set<UseWithProduct> listShowOnSite();
    Set<UseWithProduct> listShowOnHomePage();
    Set<UseWithProduct> listSearchProducts(SearchUseWithProducts searchProductCriteria);
    Set<UseWithProduct> listSearchByPhrase(String phrase);
    UseWithProduct getProductById(long id);
    Set<UseWithProduct> getProductsByIds(long[] p);
    void removeProduct(long id);
    Set<UseWithProduct> getPrintersByTypeInk(String[] typeInk);
}
