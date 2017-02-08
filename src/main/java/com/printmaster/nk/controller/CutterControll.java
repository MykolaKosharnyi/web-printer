package com.printmaster.nk.controller;

import static com.printmaster.nk.controller.ConstUsedInContr.ATTRIBUTE_ADD_PRODUCT;
import static com.printmaster.nk.controller.ConstUsedInContr.ATTRIBUTE_NAME_PRODUCT;
import static com.printmaster.nk.controller.ConstUsedInContr.ATTRIBUTE_TITLE;
import static com.printmaster.nk.controller.ConstUsedInContr.ATTRIBUTE_TITLE_OF_TABLE;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.printmaster.nk.model.entity.Cutter;
import com.printmaster.nk.model.entity.search.SearchCutters;
import com.printmaster.nk.model.service.ProductService;

public class CutterControll extends ProductController<Cutter, SearchCutters> {
	
	private Map<String, String> links = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put("for_wood", "Для обработки дерева");
	    put("for_the_treatment_of_metal", "Для обработки металла");
	    put("stone_processing", "Для обработки камня");
	}};
	
	private Map<String, String> parametersOnAdminProductsPage = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put(ATTRIBUTE_TITLE_OF_TABLE, "Список загруженных граверов/фрезеров");
	    put(ATTRIBUTE_NAME_PRODUCT, "Имя гравера/фрезера");
	    put(ATTRIBUTE_TITLE, "Гравера/фрезера");
	    put(ATTRIBUTE_ADD_PRODUCT, "Добавить гравер/фрезер");
	}};
    
	private Logger logger = Logger.getLogger(CutterController.class);
	

    @Autowired(required=true)
    @Qualifier(value="cutterService")
	public void setProductService(ProductService<Cutter, SearchCutters> productService) {
    	this.productService = productService;
	}

}
