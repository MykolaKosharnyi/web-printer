package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import org.springframework.web.servlet.ModelAndView;

import com.printmaster.nk.beans.ComponetsForController;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Scanner;
import com.printmaster.nk.model.SearchScanners;
import com.printmaster.nk.service.ScannerService;

@Controller
public class ScannerController {
	
	private Logger logger = Logger.getLogger(ScannerController.class);
	
	private String directory = "/var/www/localhost/images";

	private String concreteFolder = "scanners";
	
	@Autowired
	private LinksForProducts links;
	
	@Autowired
    ComponetsForController componets;

    @Autowired
    PicturesContainer files;
 
    private ScannerService scannerService;
    
    @Autowired(required=true)
    @Qualifier(value="scannerService")
    public void setScanerService(ScannerService ps){
        this.scannerService = ps;
    }
    
	@ModelAttribute("delivery")
	public Map<String, String> delivery(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Первый способ", "Первый способ");
		m.put("Второй способ", "Второй способ");
		m.put("Третий способ", "Третий способ");
		return m;
	}
	
	@ModelAttribute("availability")
	public Map<String, String> availability(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("есть", "есть");
		m.put("нету", "нету");
		m.put("заканчивается", "заканчивается");
		m.put("под заказ", "под заказ");
		return m;
	}
	
	@ModelAttribute("typeProduct")
	public Map<String, String> typeLaser(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Широкоформатные сканеры", "Широкоформатные сканеры");
		m.put("3D Сканеры", "3D Сканеры");
		return m;
	}
	
	@ModelAttribute("previouslyUsed")
	public Map<String, String> previouslyUsed(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("новое оборудование", "новое оборудование");
		m.put("демозальное оборудование", "демозальное оборудование");
		m.put("б/у", "б/у");
		return m;
	}
	
	@ModelAttribute("scanningWidth")
	public Map<String, String> scanningWidth(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("305", "305");
		m.put("457", "457");
		m.put("610", "610");
		m.put("914", "914");
		m.put("1070", "1070");
		m.put("1524", "1524");
		m.put("1550", "1550");
		m.put("1600", "1600");
		m.put("1800", "1800");
		m.put("2500", "2500");
		m.put("2540", "2540");
		m.put("2600", "2600");
		m.put("3200", "3200");
		m.put("3300", "3300");
		return m;
	}
	
	@ModelAttribute("innings")
	public Map<String, String> typeEngine(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Рулонный", "Рулонный");
		m.put("Плоскопечатный", "Плоскопечатный");
		m.put("Гибридный", "Гибридный");
		return m;
	}
	
	@ModelAttribute("chromaticity")
	public Map<String, String> chromaticity(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Цветной", "Цветной");
		m.put("Монохромный", "Монохромный");
		return m;
	}
	
	@ModelAttribute("scanningElement")
	public Map<String, String> scanningElement(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("CIS", "CIS");
		return m;
	}
	
	@ModelAttribute("lightSource")
	public Map<String, String> lightSource(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("3-цветные (RGB) светодиоды", "3-цветные (RGB) светодиоды");
		return m;
	}
	
	@ModelAttribute("bitColorScanning")
	public Map<String, String> bitColorScanning(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("48 бит на входе, 48 бита на выходе", "48 бит на входе, 48 бита на выходе");
		m.put("48 бит на входе, 24 бита на выходе", "48 бит на входе, 24 бита на выходе");
		return m;
	}
	
	@ModelAttribute("bitScanningGrayscale")
	public Map<String, String> bitScanningGrayscale(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("16 бит на входе, 8 бит на выходе", "16 бит на входе, 8 бит на выходе");
		return m;
	}
	
	@ModelAttribute("opticalResolution")
	public Map<String, String> opticalResolution(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("300dpi", "300dpi");
		m.put("600dpi", "600dpi");
		m.put("1200dpi", "1200dpi");
		m.put("1440dpi", "1440dpi");
		m.put("2880dpi", "2880dpi");
		m.put("4880dpi", "4880dpi");
		return m;
	}
	
	@ModelAttribute("equipmentManufacturer")
	public Map<String, String> equipmentManufacturer(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Contex", "Contex");
		m.put("Vidar", "Vidar");
		return m;
	}
	
	@ModelAttribute("connectionInterface")
	public Map<String, String> connectionInterface(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("SCSI", "SCSI");
		m.put("PCI Adapter", "PCI Adapter");
		m.put("USB", "USB");
		m.put("Fire-Wire", "Fire-Wire");
		return m;
	}
	
	@ModelAttribute("software")
	public Map<String, String> software(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put(" ", " ");
		return m;
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
        model.addAttribute("product", scannerService.getScannerById(id));
        return "scanner";
    }
    
	@RequestMapping(value = "/admin/scanners", method = RequestMethod.GET)	
    public String listScanners(Model model) {
		model.addAttribute("productType", "scanner");
		model.addAttribute("nameProduct", "Имя сканера");
		model.addAttribute("titleOfTable", "Список загруженных сканеров");
        model.addAttribute("listProducts", scannerService.listScanners());
        model.addAttribute("title", "Сканеры");
        model.addAttribute("addProduct", "Добавить сканер");
        logger.info("/admin/scanners page.");
        return "admin/scanners";
    }
	
