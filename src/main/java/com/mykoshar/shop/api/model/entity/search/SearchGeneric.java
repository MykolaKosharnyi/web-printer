package com.mykoshar.shop.api.model.entity.search;

public abstract class SearchGeneric {
	
	protected double prise0;
	protected double prise1;
	
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

	public abstract String[] getTypeProduct();

	public abstract void setTypeProduct(String[] typeProduct);

}
