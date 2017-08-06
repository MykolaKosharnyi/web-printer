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

import com.printmaster.nk.model.entity.Scanner;
import com.printmaster.nk.model.entity.search.SearchScanners;
import com.printmaster.nk.model.service.ScannerService;

@Controller
public class ScannerController extends ProductControllerTemplate<Scanner, SearchScanners>{
	
	private static final String TYPE = SCANNER;
	private static final String CONCRETE_FOLDER = SCANNER + "s";
	private ScannerService productService;
	
	public ScannerController() {
		super(Scanner.class, SearchScanners.class);
	}
	
	private Map<String, String> links = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put("large_format_scanners", "Широкоформатные сканеры");
	    put("3d_scanners", "3D Сканеры");   
	}};
	
	private Map<String, String> parametersOnAdminProductsPage = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put(ATTRIBUTE_TITLE_OF_TABLE, "Список загруженных сканеров");
	    put(ATTRIBUTE_NAME_PRODUCT, "Имя сканера");
	    put(ATTRIBUTE_TITLE, "Сканеры");
	    put(ATTRIBUTE_ADD_PRODUCT, "Добавить сканер");
	}};
	
	private Map<String, ProductPropertiesHelper> properties = new HashMap<String, ProductPropertiesHelper>(){
		private static final long serialVersionUID = 5469471335760507253L;
		{
			put("availability", new ProductPropertiesHelper(
					"Добавление/Изменение наличия для сканеров",
					"Добавление наличие",
					"Есть повторение с раннее введенным наличием!",
					"Добавить наличие",
					"Изменение вывода наличия для сканеров"));
			
			put("previously_used", new ProductPropertiesHelper(
					"Добавление/Изменение состояния оборудования для сканеров",
					"Добавление состояние оборудования",
					"Есть повторение с раннее введенным состоянием оборудования!",
					"Добавить состояние оборудования",
					"Изменение вывода состояний оборудования для сканеров"));
			
			put("type_product", new ProductPropertiesHelper(
					"Добавление/Изменение типа сканеров",
					"Добавление тип сканера",
					"Есть повторение с раннее введенным типом сканера!",
					"Добавить тип сканера",
					"Изменение вывода типов сканеров"));
			
			put("scanning_width", new ProductPropertiesHelper(
					"Добавление/Изменение ширину сканирования для сканеров",
					"Добавление ширину сканирования",
					"Есть повторение с раннее введенной шириной сканирования!",
					"Добавить ширину сканирования",
					"Изменение вывода ширин сканирования для сканеров"));
			
			put("innings", new ProductPropertiesHelper(
					"Добавление/Изменение подачи для сканеров",
					"Добавление подачи",
					"Есть повторение с раннее введенной подачей!",
					"Добавить подачу",
					"Изменение вывода подачи для сканеров"));
			
			put("chromaticity", new ProductPropertiesHelper(
					"Добавление/Изменение цветности для сканеров",
					"Добавление цветности",
					"Есть повторение с раннее введенной цветностью!",
					"Добавить цветность",
					"Изменение вывода цветности для сканеров"));
			
			put("scanning_element", new ProductPropertiesHelper(
					"Добавление/Изменение сканирующих елементов для сканеров",
					"Добавление сканирующего елемента",
					"Есть повторение с раннее введенным сканирующим елементом!",
					"Добавить сканирующий елемент",
					"Изменение вывода сканирующих елементов для сканеров"));
			
			put("light_source", new ProductPropertiesHelper(
					"Добавление/Изменение источника света для сканеров",
					"Добавление источника света",
					"Есть повторение с раннее введенным источником света!",
					"Добавить источник света",
					"Изменение вывода источников света для сканеров"));
			
			put("bit_color_scanning", new ProductPropertiesHelper(
					"Добавление/Изменение разрядности цветного сканирования для сканеров",
					"Добавление разрядности цветного скнирования",
					"Есть повторение с раннее введенной разрядностью цветного сканирования!",
					"Добавить разрядность цветного сканирования",
					"Изменение вывода разрядности цветного сканирования для сканеров"));
			
			put("bit_scanning_grayscale", new ProductPropertiesHelper(
					"Добавление/Изменение разрядности сканирования c оттенком серого для сканеров",
					"Добавление разрядности сканирования с оттенком серого скнирования",
					"Есть повторение с раннее введенной разрядностью сканирования!",
					"Добавить разрядность сканирования с оттенком серого",
					"Изменение вывода разрядности сканирования с оттенком серого для сканеров"));
			
			put("optical_resolution", new ProductPropertiesHelper(
					"Добавление/Изменение оптического разрешения для сканеров",
					"Добавление оптического разрешения",
					"Есть повторение с раннее введенным оптическим разрешением!",
					"Добавить оптическое разрешение",
					"Изменение вывода оптического разрешения для сканеров"));
			
			put("equipment_manufacturer", new ProductPropertiesHelper(
					"Добавление/Изменение производителя оборудования для сканеров",
					"Добавление производителя оборудования",
					"Есть повторение с раннее введенным производителем оборудования!",
					"Добавить производителя оборудования",
					"Изменение вывода производителей оборудованя для сканеров"));
			
			put("connection_interface", new ProductPropertiesHelper(
					"Добавление/Изменение интерфейса подключения для сканеров",
					"Добавление интерфейса подключения",
					"Есть повторение с раннее введенным интерфейсом подключения!",
					"Добавить интерфейс подключения",
					"Изменение вывода интерфейсов подключения для сканеров"));
			
			put("software", new ProductPropertiesHelper(
					"Добавление/Изменение программного обеспечения для сканеров",
					"Добавление программного обеспечения",
					"Есть повторение с раннее введенным программным обеспечением!",
					"Добавить программное обеспечение",
					"Изменение вывода программного обеспечения для сканеров"));
		}
	};
	
    @Autowired(required=true)
    @Qualifier(value="scannerService")
    public void setProductService(ScannerService ps){
        this.productService = ps;
    }
    
    public ScannerService getProductService(){
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
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchScanners search, BindingResult result ){
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
    public @ResponseBody List<Scanner> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {	
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
	public String handleFormUpload(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Scanner product,
			BindingResult result, Model model){
		return handleFormUploadTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_ADD, method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Scanner product,
			BindingResult result, Model model){
		return handleFormUploadSaveTemplate(product, result, model);
	}
	
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_EDIT +"/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        return editProductTemplate(id, model);
    }
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_UPDATE, method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Scanner product,
			BindingResult result, Model model){
		return updateSaveProductTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Scanner product,
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
