package com.printmaster.nk.controller;

import static com.printmaster.nk.controller.ControllerConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.printmaster.nk.beans.ComponentsForControllers;
import com.printmaster.nk.model.User;
import com.printmaster.nk.service.UserService;
import com.printmaster.nk.service.user.SecurityService;
import com.printmaster.nk.validator.UserValidator;

@Controller
public class UserController {
	
	private static final String DIRECTORY = "/var/www/localhost/images";
	private static final String TYPE = "user";
	private static final String CONCRETE_FOLDER = "users";
	
	@Autowired
    private MailSender mailSender;
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
	@Autowired
    ComponentsForControllers componets;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) {
    	model.addAttribute("user", getUser());
        return "user";
    }
	
	private User getUser(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	String username = null;
    	if (principal instanceof UserDetails) {
    		username = ((UserDetails)principal).getUsername();
    	} else {
    		username = (String) principal;
    	}
    	return userService.findByUserName(username);
	}
	
	@RequestMapping(value="/ask/product", method = RequestMethod.POST, consumes="application/json",
			headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void askProductPage(HttpServletRequest request) {

        String recipientAddress = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
         
        // sends the e-mail
        mailSender.send(email);

    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
    	model.addAttribute("userForm", new User());
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
	
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }
	
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        String password = userForm.getPassword();
        long id = userService.save(userForm);

        securityService.autologin(userForm.getUsername(), password);
        
        //create folder on service for keeping user's pictures
        componets.createDirectoryForPictures(DIRECTORY, CONCRETE_FOLDER, id);
        
        return "redirect:/user";
    }
    
  //for 403 access denied page
  	@RequestMapping(value = "/403", method = RequestMethod.GET)
  	public ModelAndView accesssDenied() {

  	  ModelAndView model = new ModelAndView();
  	  
  	  //check if user is login
  	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  	  if (!(auth instanceof AnonymousAuthenticationToken)) {
  		Object principal = auth.getPrincipal();
  		String username = null;
  		if (principal instanceof UserDetails) {
  			username = ((UserDetails)principal).getUsername();
  		} else {
  			username = (String) principal;
  		}
  		 
  		model.addObject("username", username);
  	  }
  		
  	  model.setViewName("403");
  	  return model;
  	}
  	
    @RequestMapping(value="/upload_new_picture/user/{id}", method = RequestMethod.POST)
    public @ResponseBody void uploadPicturesUpdate(MultipartHttpServletRequest request, @PathVariable("id") long id) {
    	
 		User user = userService.getUserById(id);
 		
 		//delete old picture
 		String oldPicture = user.getNameUserPicture();
 		if (oldPicture != null && !oldPicture.isEmpty()) {
 			componets.removePicture(user.getNameUserPicture(), DIRECTORY, CONCRETE_FOLDER, id);
 		}
 		
 		//load and set new picture
 		String nameOfAddedPicture = componets.uploadPictureToExistedProduct(request, DIRECTORY, CONCRETE_FOLDER, id);
 		user.setNameUserPicture(nameOfAddedPicture);
 		userService.updateUser(user);
    }

	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"s", method = RequestMethod.GET)
	public String getAllUsersOnAdmin(Model model) {
		model.addAttribute("userList", userService.listUsers());
	    return PATH_ADMIN + "/"+ TYPE + "s";
	}
	
	@RequestMapping(value = "/user/subscription", method = RequestMethod.GET)
	public String subscriptionGET(Model model) {
		List<String> listSubscription = new ArrayList<>();
		listSubscription.add("принтеры");
		listSubscription.add("3Д принтеры");
		listSubscription.add("цифровое оборудование");
		listSubscription.add("ламинаторы");
		listSubscription.add("лазеры");
		listSubscription.add("фрезеры");
		listSubscription.add("сканеры");
		listSubscription.add("б/у оборудование");
		listSubscription.add("ПО");
		listSubscription.add("сопутствующие товары");
		
		model.addAttribute("listSubscription", listSubscription);
		model.addAttribute("user", getUser());
	    return "user/subscription";
	}
	
	@RequestMapping(value = "/user/subscription", method = RequestMethod.POST,consumes="application/json",
    		headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody String[] subscriptionPOST(@RequestBody List<String> subscriptionFromForm) {
		User user = getUser();
		String[] newSubscription = new String[subscriptionFromForm.size()];
		newSubscription = subscriptionFromForm.toArray(newSubscription);
		user.setSubscription(newSubscription);
		userService.updateUser(user);
		return newSubscription;
	}
    
}
