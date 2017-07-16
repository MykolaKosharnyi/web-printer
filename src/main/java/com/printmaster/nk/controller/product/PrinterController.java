package com.printmaster.nk.controller.product;

import static com.printmaster.nk.controller.ConstUsedInContr.*;

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
import com.printmaster.nk.model.entity.Comment;
import com.printmaster.nk.model.entity.Printer;
import com.printmaster.nk.model.entity.UseWithProduct;
import com.printmaster.nk.model.entity.search.SearchPrinters;
import com.printmaster.nk.model.service.CommentService;
import com.printmaster.nk.model.service.PrinterService;

@Controller
public class PrinterController extends ProductControllerTemplate<Printer, SearchPrinters>{
	
	private static final String TYPE = "printer";
	private static final String CONCRETE_FOLDER = TYPE + "s";
	private PrinterService productService;
	
	public PrinterController() {
		super(Printer.class, SearchPrinters.class);
	}
	
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
	
	private Map<String, String> parametersOnAdminProductsPage = new HashMap<String, String>() {
		private static final long serialVersionUID = 6020303266276652199L;

		{
			put(ATTRIBUTE_TITLE_OF_TABLE, "Список загруженных принтеров");
			put(ATTRIBUTE_NAME_PRODUCT, "Имя принтера");
			put(ATTRIBUTE_TITLE, "Принтера");
			put(ATTRIBUTE_ADD_PRODUCT, "Добавить принтер");
		}
	};
	
    private Map<String, ProductPropertiesHelper> properties = new HashMap<String, ProductPropertiesHelper>(){
		private static final long serialVersionUID = 2611874319445410016L;
	{
		put("equipment_manufacturer", new ProductPropertiesHelper(
				"Добавление/Изменение производителей для принтеров",
				"Добавление нового производителя",
				"Есть повторение с раннее введенным производителем!",
				"Добавить производителя",
				"Изменение вывода производителей для принтеров"));
		
		put("rip", new ProductPropertiesHelper(
				"Добавление/Изменение программного обеспечения для принтеров",
				"Добавление нового ПО",
				"Есть повторение с раннее введенным ПО!",
				"Добавить ПО",
				"Изменение вывода ПО для принтеров"));
		
		put("manufacturer_printhead", new ProductPropertiesHelper(
				"Добавление/Изменение производителей печатающей головки для принтеров",
				"Добавление новых производителей печатающей головки",
				"Есть повторение с раннее введенным производителем печатающей головки!",
				"Добавить производителя печатающей головки",
				"Изменение вывода производителей печатающей головки для принтеров"));
		
		put("printing_extension", new ProductPropertiesHelper(
				"Добавление/Изменение расширения печати для принтеров",
				"Добавление новых расширений печати",
				"Есть повторение с раннее введенным расширением печати!",
				"Добавить расширение печати",
				"Изменение вывода раширений печати для принтеров"));
		
		put("weight_print_mm", new ProductPropertiesHelper(
				"Добавление/Изменение ширины печати для принтеров",
				"Добавление новой ширины печати",
				"Есть повторение с раннее введенной шириной печати!",
				"Добавить ширину печати",
				"Изменение вывода ширины печати для принтеров"));
		
		put("chromaticity", new ProductPropertiesHelper(
				"Добавление/Изменение цветовой схемы для принтеров",
				"Добавление новой цветовой схемы",
				"Есть повторение с раннее введенной цветовой схемой!",
				"Добавить цветовую схему",
				"Изменение вывода цветовой схемы для принтеров"));
		
		put("size_drops", new ProductPropertiesHelper(
				"Добавление/Изменение размера капли для принтеров",
				"Добавление нового размера капли",
				"Есть повторение с раннее введенным размером капли!",
				"Добавить размер капли",
				"Изменение вывода размера капли для принтеров"));
		
		put("resolution", new ProductPropertiesHelper(
				"Добавление/Изменение разрешения скорости печати для принтеров",
				"Добавление нового разрешения скорости печати",
				"Есть повторение с раннее введенным разрешением скорости печати!",
				"Добавить разрешение скорости печати",
				"Изменение вывода разрешения скорости печати для принтеров"));
		
		put("interface_connection", new ProductPropertiesHelper(
				"Добавление/Изменение интерфейсов подключения для принтеров",
				"Добавление нового интерфейса подключения",
				"Есть повторение с раннее введенным интерфейсом подключения!",
				"Добавить интерфейс подключения",
				"Изменение вывода интерфейсов подключения для принтеров"));
		
		put("print_resolution", new ProductPropertiesHelper(
				"Добавление/Изменение разрешения печати для принтеров",
				"Добавление нового разрешения печати",
				"Есть повторение с раннее введенным разрешением печати!",
				"Добавить разрешение печати",
				"Изменение вывода разрешения печати для принтеров"));
		
		
		/**********************************************************************/
		put("compatible_ink", new ProductPropertiesHelper(
				"Добавление/Изменение cовместимых чернил для принтеров",
				"Добавление новых совместимых чернил",
				"Есть повторение с раннее введенными совместимыми чернилами!",
				"Добавить чернила",
				"Изменение вывода совместимых чернил для принтеров"));
		
		put("feeds", new ProductPropertiesHelper(
				"Добавление/Изменение подачи материала для принтеров",
				"Добавление новой подачи материала",
				"Есть повторение с раннее введенной подачей материала!",
				"Добавить подачу материала",
				"Изменение вывода подачи материала для принтеров"));
		
		put("type_drops", new ProductPropertiesHelper(
				"Добавление/Изменение типа капли для принтеров",
				"Добавление нового типа капли",
				"Есть повторение с раннее введенным типом капли!",
				"Добавить тип капли",
				"Изменение вывода типа капли для принтеров"));
		
		put("previously_used", new ProductPropertiesHelper(
				"Добавление/Изменение состояния оборудования для принтеров",
				"Добавление нового состояния оборудования",
				"Есть повторение с раннее введенным состоянием оборудования!",
				"Добавить состояние оборудования",
				"Изменение вывода состояния оборудования для принтеров"));
		
		put("type_printer", new ProductPropertiesHelper(
				"Добавление/Изменение типа принтеров для принтеров",
				"Добавление нового типа принтеров",
				"Есть повторение с раннее введенным типом принтеров!",
				"Добавить тип принтеров",
				"Изменение вывода типов принтеров для принтеров"));
		
		put("type_print", new ProductPropertiesHelper(
				"Добавление/Изменение типа печати для принтеров",
				"Добавление нового типа печати",
				"Есть повторение с раннее введенным типом печати!",
				"Добавить тип печати",
				"Изменение вывода типов печати для принтеров"));
		
		put("delivery", new ProductPropertiesHelper(
				"Добавление/Изменение доставки для принтеров",
				"Добавление новой доставки",
				"Есть повторение с раннее введенной доставкой!",
				"Добавить доставку",
				"Изменение вывода доставки для принтеров"));
		
		put("availability", new ProductPropertiesHelper(
				"Добавление/Изменение наличия для принтеров",
				"Добавление наличие",
				"Есть повторение с раннее введенным наличием!",
				"Добавить наличие",
				"Изменение вывода наличия для принтеров"));
	}};
	
