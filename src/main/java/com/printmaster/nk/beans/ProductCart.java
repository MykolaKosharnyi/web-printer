package com.printmaster.nk.beans;

import java.util.List;

import com.printmaster.nk.model.entity.Option;

public class ProductCart {
	
	private String typeProduct;	
	private Long idProduct;
	private String name;
	private double price;
	private double priceWithOptionAndDeivery;
	private String picturePath;
	private List<Option> options;
	private List<Delivery> deliveries;
	private List<Paint> paints;

	public double getPriceWithOptionAndDeivery() {
		priceWithOptionAndDeivery = price;
		double coeficientVAT = 1;
		
		for(Option option: options){
			if(option.isChecked()){
				if(option.getName() != "НДС"){
					priceWithOptionAndDeivery += option.getPrice();
				} else {
					coeficientVAT = option.getPrice();
				}
			}
		}
		
		for(Delivery delivery: deliveries){
			if(delivery.isChecked()){
				priceWithOptionAndDeivery += delivery.getPriceSize();
				priceWithOptionAndDeivery += delivery.getPriceWeight();
			}
		}
		
		for(Paint paint: paints){
			if(paint.isChecked()){
				priceWithOptionAndDeivery += (paint.getPrice() * paint.getQuantity());
			}
		}
		
		return priceWithOptionAndDeivery * coeficientVAT;
	}
	
	public List<Delivery> getDeliveries() {
		return deliveries;
	}
	public List<Paint> getPaints() {
		return paints;
	}
	public void setPaints(List<Paint> paints) {
		this.paints = paints;
	}
	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypeProduct() {
		return typeProduct;
	}
	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Long getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProduct == null) ? 0 : idProduct.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((typeProduct == null) ? 0 : typeProduct.hashCode());
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
		ProductCart other = (ProductCart) obj;
		if (idProduct == null) {
			if (other.idProduct != null)
				return false;
		} else if (!idProduct.equals(other.idProduct))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (typeProduct == null) {
			if (other.typeProduct != null)
				return false;
		} else if (!typeProduct.equals(other.typeProduct))
			return false;
		return true;
	}

}
