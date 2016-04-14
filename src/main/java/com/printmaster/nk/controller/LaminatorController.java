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
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.model.SearchLaminators;
import com.printmaster.nk.service.LaminatorService;

@Controller
public class LaminatorController {
	
	private Logger logger = Logger.getLogger(LaminatorController.class);
	
	private String directory = "/var/www/localhost/images";

	private String concreteFolder = "laminators";
	
	@Autowired
	private LinksForProducts links;
	
	@Autowired
    ComponetsForController componets;

    @Autowired
    PicturesContainer files;
 
    private LaminatorService laminatorService;
    
    @Autowired(required=true)
    @Qualifier(value="laminatorService")
    public void setPrinterService(LaminatorService ps){
        this.laminatorService = ps;
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
		m.put("Горячего ламинирования", "Горячего ламинирования");
		m.put("Холодного ламинирования", "Холодного ламинирования");
		m.put("Жидкостные", "Жидкостные");
		m.put("Планшетный ламинатор", "Планшетный ламинатор");
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
	
	@ModelAttribute("innings")
	public Map<String, String> typeEngine(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Рулонный", "Рулонный");
		m.put("Плоскопечатный", "Плоскопечатный");
		m.put("Гибридный", "Гибридный");
		return m;
	}
	
	@ModelAttribute("laminatingWidth")
	public Map<String, String> laminatingWidth(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("305", "305");
		m.put("457", "457");
		m.put("610", "610");
		m.put("914", "914");
		m.put("1070", "1070");
		m.put("1118", "1118");
		m.put("1524", "1524");
		m.put("1550", "1550");
		m.put("1600", "1600");
		return m;
	}
	
	@ModelAttribute("equipmentManufacturer")
	public Map<String, String> equipmentManufacturer(){
		Map<String, String> m = new LinkedHashMap<String, String>();
		m.put("Kala", "Kala");
		m.put("Royal Sovereign", "Royal Sovereign");
		m.put("GMP", "GMP");
		m.put("Champion", "Champion");
		m.put("Aurora", "Aurora");
		m.put("GBC", "GBC");
		m.put("HF FGK", "HF FGK");
		m.put("Yingkai", "Yingkai");
		return m;
	}

	
	@RequestMapping(value = "/laminators", method = RequestMethod.GET)	
    public String allLaminators(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfLaminator(this.laminatorService.listShowOnSite()));
        SearchLaminators search = new SearchLaminators();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        logger.info("On '../laminators' page.");
        return "laminators";
    }
	
	@RequestMapping(value = "/laminators/{type}", method = RequestMethod.GET)	
    public String typeLaminators(@PathVariable("type") String type, Model model) {
        SearchLaminators search = new SearchLaminators();
        String currentType = null;
        
        	if(type.equals("hot_lamination")){
        		currentType = "Горячего ламинирования";
        		logger.info("On the /laminator/" + type + " page.");
        		
        	} else if(type.equals("cold_laminating")){
        		currentType = "Холодного ламинирования";
        		logger.info("On the /laminator/" + type + " page.");
        		
        	} else if(type.equals("liquid")){
        		currentType = "Жидкостные";
        		logger.info("On the /laminator/" + type + " page.");
        		
        	} else if(type.equals("flatbed_laminating_machine")){
        		currentType = "Планшетный ламинатор";
        		logger.info("On the /laminator/" + type + " page.");
        		
        	} else {
        		return "redirect:/";
        	}
        	
        String[] a = {currentType};
        search.setTypeProduct(a);
        search.setPrise0(0);
        search.setPrise1(100000);
        model.addAttribute("search", search);
        model.addAttribute("listProducts", componets.showSimplestArrayOfLaminator(laminatorService.listSearchLaminators(search)));
        return "laminators/" + type ;
    }

    @RequestMapping(value="/laminators/search",method=RequestMethod.POST, produces = "application/json; charset=utf-8")
    public @ResponseBody ArrayList<JSONObject> showSearchLaminators(@ModelAttribute(value="search") SearchLaminators search, BindingResult result ){
    	logger.info("On the /laminator/search page.");
    	return componets.showSimplestArrayOfLaminator(laminatorService.listSearchLaminators(search));
    }
	
