package com.printmaster.nk.modelwork;

import java.io.Serializable;

public class SearchUseWithProducts implements Serializable{

	private static final long serialVersionUID = 6702501013538481082L;
	
	private double prise0;
	private double prise1;
	private String[] typeProduct;

	public SearchUseWithProducts(){}

	public double getPrise0() {
		return prise0;
	}

	public void setPrise0(double prise0) {
		this.prise0 = prise0;
	}

	public double getPrise1() {
		return prise1;
	}

	public void setPrise1(double prise1) {
		this.prise1 = prise1;
	}

	public String[] getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String[] typeProduct) {
		this.typeProduct = typeProduct;
	}
	
}
