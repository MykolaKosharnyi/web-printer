package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
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
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Rip;
import com.printmaster.nk.model.SearchRips;
import com.printmaster.nk.service.RipService;

@Controller
public class RipController {
	
	private Logger logger = Logger.getLogger(RipController.class);
	
	private String directory = "/var/www/localhost/images";
	private String concreteFolder = "rips";

//	@Autowired
//	private LinksForProducts links;

    @Autowired
    PicturesContainer files;
    
    @Autowired
    ComponetsForController componets;
 
    private RipService ripService;
    
    @Autowired(required=true)
    @Qualifier(value="ripService")
    public void setRipService(RipService ps){
        this.ripService = ps;
    }
    
	@RequestMapping(value = "/rips", method = RequestMethod.GET)	
    public String allRips(Model model) throws UnsupportedEncodingException, FileNotFoundException, IOException, ParseException {
		
        model.addAttribute("listProducts", componets.showSimplestArrayOfRip(this.ripService.listShowOnSite()));
        SearchRips search = new SearchRips();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        logger.info("All characteristic of RIP.");
		model.addAttribute("rip", (JSONArray)new JSONParser().parse(new InputStreamReader(new FileInputStream("/var/www/localhost/images/rip.json"), "UTF-8")));
        
        model.addAttribute("search", search);
        logger.info("On '../rips' page.");
        return "rips";
    }

    @RequestMapping(value="/rips/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchRips(@ModelAttribute(value="search") SearchRips search, BindingResult result ){
    	logger.info("On the /rip/search page.");
    	return componets.showSimplestArrayOfRip(ripService.listSearchRips(search));
    }
	
    @RequestMapping("/rip/{id}")
    public String showRip(@PathVariable("id") long id, Model model){
    	logger.info("/rip/" + id + " page.");
        model.addAttribute("product", ripService.getRipById(id));
        return "rip";
    }
    
	@RequestMapping(value = "/admin/rips", method = RequestMethod.GET)	
    public String listRips(Model model) {
		model.addAttribute("productType", "rip");
		model.addAttribute("nameProduct", "Наименование ПО");
		model.addAttribute("titleOfTable", "Список загруженного ПО");
        model.addAttribute("listProducts", ripService.listRips());
        model.addAttribute("title", "ПО");
        model.addAttribute("addProduct", "Добавить новое ПО");
        logger.info("/admin/rips page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/rip/new", method = RequestMethod.GET)
	public String addNewRip(Model model) throws UnsupportedEncodingException, FileNotFoundException, IOException, ParseException {
		files.clear();
		logger.info("/admin/rip/new page.");
		model.addAttribute("product", new Rip());
		
		logger.info("All characteristic of RIP.");
		model.addAttribute("rip", (JSONArray)new JSONParser().parse(new InputStreamReader(new FileInputStream("/var/www/localhost/images/rip.json"), "UTF-8")));
	    return "admin/rip";
	}
     
	@RequestMapping(value = "/admin/rip/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute("product") @Valid Rip product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/rip", "product", product);
	        }
		
