package com.nk.printmaster.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nk.printmaster.entities.Printer;

@Controller
//@RequestMapping("/hello")
public class BaseController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
	    ModelAndView mav = new ModelAndView("home"); 
	    return mav;
	}
	
	@RequestMapping(value = "/admin/add_printer", method = RequestMethod.GET)
	public ModelAndView addNewPrinter() {
	    ModelAndView mav = new ModelAndView("addPrinter"); 
	    return mav;
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST) 
	public ModelAndView handleFormUpload(@RequestParam("file") MultipartFile file, 
										 @ModelAttribute("printer") Printer printer) throws IOException{
		
		ModelAndView mav = new ModelAndView("product"); 
		
	if (!file.isEmpty()) {
	 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	 File destination = new File("/resources/images/printers"); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
	 ImageIO.write(src, "png", destination);
	 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID. 
	 mav.addObject("image", src);
	 }   
	   return mav;
	} 

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", name);
		return "hello";

	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model){
		model.addAttribute("message", "Hello Spring WEB MVC!");
		return "hello";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index1(ModelMap model){
		return "home";
	}
	
}
