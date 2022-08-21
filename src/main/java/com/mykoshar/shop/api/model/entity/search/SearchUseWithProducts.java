package com.mykoshar.shop.api.model.entity.search;

import java.io.Serializable;
import java.util.Arrays;

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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SEARCH USE WITH PRODUCT details:");
		
		if(typeProduct!=null && typeProduct.length > 0){
			result.append(" typeProduct=" + Arrays.toString(typeProduct));
		}
		
		return result.toString();
	}

}
