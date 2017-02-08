package com.printmaster.nk.controller;

import static com.printmaster.nk.controller.ConstUsedInContr.*;

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
import com.printmaster.nk.model.entity.UseWithProduct;
import com.printmaster.nk.model.entity.search.SearchUseWithProducts;
import com.printmaster.nk.model.service.UseWithProductService;

@Controller
public class UseWithProductController {
	
	private Map<String, String> links = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
	    put("ink_for_inkjet", "Чернила для струйной печати");
	    put("consumables_for_digital_equipment", "Расходные материалы для цифрового оборудования");
	    put("consumables_for_3D_equipment", "Расходные материалы для 3D оборудования");
	    put("products_for_maintenance", "Товары для обслуживания");
	    put("parts_and_accessories", "Запчасти и комплектующие");
	}};
	
	private Map<String, String> parametersOnAdminProductsPage = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put(ATTRIBUTE_TITLE_OF_TABLE, "Список загруженного товара");
	    put(ATTRIBUTE_NAME_PRODUCT, "Имя товара");
	    put(ATTRIBUTE_TITLE, "Используется с товаром");
	    put(ATTRIBUTE_ADD_PRODUCT, "Добавить товар");
	}};
	
	private Logger logger = Logger.getLogger(UseWithProductController.class);
	
	private static final String TYPE = USE_WITH_PRODUCT;
	private final static String CONCRETE_FOLDER = USE_WITH_PRODUCT + "s";
	
	@Autowired
	private LinksForProducts linksForProduct;

    @Autowired
    PicturesContainer files;
    
    @Autowired
    ComponentsForControllers componets;
 
    private UseWithProductService useWithProductService;
    
    @Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }

	@RequestMapping(value = "/"+ TYPE +"s", method = RequestMethod.GET)	
    public String allProducts(Model model) {
        model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, componets.makeLightWeightCollectionOfProduct(this.useWithProductService.listShowOnSite()));
        SearchUseWithProducts search = new SearchUseWithProducts();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute(ATTRIBUTE_SEARCH, search);
        logger.info(String.format("On '../%s' page.", CONCRETE_FOLDER));
        
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return TYPE + "s";
    }
	
	@RequestMapping(value = "/"+ TYPE +"s/{subType}", method = RequestMethod.GET)	
    public String typeProducts(@PathVariable("subType") String subType, Model model) {
		SearchUseWithProducts search = new SearchUseWithProducts();
        String currentType = null;
   
        if(links.containsKey(subType)){
        	currentType = links.get(subType);
        	logger.info(String.format("On the /%s/%s page.", CONCRETE_FOLDER, subType));
        } else {
        	return "redirect:/";
        }
        
        String[] a = {currentType};
        search.setTypeProduct(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute(ATTRIBUTE_SEARCH, search);
        model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, componets.makeLightWeightCollectionOfProduct(useWithProductService.listSearchProducts(search)));
        
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return TYPE +"s/" + subType ;
    }
    
    @RequestMapping(value="/"+ TYPE +"s/"+ PATH_SEARCH, method=RequestMethod.POST, produces=JSON_PRODUCES)
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchUseWithProducts search, BindingResult result ){
    	logger.info(String.format("Go to the /%s/%s page.", TYPE, PATH_SEARCH));
    	return componets.makeLightWeightCollectionOfProduct(useWithProductService.listSearchProducts(search));
    }

    @RequestMapping("/"+ TYPE +"/{id}")
    public String showProduct(@PathVariable("id") long id, Model model){
    	logger.info(String.format("On /%s/%d page.", TYPE, id));
        
    	UseWithProduct product = useWithProductService.getProductById(id);
        model.addAttribute(ATTRIBUTE_PRODUCT, product);
        model.addAttribute(ATTRIBUTE_TYPE, TYPE);       
        
        return TYPE;
    }
	
	@RequestMapping(value = "/" + PATH_ADMIN + "/"+ TYPE +"s", method = RequestMethod.GET)	
    public String listProducts(Model model) {
		model.addAttribute(ATTRIBUTE_TITLE_OF_TABLE, parametersOnAdminProductsPage.get(ATTRIBUTE_TITLE_OF_TABLE));
        model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, useWithProductService.listProducts("id"));
        logger.info(String.format("/%s/%s page.", PATH_ADMIN, CONCRETE_FOLDER));
        
        model.addAttribute(ATTRIBUTE_PRODUCT_TYPE, TYPE);
		model.addAttribute(ATTRIBUTE_NAME_PRODUCT, parametersOnAdminProductsPage.get(ATTRIBUTE_NAME_PRODUCT));
        model.addAttribute(ATTRIBUTE_TITLE, parametersOnAdminProductsPage.get(ATTRIBUTE_TITLE));
        model.addAttribute(ATTRIBUTE_ADD_PRODUCT, parametersOnAdminProductsPage.get(ATTRIBUTE_ADD_PRODUCT));
        model.addAttribute(ATTRIBUTE_PRODUCT_SUB_TYPE, "none");
        return PATH_ADMIN +"/"+ PATH_PRODUCTS;
    }
	
	@RequestMapping(value = "/" + PATH_ADMIN + "/"+ TYPE +"s/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeProducts(@PathVariable("type") String type, Model model) {
		
		List<UseWithProduct> listResult = new ArrayList<UseWithProduct>();
        
        if(links.containsKey(type)){
        	for(UseWithProduct product : useWithProductService.listProducts("id")){
        		if(product.getTypeProduct().equals(links.get(type))){
        			listResult.add(product);
        		}
        	}
        	model.addAttribute(ATTRIBUTE_PRODUCT_SUB_TYPE, type);
        	model.addAttribute(ATTRIBUTE_TITLE_OF_TABLE, links.get(type));
            model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, listResult);
            logger.info(String.format("On /%s/%s/%s page.", PATH_ADMIN, CONCRETE_FOLDER, type));
        } else {
        	model.addAttribute(ATTRIBUTE_PRODUCT_SUB_TYPE, "none");
    		model.addAttribute(ATTRIBUTE_TITLE_OF_TABLE, parametersOnAdminProductsPage.get(ATTRIBUTE_TITLE_OF_TABLE));
            model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, useWithProductService.listProducts("id"));
            logger.info(String.format("On /%s/%s page.", PATH_ADMIN, CONCRETE_FOLDER));
        }
        
        model.addAttribute(ATTRIBUTE_PRODUCT_TYPE, TYPE);
		model.addAttribute(ATTRIBUTE_NAME_PRODUCT, parametersOnAdminProductsPage.get(ATTRIBUTE_NAME_PRODUCT));
        model.addAttribute(ATTRIBUTE_TITLE, parametersOnAdminProductsPage.get(ATTRIBUTE_TITLE));
        model.addAttribute(ATTRIBUTE_ADD_PRODUCT, parametersOnAdminProductsPage.get(ATTRIBUTE_ADD_PRODUCT));
        
        return PATH_ADMIN +"/"+ PATH_PRODUCTS;
    }
	
	@RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/{type}/"+PATH_SORTING+"/{value}",method=RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody List<UseWithProduct> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {
		
		List<UseWithProduct> list = new ArrayList<UseWithProduct>();

		if (links.containsKey(type)) {

			for (UseWithProduct product : useWithProductService.listProducts(value)) {
				if (product.getTypeProduct().equals(links.get(type))) 
					list.add(product);
			}

		} else {
			list.addAll(useWithProductService.listProducts(value));
		}

		return list;
    }
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_NEW, method = RequestMethod.GET)
	public String addNewProduct(Model model) {
		files.clear();
		logger.info(String.format("/%s/%s/%s page.", PATH_ADMIN, PATH_NEW, TYPE));
		model.addAttribute(ATTRIBUTE_PRODUCT, new UseWithProduct());
		
		componets.setJSONtoModelAttribute(model, TYPE);

		model.addAttribute(ATTRIBUTE_TYPE, TYPE);
		model.addAttribute(ATTRIBUTE_PRODUCT_ID, 0);
	    return PATH_ADMIN + "/"+ TYPE;
	}

	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_COPY +"/{id}", method = RequestMethod.GET)
	public String copyProduct(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info(String.format("/%s/%s/%s/%d page.", PATH_ADMIN, TYPE, PATH_COPY, id));
		
		logger.info(String.format("Copy all characteristic of %s.", TYPE));
		UseWithProduct product = useWithProductService.getProductById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer( product.getPathPictures(), DIRECTORY, CONCRETE_FOLDER, id, files );
		
		 /* set null to id because we must get create new product operation */
	     product.setId(null);
		 model.addAttribute(ATTRIBUTE_PRODUCT, product);
		 model.addAttribute(ATTRIBUTE_TYPE, TYPE);
		 model.addAttribute(ATTRIBUTE_PRODUCT_ID, id);
		 
		 componets.setJSONtoModelAttribute(model, TYPE);
	    return PATH_ADMIN +"/"+ TYPE;
	}	
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_ADD, method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid UseWithProduct product,
			BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = useWithProductService.addProduct(product);
		logger.info(String.format("Create new %s! With id=%d", TYPE, id));

		// create folder and add to her new pictures
		product.getPathPictures()
				.addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));
		
        //if it is PAINT type product
        if(product.getTypeProduct().equals("Чернила для струйной печати"))
        	product.setPrise(0);

		this.useWithProductService.updateProduct(product);

		files.clear();

		linksForProduct.createLinks(useWithProductService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/" + PATH_ADMIN + "/"+ TYPE +"s";
	}

	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_ADD, method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid UseWithProduct product,
			BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = useWithProductService.addProduct(product);
		logger.info(String.format("Create new %s! With id=%d", TYPE, id));

		// create folder and add to her new pictures
		product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, CONCRETE_FOLDER, id, files));
		
		//if it is PAINT type product
        if(product.getTypeProduct().equals("Чернила для струйной печати"))
        	product.setPrise(0);

		this.useWithProductService.updateProduct(product);

		files.clear();

		linksForProduct.createLinks(useWithProductService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/" + PATH_ADMIN + "/" + TYPE + "/"+ PATH_EDIT +"/" + id;
	}
	
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_EDIT +"/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
    	
    	logger.info(String.format("Begin editing %s with id=%d", TYPE, id));
    	UseWithProduct undateProduct = useWithProductService.getProductById(id);
    	
        model.addAttribute(ATTRIBUTE_PRODUCT, undateProduct);
        model.addAttribute(ATTRIBUTE_TYPE, TYPE);
        componets.setJSONtoModelAttribute(model, TYPE);
        
        return PATH_ADMIN + "/" + TYPE;
    }
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_UPDATE, method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid UseWithProduct product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);
		
		logger.info(String.format("%s UPDATE with save, id=%d", TYPE, product.getId()));
		
		List<String> pathPictures = useWithProductService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
		
		//if it is PAINT type product
        if(product.getTypeProduct().equals("Чернила для струйной печати"))
        	product.setPrise(0);
        
		useWithProductService.updateProduct(product);
        logger.info(String.format("%s with id=%d was UDPATED", TYPE, product.getId()));
		  
		linksForProduct.createLinks(useWithProductService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, TYPE);
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/" + PATH_ADMIN + "/" + TYPE + "/"+ PATH_EDIT +"/" + product.getId();
	}
	
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid UseWithProduct product,
			BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);

		logger.info(String.format("%s UPDATE id=%d", TYPE, product.getId()));
		List<String> pathPictures = useWithProductService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
		
		//if it is PAINT type product
        if(product.getTypeProduct().equals("Чернила для струйной печати"))
        	product.setPrise(0);

		useWithProductService.updateProduct(product);
		logger.info(String.format("%s with id=%d was UDPATED", TYPE, product.getId()));

		files.clear();

		linksForProduct.createLinks(useWithProductService.listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, TYPE);

		logger.info("Update links to the products in left menu!");
		return "redirect:/" + PATH_ADMIN +"/"+ TYPE + "s";
	}
	
	private String adminFormHasError(UseWithProduct product, Model model){
		model.addAttribute(ATTRIBUTE_PRODUCT, product);
		model.addAttribute(ATTRIBUTE_TYPE, TYPE);
		
		componets.setJSONtoModelAttribute(model, TYPE);
        return PATH_ADMIN + "/" + TYPE;
	}
    
    @RequestMapping(value="/" + PATH_ADMIN + "/" + TYPE + "/"+ PATH_UPLOAD_PICTURES, method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {
         return componets.uploadPictureOnCreationProduct(request, files);
    }

    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_CHANGE_ORDER_PICTURES, method = RequestMethod.POST,consumes=JSON_CONSUMES,headers = JSON_HEADERS)
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	componets.changeOrderPictures(CONCRETE_FOLDER, selectedIds, files); 	  	
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_REMOVE_PICTURE +"/{name_picture}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePictureFromPicturesContainer(CONCRETE_FOLDER, namePicture, files);
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPLOAD_PICTURES_UPDATE +"/{id}", method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesUpdate(MultipartHttpServletRequest request, @PathVariable("id") long id) {
    	
    	String nameOfAddedPicture = componets.uploadPictureToExistedProduct(request, DIRECTORY, CONCRETE_FOLDER, id);   	
    	UseWithProduct product = useWithProductService.getProductById(id);
 		product.getPathPictures().add(nameOfAddedPicture);
 		useWithProductService.updateProduct(product);
         
       return nameOfAddedPicture;
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_CHANGE_ORDER_PICTURES_UPDATE +"/{id}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info(String.format("change order of pictures in changed %s product", TYPE));
    	
    	UseWithProduct product = useWithProductService.getProductById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	useWithProductService.updateProduct(product);
    }
    
    @RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/"+PATH_REMOVE_PICTURE_UPDATE+"/{name_picture}/{id}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	
    	String name = namePicture.replace(":", ".");
    	UseWithProduct product = useWithProductService.getProductById(id);
    	product.getPathPictures().remove(name);
    	
    	componets.removePicture(name, DIRECTORY, CONCRETE_FOLDER, id);
    	
    	if(product.getPathPictures().size()==0){
    		componets.loadDefaultPicture(DIRECTORY, CONCRETE_FOLDER, product.getId());
			product.getPathPictures().add("default.jpg");
    	}
    	
    	logger.info(String.format("Remove pictore with name = %s from changed %s product", name, TYPE));

    	useWithProductService.updateProduct(product);
    }
    
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_REMOVE +"/{id}")
    public String removeProduct(@PathVariable("id") long id){
    	logger.info(String.format("Start deleting %s from database, id=%d", TYPE, id));
    	
    	componets.removeAllPricturesOfConcreteProduct(DIRECTORY, CONCRETE_FOLDER, id);
    		
    	logger.info("Update links to the products in left menu!");
    	componets.updateInLeftField(useWithProductService.getProductById(id), false, TYPE);
    		
    	logger.info(String.format("DELETE %s with id=%d from database", TYPE, id));
    	useWithProductService.removeProduct(id);
        
    	linksForProduct.createLinks(useWithProductService.listShowOnSite());
    		
        return "redirect:/"+ PATH_ADMIN + "/" + TYPE + "s";
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SHOW_ON_SITE +"/{id}",method = RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	UseWithProduct product = useWithProductService.getProductById(id);
    	product.setShowOnSite(value);
    	useWithProductService.updateProduct(product);
    	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide() , TYPE);
    	linksForProduct.createLinks(useWithProductService.listShowOnSite());
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SET_TOP +"/{id}",method = RequestMethod.POST,consumes=JSON_CONSUMES,headers = JSON_HEADERS)
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	UseWithProduct product = useWithProductService.getProductById(id);
    	product.setTop(value);
    	useWithProductService.updateProduct(product);
    }
    
    @RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/"+ PATH_SHOW_ON_HOME_PAGE+"/{id}",method=RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	UseWithProduct product = useWithProductService.getProductById(id);
    	product.setShowOnHomePage(value);
    	useWithProductService.updateProduct(product);
    }
    
    @RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/"+PATH_SHOW_ON_LEFT_SIDE+"/{id}",method=RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	UseWithProduct product = useWithProductService.getProductById(id);
    	product.setShowOnLeftSide(value);
    	useWithProductService.updateProduct(product);	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide(), TYPE);
    }
}