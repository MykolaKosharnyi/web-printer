package com.printmaster.nk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Cutter;
import com.printmaster.nk.model.SearchCutters;
import com.printmaster.nk.service.CutterService;
import com.printmaster.nk.service.UseWithProductService;

@Controller
public class CutterController {
	
	Map<String, String> links = new HashMap<String, String>(){

		private static final long serialVersionUID = 6020303266276652199L;

	{
		put("for_wood", "Для обработки дерева");
	    put("for_the_treatment_of_metal", "Для обработки металла");
	    put("stone_processing", "Для обработки камня");
	}};
    
	private Logger logger = Logger.getLogger(CutterController.class);
	
	private static final String DIRECTORY = "/var/www/localhost/images";

	private static final String CONCRETE_FOLDER = "cutters";
	
	@Autowired
	private LinksForProducts linksForProduct;
	
	@Autowired
    ComponentsForControllers componets;

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
   
        if(links.containsKey(type)){
        	currentType = links.get(type);
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
        
        model.addAttribute("uwp", product.getIdUseWithProduct()!=null ?
        		componets.showSimplestArrayOfUseWithProduct(
        				useWithProductService.getUseWithProductsByIds(product.getIdUseWithProduct())) : null);
        
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
		
		List<Cutter> listResult = new ArrayList<Cutter>();
        
        if(links.containsKey(type)){
        	for(Cutter cutter : cutterService.listCutters("id")){
        		if(cutter.getTypeCutter().equals(links.get(type))){
        			listResult.add(cutter);
        		}
        	}
        	model.addAttribute("productSubType", type);
        	model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров " + links.get(type).toLowerCase());
            model.addAttribute("listProducts", listResult);
            logger.info("On /admin/cutters/" + type + " page.");
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
		
		if(links.containsKey(type)){
			
			for(Cutter cutter : cutterService.listCutters(value)){
        		if(cutter.getTypeCutter().equals(links.get(type))){
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
		 componets.copyPicturesToBuffer(cutter.getPathPictures(), DIRECTORY, CONCRETE_FOLDER, id, files);
		
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
			BindingResult result, Model model){

		if (result.hasErrors())
			return adminFormHasError(product, model);

		long id = cutterService.addCutter(product);
		logger.info("Create new cutter! With id=" + id);

		// create folder and add to her new pictures
		product.getPathPictures()
				.addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));

		this.cutterService.updateCutter(product);

		files.clear();

		linksForProduct.createLinksForCutters(cutterService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, "cutter");

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/cutters";
	}
	
	@RequestMapping(value = "/admin/cutter/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);

            long id = cutterService.addCutter(product);
            logger.info("Create new cutter! With id=" + id);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));
			
            this.cutterService.updateCutter(product);
            
            files.clear();
		  
		  linksForProduct.createLinksForCutters(cutterService.listShowOnSite());	
		  
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
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(
        		useWithProductService.listShowOnSite()));
        model.addAttribute("type", "cutter");
        componets.setJSONtoModelAttribute(model, "cutter");
        
        return "admin/cutter";
    }
	
	@RequestMapping(value = "/admin/cutter/save_update", method = RequestMethod.POST) 
	public String updateSaveCutter(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);
		
		logger.info("cutter UPDATE with save, id=" + product.getId());
		
		List<String> pathPictures = cutterService.getCutterById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		cutterService.updateCutter(product);
        logger.info("cutter with id=" + product.getId() + " was UDPATED!");
		  
		linksForProduct.createLinksForCutters(cutterService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, "cutter");
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/cutter/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/cutter/update", method = RequestMethod.POST) 
	public String updateCutter(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);      
		
		logger.info("cutter UPDATE id=" + product.getId());
		List<String> pathPictures = cutterService.getCutterById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		cutterService.updateCutter(product);
        logger.info("cutter with id=" + product.getId() + " was UDPATED!");
        
		  files.clear();
		  
		  linksForProduct.createLinksForCutters(cutterService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
	    		componets.updateInLeftField(product, true, "cutter");
		  
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/cutters";
	}
	
	private String adminFormHasError(Cutter product, Model model){
		model.addAttribute("product", product);
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", "cutter");
		
		componets.setJSONtoModelAttribute(model, "cutter");
        return "admin/cutter";
	}
	
    @RequestMapping(value="/admin/cutter/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {
         return componets.uploadPictureOnCreationProduct(request, files);
    }
    
    @RequestMapping(value="/admin/cutter/change_order_pictures", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	componets.changeOrderPictures(CONCRETE_FOLDER, selectedIds, files); 	  	
    }
    
    @RequestMapping(value="/admin/cutter/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePictureFromPicturesContainer(CONCRETE_FOLDER, namePicture, files);
    }
    
    @RequestMapping(value="/admin/cutter/upload_pictures_update/{id}", method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesUpdate(MultipartHttpServletRequest request, @PathVariable("id") long id) {
    		 
    	String nameOfAddedPicture = componets.uploadPictureToExistedProduct(request, DIRECTORY, CONCRETE_FOLDER, id);
    	
 		Cutter product = cutterService.getCutterById(id);
 		product.getPathPictures().add(nameOfAddedPicture);
 		cutterService.updateCutter(product);
         
       return nameOfAddedPicture;
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
    	
    	componets.removePicture(name, DIRECTORY, CONCRETE_FOLDER, id);
    	
    	if(product.getPathPictures().size()==0){
    		componets.loadDefaultPicture(DIRECTORY, CONCRETE_FOLDER, product.getId());
			product.getPathPictures().add("default.jpg");
    	}
    	logger.info("Remove pictore with name = " + name + " from changed cutter product");
    	

    	cutterService.updateCutter(product);
    }
    
    @RequestMapping("/admin/cutter/remove/{id}")
    public String removeCutter(@PathVariable("id") long id){
    	logger.info("Start deleting cutter from database, id=" + id);
    	
    	componets.removeAllPricturesOfConcreteProduct(DIRECTORY, CONCRETE_FOLDER, id);
    		
    	logger.info("Update links to the products in left menu!");
    	componets.updateInLeftField(cutterService.getCutterById(id), false, "cutter");
    		
    	logger.info("DELETE cutter with id=" + id + " from database!");
    	cutterService.removeCutter(id);
        
    	linksForProduct.createLinksForCutters(cutterService.listShowOnSite());
    		
        return "redirect:/admin/cutters";
    }  
    
    @RequestMapping(value="/admin/cutter/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter cutter = cutterService.getCutterById(id);
    	cutter.setShowOnSite(value);
    	cutterService.updateCutter(cutter);
    	
    	componets.updateInLeftField(cutter, cutter.isShowOnSite() && cutter.isShowOnLeftSide() , "cutter");
    	linksForProduct.createLinksForCutters(cutterService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/cutter/setTop/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter cutter = cutterService.getCutterById(id);
    	cutter.setTop(value);
    	cutterService.updateCutter(cutter);
    }
    
    @RequestMapping(value="/admin/cutter/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter cutter = cutterService.getCutterById(id);
    	cutter.setShowOnHomePage(value);
    	cutterService.updateCutter(cutter);
    }
    
    @RequestMapping(value="/admin/cutter/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter cutter = cutterService.getCutterById(id);
    	cutter.setShowOnLeftSide(value);
    	cutterService.updateCutter(cutter);
    	
    	componets.updateInLeftField(cutter, cutter.isShowOnSite() && cutter.isShowOnLeftSide(), "cutter");
    }
   
}
