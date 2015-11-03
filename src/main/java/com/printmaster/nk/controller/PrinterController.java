package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

//import javax.servlet.ServletContext;

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
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.model.SearchPrinters;
import com.printmaster.nk.service.PrinterService;

@Controller
public class PrinterController {
	
//	@Autowired
//	ServletContext servletContext; 
	
    private PrinterService printerService;

    LinkedHashMap<String, FileMeta> files = new LinkedHashMap<String, FileMeta>();
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
	
	@ModelAttribute("compatibleInk")
	public Map<String, String> compatibleInk(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Водные", "Водные");
		m.put("Пигментные", "Пигментные");
		m.put("Сублимационные", "Сублимационные");
		m.put("Экосольвентные", "Экосольвентные");
		m.put("Сольвентные", "Сольвентные");
		m.put("UV-чернила", "UV-чернила");
		return m;
	}
	
	@ModelAttribute("typeDrops")
	public Map<String, String> typeDrops(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Постоянная", "Постоянная");
		m.put("Переменная", "Переменная");
		return m;
	}
	
	@ModelAttribute("printResolution")
	public Map<String, String> printResolution(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("360dpi", "360dpi");
		m.put("600dpi", "600dpi");
		m.put("720dpi", "720dpi");
		m.put("1200dpi", "1200dpi");
		m.put("1440dpi", "1440dpi");
		m.put("2880dpi", "2880dpi");
		return m;
	}
	
