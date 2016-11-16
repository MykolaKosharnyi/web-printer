package com.printmaster.nk.beans;

public class Constants {

	private double dollarInGrivna;
	private double euroInGrivna;
	private double priceAviaSize;
	private double priceAviaWeight;
	private double priceSeaSize;
	private double priceSeaWeight;
	private double priceUkraineSize;
	private double priceUkraineWeight;
	private double priceKyivSize;
	private double priceKyivWeight;
	private double percentInsuranceUkraine;
	private double percentInsuranceInternational;
	
	public Constants(){}

	public double getDollarInGrivna() {
		return dollarInGrivna;
	}

	public void setDollarInGrivna(double dollarInGrivna) {
		this.dollarInGrivna = dollarInGrivna;
	}

	public double getEuroInGrivna() {
		return euroInGrivna;
	}

	public void setEuroInGrivna(double euroInGrivna) {
		this.euroInGrivna = euroInGrivna;
	}

	public double getPriceAviaSize() {
		return priceAviaSize;
	}

	public void setPriceAviaSize(double priceAviaSize) {
		this.priceAviaSize = priceAviaSize;
	}

	public double getPriceAviaWeight() {
		return priceAviaWeight;
	}

	public void setPriceAviaWeight(double priceAviaWeight) {
		this.priceAviaWeight = priceAviaWeight;
	}

	public double getPriceSeaSize() {
		return priceSeaSize;
	}

	public void setPriceSeaSize(double priceSeaSize) {
		this.priceSeaSize = priceSeaSize;
	}

	public double getPriceSeaWeight() {
		return priceSeaWeight;
	}

	public void setPriceSeaWeight(double priceSeaWeight) {
		this.priceSeaWeight = priceSeaWeight;
	}

	public double getPriceUkraineSize() {
		return priceUkraineSize;
	}

	public void setPriceUkraineSize(double priceUkraineSize) {
		this.priceUkraineSize = priceUkraineSize;
	}

	public double getPriceUkraineWeight() {
		return priceUkraineWeight;
	}

	public void setPriceUkraineWeight(double priceUkraineWeight) {
		this.priceUkraineWeight = priceUkraineWeight;
	}

	public double getPriceKyivSize() {
		return priceKyivSize;
	}

	public void setPriceKyivSize(double priceKyivSize) {
		this.priceKyivSize = priceKyivSize;
	}

	public double getPriceKyivWeight() {
		return priceKyivWeight;
	}

	public void setPriceKyivWeight(double priceKyivWeight) {
		this.priceKyivWeight = priceKyivWeight;
	}

	public double getPercentInsuranceUkraine() {
		return percentInsuranceUkraine;
	}

	public void setPercentInsuranceUkraine(double percentInsuranceUkraine) {
		this.percentInsuranceUkraine = percentInsuranceUkraine;
	}

	public double getPercentInsuranceInternational() {
		return percentInsuranceInternational;
	}

	public void setPercentInsuranceInternational(double percentInsuranceInternational) {
		this.percentInsuranceInternational = percentInsuranceInternational;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(dollarInGrivna);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(euroInGrivna);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceAviaSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceAviaWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceKyivSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceKyivWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceSeaSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceSeaWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceUkraineSize);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceUkraineWeight);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Constants other = (Constants) obj;
		if (Double.doubleToLongBits(dollarInGrivna) != Double.doubleToLongBits(other.dollarInGrivna))
			return false;
		if (Double.doubleToLongBits(euroInGrivna) != Double.doubleToLongBits(other.euroInGrivna))
			return false;
		if (Double.doubleToLongBits(priceAviaSize) != Double.doubleToLongBits(other.priceAviaSize))
			return false;
		if (Double.doubleToLongBits(priceAviaWeight) != Double.doubleToLongBits(other.priceAviaWeight))
			return false;
		if (Double.doubleToLongBits(priceKyivSize) != Double.doubleToLongBits(other.priceKyivSize))
			return false;
		if (Double.doubleToLongBits(priceKyivWeight) != Double.doubleToLongBits(other.priceKyivWeight))
			return false;
		if (Double.doubleToLongBits(priceSeaSize) != Double.doubleToLongBits(other.priceSeaSize))
			return false;
		if (Double.doubleToLongBits(priceSeaWeight) != Double.doubleToLongBits(other.priceSeaWeight))
			return false;
		if (Double.doubleToLongBits(priceUkraineSize) != Double.doubleToLongBits(other.priceUkraineSize))
			return false;
		if (Double.doubleToLongBits(priceUkraineWeight) != Double.doubleToLongBits(other.priceUkraineWeight))
			return false;
		return true;
	}
	
}
