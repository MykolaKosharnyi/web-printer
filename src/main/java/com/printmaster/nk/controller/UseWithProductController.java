package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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

import com.printmaster.nk.beans.ComponetsForController;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.SearchUseWithProducts;
import com.printmaster.nk.model.UseWithProduct;
import com.printmaster.nk.service.UseWithProductService;

@Controller
public class UseWithProductController {
	
	private Logger logger = Logger.getLogger(UseWithProductController.class);
	
	private String directory = "/var/www/localhost/images";
	private String concreteFolder = "use_with_products";
	
	@Autowired
	private LinksForProducts links;

    @Autowired
    PicturesContainer files;
    
    @Autowired
    ComponetsForController componets;
 
    private UseWithProductService useWithProductService;
    
    @Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }
	
	@RequestMapping(value = "/use_with_products", method = RequestMethod.GET)	
    public String allUWP(Model model) {
		
        model.addAttribute("listProducts", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
        SearchUseWithProducts search = new SearchUseWithProducts();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        model.addAttribute("type", "use_with_product");
        logger.info("On '../use_with_products' page.");
        
        logger.info("All characteristic of 'Use with product'.");
		try {
			model.addAttribute("use_with_product", (JSONObject)new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "use_with_products";
    }
	
	@RequestMapping(value = "/use_with_products/{type}", method = RequestMethod.GET)	
    public String typeUWPs(@PathVariable("type") String type, Model model) {
        SearchUseWithProducts search = new SearchUseWithProducts();
        String currentType = null;

        	if(type.equals("ink_for_inkjet")){
        		currentType = "Чернила для струйной печати";
        		logger.info("On the /use_with_product/" + type + " page.");
        		
        	} else if(type.equals("consumables_for_digital_equipment")){
        		currentType = "Расходные материалы для цифрового оборудования";
        		logger.info("On the /use_with_product/" + type + " page.");
        		
        	} else if(type.equals("consumables_for_3D_equipment")){
        		currentType = "Расходные материалы для 3D оборудования";
        		logger.info("On the /use_with_product/" + type + " page.");
        		
        	} else if(type.equals("products_for_maintenance")){
        		currentType = "Товары для обслуживания";
        		logger.info("On the /use_with_product/" + type + " page.");
        		
        	} else if(type.equals("parts_and_accessories")){
        		currentType = "Запчасти и комплектующие";
        		logger.info("On the /use_with_product/" + type + " page.");
        		
        	} else {
        		return "redirect:/";
        	}
        
        String[] a = {currentType};
        search.setTypeProduct(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);        
        model.addAttribute("listProducts", componets.showSimplestArrayOfUseWithProduct(useWithProductService.listSearchUseWithProducts(search)));
        model.addAttribute("type", "use_with_product");
        
        logger.info("All characteristic of 'Use with product'.");
		try {
			model.addAttribute("use_with_product", (JSONObject)new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "use_with_products/" + type ;
    }

    @RequestMapping(value="/use_with_products/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchUWPs(@ModelAttribute(value="search") SearchUseWithProducts search, BindingResult result ){
    	logger.info("On the /use_with_product/search page.");
    	return componets.showSimplestArrayOfUseWithProduct(useWithProductService.listSearchUseWithProducts(search));
    }
	
    @RequestMapping("/use_with_product/{id}")
    public String showUWP(@PathVariable("id") long id, Model model){
    	logger.info("/use_with_product/" + id + " page.");
        model.addAttribute("product", useWithProductService.getUseWithProductById(id));
        model.addAttribute("type", "use_with_product");
        return "use_with_product";
    }
    
	@RequestMapping(value = "/admin/use_with_products", method = RequestMethod.GET)	
    public String listUWPs(Model model){
		model.addAttribute("productType", "use_with_product");
		model.addAttribute("nameProduct", "Имя товара");
		model.addAttribute("titleOfTable", "Список загруженного товара");
        model.addAttribute("listProducts", useWithProductService.listUseWithProducts("id"));
        model.addAttribute("title", "Используется с товаром");
        model.addAttribute("addProduct", "Добавить товар");
        model.addAttribute("productSubType", "none");
        logger.info("/admin/use_with_products page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/use_with_products/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeUWPs(@PathVariable("type") String type, Model model) {
        
		List<UseWithProduct> list = new ArrayList<UseWithProduct>();
		
        if(type.equals("ink_for_inkjet")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts("id")){
        		if(useWithProduct.getTypeProduct().equals("Чернила для струйной печати")){
        			list.add(useWithProduct);
        		}
        	}
        	model.addAttribute("productSubType", "ink_for_inkjet");
        	model.addAttribute("titleOfTable", "Чернила для струйной печати");
            model.addAttribute("listProducts", list);
    		
    	} else if(type.equals("consumables_for_digital_equipment")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts("id")){
        		if(useWithProduct.getTypeProduct().equals("Расходные материалы для цифрового оборудования")){
        			list.add(useWithProduct);
        		}
        	}
        	model.addAttribute("productSubType", "consumables_for_digital_equipment");
        	model.addAttribute("titleOfTable", "Расходные материалы для цифрового оборудования");
        	model.addAttribute("listProducts", list);
             
    	} else if(type.equals("consumables_for_3D_equipment")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts("id")){
        		if(useWithProduct.getTypeProduct().equals("Расходные материалы для 3D оборудования")){
        			list.add(useWithProduct);
        		}
        	}
        	model.addAttribute("productSubType", "consumables_for_3D_equipment");
        	model.addAttribute("titleOfTable", "Расходные материалы для 3D оборудования");
        	model.addAttribute("listProducts", list);
 		
    	} else if(type.equals("products_for_maintenance")){	
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts("id")){
        		if(useWithProduct.getTypeProduct().equals("Товары для обслуживания")){
        			list.add(useWithProduct);
        		}
        	}
        	model.addAttribute("productSubType", "products_for_maintenance");
        	model.addAttribute("titleOfTable", "Товары для обслуживания");
        	model.addAttribute("listProducts", list);

    	} else if(type.equals("parts_and_accessories")){		
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts("id")){
        		if(useWithProduct.getTypeProduct().equals("Запчасти и комплектующие")){
        			list.add(useWithProduct);
        		}
        	}
        	model.addAttribute("productSubType", "parts_and_accessories");
        	model.addAttribute("titleOfTable", "Запчасти и комплектующие");
        	model.addAttribute("listProducts", list);

    	} else {
    		model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженного товара");
            model.addAttribute("listProducts", useWithProductService.listUseWithProducts("id"));
    	}
        
        model.addAttribute("productType", "use_with_product");
        model.addAttribute("nameProduct", "Имя товара");
		model.addAttribute("title", "Используется с товаром");
        model.addAttribute("addProduct", "Добавить товар");
        
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/use_with_product/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<UseWithProduct> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<UseWithProduct> list = new ArrayList<UseWithProduct>();
        if(type.equals("ink_for_inkjet")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts(value)){
        		if(useWithProduct.getTypeProduct().equals("Чернила для струйной печати")){
        			list.add(useWithProduct);
        		}
        	}
    	} else if(type.equals("consumables_for_digital_equipment")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts(value)){
        		if(useWithProduct.getTypeProduct().equals("Расходные материалы для цифрового оборудования")){
        			list.add(useWithProduct);
        		}
        	}
    	} else if(type.equals("consumables_for_3D_equipment")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts(value)){
        		if(useWithProduct.getTypeProduct().equals("Расходные материалы для 3D оборудования")){
        			list.add(useWithProduct);
        		}
        	}
    	} else if(type.equals("products_for_maintenance")){	
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts(value)){
        		if(useWithProduct.getTypeProduct().equals("Товары для обслуживания")){
        			list.add(useWithProduct);
        		}
        	}
    	} else if(type.equals("parts_and_accessories")){		
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts(value)){
        		if(useWithProduct.getTypeProduct().equals("Запчасти и комплектующие")){
        			list.add(useWithProduct);
        		}
        	}
    	} else {
    		list.addAll(useWithProductService.listUseWithProducts(value));
    	}

		return list;
    }
	
	@RequestMapping(value = "/admin/use_with_product/new", method = RequestMethod.GET)
	public String addNewUWP(Model model) {
		files.clear();
		logger.info("/admin/use_with_product/new page.");
		
		 logger.info("All characteristic of use_with_product.");
		 model.addAttribute("product", new UseWithProduct());
		 model.addAttribute("type", "use_with_product");
		 model.addAttribute("productId", 0);
		 
		 try {
			model.addAttribute("use_with_product", (JSONObject)new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
	    return "admin/use_with_product";
	}
	
	@RequestMapping(value = "/admin/use_with_product/copy/{id}", method = RequestMethod.GET)
	public String copyProduct(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info("/admin/use_with_product/copy/" + id + " page.");
		
		 logger.info("Copy all characteristic of use_with_product.");
		 UseWithProduct useWithProduct = useWithProductService.getUseWithProductById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer(useWithProduct.getPathPictures(), directory, concreteFolder, id, files);
		
		 /* set null to id because we must get create new product operation */
	     useWithProduct.setId(null);
		 model.addAttribute("product", useWithProduct);
		 model.addAttribute("type", "use_with_product");
		 model.addAttribute("productId", id);
		 
		try {
			model.addAttribute("use_with_product", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
	    return "admin/use_with_product";
	}
     
	@RequestMapping(value = "/admin/use_with_product/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid UseWithProduct product,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("type", "use_with_product");
				try {
					model.addAttribute("use_with_product", (JSONObject)new JSONParser()
							.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
				} catch (IOException | ParseException e) {}
				
	            return "admin/use_with_product";
	        }
		
            long id = useWithProductService.addUseWithProduct(product);
            logger.info("Create new use_with_product! With id=" + id);

            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            //if it is PAINT type product
            if(product.getTypeProduct().equals("Чернила для струйной печати"))
            	product.setPrise(0);
            
            this.useWithProductService.updateUseWithProduct(product);
            
            files.clear();
		  
		  links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true);
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/use_with_products";
	}
	
	@RequestMapping(value = "/admin/use_with_product/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid UseWithProduct product,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("type", "use_with_product");
				try {
					model.addAttribute("use_with_product", (JSONObject)new JSONParser()
							.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
				} catch (IOException | ParseException e) {}
				
	            return "admin/use_with_product";
	        }
		
            long id = useWithProductService.addUseWithProduct(product);
            logger.info("Create new use_with_product! With id=" + id);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            //if it is PAINT type product
            if(product.getTypeProduct().equals("Чернила для струйной печати"))
            	product.setPrise(0);
            
            this.useWithProductService.updateUseWithProduct(product);
            
            files.clear();
		  
		  links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true);
	    	}
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/use_with_product/edit/" + id;
	}
	
    @RequestMapping("/admin/use_with_product/edit/{id}")
    public String editUWP(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing use_with_product with id=" + id);
    	UseWithProduct undateUWP = useWithProductService.getUseWithProductById(id);
    	
        model.addAttribute("product", undateUWP);
        model.addAttribute("type", "use_with_product");
        
        try {
			model.addAttribute("use_with_product", (JSONObject)new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "admin/use_with_product";
    }
	
	@RequestMapping(value = "/admin/use_with_product/save_update", method = RequestMethod.POST) 
	public String updateSavePrUWP(@ModelAttribute("product") @Valid UseWithProduct product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("type", "use_with_product");
			try {
				model.addAttribute("use_with_product", (JSONObject)new JSONParser()
						.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
			
            return "admin/use_with_product";
        }
		
		logger.info("use_with_product UPDATE with save, id=" + product.getId());
		
		List<String> pathPictures = useWithProductService.getUseWithProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		//if it is PAINT type product
        if(product.getTypeProduct().equals("Чернила для струйной печати"))
        	product.setPrise(0);
		
        useWithProductService.updateUseWithProduct(product);
        logger.info("use_with_product with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide()){
			componets.updateInLeftField(product, true);
	    }
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/use_with_product/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/use_with_product/update", method = RequestMethod.POST) 
	public String updateUseWithProduct(@ModelAttribute("product") @Valid UseWithProduct product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("type", "use_with_product");
			try {
				model.addAttribute("use_with_product", (JSONObject)new JSONParser()
						.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
			
            return "admin/use_with_product";
        }
		
		logger.info("use_with_product UPDATE id=" + product.getId());
		
		List<String> pathPictures = useWithProductService.getUseWithProductById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		//if it is PAINT type product
        if(product.getTypeProduct().equals("Чернила для струйной печати"))
        	product.setPrise(0);
		
        useWithProductService.updateUseWithProduct(product);
        logger.info("use_with_product with id=" + product.getId() + " was UDPATED!");
        
		  files.clear();
		  
		  links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true);
	    	}
		  
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/use_with_products";
	}
	
    @RequestMapping(value="/admin/use_with_product/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {
    	logger.info("upload new picture");
        
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
                logger.info("WRITED new picture to the FILEMETA.");
            } catch (IOException e) {
                logger.error("WRITTING picture to the FILEMETA has a problem: ",e);
            }
             
             logger.info("pictute added to the FILEMETA successful - " + fileMeta.getFileName());
             files.add(fileMeta);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/use_with_product/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	componets.changeOrderPictures(concreteFolder, selectedIds, files); 	
    }
    
    @RequestMapping(value="/admin/use_with_product/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePicture(concreteFolder, namePicture, files);	
    }
    
    @RequestMapping(value="/admin/use_with_product/upload_pictures_update/{id}", method = RequestMethod.POST)
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
        	 
 			UseWithProduct product = useWithProductService.getUseWithProductById(id);
 			product.getPathPictures().add(fileName);
 			useWithProductService.updateUseWithProduct(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/use_with_product/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed use_with_product product");
    	
    	UseWithProduct product = useWithProductService.getUseWithProductById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	useWithProductService.updateUseWithProduct(product);
    }
    
    @RequestMapping(value="/admin/use_with_product/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	UseWithProduct product = useWithProductService.getUseWithProductById(id);
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
				logger.error("Can't update path of the default picture to useWithProduct with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	useWithProductService.updateUseWithProduct(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed useWithProduct product");
    }
    
    @RequestMapping("/admin/use_with_product/remove/{id}")
    public String removeUseWithProduct(@PathVariable("id") long id){
    		logger.info("Start deleting use_with_product from database, id=" + id);
    		try {
    			FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
    			logger.info("deleted all pictures and pictures directory of this use_with_product");
			} catch (IOException e) {
				logger.error("Deleting all pictures from this use_with_product has a problem: ", e);
			}
    		
    		logger.info("Update links to the products in left menu!");
    		
    		componets.updateInLeftField(useWithProductService.getUseWithProductById(id), false);
    		
    		logger.info("DELETE use_with_product with id=" + id + " from database!");
    		useWithProductService.removeUseWithProduct(id);
        
    		links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());
    		
        return "redirect:/admin/use_with_products";
    }  
    
    @RequestMapping(value="/admin/use_with_product/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	UseWithProduct useWithProduct = useWithProductService.getUseWithProductById(id);
    	useWithProduct.setShowOnSite(value);
    	useWithProductService.updateUseWithProduct(useWithProduct);
    	
    	if (useWithProduct.isShowOnSite() && useWithProduct.isShowOnLeftSide()){
    		componets.updateInLeftField(useWithProduct, true);
    	} else {
    		componets.updateInLeftField(useWithProduct, false);
    	}
    	
    	links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/use_with_product/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	UseWithProduct useWithProduct = useWithProductService.getUseWithProductById(id);
    	useWithProduct.setShowOnHomePage(value);
    	useWithProductService.updateUseWithProduct(useWithProduct);
    }
    
    @RequestMapping(value="/admin/use_with_product/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	UseWithProduct useWithProduct = useWithProductService.getUseWithProductById(id);
    	useWithProduct.setShowOnLeftSide(value);
    	useWithProductService.updateUseWithProduct(useWithProduct);
    	
    	if (useWithProduct.isShowOnSite() && useWithProduct.isShowOnLeftSide()){
    		componets.updateInLeftField(useWithProduct, true);
    	} else {
    		componets.updateInLeftField(useWithProduct, false);
    	}
    		
    }
}