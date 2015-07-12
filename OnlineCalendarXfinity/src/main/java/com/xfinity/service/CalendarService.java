package com.xfinity.service;

import com.xfinity.model.SharedCalendar;

public interface CalendarService {
	
	SharedCalendar shareCalendar(String sharedBy, String sharedWith);

}
