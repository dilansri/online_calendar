package com.xfinity.repository;

import com.xfinity.model.SharedCalendar;

public interface CalendarRepository {
	SharedCalendar saveSharedCalendar(SharedCalendar calendar);

	boolean isCalendarShared(String sharedBy, String sharedWith);
}
