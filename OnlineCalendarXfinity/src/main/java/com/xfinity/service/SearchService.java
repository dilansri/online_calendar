package com.xfinity.service;

import java.util.Date;
import java.util.List;


import com.xfinity.model.Event;

public interface SearchService {
	
	public List<Event> search(Date startDate,Date endDate);

}
