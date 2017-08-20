package com.printmaster.nk.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.printmaster.nk.beans.ProductCart;
import com.printmaster.nk.model.entity.Option;

@Entity
@Table(name="order")
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,
		proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Cart implements Serializable{

	private static final long serialVersionUID = 3085887569799299321L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="contents")
	@Fetch(value = FetchMode.SUBSELECT)
	private Map<ProductCart, Integer> contents = new LinkedHashMap<ProductCart, Integer>();
	
	@Column(name="id_user")
	private long idUser;
	
	@Column(name="date_creation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation = new Date();
	
	@Column(length = 40, columnDefinition = "varchar(40) default 'CREATING'")
	@Enumerated(value = EnumType.STRING)
	private StatusOfOrdering status = StatusOfOrdering.CREATING;
	
	public static enum StatusOfOrdering{
		CREATING, CREATED, WAITING, CANCELED, MANAGER_PROCESSING, ON_WAY, ORDER_COMPLETED, ORDER_DELIVERED
	}
	
	public Map<ProductCart, Integer> getContents(){
		return contents;
	}
	
	public Set<ProductCart> getProduct(){
		return contents.keySet();
	}
	
	public void addProduct(ProductCart product, int count){
		if (contents.containsKey(product)){
			contents.put(product, contents.get(product) + count);
		} else {
			contents.put(product, count);
		}
	}
	
	public void changeQuantityProduct(ProductCart product, int count){
		contents.put(product, count);
	}
	
	public void changeQuantityPaintProduct(ProductCart product, String namePaint, int quantityConcretePaint){
		int quantity = contents.get(product);
		contents.remove(product);

		for(Paint paint : product.getPaints()){
			if(paint.getName().equals(namePaint)){
				paint.setQuantity(quantityConcretePaint);
				break;
			}
		}
		
		contents.put(product, quantity);
	}
	
	public void changeOptionProduct(ProductCart product, String optionName, boolean stateOfOption){
		int quantity = contents.get(product);
		contents.remove(product);
		for(Option option : product.getOptions()){
			if(option.getName().equals(optionName)){
				option.setChecked(stateOfOption);
				break;
			}
		}
		
		contents.put(product, quantity);
	}
	
	public void changeDeliveryProduct(ProductCart product, String deliveryName, boolean stateOfOption){
		int quantity = contents.get(product);
		contents.remove(product);
		for(Delivery delivery : product.getDeliveries()){
			if(delivery.getName().equals(deliveryName)){
				delivery.setChecked(stateOfOption);
				break;
			}
		}
		
		contents.put(product, quantity);
	}
	
	public void changePaintProduct(ProductCart product, String paintName, boolean stateOfOption){
		int quantity = contents.get(product);
		contents.remove(product);
		for(Paint paint : product.getPaints()){
			if(paint.getName().equals(paintName)){
				paint.setChecked(stateOfOption);
				break;
			}
		}
		
		contents.put(product, quantity);
	}
	
	public void removeProduct(ProductCart product){
		contents.remove(product);
	}
	
	public void clearCart(){
		contents.clear();
	}

	@Override
	public String toString() {
		return contents.toString();
	}
	
	public double getTotalCost(){
		double totalCost = 0;
		for (ProductCart product : contents.keySet()){
			totalCost += product.getPriceWithOptionAndDeivery() * contents.get(product);
		}
		return totalCost;
	}
	
	public int getTotalQuantity(){
		int quantity = 0;
		for (ProductCart product : contents.keySet()){
			quantity += contents.get(product);
		}
		return quantity;
	}
	
}
