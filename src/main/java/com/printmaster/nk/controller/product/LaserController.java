package com.printmaster.nk.controller.product;

import static com.printmaster.nk.controller.ConstUsedInContr.*;

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

import com.printmaster.nk.model.entity.Laser;
import com.printmaster.nk.model.entity.search.SearchLasers;
import com.printmaster.nk.model.service.LaserService;

@Controller
public class LaserController extends ProductControllerTemplate<Laser, SearchLasers>{
	
	private static final String TYPE = LASER;
	private static final String CONCRETE_FOLDER = LASER + "s";
	private LaserService productService;
	
	public LaserController() {
		super(Laser.class, SearchLasers.class);
	}
	
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
	
	private Map<String, String> parametersOnAdminProductsPage = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put(ATTRIBUTE_TITLE_OF_TABLE, "Список загруженных лазеров");
	    put(ATTRIBUTE_NAME_PRODUCT, "Имя лазера");
	    put(ATTRIBUTE_TITLE, "Лазера");
	    put(ATTRIBUTE_ADD_PRODUCT, "Добавить лазер");
	}};  
	
    private Map<String, ProductPropertiesHelper> properties = new HashMap<String, ProductPropertiesHelper>(){
		private static final long serialVersionUID = 4195782945408346948L;
		{
    		put("availability", new ProductPropertiesHelper(
					"Добавление/Изменение наличия для лазеров",
					"Добавление наличие",
					"Есть повторение с раннее введенным наличием!",
					"Добавить наличие",
					"Изменение вывода наличия для лазеров"));
			
			put("previously_used", new ProductPropertiesHelper(
					"Добавление/Изменение состояний оборудования для лазеров",
					"Добавление состояние оборудования",
					"Есть повторение с раннее введенным состоянием оборудования!",
					"Добавить состояние оборудования",
					"Изменение вывода состояния оборудования для лазеров"));
			
			put("type_of_cooling", new ProductPropertiesHelper(
					"Добавление/Изменение типа охлаждения для лазеров",
					"Добавление типа охлаждения",
					"Есть повторение с раннее введенным охлаждением!",
					"Добавить охлаждение",
					"Изменение вывода охлаждения для лазеров"));
			
			put("type_engine", new ProductPropertiesHelper(
					"Добавление/Изменение типа двигателей для лазеров",
					"Добавление типа двигателей",
					"Есть повторение с раннее введенным типом двигателей!",
					"Добавить тип двигателя",
					"Изменение вывода типов двигателя для лазеров"));
			
			put("type_laser", new ProductPropertiesHelper(
					"Добавление/Изменение типа для лазеров",
					"Добавление типа лазеров",
					"Есть повторение с раннее введенным типом лазеров!",
					"Добавить тип лазеров",
					"Изменение вывода типов лазеров"));
			
			put("equipment_manufacturer", new ProductPropertiesHelper(
					"Добавление/Изменение производителей для лазеров",
					"Добавление производителей лазеров",
					"Есть повторение с раннее введенным производителем лазеров!",
					"Добавить производителя лазеров",
					"Изменение вывода производителей лазеров"));
			
			put("color_separation", new ProductPropertiesHelper(
					"Добавление/Изменение цветоделения для лазеров",
					"Добавление цветоделения",
					"Есть повторение с раннее введенным цветоделением!",
					"Добавить цветоделение",
					"Изменение вывода цветоделения для лазеров"));
			
			put("special_purpose", new ProductPropertiesHelper(
					"Добавление/Изменение целевого назначения для лазеров",
					"Добавление целевого назначения",
					"Есть повторение с раннее введенным целевым назначением!",
					"Добавить целевое назначение",
					"Изменение вывода целевого назначения для лазеров"));
			
			put("type_the_displayed_image", new ProductPropertiesHelper(
					"Добавление/Изменение типа выводимого изображения для лазеров",
					"Добавление типа выводимого изображения",
					"Есть повторение с раннее введенным типом изображения!",
					"Добавить тип выводимого изображения",
					"Изменение вывода типа выводимого изображения для лазеров"));
			
			put("connection_interface", new ProductPropertiesHelper(
					"Добавление/Изменение интерфейса подключения для лазеров",
					"Добавление интерфейса подключения",
					"Есть повторение с раннее введенным интерфейсом подключения!",
					"Добавить интерфейс подключения",
					"Изменение вывода интерфейсов подключения для лазеров"));
			
			put("file_types", new ProductPropertiesHelper(
					"Добавление/Изменение типов файлов для лазеров",
					"Добавление типов файлов",
					"Есть повторение с раннее введенным типом файлов!",
					"Добавить тип файлов",
					"Изменение вывода типов файлов для лазеров"));
			
			put("software", new ProductPropertiesHelper(
					"Добавление/Изменение програмного обеспечения для лазеров",
					"Добавление програмного обеспечения",
					"Есть повторение с раннее введенным програмним обеспечением!",
					"Добавить програмное обеспечение",
					"Изменение вывода програмного обеспеченя для лазеров"));
    	}
    };
  
    @Autowired(required=true)
    @Qualifier(value="laserService")
    public void setProductService(LaserService ps){
        this.productService = ps;
    }
    
    public LaserService getProductService() {
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
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchLasers search, BindingResult result ){
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
    public @ResponseBody List<Laser> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {	
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
	public String handleFormUpload(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Laser product,
			BindingResult result, Model model){
		return handleFormUploadTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_ADD, method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Laser product,
			BindingResult result, Model model){
		return handleFormUploadSaveTemplate(product, result, model);
	}
	
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_EDIT +"/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        return editProductTemplate(id, model);
    }
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_UPDATE, method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Laser product,
			BindingResult result, Model model){
		return updateSaveProductTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Laser product,
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
