package com.printmaster.nk.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.printmaster.nk.model.entity.Option;

/*@Entity
@Table(name="product_cart")*/
public class ProductCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="type_product")
	private String typeProduct;	
	
	@Column(name="id_product")
	private Long idProduct;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="buy_online_coefficient")
	private double buyOnlineCoefficient;
	
	@Column(name="price_with_option_and_deivery")
	private double priceWithOptionAndDeivery;
	
	@Column(name="picture_path")
	private String picturePath;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="options")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Option> options;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="deliveries")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Delivery> deliveries;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="paints")
	@Fetch(value = FetchMode.SUBSELECT)
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
	public double getBuyOnlineCoefficient() {
		return buyOnlineCoefficient;
	}
	public void setBuyOnlineCoefficient(double buyOnlineCoefficient) {
		this.buyOnlineCoefficient = buyOnlineCoefficient;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setPriceWithOptionAndDeivery(double priceWithOptionAndDeivery) {
		this.priceWithOptionAndDeivery = priceWithOptionAndDeivery;
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

	@Override
	public String toString() {
		return "ProductCart [typeProduct=" + typeProduct + ", idProduct=" + idProduct + ", name=" + name
				+ ", price=" + price + ", buyOnlineCoefficient=" + buyOnlineCoefficient
				+ ", priceWithOptionAndDeivery=" + priceWithOptionAndDeivery + ", picturePath=" + picturePath
				+ ", options=" + options.toString() + ", deliveries=" + deliveries.toString() + ", paints=" + paints.toString() + "]";
	}

}
