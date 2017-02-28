package com.printmaster.nk.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.entity.Printer;
import com.printmaster.nk.model.entity.UseWithProduct;
import com.printmaster.nk.model.entity.search.SearchPrinters;
import com.printmaster.nk.model.service.CommentService;
import com.printmaster.nk.model.service.PrinterService;
import com.printmaster.nk.model.service.UseWithProductService;

@Controller
public class PrinterController {
	
	private Map<String, String> links = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put("dissolving", "Сольвентный");
	    put("ecosolvent", "Экосольвентный");
	    put("UV_roll", "UV рулонный");
	    put("UV_flatbed", "UV плоскопечатный");
	    put("sublimation", "Сублимационный");
	    put("textile", "Текстильный");
	    put("water_pigment", "Водный/Пигментный");
	    put("SAPR-GIS", "САПР/ГИС");
	}};
	
	private Logger logger = Logger.getLogger(this.getClass());
	//private Logger logger = Logger.getLogger(PrinterController.class);
	
	private static final String DIRECTORY = "/var/www/localhost/images";
	
	private static final String TYPE = "printer";
	
	private static final String CONCRETE_FOLDER = TYPE + "s";
	
	@Autowired
	private LinksForProducts linksForProduct;

    @Autowired
    PicturesContainer files;
    
    @Autowired
    ComponentsForControllers componets;
 
    private PrinterService printerService;
    
    @Autowired(required=true)
    @Qualifier(value="printerService")
    public void setProductService(PrinterService ps){
        this.printerService = ps;
    }
    
    private UseWithProductService useWithProductService;
    
    @Autowired
	private CommentService commentService;
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }
	
	@RequestMapping(value = "/"+ TYPE +"s", method = RequestMethod.GET)	
    public String allProducts(Model model) {
        model.addAttribute("listProducts", componets.makeLightWeightCollectionOfProduct(this.printerService.listShowOnSite()));
        SearchPrinters search = new SearchPrinters();
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
		SearchPrinters search = new SearchPrinters();
        String currentType = null;
   
        if(links.containsKey(type)){
        	currentType = links.get(type);
        	logger.info(String.format("On the /%s/%s page.", CONCRETE_FOLDER, type));
        } else {
        	return "redirect:/";
        }
        
        String[] a = {currentType};
        search.setTypePrinter(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        model.addAttribute("listProducts", componets.makeLightWeightCollectionOfProduct(printerService.listSearchProducts(search)));
        model.addAttribute("type", TYPE);
        
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return TYPE +"s/" + type ;
    }
	
	@RequestMapping(value="/"+ TYPE +"s/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchPrinters search, BindingResult result ){
    	logger.info(String.format("On the /%s/search page.", TYPE));
    	return componets.makeLightWeightCollectionOfProduct(printerService.listSearchProducts(search));
    }
	
    @RequestMapping("/"+ TYPE +"/{id}")
    public String showPrinter(@PathVariable("id") long id, Model model){
    	logger.info(String.format("On /%s/%d page.", TYPE, id));
        
        Printer product = printerService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", TYPE);
        model.addAttribute("comments", commentService.getAllForProduct(TYPE, id));
        
        if(product.getIdUseWithProduct()!=null || product.getCompatibleInk()!=null){
	        Set<UseWithProduct> useWithThisProduct = new LinkedHashSet<UseWithProduct>();
	        
	        //get checked USE WITH PRODUCT from admin page
	        if(product.getIdUseWithProduct()!=null){
	        	useWithThisProduct.addAll(useWithProductService.getProductsByIds(product.getIdUseWithProduct()));
	        }
	        
	        //get PAINT to product by COMPATIBLE INK in printer
	        if(product.getCompatibleInk()!=null){
	        	useWithThisProduct.addAll(useWithProductService.getPrintersByTypeInk(product.getCompatibleInk()));
	        }
	  
	        model.addAttribute("uwp", useWithThisProduct);
        } else {
        	model.addAttribute("uwp", null);
        }

        return TYPE;
    }
    
    @RequestMapping(value = "/admin/"+ TYPE +"s", method = RequestMethod.GET)	
    public String listProducts(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных принтеров");
		model.addAttribute("listProducts", printerService.listProducts("id"));
        logger.info(String.format("/admin/%s page.", CONCRETE_FOLDER));
        
        model.addAttribute("productType", TYPE);
		model.addAttribute("nameProduct", "Имя принтера");
        model.addAttribute("title", "Принтеры");
        model.addAttribute("addProduct", "Добавить принтер");
        model.addAttribute("productSubType", "none");
        return "admin/products";
    }
    
    @RequestMapping(value = "/admin/"+ TYPE +"s/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeProducts(@PathVariable("type") String type, Model model) {
		
		List<Printer> listResult = new ArrayList<Printer>();
        
        if(links.containsKey(type)){
        	for(Printer product : printerService.listProducts("id")){
        		if(product.getTypePrinter().equals(links.get(type))){
        			listResult.add(product);
        		}
        	}
        	model.addAttribute("productSubType", type);
        	model.addAttribute("titleOfTable", "Список загруженных принтеров " + links.get(type).toLowerCase());
            model.addAttribute("listProducts", listResult);
            logger.info(String.format("On /admin/%s/%s page.", CONCRETE_FOLDER, type));
        } else {
        	model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных принтеров");
            model.addAttribute("listProducts", printerService.listProducts("id"));
            logger.info(String.format("On /admin/%s page.", CONCRETE_FOLDER));
        }
        
        model.addAttribute("productType", TYPE);
		model.addAttribute("nameProduct", "Имя принтера");
        model.addAttribute("title", "Принтеры");
        model.addAttribute("addProduct", "Добавить принтер");
        
        return "admin/products";
    }
    
    @RequestMapping(value="/admin/"+ TYPE +"/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Printer> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {
		
		List<Printer> list = new ArrayList<Printer>();

		if (links.containsKey(type)) {

			for (Printer product : printerService.listProducts(value)) {
				if (product.getTypePrinter().equals(links.get(type))) 
					list.add(product);
			}

		} else {
			list.addAll(printerService.listProducts(value));
		}

		return list;
    }
	
	@RequestMapping(value = "/admin/"+ TYPE +"/new", method = RequestMethod.GET)
	public String addNewProduct(Model model) {
		files.clear();
		logger.info(String.format("/admin/%s/new page.", TYPE));
		model.addAttribute("product", new Printer());
		
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
		Printer product = printerService.getProductById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer( product.getPathPictures(), DIRECTORY, CONCRETE_FOLDER, id, files );
		
		 /* set null to id because we must get create new product operation */
	     product.setId(null);
		 model.addAttribute("product", product);
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", TYPE);
		 model.addAttribute("productId", id);
		 
		 componets.setJSONtoModelAttribute(model, TYPE);
	    return "admin/"+ TYPE +"";
	}
     
	@RequestMapping(value = "/admin/"+ TYPE +"/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid Printer product,
			BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = printerService.addProduct(product);
		logger.info(String.format("Create new %s! With id=%d", TYPE, id));

		// create folder and add to her new pictures
		product.getPathPictures()
				.addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));

		this.printerService.updateProduct(product);

		files.clear();

		linksForProduct.createLinks(printerService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/"+ TYPE +"s";
	}
	
	@RequestMapping(value = "/admin/"+ TYPE +"/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Printer product,
			BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = printerService.addProduct(product);
		logger.info(String.format("Create new %s! With id=%d", TYPE, id));

		// create folder and add to her new pictures
		product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));

		this.printerService.updateProduct(product);

		files.clear();

		linksForProduct.createLinks(printerService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "/edit/" + id;
	}
	
    @RequestMapping("/admin/"+ TYPE +"/edit/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
    	logger.info(String.format("Begin editing %s with id=%d", TYPE, id));
    	Printer undateProduct = printerService.getProductById(id);
    	
        model.addAttribute("product", undateProduct);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(
        		useWithProductService.listShowOnSite()));
        model.addAttribute("type", TYPE);
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return "admin/" + TYPE;
    }
	
	@RequestMapping(value = "/admin/" + TYPE + "/save_update", method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute("product") @Valid Printer product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);
		
		logger.info(String.format("%s UPDATE with save, id=%d", TYPE, product.getId()));
		
		List<String> pathPictures = printerService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		printerService.updateProduct(product);
        logger.info(String.format("%s with id=%d was UDPATED", TYPE, product.getId()));
		  
		linksForProduct.createLinks(printerService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, TYPE);
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/" + TYPE + "/update", method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute("product") @Valid Printer product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);

		logger.info(String.format("%s UPDATE id=%d", TYPE, product.getId()));
		List<String> pathPictures = printerService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);

		printerService.updateProduct(product);
		logger.info(String.format("%s with id=%d was UDPATED", TYPE, product.getId()));

		files.clear();

		linksForProduct.createLinks(printerService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "s";
	}
	
	private String adminFormHasError(Printer product, Model model){
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
    	
 		Printer product = printerService.getProductById(id);
 		product.getPathPictures().add(nameOfAddedPicture);
 		printerService.updateProduct(product);
         
       return nameOfAddedPicture;
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info(String.format("change order of pictures in changed %s product", TYPE));
    	
    	Printer product = printerService.getProductById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	printerService.updateProduct(product);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	
    	String name = namePicture.replace(":", ".");
    	Printer product = printerService.getProductById(id);
    	product.getPathPictures().remove(name);
    	
    	componets.removePicture(name, DIRECTORY, CONCRETE_FOLDER, id);
    	
    	if(product.getPathPictures().size()==0){
    		componets.loadDefaultPicture(DIRECTORY, CONCRETE_FOLDER, product.getId());
			product.getPathPictures().add("default.jpg");
    	}
    	
    	logger.info(String.format("Remove pictore with name = %s from changed %s product", name, TYPE));

    	printerService.updateProduct(product);
    }
    
    @RequestMapping("/admin/" + TYPE + "/remove/{id}")
    public String removeProduct(@PathVariable("id") long id){
    	logger.info(String.format("Start deleting %s from database, id=%d", TYPE, id));
    	
    	componets.removeAllPricturesOfConcreteProduct(DIRECTORY, CONCRETE_FOLDER, id);
    		
    	logger.info("Update links to the products in left menu!");
    	componets.updateInLeftField(printerService.getProductById(id), false, TYPE);
    		
    	logger.info(String.format("DELETE %s with id=%d from database", TYPE, id));
    	printerService.removeProduct(id);
        
    	linksForProduct.createLinks(printerService.listShowOnSite());
    		
        return "redirect:/admin/" + TYPE + "s";
    }  
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer product = printerService.getProductById(id);
    	product.setShowOnSite(value);
    	printerService.updateProduct(product);
    	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide() , TYPE);
    	linksForProduct.createLinks(printerService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/setTop/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer product = printerService.getProductById(id);
    	product.setTop(value);
    	printerService.updateProduct(product);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer product = printerService.getProductById(id);
    	product.setShowOnHomePage(value);
    	printerService.updateProduct(product);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer product = printerService.getProductById(id);
    	product.setShowOnLeftSide(value);
    	printerService.updateProduct(product);
    	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide(), TYPE);
    }
    
    @RequestMapping(value = "/admin/"+ TYPE +"/equipment_manufacturer", method = RequestMethod.GET)
	public String equipmentManufacturer(Model model) {
    	componets.setJSONtoModelAttributeForChanging(model, TYPE);
	    return "admin/"+ TYPE +"/equipment_manufacturer";
	}
    
    @RequestMapping(value = "/admin/"+ TYPE +"/equipment_manufacturer", method = RequestMethod.POST)
	public String changeEquipmentManufacturer(@RequestParam(value = "equipment_manufacturer") List<String> manufacturers) {
    	componets.showValueOfParameter(TYPE, "equipment_manufacturer", manufacturers);
	    return "redirect:/admin/"+ TYPE +"/equipment_manufacturer";
	}
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/"+ TYPE +"/check_name_manufacture", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody JSONObject checkManufacture(@RequestBody String name) {
    	JSONObject result = new JSONObject();
    	result.put("result", componets.isParameterRepeated(TYPE, "equipment_manufacturer", name));
    	return result;
    }
    
    @RequestMapping(value = "/admin/"+ TYPE +"/add_equipment_manufacturer", method = RequestMethod.POST)
	public String addquipmentManufacturer(@RequestParam(value = "new_equipment") String manufacturer) {
    	componets.setNewValueOfParameter(TYPE, "equipment_manufacturer", manufacturer);
	    return "redirect:/admin/"+ TYPE +"/equipment_manufacturer";
	}
}
