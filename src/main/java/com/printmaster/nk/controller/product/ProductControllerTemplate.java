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
	private Logger logger =  Logger.getLogger(ProductControllerTemplate.class);
	
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
        logger.info(String.format("On '../%s' page.", getCONCRETE_FOLDER()));
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
        	logger.info(String.format("On the /%s/%s page.", getCONCRETE_FOLDER(), subType));
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
    	logger.info(String.format("Go to the /%s/%s page.", getTYPE(), PATH_SEARCH));
    	return componets.makeLightWeightCollectionOfProduct(getProductService().listSearchProducts(search));
    }
	
    public String showConcreteProductTemplate(long id, Model model){
    	logger.info(String.format("On /%s/%d page.", getTYPE(), id));
        
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
        logger.info(String.format("/%s/%s page.", PATH_ADMIN, getCONCRETE_FOLDER()));
        
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
            logger.info(String.format("On /%s/%s/%s page.", PATH_ADMIN, getCONCRETE_FOLDER(), type));
        } else {
        	model.addAttribute(ATTRIBUTE_PRODUCT_SUB_TYPE, "none");
    		model.addAttribute(ATTRIBUTE_TITLE_OF_TABLE, getParametersOnAdminProductsPage().get(ATTRIBUTE_TITLE_OF_TABLE));
            model.addAttribute(ATTRIBUTE_LIST_PRODUCTS, getProductService().listProducts("id"));
            logger.info(String.format("On /%s/%s page.", PATH_ADMIN, getCONCRETE_FOLDER()));
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
		logger.info(String.format("/%s/%s/%s page.", PATH_ADMIN, PATH_NEW, getTYPE()));
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
		logger.info(String.format("/%s/%s/%s/%d page.", PATH_ADMIN, getTYPE(), PATH_COPY, id));
		
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
    }
    
    public void setTopTemplate(long id, boolean value) {
    	T product = getProductService().getProductById(id);
    	product.setTop(value);
    	getProductService().updateProduct(product);
    }
    
    public void showOnHomePageTemplate(long id, boolean value) {
    	T product = getProductService().getProductById(id);
    	product.setShowOnHomePage(value);
    	getProductService().updateProduct(product);
    }
    
    public void showOnLeftSideTemplate(long id, boolean value) {
    	T product = getProductService().getProductById(id);
    	product.setShowOnLeftSide(value);
    	getProductService().updateProduct(product);	
    	componets.updateInLeftField(product, product.isShowOnSite() && product.isShowOnLeftSide(), getTYPE());
    }
}
