package com.xfinity.service;

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

}
