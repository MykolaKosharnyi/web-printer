package com.printmaster.nk.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
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
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;

import com.printmaster.nk.model.FileMeta;
import com.printmaster.nk.model.Printer;
import com.printmaster.nk.service.PrinterService;

@Controller
public class PrinterController {
     
    private PrinterService printerService;
    LinkedList<FileMeta> files = new LinkedList<FileMeta>();
    FileMeta fileMeta = null;
    
    @Autowired(required=true)
    @Qualifier(value="printerService")
    public void setPrinterService(PrinterService ps){
        this.printerService = ps;
    }
    
	@ModelAttribute("feeds")
	public Map<String, String> feeds(){
		Map<String, String> m = new HashMap<String, String>();
		m.put("Рулонный", "Рулонный");
		m.put("Плоскопечатный", "Плоскопечатный");
		m.put("Гибридный", "Гибридный");
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
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute Printer printer) throws IOException{
		
        if(printer.getId() == 0){
        	System.out.println("not exist!");
            //new printer, add it
            this.printerService.addPrinter(printer);
            
            for(FileMeta mf: files){
            	try {
            		// copy file to local disk (make sure the path "e.g. D:/temp/files" exists)            
	                 FileCopyUtils.copy(mf.getBytes(), new FileOutputStream("C:/Users/Николай/Desktop/f/" + mf.getFileName()));
            	} catch (IOException e) {
	                e.printStackTrace();
	            }
            }
            files = new LinkedList<FileMeta>();
        }else{
        	System.out.println("update!!!!!");
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
        System.out.println(this.printerService.getPrinterById(id).getId());
        model.addAttribute("listPrinters", this.printerService.listPrinters());
        return "admin/printer";
    }
    
	 @RequestMapping(value="printer/upload_pictures", method = RequestMethod.POST)
	    public @ResponseBody void upload(
	    		  MultipartRequest request,
	    		 @RequestParam("file_name") String fileName,
				 @RequestParam("file_size") String fileSize,
				 @RequestParam("file_type") String fileType) {
	 
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
}
