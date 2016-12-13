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
import com.printmaster.nk.model.Laser;
import com.printmaster.nk.model.SearchLasers;
import com.printmaster.nk.service.LaserService;
import com.printmaster.nk.service.UseWithProductService;

@Controller
public class LaserController {
	
	private Map<String, String> links = new HashMap<String, String>(){

		private static final long serialVersionUID = 6020303266276652199L;

	{
		put("CO2_gas_lasers", "Газовые лазеры СО2");
	    put("solid_state_lasers", "Твердотельные лазеры");
	    put("for_the_treatment_of_metal", "Для обработки метала");
	    put("diode_pumped", "С диодной накачкой");
	    put("fiber_lasers", "Оптоволоконные лазеры");
	    put("plasma_lasers", "Плазменные лазеры");	    
	}};
	
	private Logger logger = Logger.getLogger(LaserController.class);
	
	private static final String DIRECTORY = "/var/www/localhost/images";
	
	private static final String TYPE = "laser";

	private static final String CONCRETE_FOLDER = TYPE + "s";
	
	@Autowired
	private LinksForProducts linksForProduct;
	
	@Autowired
    ComponentsForControllers componets;

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

	@RequestMapping(value = "/"+ TYPE +"s", method = RequestMethod.GET)	
    public String allProducts(Model model) {
        model.addAttribute("listProducts", componets.makeLightWeightCollectionOfProduct(this.laserService.listShowOnSite()));
        SearchLasers search = new SearchLasers();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        model.addAttribute("type", TYPE);
        logger.info(String.format("On '../%s' page.", CONCRETE_FOLDER));
        
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return TYPE + "s";
    }
	