            long id = ripService.addRip(product);
            logger.info("Create new RIP! With id=" + id);

            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new rip directory! With id=" + id);
            } else {
            	logger.error("Don't create new rip directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to rip with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to rip with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the rip with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to rip with id=" + id, e);
				}
			}
			
            this.ripService.updateRip(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/rips"); 
		  mav.addObject("listProducts", ripService.listRips());
		  
		  //links.createLinksForRips(ripService.listShowOnSite());
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true);
	    	
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
	@RequestMapping(value = "/admin/rip/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid Rip product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/rip", "product", product);
	        }
		
            long id = ripService.addRip(product);
            logger.info("Create new rip! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new rip directory! With id=" + id);
            } else {
            	logger.error("Don't create new rip directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to rip with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to rip with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the rip with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to rip with id=" + id, e);
				}
			}
			
            this.ripService.updateRip(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/rip/edit/" + id); 
		  
		  //links.createLinksForRips(ripService.listShowOnSite());	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true);
	    	}
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
    @RequestMapping("/admin/rip/edit/{id}")
    public String editRip(@PathVariable("id") long id, Model model) throws UnsupportedEncodingException, FileNotFoundException, IOException, ParseException {
    	logger.info("Begin editing rip with id=" + id);
    	files.clear();
    	Rip undateRip = ripService.getRipById(id);
    	
    	FileMeta fm = null;
    	for(String path : undateRip.getPathPictures()){
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
        model.addAttribute("product", undateRip);
        
        logger.info("All characteristic of RIP.");
		model.addAttribute("rip", (JSONArray)new JSONParser().parse(new InputStreamReader(new FileInputStream("/var/www/localhost/images/rip.json"), "UTF-8")));
        return "admin/rip";
    }
	
	@RequestMapping(value = "/admin/rip/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSaveRip(@ModelAttribute("product") @Valid Rip product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/rip", "product", product);
        }
		
		logger.info("RIP UPDATE with save, id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to rip with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to rip with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the rip with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to rip with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
        ripService.updateRip(product);
        logger.info("rip with id=" + product.getId() + " was UDPATED!");
		  
		//links.createLinksForRips(ripService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide()){
			componets.updateInLeftField(product, true);
	    }
		  
		logger.info("Update links to the products in left menu!");
		ModelAndView mav = new ModelAndView("redirect:/admin/rip/edit/" + product.getId());
		return mav;
	}
	
	@RequestMapping(value = "/admin/rip/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateRip(@ModelAttribute("product") @Valid Rip product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/rip", "product", product);
        }
		
		logger.info("RIP UPDATE id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to rip with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to rip with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the rip with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to rip with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
        ripService.updateRip(product);
        logger.info("rip with id=" + product.getId() + " was UDPATED!");
        
		ModelAndView mav = new ModelAndView("redirect:/admin/rips"); 
		  mav.addObject("listProducts", ripService.listRips());
		  files.clear();
		  
		  //links.createLinksForRips(ripService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide()){
			  componets.updateInLeftField(product, true);
	    	}
		  
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
    @RequestMapping(value="/admin/rip/upload_pictures", method = RequestMethod.POST)
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
    
    @RequestMapping(value="/admin/rip/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
    
    @RequestMapping(value="/admin/rip/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
    
    @RequestMapping("/admin/rip/remove/{id}")
    public String removeRip(@PathVariable("id") long id){
    		logger.info("Start deleting rip from database, id=" + id);
    		try {
    			FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
    			logger.info("deleted all pictures and pictures directory of this rip");
			} catch (IOException e) {
				logger.error("Deleting all pictures from this rip has a problem: ", e);
			}
    		
    		logger.info("Update links to the products in left menu!");
    		
    		componets.updateInLeftField(ripService.getRipById(id), false);
    		
    		logger.info("DELETE rip with id=" + id + " from database!");
    		ripService.removeRip(id);
        
    		//links.createLinksForRips(ripService.listShowOnSite());
    		
        return "redirect:/admin/rips";
    }  
    
    @RequestMapping(value="/admin/rip/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Rip rip = ripService.getRipById(id);
    	rip.setShowOnSite(value);
    	ripService.updateRip(rip);
    	
    	if (rip.isShowOnSite() && rip.isShowOnLeftSide()){
    		componets.updateInLeftField(rip, true);
    	} else {
    		componets.updateInLeftField(rip, false);
    	}
    	
    	//links.createLinksForRips(ripService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/rip/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Rip rip = ripService.getRipById(id);
    	rip.setShowOnHomePage(value);
    	ripService.updateRip(rip);
    }
    
    @RequestMapping(value="/admin/rip/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Rip rip = ripService.getRipById(id);
    	rip.setShowOnLeftSide(value);
    	ripService.updateRip(rip);
    	
    	if (rip.isShowOnSite() && rip.isShowOnLeftSide()){
    		componets.updateInLeftField(rip, true);
    	} else {
    		componets.updateInLeftField(rip, false);
    	}
    		
    }
}
