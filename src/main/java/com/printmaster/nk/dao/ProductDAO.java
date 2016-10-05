package com.printmaster.nk.dao;

import java.util.Set;

public interface ProductDAO<P,C> {//P - product, C - criteria for with we will be searching product
	
	public long addProduct(P p);
    public void updateProduct(P p);
    public Set<P> listProducts(String sortCriteria);
    public Set<P> listShowOnSite();
    public Set<P> listShowOnHomePage();
    public Set<P> listSearchProducts(C searchProductCriteria);
    public Set<P> listSearchByPhrase(String phrase);
    public P getProductById(long id);
    public void removeProduct(long id);
    
}
