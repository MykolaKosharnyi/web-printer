package com.printmaster.nk.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

	List<String> listSubscription2 = new ArrayList<String>(){
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
	
	Map<String, List<String>> listSubscription = new LinkedHashMap<String, List<String>>(){
		private static final long serialVersionUID = 1L;
		{
			put("Принтеры", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Сольвентные");
					add("Экосольвентные");
					add("UV рулонные");
					add("UV плоскопечатные");
					add("Сублимационные");
					add("Текстильные");
					add("Водные/Пигментные");
					add("САПР/ГИС");
				}
			});
			
			put("3Д принтеры", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Экструдные FDM ");
					add("Фото печать Polyjet");
				    add("Лазерного спекания LENS");
				    add("Ламинации LOM");
				    add("Стереолитографии SL");
				    add("Лазерного спекания LS");
				    add("Порошкового склеивания 3DP");
				}
			});
			
			put("Цифровое оборудование", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Полноцветное лазерное оборудование");
					add("Монохромное лазерное оборудование");
					add("Полноцветное струйное оборудование");
				}
			});
			
			put("Ламинаторы", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Горячего ламинирования");
					add("Холодного ламинирования");
					add("Жидкостные");
					add("Планшетный ламинатор");
				}
			});
			
			put("Лазеры", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Газовые лазеры СО2");
					add("Твердотельные лазеры");
					add("Для обработки метала");
					add("С диодной накачкой");
					add("Оптоволоконные лазеры");
					add("Плазменные лазеры");	
				}
			});
			
			put("Фрезеры", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Для обработки дерева");
					add("Для обработки металла");
					add("Для обработки камня");	
				}
			});
			
			put("Сканеры", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Широкоформатные сканеры");
					add("3D Сканеры");  
				}
			});
			
			put("Б/у оборудование", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Сольвентные принтеры");
					add("Экосольвентные принтеры");
					add("UV рулонные принтеры");
					add("UV плоскопечатные принтеры");
					add("Сублимационные принтеры");
					add("Текстильные принтеры");
					add("Водные/Пигментные принтеры");
					add("САПР/ГИС принтеры");
				}
			});
			
			put("ПО", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("ПО");
				}
			});
			
			put("Сопутствующие товары", new ArrayList<String>(){
				private static final long serialVersionUID = 1L;
				{
					add("Чернила для струйной печати");
					add("Расходные материалы для цифрового оборудования");
					add("Расходные материалы для 3D оборудования");
					add("Товары для обслуживания");
					add("Запчасти и комплектующие");
				}
			});
			
		}
	};
	
	List<String> listScopeOfActivities = new ArrayList<String>(){
		private static final long serialVersionUID = 1L;
		{
			add("Цифровая печать");
			add("Широкоформатная печать");
			add("Наружная реклама");
			add("САПР/ГИС");
			add("Другое");
		}
	};
}
