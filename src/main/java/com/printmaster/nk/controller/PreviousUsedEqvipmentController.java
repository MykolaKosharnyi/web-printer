package com.printmaster.nk.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

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

import com.printmaster.nk.model.entity.search.SearchPUE;
import com.printmaster.nk.service.PreviousUsedEqvipmentService;

@Controller
public class PreviousUsedEqvipmentController {
	
	private Logger logger = Logger.getLogger(PreviousUsedEqvipmentController.class);
	
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
   
        model.addAttribute("search", search);
        logger.info("On '../previously used equipment' page.");
        return "previous_use_equipments";
    }

    @RequestMapping(value="/previous_use_equipments/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchProduct(@ModelAttribute(value="search") SearchPUE search, BindingResult result ){
    	logger.info("On the /previous_use_equipments/search page.");
    	return pueService.listSearchProduct(search);
    }
    
    @RequestMapping(value = "/admin/previous_use_equipments", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
        model.addAttribute("listProducts", pueService.listAllProduct());
        logger.info("/admin/previous_use_equipments page.");
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
            logger.info("On /admin/previous_use_equipments/printers page.");
            
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
            logger.info("On /admin/previous_use_equipments/3d_printers page.");
            
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
            logger.info("On /admin/previous_use_equipments/digital_printers page.");
            
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
            logger.info("On /admin/previous_use_equipments/laminators page.");
            
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
            logger.info("On /admin/previous_use_equipments/lasers page.");
            
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
            logger.info("On /admin/previous_use_equipments/cutters page.");
            
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
            logger.info("On /admin/previous_use_equipments/scanners page.");
            
            return "admin/products";
    		
    	} else {
            return "redirect:/admin/previous_use_equipments";
    	}
    }

	
	@ModelAttribute("typePrinter")
	public Map<String, String> typePrinter(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Сольвентный", "Сольвентный");
		m.put("Экосольвентный", "Экосольвентный");
		m.put("UV рулонный", "UV рулонный");
		
		m.put("UV плоскопечатный", "UV плоскопечатный");
		m.put("Сублимационный", "Сублимационный");
		m.put("Текстильный", "Текстильный");

		m.put("Водный/Пигментный", "Водный/Пигментный");
		m.put("САПР/ГИС", "САПР/ГИС");
		return m;
	}
	
	@ModelAttribute("printerEquipment")
	public Map<String, String> printerEquipment(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Epson", "Epson");
		m.put("Mimaki", "Mimaki");
		m.put("Roland", "Roland");
		m.put("HP", "HP");
		m.put("OCE", "OCE");
		m.put("Agfa", "Agfa");
		m.put("LIYU", "LIYU");
		m.put("Infinity", "Infinity");
		m.put("Gonzeng", "Gonzeng");
		m.put("Jong Ye", "Jong Ye");
		m.put("Brother", "Brother");
		m.put("Yueda", "Yueda");
		m.put("AZON", "AZON");
		m.put("Big Color", "Big Color");
		return m;
	}
	
	@ModelAttribute("type3dPrinter")
	public Map<String, String> type3dPrinter(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Экструдные FDM", "Экструдные FDM");
		m.put("Фото печать Polyjet", "Фото печать Polyjet");
		m.put("Лазерного спекания LENS", "Лазерного спекания LENS");
		m.put("Ламинация LOM", "Ламинация LOM");
		m.put("Стереолитография SL", "Стереолитография SL");
		m.put("Лазерное спекание LS", "Лазерное спекание LS");
		m.put("Порошкового склеивания 3DP", "Порошкового склеивания 3DP");
		return m;
	}
	
	@ModelAttribute("d3PrinterEquipment")
	public Map<String, String> d3PrinterEquipment(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("MakerBot", "MakerBot");
		m.put("3D Systems", "3D Systems");
		m.put("XYZ printing", "XYZ printing");
		m.put("PrintBox3D", "PrintBox3D");
		m.put("ProJet Accelerator Software", "ProJet Accelerator Software");
		m.put("3DTouch", "3DTouch");
		return m;
	}
	
	@ModelAttribute("typeDigitalPrinter")
	public Map<String, String> typeDigitalPrinter(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Полноцветное лазерное оборудование", "Полноцветное лазерное оборудование");
		m.put("Монохромное лазерное оборудование", "Монохромное лазерное оборудование");
		m.put("Полноцветное струйное оборудование", "Полноцветное струйное оборудование");
		return m;
	}
	
	@ModelAttribute("typeLaminator")
	public Map<String, String> typeLaminator(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Горячего ламинирования", "Горячего ламинирования");
		m.put("Холодного ламинирования", "Холодного ламинирования");
		m.put("Жидкостные", "Жидкостные");
		return m;
	}
	
	@ModelAttribute("laminatorEquipment")
	public Map<String, String> laminatorEquipment(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Kala", "Kala");
		m.put("Royal Sovereign", "Royal Sovereign");
		m.put("GMP", "GMP");
		m.put("Champion", "Champion");
		m.put("Aurora", "Aurora");
		m.put("GBC", "GBC");
		m.put("HF FGK", "HF FGK");
		m.put("Yingkai", "Yingkai");
		return m;
	}
	
	@ModelAttribute("typeLaser")
	public Map<String, String> typeLaser(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Газовые лазеры СО2", "Газовые лазеры СО2");
		m.put("Твердотельные лазеры", "Твердотельные лазеры");
		m.put("Для обработки метала", "Для обработки метала");
		m.put("С диодной накачкой", "С диодной накачкой");
		m.put("Оптоволоконные лазеры", "Оптоволоконные лазеры");
		m.put("Плазменные лазеры", "Плазменные лазеры");
		return m;
	}
	
	@ModelAttribute("laserEquipment")
	public Map<String, String> laserEquipment(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Tander Jet", "Tander Jet");
		m.put("JHF", "JHF");
		m.put("Bodor", "Bodor");
		m.put("Chanxan", "Chanxan");
		return m;
	}
	
	@ModelAttribute("typeCutter")
	public Map<String, String> typeCutter(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Для обработки дерева", "Для обработки дерева");
		m.put("Для обработки металла", "Для обработки металла");
		m.put("Для обработки камня", "Для обработки камня");
		return m;
	}
	
	@ModelAttribute("cutterEquipment")
	public Map<String, String> cutterEquipment(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Esco Grafics", "Esco Grafics");
		m.put("JHF", "JHF");
		m.put("Agfa", "Agfa");
		m.put("Hongda boke", "Hongda boke");
		return m;
	}
	
	@ModelAttribute("typeScanner")
	public Map<String, String> typeScanner(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Широкоформатные сканеры", "Широкоформатные сканеры");
		m.put("3D Сканеры", "3D Сканеры");
		return m;
	}
	
	@ModelAttribute("scannerEquipment")
	public Map<String, String> scannerEquipment(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Contex", "Contex");
		m.put("Vidar", "Vidar");
		return m;
	}
}

