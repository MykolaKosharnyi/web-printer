package com.printmaster.nk.controller;

import java.util.List;
import java.util.Map;

public class Shopping {
	
	double price;
	String pathToPicture;
	List<String> arrayOfCheckedOption;
	String checkedDelivery;
	Map<String, Integer> mapOfPaint;
	
	public Shopping(){}

	public Map<String, Integer> getMapOfPaint() {
		return mapOfPaint;
	}

	public void setMapOfPaint(Map<String, Integer> mapOfPaint) {
		this.mapOfPaint = mapOfPaint;
	}

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

	public String getCheckedDelivery() {
		return checkedDelivery;
	}

	public void setCheckedDelivery(String checkedDelivery) {
		this.checkedDelivery = checkedDelivery;
	}

}
