package com.xfinity.service;

import java.util.List;

import com.xfinity.model.Event;
import com.xfinity.model.TeamEvent;

public interface TeamEventService {
	TeamEvent save(TeamEvent event);

	List<TeamEvent> findAllEvents();

	void update(TeamEvent ev);

	void delete(TeamEvent ev);

	String getUsername(int eventId);
}
