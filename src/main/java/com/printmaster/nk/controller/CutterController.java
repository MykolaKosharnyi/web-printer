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
import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.model.SearchCutters;
import com.printmaster.nk.service.CutterService;

@Controller
public class CutterController {
	
	private Logger logger = Logger.getLogger(CutterController.class);
	
	private String directory = "/var/www/localhost/images";

	private String concreteFolder = "cutters";
	
	@Autowired
	private LinksForProducts links;
	
	@Autowired
    ComponetsForController componets;

    @Autowired
    PicturesContainer files;
 
    private CutterService cutterService;
    
    @Autowired(required=true)
    @Qualifier(value="cutterService")
    public void setPrinterService(CutterService ps){
        this.cutterService = ps;
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
    
	@ModelAttribute("typeCutter")
	public Map<String, String> typeLaser(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Для обработки дерева", "Для обработки дерева");
		m.put("Для обработки металла", "Для обработки металла");
		m.put("Для обработки камня", "Для обработки камня");
		return m;
	}
	
	@ModelAttribute("engravingStyle")
	public Map<String, String> engravingStyle(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Ударный", "Ударный");
		m.put("Режущий", "Режущий");
		return m;
	}
	
	@ModelAttribute("typeEngine")
	public Map<String, String> typeEngine(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Серво двигатель", "Серво двигатель");
		m.put("Шаговый двигатель", "Шаговый двигатель");
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
	
	@ModelAttribute("mountingTool")
	public Map<String, String> mountingTool(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Зажимные цанги", "Зажимные цанги");
		return m;
	}
	
	@ModelAttribute("equipmentManufacturer")
	public Map<String, String> equipmentManufacturer(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Esco Grafics", "Esco Grafics");
		m.put("JHF", "JHF");
		m.put("Agfa", "Agfa");
		m.put("Hongda boke", "Hongda boke");
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
	
	@ModelAttribute("software")
	public Map<String, String> software(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Art Cam", "Art Cam");
		m.put("Art Cut", "Art Cut");
		return m;
	}
	
	@RequestMapping(value = "/cutters", method = RequestMethod.GET)	
    public String allCutters(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfCutter(this.cutterService.listShowOnSite()));
        SearchCutters search = new SearchCutters();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        model.addAttribute("type", "cutter");
        logger.info("On '../cutters' page.");
        return "cutters";
    }
	
	@RequestMapping(value = "/cutters/{type}", method = RequestMethod.GET)	
    public String typeCutters(@PathVariable("type") String type, Model model) {
        SearchCutters search = new SearchCutters();
        String currentType = null;

        	if(type.equals("for_wood")){
        		currentType = "Для обработки дерева";
        		logger.info("On the /cutters/" + type + " page.");
        		
        	} else if(type.equals("for_the_treatment_of_metal")){
        		currentType = "Для обработки металла";
        		logger.info("On the /cutters/" + type + " page.");
        		
        	} else if(type.equals("stone_processing")){
        		currentType = "Для обработки камня";
        		logger.info("On the /cutters/" + type + " page.");
        		
        	} else {
        		return "redirect:/";
        	}
        
        String[] a = {currentType};
        search.setTypeCutter(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        model.addAttribute("listProducts", componets.showSimplestArrayOfCutter(cutterService.listSearchCutters(search)));
        model.addAttribute("type", "cutter");
        return "cutters/" + type ;
    }

    @RequestMapping(value="/cutters/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchCutters(@ModelAttribute(value="search") SearchCutters search, BindingResult result ){
    	logger.info("On the /cutter/search page.");
    	return componets.showSimplestArrayOfCutter(cutterService.listSearchCutters(search));
    }
	
    @RequestMapping("/cutter/{id}")
    public String showCutter(@PathVariable("id") long id, Model model){
    	logger.info("/cutter/" + id + " page.");
        model.addAttribute("product", cutterService.getCutterById(id));
        return "cutter";
    }
    
	@RequestMapping(value = "/admin/cutters", method = RequestMethod.GET)	
    public String listCutters(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров");
        model.addAttribute("listProducts", cutterService.listCutters());
        logger.info("/admin/cutters page.");
        return "admin/cutters";
    }
	
	@RequestMapping(value = "/admin/cutters/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeCutters(@PathVariable("type") String type, Model model) {
	
        if(type.equals("for_wood")){
        	List<Cutter> list = new ArrayList<Cutter>();
        	
        	for(Cutter cutter : cutterService.listCutters()){
        		if(cutter.getTypeCutter().equals("Для обработки дерева")){
        			list.add(cutter);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров для обработки дерева");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/cutters/for_wood page.");
            
            return "admin/cutters";
    		
    	} else if(type.equals("for_the_treatment_of_metal")){
    		List<Cutter> list = new ArrayList<Cutter>();
        	
        	for(Cutter cutter : cutterService.listCutters()){
        		if(cutter.getTypeCutter().equals("Для обработки металла")){
        			list.add(cutter);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров для обработки металла");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/cutters/for_the_treatment_of_metal page.");
            
            return "admin/cutters";
            
    	} else if(type.equals("stone_processing")){
    		List<Cutter> list = new ArrayList<Cutter>();
        	
        	for(Cutter cutter : cutterService.listCutters()){
        		if(cutter.getTypeCutter().equals("Для обработки камня")){
        			list.add(cutter);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров для обработки камня");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/cutters/stone_processing");
            
            return "admin/cutters";
             		
    	} else {
    		model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров");
            model.addAttribute("listProducts", cutterService.listCutters());
            logger.info("/admin/cutters page.");
            return "admin/cutters";
    	}
    }
	
	@RequestMapping(value = "/admin/cutter/new", method = RequestMethod.GET)
	public ModelAndView addNewCutter() {
		files.clear();
		logger.info("/admin/cutter/new page.");
	    return new ModelAndView("admin/cutter", "product", new Cutter());
	}
     
	@RequestMapping(value = "/admin/cutter/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result) throws IOException{
		
			if (result.hasErrors()) {
	            return new ModelAndView("admin/cutter", "product", product);
	        }

            long id = cutterService.addCutter(product);
            logger.info("Create new cutter! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	logger.info("Create new cutter directory! With id=" + id);
            } else {
            	logger.error("Don't create new cutter directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to cutter with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to cutter with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the cutter with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to cutter with id=" + id, e);
				}
			}
			
            this.cutterService.updateCutter(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/cutters"); 
		  mav.addObject("listProducts", cutterService.listCutters());
		  
		  links.createLinksForCutters(cutterService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "cutter");
	    	
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
	@RequestMapping(value = "/admin/cutter/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result) throws IOException{
		
			if (result.hasErrors()) {
	            return new ModelAndView("admin/cutter", "product", product);
	        }

            long id = cutterService.addCutter(product);
            logger.info("Create new cutter! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	logger.info("Create new cutter directory! With id=" + id);
            } else {
            	logger.error("Don't create new cutter directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to cutter with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to cutter with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the cutter with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to cutter with id=" + id, e);
				}
			}
			
            this.cutterService.updateCutter(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/cutter/edit/" + id); 
		  
		  links.createLinksForCutters(cutterService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
	    		componets.updateInLeftField(product, true, "cutter");
	    	
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
    @RequestMapping("/admin/cutter/edit/{id}")
    public String editCutter(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing cutter with id=" + id);
    	files.clear();
    	Cutter undateCutter = cutterService.getCutterById(id);
    	
    	FileMeta fm = null;
    	for(String path : undateCutter.getPathPictures()){
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
        model.addAttribute("product", undateCutter);
        return "admin/cutter";
    }
	
	@RequestMapping(value = "/admin/cutter/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSaveCutter(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/cutter", "product", product);
        }
		
		logger.info("cutter UPDATE with save, id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to cutter with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to cutter with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the cutter with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to cutter with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
		cutterService.updateCutter(product);
        logger.info("cutter with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForCutters(cutterService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, "cutter");
		  
		logger.info("Update links to the products in left menu!");
		ModelAndView mav = new ModelAndView("redirect:/admin/cutter/edit/" + product.getId());
		return mav;
	}
	
	@RequestMapping(value = "/admin/cutter/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateCutter(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/cutter", "product", product);
        }
		
		logger.info("cutter UPDATE id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to cutter with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to cutter with id = " + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the cutter with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to cutter with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
		cutterService.updateCutter(product);
        logger.info("cutter with id=" + product.getId() + " was UDPATED!");
        
		ModelAndView mav = new ModelAndView("redirect:/admin/cutters"); 
		  mav.addObject("listProducts", cutterService.listCutters());
		  files.clear();
		  
		  links.createLinksForCutters(cutterService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
	    		componets.updateInLeftField(product, true, "cutter");
		  
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
    @RequestMapping(value="/admin/cutter/upload_pictures", method = RequestMethod.POST)
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
    
    @RequestMapping(value="/admin/cutter/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
    
    @RequestMapping(value="/admin/cutter/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
    
    @RequestMapping("/admin/cutter/remove/{id}")
    public String removeCutter(@PathVariable("id") long id){
    		logger.info("Start deleting cutter from database, id=" + id);
    		try {
    			FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
    			logger.info("deleted all pictures and pictures directory of this cutter");
			} catch (IOException e) {
				logger.error("Deleting all pictures from this cutter has a problem: ", e);
			}
    		
    		logger.info("Update links to the products in left menu!");

    		componets.updateInLeftField(cutterService.getCutterById(id), false, "cutter");
    		
    		logger.info("DELETE cutter with id=" + id + " from database!");
    		cutterService.removeCutter(id);
        
    		links.createLinksForCutters(cutterService.listShowOnSite());
    		
        return "redirect:/admin/cutters";
    }  
    
    @RequestMapping(value="/admin/cutter/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter cutter = cutterService.getCutterById(id);
    	cutter.setShowOnSite(value);
    	cutterService.updateCutter(cutter);
    	
    	if (cutter.isShowOnSite() && cutter.isShowOnLeftSide()){
    		componets.updateInLeftField(cutter, true, "cutter");
    	} else {
    		componets.updateInLeftField(cutter, false, "cutter");
    	}
    	
    	links.createLinksForCutters(cutterService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/cutter/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter cutter = cutterService.getCutterById(id);
    	cutter.setShowOnHomePage(value);
    	cutterService.updateCutter(cutter);
    }
    
    @RequestMapping(value="/admin/cutter/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter cutter = cutterService.getCutterById(id);
    	cutter.setShowOnLeftSide(value);
    	cutterService.updateCutter(cutter);
    	
    	if (cutter.isShowOnSite() && cutter.isShowOnLeftSide()){
    		componets.updateInLeftField(cutter, true, "cutter");
    	} else {
    		componets.updateInLeftField(cutter, false, "cutter");
    	}
    		
    }
}
