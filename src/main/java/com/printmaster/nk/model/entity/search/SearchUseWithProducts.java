package com.printmaster.nk.model.entity.search;

import java.io.Serializable;

public class SearchUseWithProducts extends SearchGeneric implements Serializable{

	private static final long serialVersionUID = 6702501013538481082L;
	protected String[] typeProduct;

	public SearchUseWithProducts(){}
	
	public String[] getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String[] typeProduct) {
		this.typeProduct = typeProduct;
	}

}
