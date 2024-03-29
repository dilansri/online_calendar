package com.xfinity.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.xfinity.model.User;
import com.xfinity.model.UserPreference;
import com.xfinity.service.UserService;


/**
 * Handling user login and registration
 */
@Controller
public class UserController {
	
	/**
	 * Injecting user service
	 */
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register")
	public ModelAndView register(HttpServletRequest request){
		
		/**
		 * Registering the user in the system
		 */
		if(request.getMethod().equals("POST")){
			String username= request.getParameter("username");
			String password = request.getParameter("password");
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			password = encoder.encode(password);
			User registeredUser = new User(username,password,true);
			UserPreference userPreference = new UserPreference();
			userPreference.setUsername(registeredUser.getUsername());
			registeredUser.setUserPreference(userPreference);
			userPreference.setUser(registeredUser);
			
			try{
				userService.save(registeredUser);
			}
			/** 
			 * Handling error of user registration process
			 */
			catch(javax.persistence.PersistenceException exception){
				ModelAndView mnv = new ModelAndView("register");
				mnv.addObject("error","User already exists. Try a different username.");
				return mnv;
			}catch(Exception ex){
				ModelAndView mnv = new ModelAndView("register");
				mnv.addObject("error","Something went wrong. Please try again later.");
				return mnv;
			}
			/**
			 * SUccess registration of the user in the system
			 */
			ModelAndView mnv = new ModelAndView("register");
			mnv.addObject("success","You've been successfully registered.");
			return mnv;
		}
			
		return new ModelAndView("register");
	}
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ModelAndView registerUserAccount(WebRequest request, Model model){
		//model.addAttribute("greeting","HELLO WORLDss");	
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		password = encoder.encode(password);
		User registeredUser = new User(username,password,true);
		UserPreference userPreference = new UserPreference();
		userPreference.setUsername(registeredUser.getUsername());
		registeredUser.setUserPreference(userPreference);
		userPreference.setUser(registeredUser);
		
		//userService.savePreference(userPreference);
		try{
			userService.save(registeredUser);
		}catch(javax.persistence.PersistenceException exception){
			return new ModelAndView("register");
		}		
			
		return new ModelAndView("registerSuccess");
	}
	
	@RequestMapping("/my/settings")
    public ModelAndView settings(HttpServletRequest request){
		ModelAndView mnv = new ModelAndView("settings");
		
		UserPreference userPref = getUser().getUserPreference();
		
		if(request.getMethod().equals("POST")){
			
			userPref.setRecurringColor(request.getParameter("rec_color"));
			userPref.setRecurringTextColor(request.getParameter("rec_text_color"));
			
			userPref.setSundayColor(request.getParameter("sun_color"));
			userPref.setSundayTextColor(request.getParameter("sun_text_color"));
			
			userPref.setMondayColor(request.getParameter("mon_color"));
			userPref.setMondayTextColor(request.getParameter("mon_text_color"));
			
			userPref.setTuesdayColor(request.getParameter("tue_color"));
			userPref.setTuesdayTextColor(request.getParameter("tue_text_color"));
			
			userPref.setWednesdayColor(request.getParameter("wed_color"));
			userPref.setWednesdayTextColor(request.getParameter("wed_text_color"));
			
			userPref.setThursdayColor(request.getParameter("thu_color"));
			userPref.setThursdayTextColor(request.getParameter("thu_text_color"));
			
			userPref.setFridayColor(request.getParameter("fri_color"));
			userPref.setFridayTextColor(request.getParameter("fri_text_color"));
			
			userPref.setSaturdayColor(request.getParameter("sat_color"));
			userPref.setSaturdayTextColor(request.getParameter("sat_text_color"));
			
			userPref.setSkin(request.getParameter("skin"));
			
			userPref.setTeamEventColor(request.getParameter("team_event_color"));
			userPref.setTeamTextColor(request.getParameter("team_text_color"));
			
			if(request.getParameter("keepOldColors") != null && request.getParameter("keepOldColors").equals("yes")){
				userPref.setKeepOldColors(true);
			}else{
				userPref.setKeepOldColors(false);
			}
			
			userService.savePreference(userPref);
			mnv.addObject("pref",userPref);
			mnv.addObject("success", "Your settings are successfully updated.");
			return mnv;
		}
		mnv.addObject("pref",userPref);
		return mnv;
	}
	
	@RequestMapping("/login") 
	public String login() {
		return "login";
	}
	
	@RequestMapping("/403") 
	public String error() {
		return "403";
	}
	
	
	 private User getUser() {
	    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String username = auth.getName();		
		    User user = userService.getUser(username);
		    return user;
	}

}
