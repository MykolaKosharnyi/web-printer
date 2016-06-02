package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

import com.printmaster.nk.beans.ComponetsForController;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;
import com.printmaster.nk.service.PrinterService;
import com.printmaster.nk.service.UseWithProductService;

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
    
    private UseWithProductService useWithProductService;
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }
	
	@RequestMapping(value = "/printers", method = RequestMethod.GET)	
    public String allPrinters(Model model) {
		
        model.addAttribute("listProducts", componets.showSimplestArrayOfPrinter(this.printerService.listShowOnSite()));
        SearchPrinters search = new SearchPrinters();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        model.addAttribute("type", "printer");
        logger.info("On '../printers' page.");
        
        logger.info("All characteristic of printer.");
		try {
			model.addAttribute("printer", (JSONObject)new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
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
        model.addAttribute("type", "printer");
        
        logger.info("All characteristic of printer.");
		try {
			model.addAttribute("printer", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
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
        
        Printer product = printerService.getPrinterById(id);
        model.addAttribute("product", product);
        if(product.getIdUseWithProduct()!=null){
        	model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(useWithProductService.getUseWithProductsByIds(product.getIdUseWithProduct())));
        } else {
        	model.addAttribute("uwp", null);
        }
        return "printer";
    }
    
	@RequestMapping(value = "/admin/printers", method = RequestMethod.GET)	
    public String listPrinters(Model model) {

		model.addAttribute("titleOfTable", "Список загруженных принтеров");
        model.addAttribute("listProducts", printerService.listPrinters("id"));
        
		model.addAttribute("productType", "printer");
		model.addAttribute("nameProduct", "Имя принтера");
        model.addAttribute("title", "Принтеры");
        model.addAttribute("addProduct", "Добавить принтер");
        model.addAttribute("productSubType", "none");
        logger.info("/admin/printers page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/printers/{type}", method = RequestMethod.GET)	
    public String listConcreteTypePrinters(@PathVariable("type") String type, Model model) {
        
		List<Printer> list = new ArrayList<Printer>();
        if(type.equals("dissolving")){

        	for(Printer printer : printerService.listPrinters("id")){
        		if(printer.getTypePrinter().equals("Сольвентный")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "dissolving");
        	model.addAttribute("titleOfTable", "Список загруженных сольвентных принтеров");
            model.addAttribute("listProducts", list);
            
            logger.info("On /admin/printers/dissolving page.");
    		
    	} else if(type.equals("ecosolvent")){
        	
        	for(Printer printer : printerService.listPrinters("id")){
        		if(printer.getTypePrinter().equals("Экосольвентный")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "ecosolvent");
        	model.addAttribute("titleOfTable", "Список загруженных экосольвентных принтеров");
            model.addAttribute("listProducts", list);
            
            logger.info("On /admin/printers/ecosolvent page.");
            
    	} else if(type.equals("UV_roll")){
        	
        	for(Printer printer : printerService.listPrinters("id")){
        		if(printer.getTypePrinter().equals("UV рулонный")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "UV_roll");
        	model.addAttribute("titleOfTable", "Список загруженных UV рулонных принтеров");
            model.addAttribute("listProducts", list);
            
            logger.info("On /admin/printers/UV_roll page.");
             		
    	} else if(type.equals("UV_flatbed")){	
        	
        	for(Printer printer : printerService.listPrinters("id")){
        		if(printer.getTypePrinter().equals("UV плоскопечатный")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "UV_flatbed");
        	model.addAttribute("titleOfTable", "Список загруженных UV плоскопечатных принтеров");
            model.addAttribute("listProducts", list);
            
            logger.info("On /admin/printers/UV_flatbed page.");
    		
    	} else if(type.equals("sublimation")){		
        	
        	for(Printer printer : printerService.listPrinters("id")){
        		if(printer.getTypePrinter().equals("Сублимационный")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "sublimation");
        	model.addAttribute("titleOfTable", "Список загруженных сублимационных принтеров");
            model.addAttribute("listProducts", list);
            
            logger.info("On /admin/printers/sublimation page.");
    		
    	} else if(type.equals("textile")){    		
        	
        	for(Printer printer : printerService.listPrinters("id")){
        		if(printer.getTypePrinter().equals("Текстильный")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "textile");
        	model.addAttribute("titleOfTable", "Список загруженных текстильных принтеров");
            model.addAttribute("listProducts", list);

            logger.info("On /admin/printers/textile page.");
    		
    	} else if(type.equals("water_pigment")){  		
        	
        	for(Printer printer : printerService.listPrinters("id")){
        		if(printer.getTypePrinter().equals("Водный/Пигментный")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "water_pigment");
        	model.addAttribute("titleOfTable", "Список загруженных водных/пигментных принтеров");
            model.addAttribute("listProducts", list);

            logger.info("On /admin/printers/water_pigment page.");
    		
    	} else if(type.equals("SAPR-GIS")){
        	
        	for(Printer printer : printerService.listPrinters("id")){
        		if(printer.getTypePrinter().equals("САПР/ГИС")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "SAPR-GIS");
        	model.addAttribute("titleOfTable", "Список загруженных САПР/ГИС принтеров");
            model.addAttribute("listProducts", list);
            
            logger.info("On /admin/printers/SAPR-GIS page.");
    		
    	} else {
    		model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных принтеров");
            model.addAttribute("listProducts", printerService.listPrinters("id"));
            logger.info("/admin/printers page.");
    	}
        
        model.addAttribute("productType", "printer");
		model.addAttribute("nameProduct", "Имя принтера");
        model.addAttribute("title", "Принтеры");
        model.addAttribute("addProduct", "Добавить принтер");
        
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/printer/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Printer> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<Printer> list = new ArrayList<Printer>();
        if(type.equals("dissolving")){

        	for(Printer printer : printerService.listPrinters(value)){
        		if(printer.getTypePrinter().equals("Сольвентный")){
        			list.add(printer);
        		}
        	}
    	} else if(type.equals("ecosolvent")){
        	
        	for(Printer printer : printerService.listPrinters(value)){
        		if(printer.getTypePrinter().equals("Экосольвентный")){
        			list.add(printer);
        		}
        	}
    	} else if(type.equals("UV_roll")){
        	
        	for(Printer printer : printerService.listPrinters(value)){
        		if(printer.getTypePrinter().equals("UV рулонный")){
        			list.add(printer);
        		}
        	} 		
    	} else if(type.equals("UV_flatbed")){	
        	
        	for(Printer printer : printerService.listPrinters(value)){
        		if(printer.getTypePrinter().equals("UV плоскопечатный")){
        			list.add(printer);
        		}
        	}
    	} else if(type.equals("sublimation")){		
        	
        	for(Printer printer : printerService.listPrinters(value)){
        		if(printer.getTypePrinter().equals("Сублимационный")){
        			list.add(printer);
        		}
        	}
    	} else if(type.equals("textile")){    		
        	
        	for(Printer printer : printerService.listPrinters(value)){
        		if(printer.getTypePrinter().equals("Текстильный")){
        			list.add(printer);
        		}
        	}
    	} else if(type.equals("water_pigment")){  		
        	
        	for(Printer printer : printerService.listPrinters(value)){
        		if(printer.getTypePrinter().equals("Водный/Пигментный")){
        			list.add(printer);
        		}
        	}
    	} else if(type.equals("SAPR-GIS")){
        	
        	for(Printer printer : printerService.listPrinters(value)){
        		if(printer.getTypePrinter().equals("САПР/ГИС")){
        			list.add(printer);
        		}
        	}
    	} else {
    		list.addAll(printerService.listPrinters(value));
    	}

		return list;
    }
	
	@RequestMapping(value = "/admin/printer/new", method = RequestMethod.GET)
	public String addNewPrinter(Model model) {
		files.clear();
		logger.info("/admin/printer/new page.");
		
		 logger.info("All characteristic of printer.");
		 model.addAttribute("product", new Printer());
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", "printer");
		 
		try {
			model.addAttribute("printer", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
	    return "admin/printer";
	}
     
	@RequestMapping(value = "/admin/printer/add", method = RequestMethod.POST) 
	public String handleFormUpload(/*
			@RequestParam("files") MultipartFile[] request, */@ModelAttribute("product") @Valid Printer product,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "printer");
				try {
					model.addAttribute("printer", (JSONObject)new JSONParser().
							parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8")));
				} catch (IOException | ParseException e) {}
	            return "admin/printer";
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
		  
		  links.createLinksForPrinters(printerService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "printer");
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/printers";
	}
	
	@RequestMapping(value = "/admin/printer/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Printer product,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "printer");
				try {
					model.addAttribute("printer", (JSONObject)new JSONParser().
							parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8")));
				} catch (IOException | ParseException e) {}
	            return "admin/printer";
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
		  
		  links.createLinksForPrinters(printerService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "printer");
	    	}
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/printer/edit/" + id;
	}
	
    @RequestMapping("/admin/printer/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing printer with id=" + id);
    	Printer undatePrinter = printerService.getPrinterById(id);
    	
        model.addAttribute("product", undatePrinter);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
        model.addAttribute("type", "printer");
        
        try {
			model.addAttribute("printer", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "admin/printer";
    }
	
	@RequestMapping(value = "/admin/printer/save_update", method = RequestMethod.POST) 
	public String updateSavePrinter(@ModelAttribute("product") @Valid Printer product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "printer");
			try {
				model.addAttribute("printer", (JSONObject)new JSONParser().
						parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
            return "admin/printer";
        }
		
		logger.info("PRINTER UPDATE with save, id=" + product.getId());
		
		List<String> pathPictures = printerService.getPrinterById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
        printerService.updatePrinter(product);
        logger.info("printer with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForPrinters(printerService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide()){
			componets.updateInLeftField(product, true, "printer");
	    }
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/printer/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/printer/update", method = RequestMethod.POST) 
	public String updatePrinter(@ModelAttribute("product") @Valid Printer product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "printer");
			try {
				model.addAttribute("printer", (JSONObject)new JSONParser().
						parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/printer.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
            return "admin/printer";
        }
		
		logger.info("PRINTER UPDATE id=" + product.getId());

		List<String> pathPictures = printerService.getPrinterById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
        printerService.updatePrinter(product);
        logger.info("printer with id=" + product.getId() + " was UDPATED!");
        
		  files.clear();
		  
		  links.createLinksForPrinters(printerService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "printer");
	    	}
		  
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/printers";
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
    
    @RequestMapping(value="/admin/printer/upload_pictures_update/{id}", method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesUpdate(MultipartHttpServletRequest request, @PathVariable("id") long id) {
    	logger.info("upload new picture");
        
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String fileName = null;

         while(itr.hasNext()){
        	mpf = request.getFile(itr.next()); 
     		fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 

 			try {
 				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + concreteFolder
	    				+ File.separator + id + File.separator + fileName));
 			} catch (IOException e) {
 				logger.error("Don't write picture to the folder", e);
 			} 
        	 
 			Printer product = printerService.getPrinterById(id);
 			product.getPathPictures().add(fileName);
 			printerService.updatePrinter(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/printer/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed printer product");
    	
    	Printer product = printerService.getPrinterById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	printerService.updatePrinter(product);
    }
    
    @RequestMapping(value="/admin/printer/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	Printer product = printerService.getPrinterById(id);
    	product.getPathPictures().remove(name);
    	
    	try {
    		FileUtils.forceDelete(new File(directory + File.separator + concreteFolder+ File.separator + id + File.separator + name));
		} catch (IOException e) {
			logger.error("Can't delete picture from the folder", e);
		} 
    	
    	if(product.getPathPictures().size()==0){
    		File fi = new File(directory + File.separator + "default.jpg");
			try {
				FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to printer with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	printerService.updatePrinter(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed printer product");
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
