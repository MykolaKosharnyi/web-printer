package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
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

import com.printmaster.nk.model.FileMeta;
import com.printmaster.nk.model.Printer3D;
import com.printmaster.nk.model.SearchPrinters3D;
import com.printmaster.nk.service.Printer3DService;

@Controller
public class Printer3DController {
	
	@Autowired
	ServletContext servletContext; 
	
    private Printer3DService productService;

    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;
    private String directory = "C:/Users/Николай/Desktop/work/print-master/src/main/webapp/resources/images/printers3d";
    
    @Autowired(required=true)
    @Qualifier(value="printer3DService")
    public void setPrinter3DService(Printer3DService productService){
        this.productService = productService;
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
		m.put("2…10 цветный", "2…10 цветный");
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
	
	@RequestMapping(value = "/printers_3d", method = RequestMethod.GET)	
    public String allPrinters(Model model) {
        model.addAttribute("listProducts", productService.listPrinters3D());
        SearchPrinters3D search = new SearchPrinters3D();
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        return "printers_3d";
    }
	
	@RequestMapping(value = "/printers_3d/{type}", method = RequestMethod.GET)
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
		model.addAttribute("listProducts", productService.listSearchPrinters3D(search));
		return "printers_3d/" + type;
	}

    @RequestMapping(value="/printers_3d/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody Set<Printer3D> addUser(@ModelAttribute(value="search") SearchPrinters3D search, BindingResult result ){
        return productService.listSearchPrinters3D(search);
    }
	
    @RequestMapping("/printer_3d/{id}")
    public String showPrinter(@PathVariable("id") long id, Model model){
        model.addAttribute("product", productService.getPrinter3DById(id));
        return "printer_3d";
    }
    
	@RequestMapping(value = "/admin/printers_3d", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
        model.addAttribute("listProducts", productService.listPrinters3D());
        return "admin/printers_3d";
    }
	
	@RequestMapping(value = "/admin/printer_3d/new", method = RequestMethod.GET)
	public ModelAndView addNewPrinter() {
		files.clear();
	    return new ModelAndView("admin/printer_3d", "product", new Printer3D());
	}
     
	@RequestMapping(value = "/admin/printer_3d/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute Printer3D product) throws IOException{

            long id = productService.addPrinter3D(product);
  
            if(new File(directory + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию! для 3D принтера" + id);
            } else {
            	System.out.println("Не создано новую директорию :(");
            }
            
			if (files != null) {
				for (FileMeta fm : files) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
            productService.updatePrinter3D(product);
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/printers_3d"); 
		  mav.addObject("listProducts", productService.listPrinters3D());
		/*mav.addObject("printer", printer3d);*/
	   return mav;
	}
	
    @RequestMapping("/admin/printer_3d/edit/{id}")
    public String editPrinter(@PathVariable("id") long id, Model model){
    	files.clear();
    	Printer3D undatePrinter3D = productService.getPrinter3DById(id);
    	
    	FileMeta fm = null;
    	for(String path : undatePrinter3D.getPathPictures()){
    		fm = new FileMeta();
    		fm.setFileName(path);
    		
    		try {
    			File fi = new File(directory + File.separator + id + File.separator + path);
    			fm.setBytes(Files.readAllBytes(fi.toPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
    		files.add(fm);
    	}
        model.addAttribute("product", undatePrinter3D);
        return "admin/printer_3d";
    }
	
	@RequestMapping(value = "/admin/printer_3d/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updatePrinter(@ModelAttribute Printer3D product) throws IOException{
		FileUtils.cleanDirectory(new File(directory + File.separator + product.getId()));
		
		for (FileMeta fm : files) {
			try {
				FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
						directory + File.separator + product.getId() + File.separator + fm.getFileName()));
				product.getPathPictures().add(fm.getFileName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
        productService.updatePrinter3D(product);
		
		ModelAndView mav = new ModelAndView("redirect:/admin/printers_3d"); 
		  mav.addObject("listProducts", productService.listPrinters3D());
		  files.clear();
	   return mav;
	}
	
    @RequestMapping(value="/admin/printer_3d/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {

         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String fileName = null;

         while(itr.hasNext()){

             mpf = request.getFile(itr.next()); 

             fileMeta = new FileMeta();
     		
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
    
    @RequestMapping(value="/admin/printer_3d/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    	for(int i = 0; i < selectedIds.size(); i++){
    		for(int k = 0; k < files.size() ; k++){
        		if(files.get(k).getFileName().equals(selectedIds.get(i))){
        			Collections.swap(files, i, k);
        			break;
        		}
        	}
    	}
    }
    
    @RequestMapping(value="/admin/printer_3d/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	String name = namePicture.replace(":", ".");
    		Iterator<FileMeta> fmi = files.iterator();
    		while(fmi.hasNext()){
        		if(fmi.next().getFileName().equals(name)){
        			fmi.remove();
        			break;
        		}
        	}	
    }
    
    @RequestMapping("/admin/printer_3d/remove/{id}")
    public String removePrinter(@PathVariable("id") long id){
    	
    		try {
				FileUtils.deleteDirectory(new File(directory + File.separator + id));
			} catch (IOException e) {
				e.printStackTrace();
			}
     	
        productService.removePrinter3D(id);
        return "redirect:/admin/printers_3d";
    }
}

