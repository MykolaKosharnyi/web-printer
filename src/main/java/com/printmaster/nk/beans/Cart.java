package com.printmaster.nk.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.printmaster.nk.beans.ProductCart;
import com.printmaster.nk.modelwork.Option;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,
		proxyMode  = ScopedProxyMode.TARGET_CLASS)
public class Cart {

	private Map<ProductCart, Integer> contents = new HashMap<ProductCart, Integer>();
	
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
			totalCost += product.getPriceWithOption() * contents.get(product);
		}
		return totalCost;
	}
	
}
