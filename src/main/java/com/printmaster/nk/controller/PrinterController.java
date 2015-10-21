package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.printmaster.nk.model.FileMeta;
import com.printmaster.nk.model.Picture;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.service.PictureService;
import com.printmaster.nk.service.PrinterService;

@Controller
public class PrinterController {
     
    private PrinterService printerService;
    private PictureService pictureService;
    private Picture picture;
    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;
    
    @Autowired(required=true)
    @Qualifier(value="printerService")
    public void setPrinterService(PrinterService ps){
        this.printerService = ps;
    }
    
	@ModelAttribute("typePrinter")
	public Map<String, String> typePrinter(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Сольвентный", "Сольвентный");
		m.put("Экосольвентный", "Экосольвентный");
		m.put("UV рулонный", "UV рулонный");
		m.put("UV плоскопечатный", "UV плоскопечатный");
		m.put("Сублимационный", "Сублимационный");
		m.put("Текстильный", "Текстильный");
		m.put("Водный/Пигментный", "Водный/Пигментный");
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
	
	@ModelAttribute("feeds")
	public Map<String, String> feeds(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Рулонный", "Рулонный");
		m.put("Плоскопечатный", "Плоскопечатный");
		m.put("Гибридный", "Гибридный");
		return m;
	}
	
	@ModelAttribute("sizeDrops")//размер капли
	public Map<String, String> sizeDrops(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("1,5", "1,5");
		m.put("2", "2");
		m.put("4", "4");
		m.put("8", "8");
		m.put("12", "12");
		m.put("15", "15");
		m.put("20", "20");
		m.put("30", "30");
		m.put("35", "35");
		m.put("40", "40");
		m.put("80", "80");
		return m;
	}
	
	@ModelAttribute("weightPrintMM")
	public Map<String, String> weightPrintMM(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("600", "600");
		m.put("900", "900");
		m.put("1070", "1070");
		m.put("1300", "1300");
		m.put("1600", "1600");
		m.put("1800", "1800");
		m.put("2500", "2500");
		m.put("2600", "2600");
		m.put("32000", "32000");
		m.put("50000", "50000");
		return m;
	}
	
	@ModelAttribute("typePrint")
	public Map<String, String> typePrint(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Термо-струйная", "Термо-струйная");
		m.put("Пьезо-струйная", "Пьезо-струйная");
		return m;
	}
	@ModelAttribute("chromaticity")
	public Map<String, String> chromaticity(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("CMYK", "CMYK");
		m.put("CMYKX 2", "CMYKX 2");
		m.put("CMYKLcLm", "CMYKLcLm");
		m.put("CMYKLcLmOG", "CMYKLcLmOG");
		return m;
	}
	@ModelAttribute("manufacturerPrinthead")
	public Map<String, String> manufacturerPrinthead(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Spectra", "Spectra");
		m.put("XAAR", "XAAR");
		m.put("SPT", "SPT");
		m.put("Konika-Minolta", "Konika-Minolta");
		m.put("Toshiba", "Toshiba");
		m.put("Ricoh", "Ricoh");
		m.put("Epson", "Epson");
		m.put("Lexmark", "Lexmark");
		return m;
	}
	
	@RequestMapping(value = "/printers", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
        model.addAttribute("listPrinters", this.printerService.listPrinters());
        return "admin/printers";
    }
	@RequestMapping(value = "/printer/new", method = RequestMethod.GET)
	public ModelAndView addNewPrinter() {
	    return new ModelAndView("admin/printer", "printer", new Printer());
	}
     
	@RequestMapping(value = "/printer/added", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(
			@RequestParam("files") MultipartFile[] request, @ModelAttribute Printer printer) throws IOException{
		
        if(printer.getId() == 0){
        	System.out.println("not exist!");
            //new printer, add it
            int id = this.printerService.addPrinter(printer);
            System.out.println(printer.getName());
            
            System.out.println("Id: " + id);
            if(new File("C:\\Users\\Николай\\Desktop\\f\\" + id).mkdir()){
            	
            }
            if(request!=null){
            for(MultipartFile mf: request){
            	try {
            		picture = new Picture();
            		// copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
            		int id_picture = this.pictureService.addPicture(new Picture());
            		picture.setId(id_picture);
            		System.out.println(mf.getOriginalFilename());
            		String fileExtension = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
            		
	                 FileCopyUtils.copy(mf.getBytes(), new FileOutputStream("C:/Users/Николай/Desktop/f/" + id 
	                		 + File.separator + id_picture + "" + fileExtension));
	                 
	                 picture.setTableAndId("printer_" + id);
	                 picture.setPathPicture(id_picture + "" + fileExtension);
	                 this.pictureService.updatePicture(picture);
            	} catch (IOException e) {
	                e.printStackTrace();
	            }
            }
           }
            files = new LinkedList<FileMeta>();
        }else{
        	System.out.println("update!!!!!");
        	 System.out.println(printer.getName());
            //existing printer, call update
            this.printerService.updatePrinter(printer);
        }
		
		ModelAndView mav = new ModelAndView("redirect:/printers"); 
		  mav.addObject("listPrinters", this.printerService.listPrinters());
		  mav.addObject("printer", printer);
	   return mav;
	}
	
    @RequestMapping("/printer/remove/{id}")
    public String removePrinter(@PathVariable("id") int id){
        this.printerService.removePrinter(id);
        return "redirect:/printers";
    }
  
    @RequestMapping("/printer/edit/{id}")
    public String editPrinter(@PathVariable("id") int id, Model model){
        model.addAttribute("printer", this.printerService.getPrinterById(id));
        model.addAttribute("listPrinters", this.printerService.listPrinters());
        return "admin/printer";
    }
    
    @RequestMapping("/product/printer/{id}")
    public String showPrinter(@PathVariable("id") int id, Model model){
        model.addAttribute("printer", this.printerService.getPrinterById(id));
        return "product_printer";
    }
    
	 @RequestMapping(value="printer/upload_pictures", method = RequestMethod.POST)
	    public @ResponseBody void upload(MultipartHttpServletRequest request, HttpServletResponse response) {
	 
	        //1. build an iterator
	         Iterator<String> itr =  request.getFileNames();
	         MultipartFile mpf = null;
	 
	         //2. get each file
	         while(itr.hasNext()){
	 
	             //2.1 get next MultipartFile
	             mpf = request.getFile(itr.next()); 
	             System.out.println(mpf.getOriginalFilename() +" uploaded! "+files.size());
	 
	             //2.3 create new fileMeta
	             fileMeta = new FileMeta();
	             fileMeta.setFileName(mpf.getOriginalFilename());
	             fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
	             fileMeta.setLength((int) (mpf.getSize()/1024));
	             fileMeta.setFileType(mpf.getContentType());
	 
	             try {
	                fileMeta.setBytes(mpf.getBytes());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	             //2.4 add to files
	             files.add(fileMeta);
	         }  
	    }
		@RequestMapping(value = "/printers/search", method = RequestMethod.GET)	
	    public String searchPrinters(Model model) {
	        model.addAttribute("listPrinters", this.printerService.listPrinters());
	        return "printer_search";
	    }
}
