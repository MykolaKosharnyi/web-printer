package com.mykoshar.shop.api.controller.product;

import static com.mykoshar.shop.api.controller.ConstUsedInContr.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import com.mykoshar.shop.api.model.entity.Cutter;
import com.mykoshar.shop.api.model.entity.search.SearchCutters;
import com.mykoshar.shop.api.model.service.CutterService;

@Controller
public class CutterController extends ProductControllerTemplate<Cutter, SearchCutters>{
	
	private final String TYPE = CUTTER;
	private final String CONCRETE_FOLDER = CUTTER + "s";
	private CutterService productService;

	public CutterController() {
		super(Cutter.class, SearchCutters.class);
	}

	private Map<String, String> links = new HashMap<String, String>() {
		private static final long serialVersionUID = 6020303266276652199L;

		{
			put("for_wood", "Для обработки дерева");
			put("for_the_treatment_of_metal", "Для обработки металла");
			put("stone_processing", "Для обработки камня");
		}
	};

	private Map<String, String> parametersOnAdminProductsPage = new HashMap<String, String>() {
		private static final long serialVersionUID = 6020303266276652199L;

		{
			put(ATTRIBUTE_TITLE_OF_TABLE, "Список загруженных граверов/фрезеров");
			put(ATTRIBUTE_NAME_PRODUCT, "Имя гравера/фрезера");
			put(ATTRIBUTE_TITLE, "Гравера/фрезера");
			put(ATTRIBUTE_ADD_PRODUCT, "Добавить гравер/фрезер");
		}
	};
	
	private Map<String, ProductPropertiesHelper> properties = new HashMap<String, ProductPropertiesHelper>(){
		private static final long serialVersionUID = 5962853935903305295L;
		{
			put("availability", new ProductPropertiesHelper(
					"Добавление/Изменение наличия для фрезеров",
					"Добавление наличие",
					"Есть повторение с раннее введенным наличием!",
					"Добавить наличие",
					"Изменение вывода наличия для фрезеров"));
			
			put("previously_used", new ProductPropertiesHelper(
					"Добавление/Изменение состояния оборудования для фрезеров",
					"Добавление состояние оборудования",
					"Есть повторение с раннее введенным состоянием оборудования!",
					"Добавить состояние оборудования",
					"Изменение вывода состояний оборудования для фрезеров"));
			
			put("type_of_cooling", new ProductPropertiesHelper(
					"Добавление/Изменение типа охлажденя для фрезеров",
					"Добавление типа охлаждения",
					"Есть повторение с раннее введенным типом охлаждения!",
					"Добавить тип охлаждения",
					"Изменение вывода типа охлаждений для фрезеров"));
			
			put("type_cutter", new ProductPropertiesHelper(
					"Добавление/Изменение типа  фрезеров",
					"Добавление типа",
					"Есть повторение с раннее введенным типом!",
					"Добавить тип фрезера",
					"Изменение вывода типа фрезеров"));
			
			put("engraving_style", new ProductPropertiesHelper(
					"Добавление/Изменение типа гравировки фрезеров",
					"Добавление типа гравировки",
					"Есть повторение с раннее введенным типом гравировки!",
					"Добавить тип гравировки",
					"Изменение вывода типа гравировки"));
			
			put("type_engine", new ProductPropertiesHelper(
					"Добавление/Изменение типа двигателей для фрезеров",
					"Добавление типа двигателя",
					"Есть повторение с раннее введенным типом двигателя!",
					"Добавить тип двигателя",
					"Изменение вывода типа двигателя"));
			
			put("mounting_tool", new ProductPropertiesHelper(
					"Добавление/Изменение крепления инструментов для фрезеров",
					"Добавление крепления инструментов",
					"Есть повторение с раннее введенным креплением инструментов!",
					"Добавить крепление инструментов",
					"Изменение вывода креплений инструментов"));
			
			put("equipment_manufacturer", new ProductPropertiesHelper(
					"Добавление/Изменение производителя оборудования для фрезеров",
					"Добавление производителя оборудования",
					"Есть повторение с раннее введенным производителем оборудования!",
					"Добавить производителя оборудования",
					"Изменение вывода производителей оборудования"));
			
			put("connection_interface", new ProductPropertiesHelper(
					"Добавление/Изменение интерфейса подключения для фрезеров",
					"Добавление интерфейс подключения",
					"Есть повторение с раннее введенным интерфейсом подключения!",
					"Добавить интерфейс подключения",
					"Изменение вывода интерфейсов подключения"));
			
			put("software", new ProductPropertiesHelper(
					"Добавление/Изменение программного обеспечения для фрезеров",
					"Добавление програмный интерфейс",
					"Есть повторение с раннее введенным програмным интерфейсом!",
					"Добавить програмный интерфейс",
					"Изменение вывода програмных интерфейсов"));

		}
	};
	
