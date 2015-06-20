package com.xfinity.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dhtmlx.planner.DHXPlanner;
import com.dhtmlx.planner.DHXSkin;
import com.dhtmlx.planner.data.DHXDataFormat;
import com.dhtmlx.planner.extensions.DHXExtension;
import com.xfinity.event.manager.EventsManager;

@Controller
public class HelloController {
	
	@RequestMapping(value="/greeting")
	public String sayHello(Model model){
		model.addAttribute("greeting","HELLO WORLDss");
		return "hello";
	}	
	
	@RequestMapping("/myplanner.html")
    public ModelAndView planner(HttpServletRequest request) throws Exception {
            DHXPlanner p = new DHXPlanner("./codebase/", DHXSkin.TERRACE);
            p.setInitialDate(2013, 0, 23);
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
            EventsManager evs = new EventsManager(request);
            return evs.run();
    }
	
}