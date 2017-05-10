package com.printmaster.nk.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.printmaster.nk.beans.ConstantService;
import com.printmaster.nk.beans.Constants;

@Controller
public class ConstController {
	
	@Autowired
	private ConstantService constantsService;
	
	@RequestMapping(value = "/admin/constants", method = RequestMethod.GET)
	public String getConstants(Model model){
		model.addAttribute("title", "Константы");
		model.addAttribute("constantsChange", constantsService.getConstants());
	    return "admin/constants";
	}

	@RequestMapping(value = "/admin/constants/update", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("constantsChange") @Valid Constants constants,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("constants", constants);
	            return "admin/constants";
	        }
		
			//action for saving new CONSTANTS
			constantsService.saveConstants(constants);			
	   return "redirect:/admin/constants";
	}

}