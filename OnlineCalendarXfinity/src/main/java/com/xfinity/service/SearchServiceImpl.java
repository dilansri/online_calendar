package com.xfinity.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.xfinity.model.Event;
import com.xfinity.repository.SearchRepository;
@Service("searchService")
public class SearchServiceImpl implements SearchService {
	
	@Autowired
	private SearchRepository searchRepository;

	public List<Event> search(Date startDate, Date endDate) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
		return searchRepository.search(startDate,endDate,username);
	}

}
