package com.xfinity.model;

import java.util.Calendar;

import com.dhtmlx.planner.DHXEventRec;

public class Event extends DHXEventRec {
	
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
		
		Calendar c = Calendar.getInstance();
		c.setTime(start_date);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
				
		switch (dayOfWeek) {
		case Calendar.SUNDAY:
			this.color = "Red";
			this.textColor = "white";
			break;
		case Calendar.MONDAY:
			this.color = "brown";
			this.textColor = "white";
			break;
		case Calendar.TUESDAY:
			this.color = "blue";
			this.textColor = "white";
			break;
		case Calendar.WEDNESDAY:
			this.color = "green";
			this.textColor = "white";
			break;
		case Calendar.THURSDAY:
			this.color = "orange";
			this.textColor = "white";
			break;
		case Calendar.FRIDAY:
			this.color = "purple";
			this.textColor = "white";
			break;
		case Calendar.SATURDAY:
			this.color = "grey";
			this.textColor = "white";
			break;

		default:
			break;
		}
	}

}
