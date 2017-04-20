package com.printmaster.nk.model.service.impl;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.printmaster.nk.model.dao.impl.PreviousUsedEqvipmentDAOImpl;
import com.printmaster.nk.model.entity.search.SearchPUE;
import com.printmaster.nk.model.service.PreviousUsedEqvipmentService;

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
