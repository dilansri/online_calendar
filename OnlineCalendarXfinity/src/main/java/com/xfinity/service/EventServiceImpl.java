package com.xfinity.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfinity.model.Event;
import com.xfinity.repository.EventRepository;

@Service("eventService")
public class EventServiceImpl implements EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Transactional
	public Event save(Event event) {
		return eventRepository.save(event);
	}

	public List<Event> findAllEvents(String username) {
		return eventRepository.loadAll(username);
	}
	
	@Transactional
	public void update(Event ev) {
		eventRepository.update(ev);		
	}
	
	@Transactional
	public void delete(Event ev) {
		eventRepository.delete(ev);
		
	}

	public List<Event> findAllEvents(String username,
			HashMap<String, String> options) {
		
		return eventRepository.load(username,options);
	}

}