	@RequestMapping(value = "/admin/scanners/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeScanners(@PathVariable("type") String type, Model model) {

        if(type.equals("large_format_scanners")){
        	List<Scanner> list = new ArrayList<Scanner>();
        	
        	for(Scanner scanner : scannerService.listScanners()){
        		if(scanner.getTypeProduct().equals("Широкоформатные сканеры")){
        			list.add(scanner);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных широкоформатных сканеров");
            model.addAttribute("listProducts", list);
         
    		model.addAttribute("productType", "scanner");
    		model.addAttribute("nameProduct", "Имя сканера");
            model.addAttribute("title", "Сканеры");
            model.addAttribute("addProduct", "Добавить сканер");
            logger.info("On /admin/scanners/large_format_scanners page.");
            
            return "admin/scanners";
    		
    	} else if(type.equals("3d_scanners")){
        	List<Scanner> list = new ArrayList<Scanner>();
        	
        	for(Scanner scanner : scannerService.listScanners()){
        		if(scanner.getTypeProduct().equals("3D Сканеры")){
        			list.add(scanner);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных 3D сканеров");
            model.addAttribute("listProducts", list);
         
    		model.addAttribute("productType", "scanner");
    		model.addAttribute("nameProduct", "Имя сканера");
            model.addAttribute("title", "Сканеры");
            model.addAttribute("addProduct", "Добавить сканер");
            logger.info("On /admin/scanners/3d_scanners page.");
            
            return "admin/scanners";
    		
    	} else {
    		model.addAttribute("productType", "scanner");
    		model.addAttribute("nameProduct", "Имя сканера");
    		model.addAttribute("titleOfTable", "Список загруженных сканеров");
            model.addAttribute("listProducts", scannerService.listScanners());
            model.addAttribute("title", "Сканеры");
            model.addAttribute("addProduct", "Добавить сканер");
            logger.info("/admin/scanners page.");
            return "admin/scanners";
    	}
    }
	
	@RequestMapping(value = "/admin/scanner/new", method = RequestMethod.GET)
	public ModelAndView addNewScanner() {
		files.clear();
		logger.info("/admin/scanner/new page.");
	    return new ModelAndView("admin/scanner", "product", new Scanner());
	}
     
	@RequestMapping(value = "/admin/scanner/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute("product") @Valid  Scanner product,
			BindingResult result) throws IOException{
			
			if (result.hasErrors()) {
	            return new ModelAndView("admin/scanner", "product", product);
	        }

            long id = scannerService.addScanner(product);
            logger.info("Create new scanner! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new scanner directory! With id=" + id);
            } else {
            	logger.error("Don't create new scanner directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to scanner with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to scanner with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the scanner with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to scanner with id=" + id, e);
				}
			}
			
            this.scannerService.updateScanner(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/scanners"); 
		  mav.addObject("listProducts", scannerService.listScanners());
		  
		  links.createLinksForScanners(scannerService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "scanner");
	    	
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
	@RequestMapping(value = "/admin/scanner/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid Scanner product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/scanner", "product", product);
	        }
		
            long id = scannerService.addScanner(product);
            logger.info("Create new scanner! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	logger.info("Create new scanner directory! With id=" + id);
            } else {
            	logger.error("Don't create new scanner directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to scanner with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to scanner with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the scanner with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to scanner with id=" + id, e);
				}
			}
			
            this.scannerService.updateScanner(product);
            
            files.clear(); 
		  
		  links.createLinksForScanners(scannerService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "scanner");
	    	
		  logger.info("Update links to the products in left menu!");
	   return new ModelAndView("redirect:/admin/scanner/edit/" + id);
	}
	
    @RequestMapping("/admin/scanner/edit/{id}")
    public String editScanner(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing scanner with id=" + id);
    	files.clear();
    	Scanner undateScanner = scannerService.getScannerById(id);
    	
    	FileMeta fm = null;
    	for(String path : undateScanner.getPathPictures()){
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
        model.addAttribute("product", undateScanner);
        return "admin/scanner";
    }
	
	@RequestMapping(value = "/admin/scanner/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSaveScanner(@ModelAttribute("product") @Valid Scanner product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/scanner", "product", product);
        }
		
		logger.info("scanner UPDATE with save, id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to scanner with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to scanner with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the scanner with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to scanner with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
		scannerService.updateScanner(product);
        logger.info("scanner with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForScanners(scannerService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, "scanner");
		  
		logger.info("Update links to the products in left menu!");
		ModelAndView mav = new ModelAndView("redirect:/admin/scanner/edit/" + product.getId());
		return mav;
	}
	
	@RequestMapping(value = "/admin/scanner/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateScanner(@ModelAttribute("product") @Valid Scanner product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/scanner", "product", product);
        }
		
		logger.info("scanner UPDATE id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to scanner with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to scanner with id = " + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the scanner with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to scanner with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
		scannerService.updateScanner(product);
        logger.info("scanner with id=" + product.getId() + " was UDPATED!");
        
		ModelAndView mav = new ModelAndView("redirect:/admin/scanners"); 
		  mav.addObject("listProducts", scannerService.listScanners());
		  files.clear();
		  
		  links.createLinksForScanners(scannerService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "scanner");
		  
		  logger.info("Update links to the products in left menu!");
	   return mav;
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
    
    @RequestMapping(value="/admin/scanner/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	logger.info("change order of pictures in FILEMETA");
    	for(int i = 0; i < selectedIds.size(); i++){
    		for(int k = 0; k < files.size() ; k++){
        		if(files.get(k).getFileName().equals(selectedIds.get(i))){
        			Collections.swap(files.getFiles(), i, k);
        			break;
        		}
        	}
    	}   	  	
    }
    
    @RequestMapping(value="/admin/scanner/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	String name = namePicture.replace(":", ".");
    		Iterator<FileMeta> fmi = files.getFiles().iterator();
    		while(fmi.hasNext()){
        		if(fmi.next().getFileName().equals(name)){
        			fmi.remove();
        			break;
        		}
        	}
    	logger.info("Remove pictore with name = " + namePicture + " from FILEMETA");
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
