package com.xfinity.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension;
import com.xfinity.event.manager.EventManager;
import com.xfinity.event.manager.EventsManager;
import com.xfinity.model.Event;
import com.xfinity.service.EventService;

@Controller
public class HelloController {
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(value="/greeting")
	public String sayHello(Model model){
		model.addAttribute("greeting","HELLO WORLDss");
		
		Event evt = new Event();
		evt.setStart_date(new Date(115,5,24));
		evt.setEnd_date(new Date(115,5,25));
		evt.setText("Test Event");
		eventService.save(evt);		
		return "hello";
	}	
	
	@RequestMapping("/myplanner.html")
    public ModelAndView planner(HttpServletRequest request) throws Exception {
            DHXPlanner p = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
            p.setInitialDate(2013, 1, 2);
            p.extensions.add(DHXExtension.RECURRING);
            //p.setWidth(900);
            p.load("events.html", DHXDataFormat.JSON);
            p.data.dataprocessor.setURL("events.html");
            ModelAndView mnv = new ModelAndView("article");
            mnv.addObject("body", p.render());
            return mnv;
    }

    @RequestMapping("/events")
    @ResponseBody public String events(HttpServletRequest request) {
            //EventsManager evs = new EventsManager(request);
            //return evs.run();
    	EventManager evs = new EventManager(request,eventService);
    	return evs.run();
            //CustomEventsManager evs = new CustomEventsManager(request);
            //return evs.run();
    }
	
}