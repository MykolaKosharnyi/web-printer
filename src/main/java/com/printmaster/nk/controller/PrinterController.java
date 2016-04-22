package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.printmaster.nk.beans.ComponetsForController;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;
import com.printmaster.nk.service.PrinterService;

@Controller
public class PrinterController {
	
	private Logger logger = Logger.getLogger(PrinterController.class);
	
	private String directory = "/var/www/localhost/images";
	private String concreteFolder = "printers";
	
	@Autowired
	private LinksForProducts links;

    @Autowired
    PicturesContainer files;
    
    @Autowired
    ComponetsForController componets;
 
    private PrinterService printerService;
    
    @Autowired(required=true)
    @Qualifier(value="printerService")
    public void setPrinterService(PrinterService ps){
        this.printerService = ps;
    }
    
	@ModelAttribute("delivery")
	public Map<String, String> delivery(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Первый способ", "Первый способ");
		m.put("Второй способ", "Второй способ");
		m.put("Третий способ", "Третий способ");
		return m;
	}
	
	@ModelAttribute("availability")
	public Map<String, String> availability(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("есть", "есть");
		m.put("нету", "нету");
		m.put("заканчивается", "заканчивается");
		m.put("под заказ", "под заказ");
		return m;
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
	
	@ModelAttribute("previouslyUsed")
	public Map<String, String> previouslyUsed(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("новое оборудование", "новое оборудование");
		m.put("демозальное оборудование", "демозальное оборудование");
		m.put("б/у", "б/у");
		return m;
	}
	
	@ModelAttribute("feeds")
	public Map<String, String> feeds(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Рулонный", "Рулонный");
		m.put("Плоскопечатный", "Плоскопечатный");
		m.put("Гибридный", "Гибридный");
		return m;
	}
	
	@ModelAttribute("sizeDrops")//размер капли
	public Map<String, String> sizeDrops(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("1,5", "1,5");
		m.put("2", "2");
		m.put("4", "4");
		m.put("8", "8");
		m.put("12", "12");
		m.put("15", "15");
		m.put("20", "20");
		m.put("30", "30");
		m.put("35", "35");
		m.put("40", "40");
		m.put("80", "80");
		return m;
	}
	
	@ModelAttribute("weightPrintMM")
	public Map<String, String> weightPrintMM(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("305", "305");
		m.put("457", "457");
		m.put("610", "610");
		m.put("914", "914");
		m.put("1070", "1070");
		m.put("1118", "1118");
		m.put("1524", "1524");
		m.put("1550", "1550");
		m.put("1600", "1600");
		m.put("1800", "1800");
		m.put("1900", "1900");
		m.put("2500", "2500");
		m.put("2540", "2540");
		m.put("2600", "2600");
		m.put("3200", "3200");
		m.put("3300", "3300");
		return m;
	}
	
	@ModelAttribute("typePrint")
	public Map<String, String> typePrint(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Термо-струйная", "Термо-струйная");
		m.put("Пьезо-струйная", "Пьезо-струйная");
		return m;
	}
	
	@ModelAttribute("chromaticity")
	public Map<String, String> chromaticity(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("CMYK", "CMYK");
		m.put("CMYK x 2", "CMYK x 2");
		m.put("CMYKLcLm", "CMYKLcLm");
		m.put("CMYKLcLmOG", "CMYKLcLmOG");
		return m;
	}
	
	@ModelAttribute("manufacturerPrinthead")
	public Map<String, String> manufacturerPrinthead(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Spectra", "Spectra");
		m.put("XAAR", "XAAR");
		m.put("SPT", "SPT");
		m.put("Konika-Minolta", "Konika-Minolta");
		m.put("Toshiba", "Toshiba");
		m.put("Ricoh", "Ricoh");
		m.put("Epson", "Epson");
		m.put("Lexmark", "Lexmark");
		return m;
	}
	
	@ModelAttribute("compatibleInk")
	public Map<String, String> compatibleInk(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Водные", "Водные");
		m.put("Пигментные", "Пигментные");
		m.put("Сублимационные", "Сублимационные");
		m.put("Экосольвентные", "Экосольвентные");
		m.put("Сольвентные", "Сольвентные");
		m.put("UV-чернила", "UV-чернила");
		m.put("Активные", "Активные");
		m.put("Кислотные", "Кислотные");
		m.put("Дисперсные", "Дисперсные");
		m.put("Текстильные", "Текстильные");
		m.put("Реактивные чернила", "Реактивные чернила");
		return m;
	}
	
	@ModelAttribute("typeDrops")
	public Map<String, String> typeDrops(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Постоянная", "Постоянная");
		m.put("Переменная", "Переменная");
		return m;
	}
	
	@ModelAttribute("printResolution")
	public Map<String, String> printResolution(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("360dpi", "360dpi");
		m.put("600dpi", "600dpi");
		m.put("720dpi", "720dpi");
		m.put("1200dpi", "1200dpi");
		m.put("1440dpi", "1440dpi");
		m.put("2880dpi", "2880dpi");
		return m;
	}
	
	@ModelAttribute("equipmentManufacturer")
	public Map<String, String> equipmentManufacturer(){
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
		m.put("ATEXCO", "ATEXCO");
		return m;
	}
	
	@ModelAttribute("interfaceConnection")
	public Map<String, String> interfaceConnection(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("SCSI", "SCSI");
		m.put("PCI Adapter", "PCI Adapter");
		m.put("USB", "USB");
		m.put("Fire-Wire", "Fire-Wire");
		return m;
	}
	
	@ModelAttribute("rip")
	public Map<String, String> rip(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("ONYX Graphics", "ONYX Graphics");
		m.put("SA International/PhotoPRINT™ Family", "SA International/PhotoPRINT™ Family");
		m.put("Wasatch SOFTRIP", "Wasatch SOFTRIP");
		m.put("ColorGATE Productionserver", "ColorGATE Productionserver");
		m.put("Poster Print", "Poster Print");
		m.put("Main Top", "Main Top");
		return m;
	}

	@ModelAttribute("resolution")
	public Map<String, String> resolution(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("None", "None");
		m.put("360x360", "360x360");
		m.put("360x540", "360x540");
		m.put("360x720", "360x720");
		m.put("540x360", "540x360");
		m.put("540x720", "540x720");
		m.put("540x900", "540x900");
		m.put("540x1080", "540x1080");
		m.put("720x360", "720x360");
		m.put("720x540", "720x540");
		m.put("720x720", "720x720");
		m.put("720x1080", "720x1080");
		m.put("720x1440", "720x1440");
		m.put("1440x720", "1440x720");
		m.put("1440x1440", "1440x1440");
		m.put("1440x2880", "1440x2880");
		m.put("2880x1440", "2880x1440");
		m.put("2880x2880", "2880x2880");
		return m;
	}
	
	@RequestMapping(value = "/printers", method = RequestMethod.GET)	
    public String allPrinters(Model model) {
		
        model.addAttribute("listProducts", componets.showSimplestArrayOfPrinter(this.printerService.listShowOnSite()));
        SearchPrinters search = new SearchPrinters();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        logger.info("On '../printers' page.");
        return "printers";
    }
	
	@RequestMapping(value = "/printers/{type}", method = RequestMethod.GET)	
    public String typePrinters(@PathVariable("type") String type, Model model) {
        SearchPrinters search = new SearchPrinters();
        String currentType = null;

        	if(type.equals("dissolving")){
        		currentType = "Сольвентный";
        		logger.info("On the /printer/" + type + " page.");
        		
        	} else if(type.equals("ecosolvent")){
        		currentType = "Экосольвентный";
        		logger.info("On the /printer/" + type + " page.");
        		
        	} else if(type.equals("UV_roll")){
        		currentType = "UV рулонный";
        		logger.info("On the /printer/" + type + " page.");
        		
        	} else if(type.equals("UV_flatbed")){
        		currentType = "UV плоскопечатный";
        		logger.info("On the /printer/" + type + " page.");
        		
        	} else if(type.equals("sublimation")){
        		currentType = "Сублимационный";
        		logger.info("On the /printer/" + type + " page.");
        		
        	} else if(type.equals("textile")){
        		currentType = "Текстильный";
        		logger.info("On the /printer/" + type + " page.");
        		
        	} else if(type.equals("water_pigment")){
        		currentType = "Водный/Пигментный";
        		logger.info("On the /printer/" + type + " page.");
        		
        	} else if(type.equals("SAPR-GIS")){
        		currentType = "САПР/ГИС";
        		logger.info("On the /printer/" + type + " page.");
        		
        	} else {
        		return "redirect:/";
        	}
        
        String[] a = {currentType};
        search.setTypePrinter(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);        
        model.addAttribute("listProducts", componets.showSimplestArrayOfPrinter(printerService.listSearchPrinters(search)));
        return "printers/" + type ;
    }

    @RequestMapping(value="/printers/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchPrinters(@ModelAttribute(value="search") SearchPrinters search, BindingResult result ){
    	logger.info("On the /printer/search page.");
    	return componets.showSimplestArrayOfPrinter(printerService.listSearchPrinters(search));
    }
	
    @RequestMapping("/printer/{id}")
    public String showPrinter(@PathVariable("id") long id, Model model){
    	logger.info("/printer/" + id + " page.");
        model.addAttribute("product", printerService.getPrinterById(id));
        return "printer";
    }
    
	@RequestMapping(value = "/admin/printers", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
		model.addAttribute("productType", "printer");
		model.addAttribute("nameProduct", "Имя принтера");
		model.addAttribute("titleOfTable", "Список загруженных принтеров");
        model.addAttribute("listProducts", printerService.listPrinters());
        model.addAttribute("title", "Принтеры");
        model.addAttribute("addProduct", "Добавить принтер");
        logger.info("/admin/printers page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/printers/{type}", method = RequestMethod.GET)	
    public String listConcreteTypePrinters(@PathVariable("type") String type, Model model) {
        
        if(type.equals("dissolving")){
        	List<Printer> list = new ArrayList<Printer>();
        	
        	for(Printer printer : printerService.listPrinters()){
        		if(printer.getTypePrinter().equals("Сольвентный")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных сольвентных принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("On /admin/printers/dissolving page.");
            
            return "admin/products";
    		
    	} else if(type.equals("ecosolvent")){
    		List<Printer> list = new ArrayList<Printer>();
        	
        	for(Printer printer : printerService.listPrinters()){
        		if(printer.getTypePrinter().equals("Экосольвентный")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных экосольвентных принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("On /admin/printers/ecosolvent page.");
            
            return "admin/products";
            
    	} else if(type.equals("UV_roll")){
    		List<Printer> list = new ArrayList<Printer>();
        	
        	for(Printer printer : printerService.listPrinters()){
        		if(printer.getTypePrinter().equals("UV рулонный")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных UV рулонных принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("On /admin/printers/UV_roll page.");
            
            return "admin/products";
             		
    	} else if(type.equals("UV_flatbed")){	
    		List<Printer> list = new ArrayList<Printer>();
        	
        	for(Printer printer : printerService.listPrinters()){
        		if(printer.getTypePrinter().equals("UV плоскопечатный")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных UV плоскопечатных принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("On /admin/printers/UV_flatbed page.");
            
            return "admin/products";
    		
    	} else if(type.equals("sublimation")){		
    		List<Printer> list = new ArrayList<Printer>();
        	
        	for(Printer printer : printerService.listPrinters()){
        		if(printer.getTypePrinter().equals("Сублимационный")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных сублимационных принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("On /admin/printers/sublimation page.");
            
            return "admin/products";
    		
    	} else if(type.equals("textile")){    		
    		List<Printer> list = new ArrayList<Printer>();
        	
        	for(Printer printer : printerService.listPrinters()){
        		if(printer.getTypePrinter().equals("Текстильный")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных текстильных принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("On /admin/printers/textile page.");
            
            return "admin/products";
    		
    	} else if(type.equals("water_pigment")){  		
    		List<Printer> list = new ArrayList<Printer>();
        	
        	for(Printer printer : printerService.listPrinters()){
        		if(printer.getTypePrinter().equals("Водный/Пигментный")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных водных/пигментных принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("On /admin/printers/water_pigment page.");
            
            return "admin/products";
    		
    	} else if(type.equals("SAPR-GIS")){
    		List<Printer> list = new ArrayList<Printer>();
        	
        	for(Printer printer : printerService.listPrinters()){
        		if(printer.getTypePrinter().equals("САПР/ГИС")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных САПР/ГИС принтеров");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("On /admin/printers/SAPR-GIS page.");
            
            return "admin/products";
    		
    	} else {
    		model.addAttribute("productType", "printer");
    		model.addAttribute("nameProduct", "Имя принтера");
    		model.addAttribute("titleOfTable", "Список загруженных принтеров");
            model.addAttribute("listProducts", printerService.listPrinters());
            model.addAttribute("title", "Принтеры");
            model.addAttribute("addProduct", "Добавить принтер");
            logger.info("/admin/printers page.");
            return "admin/products";
    	}
    }
	
	@RequestMapping(value = "/admin/printer/new", method = RequestMethod.GET)
	public ModelAndView addNewPrinter() {
		files.clear();
		logger.info("/admin/printer/new page.");
	    return new ModelAndView("admin/printer", "product", new Printer());
	}
     
	@RequestMapping(value = "/admin/printer/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(/*
			@RequestParam("files") MultipartFile[] request, */@ModelAttribute("product") @Valid Printer product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/printer", "product", product);
	        }
		
            long id = printerService.addPrinter(product);
            logger.info("Create new printer! With id=" + id);
  
  //          String phyPath = servletContext.getRealPath("/");

            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new printer directory! With id=" + id);
            } else {
            	logger.error("Don't create new printer directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to printer with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to printer with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the printer with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to printer with id=" + id, e);
				}
			}
			
            this.printerService.updatePrinter(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/printers"); 
		  mav.addObject("listProducts", printerService.listPrinters());
		  
		  links.createLinksForPrinters(printerService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "printer");
	    	
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
	@RequestMapping(value = "/admin/printer/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid Printer product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/printer", "product", product);
	        }
		
            long id = printerService.addPrinter(product);
            logger.info("Create new printer! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new printer directory! With id=" + id);
            } else {
            	logger.error("Don't create new printer directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to printer with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to printer with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the printer with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to printer with id=" + id, e);
				}
			}
			
            this.printerService.updatePrinter(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/printer/edit/" + id); 
		  
		  links.createLinksForPrinters(printerService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "printer");
	    	}
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
    @RequestMapping("/admin/printer/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing printer with id=" + id);
    	files.clear();
    	Printer undatePrinter = printerService.getPrinterById(id);
    	
    	FileMeta fm = null;
    	for(String path : undatePrinter.getPathPictures()){
    		fm = new FileMeta();
    		fm.setFileName(path);
    		
    		try {
    			File fi = new File(directory + File.separator + 
    					concreteFolder + File.separator + id + File.separator + path);
    			fm.setBytes(Files.readAllBytes(fi.toPath()));
    			logger.info("Load pictures from folder to the FILEMETA.");
			} catch (IOException e) {
				logger.error("Can't load pistures to the FILEMETA", e);
			}
    		files.add(fm);
    	}
        model.addAttribute("product", undatePrinter);
    //    model.addAttribute("listPrinters", this.printerService.listPrinters());
        return "admin/printer";
    }
	
	@RequestMapping(value = "/admin/printer/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSavePrinter(@ModelAttribute("product") @Valid Printer product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/printer", "product", product);
        }
		
		logger.info("PRINTER UPDATE with save, id=" + product.getId());
		
		FileUtils.cleanDirectory(new File(directory + File.separator + 
				concreteFolder + File.separator + product.getId()));
		logger.info("Clear directory with old pictures.");
		
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + 
        					concreteFolder + File.separator + product.getId() + File.separator + fm.getFileName()));
					product.getPathPictures().add(fm.getFileName());
					logger.info("Updatepath of the pictures to printer with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to printer with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the printer with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to printer with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
        printerService.updatePrinter(product);
        logger.info("printer with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForPrinters(printerService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide()){
			componets.updateInLeftField(product, true, "printer");
	    }
		  
		logger.info("Update links to the products in left menu!");
		ModelAndView mav = new ModelAndView("redirect:/admin/printer/edit/" + product.getId());
		return mav;
	}
	
	@RequestMapping(value = "/admin/printer/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updatePrinter(@ModelAttribute("product") @Valid Printer product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/printer", "product", product);
        }
		
		logger.info("PRINTER UPDATE id=" + product.getId());
		
		FileUtils.cleanDirectory(new File(directory + File.separator + 
				concreteFolder + File.separator + product.getId()));
		logger.info("Clear directory with old pictures.");
		
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + 
        					concreteFolder + File.separator + product.getId() + File.separator + fm.getFileName()));
					product.getPathPictures().add(fm.getFileName());
					logger.info("Updatepath of the pictures to printer with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to printer with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the printer with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to printer with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
        printerService.updatePrinter(product);
        logger.info("printer with id=" + product.getId() + " was UDPATED!");
        
		ModelAndView mav = new ModelAndView("redirect:/admin/printers"); 
		  mav.addObject("listProducts", printerService.listPrinters());
		  files.clear();
		  
		  links.createLinksForPrinters(printerService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "printer");
	    	}
		  
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
    @RequestMapping(value="/admin/printer/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {
    	logger.info("upload new picture");
        
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String fileName = null;

         while(itr.hasNext()){
             mpf = request.getFile(itr.next()); 
             
             FileMeta fileMeta = new FileMeta();
     		
     		 fileName = files.size() + new Random().nextInt(1000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 
             fileMeta.setFileName(fileName);

             try {
                fileMeta.setBytes(mpf.getBytes());
                logger.info("WRITED new picture to the FILEMETA.");
            } catch (IOException e) {
                logger.error("WRITTING picture to the FILEMETA has a problem: ",e);
            }
             
             logger.info("pictute added to the FILEMETA successful - " + fileMeta.getFileName());
             files.add(fileMeta);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/printer/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	System.out.println("------------------------");
    	System.out.println("Получение нового порядка");
    	logger.info("change order of pictures in FILEMETA");
    	for(String s : selectedIds){
    		System.out.println(s);
    	}
    	for(int i = 0; i < selectedIds.size(); i++){
    		for(int k = 0; k < files.size() ; k++){
        		if(files.get(k).getFileName().equals(selectedIds.get(i))){
        			Collections.swap(files.getFiles(), i, k);
        			break;
        		}
        	}
    	}
    	System.out.println("------------------------");
    	System.out.println("After sorting: ");
    	for(FileMeta s : files.getFiles()){
    		System.out.println(s.getFileName());
    	}
    	  	
    }
    
    @RequestMapping(value="/admin/printer/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	String name = namePicture.replace(":", ".");
    	System.out.println("------------------------");
    	System.out.println("ID: " + name);
    	System.out.println("Before removing");
    	for(FileMeta s : files.getFiles()){
    		System.out.println(s.getFileName());
    	}
    		Iterator<FileMeta> fmi = files.getFiles().iterator();
    		while(fmi.hasNext()){
        		if(fmi.next().getFileName().equals(name)){
        			fmi.remove();
        			break;
        		}
        	}
    		logger.info("Remove pictore with name=" + namePicture + "from FILEMETA");
    	System.out.println("------------------------");
    	System.out.println("After removing: ");
    	for(FileMeta s : files.getFiles()){
    		System.out.println(s.getFileName());
    	}	
    }
    
    @RequestMapping("/admin/printer/remove/{id}")
    public String removePrinter(@PathVariable("id") long id){
    		logger.info("Start deleting printer from database, id=" + id);
    		try {
    			FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
    			logger.info("deleted all pictures and pictures directory of this printer");
			} catch (IOException e) {
				logger.error("Deleting all pictures from this printer has a problem: ", e);
			}
    		
    		logger.info("Update links to the products in left menu!");
    		
    		componets.updateInLeftField(printerService.getPrinterById(id), false, "printer");
    		
    		logger.info("DELETE printer with id=" + id + " from database!");
    		printerService.removePrinter(id);
        
    		links.createLinksForPrinters(printerService.listShowOnSite());
    		
        return "redirect:/admin/printers";
    }  
    
    @RequestMapping(value="/admin/printer/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer printer = printerService.getPrinterById(id);
    	printer.setShowOnSite(value);
    	printerService.updatePrinter(printer);
    	
    	if (printer.isShowOnSite() && printer.isShowOnLeftSide()){
    		componets.updateInLeftField(printer, true, "printer");
    	} else {
    		componets.updateInLeftField(printer, false, "printer");
    	}
    	
    	links.createLinksForPrinters(printerService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/printer/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer printer = printerService.getPrinterById(id);
    	printer.setShowOnHomePage(value);
    	printerService.updatePrinter(printer);
    }
    
    @RequestMapping(value="/admin/printer/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer printer = printerService.getPrinterById(id);
    	printer.setShowOnLeftSide(value);
    	printerService.updatePrinter(printer);
    	
    	if (printer.isShowOnSite() && printer.isShowOnLeftSide()){
    		componets.updateInLeftField(printer, true, "printer");
    	} else {
    		componets.updateInLeftField(printer, false, "printer");
    	}
    		
    }
}
