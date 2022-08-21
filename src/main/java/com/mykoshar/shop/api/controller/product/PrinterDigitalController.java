package com.mykoshar.shop.api.controller.product;

import static com.mykoshar.shop.api.controller.ConstUsedInContr.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.mykoshar.shop.api.model.entity.DigitalPrinter;
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

import com.mykoshar.shop.api.model.entity.search.SearchDigitalPrinters;
import com.mykoshar.shop.api.model.service.DigitalPrinterService;

@Controller
public class PrinterDigitalController extends ProductControllerTemplate<DigitalPrinter, SearchDigitalPrinters>{
	
	private static final String TYPE = DIGITAL_PRINTER;
	private static final String CONCRETE_FOLDER = DIGITAL_PRINTER + "s";
	private DigitalPrinterService productService;
	
	public PrinterDigitalController() {
		super(DigitalPrinter.class, SearchDigitalPrinters.class);
	}
	
	private Map<String, String> links = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put("full_color_laser_printers", "Полноцветное лазерное оборудование");
	    put("monochrome_laser_printers", "Монохромное лазерное оборудование");
	    put("full-color_inkjet_printers", "Полноцветное струйное оборудование");
	}};
	
	private Map<String, String> parametersOnAdminProductsPage = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put(ATTRIBUTE_TITLE_OF_TABLE, "Список загруженого цыфрового оборудования");
	    put(ATTRIBUTE_NAME_PRODUCT, "Имя цыфрового оборудования");
	    put(ATTRIBUTE_TITLE, "Цыфровое оборудование");
	    put(ATTRIBUTE_ADD_PRODUCT, "Добавить цыфровое оборудование");
	}};
    
	private Map<String, ProductPropertiesHelper> properties = new HashMap<String, ProductPropertiesHelper>(){
		private static final long serialVersionUID = -4581974865614058837L;
		{
			put("interfaces", new ProductPropertiesHelper(
					"Добавление/Изменение интерфейсов подключения для цифрового оборудования",
					"Добавление интерфейс подключения",
					"Есть повторение с раннее введенным интерфейсом подключения!",
					"Добавить интерфейс подключения",
					"Изменение вывода интерфейсов подключения для цифрового оборудования"));
			
			put("maximum_format", new ProductPropertiesHelper(
					"Добавление/Изменение максимального формата для цифрового оборудования",
					"Добавление формата",
					"Есть повторение с раннее введенным форматом!",
					"Добавить формат",
					"Изменение вывода максимального формата для цифрового оборудования"));
			
			put("scanner_resolution", new ProductPropertiesHelper(
					"Добавление/Изменение разрешения сканера для цифрового оборудования",
					"Добавление разрешение сканера",
					"Есть повторение с раннее введенным разрешением сканера!",
					"Добавить разрешение сканера",
					"Изменение вывода разрешения сканера для цифрового оборудования"));
			
			put("maximum_resolution_copier_bw", new ProductPropertiesHelper(
					"Добавление/Изменение максимального разрешения копира для цифрового оборудования",
					"Добавление разрешение копира",
					"Есть повторение с раннее введенным разрешением копира!",
					"Добавить разрешение копира",
					"Изменение вывода разрешения копира для цифрового оборудования"));
			
			put("support", new ProductPropertiesHelper(
					"Добавление/Изменение поддержки для цифрового оборудования",
					"Добавление поддержки",
					"Есть повторение с раннее введенной поддержкой!",
					"Добавить поддержку",
					"Изменение вывода поддержки для цифрового оборудования"));
			
			put("os_support", new ProductPropertiesHelper(
					"Добавление/Изменение поддержки ОС для цифрового оборудования",
					"Добавление поддержки ОС",
					"Есть повторение с раннее введенной поддержкой ОС!",
					"Добавить поддержку ОС",
					"Изменение вывода поддержки ОС для цифрового оборудования"));
			
			put("availability", new ProductPropertiesHelper(
					"Добавление/Изменение наличия для цифрового оборудования",
					"Добавление наличие",
					"Есть повторение с раннее введенным наличием!",
					"Добавить наличие",
					"Изменение вывода наличия для цифрового оборудования"));
			
			put("previously_used", new ProductPropertiesHelper(
					"Добавление/Изменение состояний оборудования для цифрового оборудования",
					"Добавление состояние оборудования",
					"Есть повторение с раннее введенным состоянием оборудования!",
					"Добавить состояние оборудования",
					"Изменение вывода состояния оборудования для цифрового оборудоания"));
			
			put("type_printer", new ProductPropertiesHelper(
					"Добавление/Изменение типов цифрового оборудования",
					"Добавление типа цифрового оборудования",
					"Есть повторение с раннее введенным типом оборудования!",
					"Добавить тип цифрового оборудования",
					"Изменение вывода типа цифрового оборудоания"));
			
			put("device", new ProductPropertiesHelper(
					"Добавление/Изменение устройства цифрового оборудования",
					"Добавление устройства цифрового оборудования",
					"Есть повторение с раннее введенным устройством!",
					"Добавить устройство",
					"Изменение вывода устройств для цифрового оборудоания"));
			
			put("type_of_printing", new ProductPropertiesHelper(
					"Добавление/Изменение типа печати цифрового оборудования",
					"Добавление типа печати",
					"Есть повторение с раннее введенным типом печати!",
					"Добавить тип печати",
					"Изменение вывода типа печати для цифрового оборудоания"));
			
			put("print_technology", new ProductPropertiesHelper(
					"Добавление/Изменение технологии печати цифрового оборудования",
					"Добавление технологии печати",
					"Есть повторение с раннее введенной технологией печати!",
					"Добавить технологию печати",
					"Изменение вывода технологии печати для цифрового оборудоания"));
			
			put("accommodation", new ProductPropertiesHelper(
					"Добавление/Изменение размещения цифрового оборудования",
					"Добавление размещения",
					"Есть повторение с раннее введенным размещением!",
					"Добавить размещение",
					"Изменение вывода размещения для цифрового оборудоания"));
			
			put("application_area", new ProductPropertiesHelper(
					"Добавление/Изменение области применения цифрового оборудования",
					"Добавление области применения",
					"Есть повторение с раннее введенной областью применения!",
					"Добавить область применения",
					"Изменение вывода области применения для цифрового оборудоания"));
			
			put("yn", new ProductPropertiesHelper(
					"Добавление/Изменение есть/нет цифрового оборудования",
					"Добавление",
					"Есть повторение с раннее введенным значением!",
					"Добавить есть/нет",
					"Изменение вывода есть/нет для цифрового оборудоания"));
			
			put("scanner_type", new ProductPropertiesHelper(
					"Добавление/Изменение типа сканера цифрового оборудования",
					"Добавление типа сканера",
					"Есть повторение с раннее введенным типом сканера!",
					"Добавить тип сканера",
					"Изменение вывода типа сканера для цифрового оборудоания"));
			
			put("printing_on", new ProductPropertiesHelper(
					"Добавление/Изменение 'печати на' для цифрового оборудования",
					"Добавление 'печати на'",
					"Есть повторение с раннее введенным 'печати на'!",
					"Добавить 'печати на'",
					"Изменение вывода 'печати на' для цифрового оборудоания"));
			
			put("display_information", new ProductPropertiesHelper(
					"Добавление/Изменение отображение информации для цифрового оборудования",
					"Добавление отображения информации",
					"Есть повторение с раннее введенным отображением информации!",
					"Добавить отображение информации",
					"Изменение вывода отображения информации для цифрового оборудоания"));
			
		}
	};
	
    @Autowired(required=true)
    @Qualifier(value="digitalPrinterService")
    public void setProductService(DigitalPrinterService productService){
        this.productService = productService;
    }
    
    public DigitalPrinterService getProductService() {
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
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchDigitalPrinters search, BindingResult result ){
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
    public @ResponseBody List<DigitalPrinter> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {	
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
	public String handleFormUpload(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid DigitalPrinter product,
			BindingResult result, Model model){
		return handleFormUploadTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_ADD, method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid DigitalPrinter product,
			BindingResult result, Model model){
		return handleFormUploadSaveTemplate(product, result, model);
	}
	
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_EDIT +"/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        return editProductTemplate(id, model);
    }
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_UPDATE, method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid DigitalPrinter product,
			BindingResult result, Model model){
		return updateSaveProductTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid DigitalPrinter product,
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

