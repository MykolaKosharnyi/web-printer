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
import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.SearchLasers;
import com.printmaster.nk.service.LaserService;

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
    
	@ModelAttribute("delivery")
	public Map<String, String> delivery(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Первый способ", "Первый способ");
		m.put("Второй способ", "Второй способ");
		m.put("Третий способ", "Третий способ");
		return m;
	}
	
	@ModelAttribute("typeOfCooling")
	public Map<String, String> typeOfCooling(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Воздушное", "Воздушное");
		m.put("Водяное", "Водяное");
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
	
	@ModelAttribute("typeEngine")
	public Map<String, String> typeEngine(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Серво двигатель", "Серво двигатель");
		m.put("Шаговый двигатель", "Шаговый двигатель");
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
	
	@ModelAttribute("previouslyUsed")
	public Map<String, String> previouslyUsed(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("новое оборудование", "новое оборудование");
		m.put("демозальное оборудование", "демозальное оборудование");
		m.put("б/у", "б/у");
		return m;
	}
	
	@ModelAttribute("equipmentManufacturer")
	public Map<String, String> equipmentManufacturer(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Tander Jet", "Tander Jet");
		m.put("JHF", "JHF");
		m.put("Bodor", "Bodor");
		m.put("Chanxan", "Chanxan");
		return m;
	}
	
	@ModelAttribute("colorSeparation")
	public Map<String, String> colorSeparation(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Да", "Да");
		m.put("Нет", "Нет");
		return m;
	}
	
	@ModelAttribute("specialPurpose")
	public Map<String, String> specialPurpose(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Для маркирования поверхностей", "Для маркирования поверхностей");
		m.put("Для резки черных металлов", "Для резки черных металлов");
		m.put("Для резки цветных металлов", "Для резки цветных металлов");
		m.put("Для резки изделий из дерева", "Для резки изделий из дерева");
		m.put("Для резки изделий из стекла", "Для резки изделий из стекла");
		return m;
	}
	
	@ModelAttribute("typeTheDisplayedImage")
	public Map<String, String> typeTheDisplayedImage(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Контур", "Контур");
		m.put("Текст", "Текст");
		m.put("Штрих-код", "Штрих-код");
		m.put("Растровые изображения", "Растровые изображения");
		return m;
	}
	
	@ModelAttribute("connectionInterface")
	public Map<String, String> connectionInterface(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("SCSI", "SCSI");
		m.put("PCI Adapter", "PCI Adapter");
		m.put("USB", "USB");
		m.put("Fire-Wire", "Fire-Wire");
		return m;
	}
	
	@ModelAttribute("fileTypes")
	public Map<String, String> fileTypes(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("AI", "AI");
		m.put("DST", "DST");
		m.put("DXF", "DXF");
		m.put("PLT", "PLT");
		m.put("BMP", "BMP");
		m.put("DWG", "DWG");
		m.put("LAS", "LAS");
		m.put("JPG", "JPG");
		m.put("GIF", "GIF");
		m.put("TGA", "TGA");
		m.put("PNG", "PNG");
		m.put("TIF", "TIF");
		return m;
	}
	
	@ModelAttribute("software")
	public Map<String, String> software(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Corel Draw", "Corel Draw");
		m.put("Photoshop", "Photoshop");
		m.put("Auto CAD", "Auto CAD");
		m.put("TAJIMA", "TAJIMA");
		return m;
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
        model.addAttribute("product", laserService.getLaserById(id));
        return "laser";
    }
    
	@RequestMapping(value = "/admin/lasers", method = RequestMethod.GET)	
    public String listLasers(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных лазеров");
        model.addAttribute("listProducts", laserService.listLasers());
        logger.info("/admin/lasers page.");
        return "admin/lasers";
    }
	
	@RequestMapping(value = "/admin/lasers/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeLasers(@PathVariable("type") String type, Model model) {
		
        if(type.equals("CO2_gas_lasers")){
        	List<Laser> list = new ArrayList<Laser>();
        	
        	for(Laser laser : laserService.listLasers()){
        		if(laser.getTypeLaser().equals("Газовые лазеры СО2")){
        			list.add(laser);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных 'Газовые лазеры СО2'");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/CO2_gas_lasers page.");
            
            return "admin/lasers";
    		
    	} else if(type.equals("solid_state_lasers")){
    		List<Laser> list = new ArrayList<Laser>();
        	
        	for(Laser laser : laserService.listLasers()){
        		if(laser.getTypeLaser().equals("Твердотельные лазеры")){
        			list.add(laser);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных лазеров 'Твердотельные лазеры'");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/solid_state_lasers page.");
            
            return "admin/lasers";
            
    	} else if(type.equals("for_the_treatment_of_metal")){
    		List<Laser> list = new ArrayList<Laser>();
        	
        	for(Laser laser : laserService.listLasers()){
        		if(laser.getTypeLaser().equals("Для обработки метала")){
        			list.add(laser);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных лазеров 'Для обработки метала'");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/for_the_treatment_of_metal.");
            
            return "admin/lasers";
             		
    	} else if(type.equals("diode_pumped")){	
    		List<Laser> list = new ArrayList<Laser>();
        	
        	for(Laser laser : laserService.listLasers()){
        		if(laser.getTypeLaser().equals("С диодной накачкой")){
        			list.add(laser);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных лазеров с диодной накачкой");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/diode_pumped page.");
            
            return "admin/lasers";
    		
    	} else if(type.equals("fiber_lasers")){	
    		List<Laser> list = new ArrayList<Laser>();
        	
        	for(Laser laser : laserService.listLasers()){
        		if(laser.getTypeLaser().equals("Оптоволоконные лазеры")){
        			list.add(laser);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных оптоволоконных лазеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/fiber_lasers page.");
            
            return "admin/lasers";
    		
    	} else if(type.equals("plasma_lasers")){	
    		List<Laser> list = new ArrayList<Laser>();
        	
        	for(Laser laser : laserService.listLasers()){
        		if(laser.getTypeLaser().equals("Плазменные лазеры")){
        			list.add(laser);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных плазменных лазеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/lasers/plasma_lasers page.");
            
            return "admin/lasers";
    		
    	} else {
    		model.addAttribute("titleOfTable", "Список загруженных лазеров");
            model.addAttribute("listProducts", laserService.listLasers());
            logger.info("/admin/lasers page.");
            return "admin/lasers";
    	}
    }
	
	@RequestMapping(value = "/admin/laser/new", method = RequestMethod.GET)
	public ModelAndView addNewLaser() {
		files.clear();
		logger.info("/admin/laser/new page.");
	    return new ModelAndView("admin/laser", "product", new Laser());
	}
     
	@RequestMapping(value = "/admin/laser/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute("product") @Valid  Laser product,
			BindingResult result) throws IOException{
			
			if (result.hasErrors()) {
	            return new ModelAndView("admin/laser", "product", product);
	        }

            long id = laserService.addLaser(product);
            logger.info("Create new laser! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new laser directory! With id=" + id);
            } else {
            	logger.error("Don't create new laser directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to laser with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to laser with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the laser with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to laser with id=" + id, e);
				}
			}
			
            this.laserService.updateLaser(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/lasers"); 
		  mav.addObject("listProducts", laserService.listLasers());
		  
		  links.createLinksForLasers(laserService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laser");
	    	
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
	@RequestMapping(value = "/admin/laser/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid Laser product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/laser", "product", product);
	        }
		
            long id = laserService.addLaser(product);
            logger.info("Create new laser! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	logger.info("Create new laser directory! With id=" + id);
            } else {
            	logger.error("Don't create new laser directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to laser with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to laser with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the laser with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to laser with id=" + id, e);
				}
			}
			
            this.laserService.updateLaser(product);
            
            files.clear(); 
		  
		  links.createLinksForLasers(laserService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
	    		componets.updateInLeftField(product, true, "laser");
	    	
		  logger.info("Update links to the products in left menu!");
	   return new ModelAndView("redirect:/admin/laser/edit/" + id);
	}
	
    @RequestMapping("/admin/laser/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing laser with id=" + id);
    	files.clear();
    	Laser undateLaser = laserService.getLaserById(id);
    	
    	FileMeta fm = null;
    	for(String path : undateLaser.getPathPictures()){
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
        model.addAttribute("product", undateLaser);
        return "admin/laser";
    }
	
	@RequestMapping(value = "/admin/laser/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSaveLaser(@ModelAttribute("product") @Valid Laser product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/laser", "product", product);
        }
		
		logger.info("LASER UPDATE with save, id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to laser with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to laser with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the laser with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to laser with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
        laserService.updateLaser(product);
        logger.info("laser with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForLasers(laserService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, "laser");
		  
		logger.info("Update links to the products in left menu!");
		ModelAndView mav = new ModelAndView("redirect:/admin/laser/edit/" + product.getId());
		return mav;
	}
	
	@RequestMapping(value = "/admin/laser/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateLaser(@ModelAttribute("product") @Valid Laser product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/laser", "product", product);
        }
		
		logger.info("LASER UPDATE id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to laser with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to laser with id = " + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the laser with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to laser with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
        laserService.updateLaser(product);
        logger.info("laser with id=" + product.getId() + " was UDPATED!");
        
		ModelAndView mav = new ModelAndView("redirect:/admin/lasers"); 
		  mav.addObject("listProducts", laserService.listLasers());
		  files.clear();
		  
		  links.createLinksForLasers(laserService.listShowOnSite());

		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laser");
		  
		  logger.info("Update links to the products in left menu!");
	   return mav;
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
    	logger.info("change order of pictures in FILEMETA");
    	for(int i = 0; i < selectedIds.size(); i++){
    		for(int k = 0; k < files.size() ; k++){
        		if(files.get(k).getFileName().equals(selectedIds.get(i))){
        			Collections.swap(files.getFiles(), i, k);
        			break;
        		}
        	}
    	}   	  	
    }
    
    @RequestMapping(value="/admin/laser/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	String name = namePicture.replace(":", ".");
    		Iterator<FileMeta> fmi = files.getFiles().iterator();
    		while(fmi.hasNext()){
        		if(fmi.next().getFileName().equals(name)){
        			fmi.remove();
        			break;
        		}
        	}
    	logger.info("Remove pictore with name = " + namePicture + " from FILEMETA");
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