    @RequestMapping("/laminator/{id}")
    public String showLaminator(@PathVariable("id") long id, Model model){
    	logger.info("/laminator/" + id + " page.");
        model.addAttribute("product", laminatorService.getLaminatorById(id));
        return "laminator";
    }
    
	@RequestMapping(value = "/admin/laminators", method = RequestMethod.GET)	
    public String listLaminators(Model model) {
		model.addAttribute("productType", "laminator");
		model.addAttribute("nameProduct", "Имя ламинатора");
		model.addAttribute("titleOfTable", "Список загруженных ламинаторов");
        model.addAttribute("listProducts", laminatorService.listLaminators());
        model.addAttribute("title", "Ламинаторы");
        model.addAttribute("addProduct", "Добавить ламинатор");
        logger.info("/admin/laminators page.");
        return "admin/laminators";
    }
	
	@RequestMapping(value = "/admin/laminators/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeLaminators(@PathVariable("type") String type, Model model) {
		
        if(type.equals("hot_lamination")){
        	List<Laminator> list = new ArrayList<Laminator>();
        	
        	for(Laminator laminator : laminatorService.listLaminators()){
        		if(laminator.getTypeProduct().equals("Горячего ламинирования")){
        			list.add(laminator);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных ламинаторов горячего ламинирования");
            model.addAttribute("listProducts", list);
         
    		model.addAttribute("productType", "laminator");
    		model.addAttribute("nameProduct", "Имя ламинатора");
            model.addAttribute("title", "Ламинаторы");
            model.addAttribute("addProduct", "Добавить ламинатор");
            logger.info("On /admin/laminators/hot_lamination page.");
            
            return "admin/laminators";
    		
    	} else if(type.equals("cold_laminating")){
    		List<Laminator> list = new ArrayList<Laminator>();
        	
        	for(Laminator laminator : laminatorService.listLaminators()){
        		if(laminator.getTypeProduct().equals("Холодного ламинирования")){
        			list.add(laminator);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных ламинаторов холодного ламинирования");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "laminator");
    		model.addAttribute("nameProduct", "Имя ламинатора");
            model.addAttribute("title", "Ламинаторы");
            model.addAttribute("addProduct", "Добавить ламинатор");
            logger.info("On /admin/laminators/cold_laminating page.");
            
            return "admin/laminators";
            
    	} else if(type.equals("liquid")){
    		List<Laminator> list = new ArrayList<Laminator>();
        	
        	for(Laminator laminator : laminatorService.listLaminators()){
        		if(laminator.getTypeProduct().equals("Жидкостные")){
        			list.add(laminator);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных жидкостных ламинаторов");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "laminator");
    		model.addAttribute("nameProduct", "Имя ламинатора");
            model.addAttribute("title", "Ламинаторы");
            model.addAttribute("addProduct", "Добавить ламинатор");
            logger.info("On /admin/laminators/liquid.");
            
            return "admin/laminators";
             		
    	} else if(type.equals("flatbed_laminating_machine")){
    		List<Laminator> list = new ArrayList<Laminator>();
        	
        	for(Laminator laminator : laminatorService.listLaminators()){
        		if(laminator.getTypeProduct().equals("Планшетный ламинатор")){
        			list.add(laminator);
        		}
        	}
        	
        	model.addAttribute("titleOfTable", "Список загруженных планшетных ламинаторов");
            model.addAttribute("listProducts", list);
            
            model.addAttribute("productType", "laminator");
    		model.addAttribute("nameProduct", "Имя ламинатора");
            model.addAttribute("title", "Ламинаторы");
            model.addAttribute("addProduct", "Добавить ламинатор");
            logger.info("On /admin/laminators/flatbed_laminating_machine.");
            
            return "admin/laminators";
    		
    	} else {
    		model.addAttribute("productType", "laminator");
    		model.addAttribute("nameProduct", "Имя ламинатора");
    		model.addAttribute("titleOfTable", "Список загруженных ламинаторов");
            model.addAttribute("listProducts", laminatorService.listLaminators());
            model.addAttribute("title", "Ламинаторы");
            model.addAttribute("addProduct", "Добавить ламинатор");
            logger.info("/admin/laminators page.");
            return "admin/laminators";
    	}
    }
	
	@RequestMapping(value = "/admin/laminator/new", method = RequestMethod.GET)
	public ModelAndView addNewLaminator() {
		files.clear();
		logger.info("/admin/laminator/new page.");
	    return new ModelAndView("admin/laminator", "product", new Laminator());
	}
     
	@RequestMapping(value = "/admin/laminator/add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(@ModelAttribute("product") @Valid  Laminator product,
			BindingResult result) throws IOException{
			
			if (result.hasErrors()) {
	            return new ModelAndView("admin/laminator", "product", product);
	        }

            long id = laminatorService.addLaminator(product);
            logger.info("Create new laminator! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	System.out.println("Создано новую директорию!" + id);
            	logger.info("Create new laminator directory! With id=" + id);
            } else {
            	logger.error("Don't create new laminator directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to laminator with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to laminator with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the laminator with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to laminator with id=" + id, e);
				}
			}
			
            this.laminatorService.updateLaminator(product);
            
            files.clear();
		
          ModelAndView mav = new ModelAndView("redirect:/admin/laminators"); 
		  mav.addObject("listProducts", laminatorService.listLaminators());
		  
		  links.createLinksForLaminators(laminatorService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laminator");

		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
	@RequestMapping(value = "/admin/laminator/save_add", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUploadSave(@ModelAttribute("product") @Valid Laminator product,
			BindingResult result) throws IOException{

			if (result.hasErrors()) {
	            return new ModelAndView("admin/laminator", "product", product);
	        }
		
            long id = laminatorService.addLaminator(product);
            logger.info("Create new laminator! With id=" + id);
  
            if(new File(directory + File.separator + 
            		concreteFolder + File.separator + id).mkdir()){
            	logger.info("Create new laminator directory! With id=" + id);
            } else {
            	logger.error("Don't create new laminator directory!");
            }
            
			if (files != null && files.size()!=0) {
				for (FileMeta fm : files.getFiles()) {
					try {
						FileCopyUtils.copy(fm.getBytes(), new FileOutputStream(
								directory + File.separator + concreteFolder
			    				+ File.separator + id + File.separator + fm.getFileName()));
						product.getPathPictures().add(fm.getFileName());
						logger.info("Add path of the pictures to laminator with id=" + id);
					} catch (IOException e) {
						logger.error("Can't add paths of the pictures to laminator with id=" + id, e);
					}
				}
			} else {
	    		try {
	    			File fi = new File(directory + File.separator + "default.jpg");
        			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(directory + File.separator + 
        					concreteFolder + File.separator + id + File.separator + "default.jpg"));
	    			product.getPathPictures().add("default.jpg");
	    			logger.error("User didn't add any picture to the laminator with id=" + id + ", so picture of the"
	    					+ "product will has name 'default.jpg' ");
				} catch (IOException e) {
					logger.error("Can't add path of the default picture to laminator with id=" + id, e);
				}
			}
			
            this.laminatorService.updateLaminator(product);
            
            files.clear(); 
		  
		  links.createLinksForLaminators(laminatorService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laminator");
	    	
		  logger.info("Update links to the products in left menu!");
	   return new ModelAndView("redirect:/admin/laminator/edit/" + id);
	}
	
    @RequestMapping("/admin/laminator/edit/{id}")
    public String editLaminator(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing laminator with id=" + id);
    	files.clear();
    	Laminator undateLaminator = laminatorService.getLaminatorById(id);
    	
    	FileMeta fm = null;
    	for(String path : undateLaminator.getPathPictures()){
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
        model.addAttribute("product", undateLaminator);
        return "admin/laminator";
    }
	
	@RequestMapping(value = "/admin/laminator/save_update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateSaveLaminator(@ModelAttribute("product") @Valid Laminator product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/laminator", "product", product);
        }
		
		logger.info("Laminator UPDATE with save, id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to laminator with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to laminator with id=" + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the laminator with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to laminator with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
		laminatorService.updateLaminator(product);
        logger.info("laminator with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForLaminators(laminatorService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, "laminator");
		  
		logger.info("Update links to the products in left menu!");
		ModelAndView mav = new ModelAndView("redirect:/admin/laminator/edit/" + product.getId());
		return mav;
	}
	
	@RequestMapping(value = "/admin/laminator/update", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView updateLaminator(@ModelAttribute("product") @Valid Laminator product,
			BindingResult result) throws IOException{
		
		if (result.hasErrors()) {
            return new ModelAndView("admin/laminator", "product", product);
        }
		
		logger.info("Laminator UPDATE id=" + product.getId());
		
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
					logger.info("Updatepath of the pictures to laminator with id=" + product.getId());
				} catch (IOException e) {
					logger.error("Can't UDDATE paths of the pictures to laminator with id = " + product.getId(), e);
				}
			}
		} else {
    		try {
    			File fi = new File(directory + File.separator + "default.jpg");
    			FileCopyUtils.copy(Files.readAllBytes(fi.toPath()), new FileOutputStream(
						directory + File.separator + 
    					concreteFolder + File.separator + product.getId() + File.separator + "default.jpg"));
    			product.getPathPictures().add("default.jpg");
    			logger.error("User didn't UPDATE any picture to the laminator with id=" + product.getId() + ", so picture of the"
    					+ "product will has name 'default.jpg' ");
			} catch (IOException e) {
				logger.error("Can't update path of the default picture to laminator with id=" + product.getId(), e);
			}
		}
		logger.info("UPDATE pictures was done susseccful!");
        
		laminatorService.updateLaminator(product);
        logger.info("laminator with id=" + product.getId() + " was UDPATED!");
        
		ModelAndView mav = new ModelAndView("redirect:/admin/laminators"); 
		  mav.addObject("listProducts", laminatorService.listLaminators());
		  files.clear();
		  
		  links.createLinksForLaminators(laminatorService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laminator");
		  
		  logger.info("Update links to the products in left menu!");
	   return mav;
	}
	
    @RequestMapping(value="/admin/laminator/upload_pictures", method = RequestMethod.POST)
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
    
    @RequestMapping(value="/admin/laminator/change_order_pictures", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
    
    @RequestMapping(value="/admin/laminator/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
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
    
    @RequestMapping("/admin/laminator/remove/{id}")
    public String removeLaminator(@PathVariable("id") long id){
    		logger.info("Start deleting laminator from database, id=" + id);
    		try {
    			FileUtils.deleteDirectory(new File(directory + File.separator + 
						concreteFolder + File.separator + id));
    			logger.info("deleted all pictures and pictures directory of this laminator");
			} catch (IOException e) {
				logger.error("Deleting all pictures from this laminator has a problem: ", e);
			}
    		
    		logger.info("Update links to the products in left menu!");
    		componets.updateInLeftField(laminatorService.getLaminatorById(id), false, "laminator");
    		
    		logger.info("DELETE laminator with id=" + id + " from database!");
    		laminatorService.removeLaminator(id);
        
    		links.createLinksForLaminators(laminatorService.listShowOnSite());
    		
        return "redirect:/admin/laminators";
    }  
    
    @RequestMapping(value="/admin/laminator/showOnSite/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnSite(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laminator laminator = laminatorService.getLaminatorById(id);
    	laminator.setShowOnSite(value);
    	laminatorService.updateLaminator(laminator);
    	
    	if (laminator.isShowOnSite() && laminator.isShowOnLeftSide()){
    		componets.updateInLeftField(laminator, true, "laminator");
    	} else {
    		componets.updateInLeftField(laminator, false, "laminator");
    	}
    	
    	links.createLinksForLaminators(laminatorService.listShowOnSite());
    }
    
    @RequestMapping(value="/admin/laminator/showOnHomePage/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnHomePage(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laminator laminator = laminatorService.getLaminatorById(id);
    	laminator.setShowOnHomePage(value);
    	laminatorService.updateLaminator(laminator);
    }
    
    @RequestMapping(value="/admin/laminator/showOnLeftSide/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void showOnLeftSide(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laminator laminator = laminatorService.getLaminatorById(id);
    	laminator.setShowOnLeftSide(value);
    	laminatorService.updateLaminator(laminator);
    	
    	if (laminator.isShowOnSite() && laminator.isShowOnLeftSide()){
    		componets.updateInLeftField(laminator, true, "laminator");
    	} else {
    		componets.updateInLeftField(laminator, false, "laminator");
    	}
    		
    }
}

