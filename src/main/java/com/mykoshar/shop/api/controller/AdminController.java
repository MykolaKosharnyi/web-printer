package com.mykoshar.shop.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author nikolay
 *
 */
@Controller
public class AdminController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Model model) {
		logger.info("/admin");
		return "admin";
	}
}
