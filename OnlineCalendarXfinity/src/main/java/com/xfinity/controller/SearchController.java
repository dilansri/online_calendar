package com.xfinity.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xfinity.model.Event;
import com.xfinity.service.SearchService;

@Controller
public class SearchController {
	/**
	 * Injecting search services
	 */
	@Autowired
	private SearchService searchService;
	
	/**
	 * Handling user's search requests
	 */
	
	@RequestMapping("/my/search")
    public ModelAndView planner(HttpServletRequest request) throws Exception {
		
		ModelAndView mnv = new ModelAndView("search");
        
		/**
		 * Searching eligible events from search service
		 */
		List<Event> searchResult = new ArrayList<Event>();
		if(request.getMethod().equals("POST")){
			String startDateString = request.getParameter("startDate");
			String endDateString = request.getParameter("endDate");
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
			
			try{
				Date startDate = sdf.parse(startDateString);
				Date endDate = sdf.parse(endDateString);
				
				searchResult = searchService.search(startDate, endDate);
				if(searchResult.size() == 0 ){
					mnv.addObject("no_result","No results found.");
				}
				mnv.addObject("startDateString",startDateString);
				mnv.addObject("endDateString",endDateString);
				
			}catch(Exception ex){
				
			}
		}			
		
		mnv.addObject("result", searchResult);
        return mnv;
	}
}
