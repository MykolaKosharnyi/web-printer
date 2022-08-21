package com.mykoshar.shop.api.model.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.mykoshar.shop.api.model.entity.search.SearchPUE;

public interface PreviousUsedEqvipmentService {

	public ArrayList<JSONObject> listProduct(SearchPUE searchProduct);
	
	public ArrayList<JSONObject> listSearchProduct(SearchPUE searchProduct);
	
	public ArrayList<JSONObject> listProductForHomePage();
	
	public ArrayList<JSONObject> listAllProduct();
}
