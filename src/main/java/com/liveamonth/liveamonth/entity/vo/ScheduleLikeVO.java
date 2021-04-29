package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class ScheduleLikeVO {
	// Attributes
	private int scheduleLikeUserNO;

	private int scheduleNO; // Reference

	// Constructor
	public ScheduleLikeVO() {
		this.scheduleLikeUserNO = 0;

		this.scheduleNO = 0;
	}

	// Getter & Setter
	public int getScheduleNO() {return scheduleNO;}
	public void setScheduleNO(int scheduleNO) {this.scheduleNO = scheduleNO;}

	public int getScheduleLikeUserNO() {return scheduleLikeUserNO;}
	public void setScheduleLikeUserNO(int scheduleLikeUserNO) {this.scheduleLikeUserNO = scheduleLikeUserNO;}
}