	@RequestMapping(value = "/"+ TYPE +"s/{type}", method = RequestMethod.GET)	
    public String typeProducts(@PathVariable("type") String type, Model model) {
        SearchLasers search = new SearchLasers();
        String currentType = null;
   
        if(links.containsKey(type)){
        	currentType = links.get(type);
        	logger.info(String.format("On the /%s/%s page.", CONCRETE_FOLDER, type));
        } else {
        	return "redirect:/";
        }
        
        String[] a = {currentType};
        search.setTypeLaser(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        model.addAttribute("listProducts", componets.makeLightWeightCollectionOfProduct(laserService.listSearchProducts(search)));
        model.addAttribute("type", TYPE);
        
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return TYPE +"s/" + type ;
    }

    @RequestMapping(value="/"+ TYPE +"s/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchLasers search, BindingResult result ){
    	logger.info(String.format("On the /%s/search page.", TYPE));
    	return componets.makeLightWeightCollectionOfProduct(laserService.listSearchProducts(search));
    }
	
    @RequestMapping("/"+ TYPE +"/{id}")
    public String showProduct(@PathVariable("id") long id, Model model){
    	logger.info(String.format("On /%s/%d page.", TYPE, id));
        
        Laser product = laserService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", TYPE);
        
        model.addAttribute("uwp", product.getIdUseWithProduct()!=null ?
        		componets.showSimplestArrayOfUseWithProduct(
        				useWithProductService.getProductsByIds(product.getIdUseWithProduct())) : null);
        
        return TYPE;
    }
    
	@RequestMapping(value = "/admin/"+ TYPE +"s", method = RequestMethod.GET)	
    public String listProducts(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных лазеров");
        model.addAttribute("listProducts", laserService.listProducts("id"));
        logger.info(String.format("/admin/%s page.", CONCRETE_FOLDER));
        
        model.addAttribute("productType", TYPE);
		model.addAttribute("nameProduct", "Имя лазера");
        model.addAttribute("title", "Лазера");
        model.addAttribute("addProduct", "Добавить лазер");
        model.addAttribute("productSubType", "none");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/"+ TYPE +"s/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeProducts(@PathVariable("type") String type, Model model) {
		
		List<Laser> listResult = new ArrayList<Laser>();
        
        if(links.containsKey(type)){
        	for(Laser laser : laserService.listProducts("id")){
        		if(laser.getTypeLaser().equals(links.get(type))){
        			listResult.add(laser);
        		}
        	}
        	model.addAttribute("productSubType", type);
        	model.addAttribute("titleOfTable", "Список загруженных лазеров " + links.get(type).toLowerCase());
            model.addAttribute("listProducts", listResult);
            logger.info(String.format("On /admin/%s/%s page.", CONCRETE_FOLDER, type));
        } else {
        	model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных лазеров");
            model.addAttribute("listProducts", laserService.listProducts("id"));
            logger.info(String.format("On /admin/%s page.", CONCRETE_FOLDER));
        }
        
        model.addAttribute("productType", TYPE);
		model.addAttribute("nameProduct", "Имя лазера");
        model.addAttribute("title", "Лазера");
        model.addAttribute("addProduct", "Добавить лазер");
        
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/"+ TYPE +"/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Laser> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {
		
		List<Laser> list = new ArrayList<Laser>();

		if (links.containsKey(type)) {

			for (Laser laser : laserService.listProducts(value)) {
				if (laser.getTypeLaser().equals(links.get(type))) 
					list.add(laser);
			}

		} else {
			list.addAll(laserService.listProducts(value));
		}

		return list;
    }
	
	@RequestMapping(value = "/admin/"+ TYPE +"/new", method = RequestMethod.GET)
	public String addNewProduct(Model model) {
		files.clear();
		logger.info(String.format("/admin/%s/new page.", TYPE));
		model.addAttribute("product", new Laser());
		
		componets.setJSONtoModelAttribute(model, TYPE);
		
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", TYPE);
		model.addAttribute("productId", 0);
	    return "admin/"+ TYPE;
	}
	
	@RequestMapping(value = "/admin/"+ TYPE +"/copy/{id}", method = RequestMethod.GET)
	public String copyProduct(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info(String.format("/admin/%s/copy/%d page.", TYPE, id));
		
		logger.info(String.format("Copy all characteristic of %s.", TYPE));
		Laser laser = laserService.getProductById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer( laser.getPathPictures(), DIRECTORY, CONCRETE_FOLDER, id, files );
		
		 /* set null to id because we must get create new product operation */
	     laser.setId(null);
		 model.addAttribute("product", laser);
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", TYPE);
		 model.addAttribute("productId", id);
		 
		 componets.setJSONtoModelAttribute(model, TYPE);
	    return "admin/"+ TYPE +"";
	}
     
	@RequestMapping(value = "/admin/"+ TYPE +"/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid Laser product,
			BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = laserService.addProduct(product);
		logger.info(String.format("Create new %s! With id=%d", TYPE, id));

		// create folder and add to her new pictures
		product.getPathPictures()
				.addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));

		this.laserService.updateProduct(product);

		files.clear();

		linksForProduct.createLinksForLasers(laserService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/"+ TYPE +"s";
	}
	
	@RequestMapping(value = "/admin/"+ TYPE +"/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Laser product,
			BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = laserService.addProduct(product);
		logger.info(String.format("Create new %s! With id=%d", TYPE, id));

		// create folder and add to her new pictures
		product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));

		this.laserService.updateProduct(product);

		files.clear();

		linksForProduct.createLinksForLasers(laserService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "/edit/" + id;
	}
	
    @RequestMapping("/admin/"+ TYPE +"/edit/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
    	logger.info(String.format("Begin editing %s with id=%d", TYPE, id));
    	Laser undateLaser = laserService.getProductById(id);
    	
        model.addAttribute("product", undateLaser);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(
        		useWithProductService.listShowOnSite()));
        model.addAttribute("type", TYPE);
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return "admin/" + TYPE;
    }
	
	@RequestMapping(value = "/admin/" + TYPE + "/save_update", method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute("product") @Valid Laser product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);
		
		logger.info(String.format("%s UPDATE with save, id=%d", TYPE, product.getId()));
		
		List<String> pathPictures = laserService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		laserService.updateProduct(product);
        logger.info(String.format("%s with id=%d was UDPATED", TYPE, product.getId()));
		  
