package com.xfinity.repository;

import java.util.List;

import com.xfinity.model.Event;

public interface EventRepository {
	
	Event save(Event event);

	List<Event> loadAll();

	void delete(Event ev);

	void update(Event ev);
}
