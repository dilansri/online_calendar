package com.xfinity.service;

import java.util.List;

import com.xfinity.model.SharedCalendar;

public interface CalendarService {
	
	SharedCalendar shareCalendar(String sharedBy, String sharedWith);

	boolean isCalendarShared(String user);

	List<String> getSharedCalendarsWithMe();

	List<String> getSharedCalendarsByMe();

}
