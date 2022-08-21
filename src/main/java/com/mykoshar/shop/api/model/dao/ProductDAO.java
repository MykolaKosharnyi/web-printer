package com.mykoshar.shop.api.model.dao;

import java.util.Set;

import com.mykoshar.shop.api.model.entity.Product;

public interface ProductDAO<P extends Product,C> {//P - product, C - criteria for with we will be searching product
	long addProduct(P p);
    void updateProduct(P p);
    Set<P> listProducts(String sortCriteria);
    Set<P> listShowOnSite();
    Set<P> listShowOnHomePage();
    Set<P> listSearchProducts(C searchProductCriteria);
    Set<P> listSearchByPhrase(String phrase);
    P getProductById(long id);
    void removeProduct(long id);   
}
