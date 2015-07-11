package com.xfinity.model;

import com.dhtmlx.planner.DHXEventRec;

public class Event extends DHXEventRec {
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
