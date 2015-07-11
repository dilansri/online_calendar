package com.xfinity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xfinity.model.User;
import com.xfinity.service.UserService;



@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register")
	public String register(Model model){
		model.addAttribute("greeting","HELLO WORLDss");		
			
		return "register";
	}
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ModelAndView registerUserAccount(WebRequest request, Model model){
		//model.addAttribute("greeting","HELLO WORLDss");	
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		password = encoder.encode(password);
		User registeredUser = new User(username,password,true);
		try{
			userService.save(registeredUser);
		}catch(javax.persistence.PersistenceException exception){
			return new ModelAndView("register");
		}		
			
		return new ModelAndView("registerSuccess");
	}

}
