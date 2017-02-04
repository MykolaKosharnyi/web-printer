package com.printmaster.nk.service.impl;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.dao.impl.PreviousUsedEqvipmentDAOImpl;
import com.printmaster.nk.model.SearchPUE;
import com.printmaster.nk.service.PreviousUsedEqvipmentService;

public class PreviousUsedEqvipmentServiceImpl implements PreviousUsedEqvipmentService {
	
	private PreviousUsedEqvipmentDAOImpl productDAO;
	
	public void setProductDAO(PreviousUsedEqvipmentDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    @Transactional
	public ArrayList<JSONObject> listProduct(SearchPUE searchProduct) {
		return productDAO.listProduct(searchProduct);
	}
    
    @Override
    @Transactional
	public ArrayList<JSONObject> listSearchProduct(SearchPUE searchProduct) {
		return productDAO.listSearchProduct(searchProduct);
	}
    
    @Override
    @Transactional
	public ArrayList<JSONObject> listProductForHomePage() {
		return productDAO.listProductForHomePage();
	}
    
    @Override
    @Transactional
	public ArrayList<JSONObject> listAllProduct() {
		return productDAO.listAllProduct();
	}

}
