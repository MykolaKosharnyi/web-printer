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
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.SearchPrinters3D;
import com.printmaster.nk.service.Printer3DService;

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
    
	@ModelAttribute("typePrinter3D")
	public Map<String, String> typePrinter3D(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Экструдные FDM", "Экструдные FDM");
		m.put("Фото печать Polyjet", "Фото печать Polyjet");
		m.put("Лазерного спекания LENS", "Лазерного спекания LENS");
		m.put("Ламинация LOM", "Ламинация LOM");
		m.put("Стереолитография SL", "Стереолитография SL");
		m.put("Лазерное спекание LS", "Лазерное спекание LS");
		m.put("Порошкового склеивания 3DP", "Порошкового склеивания 3DP");
		return m;
	}
    
	@ModelAttribute("printTechnology")
	public Map<String, String> printTechnology(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("FDM", "FDM");
		m.put("RepRap", "RepRap");
		m.put("MJM (Multi Jet Modeling)", "MJM (Multi Jet Modeling)");
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
	
	@ModelAttribute("chromaticity")
	public Map<String, String> chromaticity(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Монохромный", "Монохромный");
		m.put("2 цветный", "2 цветный");
		m.put("3 цветный", "3 цветный");
		m.put("4 цветный", "4 цветный");
		m.put("5 цветный", "5 цветный");
		m.put("6 цветный", "6 цветный");
		m.put("7 цветный", "7 цветный");
		m.put("8 цветный", "8 цветный");
		m.put("9 цветный", "9 цветный");
		m.put("10 цветный", "10 цветный");
		return m;
	}
	
	@ModelAttribute("typeOfPrinthead")
	public Map<String, String> typeOfPrinthead(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Первая", "Первая");
		m.put("Вторая", "Вторая");
		return m;
	}
	
	@ModelAttribute("media")
	public Map<String, String> media(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("PLA  (полилактид)", "PLA  (полилактид)");
		m.put("ABS (акрилонитрилбутадиенстирол)", "ABS (акрилонитрилбутадиенстирол)");
		m.put("ПВС (поливиниловый спирт)", "ПВС (поливиниловый спирт)");
		m.put("FTI - акриловый фотополимерный пластик", "FTI - акриловый фотополимерный пластик");
		m.put("HIPS", "HIPS");
		m.put("PA (нейлон)", "PA (нейлон)");
		m.put("PET / PETG", "PET / PETG");
		m.put("POM", "POM");
		m.put("PVA", "PVA");
		return m;
	}
	
	@ModelAttribute("equipmentManufacturer")
	public Map<String, String> equipmentManufacturer(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("MakerBot", "MakerBot");
		m.put("3D Systems", "3D Systems");
		m.put("XYZ printing", "XYZ printing");
		m.put("PrintBox3D", "PrintBox3D");
		m.put("ProJet Accelerator Software", "ProJet Accelerator Software");
		m.put("3DTouch", "3DTouch");
		return m;
	}
	
	@ModelAttribute("interfaceConnection")
	public Map<String, String> interfaceConnection(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("SCSI", "SCSI");
		m.put("PCI Adapter", "PCI Adapter");
		m.put("USB", "USB");
		m.put("Fire-Wire", "Fire-Wire");
		return m;
	}
	
	@ModelAttribute("typesOfFiles")
	public Map<String, String> typesOfFiles(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put(".stl", ".stl");
		m.put(".gcode", ".gcode");
		m.put("STL", "STL");
		m.put("SLC", "SLC");
		m.put("CTL", "CTL");
		return m;
	}
	
	@ModelAttribute("rip")
	public Map<String, String> rip(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Cura", "Cura");
		m.put("ReplicatorG", "ReplicatorG");
		m.put("Pronterface", "Pronterface");
		m.put("Repetier", "Repetier");
		m.put("3DPrint Controller Software", "3DPrint Controller Software");
		m.put("Cube Software", "Cube Software");
		m.put("MakerBot MakerWare", "MakerBot MakerWare");
		return m;
	}
	
	@RequestMapping(value = "/3d_printers", method = RequestMethod.GET)	
    public String allPrinters(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfPrinter3D(productService.listShowOnSite()));
        SearchPrinters3D search = new SearchPrinters3D();
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
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
		return "3d_printers/" + type;
	}

    @RequestMapping(value="/3d_printers/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> addUser(@ModelAttribute(value="search") SearchPrinters3D search, BindingResult result ){
        return componets.showSimplestArrayOfPrinter3D(productService.listSearchPrinters3D(search));
    }
	
    @RequestMapping("/3d_printer/{id}")
    public String showPrinter(@PathVariable("id") long id, Model model){
        model.addAttribute("product", productService.getPrinter3DById(id));
        return "3d_printer";
    }
    
	@RequestMapping(value = "/admin/3d_printers", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
		model.addAttribute("titleOfTable", "Список загруженных 3D принтеров");
        model.addAttribute("listProducts", productService.listPrinters3D());
        logger.info("/admin/3d_printers page.");
        return "admin/3d_printers";
    }
	
	@RequestMapping(value = "/admin/3d_printers/{type}", method = RequestMethod.GET)	
    public String listConcreteType3DPrinters(@PathVariable("type") String type, Model model) {
        
        if(type.equals("FDM-extruder")){
        	List<Printer3D> list = new ArrayList<Printer3D>();
        	
        	for(Printer3D printer3d : productService.listPrinters3D()){
        		if(printer3d.getTypePrinter3D().equals("Экструдные FDM")){
        			list.add(printer3d);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных экструдных FDM принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/FDM-extruder page.");
            
            return "admin/3d_printers";
    		
    	} else if(type.equals("photo_printing_polyjet")){
    		List<Printer3D> list = new ArrayList<Printer3D>();
        	
        	for(Printer3D printer3d : productService.listPrinters3D()){
        		if(printer3d.getTypePrinter3D().equals("Фото печать Polyjet")){
        			list.add(printer3d);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Фото печать Polyjet, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/photo_printing_polyjet page.");
            
            return "admin/3d_printers";
            
    	} else if(type.equals("laser_sintering_LENS")){
    		List<Printer3D> list = new ArrayList<Printer3D>();
        	
        	for(Printer3D printer3d : productService.listPrinters3D()){
        		if(printer3d.getTypePrinter3D().equals("Лазерного спекания LENS")){
        			list.add(printer3d);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Лазерного спекания LENS, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/laser_sintering_LENS page.");
            
            return "admin/3d_printers";
             		
    	} else if(type.equals("lamination_LOM")){	
    		List<Printer3D> list = new ArrayList<Printer3D>();
        	
        	for(Printer3D printer3d : productService.listPrinters3D()){
        		if(printer3d.getTypePrinter3D().equals("Ламинация LOM")){
        			list.add(printer3d);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Ламинация LOM, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/lamination_LOM page.");
            
            return "admin/3d_printers";
    		
    	} else if(type.equals("stereolithography_SL")){		
    		List<Printer3D> list = new ArrayList<Printer3D>();
        	
        	for(Printer3D printer3d : productService.listPrinters3D()){
        		if(printer3d.getTypePrinter3D().equals("Стереолитография SL")){
        			list.add(printer3d);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Стереолитография SL, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/stereolithography_SL page.");
            
            return "admin/3d_printers";
    		
    	} else if(type.equals("laser_sintering_LS")){    		
    		List<Printer3D> list = new ArrayList<Printer3D>();
        	
        	for(Printer3D printer3d : productService.listPrinters3D()){
        		if(printer3d.getTypePrinter3D().equals("Лазерное спекание LS")){
        			list.add(printer3d);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Лазерное спекание LS, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/laser_sintering_LS page.");
            
            return "admin/3d_printers";
    		
    	} else if(type.equals("powder_bonding_3DP")){  		
    		List<Printer3D> list = new ArrayList<Printer3D>();
        	
        	for(Printer3D printer3d : productService.listPrinters3D()){
        		if(printer3d.getTypePrinter3D().equals("Порошкового склеивания 3DP")){
        			list.add(printer3d);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Порошкового склеивания 3DP, список загруженных 3D принтеров");
            model.addAttribute("listProducts", list);
            logger.info("On /admin/3d_printers/powder_bonding_3DP page.");
            
            return "admin/3d_printers";
    		
    	} else {
    		model.addAttribute("titleOfTable", "Список загруженных 3D принтеров");
            model.addAttribute("listProducts", productService.listPrinters3D());
            logger.info("/admin/3d_printers page.");
            return "admin/3d_printers";
    	}
    }
	
	@RequestMapping(value = "/admin/3d_printer/new", method = RequestMethod.GET)
	public ModelAndView addNewPrinter() {
		files.clear();
	    return new ModelAndView("admin/3d_printer", "product", new Printer3D());
	}
     
	@RequestMapping(value = "/admin/3d_printer/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute("product") @Valid Printer3D product,
			BindingResult result) throws IOException{
		
			if (result.hasErrors()) {
	            return new ModelAndView("admin/3d_printer", "product", product);
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
		
          ModelAndView mav = new ModelAndView("redirect:/admin/3d_printers"); 
		  mav.addObject("listProducts", productService.listPrinters3D());
		
		  links.createLinksFor3DPrinters(productService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "3d_printer");
	    	}
	   return mav;
	}
	
	@RequestMapping(value = "/admin/3d_printer/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid Printer3D product,
			BindingResult result) throws IOException{
			
			if (result.hasErrors()) {
	            return new ModelAndView("admin/3d_printer", "product", product);
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
		
          ModelAndView mav = new ModelAndView("redirect:/admin/3d_printer/edit/" + id); 
		
		  links.createLinksFor3DPrinters(productService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "3d_printer");
	    	}
	   return mav;
	}
	
    @RequestMapping("/admin/3d_printer/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	files.clear();
    	Printer3D undatePrinter3D = productService.getPrinter3DById(id);
    	
    	FileMeta fm = null;
    	for(String path : undatePrinter3D.getPathPictures()){
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
        model.addAttribute("product", undatePrinter3D);
        return "admin/3d_printer";
    }
	
	@RequestMapping(value = "/admin/3d_printer/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updatePrinter(@ModelAttribute("product") @Valid Printer3D product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/3d_printer", "product", product);
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

        productService.updatePrinter3D(product);
		
		ModelAndView mav = new ModelAndView("redirect:/admin/3d_printers"); 
		  mav.addObject("listProducts", productService.listPrinters3D());
		  files.clear();

		  links.createLinksFor3DPrinters(productService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "3d_printer");
	    	}
	   return mav;
	}
	
	@RequestMapping(value = "/admin/3d_printer/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSavePrinter(@ModelAttribute("product") @Valid Printer3D product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/3d_printer", "product", product);
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

        productService.updatePrinter3D(product);

		  links.createLinksFor3DPrinters(productService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true, "3d_printer");
	    	}
		  
		ModelAndView mav = new ModelAndView("redirect:/admin/3d_printer/edit/" + product.getId());
  		return mav;
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

