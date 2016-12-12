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
	
	private Map<String, String> links = new HashMap<String, String>(){

		private static final long serialVersionUID = 6020303266276652199L;

	{
		put("for_wood", "Для обработки дерева");
	    put("for_the_treatment_of_metal", "Для обработки металла");
	    put("stone_processing", "Для обработки камня");
	}};
    
	private Logger logger = Logger.getLogger(CutterController.class);
	
	private static final String DIRECTORY = "/var/www/localhost/images";

	private static final String TYPE = "cutter";
	
	private static final String CONCRETE_FOLDER = TYPE + "s";
	
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
    
	@RequestMapping(value = "/"+ TYPE +"s", method = RequestMethod.GET)	
    public String allProducts(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfCutter(this.cutterService.listShowOnSite()));
        SearchCutters search = new SearchCutters();
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
        SearchCutters search = new SearchCutters();
        String currentType = null;
   
        if(links.containsKey(type)){
        	currentType = links.get(type);
        	logger.info(String.format("On the /%s/%s page.", CONCRETE_FOLDER, type));
        } else {
        	return "redirect:/";
        }
        
        String[] a = {currentType};
        search.setTypeCutter(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        model.addAttribute("listProducts", componets.showSimplestArrayOfCutter(cutterService.listSearchCutters(search)));
        model.addAttribute("type", TYPE);
        
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return TYPE +"s/" + type ;
    }

    @RequestMapping(value="/"+ TYPE +"s/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchCutters search, BindingResult result ){
    	logger.info(String.format("On the /%s/search page.", TYPE));
    	return componets.showSimplestArrayOfCutter(cutterService.listSearchCutters(search));
    }
	
    @RequestMapping("/"+ TYPE +"/{id}")
    public String showProduct(@PathVariable("id") long id, Model model){
    	logger.info(String.format("On /%s/%d page.", TYPE, id));
        
        Cutter product = cutterService.getCutterById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", TYPE);
        
        model.addAttribute("uwp", product.getIdUseWithProduct()!=null ?
        		componets.showSimplestArrayOfUseWithProduct(
        				useWithProductService.getUseWithProductsByIds(product.getIdUseWithProduct())) : null);
        
        return TYPE;
    }
    
	@RequestMapping(value = "/admin/"+ TYPE +"s", method = RequestMethod.GET)	
    public String listProducts(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров");
        model.addAttribute("listProducts", cutterService.listCutters("id"));
        logger.info(String.format("/admin/%s page.", CONCRETE_FOLDER));
        
        model.addAttribute("productType", TYPE);
		model.addAttribute("nameProduct", "Имя гравера/фрезера");
        model.addAttribute("title", "Гравера/фрезера");
        model.addAttribute("addProduct", "Добавить гравер/фрезер");
        model.addAttribute("productSubType", "none");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/"+ TYPE +"s/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeProducts(@PathVariable("type") String type, Model model) {
		
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
            logger.info(String.format("On /admin/%s/%s page.", CONCRETE_FOLDER, type));
        } else {
        	model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных граверов/фрезеров");
            model.addAttribute("listProducts", cutterService.listCutters("id"));
            logger.info(String.format("On /admin/%s page.", CONCRETE_FOLDER));
        }
        
        model.addAttribute("productType", TYPE);
		model.addAttribute("nameProduct", "Имя гравера/фрезера");
        model.addAttribute("title", "Гравера/фрезера");
        model.addAttribute("addProduct", "Добавить гравер/фрезер");
        
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/"+ TYPE +"/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Cutter> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {
		
		List<Cutter> list = new ArrayList<Cutter>();

		if (links.containsKey(type)) {

			for (Cutter product : cutterService.listCutters(value)) {
				if (product.getTypeCutter().equals(links.get(type))) 
					list.add(product);
			}

		} else {
			list.addAll(cutterService.listCutters(value));
		}

		return list;
    }
	
	@RequestMapping(value = "/admin/"+ TYPE +"/new", method = RequestMethod.GET)
	public String addNewProduct(Model model) {
		files.clear();
		logger.info(String.format("/admin/%s/new page.", TYPE));
		model.addAttribute("product", new Cutter());
		
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
		Cutter product = cutterService.getCutterById(id);
		
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
	public String handleFormUpload(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = cutterService.addCutter(product);
		logger.info(String.format("Create new %s! With id=%d", TYPE, id));

		// create folder and add to her new pictures
		product.getPathPictures()
				.addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));

		this.cutterService.updateCutter(product);

		files.clear();

		linksForProduct.createLinksForCutters(cutterService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/"+ TYPE +"s";
	}
	
	@RequestMapping(value = "/admin/"+ TYPE +"/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = cutterService.addCutter(product);
		logger.info(String.format("Create new %s! With id=%d", TYPE, id));

		// create folder and add to her new pictures
		product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));

		this.cutterService.updateCutter(product);

		files.clear();

		linksForProduct.createLinksForCutters(cutterService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "/edit/" + id;
	}
	
    @RequestMapping("/admin/"+ TYPE +"/edit/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
    	logger.info(String.format("Begin editing %s with id=%d", TYPE, id));
    	Cutter undateProduct = cutterService.getCutterById(id);
    	
        model.addAttribute("product", undateProduct);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(
        		useWithProductService.listShowOnSite()));
        model.addAttribute("type", TYPE);
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return "admin/" + TYPE;
    }
	
	@RequestMapping(value = "/admin/" + TYPE + "/save_update", method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);
		
		logger.info(String.format("%s UPDATE with save, id=%d", TYPE, product.getId()));
		
		List<String> pathPictures = cutterService.getCutterById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		cutterService.updateCutter(product);
        logger.info(String.format("%s with id=%d was UDPATED", TYPE, product.getId()));
		  
		linksForProduct.createLinksForCutters(cutterService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, TYPE);
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/" + TYPE + "/update", method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute("product") @Valid Cutter product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);

		logger.info(String.format("%s UPDATE id=%d", TYPE, product.getId()));
		List<String> pathPictures = cutterService.getCutterById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);

		cutterService.updateCutter(product);
		logger.info(String.format("%s with id=%d was UDPATED", TYPE, product.getId()));

		files.clear();

		linksForProduct.createLinksForCutters(cutterService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/" + TYPE + "s";
	}
	
	private String adminFormHasError(Cutter product, Model model){
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
    	
 		Cutter product = cutterService.getCutterById(id);
 		product.getPathPictures().add(nameOfAddedPicture);
 		cutterService.updateCutter(product);
         
       return nameOfAddedPicture;
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info(String.format("change order of pictures in changed %s product", TYPE));
    	
    	Cutter product = cutterService.getCutterById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	cutterService.updateCutter(product);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
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
    	
    	logger.info(String.format("Remove pictore with name = %s from changed %s product", name, TYPE));

    	cutterService.updateCutter(product);
    }
    
    @RequestMapping("/admin/" + TYPE + "/remove/{id}")
    public String removeProduct(@PathVariable("id") long id){
    	logger.info(String.format("Start deleting %s from database, id=%d", TYPE, id));
    	
    	componets.removeAllPricturesOfConcreteProduct(DIRECTORY, CONCRETE_FOLDER, id);
    		
    	logger.info("Update links to the products in left menu!");
    	componets.updateInLeftField(cutterService.getCutterById(id), false, TYPE);
    		
    	logger.info(String.format("DELETE %s with id=%d from database", TYPE, id));
    	cutterService.removeCutter(id);
        
    	linksForProduct.createLinksForCutters(cutterService.listShowOnSite());
    		
        return "redirect:/admin/" + TYPE + "s";
    }  
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter product = cutterService.getCutterById(id);
    	product.setShowOnSite(value);
    	cutterService.updateCutter(product);
    	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide() , TYPE);
    	linksForProduct.createLinksForCutters(cutterService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/setTop/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter product = cutterService.getCutterById(id);
    	product.setTop(value);
    	cutterService.updateCutter(product);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter product = cutterService.getCutterById(id);
    	product.setShowOnHomePage(value);
    	cutterService.updateCutter(product);
    }
    
    @RequestMapping(value="/admin/" + TYPE + "/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Cutter product = cutterService.getCutterById(id);
    	product.setShowOnLeftSide(value);
    	cutterService.updateCutter(product);
    	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide(), TYPE);
    }
   
}
