package com.xfinity.model;

import java.io.Serializable;

public class SharedCalendarPK implements Serializable {
	private String sharedBy;
	private String sharedWith;
	public String getSharedBy() {
		return sharedBy;
	}
	public void setSharedBy(String sharedBy) {
		this.sharedBy = sharedBy;
	}
	public String getSharedWith() {
		return sharedWith;
	}
	public void setSharedWith(String sharedWith) {
		this.sharedWith = sharedWith;
	}
}
