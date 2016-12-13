package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.model.SearchDigitalPrinters;
import com.printmaster.nk.service.DigitalPrinterService;
import com.printmaster.nk.service.UseWithProductService;

@Controller
public class PrinterDigitalController {
	
	private Logger logger = Logger.getLogger(PrinterDigitalController.class);
	
	private String directory = "/var/www/localhost/images";
	private String concreteFolder = "digital_printers";
	
	@Autowired
	private LinksForProducts links;
	
	@Autowired
    ComponentsForControllers componets;

    @Autowired
    PicturesContainer files;

    private DigitalPrinterService productService;
    
    @Autowired(required=true)
    @Qualifier(value="digitalPrinterService")
    public void setPrinterService(DigitalPrinterService productService){
        this.productService = productService;
    }
    
    private UseWithProductService useWithProductService;
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }
	
	@RequestMapping(value = "/digital_printers", method = RequestMethod.GET)	
    public String allPrinters(Model model) {
        model.addAttribute("listProducts", componets.makeLightWeightCollectionOfProduct(productService.listShowOnSite()));
        SearchDigitalPrinters search = new SearchDigitalPrinters();
        search.setPrise0(0);
        search.setPrise1(30000);
        model.addAttribute("search", search);
        model.addAttribute("type", "digital_printer");
           
        componets.setJSONtoModelAttribute(model, "digital_printer");
        return "digital_printers";
    }
	
	@RequestMapping(value = "/digital_printers/{type}", method = RequestMethod.GET)
	public String typePrinters(@PathVariable("type") String type, Model model) {
		SearchDigitalPrinters search = new SearchDigitalPrinters();
		String currentType = null;
				
		if (type.equals("full_color_laser_printers")) {
			currentType = "Полноцветное лазерное оборудование";
		} else if (type.equals("monochrome_laser_printers")) {
			currentType = "Монохромное лазерное оборудование";
		} else if (type.equals("full-color_inkjet_printers")) {
			currentType = "Полноцветное струйное оборудование";
		} else {
			return "redirect:/";
		}

		String[] a = { currentType };
		search.setTypePrinter(a);
		search.setPrise0(0);
		search.setPrise1(30000);
		model.addAttribute("search", search);
		model.addAttribute("listProducts", componets.makeLightWeightCollectionOfProduct(productService.listSearchProducts(search)));
		model.addAttribute("type", "digital_printer");
		
		componets.setJSONtoModelAttribute(model, "digital_printer");
		return "digital_printers/" + type;
	}

    @RequestMapping(value="/digital_printers/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> addUser(@ModelAttribute(value="search") SearchDigitalPrinters search, BindingResult result ){
        return componets.makeLightWeightCollectionOfProduct(productService.listSearchProducts(search));
    }
	
    @RequestMapping("/digital_printer/{id}")
    public String showPrinter(@PathVariable("id") long id, Model model){
        
        DigitalPrinter product = productService.getProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", "digital_printer");
        if(product.getIdUseWithProduct()!=null){
        	model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(useWithProductService.getProductsByIds(product.getIdUseWithProduct())));
        } else {
        	model.addAttribute("uwp", null);
        }
        return "digital_printer";
    }
    
	@RequestMapping(value = "/admin/digital_printers", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
		model.addAttribute("titleOfTable", "Список загруженого цыфрового оборудования");
        model.addAttribute("listProducts", productService.listProducts("id"));
        
        model.addAttribute("productType", "digital_printer");
		model.addAttribute("nameProduct", "Имя цыфрового оборудования");
        model.addAttribute("title", "Цыфровое оборудование");
        model.addAttribute("addProduct", "Добавить цыфровое оборудование");
        model.addAttribute("productSubType", "none");
        logger.info("/admin/digital_printers page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/digital_printers/{type}", method = RequestMethod.GET)	
    public String listConcreteType3DPrinters(@PathVariable("type") String type, Model model) {
        
		List<DigitalPrinter> list = new ArrayList<DigitalPrinter>();
        if(type.equals("full_color_laser_printers")){
        	for(DigitalPrinter printer : productService.listProducts("id")){
        		if(printer.getTypePrinter().equals("Полноцветное лазерное оборудование")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "full_color_laser_printers");
        	model.addAttribute("titleOfTable", "Список загруженого полноцветного лазерного оборудования");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/digital_printers/full_color_laser_printers page.");

    	} else if(type.equals("monochrome_laser_printers")){
        	for(DigitalPrinter printer : productService.listProducts("id")){
        		if(printer.getTypePrinter().equals("Монохромное лазерное оборудование")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "monochrome_laser_printers");
        	model.addAttribute("titleOfTable", "Список загруженого монохромного лазерного оборудования");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/digital_printers/monochrome_laser_printers page.");
            
    	} else if(type.equals("full-color_inkjet_printers")){
        	for(DigitalPrinter printer : productService.listProducts("id")){
        		if(printer.getTypePrinter().equals("Полноцветное струйное оборудование")){
        			list.add(printer);
        		}
        	}
        	model.addAttribute("productSubType", "full-color_inkjet_printers");
        	model.addAttribute("titleOfTable", "Список загруженого полноцветного струйного оборудования");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/digital_printers/full-color_inkjet_printers page.");
             		
    	} else {
    		model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных цыфровых принтеров");
            model.addAttribute("listProducts", productService.listProducts("id"));
            logger.info("/admin/digital_printers page.");
    	}
        
        model.addAttribute("productType", "digital_printer");
		model.addAttribute("nameProduct", "Имя цыфрового оборудования");
        model.addAttribute("title", "Цыфровое оборудование");
        model.addAttribute("addProduct", "Добавить цыфровое оборудование");
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/digital_printer/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<DigitalPrinter> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<DigitalPrinter> list = new ArrayList<DigitalPrinter>();
        if(type.equals("full_color_laser_printers")){
        	for(DigitalPrinter printer : productService.listProducts(value)){
        		if(printer.getTypePrinter().equals("Полноцветное лазерное оборудование")){
        			list.add(printer);
        		}
        	}
    	} else if(type.equals("monochrome_laser_printers")){
        	for(DigitalPrinter printer : productService.listProducts(value)){
        		if(printer.getTypePrinter().equals("Монохромное лазерное оборудование")){
        			list.add(printer);
        		}
        	} 
    	} else if(type.equals("full-color_inkjet_printers")){
        	for(DigitalPrinter printer : productService.listProducts(value)){
        		if(printer.getTypePrinter().equals("Полноцветное струйное оборудование")){
        			list.add(printer);
        		}
        	}  		
    	} else {
    		list.addAll(productService.listProducts(value));
    	}

		return list;
    }
	
	@RequestMapping(value = "/admin/digital_printer/new", method = RequestMethod.GET)
	public String addNewPrinter(Model model) {
		files.clear();
		model.addAttribute("product", new DigitalPrinter());
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", "digital_printer");
		model.addAttribute("productId", 0);
		
		componets.setJSONtoModelAttribute(model, "digital_printer");
	    return "admin/digital_printer";
	}
	
	@RequestMapping(value = "/admin/digital_printer/copy/{id}", method = RequestMethod.GET)
	public String copyDigitalEquipment(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info("/admin/digital_printer/copy/" + id + " page.");
		
		 logger.info("Copy all characteristic of digital_printer.");
		 DigitalPrinter digitalPrinter = productService.getProductById(id);
		 
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer(digitalPrinter.getPathPictures(), directory, concreteFolder, id, files);
		
		 /* set null to id because we must get create new product operation */
	    	digitalPrinter.setId(null);
		 model.addAttribute("product", digitalPrinter);
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", "digital_printer");
		 model.addAttribute("productId", id);
		 
		 componets.setJSONtoModelAttribute(model, "digital_printer");
	    return "admin/digital_printer";
	}
     
	@RequestMapping(value = "/admin/digital_printer/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid DigitalPrinter product,
			BindingResult result, Model model) throws IOException{
		
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "digital_printer");
				
				componets.setJSONtoModelAttribute(model, "digital_printer");
	            return "admin/digital_printer";
	        }

            long id = productService.addProduct(product);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
            
            productService.updateProduct(product);
            files.clear();
		
		  links.createLinksForDigitalPrinters(productService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "digital_printer");
	    	
	   return "redirect:/admin/digital_printers";
	}
	
	@RequestMapping(value = "/admin/digital_printer/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid DigitalPrinter product,
			BindingResult result, Model model) throws IOException{
		
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "digital_printer");
				
				componets.setJSONtoModelAttribute(model, "digital_printer");
	            return "admin/digital_printer";
	        }

            long id = productService.addProduct(product);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
            
            productService.updateProduct(product);
            files.clear();
		
		  links.createLinksForDigitalPrinters(productService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "digital_printer");
	    	
	   return "redirect:/admin/digital_printer/edit/" + id;
	}
	
    @RequestMapping("/admin/digital_printer/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	DigitalPrinter undatePrinter = productService.getProductById(id);
    	
        model.addAttribute("product", undatePrinter);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
        model.addAttribute("type", "digital_printer");
        
        componets.setJSONtoModelAttribute(model, "digital_printer");
        return "admin/digital_printer";
    }
	
	@RequestMapping(value = "/admin/digital_printer/update", method = RequestMethod.POST) 
	public String updatePrinter(@ModelAttribute("product") @Valid DigitalPrinter product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "digital_printer");
			
			componets.setJSONtoModelAttribute(model, "digital_printer");
            return "admin/digital_printer";
        }
		
		List<String> pathPictures = productService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);

        productService.updateProduct(product);
        
		files.clear();

		links.createLinksForDigitalPrinters(productService.listShowOnSite());	
		  
		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, "digital_printer");
	    	
	   return "redirect:/admin/digital_printers";
	}
	
	@RequestMapping(value = "/admin/digital_printer/save_update", method = RequestMethod.POST) 
	public String updateSavePrinter(@ModelAttribute("product") @Valid DigitalPrinter product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "digital_printer");
			
			componets.setJSONtoModelAttribute(model, "digital_printer");
            return "admin/digital_printer";
        }
		
		List<String> pathPictures = productService.getProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);

        productService.updateProduct(product);

		  links.createLinksForDigitalPrinters(productService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "digital_printer");
		  
			return "redirect:/admin/digital_printer/edit/" + product.getId();
	}
	
    @RequestMapping(value="/admin/digital_printer/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {

         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String fileName = null;

         while(itr.hasNext()){

             mpf = request.getFile(itr.next()); 

             FileMeta fileMeta = new FileMeta();
     		
     		 fileName = files.size() + new Random().nextInt(1000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 
             fileMeta.setFileName(fileName);
 
             try {
                fileMeta.setBytes(mpf.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
             
             files.add(fileMeta);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/digital_printer/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	componets.changeOrderPictures(concreteFolder, selectedIds, files);
    }
    
    @RequestMapping(value="/admin/digital_printer/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePictureFromPicturesContainer(concreteFolder, namePicture, files);
    }
    
    @RequestMapping(value="/admin/digital_printer/upload_pictures_update/{id}", method = RequestMethod.POST)
    public @ResponseBody String uploadPicturesUpdate(MultipartHttpServletRequest request, @PathVariable("id") long id) {
    	logger.info("upload new picture");
        
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String fileName = null;

         while(itr.hasNext()){
        	mpf = request.getFile(itr.next()); 
     		fileName = new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 

 			try {
 				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(directory + File.separator + concreteFolder
	    				+ File.separator + id + File.separator + fileName));
 			} catch (IOException e) {
 				logger.error("Don't write picture to the folder", e);
 			} 
        	 
 			DigitalPrinter product = productService.getProductById(id);
 			product.getPathPictures().add(fileName);
 			productService.updateProduct(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/digital_printer/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed digital printer product");
    	
    	DigitalPrinter product = productService.getProductById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	productService.updateProduct(product);
    }
    
    @RequestMapping(value="/admin/digital_printer/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	DigitalPrinter product = productService.getProductById(id);
    	product.getPathPictures().remove(name);
    	
    	try {
    		FileUtils.forceDelete(new File(directory + File.separator + concreteFolder+ File.separator + id + File.separator + name));
		} catch (IOException e) {
			logger.error("Can't delete picture from the folder", e);
		} 
    	
    	if(product.getPathPictures().size()==0){
    		File fi = new File(directory + File.separator + "default.jpg");
			try {
				FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to digital printer with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	productService.updateProduct(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed digital printer product");
    }
    
    @RequestMapping("/admin/digital_printer/remove/{id}")
    public String removePrinter(@PathVariable("id") long id){
    	
    		try {
				FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
			} catch (IOException e) {
				e.printStackTrace();
			}

    	componets.updateInLeftField(productService.getProductById(id), false, "digital_printer");

        productService.removeProduct(id);
        
    	links.createLinksForDigitalPrinters(productService.listShowOnSite());
        
        return "redirect:/admin/digital_printers";
    }

    @RequestMapping(value="/admin/digital_printer/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	DigitalPrinter printer = productService.getProductById(id);
    	printer.setShowOnSite(value);
    	productService.updateProduct(printer);
    	links.createLinksForDigitalPrinters(productService.listShowOnSite());
    	
    	if (printer.isShowOnSite() && printer.isShowOnLeftSide()){
    		componets.updateInLeftField(printer, true, "digital_printer");
    	} else {
    		componets.updateInLeftField(printer, false, "digital_printer");
    	}
    }
    
    @RequestMapping(value="/admin/digital_printer/setTop/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	DigitalPrinter printer = productService.getProductById(id);
    	printer.setTop(value);
    	productService.updateProduct(printer);
    }
    
    @RequestMapping(value="/admin/digital_printer/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	DigitalPrinter printer = productService.getProductById(id);
    	printer.setShowOnHomePage(value);
    	productService.updateProduct(printer);
    }
    
    @RequestMapping(value="/admin/digital_printer/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	DigitalPrinter printer = productService.getProductById(id);
    	printer.setShowOnLeftSide(value);
    	productService.updateProduct(printer);
    	
    	if (printer.isShowOnSite() && printer.isShowOnLeftSide()){
    		componets.updateInLeftField(printer, true, "digital_printer");
    	} else {
    		componets.updateInLeftField(printer, false, "digital_printer");
    	}
    }
}

