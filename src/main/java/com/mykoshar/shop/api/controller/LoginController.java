package com.mykoshar.shop.api.controller;

import org.springframework.stereotype.Controller;

//import com.printmaster.nk.service.UserService;

@Controller
public class LoginController {
	
//	@Autowired
//	private UserService userService;
//	
//	@RequestMapping(value = {"/login", "/logout"}, method = RequestMethod.GET)
//	public String showLoginForm(Model model,
//			@RequestParam(value = "error", required = false) String error,
//			@RequestParam(value = "logout", required = false) String logout) {
//		
//		if (error != null) {
//			model.addAttribute("error", "Invalid username and password!");
//		}
//
//		if (logout != null) {
//			model.addAttribute("msg", "You've been logged out successfully.");
//		}
//		
//		return "login";
//	}

/*	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String verifyLogin(@RequestParam String userId, @RequestParam String password, HttpSession session, Model model) {
		
		User user = userService.loginUser(userId, password);
		if(user == null){
			model.addAttribute("loginError", "Error login in. Please train again.");
			return "login";
		}
		
		session.setAttribute("loggedInUser", user);
		return "redirect:/printers";
	}
		
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "login";
	}*/
}
