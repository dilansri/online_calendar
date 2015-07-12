package com.xfinity.repository;

import java.util.List;



import com.xfinity.model.TeamEvent;

public interface TeamEventRepository {
	TeamEvent save(TeamEvent event);

	List<TeamEvent> loadAll();

	void delete(TeamEvent ev);

	void update(TeamEvent ev);

	String getUsername(int eventId);
}
