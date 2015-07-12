package com.xfinity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xfinity.model.TeamEvent;
import com.xfinity.repository.TeamEventRepository;

@Service("teamEventService")
public class TeamEventServiceImpl implements TeamEventService {
	
	@Autowired
	private TeamEventRepository teamEventRepository;
	
	@Transactional
	public TeamEvent save(TeamEvent event) {
		return teamEventRepository.save(event);
	}

	public List<TeamEvent> findAllEvents() {
		return teamEventRepository.loadAll();
	}
	
	@Transactional
	public void update(TeamEvent ev) {
		teamEventRepository.update(ev);
	}
	
	@Transactional
	public void delete(TeamEvent ev) {
		teamEventRepository.delete(ev);
	}

	public String getUsername(int eventId) {		
		return teamEventRepository.getUsername(eventId);
	}

}
