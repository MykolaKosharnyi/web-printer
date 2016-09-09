package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
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
import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.SearchLasers;
import com.printmaster.nk.service.LaserService;
import com.printmaster.nk.service.UseWithProductService;

@Controller
public class LaserController {
	
	private Logger logger = Logger.getLogger(LaserController.class);
	
	private String directory = "/var/www/localhost/images";

	private String concreteFolder = "lasers";
	
	@Autowired
	private LinksForProducts links;
	
	@Autowired
    ComponetsForController componets;

    @Autowired
    PicturesContainer files;
 
    private LaserService laserService;
    
    @Autowired(required=true)
    @Qualifier(value="laserService")
    public void setPrinterService(LaserService ps){
        this.laserService = ps;
    }
    
    private UseWithProductService useWithProductService;
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }

	@RequestMapping(value = "/lasers", method = RequestMethod.GET)	
    public String allLasers(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfLaser(this.laserService.listShowOnSite()));
        SearchLasers search = new SearchLasers();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        model.addAttribute("type", "laser");
        logger.info("On '../lasers' page.");
        
        try {
			model.addAttribute("laser", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "lasers";
    }
	
	@RequestMapping(value = "/lasers/{type}", method = RequestMethod.GET)	
    public String typeLasers(@PathVariable("type") String type, Model model) {
        SearchLasers search = new SearchLasers();
        String currentType = null;

        	if(type.equals("CO2_gas_lasers")){
        		currentType = "Газовые лазеры СО2";
        		logger.info("On the /laser/" + type + " page.");
        		
        	} else if(type.equals("solid_state_lasers")){
        		currentType = "Твердотельные лазеры";
        		logger.info("On the /laser/" + type + " page.");
        		
        	} else if(type.equals("for_the_treatment_of_metal")){
        		currentType = "Для обработки метала";
        		logger.info("On the /laser/" + type + " page.");
        		
        	} else if(type.equals("diode_pumped")){
        		currentType = "С диодной накачкой";
        		logger.info("On the /laser/" + type + " page.");
        		
        	} else if(type.equals("fiber_lasers")){
        		currentType = "Оптоволоконные лазеры";
        		logger.info("On the /laser/" + type + " page.");
        		
        	} else if(type.equals("plasma_lasers")){
        		currentType = "Плазменные лазеры";
        		logger.info("On the /laser/" + type + " page.");
        		
        	} else {
        		return "redirect:/";
        	}
        
        String[] a = {currentType};
        search.setTypeLaser(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        model.addAttribute("listProducts", componets.showSimplestArrayOfLaser(laserService.listSearchLasers(search)));
        model.addAttribute("type", "laser");
        
        try {
			model.addAttribute("laser", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "lasers/" + type ;
    }

    @RequestMapping(value="/lasers/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchLasers(@ModelAttribute(value="search") SearchLasers search, BindingResult result ){
    	logger.info("On the /laser/search page.");
    	return componets.showSimplestArrayOfLaser(laserService.listSearchLasers(search));
    }
	
    @RequestMapping("/laser/{id}")
    public String showLaser(@PathVariable("id") long id, Model model){
    	logger.info("/laser/" + id + " page.");
        
        Laser product = laserService.getLaserById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", "laser");
        if(product.getIdUseWithProduct()!=null){
        	model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(useWithProductService.getUseWithProductsByIds(product.getIdUseWithProduct())));
        } else {
        	model.addAttribute("uwp", null);
        }
        return "laser";
    }
    
	@RequestMapping(value = "/admin/lasers", method = RequestMethod.GET)	
    public String listLasers(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных лазеров");
        model.addAttribute("listProducts", laserService.listLasers("id"));
        
        model.addAttribute("productType", "laser");
		model.addAttribute("nameProduct", "Имя лазера");
        model.addAttribute("title", "Лазера");
        model.addAttribute("addProduct", "Добавить лазер");
        model.addAttribute("productSubType", "none");
        logger.info("/admin/lasers page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/lasers/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeLasers(@PathVariable("type") String type, Model model) {
		
		List<Laser> list = new ArrayList<Laser>();
        if(type.equals("CO2_gas_lasers")){
        	for(Laser laser : laserService.listLasers("id")){
        		if(laser.getTypeLaser().equals("Газовые лазеры СО2")){
        			list.add(laser);
        		}
        	}
        	model.addAttribute("productSubType", "CO2_gas_lasers");
        	model.addAttribute("titleOfTable", "Список загруженных 'Газовые лазеры СО2'");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/CO2_gas_lasers page.");

    	} else if(type.equals("solid_state_lasers")){
        	for(Laser laser : laserService.listLasers("id")){
        		if(laser.getTypeLaser().equals("Твердотельные лазеры")){
        			list.add(laser);
        		}
        	}
        	model.addAttribute("productSubType", "solid_state_lasers");
        	model.addAttribute("titleOfTable", "Список загруженных лазеров 'Твердотельные лазеры'");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/solid_state_lasers page.");

    	} else if(type.equals("for_the_treatment_of_metal")){
        	for(Laser laser : laserService.listLasers("id")){
        		if(laser.getTypeLaser().equals("Для обработки метала")){
        			list.add(laser);
        		}
        	}
        	model.addAttribute("productSubType", "for_the_treatment_of_metal");
        	model.addAttribute("titleOfTable", "Список загруженных лазеров 'Для обработки метала'");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/for_the_treatment_of_metal.");
  		
    	} else if(type.equals("diode_pumped")){	
        	for(Laser laser : laserService.listLasers("id")){
        		if(laser.getTypeLaser().equals("С диодной накачкой")){
        			list.add(laser);
        		}
        	}
        	model.addAttribute("productSubType", "diode_pumped");
        	model.addAttribute("titleOfTable", "Список загруженных лазеров с диодной накачкой");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/diode_pumped page.");

    	} else if(type.equals("fiber_lasers")){	
        	for(Laser laser : laserService.listLasers("id")){
        		if(laser.getTypeLaser().equals("Оптоволоконные лазеры")){
        			list.add(laser);
        		}
        	}
        	model.addAttribute("productSubType", "fiber_lasers");
        	model.addAttribute("titleOfTable", "Список загруженных оптоволоконных лазеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/fiber_lasers page.");

    	} else if(type.equals("plasma_lasers")){	
        	for(Laser laser : laserService.listLasers("id")){
        		if(laser.getTypeLaser().equals("Плазменные лазеры")){
        			list.add(laser);
        		}
        	}
        	model.addAttribute("productSubType", "plasma_lasers");
        	model.addAttribute("titleOfTable", "Список загруженных плазменных лазеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/plasma_lasers page.");

    	} else {
    		model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных лазеров");
            model.addAttribute("listProducts", laserService.listLasers("id"));
            logger.info("/admin/lasers page.");
    	}
        model.addAttribute("productType", "laser");
		model.addAttribute("nameProduct", "Имя лазера");
        model.addAttribute("title", "Лазера");
        model.addAttribute("addProduct", "Добавить лазер");
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/laser/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Laser> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<Laser> list = new ArrayList<Laser>();
        if(type.equals("CO2_gas_lasers")){
        	for(Laser laser : laserService.listLasers(value)){
        		if(laser.getTypeLaser().equals("Газовые лазеры СО2")){
        			list.add(laser);
        		}
        	}
    	} else if(type.equals("solid_state_lasers")){
        	for(Laser laser : laserService.listLasers(value)){
        		if(laser.getTypeLaser().equals("Твердотельные лазеры")){
        			list.add(laser);
        		}
        	}
    	} else if(type.equals("for_the_treatment_of_metal")){
        	for(Laser laser : laserService.listLasers(value)){
        		if(laser.getTypeLaser().equals("Для обработки метала")){
        			list.add(laser);
        		}
        	}
    	} else if(type.equals("diode_pumped")){	
        	for(Laser laser : laserService.listLasers(value)){
        		if(laser.getTypeLaser().equals("С диодной накачкой")){
        			list.add(laser);
        		}
        	}
    	} else if(type.equals("fiber_lasers")){	
        	for(Laser laser : laserService.listLasers(value)){
        		if(laser.getTypeLaser().equals("Оптоволоконные лазеры")){
        			list.add(laser);
        		}
        	}
    	} else if(type.equals("plasma_lasers")){	
        	for(Laser laser : laserService.listLasers(value)){
        		if(laser.getTypeLaser().equals("Плазменные лазеры")){
        			list.add(laser);
        		}
        	}
    	} else {
    		list.addAll(laserService.listLasers(value));
    	}

		return list;
    }
	
	@RequestMapping(value = "/admin/laser/new", method = RequestMethod.GET)
	public String addNewLaser(Model model) {
		files.clear();
		logger.info("/admin/laser/new page.");
		model.addAttribute("product", new Laser());
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", "laser");
		model.addAttribute("productId", 0);
		 try {
				model.addAttribute("laser", (JSONObject)new JSONParser().
						parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
	    return "admin/laser";
	}
     
	@RequestMapping(value = "/admin/laser/copy/{id}", method = RequestMethod.GET)
	public String copyProduct(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info("/admin/laser/copy/" + id + " page.");
		
		 logger.info("Copy all characteristic of laser.");
		 Laser laser = laserService.getLaserById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer(laser.getPathPictures(), directory, concreteFolder, id, files);
		
		 /* set null to id because we must get create new product operation */
	     laser.setId(null);
		 model.addAttribute("product", laser);
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", "laser");
		 model.addAttribute("productId", id);
		 
		try {
			model.addAttribute("laser", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
	    return "admin/laser";
	}
	
	@RequestMapping(value = "/admin/laser/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid  Laser product,
			BindingResult result, Model model) throws IOException{
			
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "laser");
				try {
					model.addAttribute("laser", (JSONObject)new JSONParser().
							parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
				} catch (IOException | ParseException e) {}
	            return "admin/laser";
	        }

            long id = laserService.addLaser(product);
            logger.info("Create new laser! With id=" + id);
  
            //create folder and add to her new files
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            this.laserService.updateLaser(product);
            
            files.clear();
		  
		  links.createLinksForLasers(laserService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laser");
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/lasers";
	}
	
	@RequestMapping(value = "/admin/laser/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Laser product, BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "laser");
				try {
					model.addAttribute("laser", (JSONObject)new JSONParser().
							parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
				} catch (IOException | ParseException e) {}
	            return "admin/laser";
	        }
		
            long id = laserService.addLaser(product);
            logger.info("Create new laser! With id=" + id);
  
            //create folder and add to her new files
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            this.laserService.updateLaser(product);
            
            files.clear(); 
		  
		  links.createLinksForLasers(laserService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
	    		componets.updateInLeftField(product, true, "laser");
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/laser/edit/" + id;
	}
	
    @RequestMapping("/admin/laser/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing laser with id=" + id);
    	files.clear();
    	Laser undateLaser = laserService.getLaserById(id);
    	
        model.addAttribute("product", undateLaser);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
        model.addAttribute("type", "laser");
        try {
			model.addAttribute("laser", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "admin/laser";
    }
	
	@RequestMapping(value = "/admin/laser/save_update", method = RequestMethod.POST) 
	public String updateSaveLaser(@ModelAttribute("product") @Valid Laser product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "laser");
			try {
				model.addAttribute("laser", (JSONObject)new JSONParser().
						parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
            return "admin/laser";
        }
		
		logger.info("LASER UPDATE with save, id=" + product.getId());
		
		List<String> pathPictures = laserService.getLaserById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
        laserService.updateLaser(product);
        logger.info("laser with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForLasers(laserService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, "laser");
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/laser/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/laser/update", method = RequestMethod.POST) 
	public String updateLaser(@ModelAttribute("product") @Valid Laser product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "laser");
			try {
				model.addAttribute("laser", (JSONObject)new JSONParser().
						parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/laser.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
            return "admin/laser";
        }
		
		logger.info("LASER UPDATE id=" + product.getId());
		
		List<String> pathPictures = laserService.getLaserById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
        laserService.updateLaser(product);
        logger.info("laser with id=" + product.getId() + " was UDPATED!");

		  files.clear();
		  
		  links.createLinksForLasers(laserService.listShowOnSite());

		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laser");
		  
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/lasers";
	}
	
    @RequestMapping(value="/admin/laser/upload_pictures", method = RequestMethod.POST)
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
    
    @RequestMapping(value="/admin/laser/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	componets.changeOrderPictures(concreteFolder, selectedIds, files);  	  	
    }
    
    @RequestMapping(value="/admin/laser/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePicture(concreteFolder, namePicture, files);
    }
    
    @RequestMapping(value="/admin/laser/upload_pictures_update/{id}", method = RequestMethod.POST)
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
        	 
 			Laser product = laserService.getLaserById(id);
 			product.getPathPictures().add(fileName);
 			laserService.updateLaser(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/laser/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed laser product");
    	
    	Laser product = laserService.getLaserById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	laserService.updateLaser(product);
    }
    
    @RequestMapping(value="/admin/laser/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	Laser product = laserService.getLaserById(id);
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
				logger.error("Can't update path of the default picture to laser with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	laserService.updateLaser(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed laser product");
    }
    
    @RequestMapping("/admin/laser/remove/{id}")
    public String removeLaser(@PathVariable("id") long id){
    		logger.info("Start deleting laser from database, id=" + id);
    		try {
    			FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
    			logger.info("deleted all pictures and pictures directory of this laser");
			} catch (IOException e) {
				logger.error("Deleting all pictures from this laser has a problem: ", e);
			}
    		
    		logger.info("Update links to the products in left menu!");
    		componets.updateInLeftField(laserService.getLaserById(id), false, "laser");
    		
    		logger.info("DELETE laser with id=" + id + " from database!");
    		laserService.removeLaser(id);
        
    		links.createLinksForLasers(laserService.listShowOnSite());
    		
        return "redirect:/admin/lasers";
    }  
    
    @RequestMapping(value="/admin/laser/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laser laser = laserService.getLaserById(id);
    	laser.setShowOnSite(value);
    	laserService.updateLaser(laser);
    	
    	if (laser.isShowOnSite() && laser.isShowOnLeftSide()){
    		componets.updateInLeftField(laser, true, "laser");
    	} else {
    		componets.updateInLeftField(laser, false, "laser");
    	}
    	
    	links.createLinksForLasers(laserService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/laser/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laser laser = laserService.getLaserById(id);
    	laser.setShowOnHomePage(value);
    	laserService.updateLaser(laser);
    }
    
    @RequestMapping(value="/admin/laser/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laser laser = laserService.getLaserById(id);
    	laser.setShowOnLeftSide(value);
    	laserService.updateLaser(laser);
    	
    	if (laser.isShowOnSite() && laser.isShowOnLeftSide()){
    		componets.updateInLeftField(laser, true, "laser");
    	} else {
    		componets.updateInLeftField(laser, false, "laser");
    	}
    		
    }
}
