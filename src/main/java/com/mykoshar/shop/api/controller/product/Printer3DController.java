package com.mykoshar.shop.api.controller.product;

import static com.mykoshar.shop.api.controller.ConstUsedInContr.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.mykoshar.shop.api.model.entity.Printer3D;
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

import com.mykoshar.shop.api.model.entity.search.SearchPrinters3D;
import com.mykoshar.shop.api.model.service.Printer3DService;

@Controller
public class Printer3DController extends ProductControllerTemplate<Printer3D, SearchPrinters3D>{
	
	private static final String TYPE = PRINTER_3D;	
	private static final String CONCRETE_FOLDER = PRINTER_3D + "s";
	private Printer3DService productService;
	
	public Printer3DController() {
		super(Printer3D.class, SearchPrinters3D.class);
	}
	
	private Map<String, String> links = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
	    put("FDM-extruder", "Экструдные FDM");
	    put("photo_printing_polyjet", "Фото печать Polyjet");
	    put("laser_sintering_LENS", "Лазерного спекания LENS");
	    put("lamination_LOM", "Ламинация LOM");
	    put("stereolithography_SL", "Стереолитография SL");
	    put("laser_sintering_LS", "Лазерное спекание LS");
	    put("powder_bonding_3DP", "Порошкового склеивания 3DP");
	}};
	
	private Map<String, String> parametersOnAdminProductsPage = new HashMap<String, String>(){
		private static final long serialVersionUID = 6020303266276652199L;
	{
		put(ATTRIBUTE_TITLE_OF_TABLE, "Список загруженных 3Д принтеров");
	    put(ATTRIBUTE_NAME_PRODUCT, "Имя 3Д принтера");
	    put(ATTRIBUTE_TITLE, "3Д принтера");
	    put(ATTRIBUTE_ADD_PRODUCT, "Добавить 3Д принтер");
	}};
	
	private Map<String, ProductPropertiesHelper> properties = new HashMap<String, ProductPropertiesHelper>(){
		private static final long serialVersionUID = -4222153587167260117L;
		{
			put("type_printer_3d", new ProductPropertiesHelper(
					"Добавление/Изменение типа 3Д принтеров",
					"Добавление нового типа 3Д принтеров",
					"Есть повторение с раннее введенным типом 3Д принтера!",
					"Добавить тип 3Д принтера",
					"Изменение вывода типов 3Д принтеров"));
			
			put("print_technology", new ProductPropertiesHelper(
					"Добавление/Изменение технологии печати 3Д принтеров",
					"Добавление новой технологии печати для 3Д принтеров",
					"Есть повторение с раннее введенной технологией печати для 3Д принтера!",
					"Добавить пехнологию печати для 3Д принтера",
					"Изменение вывода технологии печати для 3Д принтеров"));
			
			put("chromaticity", new ProductPropertiesHelper(
					"Добавление/Изменение цветовой схемы для 3Д принтеров",
					"Добавление новой цветовой схемы для 3Д принтеров",
					"Есть повторение с раннее введенной цветовой схемой для 3Д принтера!",
					"Добавить цветовую схему для 3Д принтера",
					"Изменение вывода цветовой схемы для 3Д принтеров"));
			
			put("type_of_printhead", new ProductPropertiesHelper(
					"Добавление/Изменение типа печатающей головки для 3Д принтеров",
					"Добавление нового типа печатающей головки для 3Д принтеров",
					"Есть повторение с раннее введенным типом печатающей головкой для 3Д принтера!",
					"Добавить тип печатающей головки для 3Д принтера",
					"Изменение вывода типа печатающей головки для 3Д принтеров"));
			
			put("media", new ProductPropertiesHelper(
					"Добавление/Изменение метериала для печати 3Д принтеров",
					"Добавление нового материала для печати 3Д принтеров",
					"Есть повторение с раннее введенным материалом для печати 3Д принтера!",
					"Добавить материал для печати 3Д принтера",
					"Изменение вывода материала для печати 3Д принтеров"));
			
			put("equipment_manufacturer", new ProductPropertiesHelper(
					"Добавление/Изменение производителя оборудования 3Д принтеров",
					"Добавление нового производителя оборудования 3Д принтеров",
					"Есть повторение с раннее введенным производителем оборудования 3Д принтера!",
					"Добавить производителя оборудования 3Д принтера",
					"Изменение вывода производителей оборудования 3Д принтеров"));
			
			put("interface_connection", new ProductPropertiesHelper(
					"Добавление/Изменение интерфейса подключения 3Д принтеров",
					"Добавление нового интерфейса подключения 3Д принтеров",
					"Есть повторение с раннее введенным интерфейсом подключения 3Д принтера!",
					"Добавить интерфейс подключения 3Д принтера",
					"Изменение вывода интерфейсов подключения 3Д принтеров"));
			
			put("types_of_files", new ProductPropertiesHelper(
					"Добавление/Изменение типов файлов 3Д принтеров",
					"Добавление нового типа файлов 3Д принтеров",
					"Есть повторение с раннее введенным типом файлов 3Д принтера!",
					"Добавить тип файлов для 3Д принтера",
					"Изменение вывода типов файлов 3Д принтеров"));
			
			put("rip", new ProductPropertiesHelper(
					"Добавление/Изменение программное обеспечение 3Д принтеров",
					"Добавление нового программного обеспечения 3Д принтеров",
					"Есть повторение с раннее введенным программным обеспечением 3Д принтера!",
					"Добавить тип программного обеспечения для 3Д принтера",
					"Изменение вывода программного обеспечения 3Д принтеров"));
			
			put("type_extruder", new ProductPropertiesHelper(
					"Добавление/Изменение типа экструдера 3Д принтеров",
					"Добавление нового типа экструдера 3Д принтеров",
					"Есть повторение с раннее введенным типом экструдера 3Д принтера!",
					"Добавить тип экструдера для 3Д принтера",
					"Изменение вывода типов экструдера 3Д принтеров"));
			
			put("extruder_number", new ProductPropertiesHelper(
					"Добавление/Изменение колличества экструдеров 3Д принтеров",
					"Добавление нового колличества экструдеров 3Д принтеров",
					"Есть повторение с раннее введенным колличеством экструдера 3Д принтера!",
					"Добавить колличество экструдеров для 3Д принтера",
					"Изменение вывода колличества экструдеров 3Д принтеров"));
			
			put("airflow_models", new ProductPropertiesHelper(
					"Добавление/Изменение обдува модели 3Д принтеров",
					"Добавление нового обдува модели 3Д принтеров",
					"Есть повторение с раннее введенным обдувом модели 3Д принтера!",
					"Добавить обдув модели для 3Д принтера",
					"Изменение вывода обдува модели 3Д принтеров"));
		
			put("previously_used", new ProductPropertiesHelper(
					"Добавление/Изменение состояния оборудования для принтеров",
					"Добавление нового состояния оборудования",
					"Есть повторение с раннее введенным состоянием оборудования!",
					"Добавить состояние оборудования",
					"Изменение вывода состояния оборудования для принтеров"));
			
			put("availability", new ProductPropertiesHelper(
					"Добавление/Изменение наличия для принтеров",
					"Добавление наличие",
					"Есть повторение с раннее введенным наличием!",
					"Добавить наличие",
					"Изменение вывода наличия для принтеров"));
		}
	};
	
    @Autowired(required=true)
    @Qualifier(value="printer3DService")
    public void setProductService(Printer3DService productService){
        this.productService = productService;
    }
    
    public Printer3DService getProductService() {
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
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchPrinters3D search, BindingResult result ){
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
    public @ResponseBody List<Printer3D> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {	
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
	public String handleFormUpload(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Printer3D product,
			BindingResult result, Model model){
		return handleFormUploadTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_ADD, method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Printer3D product,
			BindingResult result, Model model){
		return handleFormUploadSaveTemplate(product, result, model);
	}
	
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_EDIT +"/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        return editProductTemplate(id, model);
    }
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_UPDATE, method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Printer3D product,
			BindingResult result, Model model){
		return updateSaveProductTemplate(product, result, model);
	}
	
	@RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Printer3D product,
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

