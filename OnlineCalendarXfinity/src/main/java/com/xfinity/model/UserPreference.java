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

	public UserPreference() {
		recurringColor = "#808080";
		recurringTextColor = "#FFFFFF";
		
		sundayColor = "#FF0000";
		sundayTextColor = "#FFFFFF";

		mondayColor = "#008000";
		mondayTextColor = "#FFFFFF";

		tuesdayColor = "#808000";
		tuesdayTextColor = "#FFFFFF";

		wednesdayColor = "#008080";
		wednesdayTextColor = "#FFFFFF";

		thursdayColor = "#FFA500";
		thursdayTextColor = "#FFFFFF";

		fridayColor = "#800000";
		fridayTextColor = "#FFFFFF";

		saturdayColor = "#800080";
		saturdayTextColor = "#FFFFFF";
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

}