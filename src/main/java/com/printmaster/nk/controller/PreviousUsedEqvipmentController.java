package com.printmaster.nk.controller;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.model.entity.search.SearchPUE;
import com.printmaster.nk.model.service.PreviousUsedEqvipmentService;

@Controller
public class PreviousUsedEqvipmentController {
	
	private Logger logger = Logger.getLogger(PreviousUsedEqvipmentController.class);
	
	@Autowired
    private ComponentsForControllers componets;
	
	 private PreviousUsedEqvipmentService pueService;
	    
	    @Autowired(required=true)
	    @Qualifier(value="pueService")
	    public void setPrinterService(PreviousUsedEqvipmentService ps){
	        this.pueService = ps;
	    }
 
	@RequestMapping(value = "/previous_use_equipments", method = RequestMethod.GET)	
    public String allProduct(Model model) {
		
		SearchPUE search = new SearchPUE();
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("listProducts", pueService.listProduct(search)); 
        
        model.addAttribute("typePrinter", componets.getParametersFromConcreteJSONProduct("printer", "type_printer"));
    	model.addAttribute("printerEquipment", componets.getParametersFromConcreteJSONProduct("printer", "equipment_manufacturer"));
    	
    	model.addAttribute("type3dPrinter", componets.getParametersFromConcreteJSONProduct("3d_printer", "type_printer_3d"));
    	model.addAttribute("d3PrinterEquipment", componets.getParametersFromConcreteJSONProduct("3d_printer", "equipment_manufacturer"));
    	
    	model.addAttribute("typeDigitalPrinter", componets.getParametersFromConcreteJSONProduct("digital_printer", "type_printer"));
    	
    	model.addAttribute("typeLaminator", componets.getParametersFromConcreteJSONProduct("laminator", "type_product"));
    	model.addAttribute("laminatorEquipment", componets.getParametersFromConcreteJSONProduct("laminator", "equipment_manufacturer"));
    	
    	model.addAttribute("typeLaser", componets.getParametersFromConcreteJSONProduct("laser", "type_laser"));
    	model.addAttribute("laserEquipment", componets.getParametersFromConcreteJSONProduct("laser", "equipment_manufacturer"));
    	
    	model.addAttribute("typeCutter", componets.getParametersFromConcreteJSONProduct("cutter", "type_cutter"));
    	model.addAttribute("cutterEquipment", componets.getParametersFromConcreteJSONProduct("cutter", "equipment_manufacturer"));
    	
    	model.addAttribute("typeScanner", componets.getParametersFromConcreteJSONProduct("scanner", "type_product"));
    	model.addAttribute("scannerEquipment", componets.getParametersFromConcreteJSONProduct("scanner", "equipment_manufacturer"));
   
        model.addAttribute("search", search);
        logger.info("/previously_used_equipment");
        return "previous_use_equipments";
    }

    @RequestMapping(value="/previous_use_equipments/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchProduct(@ModelAttribute(value="search") SearchPUE search, BindingResult result){
    	logger.info("/previous_use_equipments/SEARCH");
    	return pueService.listSearchProduct(search);
    }
    
    @RequestMapping(value = "/admin/previous_use_equipments", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
        model.addAttribute("listProducts", pueService.listAllProduct());
        logger.info("/admin/previous_use_equipments");
        return "admin/previous_use_equipments";
    }

