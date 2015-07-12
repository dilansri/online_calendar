package com.xfinity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(SharedCalendarPK.class)
@Table(name = "shared_calendar")
public class SharedCalendar {
	
	private String sharedBy;
	private String sharedWith;
	
	@Id
	@Column(name = "shared_by", 
		nullable = false)
	public String getSharedBy() {
		return this.sharedBy;
	}
	
	public void setSharedBy(String username){
		sharedBy = username;
	}
	
	@Id
	@Column(name = "shared_with", 
		nullable = false)
	public String getSharedWith() {
		return this.sharedWith;
	}
	
	public void setSharedWith(String username){
		sharedWith = username;
	}
}
