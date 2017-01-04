package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
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

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.SearchRips;
import com.printmaster.nk.service.RipService;

@Controller
public class RipController {
	
	private Logger logger = Logger.getLogger(RipController.class);
	
	private final static String DIRECTORY = "/var/www/localhost/images";
	private static final String TYPE = "rip";
	private static final String CONCRETE_FOLDER = TYPE + "s";

	@Autowired
	private LinksForProducts linksForProduct;

    @Autowired
    PicturesContainer files;
    
    @Autowired
    ComponentsForControllers componets;
 
    private RipService ripService;
    
    @Autowired(required=true)
    @Qualifier(value="ripService")
    public void setRipService(RipService ps){
        this.ripService = ps;
    }
    
	@RequestMapping(value = "/rips", method = RequestMethod.GET)	
    public String allRips(Model model) throws UnsupportedEncodingException, FileNotFoundException, IOException, ParseException {
		
        model.addAttribute("listProducts", componets.makeLightWeightCollectionOfProduct(this.ripService.listShowOnSite()));
        SearchRips search = new SearchRips();
        search.setPrise0(0);
        search.setPrise1(100000);

        logger.info("All characteristic of RIP.");
        model.addAttribute("type", "rip");
        componets.setJSONtoModelAttribute(model, "rip");
        
        model.addAttribute("search", search);
        logger.info("On '../rips' page.");
        return "rips";
    }

    @RequestMapping(value="/rips/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchRips(@ModelAttribute(value="search") SearchRips search, BindingResult result ){
    	logger.info("On the /rip/search page.");
    	return componets.makeLightWeightCollectionOfProduct(ripService.listSearchProducts(search));
    }
	
    @RequestMapping("/rip/{id}")
    public String showRip(@PathVariable("id") long id, Model model){
    	logger.info("/rip/" + id + " page.");
        model.addAttribute("product", ripService.getProductById(id));
        model.addAttribute("type", "rip");
        return "rip";
    }
    
	@RequestMapping(value = "/admin/rips", method = RequestMethod.GET)	
    public String listRips(Model model) {
		model.addAttribute("productType", "rip");
		model.addAttribute("nameProduct", "Наименование ПО");
		model.addAttribute("titleOfTable", "Список загруженного ПО");
        model.addAttribute("listProducts", ripService.listProducts("id"));
        model.addAttribute("title", "ПО");
        model.addAttribute("addProduct", "Добавить новое ПО");
        model.addAttribute("productSubType", "none");
        logger.info("/admin/rips page.");
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/rip/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Rip> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<Rip> list = new ArrayList<Rip>();
        if(type.equals("none")){
        	list.addAll(ripService.listProducts(value));
    	} else {
    		list.addAll(ripService.listProducts(value));
    	}

		return list;
    }
	
	@RequestMapping(value = "/admin/rip/new", method = RequestMethod.GET)
	public String addNewRip(Model model) throws UnsupportedEncodingException, FileNotFoundException, IOException, ParseException {
		files.clear();
		logger.info("/admin/rip/new page.");
		model.addAttribute("product", new Rip());
		model.addAttribute("type", "rip");
		model.addAttribute("productId", 0);
		
		logger.info("All characteristic of RIP.");
		componets.setJSONtoModelAttribute(model, "rip");
	    return "admin/rip";
	}
     
	@RequestMapping(value = "/admin/rip/copy/{id}", method = RequestMethod.GET)
	public String copyProduct(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info("/admin/rip/copy/" + id + " page.");
		
		 logger.info("Copy all characteristic of rip.");
		 Rip rip = ripService.getProductById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer(rip.getPathPictures(), DIRECTORY, CONCRETE_FOLDER, id, files);
		
		 /* set null to id because we must get create new product operation */
	     rip.setId(null);
		 model.addAttribute("product", rip);
		 model.addAttribute("type", "rip");
		 model.addAttribute("productId", id);
		 
		 componets.setJSONtoModelAttribute(model, "rip");
	    return "admin/rip";
	}
	
