package com.nk.printmaster.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.nk.printmaster.entities.Printer;
import com.nk.printmaster.hibernate.HibernateUtil;

@Controller
//@RequestMapping("/hello")
public class BaseController{
	
	private String saveDirectory = "C:/Users/Николай/Desktop/workspaceLinux/maven-web/src/main/webapp/resources/images/printers";
//	private String saveDirectory = request.getServletContext().getRealPath("/resources/images/printers") + "/";	
//	private ServletContext context;
//	private String saveDirectory = context.getContextPath() + File.separator + "resources/images/printers";
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
	    return new ModelAndView("home");
	}

	@RequestMapping(value = "/product", method = RequestMethod.POST) 
	public @ResponseBody ModelAndView handleFormUpload(HttpServletRequest request,
			@RequestParam("namePicture") String namePicture,
			@RequestParam("file") MultipartFile file, @ModelAttribute Printer printer) throws IOException{
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		List<Printer> printers = null;
		try{
			session.beginTransaction();
			
			Criteria criteria = session.createCriteria(Printer.class);
			criteria.add(Example.create(printer));
			printers = criteria.list();
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
		
		for(Printer p: printers){
			System.out.println(p.toString());
		}
		
		ModelAndView mav = new ModelAndView("product"); 
	if (!file.isEmpty()) {
	 BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
	 File destination = new File(saveDirectory + File.separator + file.getOriginalFilename()); // something like C:/Users/tom/Documents/nameBasedOnSomeId.png
	 
	 ImageIO.write(src, "png", destination);
	 //Save the id you have used to create the file name in the DB. You can retrieve the image in future with the ID. 
	 mav.addObject("image", src);
	 }   
	
	   mav.addObject("printer", printer);
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
		HibernateUtil.getSessionFactory();
		return "home";
	}

}
