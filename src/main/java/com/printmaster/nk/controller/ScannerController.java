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
import com.printmaster.nk.model.Scanner;
import com.printmaster.nk.model.SearchScanners;
import com.printmaster.nk.service.ScannerService;
import com.printmaster.nk.service.UseWithProductService;

@Controller
public class ScannerController {
	
	private Logger logger = Logger.getLogger(ScannerController.class);
	
	private String directory = "/var/www/localhost/images";

	private String concreteFolder = "scanners";
	
	@Autowired
	private LinksForProducts links;
	
	@Autowired
    ComponentsForControllers componets;

    @Autowired
    PicturesContainer files;
 
    private ScannerService scannerService;
    
    @Autowired(required=true)
    @Qualifier(value="scannerService")
    public void setScanerService(ScannerService ps){
        this.scannerService = ps;
    }
    
    private UseWithProductService useWithProductService;
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }

	@RequestMapping(value = "/scanners", method = RequestMethod.GET)	
    public String allScanners(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfScanner(this.scannerService.listShowOnSite()));
        SearchScanners search = new SearchScanners();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        model.addAttribute("type", "scanner");
        logger.info("On '../scanners' page.");
        
        componets.setJSONtoModelAttribute(model, "scanner");
        return "scanners";
    }
	
	@RequestMapping(value = "/scanners/{type}", method = RequestMethod.GET)	
    public String typeScanners(@PathVariable("type") String type, Model model) {
        SearchScanners search = new SearchScanners();
        String currentType = null;
        
        	if(type.equals("large_format_scanners")){
        		currentType = "Широкоформатные сканеры";
        		logger.info("On the /scanners/" + type + " page.");
        		
        	} else if(type.equals("3d_scanners")){
        		currentType = "3D Сканеры";
        		logger.info("On the /scanners/" + type + " page.");
        	} else {
        		return "redirect:/";
        	}
        
        String[] a = {currentType};
        search.setTypeProduct(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        model.addAttribute("listProducts", componets.showSimplestArrayOfScanner(scannerService.listSearchScanners(search)));
        model.addAttribute("type", "scanner");
        
        componets.setJSONtoModelAttribute(model, "scanner");
        return "scanners/" + type ;
    }

    @RequestMapping(value="/scanners/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchScanners(@ModelAttribute(value="search") SearchScanners search, BindingResult result ){
    	logger.info("On the /scanner/search page.");
    	return componets.showSimplestArrayOfScanner(scannerService.listSearchScanners(search));
    }
	
    @RequestMapping("/scanner/{id}")
    public String showScanner(@PathVariable("id") long id, Model model){
    	logger.info("/scanner/" + id + " page.");
    	Scanner product = scannerService.getScannerById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", "scanner");
        if(product.getIdUseWithProduct()!=null){
        	model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(useWithProductService.getUseWithProductsByIds(product.getIdUseWithProduct())));
        } else {
        	model.addAttribute("uwp", null);
        }
        
        return "scanner";
    }
    
	@RequestMapping(value = "/admin/scanners", method = RequestMethod.GET)	
    public String listScanners(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных сканеров");
        model.addAttribute("listProducts", scannerService.listScanners("id"));

        model.addAttribute("productType", "scanner");
        model.addAttribute("nameProduct", "Имя сканера");
        model.addAttribute("title", "Сканеры");
        model.addAttribute("addProduct", "Добавить сканер");
        model.addAttribute("productSubType", "none");
        logger.info("/admin/scanners page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/scanners/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeScanners(@PathVariable("type") String type, Model model) {

		List<Scanner> list = new ArrayList<Scanner>();
        if(type.equals("large_format_scanners")){
        	for(Scanner scanner : scannerService.listScanners("id")){
        		if(scanner.getTypeProduct().equals("Широкоформатные сканеры")){
        			list.add(scanner);
        		}
        	}
        	model.addAttribute("productSubType", "large_format_scanners");
        	model.addAttribute("titleOfTable", "Список загруженных широкоформатных сканеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/scanners/large_format_scanners page.");
    		
    	} else if(type.equals("3d_scanners")){
        	for(Scanner scanner : scannerService.listScanners("id")){
        		if(scanner.getTypeProduct().equals("3D Сканеры")){
        			list.add(scanner);
        		}
        	}
        	model.addAttribute("productSubType", "3d_scanners");
        	model.addAttribute("titleOfTable", "Список загруженных 3D сканеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/scanners/3d_scanners page.");
            
    	} else {
    		model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных сканеров");
            model.addAttribute("listProducts", scannerService.listScanners("id"));
            logger.info("/admin/scanners page.");
    	}
        model.addAttribute("productType", "scanner");
        model.addAttribute("nameProduct", "Имя сканера");
        model.addAttribute("title", "Сканеры");
        model.addAttribute("addProduct", "Добавить сканер");
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/scanner/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Scanner> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<Scanner> list = new ArrayList<Scanner>();
        if(type.equals("large_format_scanners")){
        	for(Scanner scanner : scannerService.listScanners(value)){
        		if(scanner.getTypeProduct().equals("Широкоформатные сканеры")){
        			list.add(scanner);
        		}
        	}
    		
    	} else if(type.equals("3d_scanners")){
        	for(Scanner scanner : scannerService.listScanners(value)){
        		if(scanner.getTypeProduct().equals("3D Сканеры")){
        			list.add(scanner);
        		}
        	}
            
    	} else {
    		list.addAll(scannerService.listScanners(value));
    	}

		return list;
    }
	
	@RequestMapping(value = "/admin/scanner/new", method = RequestMethod.GET)
	public String addNewScanner(Model model) {
		files.clear();
		logger.info("/admin/scanner/new page.");
		model.addAttribute("product", new Scanner());
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", "scanner");
		model.addAttribute("productId", 0);
		
		componets.setJSONtoModelAttribute(model, "scanner");
	    return "admin/scanner";
	}
     
	@RequestMapping(value = "/admin/scanner/copy/{id}", method = RequestMethod.GET)
	public String copyScanner(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info("/admin/scanner/copy/" + id + " page.");
		
		 logger.info("Copy all characteristic of scanner.");
		 Scanner scanner = scannerService.getScannerById(id);
		
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer(scanner.getPathPictures(), directory, concreteFolder, id, files);
		
		 /* set null to id because we must get create new product operation */
	     scanner.setId(null);
		 model.addAttribute("product", scanner);
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", "scanner");
		 model.addAttribute("productId", id);
		 
		 componets.setJSONtoModelAttribute(model, "scanner");
	    return "admin/scanner";
	}
	
	@RequestMapping(value = "/admin/scanner/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid  Scanner product,
			BindingResult result, Model model) throws IOException{
			
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "scanner");
				componets.setJSONtoModelAttribute(model, "scanner");
	            return "admin/scanner";
	        }

            long id = scannerService.addScanner(product);
            logger.info("Create new scanner! With id=" + id);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            this.scannerService.updateScanner(product);
            
            files.clear();
		  
		  links.createLinksForScanners(scannerService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "scanner");
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/scanners";
	}
	
	@RequestMapping(value = "/admin/scanner/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Scanner product,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "scanner");
				componets.setJSONtoModelAttribute(model, "scanner");
	            return "admin/scanner";
	        }
		
            long id = scannerService.addScanner(product);
            logger.info("Create new scanner! With id=" + id);
  
            //create folder and add to her new pictures
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            this.scannerService.updateScanner(product);
            
            files.clear(); 
		  
		  links.createLinksForScanners(scannerService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "scanner");
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/scanner/edit/" + id;
	}
	
    @RequestMapping("/admin/scanner/edit/{id}")
    public String editScanner(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing scanner with id=" + id);
    	Scanner undateScanner = scannerService.getScannerById(id);
    	
        model.addAttribute("product", undateScanner);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
        model.addAttribute("type", "scanner");
        componets.setJSONtoModelAttribute(model, "scanner");
        return "admin/scanner";
    }
	
	@RequestMapping(value = "/admin/scanner/save_update", method = RequestMethod.POST) 
	public String updateSaveScanner(@ModelAttribute("product") @Valid Scanner product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "scanner");
			componets.setJSONtoModelAttribute(model, "scanner");
            return "admin/scanner";
        }
		
		logger.info("scanner UPDATE with save, id=" + product.getId());
        
		List<String> pathPictures = scannerService.getScannerById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
		
		scannerService.updateScanner(product);
        logger.info("scanner with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForScanners(scannerService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, "scanner");
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/scanner/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/scanner/update", method = RequestMethod.POST) 
	public String updateScanner(@ModelAttribute("product") @Valid Scanner product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "scanner");
			componets.setJSONtoModelAttribute(model, "scanner");
            return "admin/scanner";
        }
		
			logger.info("scanner UPDATE id=" + product.getId());
        
			List<String> pathPictures = scannerService.getScannerById(product.getId()).getPathPictures();
			product.setPathPictures(pathPictures);
			
			scannerService.updateScanner(product);
			logger.info("scanner with id=" + product.getId() + " was UDPATED!");
		  
			links.createLinksForScanners(scannerService.listShowOnSite());
	
			if (product.isShowOnSite() && product.isShowOnLeftSide())
				componets.updateInLeftField(product, true, "scanner");
		  
			logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/scanners";
	}
	
    @RequestMapping(value="/admin/scanner/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {
    	logger.info("upload new picture");
        
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String fileName = null;

         while(itr.hasNext()){
             mpf = request.getFile(itr.next()); 
             
             FileMeta fileMeta = new FileMeta();
     		
     		 fileName = files.size() + new Random().nextInt(10000000) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*last part is file extension*/; 
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
    
    @RequestMapping(value="/admin/scanner/change_order_pictures", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	componets.changeOrderPictures(concreteFolder, selectedIds, files);   	  	
    }
    
    @RequestMapping(value="/admin/scanner/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePictureFromPicturesContainer(concreteFolder, namePicture, files);
    }
    
    @RequestMapping(value="/admin/scanner/upload_pictures_update/{id}", method = RequestMethod.POST)
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
        	 
 			Scanner product = scannerService.getScannerById(id);
 			product.getPathPictures().add(fileName);
 			scannerService.updateScanner(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/scanner/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed scanner product");
    	
    	Scanner product = scannerService.getScannerById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	scannerService.updateScanner(product);
    }
    
    @RequestMapping(value="/admin/scanner/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	Scanner product = scannerService.getScannerById(id);
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
				logger.error("Can't update path of the default picture to scannanner with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	scannerService.updateScanner(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed scanner product");
    }
    
    @RequestMapping("/admin/scanner/remove/{id}")
    public String removeLaminator(@PathVariable("id") long id){
    		logger.info("Start deleting scanner from database, id=" + id);
    		try {
    			FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
    			logger.info("deleted all pictures and pictures directory of this scanner");
			} catch (IOException e) {
				logger.error("Deleting all pictures from this scanner has a problem: ", e);
			}
    		
    		logger.info("Update links to the products in left menu!");
    		componets.updateInLeftField(scannerService.getScannerById(id), false, "scanner");
    		
    		logger.info("DELETE scanner with id=" + id + " from database!");
    		scannerService.removeScanner(id);
        
    		links.createLinksForScanners(scannerService.listShowOnSite());
    		
        return "redirect:/admin/scanners";
    }  
    
    @RequestMapping(value="/admin/scanner/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Scanner scanner = scannerService.getScannerById(id);
    	scanner.setShowOnSite(value);
    	scannerService.updateScanner(scanner);
    	
    	if (scanner.isShowOnSite() && scanner.isShowOnLeftSide()){
    		componets.updateInLeftField(scanner, true, "scanner");
    	} else {
    		componets.updateInLeftField(scanner, false, "scanner");
    	}
    	
    	links.createLinksForScanners(scannerService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/scanner/setTop/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	Scanner scanner = scannerService.getScannerById(id);
    	scanner.setTop(value);
    	scannerService.updateScanner(scanner);
    }
    
    @RequestMapping(value="/admin/scanner/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Scanner scanner = scannerService.getScannerById(id);
    	scanner.setShowOnHomePage(value);
    	scannerService.updateScanner(scanner);
    }
    
    @RequestMapping(value="/admin/scanner/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Scanner scanner = scannerService.getScannerById(id);
    	scanner.setShowOnLeftSide(value);
    	scannerService.updateScanner(scanner);
    	
    	if (scanner.isShowOnSite() && scanner.isShowOnLeftSide()){
    		componets.updateInLeftField(scanner, true, "scanner");
    	} else {
    		componets.updateInLeftField(scanner, false, "scanner");
    	}
    		
    }
}