	@ModelAttribute("equipmentManufacturer")
	public Map<String, String> equipmentManufacturer(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Mimaki", "Mimaki");
		m.put("Roland", "Roland");
		m.put("HP", "HP");
		m.put("OCE", "OCE");
		m.put("Agfa", "Agfa");
		m.put("LIYU", "LIYU");
		m.put("Infinity", "Infinity");
		m.put("Gonzeng", "Gonzeng");
		m.put("Jong Ye", "Jong Ye");
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
	
	@ModelAttribute("rip")
	public Map<String, String> rip(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("ONYX Graphics", "ONYX Graphics");
		m.put("SA International/PhotoPRINT™ Family", "SA International/PhotoPRINT™ Family");
		m.put("Wasatch SOFTRIP", "Wasatch SOFTRIP");
		m.put("ColorGATE Productionserver", "ColorGATE Productionserver");
		m.put("Poster Print", "Poster Print");
		return m;
	}
	
	@ModelAttribute("typeOfPrinthead")
	public Map<String, String> typeOfPrinthead(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Nova 256", "Nova 256");
		m.put("Galaxy 256", "Galaxy 256");
		m.put("Polyaris 512", "Polyaris 512");
		m.put("126/50", "126/50");
		m.put("126/80", "126/80");
		m.put("128/40", "128/40");
		m.put("128/80", "128/80");
		m.put("255", "255");
		m.put("256", "256");
		m.put("500", "500");
		m.put("510", "510");
		m.put("512", "512");
		m.put("512KN", "512KN");
		m.put("1020", "1020");
		m.put("1024", "1024");
		m.put("1024I", "1024I");
		m.put("CA3", "CA3");
		m.put("CA4", "CA4");
		m.put("Gen4", "Gen4");
		m.put("Gen5", "Gen5");
		m.put("DX2", "DX2");
		m.put("DX4", "DX4");
		m.put("DX5", "DX5");
		m.put("DX6", "DX6");
		m.put("DX7", "DX7");
		return m;
	}
	
	@RequestMapping(value = "/printers/search", method = RequestMethod.GET)	
    public String searchPrinters(Model model) {
        model.addAttribute("listPrinters", this.printerService.listPrinters());
        SearchPrinters sp = new SearchPrinters();
        sp.setPrise0(0);
        sp.setPrise1(50000);
        model.addAttribute("search", sp);
        return "printers";
    }
	
//	@RequestMapping(value = "/printers/search", method = RequestMethod.POST)	
//    public ModelAndView searchingPrinters(Model model, @ModelAttribute("search") SearchPrinters searchPrintersCriteria) {
//		System.out.println(searchPrintersCriteria.toString());
//		System.out.println(searchPrintersCriteria.getPrise1());
//        //model.addAttribute("listPrinters", this.printerService.listSearchPrinters(searchPrintersCriteria));
//        //model.addAttribute("searchPrintersCriteria", searchPrintersCriteria);
//		ModelAndView mav = new ModelAndView("printers"); 
//		mav.addObject("listPrinters", this.printerService.listSearchPrinters(searchPrintersCriteria));
////		mav.addObject("listPrinters", this.printerService.listPrinters());
//		mav.addObject("search", searchPrintersCriteria);
//        return mav;
//    }

    @RequestMapping(value="/printers/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody Set<Printer> addUser(@ModelAttribute(value="search") SearchPrinters search, BindingResult result ){
        String returnText;
        if(!result.hasErrors()){
            returnText = "  Запрос виконано успішно!!! ";
            System.out.println(search.toString());
        }else{
            returnText = "Sorry, an error has occur. User has not been added to list.";
        }
        return printerService.listSearchPrinters(search);
    }
	
	
//	@RequestMapping(value = "/printers/search", method = RequestMethod.POST)	
//    public @ResponseBody Set<Printer> searchingPrinters(@RequestParam("prise0") String prise0,
//    		@RequestParam("prise1") String prise1) {
//		SearchPrinters searchPrintersCriteria = new SearchPrinters();
//		searchPrintersCriteria.setPrise0(Integer.parseInt(prise0));
//		searchPrintersCriteria.setPrise1(Integer.parseInt(prise1));
//        return null;
//    }
	
    @RequestMapping("/printer/{id}")
    public String showPrinter(@PathVariable("id") int id, Model model){
    	System.out.println("Id: " + id);
        model.addAttribute("printer", printerService.getPrinterById(id));
        return "printer";
    }
    
	@RequestMapping(value = "/admin/printers", method = RequestMethod.GET)	
    public String listPrinters(Model model) {
        model.addAttribute("listPrinters", this.printerService.listPrinters());
        return "admin/printers";
    }
	
	@RequestMapping(value = "/admin/printer/new", method = RequestMethod.GET)
	public ModelAndView addNewPrinter() {
		files.clear();
	    return new ModelAndView("admin/printer", "printer", new Printer());
	}
     
	@RequestMapping(value = "/printer/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(/*
			@RequestParam("files") MultipartFile[] request, */@ModelAttribute Printer printer) throws IOException{
		
        if(printer.getId() == 0){
            int id = this.printerService.addPrinter(printer);
  
//            String phyPath = servletContext.getRealPath("/");

            String myPath = "C:/Users/Николай/Desktop/work/print-master/src/main/webapp/resources/images/printers";
            if(new File(myPath + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            } else {
            	System.out.println("Не создано новую директорию :(");
            }
            
			if (files != null) {
				for (final Map.Entry<String, FileMeta> entry : files.entrySet()) {
					try {
						FileCopyUtils.copy(entry.getValue().getBytes(), new FileOutputStream(
								myPath + File.separator + id + File.separator + entry.getValue().getFileName()));
						printer.getPathPictures().add(entry.getKey());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
            this.printerService.updatePrinter(printer);
            files.clear();
        }else{
        	System.out.println("update!!!!!");
        	System.out.println(printer.getId());
            //existing printer, call update
            this.printerService.updatePrinter(printer);
        }
		
		ModelAndView mav = new ModelAndView("redirect:/admin/printers"); 
		  mav.addObject("listPrinters", this.printerService.listPrinters());
		  mav.addObject("printer", printer);
	   return mav;
	}
	
    @RequestMapping(value="/admin/printer/upload_pictures", method = RequestMethod.POST)
    public @ResponseBody String uploadPictures(MultipartHttpServletRequest request) {
 
        //1. build an iterator
         Iterator<String> itr =  request.getFileNames();
         MultipartFile mpf = null;
         String fileName = null;
         
         //2. get each file
         while(itr.hasNext()){
 
             //2.1 get next MultipartFile
             mpf = request.getFile(itr.next()); 
             System.out.println(mpf.getOriginalFilename() +" uploaded! " + files.size());
 
             //2.3 create new fileMeta
             fileMeta = new FileMeta();
     		
     		 fileName = (1 + files.size()) + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."))/*second part is file extension*/; 
             fileMeta.setFileName(fileName);
             
             fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
             fileMeta.setLength((int) (mpf.getSize()/1024));
             fileMeta.setFileType(mpf.getContentType());
 
             try {
                fileMeta.setBytes(mpf.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
             //2.4 add to files
             System.out.println("Добавлено: " + fileMeta.getFileName());
             files.put(fileMeta.getFileName(),fileMeta);
         }  
         return fileName;
    }
    @RequestMapping(value="/admin/printer/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPictures(@RequestBody List<String> selectedIds) {
    //	for(String s : selectedIds){
    	for(int i=0; i < selectedIds.size(); i++){
    		//System.out.println("Значение: " + s);
    		Collections.swap(files, i, files.);
    	}
    	System.out.println("-----------------");
    	
    }
    
    @RequestMapping("/admin/printer/remove/{id}")
    public String removePrinter(@PathVariable("id") int id){
        this.printerService.removePrinter(id);
        return "redirect:/printers";
    }
  
    @RequestMapping("/admin/printer/edit/{id}")
    public String editPrinter(@PathVariable("id") int id, Model model){
    	files.clear();
        model.addAttribute("printer", this.printerService.getPrinterById(id));
        model.addAttribute("listPrinters", this.printerService.listPrinters());
        return "admin/printer";
    }
    
    @RequestMapping("/test")
    public String test(Model model){
    	model.addAttribute("searchPrintersCriteria", new SearchPrinters());
        return "test";
    }
}