    @RequestMapping(value = "/admin/previous_use_equipments/{type}", method = RequestMethod.GET)	
    public String listConcreteTypePrinters(@PathVariable("type") String type, Model model) {
        
        if(type.equals("printers")){
        	ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        	
        	for(JSONObject product : pueService.listAllProduct()){
        		if(product.get("type").equals("printer")){
        			list.add(product);
        		}
        	}
        	model.addAttribute("productSubType", "none");
        	model.addAttribute("titleOfTable", "Список загруженных б/у принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("/admin/previous_use_equipments/printers");
            
            return "admin/products";
    		
    	} else if(type.equals("3d_printers")){
    		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        	
        	for(JSONObject product : pueService.listAllProduct()){
        		if(product.get("type").equals("3d_printer")){
        			list.add(product);
        		}
        	}
        	model.addAttribute("productSubType", "none");
        	model.addAttribute("titleOfTable", "Список загруженных б/у 3D принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "3d_printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("/admin/previous_use_equipments/3d_printers");
            
            return "admin/products";
            
    	} else if(type.equals("digital_printers")){
    		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        	
        	for(JSONObject product : pueService.listAllProduct()){
        		if(product.get("type").equals("digital_printer")){
        			list.add(product);
        		}
        	}
        	model.addAttribute("productSubType", "none");
        	model.addAttribute("titleOfTable", "Список загруженных б/у цыфрового оборудования");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "digital_printer");
    		model.addAttribute("nameProduct", "Имя товара");
            model.addAttribute("title", "Цыфровое оборудование");
            model.addAttribute("addProduct", "Добавить цыфровое оборудование");
            logger.info("/admin/previous_use_equipments/digital_printers");
            
            return "admin/products";
             		
    	} else if(type.equals("laminators")){	
    		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        	
        	for(JSONObject product : pueService.listAllProduct()){
        		if(product.get("type").equals("laminator")){
        			list.add(product);
        		}
        	}
        	model.addAttribute("productSubType", "none");
        	model.addAttribute("titleOfTable", "Список загруженных б/у ламинаторов");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "laminator");
    		model.addAttribute("nameProduct", "Имя ламинатора");
            model.addAttribute("title", "Б/У ламинаторы");
            model.addAttribute("addProduct", "Добавить ламинатор");
            logger.info("/admin/previous_use_equipments/laminators");
            
            return "admin/products";
    		
    	} else if(type.equals("lasers")){		
    		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        	
        	for(JSONObject product : pueService.listAllProduct()){
        		if(product.get("type").equals("laser")){
        			list.add(product);
        		}
        	}
        	model.addAttribute("productSubType", "none");
        	model.addAttribute("titleOfTable", "Список загруженных б/у лазеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "laser");
    		model.addAttribute("nameProduct", "Имя лазера");
            model.addAttribute("title", "Б/У лазеры");
            model.addAttribute("addProduct", "Добавить лазер");
            logger.info("/admin/previous_use_equipments/lasers");
            
            return "admin/products";
    		
    	} else if(type.equals("cutters")){    		
    		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        	
        	for(JSONObject product : pueService.listAllProduct()){
        		if(product.get("type").equals("cutter")){
        			list.add(product);
        		}
        	}
        	model.addAttribute("productSubType", "none");
        	model.addAttribute("titleOfTable", "Список загруженных б/у граверов/фрезеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "cutter");
    		model.addAttribute("nameProduct", "Имя гравера/фрезера");
            model.addAttribute("title", "Б/У гравер/фрезер");
            model.addAttribute("addProduct", "Добавить гравер/фрезер");
            logger.info("/admin/previous_use_equipments/cutters");
            
            return "admin/products";
    		
    	} else if(type.equals("scanners")){  		
    		ArrayList<JSONObject> list = new ArrayList<JSONObject>();
        	
        	for(JSONObject product : pueService.listAllProduct()){
        		if(product.get("type").equals("scanner")){
        			list.add(product);
        		}
        	}
        	model.addAttribute("productSubType", "none");
        	model.addAttribute("titleOfTable", "Список загруженных б/у сканеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "scanner");
    		model.addAttribute("nameProduct", "Имя сканера");
            model.addAttribute("title", "Б/У сканера");
            model.addAttribute("addProduct", "Добавить сканер");
            logger.info("/admin/previous_use_equipments/scanners");
            
            return "admin/products";
    		
    	} else {
            return "redirect:/admin/previous_use_equipments";
    	}
    }

}

