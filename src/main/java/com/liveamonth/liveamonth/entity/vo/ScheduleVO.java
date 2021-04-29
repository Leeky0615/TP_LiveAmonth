package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ScheduleVO {
	//should add more city

	public enum schedulePlace {
		SEOUL("서울"), 
		JEJU("제주"),
		BUSAN("부산"), 
		GANGNEUNG("강릉"), 
		YEOSU("여수"), 
		GYEONGJU("경주"); 

		private String label; 	
		schedulePlace(String label) {this.label = label;}

		public String getLabel() {return label;}
		public void setLabel(String label) {this.label = label;} 
	}

	private int scheduleNO;
	private String scheduleSubject;
	private int scheduleViewCount;
	private boolean scheduleStatus;
	private schedulePlace schedulePlace;

	// Reference
	private int userNO;


	public ScheduleVO() {
		this.scheduleNO = 0;
		this.scheduleSubject = null;
		this.scheduleViewCount = 0;
		this.scheduleStatus = false;
		this.schedulePlace = schedulePlace.SEOUL;

		// Reference
		this.userNO = 0;
	}

	public int getScheduleNO() {
		return scheduleNO;
	}


	public void setScheduleNO(int scheduleNO) {
		this.scheduleNO = scheduleNO;
	}


	public String getScheduleSubject() {
		return scheduleSubject;
	}


	public void setScheduleSubject(String scheduleSubject) {
		this.scheduleSubject = scheduleSubject;
	}


	public int getScheduleViewCount() {
		return scheduleViewCount;
	}


	public void setScheduleViewCount(int scheduleViewCount) {
		this.scheduleViewCount = scheduleViewCount;
	}


	public boolean isScheduleStatus() {
		return scheduleStatus;
	}


	public void setScheduleStatus(boolean scheduleStatus) {
		this.scheduleStatus = scheduleStatus;
	}


	public schedulePlace getSchedulePlace() {
		return schedulePlace;
	}


	public void setSchedulePlace(schedulePlace schedulePlace) {
		this.schedulePlace = schedulePlace;
	}


	public int getUserNO() {
		return userNO;
	}


	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}
	
	

}
