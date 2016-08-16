package com.printmaster.nk.controller;

import java.util.List;

public class Shopping {
	
	double price;
	String pathToPicture;
	List<String> arrayOfCheckedOption;
	List<String> arrayOfCheckedDelivery;
	
	public Shopping(){}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPathToPicture() {
		return pathToPicture;
	}

	public void setPathToPicture(String pathToPicture) {
		this.pathToPicture = pathToPicture;
	}

	public List<String> getArrayOfCheckedOption() {
		return arrayOfCheckedOption;
	}

	public void setArrayOfCheckedOption(List<String> arrayOfCheckedOption) {
		this.arrayOfCheckedOption = arrayOfCheckedOption;
	}

	public List<String> getArrayOfCheckedDelivery() {
		return arrayOfCheckedDelivery;
	}

	public void setArrayOfCheckedDelivery(List<String> arrayOfCheckedDelivery) {
		this.arrayOfCheckedDelivery = arrayOfCheckedDelivery;
	}
	
}
