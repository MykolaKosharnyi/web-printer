package com.printmaster.nk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.printmaster.nk.model.User;
import com.printmaster.nk.service.UserService;
import com.printmaster.nk.service.user.SecurityService;
import com.printmaster.nk.validator.UserValidator;

@Controller
public class UserController {

//	@Autowired
//	private UserService userService;
	
//	@Autowired
//    private MailSender mailSender;
	
/*	@RequestMapping(value="/ask/product", method = RequestMethod.POST, consumes="application/json",
			headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void askProductPage(HttpServletRequest request) {
		// takes input from e-mail form
        String recipientAddress = request.getParameter("recipient");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
         
        // prints debug info
        System.out.println("To: " + recipientAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
         
        // creates a simple e-mail object
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message);
         
        // sends the e-mail
        mailSender.send(email);
         
        // forwards to the view named "Result"
        //return "Result";
    }
	*/
	
	@Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) {
		
    	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	String username = null;
    	if (principal instanceof UserDetails) {
    		username = ((UserDetails)principal).getUsername();
    	} else {
    		username = (String) principal;
    	}
    	
    	model.addAttribute("user", userService.findByUserName(username));
    	
        return "user";
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
        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), password);

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

}
