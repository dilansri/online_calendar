package com.xfinity.service;

import java.util.List;

import com.xfinity.model.Event;

public interface EventService {
	
	Event save(Event event);

	List<Event> findAllEvents(String username);

	void update(Event ev);

	void delete(Event ev);
	
}
