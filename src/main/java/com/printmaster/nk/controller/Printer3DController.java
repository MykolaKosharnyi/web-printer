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

import com.printmaster.nk.beans.ComponetsForController;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.modelwork.SearchPrinters3D;
import com.printmaster.nk.service.Printer3DService;
import com.printmaster.nk.service.UseWithProductService;

@Controller
public class Printer3DController {
	
	private Logger logger = Logger.getLogger(Printer3DController.class);
	private String directory = "/var/www/localhost/images";

	private String concreteFolder = "3d_printers";
	
	@Autowired
	private LinksForProducts links;
	
	@Autowired
    ComponetsForController componets;
	
    private Printer3DService productService;

    @Autowired
    PicturesContainer files;
    
    @Autowired(required=true)
    @Qualifier(value="printer3DService")
    public void setPrinter3DService(Printer3DService productService){
        this.productService = productService;
    }
    
    private UseWithProductService useWithProductService;
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }

	@RequestMapping(value = "/3d_printers", method = RequestMethod.GET)	
    public String allPrinters(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfPrinter3D(productService.listShowOnSite()));
        SearchPrinters3D search = new SearchPrinters3D();
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        model.addAttribute("type", "3d_printer");
        
        logger.info("All characteristic of 3d printer.");
		try {
			model.addAttribute("printer", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "3d_printers";
    }
	
	@RequestMapping(value = "/3d_printers/{type}", method = RequestMethod.GET)
	public String typePrinters(@PathVariable("type") String type, Model model) {
		SearchPrinters3D search = new SearchPrinters3D();
		String currentType = null;
		
		if (type.equals("FDM-extruder")) {
			currentType = "Экструдные FDM";
		} else if (type.equals("photo_printing_polyjet")) {
			currentType = "Фото печать Polyjet";
		} else if (type.equals("laser_sintering_LENS")) {
			currentType = "Лазерного спекания LENS";
		} else if (type.equals("lamination_LOM")) {
			currentType = "Ламинация LOM";
		} else if (type.equals("stereolithography_SL")) {
			currentType = "Стереолитография SL";
		} else if (type.equals("laser_sintering_LS")) {
			currentType = "Лазерное спекание LS";
		} else if (type.equals("powder_bonding_3DP")) {
			currentType = "Порошкового склеивания 3DP";
		} else {
			return "redirect:/";
		}

		String[] a = { currentType };
		search.setTypePrinter3D(a);
		search.setPrise0(0);
		search.setPrise1(100000);
		model.addAttribute("search", search);
		model.addAttribute("listProducts", componets.showSimplestArrayOfPrinter3D(productService.listSearchPrinters3D(search)));
		model.addAttribute("type", "3d_printer");
		
		logger.info("All characteristic of 3d printer.");
		try {
			model.addAttribute("printer", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
		return "3d_printers/" + type;
	}

    @RequestMapping(value="/3d_printers/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> addUser(@ModelAttribute(value="search") SearchPrinters3D search, BindingResult result ){
        return componets.showSimplestArrayOfPrinter3D(productService.listSearchPrinters3D(search));
    }
	
    @RequestMapping("/3d_printer/{id}")
    public String showPrinter(@PathVariable("id") long id, Model model){
        
        Printer3D product = productService.getPrinter3DById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", "3d_printer");
        if(product.getIdUseWithProduct()!=null){
        	model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(useWithProductService.getUseWithProductsByIds(product.getIdUseWithProduct())));
        } else {
        	model.addAttribute("uwp", null);
        }
        return "3d_printer";
    }
    
	@RequestMapping(value = "/admin/3d_printers", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных 3D принтеров");
        model.addAttribute("listProducts", productService.listPrinters3D("id"));
        
        model.addAttribute("productType", "3d_printer");
		model.addAttribute("nameProduct", "Имя 3D принтера");
        model.addAttribute("title", "3D Принтеры");
        model.addAttribute("addProduct", "Добавить 3D принтер");
        model.addAttribute("productSubType", "none");
        logger.info("/admin/3d_printers page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/3d_printers/{type}", method = RequestMethod.GET)	
    public String listConcreteType3DPrinters(@PathVariable("type") String type, Model model) {
        
		List<Printer3D> list = new ArrayList<Printer3D>();
        if(type.equals("FDM-extruder")){
        	for(Printer3D printer3d : productService.listPrinters3D("id")){
        		if(printer3d.getTypePrinter3D().equals("Экструдные FDM")){
        			list.add(printer3d);
        		}
        	}
        	model.addAttribute("productSubType", "FDM-extruder");
        	model.addAttribute("titleOfTable", "Список загруженных экструдных FDM принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/FDM-extruder page.");

    	} else if(type.equals("photo_printing_polyjet")){
        	for(Printer3D printer3d : productService.listPrinters3D("id")){
        		if(printer3d.getTypePrinter3D().equals("Фото печать Polyjet")){
        			list.add(printer3d);
        		}
        	}
        	model.addAttribute("productSubType", "photo_printing_polyjet");
        	model.addAttribute("titleOfTable", "Фото печать Polyjet, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/photo_printing_polyjet page.");
 
    	} else if(type.equals("laser_sintering_LENS")){
        	for(Printer3D printer3d : productService.listPrinters3D("id")){
        		if(printer3d.getTypePrinter3D().equals("Лазерного спекания LENS")){
        			list.add(printer3d);
        		}
        	}
        	model.addAttribute("productSubType", "laser_sintering_LENS");
        	model.addAttribute("titleOfTable", "Лазерного спекания LENS, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/laser_sintering_LENS page.");
		
    	} else if(type.equals("lamination_LOM")){	
        	for(Printer3D printer3d : productService.listPrinters3D("id")){
        		if(printer3d.getTypePrinter3D().equals("Ламинация LOM")){
        			list.add(printer3d);
        		}
        	}
        	model.addAttribute("productSubType", "lamination_LOM");
        	model.addAttribute("titleOfTable", "Ламинация LOM, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/lamination_LOM page.");

    	} else if(type.equals("stereolithography_SL")){		
        	for(Printer3D printer3d : productService.listPrinters3D("id")){
        		if(printer3d.getTypePrinter3D().equals("Стереолитография SL")){
        			list.add(printer3d);
        		}
        	}
        	model.addAttribute("productSubType", "stereolithography_SL");
        	model.addAttribute("titleOfTable", "Стереолитография SL, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/stereolithography_SL page.");

    	} else if(type.equals("laser_sintering_LS")){    		
        	for(Printer3D printer3d : productService.listPrinters3D("id")){
        		if(printer3d.getTypePrinter3D().equals("Лазерное спекание LS")){
        			list.add(printer3d);
        		}
        	}
        	model.addAttribute("productSubType", "laser_sintering_LS");
        	model.addAttribute("titleOfTable", "Лазерное спекание LS, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/laser_sintering_LS page.");

    	} else if(type.equals("powder_bonding_3DP")){  		
        	for(Printer3D printer3d : productService.listPrinters3D("id")){
        		if(printer3d.getTypePrinter3D().equals("Порошкового склеивания 3DP")){
        			list.add(printer3d);
        		}
        	}
        	model.addAttribute("productSubType", "powder_bonding_3DP");
        	model.addAttribute("titleOfTable", "Порошкового склеивания 3DP, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/powder_bonding_3DP page.");
    		
    	} else {
    		model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных 3D принтеров");
            model.addAttribute("listProducts", productService.listPrinters3D("id"));
            logger.info("/admin/3d_printers page.");
    	}
        model.addAttribute("productType", "3d_printer");
		model.addAttribute("nameProduct", "Имя 3D принтера");
        model.addAttribute("title", "3D Принтеры");
        model.addAttribute("addProduct", "Добавить 3D принтер");
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/3d_printer/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Printer3D> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<Printer3D> list = new ArrayList<Printer3D>();
        if(type.equals("FDM-extruder")){
        	for(Printer3D printer3d : productService.listPrinters3D(value)){
        		if(printer3d.getTypePrinter3D().equals("Экструдные FDM")){
        			list.add(printer3d);
        		}
        	}
    	} else if(type.equals("photo_printing_polyjet")){
        	for(Printer3D printer3d : productService.listPrinters3D(value)){
        		if(printer3d.getTypePrinter3D().equals("Фото печать Polyjet")){
        			list.add(printer3d);
        		}
        	}
    	} else if(type.equals("laser_sintering_LENS")){
        	for(Printer3D printer3d : productService.listPrinters3D(value)){
        		if(printer3d.getTypePrinter3D().equals("Лазерного спекания LENS")){
        			list.add(printer3d);
        		}
        	}
    	} else if(type.equals("lamination_LOM")){	
        	for(Printer3D printer3d : productService.listPrinters3D(value)){
        		if(printer3d.getTypePrinter3D().equals("Ламинация LOM")){
        			list.add(printer3d);
        		}
        	}
    	} else if(type.equals("stereolithography_SL")){		
        	for(Printer3D printer3d : productService.listPrinters3D(value)){
        		if(printer3d.getTypePrinter3D().equals("Стереолитография SL")){
        			list.add(printer3d);
        		}
        	}
    	} else if(type.equals("laser_sintering_LS")){    		
        	for(Printer3D printer3d : productService.listPrinters3D(value)){
        		if(printer3d.getTypePrinter3D().equals("Лазерное спекание LS")){
        			list.add(printer3d);
        		}
        	}
    	} else if(type.equals("powder_bonding_3DP")){  		
        	for(Printer3D printer3d : productService.listPrinters3D(value)){
        		if(printer3d.getTypePrinter3D().equals("Порошкового склеивания 3DP")){
        			list.add(printer3d);
        		}
        	}
    	} else {
    		list.addAll(productService.listPrinters3D(value));
    	}

		return list;
    }
	
	@RequestMapping(value = "/admin/3d_printer/new", method = RequestMethod.GET)
	public String addNewPrinter(Model model) {
		files.clear();
		
		model.addAttribute("product", new Printer3D());
		logger.info("All characteristic of 3d printer.");
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", "3d_printer");
		model.addAttribute("productId", 0);
		try {
			model.addAttribute("printer", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
	    return "admin/3d_printer";
	}
	
	@RequestMapping(value = "/admin/3d_printer/copy/{id}", method = RequestMethod.GET)
	public String copyProduct(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info("/admin/3d_printer/copy/" + id + " page.");
		
		 logger.info("Copy all characteristic of 3d_printer.");
		 Printer3D printer3D = productService.getPrinter3DById(id);
		
		 
		 /* copy pictures to buffer */
		 FileMeta fm = null;
	    	for(String path : printer3D.getPathPictures()){
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
		
		 /* set null to id because we must get create new product operation */
	     printer3D.setId(null);
		 model.addAttribute("product", printer3D);
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", "3d_printer");
		 model.addAttribute("productId", id);
		 
		try {
			model.addAttribute("printer", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
	    return "admin/3d_printer";
	}
     
	@RequestMapping(value = "/admin/3d_printer/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid Printer3D product,
			BindingResult result, Model model) throws IOException{
		
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "3d_printer");
				try {
					model.addAttribute("printer", (JSONObject)new JSONParser().
							parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
				} catch (IOException | ParseException e) {}
	            return "admin/3d_printer";
	        }

            long id = productService.addPrinter3D(product);
  
            new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir();
            
    		if (files != null && files.size()!=0) {
    			for (FileMeta fm : files.getFiles()) {
    				try {
    					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(directory + File.separator + concreteFolder
    				+ File.separator + id + File.separator + fm.getFileName()));
    					product.getPathPictures().add(fm.getFileName());
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    			}
    		} else {
        		try {
        			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
        			product.getPathPictures().add("default.jpg");
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
            productService.updatePrinter3D(product);
            files.clear();
		
		  links.createLinksFor3DPrinters(productService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "3d_printer");
	    	}
	   return "redirect:/admin/3d_printers";
	}
	
	@RequestMapping(value = "/admin/3d_printer/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Printer3D product,
			BindingResult result, Model model) throws IOException{
			
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "3d_printer");
				try {
					model.addAttribute("printer", (JSONObject)new JSONParser().
							parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
				} catch (IOException | ParseException e) {}
	            return "admin/3d_printer";
	        }

            long id = productService.addPrinter3D(product);
  
            new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir();
            
    		if (files != null && files.size()!=0) {
    			for (FileMeta fm : files.getFiles()) {
    				try {
    					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(directory + File.separator + concreteFolder
    				+ File.separator + id + File.separator + fm.getFileName()));
    					product.getPathPictures().add(fm.getFileName());
    				} catch (IOException e) {
    					e.printStackTrace();
    				}
    			}
    		} else {
        		try {
        			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
        			product.getPathPictures().add("default.jpg");
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
            productService.updatePrinter3D(product);
            files.clear();
		
		  links.createLinksFor3DPrinters(productService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "3d_printer");
	    	}
	   return "redirect:/admin/3d_printer/edit/" + id;
	}
	
    @RequestMapping("/admin/3d_printer/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	files.clear();
    	Printer3D undatePrinter3D = productService.getPrinter3DById(id);
    	
        model.addAttribute("product", undatePrinter3D);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
        model.addAttribute("type", "3d_printer");
        logger.info("All characteristic of 3d printer.");
		try {
			model.addAttribute("printer", (JSONObject)new JSONParser().
					parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
		} catch (IOException | ParseException e) {}
        return "admin/3d_printer";
    }
	
	@RequestMapping(value = "/admin/3d_printer/update", method = RequestMethod.POST) 
	public String updatePrinter(@ModelAttribute("product") @Valid Printer3D product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "3d_printer");
			try {
				model.addAttribute("printer", (JSONObject)new JSONParser().
						parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
            return "admin/3d_printer";
        }
		
		List<String> pathPictures = productService.getPrinter3DById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);

        productService.updatePrinter3D(product);

		  files.clear();

		  links.createLinksFor3DPrinters(productService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "3d_printer");
	    	}
	   return "redirect:/admin/3d_printers";
	}
	
	@RequestMapping(value = "/admin/3d_printer/save_update", method = RequestMethod.POST) 
	public String updateSavePrinter(@ModelAttribute("product") @Valid Printer3D product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "3d_printer");
			try {
				model.addAttribute("printer", (JSONObject)new JSONParser().
						parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/3d_printer.json"), "UTF-8")));
			} catch (IOException | ParseException e) {}
            return "admin/3d_printer";
        }
		
		List<String> pathPictures = productService.getPrinter3DById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);

        productService.updatePrinter3D(product);

		  links.createLinksFor3DPrinters(productService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "3d_printer");
	    	}
		  
  		return "redirect:/admin/3d_printer/edit/" + product.getId();
	}
	
    @RequestMapping(value="/admin/3d_printer/upload_pictures", method = RequestMethod.POST)
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
    
    @RequestMapping(value="/admin/3d_printer/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
    
    @RequestMapping(value="/admin/3d_printer/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	String name = namePicture.replace(":", ".");
    		Iterator<FileMeta> fmi = files.getFiles().iterator();
    		while(fmi.hasNext()){
        		if(fmi.next().getFileName().equals(name)){
        			fmi.remove();
        			break;
        		}
        	}	
    }
    
    @RequestMapping(value="/admin/3d_printer/upload_pictures_update/{id}", method = RequestMethod.POST)
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
        	 
 			Printer3D product = productService.getPrinter3DById(id);
 			product.getPathPictures().add(fileName);
 			productService.updatePrinter3D(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/3d_printer/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed 3d_printer product");
    	
    	Printer3D product = productService.getPrinter3DById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	productService.updatePrinter3D(product);
    }
    
    @RequestMapping(value="/admin/3d_printer/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	Printer3D product = productService.getPrinter3DById(id);
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
				logger.error("Can't update path of the default picture to printer 3d with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	productService.updatePrinter3D(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed printer 3d product");
    }
    
    @RequestMapping("/admin/3d_printer/remove/{id}")
    public String removePrinter(@PathVariable("id") long id){
    	
    		try {
				FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
			} catch (IOException e) {
				e.printStackTrace();
			}

    	componets.updateInLeftField(productService.getPrinter3DById(id), false, "3d_printer");
        productService.removePrinter3D(id);
        
    	links.createLinksFor3DPrinters(productService.listShowOnSite());
        
        return "redirect:/admin/3d_printers";
    }

    @RequestMapping(value="/admin/3d_printer/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer3D printer3d = productService.getPrinter3DById(id);
    	printer3d.setShowOnSite(value);
    	productService.updatePrinter3D(printer3d);
    	links.createLinksFor3DPrinters(productService.listShowOnSite());
    	
    	if (printer3d.isShowOnSite() && printer3d.isShowOnLeftSide()){
    		componets.updateInLeftField(printer3d, true, "3d_printer");
    	} else {
    		componets.updateInLeftField(printer3d, false, "3d_printer");
    	}
    }
    
    @RequestMapping(value="/admin/3d_printer/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer3D printer3d = productService.getPrinter3DById(id);
    	printer3d.setShowOnHomePage(value);
    	productService.updatePrinter3D(printer3d);
    }
    
    @RequestMapping(value="/admin/3d_printer/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Printer3D printer3d = productService.getPrinter3DById(id);
    	printer3d.setShowOnLeftSide(value);
    	productService.updatePrinter3D(printer3d);
    	
    	if (printer3d.isShowOnSite() && printer3d.isShowOnLeftSide()){
    		componets.updateInLeftField(printer3d, true, "3d_printer");
    	} else {
    		componets.updateInLeftField(printer3d, false, "3d_printer");
    	}
    }
}

