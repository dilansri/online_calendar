package com.xfinity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfinity.model.SharedCalendar;
import com.xfinity.repository.CalendarRepository;

@Service("calendarService")
public class CalendarServiceImpl implements CalendarService {
	
	@Autowired
	private CalendarRepository calendarRepository;
	
	@Transactional
	public SharedCalendar shareCalendar(String sharedBy, String sharedWith) {
		SharedCalendar calendar = new SharedCalendar();
		calendar.setSharedBy(sharedBy);
		calendar.setSharedWith(sharedWith);
		return calendarRepository.saveSharedCalendar(calendar);
	}

	public boolean isCalendarShared(String sharedBy) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sharedWith = auth.getName(); //get logged in username
		
		return calendarRepository.isCalendarShared(sharedBy,sharedWith);
	}

	public List<String> getSharedCalendarsWithMe() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String me = auth.getName(); 
		
		return calendarRepository.getSharedWith(me);
	}

	public List<String> getSharedCalendarsByMe() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String me = auth.getName(); 
		
		return calendarRepository.getSharedBy(me);
	}

}
