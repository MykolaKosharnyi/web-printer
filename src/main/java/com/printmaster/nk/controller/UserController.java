package com.printmaster.nk.controller;

import static com.printmaster.nk.controller.ConstUsedInContr.*;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
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
import com.printmaster.nk.model.entity.User;
import com.printmaster.nk.model.entity.UserAddByAdmin;
import com.printmaster.nk.model.entity.UserAddByAdmin.StatusSubscription;
import com.printmaster.nk.model.service.SecurityService;
import com.printmaster.nk.model.service.UserAddByAdminService;
import com.printmaster.nk.model.service.UserService;
import com.printmaster.nk.validator.UserValidator;

@Controller
public class UserController {
	
	private Logger logger = Logger.getLogger(UserController.class);
	
	private static final String TYPE = "user";
	private static final String CONCRETE_FOLDER = "users";
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private UserAddByAdminService userAddByAdminService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;
    
	@Autowired
    ComponentsForControllers componets;
	
	@Value( "${magic.number}" )
	private int magicNumber;
	
	private String encodeId(Long id){
        long xor = 0;
        xor = Long.reverseBytes(id) ^ magicNumber;
		return Long.toBinaryString(xor);
	}

	private Long decodeId(String id){
		long reversedEncodedId = new BigInteger(id, 2).longValue();		
		return Long.reverseBytes(reversedEncodedId ^ magicNumber);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Model model) throws UnsupportedEncodingException {
		User user = getUser();
    	model.addAttribute("user", user);
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
    	return userService.findByEmail(username);
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

        securityService.autologin(userForm.getEmail(), password);
        
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
  	
    @RequestMapping(value="/upload_new_picture/user", method = RequestMethod.POST)
    public @ResponseBody void uploadPicturesUpdate(MultipartHttpServletRequest request) {
    	
 		User user = getUser();
 		
 		//delete old picture
 		String oldPicture = user.getNameUserPicture();
 		if (oldPicture != null && !oldPicture.isEmpty()) {
 			componets.removePicture(user.getNameUserPicture(), DIRECTORY, CONCRETE_FOLDER, user.getId());
 		}
 		
 		//load and set new picture
 		String nameOfAddedPicture = componets.uploadPictureToExistedProduct(request, DIRECTORY, CONCRETE_FOLDER, user.getId());
 		user.setNameUserPicture(nameOfAddedPicture);
 		userService.updateUser(user);
    }
	
	@RequestMapping(value = "/user/subscription", method = RequestMethod.GET)
	public String subscriptionGET(Model model) {
		model.addAttribute("listSubscription", listSubscription);
		model.addAttribute("subscriptions", getUser().getSubscription());
	    return "user/subscription";
	}
	
	@RequestMapping(value = "/user/subscription", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
	public @ResponseBody void subscriptionPOST(@RequestBody List<String> subscriptionFromForm) {
		User user = getUser();
		user.setSubscription(subscriptionFromForm);
		userService.updateUser(user);
	}
	
	@RequestMapping(value = "/subscription/{id}", method = RequestMethod.GET)
	public String unSubscriptionGET(Model model, @PathVariable("id") String id)
			throws NumberFormatException, UnsupportedEncodingException {
		model.addAttribute("listSubscription", listSubscription);
		model.addAttribute("listScopeOfActivities", listScopeOfActivities);
		UserAddByAdmin user = userAddByAdminService.getUserById(decodeId(id));
		model.addAttribute("subscriptions",  user.getSubscription());
		model.addAttribute("u_listScopeOfActivities",  user.getScopeOfActivities());
		model.addAttribute("userId", encodeId(user.getId()));
	    return "user/subscription_user_add_by_admin";
	}
	
	@RequestMapping(value = "/subscription/{id}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
	public @ResponseBody void unSubscriptionPOST(@RequestBody List<String> subscriptionFromForm, @PathVariable("id") String id)
			throws NumberFormatException, UnsupportedEncodingException {
		UserAddByAdmin user = userAddByAdminService.getUserById(decodeId(id));
		user.setStatusOfSubscription(setStatusOfSubscriptionC(subscriptionFromForm.size(), user.getSubscription().size(), user.getScopeOfActivities().size()));
		user.setSubscription(subscriptionFromForm);
		userAddByAdminService.updateUser(user);
	}
	
	@RequestMapping(value = "/scope_activities/{id}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
    		headers = JSON_HEADERS)
	public @ResponseBody void unSubscriptionSAPOST(@RequestBody List<String> scopeOfActivitiesFromForm, @PathVariable("id") String id)
			throws NumberFormatException, UnsupportedEncodingException {
		UserAddByAdmin user = userAddByAdminService.getUserById(decodeId(id));
		user.setStatusOfSubscription(setStatusOfSubscriptionC(scopeOfActivitiesFromForm.size(), user.getScopeOfActivities().size(),user.getSubscription().size()));
		user.setScopeOfActivities(scopeOfActivitiesFromForm);
		userAddByAdminService.updateUser(user);
	}

	private StatusSubscription setStatusOfSubscriptionC(int sizeForm, int sizeCurrent, int sizeCheckedProperty){		
		StatusSubscription result = StatusSubscription.NOT_CHANGED;
	
		if(sizeForm==0 && sizeCheckedProperty==0){
			result = StatusSubscription.COMPLETELY_UNSUBSCRIBED;
		} else if(sizeForm>sizeCurrent){
			result = StatusSubscription.ADDED_SUBSCRIPTIONS;
		} else if(sizeForm<sizeCurrent){
			result = StatusSubscription.REMOVED_SOME_SUBSCRIPTIONS;
		}
		
		return result;
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"s", method = RequestMethod.GET)
	public String getAllUsersOnAdmin(Model model) {
		model.addAttribute("userList", userService.listUsers());
		model.addAttribute("user_add_by_admin_List", userAddByAdminService.listUsers());	
	    return PATH_ADMIN + "/"+ TYPE + "s";
	}
	
	@RequestMapping("/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_REMOVE +"/{id}")
    public String removeUser(@PathVariable("id") long id){
    	logger.info(String.format("Start deleting %s from database, id=%d", TYPE, id));
    	
    	componets.removeAllPricturesOfConcreteProduct(DIRECTORY, CONCRETE_FOLDER, id);
    		
    	logger.info(String.format("DELETE %s with id=%d from database", TYPE, id));
    	userService.removeUser(id);
    		
        return "redirect:/"+ PATH_ADMIN + "/" + TYPE + "s";
    }
	
	@RequestMapping("/"+ PATH_ADMIN +"/user_add_by_admin/"+ PATH_REMOVE +"/{id}")
    public String removeUserAddByAdmin(@PathVariable("id") long id){
		userAddByAdminService.removeUser(id);   		
        return "redirect:/"+ PATH_ADMIN + "/" + TYPE + "s";
    }
	
	/**
	 * For editing registered Use and added by Admin
	 */
//	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_EDIT+"/{id}", method = RequestMethod.GET)
//	public String editUser(Model model,@PathVariable("id") long id) {
//		model.addAttribute("user", userService.getUserById(id));
//	    return PATH_ADMIN + "/"+ TYPE;
//	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/user_add_by_admin/"+ PATH_EDIT+"/{id}", method = RequestMethod.GET)
	public String editUserAddByAdmin(Model model,@PathVariable("id") long id) {
		model.addAttribute("user", userAddByAdminService.getUserById(id));
		model.addAttribute("listSubscription", listSubscription);
		model.addAttribute("listScopeOfActivities", listScopeOfActivities);
	    return PATH_ADMIN + "/"+ TYPE;
	}
	
	/**
	 * for displaying new add user page
	 */
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_NEW, method = RequestMethod.GET)
	public String goToPageNewUser(Model model) {
		model.addAttribute("user", new UserAddByAdmin());
		model.addAttribute("listSubscription", listSubscription);
		model.addAttribute("listScopeOfActivities", listScopeOfActivities);
	    return PATH_ADMIN + "/"+ TYPE;
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_CREATE, method = RequestMethod.POST) 
	public String saveUserAddByAdmin(@ModelAttribute("user") @Valid UserAddByAdmin product,
			BindingResult result, Model model){

		if (result.hasErrors()){
			model.addAttribute("user", product);
			model.addAttribute("listSubscription", listSubscription);
			model.addAttribute("listScopeOfActivities", listScopeOfActivities);
		    return PATH_ADMIN + "/"+ TYPE;
		}
		
		userAddByAdminService.save(product);
		return "redirect:/" + PATH_ADMIN + "/"+ TYPE +"s";
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/"+ TYPE +"/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String changeUserAddByAdmin(@ModelAttribute("user") @Valid UserAddByAdmin product,
			BindingResult result, Model model){

		if (result.hasErrors()){
			model.addAttribute("user", product);
			model.addAttribute("listSubscription", listSubscription);
			model.addAttribute("listScopeOfActivities", listScopeOfActivities);
		    return PATH_ADMIN + "/"+ TYPE;
		}
		
		userAddByAdminService.updateUser(product);
		return "redirect:/" + PATH_ADMIN + "/"+ TYPE +"s";
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/registered_user/"+ PATH_UPDATE, method = RequestMethod.POST) 
	public String changeRegisteredUserByAdmin(@ModelAttribute("user") @Valid User product,
			BindingResult result, Model model){

		if (result.hasErrors()){
			model.addAttribute("user", product);
			model.addAttribute("listSubscription", listSubscription);
			model.addAttribute("listScopeOfActivities", listScopeOfActivities);
		    return PATH_ADMIN + "/registered_user";
		}
		
		userService.updateUser(product);
		return "redirect:/" + PATH_ADMIN + "/"+ TYPE +"s";
	}
	
	@RequestMapping(value = "/"+ PATH_ADMIN +"/registered_user/"+ PATH_EDIT+"/{id}", method = RequestMethod.GET)
	public String editRegisteredUserByAdmin(Model model,@PathVariable("id") long id) {
		model.addAttribute("user", userService.getUserById(id));
		model.addAttribute("listSubscription", listSubscription);
		model.addAttribute("listScopeOfActivities", listScopeOfActivities);
	    return PATH_ADMIN + "/registered_user";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/user_add_by_admin/check_email", method = RequestMethod.POST,
    		produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
    public @ResponseBody JSONObject checkEmail(@RequestBody String email) {
    	JSONObject result = new JSONObject();
    	result.put("result", userAddByAdminService.isEmailAlreadyExist(email));
    	return result;
    }
    
}