	@Autowired(required=true)
    @Qualifier(value="printerService")
    public void setProductService(PrinterService ps){
        this.productService = ps;
    }
    
	public PrinterService getProductService() {
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
	
	
	
	
	
	
	
	
	
	private Logger logger = Logger.getLogger(this.getClass());
    
    @Autowired
    private ComponentsForControllers componets;

    @Autowired
	private CommentService commentService;
	

	
	
	
	
	
	
	
	
	@RequestMapping(value = "/"+ TYPE +"s", method = RequestMethod.GET)	
    public String allProducts(Model model) {
		return allProductsTemplate(model);
    }
	
	@RequestMapping(value = "/"+ TYPE +"s/{subType}", method = RequestMethod.GET)	
    public String typeProducts(@PathVariable("subType") String subType, Model model) {
		return allProductsWithTypeTemplate(subType, model);
    }
	
	@RequestMapping(value="/"+ TYPE +"s/"+ PATH_SEARCH, method=RequestMethod.POST, produces=JSON_PRODUCES)
    public @ResponseBody ArrayList<JSONObject> showSearchProducts(@ModelAttribute(value="search") SearchPrinters search, BindingResult result ){
    	return showSearchProductsTemplate(search, result);
    }
	
    @RequestMapping("/"+ TYPE +"/{id}")
    public String showProduct(@PathVariable("id") long id, Model model){
    	logger.info(String.format("On /%s/%d page.", TYPE, id));
        
        Printer product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", TYPE);
        model.addAttribute("comments", commentService.getAllForProduct(TYPE, id));
        model.addAttribute("addComment", new Comment());
        
        componets.setJSONtoModelAttribute(model, getTYPE());
        
        if(product.getIdUseWithProduct()!=null || product.getCompatibleInk()!=null){
	        Set<UseWithProduct> useWithThisProduct = new LinkedHashSet<UseWithProduct>();
	        
	        //get checked USE WITH PRODUCT from admin page
	        if(product.getIdUseWithProduct()!=null){
	        	useWithThisProduct.addAll(getUseWithProductService().getProductsByIds(product.getIdUseWithProduct()));
	        }
	        
	        //get PAINT to product by COMPATIBLE INK in printer
	        if(product.getCompatibleInk()!=null){
	        	useWithThisProduct.addAll(getUseWithProductService().getPrintersByTypeInk(product.getCompatibleInk()));
	        }
	  
	        model.addAttribute("uwp", useWithThisProduct);
        } else {
        	model.addAttribute("uwp", null);
        }

        return TYPE;
    }
    
    @RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"s", method = RequestMethod.GET)	
    public String adminListProducts(Model model) {
    	return adminListProductsTemplate(model);
    }
    
    @RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"s/{type}", method = RequestMethod.GET)	
    public String adminListConcreteTypeProducts(@PathVariable("type") String type, Model model) {
    	return adminListConcreteTypeProductsTemplate(type, model);
    }
    
    @RequestMapping(value="/"+PATH_ADMIN+"/"+TYPE+"/{type}/"+PATH_SORTING+"/{value}",method=RequestMethod.POST,consumes=JSON_CONSUMES,headers=JSON_HEADERS)
    public @ResponseBody List<Printer> sortingProductsInAdmin(@PathVariable("type") String type, @PathVariable("value") String value) {	
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
	public String handleFormUpload(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Printer product,
			BindingResult result, Model model){
		return handleFormUploadTemplate(product, result, model);
	}
	
    @RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_ADD, method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Printer product,
			BindingResult result, Model model){
		return handleFormUploadSaveTemplate(product, result, model);
	}
	
    @RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_EDIT +"/{id}")
    public String editProduct(@PathVariable("id") long id, Model model){
        return editProductTemplate(id, model);
    }
	
    @RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_SAVE_UPDATE, method = RequestMethod.POST) 
	public String updateSaveProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Printer product,
			BindingResult result, Model model){
		return updateSaveProductTemplate(product, result, model);
	}
	
    @RequestMapping(value = "/" + PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String updateProduct(@ModelAttribute(MODEL_ATTRIBUTE_PRODUCT) @Valid Printer product,
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
