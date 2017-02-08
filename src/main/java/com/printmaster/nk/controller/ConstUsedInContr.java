package com.printmaster.nk.controller;

import java.util.ArrayList;
import java.util.List;

interface ConstUsedInContr {
	String DIRECTORY = "/var/www/localhost/images";
	
	String PATH_ADMIN = "admin";
	String PATH_SHOW_ON_LEFT_SIDE = "showOnLeftSide";
	String PATH_SHOW_ON_HOME_PAGE = "showOnHomePage";
	String PATH_SET_TOP = "setTop";
	String PATH_SHOW_ON_SITE = "showOnSite";
	String PATH_REMOVE = "remove";
	String PATH_REMOVE_PICTURE_UPDATE = "remove_picture_update";
	String PATH_CHANGE_ORDER_PICTURES_UPDATE = "change_order_pictures_update";
	String PATH_CREATE = "create";
	String PATH_UPLOAD_PICTURES_UPDATE = "upload_pictures_update";
	String PATH_REMOVE_PICTURE = "remove_picture";
	String PATH_CHANGE_ORDER_PICTURES = "change_order_pictures";
	String PATH_UPLOAD_PICTURES = "upload_pictures";
	String PATH_UPDATE = "update";
	String PATH_SAVE_UPDATE = "save_update";
	String PATH_EDIT = "edit";
	String PATH_SAVE_ADD = "save_add";
	String PATH_ADD = "add";
	String PATH_COPY = "copy";
	String PATH_NEW = "new";
	String PATH_SORTING = "sorting";
	String PATH_SEARCH = "search";
	String PATH_PRODUCTS = "products";
	
	String MODEL_ATTRIBUTE_PRODUCT = "product";
	
	String JSON_HEADERS = "content-type=application/x-www-form-urlencoded";
	String JSON_CONSUMES = "application/json";
	String JSON_PRODUCES = "application/json; charset=utf-8";
	
	String ATTRIBUTE_SEARCH = "search";
	String ATTRIBUTE_TITLE_OF_TABLE= "titleOfTable";
	String ATTRIBUTE_LIST_PRODUCTS = "listProducts";
	String ATTRIBUTE_TYPE = "type";
	String ATTRIBUTE_NAME_PRODUCT = "nameProduct";
	String ATTRIBUTE_TITLE = "title";
	String ATTRIBUTE_ADD_PRODUCT = "addProduct";
	String ATTRIBUTE_PRODUCT_SUB_TYPE = "productSubType";
	String ATTRIBUTE_PRODUCT_TYPE = "productType";
	String ATTRIBUTE_PRODUCT = "product";
	String ATTRIBUTE_UWP = "uwp";
	String ATTRIBUTE_PRODUCT_ID = "productId";
	
	//name of product

	String PRINTER = "printer";
	String PRINTER_3D = "3d_printer";
	String DIGITAL_PRINTER = "digital_printer";
	String CUTTER = "cutter";
	String LAMINATOR = "laminator";
	String LASER = "laser";
	String SCANNER = "scanner";
	String USE_WITH_PRODUCT = "use_with_product";

	List<String> listSubscription = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
		{
			add("принтеры");
			add("3Д принтеры");
			add("цифровое оборудование");
			add("ламинаторы");
			add("лазеры");
			add("фрезеры");
			add("сканеры");
			add("б/у оборудование");
			add("ПО");
			add("сопутствующие товары");
		}
	};
	
	List<String> listScopeOfActivities = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
		{
			add("цифровая печать");
			add("широкоформатный печать");
			add("наружная реклама");
			add("САПР/ГИС");
		}
	};
}
