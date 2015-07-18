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
		
		if(importance != null && importance.equals("YES")){
			this.color = user.getUserPreference().getImportantEventColor();
			this.textColor = user.getUserPreference().getImportantTextColor();
			return;
		}
		
		Calendar c = Calendar.getInstance();
		c.setTime(start_date);
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			
		switch (dayOfWeek) {
		case Calendar.SUNDAY:
			this.color = user.getUserPreference().getSundayColor();
			this.textColor = user.getUserPreference().getSundayTextColor();
			break;
		case Calendar.MONDAY:
			this.color = user.getUserPreference().getMondayColor();
			this.textColor = user.getUserPreference().getMondayTextColor();
			break;
		case Calendar.TUESDAY:
			this.color = user.getUserPreference().getTuesdayColor();
			this.textColor = user.getUserPreference().getTuesdayTextColor();
			break;
		case Calendar.WEDNESDAY:
			this.color = user.getUserPreference().getWednesdayColor();
			this.textColor = user.getUserPreference().getWednesdayTextColor();
			break;
		case Calendar.THURSDAY:
			this.color = user.getUserPreference().getThursdayColor();
			this.textColor = user.getUserPreference().getThursdayTextColor();
			break;
		case Calendar.FRIDAY:
			this.color = user.getUserPreference().getFridayColor();
			this.textColor = user.getUserPreference().getFridayTextColor();
			break;
		case Calendar.SATURDAY:
			this.color = user.getUserPreference().getSaturdayColor();
			this.textColor = user.getUserPreference().getSaturdayTextColor();
			break;

		default:
			break;
		}
		
		if(!rec_type.trim().equals("")){
			this.color = user.getUserPreference().getRecurringColor();
			this.textColor = user.getUserPreference().getRecurringTextColor();
		}
	}
	
	private String importance;
    public String getImportance() {
            return importance;
    }
    public void setImportance(String importance) {
            this.importance = importance;
    }
    
    private String eventType;
    public String getEventType() {
            return eventType;
    }
    public void setEventType(String eventType) {
            this.eventType = eventType;
    }

}
