package com.xfinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user_preferences")
public class UserPreference {

	private String username;
	private User user;

	private String recurringColor;
	private String recurringTextColor;

	private String sundayColor;
	private String sundayTextColor;

	private String mondayColor;
	private String mondayTextColor;

	private String tuesdayColor;
	private String tuesdayTextColor;

	private String wednesdayColor;
	private String wednesdayTextColor;

	private String thursdayColor;
	private String thursdayTextColor;

	private String fridayColor;
	private String fridayTextColor;

	private String saturdayColor;
	private String saturdayTextColor;
	
	private String skin;
	
	private String teamEventColor;
	private String teamTextColor;

	public UserPreference() {
		
		skin = "TERRACE";
		
		recurringColor = "rgb(128,128,128)";
		recurringTextColor = "rgb(255,255,255)";
		
		sundayColor = "rgb(255, 0, 0)";
		sundayTextColor = "rgb(255,255,255)";

		mondayColor = "rgb(0, 128, 0)";
		mondayTextColor = "rgb(255,255,255)";

		tuesdayColor = "rgb(128,128,0)";
		tuesdayTextColor = "rgb(255,255,255)";

		wednesdayColor = "rgb(0,128,128)";
		wednesdayTextColor = "rgb(255,255,255)";

		thursdayColor = "rgb(255,165,0)";
		thursdayTextColor = "rgb(255,255,255)";

		fridayColor = "rgb(128,0,0)";
		fridayTextColor = "rgb(255,255,255)";

		saturdayColor = "rgb(128,0,128)";
		saturdayTextColor = "rgb(255,255,255)";
		
		teamEventColor = "rgb(128,0,128)";
		teamTextColor = "rgb(255,255,255)";
		
		keepOldColors = false;
	}

	@Id
	@Column(name = "username", unique = true, nullable = false, length = 45)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "recurring_color")
	public String getRecurringColor() {
		return recurringColor;
	}

	public void setRecurringColor(String recurringColor) {
		this.recurringColor = recurringColor;
	}

	@Column(name = "recurring_text_color")
	public String getRecurringTextColor() {
		return recurringTextColor;
	}

	public void setRecurringTextColor(String recurringTextColor) {
		this.recurringTextColor = recurringTextColor;
	}

	@Column(name = "sunday_color")
	public String getSundayColor() {
		return sundayColor;
	}

	public void setSundayColor(String sundayColor) {
		this.sundayColor = sundayColor;
	}

	@Column(name = "sunday_text_color")
	public String getSundayTextColor() {
		return sundayTextColor;
	}

	public void setSundayTextColor(String sundayTextColor) {
		this.sundayTextColor = sundayTextColor;
	}

	@Column(name = "monday_color")
	public String getMondayColor() {
		return mondayColor;
	}

	public void setMondayColor(String mondayColor) {
		this.mondayColor = mondayColor;
	}

	@Column(name = "monday_text_color")
	public String getMondayTextColor() {
		return mondayTextColor;
	}

	public void setMondayTextColor(String mondayTextColor) {
		this.mondayTextColor = mondayTextColor;
	}

	@Column(name = "tuesday_color")
	public String getTuesdayColor() {
		return tuesdayColor;
	}

	public void setTuesdayColor(String tuesdayColor) {
		this.tuesdayColor = tuesdayColor;
	}

	@Column(name = "tuesday_text_color")
	public String getTuesdayTextColor() {
		return tuesdayTextColor;
	}

	public void setTuesdayTextColor(String tuesdayTextColor) {
		this.tuesdayTextColor = tuesdayTextColor;
	}

	@Column(name = "wednesday_color")
	public String getWednesdayColor() {
		return wednesdayColor;
	}

	public void setWednesdayColor(String wednesdayColor) {
		this.wednesdayColor = wednesdayColor;
	}

	@Column(name = "wednesday_text_color")
	public String getWednesdayTextColor() {
		return wednesdayTextColor;
	}

	public void setWednesdayTextColor(String wednesdayTextColor) {
		this.wednesdayTextColor = wednesdayTextColor;
	}

	@Column(name = "thursday_color")
	public String getThursdayColor() {
		return thursdayColor;
	}

	public void setThursdayColor(String thursdayColor) {
		this.thursdayColor = thursdayColor;
	}

	@Column(name = "thursday_text_color")
	public String getThursdayTextColor() {
		return thursdayTextColor;
	}

	public void setThursdayTextColor(String thursdayTextColor) {
		this.thursdayTextColor = thursdayTextColor;
	}

	@Column(name = "friday_color")
	public String getFridayColor() {
		return fridayColor;
	}

	public void setFridayColor(String fridayColor) {
		this.fridayColor = fridayColor;
	}

	@Column(name = "friday_text_color")
	public String getFridayTextColor() {
		return fridayTextColor;
	}

	public void setFridayTextColor(String fridayTextColor) {
		this.fridayTextColor = fridayTextColor;
	}

	@Column(name = "saturday_color")
	public String getSaturdayColor() {
		return saturdayColor;
	}

	public void setSaturdayColor(String saturdayColor) {
		this.saturdayColor = saturdayColor;
	}

	@Column(name = "saturday_text_color")
	public String getSaturdayTextColor() {
		return saturdayTextColor;
	}

	public void setSaturdayTextColor(String saturdayTextColor) {
		this.saturdayTextColor = saturdayTextColor;
	}
	
	@Column(name = "skin")
	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		
		String skinVal = "TERRACE";
		
		if(skin.toUpperCase().equals("TERRACE")){
			skinVal = "TERRACE";
		}else if(skin.toUpperCase().equals("CLASSIC")){
			skinVal = "CLASSIC";
		}else if(skin.toUpperCase().equals("GLOSSY")){
			skinVal = "GLOSSY";
		}
		
		this.skin = skinVal;
	}
	
	@Column(name = "team_event_color")
	public String getTeamEventColor() {
		return teamEventColor;
	}

	public void setTeamEventColor(String teamEventColor) {
		this.teamEventColor = teamEventColor;
	}
	
	@Column(name = "team_text_color")
	public String getTeamTextColor() {
		return teamTextColor;
	}

	public void setTeamTextColor(String teamTextColor) {
		this.teamTextColor = teamTextColor;
	}
	
	private boolean keepOldColors;
	
	@Column(name = "keep_old_colors")
	public boolean isKeepOldColors() {
		return keepOldColors;
	}

	public void setKeepOldColors(boolean keepOldColors) {
		this.keepOldColors = keepOldColors;
	}
	
	
	

}
