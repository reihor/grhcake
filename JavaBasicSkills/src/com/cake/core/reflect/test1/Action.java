package com.cake.core.reflect.test1;

import java.util.Date;

public class Action {
	private String actionName;
	private long duiringTime;
	private long startTime;
	public Action(String actionName) {
		this.actionName = actionName;
		startTime = new Date().getTime();
	}
	private void watch() {
		System.out.printf("Action:  watching");
	}
	public void walk() {
		System.out.printf("Action: walking");
	}
	
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public long getDuiringTime() {
		return duiringTime;
	}
	public void setDuiringTime(long duiringTime) {
		this.duiringTime = duiringTime;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
}
