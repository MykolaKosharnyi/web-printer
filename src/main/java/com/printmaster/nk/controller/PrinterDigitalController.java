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
import com.printmaster.nk.model.DigitalPrinter;
import com.printmaster.nk.model.SearchDigitalPrinters;
import com.printmaster.nk.service.DigitalPrinterService;

@Controller
public class PrinterDigitalController {
	
	private Logger logger = Logger.getLogger(PrinterDigitalController.class);
	
	private String directory = "/var/www/localhost/images";
	private String concreteFolder = "digital_printers";
	
	@Autowired
	private LinksForProducts links;
	
	@Autowired
    ComponetsForController componets;

    @Autowired
    PicturesContainer files;

    private DigitalPrinterService productService;
    
    @Autowired(required=true)
    @Qualifier(value="digitalPrinterService")
    public void setPrinterService(DigitalPrinterService productService){
        this.productService = productService;
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
    
	@ModelAttribute("typePrinter")
	public Map<String, String> typePrinter(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Полноцветное лазерное оборудование", "Полноцветное лазерное оборудование");
		m.put("Монохромное лазерное оборудование", "Монохромное лазерное оборудование");
		m.put("Полноцветное струйное оборудование", "Полноцветное струйное оборудование");
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
	
	@ModelAttribute("interfaces")
	public Map<String, String> interfaceConnection(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("SCSI", "SCSI");
		m.put("PCI Adapter", "PCI Adapter");
		m.put("USB", "USB");
		m.put("Fire-Wire", "Fire-Wire");
		return m;
	}
	
	@ModelAttribute("device")
	public Map<String, String> device(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Принтер", "Принтер");
		m.put("Сканер", "Сканер");
		m.put("Копир", "Копир");
		m.put("МФУ", "МФУ");
		return m;
	}
	
	@ModelAttribute("typeOfPrinting")
	public Map<String, String> typeOfPrinting(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Черно-белая", "Черно-белая");
		m.put("Цветная", "Цветная");
		return m;
	}
	
	@ModelAttribute("printTechnology")
	public Map<String, String> printTechnology(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Лазерная", "Лазерная");
		m.put("Cтруйная", "Cтруйная");
		return m;
	}
	
	@ModelAttribute("accommodation")
	public Map<String, String> accommodation(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Напольный", "Напольный");
		m.put("Настольный", "Настольный");
		m.put("Стенд", "Стенд");
		return m;
	}
	
	@ModelAttribute("applicationArea")
	public Map<String, String> applicationArea(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Офисный", "Офисный");
		m.put("Промышленный", "Промышленный");
		return m;
	}
	
	@ModelAttribute("maximumFormat")
	public Map<String, String> maximumFormat(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("A4", "A4");
		m.put("A3", "A3");
		m.put("A2", "A2");
		m.put("A1", "A1");
		m.put("A0", "A0");
		return m;
	}
	
	@ModelAttribute("yn")
	public Map<String, String> yn(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Есть", "Есть");
		m.put("Нет", "Нет");
		return m;
	}
	
	@ModelAttribute("scannerType")
	public Map<String, String> scannerType(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Планшетный", "Планшетный");
		m.put("Протяжный", "Протяжный");
		return m;
	}
	
	@ModelAttribute("scannerResolution")
	public Map<String, String> scannerResolution(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("300x300dpi", "300x300dpi");
		m.put("300x600dpi", "300x600dpi");
		m.put("600x600dpi", "600x600dpi");
		m.put("600x1200dpi", "600x1200dpi");
		m.put("1200x1200dpi", "1200x1200dpi");
		return m;
	}
	
	@ModelAttribute("maximumResolutionCopierBW")
	public Map<String, String> maximumResolutionCopierBW(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("300x300dpi", "300x300dpi");
		m.put("300x600dpi", "300x600dpi");
		m.put("600x600dpi", "600x600dpi");
		m.put("600x1200dpi", "600x1200dpi");
		m.put("1200x1200dpi", "1200x1200dpi");
		return m;
	}
	
	@ModelAttribute("printingOn")
	public Map<String, String> printingOn(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("карточках", "карточках");
		m.put("пленках", "пленках");
		m.put("этикетках", "этикетках");
		m.put("глянцевой бумаге", "глянцевой бумаге");
		m.put("конвертах", "конвертах");
		m.put("матовой бумаге", "матовой бумаге");
		return m;
	}
	
	@ModelAttribute("support")
	public Map<String, String> support(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("PostScript 3", "PostScript 3");
		m.put("PCL 5e", "PCL 5e");
		m.put("PCL 6", "PCL 6");
		m.put("PDF", "PDF");
		return m;
	}
	
	@ModelAttribute("oSSupport")
	public Map<String, String> oSSupport(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Windows", "Windows");
		m.put("Linux", "Linux");
		m.put("Mac OS", "Mac OS");
		return m;
	}
	
	@ModelAttribute("displayInformation")
	public Map<String, String> displayInformation(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Цветной ЖК-дисплей", "Цветной ЖК-дисплей");
		m.put("Монохромный ЖК-дисплей", "Монохромный ЖК-дисплей");
		m.put("нет", "нет");
		return m;
	}
	
	@RequestMapping(value = "/digital_printers", method = RequestMethod.GET)	
    public String allPrinters(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfDigitalPrinter(productService.listShowOnSite()));
        SearchDigitalPrinters search = new SearchDigitalPrinters();
        search.setPrise0(0);
        search.setPrise1(30000);
        model.addAttribute("search", search);
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
		model.addAttribute("listProducts", componets.showSimplestArrayOfDigitalPrinter(productService.listSearchDigitalPrinters(search)));
		return "digital_printers/" + type;
	}

    @RequestMapping(value="/digital_printers/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> addUser(@ModelAttribute(value="search") SearchDigitalPrinters search, BindingResult result ){
        return componets.showSimplestArrayOfDigitalPrinter(productService.listSearchDigitalPrinters(search));
    }
	
    @RequestMapping("/digital_printer/{id}")
    public String showPrinter(@PathVariable("id") long id, Model model){
        model.addAttribute("product", productService.getPrinterById(id));
        return "digital_printer";
    }
    
	@RequestMapping(value = "/admin/digital_printers", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
		model.addAttribute("titleOfTable", "Список загруженого цыфрового оборудования");
        model.addAttribute("listProducts", productService.listPrinters());
        logger.info("/admin/digital_printers page.");
        return "admin/digital_printers";
    }
	
	@RequestMapping(value = "/admin/digital_printers/{type}", method = RequestMethod.GET)	
    public String listConcreteType3DPrinters(@PathVariable("type") String type, Model model) {
        
        if(type.equals("full_color_laser_printers")){
        	List<DigitalPrinter> list = new ArrayList<DigitalPrinter>();
        	
        	for(DigitalPrinter printer : productService.listPrinters()){
        		if(printer.getTypePrinter().equals("Полноцветное лазерное оборудование")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженого полноцветного лазерного оборудования");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/digital_printers/full_color_laser_printers page.");
            
            return "admin/digital_printers";
    		
    	} else if(type.equals("monochrome_laser_printers")){
    		List<DigitalPrinter> list = new ArrayList<DigitalPrinter>();
        	
        	for(DigitalPrinter printer : productService.listPrinters()){
        		if(printer.getTypePrinter().equals("Монохромное лазерное оборудование")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженого монохромного лазерного оборудования");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/digital_printers/monochrome_laser_printers page.");
            
            return "admin/digital_printers";
            
    	} else if(type.equals("full-color_inkjet_printers")){
    		List<DigitalPrinter> list = new ArrayList<DigitalPrinter>();
        	
        	for(DigitalPrinter printer : productService.listPrinters()){
        		if(printer.getTypePrinter().equals("Полноцветное струйное оборудование")){
        			list.add(printer);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженого полноцветного струйного оборудования");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/digital_printers/full-color_inkjet_printers page.");
            
            return "admin/digital_printers";
             		
    	} else {
    		model.addAttribute("titleOfTable", "Список загруженных цыфровых принтеров");
            model.addAttribute("listProducts", productService.listPrinters());
            logger.info("/admin/digital_printers page.");
            return "admin/digital_printers";
    	}
    }
	
	@RequestMapping(value = "/admin/digital_printer/new", method = RequestMethod.GET)
	public ModelAndView addNewPrinter() {
		files.clear();
	    return new ModelAndView("admin/digital_printer", "product", new DigitalPrinter());
	}
     
	@RequestMapping(value = "/admin/digital_printer/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute("product") @Valid DigitalPrinter product,
			BindingResult result) throws IOException{
		
			if (result.hasErrors()) {
	            return new ModelAndView("admin/digital_printer", "product", product);
	        }

            long id = productService.addPrinter(product);
  
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
            productService.updatePrinter(product);
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/digital_printers"); 
		  mav.addObject("listProducts", productService.listPrinters());
		
		  links.createLinksForDigitalPrinters(productService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "digital_printer");
	    	
	   return mav;
	}
	
	@RequestMapping(value = "/admin/digital_printer/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid DigitalPrinter product,
			BindingResult result) throws IOException{
		
			if (result.hasErrors()) {
	            return new ModelAndView("admin/digital_printer", "product", product);
	        }

            long id = productService.addPrinter(product);
  
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
            productService.updatePrinter(product);
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/digital_printer/edit/" + id);
		
		  links.createLinksForDigitalPrinters(productService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "digital_printer");
	    	
	   return mav;
	}
	
    @RequestMapping("/admin/digital_printer/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	files.clear();
    	DigitalPrinter undatePrinter = productService.getPrinterById(id);
    	
    	FileMeta fm = null;
    	for(String path : undatePrinter.getPathPictures()){
    		fm = new FileMeta();
    		fm.setFileName(path);
    		
    		try {
    			File fi = new File(directory + File.separator + 
    					concreteFolder + File.separator + id + File.separator + path);
    			fm.setBytes(Files.readAllBytes(fi.toPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
    		files.add(fm);
    	}
        model.addAttribute("product", undatePrinter);
        return "admin/digital_printer";
    }
	
	@RequestMapping(value = "/admin/digital_printer/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updatePrinter(@ModelAttribute("product") @Valid DigitalPrinter product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/digital_printer", "product", product);
        }
		
		FileUtils.cleanDirectory(new File(directory + File.separator + 
				concreteFolder + File.separator + product.getId()));
		
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + 
        					concreteFolder + File.separator + product.getId() + File.separator + fm.getFileName()));
					product.getPathPictures().add(fm.getFileName());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

        productService.updatePrinter(product);
		
		ModelAndView mav = new ModelAndView("redirect:/admin/digital_printers"); 
		  mav.addObject("listProducts", productService.listPrinters());
		  files.clear();

		  links.createLinksForDigitalPrinters(productService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "digital_printer");
	    	
	   return mav;
	}
	
	@RequestMapping(value = "/admin/digital_printer/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSavePrinter(@ModelAttribute("product") @Valid DigitalPrinter product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/digital_printer", "product", product);
        }
		
		FileUtils.cleanDirectory(new File(directory + File.separator + 
				concreteFolder + File.separator + product.getId()));
		
		if (files != null && files.size()!=0) {
			for (FileMeta fm : files.getFiles()) {
				try {
					FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
							directory + File.separator + 
        					concreteFolder + File.separator + product.getId() + File.separator + fm.getFileName()));
					product.getPathPictures().add(fm.getFileName());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

        productService.updatePrinter(product);

		  links.createLinksForDigitalPrinters(productService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "digital_printer");
		  
		  ModelAndView mav = new ModelAndView("redirect:/admin/digital_printer/edit/" + product.getId());
			return mav;
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
    	for(int i = 0; i < selectedIds.size(); i++){
    		for(int k = 0; k < files.size() ; k++){
        		if(files.get(k).getFileName().equals(selectedIds.get(i))){
        			Collections.swap(files.getFiles(), i, k);
        			break;
        		}
        	}
    	}
    }
    
    @RequestMapping(value="/admin/digital_printer/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
    
    @RequestMapping("/admin/digital_printer/remove/{id}")
    public String removePrinter(@PathVariable("id") long id){
    	
    		try {
				FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
			} catch (IOException e) {
				e.printStackTrace();
			}

    	componets.updateInLeftField(productService.getPrinterById(id), false, "digital_printer");

        productService.removePrinter(id);
        
    	links.createLinksForDigitalPrinters(productService.listShowOnSite());
        
        return "redirect:/admin/digital_printers";
    }

    @RequestMapping(value="/admin/digital_printer/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	DigitalPrinter printer = productService.getPrinterById(id);
    	printer.setShowOnSite(value);
    	productService.updatePrinter(printer);
    	links.createLinksForDigitalPrinters(productService.listShowOnSite());
    	
    	if (printer.isShowOnSite() && printer.isShowOnLeftSide()){
    		componets.updateInLeftField(printer, true, "digital_printer");
    	} else {
    		componets.updateInLeftField(printer, false, "digital_printer");
    	}
    }
    
    @RequestMapping(value="/admin/digital_printer/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	DigitalPrinter printer = productService.getPrinterById(id);
    	printer.setShowOnHomePage(value);
    	productService.updatePrinter(printer);
    }
    
    @RequestMapping(value="/admin/digital_printer/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	DigitalPrinter printer = productService.getPrinterById(id);
    	printer.setShowOnLeftSide(value);
    	productService.updatePrinter(printer);
    	
    	if (printer.isShowOnSite() && printer.isShowOnLeftSide()){
    		componets.updateInLeftField(printer, true, "digital_printer");
    	} else {
    		componets.updateInLeftField(printer, false, "digital_printer");
    	}
    }
}

