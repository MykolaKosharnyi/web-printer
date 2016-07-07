package com.printmaster.nk.model;

public class Option{

	private String name;
	private Double price;
	private String description;
	private boolean cheked;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCheked() {
		return cheked;
	}
	public void setCheked(boolean cheked) {
		this.cheked = cheked;
	}

	
}