    @Autowired(required=true)
    @Qualifier(value="cutterService")
    public void setProductService(CutterService ps){
        this.productService = ps;
    }
    
	public CutterService getProductService() {
		return productService;
	}

	public String getTYPE() {
		return TYPE;
	}

	public String getCONCRETE_FOLDER() {
		return CONCRETE_FOLDER;
	}
	
	public Map<String, String> getLinks() {
		return links;
	}

	public Map<String, String> getParametersOnAdminProductsPage() {
		return parametersOnAdminProductsPage;
	}
	
	@Override
	public Map<String, ProductPropertiesHelper> getPropertiesDescription() {
		return properties;
	}
    
	@RequestMapping(value = "/"+ TYPE +"s", method = RequestMethod.GET)	
    public String allProducts(Model model) {
		return allProductsTemplate(model);
    }
	
	@RequestMapping(value = "/"+ TYPE +"s/{subType}", method = RequestMethod.GET)	
    public String typeProducts(@PathVariable("subType") String subType, Model model) {     
        return allProductsWithTypeTemplate(subType, model);
    }

    @RequestMapping(value="/"+ TYPE +"s/"+ PATH_SEARCH, method=RequestMethod.POST, produces=JSON_PRODUCES)
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchCutters search, BindingResult result ){
    	return showSearchProductsTemplate(search, result);
    }
	
    @RequestMapping("/"+ TYPE +"/{id}")
    public String showProduct(@PathVariable("id") long id, Model model){
        return showConcreteProductTemplate(id, model);
    }
    
	@RequestMapping(value = "/" + PATH_ADMIN + "/"+ TYPE +"s", method = RequestMethod.GET)	
    public String adminListProducts(Model model) {
		return adminListProductsTemplate(model);
    }
	
	@RequestMapping(value = "/" + PATH_ADMIN + "/"+ TYPE +"s/{type}", method = RequestMethod.GET)	
    public String adminListConcreteTypeProducts(@PathVariable("type") String type, Model model) {
        return adminListConcreteTypeProductsTemplate(type, model);
    }
	
	@RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/{type}/"+PATH_SORTING+"/{value}",method=RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody List<Cutter> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {	
		return sortingProductsInAdminTemplate(type, value);
    }
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_NEW, method = RequestMethod.GET)
	public String addNewProduct(Model model) {
	    return addNewProductTemplate(model);
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_COPY +"/{id}", method = RequestMethod.GET)
	public String copyProduct(@PathVariable("id") long id, Model model) {
	    return copyProductTemplate(id, model);
	}
     
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_ADD, method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Cutter product,
			BindingResult result, Model model){
		return handleFormUploadTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_ADD, method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Cutter product,
			BindingResult result, Model model){
		return handleFormUploadSaveTemplate(product, result, model);
	}
	
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_EDIT +"/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        return editProductTemplate(id, model);
    }
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_UPDATE, method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Cutter product,
			BindingResult result, Model model){
		return updateSaveProductTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Cutter product,
			BindingResult result, Model model){
		return updateProductTemplate(product, result, model);
	}
	
    @RequestMapping(value="/" + PATH_ADMIN + "/" + TYPE + "/"+ PATH_UPLOAD_PICTURES, method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {
         return uploadPicturesTemplate(request);
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_CHANGE_ORDER_PICTURES, method = RequestMethod.POST,consumes=JSON_CONSUMES,headers = JSON_HEADERS)
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	changeOrderPicturesTemplate(selectedIds);  	
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_REMOVE_PICTURE +"/{name_picture}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	removePictureTemplate(namePicture);
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPLOAD_PICTURES_UPDATE +"/{id}", method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesUpdate(MultipartHttpServletRequest request, @PathVariable("id") long id) {         
       return uploadPicturesUpdateTemplate(request, id);
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_CHANGE_ORDER_PICTURES_UPDATE +"/{id}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	changeOrderPicturesUpdateTemplate(selectedIds, id);
    }
    
    @RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/"+PATH_REMOVE_PICTURE_UPDATE+"/{name_picture}/{id}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	removePictureTemplate(namePicture, id);
    }
    
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_REMOVE +"/{id}")
    public String removeProduct(@PathVariable("id") long id){
        return removeProductTemplate(id);
    }  
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SHOW_ON_SITE +"/{id}",method = RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	showOnSiteTemplate(id, value);
    }
    
    @RequestMapping(value="/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SET_TOP +"/{id}",method = RequestMethod.POST,consumes=JSON_CONSUMES,headers = JSON_HEADERS)
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	setTopTemplate(id, value);
    }
    
    @RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/"+ PATH_SHOW_ON_HOME_PAGE+"/{id}",method=RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	showOnHomePageTemplate(id, value);
    }
    
    @RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/"+PATH_SHOW_ON_LEFT_SIDE+"/{id}",method=RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	showOnLeftSideTemplate(id, value);
    }

    @RequestMapping(value = "/admin/"+ TYPE +"/properties/{property}", method = RequestMethod.GET)
	public String pageEditProperties(Model model, @PathVariable("property") String property) {
    	return pageEditPropertiesTemplate(model,property);
	}
    
    @RequestMapping(value = "/admin/"+ TYPE +"/properties/{property}", method = RequestMethod.POST)
	public String saveCheckedProperties(@PathVariable("property") String propertyName,
			@RequestParam(value = "properties") List<String> properties) {
	    return saveCheckedPropertiesTemplate(propertyName, properties);
	}
    
	@RequestMapping(value="/admin/"+ TYPE +"/properties/check_name_property/{property}", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody JSONObject checkNewPropertyValue(@RequestBody String name, @PathVariable("property") String propertyName) {
    	return checkNewPropertyValueTemplate(name, propertyName);
    }
    
    @RequestMapping(value = "/admin/"+ TYPE +"/properties/add/{property}", method = RequestMethod.POST)
	public String addProperty(@RequestParam(value = "new_property") String newProperty,
			@PathVariable("property") String propertyName) {
	    return addPropertyTemplate(newProperty, propertyName);
	}
    
    /**
     * 
     * BLOCK FOR EDIT PROPERTIES INCLUDE INTERNATIONALIZATION TO THEM
     * 
     * **/
    @RequestMapping(value = "/admin/"+ TYPE +"/properties_i/{property}", method = RequestMethod.GET)
	public String pageEditPropertiesI(Model model, @PathVariable("property") String property) {
	    return pageEditPropertiesITemplate(model, property);
	}
    
	@RequestMapping(value = "/admin/"+ TYPE +"/properties_i/{property}", method = RequestMethod.POST,
    		produces="application/json; charset=utf-8")
	public @ResponseBody void saveCheckedPropertiesI(@PathVariable("property") String propertyName,
			@RequestBody List<PropertyInternationalization> properties) {
		saveCheckedPropertiesITemplate(propertyName, properties);
	}
    
	@RequestMapping(value="/admin/"+ TYPE +"/properties_i/check_name_property/{property}", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody JSONObject checkNewPropertyValueI(@RequestBody String name, @PathVariable("property") String propertyName) {
    	return checkNewPropertyValueITemplate(name, propertyName);
    }
    
    @RequestMapping(value = "/admin/"+ TYPE +"/properties_i/add/{property}", method = RequestMethod.POST)
	public String addPropertyI(@RequestParam(value = "new_property") String newProperty,
			@PathVariable("property") String propertyName) {
	    return addPropertyITemplate(newProperty, propertyName);
	}
   
}
