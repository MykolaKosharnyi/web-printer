package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.web.servlet.ModelAndView;

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
        return "use_with_product";
    }
    
	@RequestMapping(value = "/admin/use_with_products", method = RequestMethod.GET)	
    public String listUWPs(Model model){
		model.addAttribute("productType", "use_with_product");
		model.addAttribute("nameProduct", "Имя товара");
		model.addAttribute("titleOfTable", "Список загруженного товара");
        model.addAttribute("listProducts", useWithProductService.listUseWithProducts());
        model.addAttribute("title", "Используется с товаром");
        model.addAttribute("addProduct", "Добавить товар");
        logger.info("/admin/use_with_products page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/use_with_products/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeUWPs(@PathVariable("type") String type, Model model) {
        
		List<UseWithProduct> list = new ArrayList<UseWithProduct>();
		
        if(type.equals("ink_for_inkjet")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts()){
        		if(useWithProduct.getTypeProduct().equals("Чернила для струйной печати")){
        			list.add(useWithProduct);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Чернила для струйной печати");
            model.addAttribute("listProducts", list);
    		
    	} else if(type.equals("consumables_for_digital_equipment")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts()){
        		if(useWithProduct.getTypeProduct().equals("Расходные материалы для цифрового оборудования")){
        			list.add(useWithProduct);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Расходные материалы для цифрового оборудования");
        	model.addAttribute("listProducts", list);
             
    	} else if(type.equals("consumables_for_3D_equipment")){
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts()){
        		if(useWithProduct.getTypeProduct().equals("Расходные материалы для 3D оборудования")){
        			list.add(useWithProduct);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Расходные материалы для 3D оборудования");
        	model.addAttribute("listProducts", list);
 		
    	} else if(type.equals("products_for_maintenance")){	
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts()){
        		if(useWithProduct.getTypeProduct().equals("Товары для обслуживания")){
        			list.add(useWithProduct);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Товары для обслуживания");
        	model.addAttribute("listProducts", list);

    	} else if(type.equals("parts_and_accessories")){		
        	
        	for(UseWithProduct useWithProduct : useWithProductService.listUseWithProducts()){
        		if(useWithProduct.getTypeProduct().equals("Запчасти и комплектующие")){
        			list.add(useWithProduct);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Запчасти и комплектующие");
        	model.addAttribute("listProducts", list);

    	} else {
    		model.addAttribute("titleOfTable", "Список загруженного товара");
            model.addAttribute("listProducts", useWithProductService.listUseWithProducts());
    	}
        
        model.addAttribute("productType", "use_with_product");
        model.addAttribute("nameProduct", "Имя товара");
		model.addAttribute("title", "Используется с товаром");
        model.addAttribute("addProduct", "Добавить товар");
        
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/use_with_product/new", method = RequestMethod.GET)
	public String addNewUWP(Model model) {
		files.clear();
		logger.info("/admin/use_with_product/new page.");
		
		 logger.info("All characteristic of use_with_product.");
		 model.addAttribute("product", new UseWithProduct());
		 
		 try {
				model.addAttribute("use_with_product", (JSONObject)new JSONParser()
						.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
	    return "admin/use_with_product";
	}
     
	@RequestMapping(value = "/admin/use_with_product/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute("product") @Valid UseWithProduct product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/use_with_product", "product", product);
	        }
		
            long id = useWithProductService.addUseWithProduct(product);
            logger.info("Create new use_with_product! With id=" + id);

            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new use_with_product directory! With id=" + id);
            } else {
            	logger.error("Don't create new use_with_product directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to use_with_product with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to use_with_product with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the use_with_product with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to use_with_product with id=" + id, e);
				}
			}
			
            this.useWithProductService.updateUseWithProduct(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/use_with_products"); 
		  mav.addObject("listProducts", useWithProductService.listUseWithProducts());
		  
		  links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true);
	    	
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
	@RequestMapping(value = "/admin/use_with_product/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid UseWithProduct product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/use_with_product", "product", product);
	        }
		
            long id = useWithProductService.addUseWithProduct(product);
            logger.info("Create new use_with_product! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new use_with_product directory! With id=" + id);
            } else {
            	logger.error("Don't create new use_with_product directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to use_with_product with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to use_with_product with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the use_with_product with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to use_with_product with id=" + id, e);
				}
			}
			
            this.useWithProductService.updateUseWithProduct(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/use_with_product/edit/" + id); 
		  
		  links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true);
	    	}
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
    @RequestMapping("/admin/use_with_product/edit/{id}")
    public String editUWP(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing use_with_product with id=" + id);
    	files.clear();
    	UseWithProduct undateUWP = useWithProductService.getUseWithProductById(id);
    	
    	FileMeta fm = null;
    	for(String path : undateUWP.getPathPictures()){
    		fm = new FileMeta();
    		fm.setFileName(path);
    		
    		try {
    			File fi = new File(directory + File.separator + 
    					concreteFolder + File.separator + id + File.separator + path);
    			fm.setBytes(Files.readAllBytes(fi.toPath()));
    			logger.info("Load pictures from folder to the FILEMETA.");
			} catch (IOException e) {
				logger.error("Can't load pistures to the FILEMETA", e);
			}
    		files.add(fm);
    	}
        model.addAttribute("product", undateUWP);
        
        try {
			model.addAttribute("use_with_product", (JSONObject)new JSONParser()
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/use_with_product.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "admin/use_with_product";
    }
	
	@RequestMapping(value = "/admin/use_with_product/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSavePrUWP(@ModelAttribute("product") @Valid UseWithProduct product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/use_with_product", "product", product);
        }
		
		logger.info("use_with_product UPDATE with save, id=" + product.getId());
		
		FileUtils.cleanDirectory(new File(directory + File.separator + 
				concreteFolder + File.separator + product.getId()));
		logger.info("Clear directory with old pictures.");
		
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + 
        					concreteFolder + File.separator + product.getId() + File.separator + fm.getFileName()));
					product.getPathPictures().add(fm.getFileName());
					logger.info("Updatepath of the pictures to use_with_product with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to use_with_product with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the use_with_product with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to use_with_product with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
        useWithProductService.updateUseWithProduct(product);
        logger.info("use_with_product with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide()){
			componets.updateInLeftField(product, true);
	    }
		  
		logger.info("Update links to the products in left menu!");
		ModelAndView mav = new ModelAndView("redirect:/admin/use_with_product/edit/" + product.getId());
		return mav;
	}
	
	@RequestMapping(value = "/admin/use_with_product/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateUseWithProduct(@ModelAttribute("product") @Valid UseWithProduct product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/use_with_product", "product", product);
        }
		
		logger.info("use_with_product UPDATE id=" + product.getId());
		
		FileUtils.cleanDirectory(new File(directory + File.separator + 
				concreteFolder + File.separator + product.getId()));
		logger.info("Clear directory with old pictures.");
		
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + 
        					concreteFolder + File.separator + product.getId() + File.separator + fm.getFileName()));
					product.getPathPictures().add(fm.getFileName());
					logger.info("Updatepath of the pictures to use_with_product with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to use_with_product with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the use_with_product with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to use_with_product with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
        useWithProductService.updateUseWithProduct(product);
        logger.info("use_with_product with id=" + product.getId() + " was UDPATED!");
        
		ModelAndView mav = new ModelAndView("redirect:/admin/use_with_products"); 
		  mav.addObject("listProducts", useWithProductService.listUseWithProducts());
		  files.clear();
		  
		  links.createLinksForUseWithProducts(useWithProductService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true);
	    	}
		  
		  logger.info("Update links to the products in left menu!");
	   return mav;
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
    	for(int i = 0; i < selectedIds.size(); i++){
    		for(int k = 0; k < files.size() ; k++){
        		if(files.get(k).getFileName().equals(selectedIds.get(i))){
        			Collections.swap(files.getFiles(), i, k);
        			break;
        		}
        	}
    	} 	
    }
    
    @RequestMapping(value="/admin/use_with_product/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	String name = namePicture.replace(":", ".");
    		Iterator<FileMeta> fmi = files.getFiles().iterator();
    		while(fmi.hasNext()){
        		if(fmi.next().getFileName().equals(name)){
        			fmi.remove();
        			break;
        		}
        	}
    	logger.info("Remove pictore with name=" + namePicture + "from FILEMETA");	
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