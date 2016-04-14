package com.printmaster.nk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.printmaster.nk.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
}
