package com.xfinity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	/**
	 * Handling request to the home page
	 */
	@RequestMapping(method=RequestMethod.GET)	
	public String index(Model model){	
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		if(!username.trim().equals("anonymousUser"))	{
			return "redirect:/my/planner";
		}
		return "hello";
	}	

}
