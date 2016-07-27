package com.printmaster.nk.service;

import java.util.ArrayList;

import org.json.simple.JSONObject;

import com.printmaster.nk.modelwork.SearchPUE;

public interface PreviousUsedEqvipmentService {

	public ArrayList<JSONObject> listProduct(SearchPUE searchProduct);
	
	public ArrayList<JSONObject> listSearchProduct(SearchPUE searchProduct);
	
	public ArrayList<JSONObject> listProductForHomePage();
	
	public ArrayList<JSONObject> listAllProduct();
}
