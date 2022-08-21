package com.mykoshar.shop.api.model.service.impl;

import java.util.ArrayList;

import com.mykoshar.shop.api.model.dao.impl.PreviousUsedEqvipmentDAOImpl;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mykoshar.shop.api.model.entity.search.SearchPUE;
import com.mykoshar.shop.api.model.service.PreviousUsedEqvipmentService;

@Service
@Transactional
public class PreviousUsedEqvipmentServiceImpl implements PreviousUsedEqvipmentService {
	
	private PreviousUsedEqvipmentDAOImpl productDAO;
	
	public void setProductDAO(PreviousUsedEqvipmentDAOImpl productDAO) {
        this.productDAO = productDAO;
    }

    @Override
	public ArrayList<JSONObject> listProduct(SearchPUE searchProduct) {
		return productDAO.listProduct(searchProduct);
	}
    
    @Override
	public ArrayList<JSONObject> listSearchProduct(SearchPUE searchProduct) {
		return productDAO.listSearchProduct(searchProduct);
	}
    
    @Override
	public ArrayList<JSONObject> listProductForHomePage() {
		return productDAO.listProductForHomePage();
	}
    
    @Override
	public ArrayList<JSONObject> listAllProduct() {
		return productDAO.listAllProduct();
	}

}
