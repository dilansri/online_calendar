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
	
	public int hashCode(){
		return super.hashCode();
	}
	
	public boolean equals(Object obj){
		
		if(obj instanceof SharedCalendarPK ){
			SharedCalendarPK scPK = (SharedCalendarPK)obj;
			
			if(scPK.sharedBy.equals(sharedBy) && scPK.sharedWith.equals(sharedWith)){
				return true;
			}
				
		}
		
		return false;
		
	}
}
