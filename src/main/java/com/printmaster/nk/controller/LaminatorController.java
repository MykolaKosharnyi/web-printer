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

import com.printmaster.nk.beans.ComponetsForController;
import com.printmaster.nk.beans.FileMeta;
import com.printmaster.nk.beans.LinksForProducts;
import com.printmaster.nk.beans.PicturesContainer;
import com.printmaster.nk.model.Laminator;
import com.printmaster.nk.model.SearchLaminators;
import com.printmaster.nk.service.LaminatorService;
import com.printmaster.nk.service.UseWithProductService;

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
    
    private UseWithProductService useWithProductService;
	
	@Autowired(required=true)
    @Qualifier(value="useWithProductService")
    public void setUseWithProductService(UseWithProductService ps){
        this.useWithProductService = ps;
    }

	@RequestMapping(value = "/laminators", method = RequestMethod.GET)	
    public String allLaminators(Model model) {
        model.addAttribute("listProducts", componets.showSimplestArrayOfLaminator(this.laminatorService.listShowOnSite()));
        SearchLaminators search = new SearchLaminators();
        search.setPrise0(0);
        search.setPrise1(100000);
   
        model.addAttribute("search", search);
        model.addAttribute("type", "laminator");
        logger.info("On '../laminators' page.");
        
        componets.setJSONtoModelAttribute(model, "laminator");
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
        model.addAttribute("type", "laminator");
        
        componets.setJSONtoModelAttribute(model, "laminator");
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
        Laminator product = laminatorService.getLaminatorById(id);
        model.addAttribute("product", product);
        model.addAttribute("type", "laminator");
        if(product.getIdUseWithProduct()!=null){
        	model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(useWithProductService.getUseWithProductsByIds(product.getIdUseWithProduct())));
        } else {
        	model.addAttribute("uwp", null);
        }
        return "laminator";
    }
    
	@RequestMapping(value = "/admin/laminators", method = RequestMethod.GET)	
    public String listLaminators(Model model) {
		model.addAttribute("productType", "laminator");
		model.addAttribute("nameProduct", "Имя ламинатора");
		model.addAttribute("titleOfTable", "Список загруженных ламинаторов");
        model.addAttribute("listProducts", laminatorService.listLaminators("id"));
        model.addAttribute("title", "Ламинаторы");
        model.addAttribute("addProduct", "Добавить ламинатор");
        model.addAttribute("productSubType", "none");
        logger.info("/admin/laminators page.");
        return "admin/products";
    }
	
	@RequestMapping(value = "/admin/laminators/{type}", method = RequestMethod.GET)	
    public String listConcreteTypeLaminators(@PathVariable("type") String type, Model model) {
		
		List<Laminator> list = new ArrayList<Laminator>();
        if(type.equals("hot_lamination")){

        	for(Laminator laminator : laminatorService.listLaminators("id")){
        		if(laminator.getTypeProduct().equals("Горячего ламинирования")){
        			list.add(laminator);
        		}
        	}
        	model.addAttribute("productSubType", "hot_lamination");
        	model.addAttribute("titleOfTable", "Список загруженных ламинаторов горячего ламинирования");
            model.addAttribute("listProducts", list);
         
            logger.info("On /admin/laminators/hot_lamination page.");

    	} else if(type.equals("cold_laminating")){
        	
        	for(Laminator laminator : laminatorService.listLaminators("id")){
        		if(laminator.getTypeProduct().equals("Холодного ламинирования")){
        			list.add(laminator);
        		}
        	}
        	model.addAttribute("productSubType", "cold_laminating");
        	model.addAttribute("titleOfTable", "Список загруженных ламинаторов холодного ламинирования");
            model.addAttribute("listProducts", list);
            
            logger.info("On /admin/laminators/cold_laminating page.");
            
    	} else if(type.equals("liquid")){
        	
        	for(Laminator laminator : laminatorService.listLaminators("id")){
        		if(laminator.getTypeProduct().equals("Жидкостные")){
        			list.add(laminator);
        		}
        	}
        	model.addAttribute("productSubType", "liquid");
        	model.addAttribute("titleOfTable", "Список загруженных жидкостных ламинаторов");
            model.addAttribute("listProducts", list);

            logger.info("On /admin/laminators/liquid.");

    	} else if(type.equals("flatbed_laminating_machine")){
        	
        	for(Laminator laminator : laminatorService.listLaminators("id")){
        		if(laminator.getTypeProduct().equals("Планшетный ламинатор")){
        			list.add(laminator);
        		}
        	}
        	model.addAttribute("productSubType", "flatbed_laminating_machine");
        	model.addAttribute("titleOfTable", "Список загруженных планшетных ламинаторов");
            model.addAttribute("listProducts", list);
            
            logger.info("On /admin/laminators/flatbed_laminating_machine.");
    		
    	} else {
    		model.addAttribute("productSubType", "none");
    		model.addAttribute("titleOfTable", "Список загруженных ламинаторов");
            model.addAttribute("listProducts", laminatorService.listLaminators("id"));
    	}
        
		model.addAttribute("productType", "laminator");
		model.addAttribute("nameProduct", "Имя ламинатора");
        model.addAttribute("title", "Ламинаторы");
        model.addAttribute("addProduct", "Добавить ламинатор");
        
        return "admin/products";
    }
	
	@RequestMapping(value="/admin/laminator/{type}/sorting/{value}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody List<Laminator> sortingProductsInAdmin(@PathVariable("type") String type,@PathVariable("value") String value) {
		
		List<Laminator> list = new ArrayList<Laminator>();
        if(type.equals("hot_lamination")){

        	for(Laminator laminator : laminatorService.listLaminators(value)){
        		if(laminator.getTypeProduct().equals("Горячего ламинирования")){
        			list.add(laminator);
        		}
        	}
    	} else if(type.equals("cold_laminating")){
        	
        	for(Laminator laminator : laminatorService.listLaminators(value)){
        		if(laminator.getTypeProduct().equals("Холодного ламинирования")){
        			list.add(laminator);
        		}
        	}
    	} else if(type.equals("liquid")){
        	
        	for(Laminator laminator : laminatorService.listLaminators(value)){
        		if(laminator.getTypeProduct().equals("Жидкостные")){
        			list.add(laminator);
        		}
        	}
    	} else if(type.equals("flatbed_laminating_machine")){
        	
        	for(Laminator laminator : laminatorService.listLaminators(value)){
        		if(laminator.getTypeProduct().equals("Планшетный ламинатор")){
        			list.add(laminator);
        		}
        	}
    	} else {
    		list.addAll(laminatorService.listLaminators(value));
    	}

		return list;
    }
	
	@RequestMapping(value = "/admin/laminator/new", method = RequestMethod.GET)
	public String addNewLaminator(Model model) {
		files.clear();
		logger.info("/admin/laminator/new page.");
		model.addAttribute("product", new Laminator());
		model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		model.addAttribute("type", "laminator");
		model.addAttribute("productId", 0);
		componets.setJSONtoModelAttribute(model, "laminator");
	    return "admin/laminator";
	}
	
	@RequestMapping(value = "/admin/laminator/copy/{id}", method = RequestMethod.GET)
	public String copyLaminator(@PathVariable("id") long id, Model model) {
		files.clear();
		logger.info("/admin/laminator/copy/" + id + " page.");
		
		 logger.info("Copy all characteristic of laminator.");
		 Laminator laminator = laminatorService.getLaminatorById(id);
		 
		 /* copy pictures to buffer */
		 componets.copyPicturesToBuffer(laminator.getPathPictures(), directory, concreteFolder, id, files);
		
		 /* set null to id because we must get create new product operation */
	     laminator.setId(null);
		 model.addAttribute("product", laminator);
		 model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
		 model.addAttribute("type", "laminator");
		 model.addAttribute("productId", id);
		 
		 componets.setJSONtoModelAttribute(model, "laminator");
	    return "admin/laminator";
	}
     
	@RequestMapping(value = "/admin/laminator/add", method = RequestMethod.POST) 
	public String handleFormUpload(@ModelAttribute("product") @Valid  Laminator product,
			BindingResult result, Model model) throws IOException{
			
			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "laminator");
				componets.setJSONtoModelAttribute(model, "laminator");
	            return "admin/laminator";
	        }

            long id = laminatorService.addLaminator(product);
            logger.info("Create new laminator! With id=" + id);
  
            //create folder and add to her new files
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            this.laminatorService.updateLaminator(product);
            
            files.clear();
		  
		  links.createLinksForLaminators(laminatorService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laminator");

		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/laminators";
	}
	
	@RequestMapping(value = "/admin/laminator/save_add", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("product") @Valid Laminator product,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("product", product);
				model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
				model.addAttribute("type", "laminator");
				componets.setJSONtoModelAttribute(model, "laminator");
	            return "admin/laminator";
	        }
		
            long id = laminatorService.addLaminator(product);
            logger.info("Create new laminator! With id=" + id);
  
            //create folder and add to her new files
            product.getPathPictures().addAll(componets.createFolderAndWriteToItPictures(directory, concreteFolder, id, files));
			
            this.laminatorService.updateLaminator(product);
            
            files.clear(); 
		  
		  links.createLinksForLaminators(laminatorService.listShowOnSite());	
		  
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laminator");
	    	
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/laminator/edit/" + id;
	}
	
    @RequestMapping("/admin/laminator/edit/{id}")
    public String editLaminator(@PathVariable("id") long id, Model model){
    	logger.info("Begin editing laminator with id=" + id);
    	files.clear();
    	Laminator undateLaminator = laminatorService.getLaminatorById(id);
    	
        model.addAttribute("product", undateLaminator);
        model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
        model.addAttribute("type", "laminator");
        componets.setJSONtoModelAttribute(model, "laminator");
        return "admin/laminator";
    }
	
	@RequestMapping(value = "/admin/laminator/save_update", method = RequestMethod.POST) 
	public String updateSaveLaminator(@ModelAttribute("product") @Valid Laminator product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "laminator");
			componets.setJSONtoModelAttribute(model, "laminator");
            return "admin/laminator";
        }
		
		logger.info("Laminator UPDATE with save, id=" + product.getId());
		
		List<String> pathPictures = laminatorService.getLaminatorById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		laminatorService.updateLaminator(product);
        logger.info("laminator with id=" + product.getId() + " was UDPATED!");
		  
		links.createLinksForLaminators(laminatorService.listShowOnSite());
	
		if (product.isShowOnSite() && product.isShowOnLeftSide())
			componets.updateInLeftField(product, true, "laminator");
		  
		logger.info("Update links to the products in left menu!");
		return "redirect:/admin/laminator/edit/" + product.getId();
	}
	
	@RequestMapping(value = "/admin/laminator/update", method = RequestMethod.POST) 
	public String updateLaminator(@ModelAttribute("product") @Valid Laminator product,
			BindingResult result, Model model) throws IOException{
		
		if (result.hasErrors()) {
			model.addAttribute("product", product);
			model.addAttribute("uwp", componets.showSimplestArrayOfUseWithProduct(this.useWithProductService.listShowOnSite()));
			model.addAttribute("type", "laminator");
			componets.setJSONtoModelAttribute(model, "laminator");
            return "admin/laminator";
        }
		
		logger.info("Laminator UPDATE id=" + product.getId());
		
		List<String> pathPictures = laminatorService.getLaminatorById(product.getId()).getPathPictures();
		product.setPathPictures(pathPictures);
        
		laminatorService.updateLaminator(product);
        logger.info("laminator with id=" + product.getId() + " was UDPATED!");
        
		  files.clear();
		  
		  links.createLinksForLaminators(laminatorService.listShowOnSite());
	
		  if (product.isShowOnSite() && product.isShowOnLeftSide())
			  componets.updateInLeftField(product, true, "laminator");
		  
		  logger.info("Update links to the products in left menu!");
	   return "redirect:/admin/laminators";
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
    	componets.changeOrderPictures(concreteFolder, selectedIds, files);  	  	
    }
    
    @RequestMapping(value="/admin/laminator/remove_picture/{name_picture}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture) {
    	componets.removePicture(concreteFolder, namePicture, files);
    }
    
    @RequestMapping(value="/admin/laminator/upload_pictures_update/{id}", method = RequestMethod.POST)
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
        	 
 			Laminator product = laminatorService.getLaminatorById(id);
 			product.getPathPictures().add(fileName);
 			laminatorService.updateLaminator(product);
         }  
         return fileName;
    }
    
    @RequestMapping(value="/admin/laminator/change_order_pictures_update/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderPicturesUpdate(@RequestBody List<String> selectedIds, @PathVariable("id") long id) {
    	logger.info("change order of pictures in changed laminator product");
    	
    	Laminator product = laminatorService.getLaminatorById(id);
    	product.getPathPictures().clear();
    	product.getPathPictures().addAll(selectedIds);
    	laminatorService.updateLaminator(product);
    }
    
    @RequestMapping(value="/admin/laminator/remove_picture_update/{name_picture}/{id}", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removePicture(@PathVariable("name_picture") String namePicture, @PathVariable("id") long id) {
    	String name = namePicture.replace(":", ".");
    	Laminator product = laminatorService.getLaminatorById(id);
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
				logger.error("Can't update path of the default picture to laminator with id=" + product.getId(), e);
			}
			product.getPathPictures().add("default.jpg");
    	}
    	
    	laminatorService.updateLaminator(product);
    	
    	logger.info("Remove pictore with name = " + name + " from changed laminator product");
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
    
    @RequestMapping(value="/admin/laminator/setTop/{id}", method = RequestMethod.POST,consumes="application/json",headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void setTop(@PathVariable("id") long id, @RequestBody boolean value) {
    	Laminator laminator = laminatorService.getLaminatorById(id);
    	laminator.setTop(value);
    	laminatorService.updateLaminator(laminator);
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

