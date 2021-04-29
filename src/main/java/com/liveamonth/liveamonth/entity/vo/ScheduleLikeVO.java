package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class ScheduleLikeVO {
	private int scheduleNO;
	private int scheduleLikeUserNO;
	
	public ScheduleLikeVO() {
		this.scheduleLikeUserNO = 0;
		this.scheduleNO = 0;
		}

}
