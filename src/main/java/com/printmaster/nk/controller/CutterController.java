package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

import com.printmaster.nk.beans.ComponetsForController;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.model.SearchCutters;
import com.printmaster.nk.service.CutterService;
import com.printmaster.nk.service.UseWithProductService;

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
	
	private UseWithProductService useWithProductService;
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
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
        
        componets.setJSONtoModelAttribute(model, "cutter");
        
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
        
        componets.setJSONtoModelAttribute(model, "cutter");
        
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
        
        Cutter product = cutterService.getCutterById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", "cutter");
        if(product.getIdUseWithProduct()!=null){
        	model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(useWithProductService.getUseWithProductsByIds(product.getIdUseWithProduct())));
        } else {
        	model.addAttribute("uwp", null);
        }
        return "cutter";
    }
    
	@RequestMapping(value = "/admin/cutters", method = RequestMethod.GET)	
    public String listCutters(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров");
        model.addAttribute("listProducts", cutterService.listCutters("id"));
        logger.info("/admin/cutters page.");
        
        model.addAttribute("productType", "cutter");
		model.addAttribute("nameProduct", "Имя гравера/фрезера");
        model.addAttribute("title", "Гравера/фрезера");
        model.addAttribute("addProduct", "Добавить гравер/фрезер");
        model.addAttribute("productSubType", "none");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/cutters/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeCutters(@PathVariable("type") String type, Model model) {
		
		List<Cutter> list = new ArrayList<Cutter>();
        if(type.equals("for_wood")){

        	for(Cutter cutter : cutterService.listCutters("id")){
        		if(cutter.getTypeCutter().equals("Для обработки дерева")){
        			list.add(cutter);
        		}
        	}
        	model.addAttribute("productSubType", "for_wood");
        	model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров для обработки дерева");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/cutters/for_wood page.");
    		
    	} else if(type.equals("for_the_treatment_of_metal")){
        	
        	for(Cutter cutter : cutterService.listCutters("id")){
        		if(cutter.getTypeCutter().equals("Для обработки металла")){
        			list.add(cutter);
        		}
        	}
        	model.addAttribute("productSubType", "for_the_treatment_of_metal");
        	model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров для обработки металла");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/cutters/for_the_treatment_of_metal page.");
            
    	} else if(type.equals("stone_processing")){
        	
        	for(Cutter cutter : cutterService.listCutters("id")){
        		if(cutter.getTypeCutter().equals("Для обработки камня")){
        			list.add(cutter);
        		}
        	}
        	model.addAttribute("productSubType", "stone_processing");
        	model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров для обработки камня");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/cutters/stone_processing"); 
             		
    	} else {
    		model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров");
            model.addAttribute("listProducts", cutterService.listCutters("id"));
            logger.info("/admin/cutters page.");
    	}
        
        model.addAttribute("productType", "cutter");
		model.addAttribute("nameProduct", "Имя гравера/фрезера");
        model.addAttribute("title", "Гравера/фрезера");
        model.addAttribute("addProduct", "Добавить гравер/фрезер");
        
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/cutter/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Cutter> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<Cutter> list = new ArrayList<Cutter>();
        if(type.equals("for_wood")){

        	for(Cutter cutter : cutterService.listCutters(value)){
        		if(cutter.getTypeCutter().equals("Для обработки дерева")){
        			list.add(cutter);
        		}
        	}	
    	} else if(type.equals("for_the_treatment_of_metal")){
        	
        	for(Cutter cutter : cutterService.listCutters(value)){
        		if(cutter.getTypeCutter().equals("Для обработки металла")){
        			list.add(cutter);
        		}
        	}
    	} else if(type.equals("stone_processing")){
        	
        	for(Cutter cutter : cutterService.listCutters(value)){
        		if(cutter.getTypeCutter().equals("Для обработки камня")){
        			list.add(cutter);
        		}
        	}	
    	} else {
    		list.addAll(cutterService.listCutters(value));
    	}
		
		return list;
    }
	
	@RequestMapping(value = "/admin/cutter/new", method = RequestMethod.GET)
	public String addNewCutter(Model model) {
		files.clear();
		logger.info("/admin/cutter/new page.");
		model.addAttribute("product", new Cutter());
		
		componets.setJSONtoModelAttribute(model, "cutter");
		
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", "cutter");
		model.addAttribute("productId", 0);
	    return "admin/cutter";
	}
	
	@RequestMapping(value = "/admin/cutter/copy/{id}", method = RequestMethod.GET)
	public String copyProduct(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info("/admin/cutter/copy/" + id + " page.");
		
		 logger.info("Copy all characteristic of cutter.");
		 Cutter cutter = cutterService.getCutterById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer(cutter.getPathPictures(), directory, concreteFolder, id, files);
		
		 /* set null to id because we must get create new product operation */
	     cutter.setId(null);
		 model.addAttribute("product", cutter);
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", "cutter");
		 model.addAttribute("productId", id);
		 
		 componets.setJSONtoModelAttribute(model, "cutter");
	    return "admin/cutter";
	}
     
	@RequestMapping(value = "/admin/cutter/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model) throws IOException{
		
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "cutter");
				
				componets.setJSONtoModelAttribute(model, "cutter");
	            return "admin/cutter";
	        }

            long id = cutterService.addCutter(product);
            logger.info("Create new cutter! With id=" + id);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            this.cutterService.updateCutter(product);
            
            files.clear();
		
          //ModelAndView mav = new ModelAndView("redirect:/admin/cutters"); 
		 // mav.addObject("listProducts", cutterService.listCutters());
		  
		  links.createLinksForCutters(cutterService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "cutter");
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/cutters";
	}
	
	@RequestMapping(value = "/admin/cutter/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model) throws IOException{
		
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "cutter");
				
				componets.setJSONtoModelAttribute(model, "cutter");
	            return "admin/cutter";
	        }

            long id = cutterService.addCutter(product);
            logger.info("Create new cutter! With id=" + id);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            this.cutterService.updateCutter(product);
            
            files.clear();
		
          //ModelAndView mav = new ModelAndView("redirect:/admin/cutter/edit/" + id); 
		  
		  links.createLinksForCutters(cutterService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
	    		componets.updateInLeftField(product, true, "cutter");
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/cutter/edit/" + id;
	}
	
    @RequestMapping("/admin/cutter/edit/{id}")
    public String editCutter(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing cutter with id=" + id);
    	Cutter undateCutter = cutterService.getCutterById(id);
    	
        model.addAttribute("product", undateCutter);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(useWithProductService.listShowOnSite()));
        model.addAttribute("type", "cutter");
        componets.setJSONtoModelAttribute(model, "cutter");
        
        return "admin/cutter";
    }
	
	@RequestMapping(value = "/admin/cutter/save_update", method = RequestMethod.POST) 
	public String updateSaveCutter(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "cutter");
			
			componets.setJSONtoModelAttribute(model, "cutter");
            return "admin/cutter";
        }
		
		logger.info("cutter UPDATE with save, id=" + product.getId());
		
		List<String> pathPictures = cutterService.getCutterById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		cutterService.updateCutter(product);
        logger.info("cutter with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForCutters(cutterService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, "cutter");
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/cutter/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/cutter/update", method = RequestMethod.POST) 
	public String updateCutter(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "cutter");
			
			componets.setJSONtoModelAttribute(model, "cutter");
            return "admin/cutter";
        }
		
		logger.info("cutter UPDATE id=" + product.getId());
		List<String> pathPictures = cutterService.getCutterById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		cutterService.updateCutter(product);
        logger.info("cutter with id=" + product.getId() + " was UDPATED!");
        
		  files.clear();
		  
		  links.createLinksForCutters(cutterService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
	    		componets.updateInLeftField(product, true, "cutter");
		  
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/cutters";
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
    	componets.changeOrderPictures(concreteFolder, selectedIds, files); 	  	
    }
    
    @RequestMapping(value="/admin/cutter/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePicture(concreteFolder, namePicture, files);
    }
    
    @RequestMapping(value="/admin/cutter/upload_pictures_update/{id}", method = RequestMethod.POST)
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
        	 
 			Cutter product = cutterService.getCutterById(id);
 			product.getPathPictures().add(fileName);
 			cutterService.updateCutter(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/cutter/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed cutter product");
    	
    	Cutter product = cutterService.getCutterById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	cutterService.updateCutter(product);
    }
    
    @RequestMapping(value="/admin/cutter/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	Cutter product = cutterService.getCutterById(id);
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
				logger.error("Can't update path of the default picture to cutter with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	cutterService.updateCutter(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed cutter product");
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
    
    @RequestMapping(value="/admin/cutter/setTop/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter cutter = cutterService.getCutterById(id);
    	cutter.setTop(value);
    	cutterService.updateCutter(cutter);
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
