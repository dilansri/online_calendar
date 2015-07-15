package com.xfinity.repository;

import java.util.Date;
import java.util.List;

import com.xfinity.model.Event;

public interface SearchRepository {
	
	public List<Event> search(Date startDate,Date endDate, String username);

}
