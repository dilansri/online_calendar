package com.xfinity.model;

import java.util.Calendar;

import com.dhtmlx.planner.DHXEventRec;

public class TeamEvent extends DHXEventRec {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String textColor;
    public String getTextColor() {
            return textColor;
    }
    public void setTextColor(String textColor) {
            this.textColor = textColor;
    }

    public String color;
    public String getColor() {
            return color;
    }
    public void setColor(String color) {
            this.color = color;
    }

	public void setColor() {		
		this.color = user.getUserPreference().getTeamEventColor();
		this.textColor = user.getUserPreference().getTeamTextColor();
	}
}