		linksForProduct.createLinksForLasers(laserService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, TYPE);
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/" + TYPE + "/update", method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute("product") @Valid Laser product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);

		logger.info(String.format("%s UPDATE id=%d", TYPE, product.getId()));
		List<String> pathPictures = laserService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);

		laserService.updateProduct(product);
		logger.info(String.format("%s with id=%d was UDPATED", TYPE, product.getId()));

		files.clear();

		linksForProduct.createLinksForLasers(laserService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "s";
	}
	
	private String adminFormHasError(Laser product, Model model){
		model.addAttribute("product", product);
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", TYPE);
		
		componets.setJSONtoModelAttribute(model, TYPE);
        return "admin/" + TYPE;
	}
	
    @RequestMapping(value="/admin/" + TYPE + "/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {
         return componets.uploadPictureOnCreationProduct(request, files);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/change_order_pictures", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	componets.changeOrderPictures(CONCRETE_FOLDER, selectedIds, files); 	  	
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePictureFromPicturesContainer(CONCRETE_FOLDER, namePicture, files);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/upload_pictures_update/{id}", method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesUpdate(MultipartHttpServletRequest request, @PathVariable("id") long id) {
    		 
    	String nameOfAddedPicture = componets.uploadPictureToExistedProduct(request, DIRECTORY, CONCRETE_FOLDER, id);
    	
 		Laser product = laserService.getProductById(id);
 		product.getPathPictures().add(nameOfAddedPicture);
 		laserService.updateProduct(product);
         
       return nameOfAddedPicture;
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info(String.format("change order of pictures in changed %s product", TYPE));
    	
    	Laser product = laserService.getProductById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	laserService.updateProduct(product);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	
    	String name = namePicture.replace(":", ".");
    	Laser product = laserService.getProductById(id);
    	product.getPathPictures().remove(name);
    	
    	componets.removePicture(name, DIRECTORY, CONCRETE_FOLDER, id);
    	
    	if(product.getPathPictures().size()==0){
    		componets.loadDefaultPicture(DIRECTORY, CONCRETE_FOLDER, product.getId());
			product.getPathPictures().add("default.jpg");
    	}
    	
    	logger.info(String.format("Remove pictore with name = %s from changed %s product", name, TYPE));

    	laserService.updateProduct(product);
    }
    
    @RequestMapping("/admin/" + TYPE + "/remove/{id}")
    public String removeProduct(@PathVariable("id") long id){
    	logger.info(String.format("Start deleting %s from database, id=%d", TYPE, id));
    	
    	componets.removeAllPricturesOfConcreteProduct(DIRECTORY, CONCRETE_FOLDER, id);
    		
    	logger.info("Update links to the products in left menu!");
    	componets.updateInLeftField(laserService.getProductById(id), false, TYPE);
    		
    	logger.info(String.format("DELETE %s with id=%d from database", TYPE, id));
    	laserService.removeProduct(id);
        
    	linksForProduct.createLinksForLasers(laserService.listShowOnSite());
    		
        return "redirect:/admin/" + TYPE + "s";
    }  
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laser laser = laserService.getProductById(id);
    	laser.setShowOnSite(value);
    	laserService.updateProduct(laser);
    	
    	componets.updateInLeftField(laser, laser.isShowOnSite() && laser.isShowOnLeftSide() , TYPE);
    	linksForProduct.createLinksForLasers(laserService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/setTop/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laser laser = laserService.getProductById(id);
    	laser.setTop(value);
    	laserService.updateProduct(laser);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laser laser = laserService.getProductById(id);
    	laser.setShowOnHomePage(value);
    	laserService.updateProduct(laser);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laser laser = laserService.getProductById(id);
    	laser.setShowOnLeftSide(value);
    	laserService.updateProduct(laser);
    	
    	componets.updateInLeftField(laser, laser.isShowOnSite() && laser.isShowOnLeftSide(), TYPE);
    }
}