	@RequestMapping(value = "/admin/rip/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid Rip product,
			BindingResult result, Model model) throws IOException{
		
			
			if (result.hasErrors()) {
				model.addAttribute("type", "rip");
				model.addAttribute("product", product);
				componets.setJSONtoModelAttribute(model, "rip");
	            return "admin/rip";
	        }
		
            long id = ripService.addProduct(product);
            logger.info("Create new RIP! With id=" + id);

            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));
			
            this.ripService.updateProduct(product);
            
            files.clear();
		
		  linksForProduct.createLinks(ripService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, TYPE);
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/rips";
	}
	
	@RequestMapping(value = "/admin/rip/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Rip product,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("type", "rip");
				componets.setJSONtoModelAttribute(model, "rip");
	            return "admin/rip";
	        }
		
            long id = ripService.addProduct(product);
            logger.info("Create new rip! With id=" + id);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));
			
            this.ripService.updateProduct(product);
            
            files.clear();
		  
		  linksForProduct.createLinks(ripService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, TYPE);
	    	}
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/rip/edit/" + id;
	}
	
    @RequestMapping("/admin/rip/edit/{id}")
    public String editRip(@PathVariable("id") long id, Model model) throws UnsupportedEncodingException, FileNotFoundException, IOException, ParseException {
    	logger.info("Begin editing rip with id=" + id);
    	Rip undateRip = ripService.getProductById(id);
    	model.addAttribute("type", "rip");
        model.addAttribute("product", undateRip);
        
        logger.info("All characteristic of RIP.");
        componets.setJSONtoModelAttribute(model, "rip");
        return "admin/rip";
    }
	
	@RequestMapping(value = "/admin/rip/save_update", method = RequestMethod.POST) 
	public String updateSaveRip(@ModelAttribute("product") @Valid Rip product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("type", "rip");
			componets.setJSONtoModelAttribute(model, "rip");
            return "admin/rip";
        }
		
		logger.info("RIP UPDATE with save, id=" + product.getId());
		
		List<String> pathPictures = ripService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
        ripService.updateProduct(product);
        logger.info("rip with id=" + product.getId() + " was UDPATED!");
		  
		linksForProduct.createLinks(ripService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide()){
			componets.updateInLeftField(product, true, TYPE);
	    }
		  
		logger.info("Update links to the products in left menu!");

		return "redirect:/admin/rip/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/rip/update", method = RequestMethod.POST) 
	public String updateRip(@ModelAttribute("product") @Valid Rip product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("type", "rip");
			componets.setJSONtoModelAttribute(model, "rip");
            return "admin/rip";
        }
		
		logger.info("RIP UPDATE id=" + product.getId());
		
		List<String> pathPictures = ripService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
        ripService.updateProduct(product);
        logger.info("rip with id=" + product.getId() + " was UDPATED!");
        
		  files.clear();
		  
		  linksForProduct.createLinks(ripService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, TYPE);
	    	}
		  
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/rips";
	}
	
    @RequestMapping(value="/admin/rip/upload_pictures", method = RequestMethod.POST)
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
    
    @RequestMapping(value="/admin/rip/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	componets.changeOrderPictures(CONCRETE_FOLDER, selectedIds, files);	  	
    }
    
    @RequestMapping(value="/admin/rip/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePictureFromPicturesContainer(CONCRETE_FOLDER, namePicture, files);
    }
    
    @RequestMapping(value="/admin/rip/upload_pictures_update/{id}", method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesUpdate(MultipartHttpServletRequest request, @PathVariable("id") long id) {
    	logger.info("upload new picture");
        
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String fileName = null;

         while(itr.hasNext()){
        	mpf = request.getFile(itr.next()); 
     		fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 

 			try {
 				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(DIRECTORY + File.separator + CONCRETE_FOLDER
	    				+ File.separator + id + File.separator + fileName));
 			} catch (IOException e) {
 				logger.error("Don't write picture to the folder", e);
 			} 
        	 
 			Rip product = ripService.getProductById(id);
 			product.getPathPictures().add(fileName);
 			ripService.updateProduct(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/rip/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed rip product");
    	
    	Rip product = ripService.getProductById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	ripService.updateProduct(product);
    }
    
    @RequestMapping(value="/admin/rip/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	Rip product = ripService.getProductById(id);
    	product.getPathPictures().remove(name);
    	
    	try {
    		FileUtils.forceDelete(new File(DIRECTORY + File.separator + CONCRETE_FOLDER+ File.separator + id + File.separator + name));
		} catch (IOException e) {
			logger.error("Can't delete picture from the folder", e);
		} 
    	
    	if(product.getPathPictures().size()==0){
    		File fi = new File(DIRECTORY + File.separator + "default.jpg");
			try {
				FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						DIRECTORY + File.separator + CONCRETE_FOLDER + File.separator + product.getId() + File.separator + "default.jpg"));
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to rip with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	ripService.updateProduct(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed rip product");
    }
    
    @RequestMapping("/admin/rip/remove/{id}")
    public String removeRip(@PathVariable("id") long id){
    		logger.info("Start deleting rip from database, id=" + id);
    		try {
    			FileUtils.deleteDirectory(new File(DIRECTORY + File.separator + 
						CONCRETE_FOLDER + File.separator + id));
    			logger.info("deleted all pictures and pictures directory of this rip");
			} catch (IOException e) {
				logger.error("Deleting all pictures from this rip has a problem: ", e);
			}
    		
    		logger.info("Update links to the products in left menu!");
    		
    		componets.updateInLeftField(ripService.getProductById(id), false, TYPE);
    		
    		logger.info("DELETE rip with id=" + id + " from database!");
    		ripService.removeProduct(id);
        
    		linksForProduct.createLinks(ripService.listShowOnSite());
    		
        return "redirect:/admin/rips";
    }  
    
    @RequestMapping(value="/admin/rip/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Rip rip = ripService.getProductById(id);
    	rip.setShowOnSite(value);
    	ripService.updateProduct(rip);
    	
    	componets.updateInLeftField(rip, (rip.isShowOnSite() && rip.isShowOnLeftSide()), TYPE);
    	
    	linksForProduct.createLinks(ripService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/rip/setTop/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	Rip rip = ripService.getProductById(id);
    	rip.setTop(value);
    	ripService.updateProduct(rip);
    }
    
    @RequestMapping(value="/admin/rip/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Rip rip = ripService.getProductById(id);
    	rip.setShowOnHomePage(value);
    	ripService.updateProduct(rip);
    }
    
    @RequestMapping(value="/admin/rip/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Rip rip = ripService.getProductById(id);
    	rip.setShowOnLeftSide(value);
    	ripService.updateProduct(rip);
    	
    	componets.updateInLeftField(rip, (rip.isShowOnSite() && rip.isShowOnLeftSide()), TYPE);		
    }
}
