package com.printmaster.nk.controller.product;

import static com.printmaster.nk.controller.ConstUsedInContr.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.entity.Comment;
import com.printmaster.nk.model.entity.HeadProduct;
import com.printmaster.nk.model.entity.search.SearchGeneric;
import com.printmaster.nk.model.service.CommentService;
import com.printmaster.nk.model.service.ProductService;
import com.printmaster.nk.model.service.UseWithProductService;

public abstract class ProductControllerTemplate <T extends HeadProduct, S extends SearchGeneric>{
	
	private Class<T> product;	
	private Class<S> searchCriteries;
	private Logger logger =  Logger.getLogger(this.getClass().getName());
	
	@Autowired
	private LinksForProducts linksForProduct;
	
	@Autowired
    private ComponentsForControllers componets;

    @Autowired
    private PicturesContainer files;
    
    @Autowired
	private CommentService commentService;

	private UseWithProductService useWithProductService;
	
	public ProductControllerTemplate(Class<T> clazz, Class<S> searchCriteries){
		this.product = clazz;
		this.searchCriteries = searchCriteries;
	}
	
	public abstract String getTYPE();
	public abstract String getCONCRETE_FOLDER();
	public abstract ProductService<T,S> getProductService();
	public abstract Map<String, String> getLinks();
	public abstract Map<String, String> getParametersOnAdminProductsPage();
	public abstract Map<String, ProductPropertiesHelper> getPropertiesDescription();
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }

    public UseWithProductService getUseWithProductService() {
		return useWithProductService;
	}

	public String allProductsTemplate(Model model){
        model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, componets.makeLightWeightCollectionOfProduct(getProductService().listShowOnSite()));
        
		try {
			S search = (S) searchCriteries.newInstance();
			search.setPrise0(0);
	        search.setPrise1(100000);
	   
	        model.addAttribute(ATTRIBUTE_SEARCH, search);
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

        componets.setJSONtoModelAttribute(model, getTYPE());
        logger.info(String.format("/%s", getCONCRETE_FOLDER()));
        return getTYPE() + "s";
    }
	
	public String allProductsWithTypeTemplate(String subType, Model model) {
		S search = null;
		try {
			search = (S) searchCriteries.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
        String currentType = null;
   
        if(getLinks().containsKey(subType)){
        	currentType = getLinks().get(subType);
        	logger.info(String.format("/%s/%s", getCONCRETE_FOLDER(), subType));
        } else {
        	return "redirect:/";
        }
        
        String[] a = {currentType};
        search.setTypeProduct(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute(ATTRIBUTE_SEARCH, search);
        model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, componets.makeLightWeightCollectionOfProduct(getProductService().listSearchProducts(search)));
        
        componets.setJSONtoModelAttribute(model, getTYPE());
        
        return getTYPE() +"s/" + subType ;
    }

    public ArrayList<JSONObject> showSearchProductsTemplate(S search, BindingResult result){
    	logger.info(String.format("/%s/%s", getTYPE(), PATH_SEARCH));
    	
    	ArrayList<JSONObject> resultSearch = new ArrayList<JSONObject>();
    	
    	try{
    		logger.info(search);
    		resultSearch = componets.makeLightWeightCollectionOfProduct(getProductService().listSearchProducts(search));
    	} catch(Exception ex){
    		logger.error(ex);
    	}
    	
    	return resultSearch;
    }
	
    public String showConcreteProductTemplate(long id, Model model){
    	logger.info(String.format("/%s/%d", getTYPE(), id));
        
        T product = getProductService().getProductById(id);
        model.addAttribute(ATTRIBUTE_PRODUCT, product);
        model.addAttribute(ATTRIBUTE_TYPE, getTYPE());       
        model.addAttribute(ATTRIBUTE_UWP, product.getIdUseWithProduct()!=null ?
        		componets.showSimplestArrayOfUseWithProduct(useWithProductService.getProductsByIds(product.getIdUseWithProduct())) : null);
        
        model.addAttribute("comments", commentService.getAllForProduct(getTYPE(), id));
        model.addAttribute("addComment", new Comment());

        componets.setJSONtoModelAttribute(model, getTYPE());
        
        return getTYPE();
    }
    
    public String adminListProductsTemplate(Model model){
		model.addAttribute(ATTRIBUTE_TITLE_OF_TABLE, getParametersOnAdminProductsPage().get(ATTRIBUTE_TITLE_OF_TABLE));
        model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, getProductService().listProducts("id"));
        logger.info(String.format("/%s/%s", PATH_ADMIN, getCONCRETE_FOLDER()));
        
        model.addAttribute(ATTRIBUTE_PRODUCT_TYPE, getTYPE());
		model.addAttribute(ATTRIBUTE_NAME_PRODUCT, getParametersOnAdminProductsPage().get(ATTRIBUTE_NAME_PRODUCT));
        model.addAttribute(ATTRIBUTE_TITLE, getParametersOnAdminProductsPage().get(ATTRIBUTE_TITLE));
        model.addAttribute(ATTRIBUTE_ADD_PRODUCT, getParametersOnAdminProductsPage().get(ATTRIBUTE_ADD_PRODUCT));
        model.addAttribute(ATTRIBUTE_PRODUCT_SUB_TYPE, "none");
        return PATH_ADMIN +"/"+ PATH_PRODUCTS;
    }
	
    public String adminListConcreteTypeProductsTemplate(String type, Model model) {
		
		List<T> listResult = new ArrayList<T>();
        
        if(getLinks().containsKey(type)){
        	for(T product : getProductService().listProducts("id")){
        		if(product.getTypeProduct().equals(getLinks().get(type))){
        			listResult.add(product);
        		}
        	}
        	model.addAttribute(ATTRIBUTE_PRODUCT_SUB_TYPE, type);
        	model.addAttribute(ATTRIBUTE_TITLE_OF_TABLE, getParametersOnAdminProductsPage().get(ATTRIBUTE_TITLE_OF_TABLE) + " " + getLinks().get(type).toLowerCase());
            model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, listResult);
            logger.info(String.format("/%s/%s/%s", PATH_ADMIN, getCONCRETE_FOLDER(), type));
        } else {
        	model.addAttribute(ATTRIBUTE_PRODUCT_SUB_TYPE, "none");
    		model.addAttribute(ATTRIBUTE_TITLE_OF_TABLE, getParametersOnAdminProductsPage().get(ATTRIBUTE_TITLE_OF_TABLE));
            model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, getProductService().listProducts("id"));
            logger.info(String.format("/%s/%s", PATH_ADMIN, getCONCRETE_FOLDER()));
        }
        
        model.addAttribute(ATTRIBUTE_PRODUCT_TYPE, getTYPE());
		model.addAttribute(ATTRIBUTE_NAME_PRODUCT, getParametersOnAdminProductsPage().get(ATTRIBUTE_NAME_PRODUCT));
        model.addAttribute(ATTRIBUTE_TITLE, getParametersOnAdminProductsPage().get(ATTRIBUTE_TITLE));
        model.addAttribute(ATTRIBUTE_ADD_PRODUCT, getParametersOnAdminProductsPage().get(ATTRIBUTE_ADD_PRODUCT));
        
        return PATH_ADMIN +"/"+ PATH_PRODUCTS;
    }
	
    public List<T> sortingProductsInAdminTemplate(String type, String value) {
		
		List<T> list = new ArrayList<T>();

		if (getLinks().containsKey(type)) {
			for (T product : getProductService().listProducts(value)) {
				if (product.getTypeProduct().equals(getLinks().get(type))) 
					list.add(product);
			}
		} else {
			list.addAll(getProductService().listProducts(value));
		}

		return list;
    }
	
	public String addNewProductTemplate(Model model) {
		files.clear();
		logger.info(String.format("/%s/%s/%s", PATH_ADMIN, PATH_NEW, getTYPE()));
		try {
			model.addAttribute(ATTRIBUTE_PRODUCT, product.newInstance());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		componets.setJSONtoModelAttribute(model, getTYPE());
		
		model.addAttribute(ATTRIBUTE_UWP, componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute(ATTRIBUTE_TYPE, getTYPE());
		model.addAttribute(ATTRIBUTE_PRODUCT_ID, 0);
	    return PATH_ADMIN + "/"+ getTYPE();
	}
	
	public String copyProductTemplate(long id, Model model) {
		files.clear();
		logger.info(String.format("/%s/%s/%s/%d", PATH_ADMIN, getTYPE(), PATH_COPY, id));
		
		logger.info(String.format("Copy all characteristic of %s.", getTYPE()));
		T product = getProductService().getProductById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer( product.getPathPictures(), DIRECTORY, getCONCRETE_FOLDER(), id, files );
		
		 /* set null to id because we must get create new product operation */
	     product.setId(null);
		 model.addAttribute(ATTRIBUTE_PRODUCT, product);
		 model.addAttribute(ATTRIBUTE_UWP, componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute(ATTRIBUTE_TYPE, getTYPE());
		 model.addAttribute(ATTRIBUTE_PRODUCT_ID, id);
		 
		 componets.setJSONtoModelAttribute(model, getTYPE());
	    return PATH_ADMIN +"/"+ getTYPE();
	}
     
	public String handleFormUploadTemplate(T product, BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = getProductService().addProduct(product);
		logger.info(String.format("Create new %s! With id=%d", getTYPE(), id));

		// create folder and add to her new pictures
		product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, getCONCRETE_FOLDER(), id, files));

		getProductService().updateProduct(product);

		files.clear();

		linksForProduct.createLinks(getProductService().listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, getTYPE());

		logger.info("Update links to the products in left menu!");
		return "redirect:/" + PATH_ADMIN + "/"+ getTYPE() +"s";
	}
	
	public String handleFormUploadSaveTemplate(T product, BindingResult result, Model model){

		if (result.hasErrors()) return adminFormHasError(product, model);

		long id = getProductService().addProduct(product);
		logger.info(String.format("Create new %s! With id=%d", getTYPE(), id));

		// create folder and add to her new pictures
		product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(DIRECTORY, getCONCRETE_FOLDER(), id, files));

		getProductService().updateProduct(product);

		files.clear();

		linksForProduct.createLinks(getProductService().listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, getTYPE());

		logger.info("Update links to the products in left menu!");
		return "redirect:/" + PATH_ADMIN + "/" + getTYPE() + "/"+ PATH_EDIT +"/" + id;
	}
	
    public String editProductTemplate(long id, Model model){
    	
    	logger.info(String.format("Begin editing %s with id=%d", getTYPE(), id));
    	T undateProduct = getProductService().getProductById(id);
    	
        model.addAttribute(ATTRIBUTE_PRODUCT, undateProduct);
        model.addAttribute(ATTRIBUTE_UWP, componets.showSimplestArrayOfUseWithProduct(
        		useWithProductService.listShowOnSite()));
        model.addAttribute(ATTRIBUTE_TYPE, getTYPE());
        componets.setJSONtoModelAttribute(model, getTYPE());
        
        return PATH_ADMIN + "/" + getTYPE();
    }
	
	public String updateSaveProductTemplate(T product, BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);
		
		logger.info(String.format("%s UPDATE with save, id=%d", getTYPE(), product.getId()));
		
		List<String> pathPictures = getProductService().getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		getProductService().updateProduct(product);
        logger.info(String.format("%s with id=%d was UDPATED", getTYPE(), product.getId()));
		  
		linksForProduct.createLinks(getProductService().listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
	    	componets.updateInLeftField(product, true, getTYPE());
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/" + PATH_ADMIN + "/" + getTYPE() + "/"+ PATH_EDIT +"/" + product.getId();
	}
	
	public String updateProductTemplate(T product, BindingResult result, Model model){
		
		if (result.hasErrors()) return adminFormHasError(product, model);

		logger.info(String.format("%s UPDATE id=%d", getTYPE(), product.getId()));
		List<String> pathPictures = getProductService().getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);

		getProductService().updateProduct(product);
		logger.info(String.format("%s with id=%d was UDPATED", getTYPE(), product.getId()));

		files.clear();

		linksForProduct.createLinks(getProductService().listShowOnSite());

		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, getTYPE());

		logger.info("Update links to the products in left menu!");
		return "redirect:/" + PATH_ADMIN +"/"+ getTYPE() + "s";
	}
	
	private String adminFormHasError(T product, Model model){
		model.addAttribute(ATTRIBUTE_PRODUCT, product);
		model.addAttribute(ATTRIBUTE_UWP, componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute(ATTRIBUTE_TYPE, getTYPE());
		
		componets.setJSONtoModelAttribute(model, getTYPE());
        return PATH_ADMIN + "/" + getTYPE();
	}
	

    public String uploadPicturesTemplate(MultipartHttpServletRequest request) {
         return componets.uploadPictureOnCreationProduct(request, files);
    }
    
    public void changeOrderPicturesTemplate(List<String> selectedIds) {
    	componets.changeOrderPictures(getCONCRETE_FOLDER(), selectedIds, files); 	  	
    }
    
    public void removePictureTemplate(String namePicture) {
    	componets.removePictureFromPicturesContainer(getCONCRETE_FOLDER(), namePicture, files);
    }
    
    public String uploadPicturesUpdateTemplate(MultipartHttpServletRequest request, long id) {
    	
    	String nameOfAddedPicture = componets.uploadPictureToExistedProduct(request, DIRECTORY, getCONCRETE_FOLDER(), id);   	
 		T product = getProductService().getProductById(id);
 		product.getPathPictures().add(nameOfAddedPicture);
 		getProductService().updateProduct(product);
         
       return nameOfAddedPicture;
    }
    
    public void changeOrderPicturesUpdateTemplate(List<String> selectedIds, long id) {
    	logger.info(String.format("change order of pictures in changed %s product", getTYPE()));
    	
    	T product = getProductService().getProductById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	getProductService().updateProduct(product);
    }
    
    public void removePictureTemplate(String namePicture, long id) {
    	
    	String name = namePicture.replace(":", ".");
    	T product = getProductService().getProductById(id);
    	product.getPathPictures().remove(name);
    	
    	componets.removePicture(name, DIRECTORY, getCONCRETE_FOLDER(), id);
    	
    	if(product.getPathPictures().size()==0){
    		String nameOfDefaultPicture = componets.loadDefaultPicture(DIRECTORY, getCONCRETE_FOLDER(), product.getId());
			product.getPathPictures().add(nameOfDefaultPicture);
    	}
    	
    	logger.info(String.format("Remove pictore with name = %s from changed %s product", name, getTYPE()));

    	getProductService().updateProduct(product);
    }
    
    public String removeProductTemplate(long id){
    	logger.info(String.format("Start deleting %s from database, id=%d", getTYPE(), id));
    	
    	componets.removeAllPricturesOfConcreteProduct(DIRECTORY, getCONCRETE_FOLDER(), id);
    		
    	logger.info("Update links to the products in left menu!");
    	componets.updateInLeftField(getProductService().getProductById(id), false, getTYPE());
    		
    	logger.info(String.format("DELETE %s with id=%d from database", getTYPE(), id));
    	getProductService().removeProduct(id);
        
    	linksForProduct.createLinks(getProductService().listShowOnSite());
    		
        return "redirect:/"+ PATH_ADMIN + "/" + getTYPE() + "s";
    }  
    
    public void showOnSiteTemplate(long id, boolean value) {
    	T product = getProductService().getProductById(id);
    	product.setShowOnSite(value);
    	getProductService().updateProduct(product);
    	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide() , getTYPE());
    	linksForProduct.createLinks(getProductService().listShowOnSite());
    	logger.info(String.format("Show on site %s with id=%d", getTYPE(), id));
    }
    
    public void setTopTemplate(long id, boolean value) {
    	T product = getProductService().getProductById(id);
    	product.setTop(value);
    	getProductService().updateProduct(product);
    	
    	if(value){
    		logger.info(String.format("Set show IN TOP %s with id=%d", getTYPE(), id));
    	} else {
    		logger.info(String.format("Set DOESN'T show  IN TOP %s with id=%d", getTYPE(), id));
    	}
    }
    
    public void showOnHomePageTemplate(long id, boolean value) {
    	T product = getProductService().getProductById(id);
    	product.setShowOnHomePage(value);
    	getProductService().updateProduct(product);
    	
    	if(value){
    		logger.info(String.format("Set show ON HOME PAGE %s with id=%d", getTYPE(), id));
    	} else {
    		logger.info(String.format("Set DOESN'T show ON HOME PAGE %s with id=%d", getTYPE(), id));
    	}
    	
    }
    
    public void showOnLeftSideTemplate(long id, boolean value) {
    	T product = getProductService().getProductById(id);
    	product.setShowOnLeftSide(value);
    	getProductService().updateProduct(product);	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide(), getTYPE());
    	
    	if(value){
    		logger.info(String.format("Set show ON LEFT SIDE %s with id=%d", getTYPE(), id));
    	} else {
    		logger.info(String.format("Set DOESN'T show ON LEFT SIDE %s with id=%d", getTYPE(), id));
    	}
    }
    
    
    /* Block for changing properties of product */
	public String pageEditPropertiesTemplate(Model model, String property) {
    	componets.setJSONtoModelAttributeForChanging(model, getTYPE());
    	model.addAttribute("property", property);
    	model.addAttribute("type", getTYPE());    	
    	model.addAttribute("property_description", getPropertiesDescription().get(property));
    	
    	logger.info(String.format("Edit properties"));
	    return "admin/change_properties";
	}
    
	public String saveCheckedPropertiesTemplate(String propertyName, List<String> properties) {
    	componets.showValueOfParameter(getTYPE(), propertyName, properties);
    	logger.info("Save checked properties");
	    return "redirect:/admin/"+ getTYPE() +"/properties/" + propertyName;
	}
    
    @SuppressWarnings("unchecked")
    public JSONObject checkNewPropertyValueTemplate(String name, String propertyName) {
    	JSONObject result = new JSONObject();
    	result.put("result", componets.isParameterRepeated(getTYPE(), propertyName, name));
    	logger.info("Check new property value");
    	return result;
    }
    
	public String addPropertyTemplate(String newProperty, String propertyName) {
    	componets.setNewValueOfParameter(getTYPE(), propertyName, newProperty);
    	logger.info("Add property");
	    return "redirect:/admin/"+ getTYPE() +"/properties/" + propertyName;
	}
    
    /**
     * 
     * BLOCK FOR EDIT PROPERTIES INCLUDE INTERNATIONALIZATION TO THEM
     * 
     * **/
	public String pageEditPropertiesITemplate(Model model, String property) {
    	componets.setJSONtoModelAttributeForChanging(model, getTYPE());
    	model.addAttribute("property", property);
    	model.addAttribute("type", getTYPE());
    	
    	model.addAttribute("property_description", getPropertiesDescription().get(property));
    	logger.info("Page edit properties Internationalization");
	    return "admin/change_properties_I";
	}
    
	public void saveCheckedPropertiesITemplate(String propertyName, List<PropertyInternationalization> properties) {
    	componets.showValueOfParameterI(getTYPE(), propertyName, properties);
    	logger.info("Save checked properties Internationalization");
	}
    
    @SuppressWarnings("unchecked")
    public JSONObject checkNewPropertyValueITemplate(String name, String propertyName) {
    	JSONObject result = new JSONObject();
    	result.put("result", componets.isParameterRepeatedI(getTYPE(), propertyName, name));
    	logger.info("Check new property values Internationalization");
    	return result;
    }
    
	public String addPropertyITemplate(String newProperty, String propertyName) {
    	componets.setNewValueOfParameterI(getTYPE(), propertyName, newProperty);
    	logger.info("Add property Internationalization");
	    return "redirect:/admin/"+ getTYPE() +"/properties_i/" + propertyName;
	}
    
}
