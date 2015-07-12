package com.xfinity.service;

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

	public boolean isCalendarShared(String sharedWith) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String sharedBy = auth.getName(); //get logged in username
		
		return calendarRepository.isCalendarShared(sharedBy,sharedWith);
	}

}
