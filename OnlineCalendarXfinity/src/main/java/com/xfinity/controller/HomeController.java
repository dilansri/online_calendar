package com.xfinity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@RequestMapping(method=RequestMethod.GET)	
	public String index(Model model){		
		
		if(SecurityContextHolder.getContext().getAuthentication() != null &&
				SecurityContextHolder.getContext().getAuthentication().isAuthenticated())	{
			return "redirect:/my/planner";
		}
		model.addAttribute("greeting","HELLO WORLDss From Home");
		return "hello";
	}	

}
