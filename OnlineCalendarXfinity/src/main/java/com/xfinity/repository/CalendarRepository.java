package com.xfinity.repository;

import java.util.List;

import com.xfinity.model.SharedCalendar;

public interface CalendarRepository {
	SharedCalendar saveSharedCalendar(SharedCalendar calendar);

	boolean isCalendarShared(String sharedBy, String sharedWith);

	List<String> getSharedWith(String user);

	List<String> getSharedBy(String user);

	boolean deleteSharing(String sharedByUser, String sharedWithUser);
}
