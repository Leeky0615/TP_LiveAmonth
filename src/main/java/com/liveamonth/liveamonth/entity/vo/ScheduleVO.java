package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ScheduleVO {
    //should add more city

    public enum Place {
    	SEOUL("서울"), 
    	JEJU("제주"),
    	BUSAN("부산"), 
    	GANGNEUNG("강릉"), 
    	YEOSU("여수"), 
    	GYEONGJU("경주"); 
    	
    	private String label; 	
		Place(String label) {this.label = label;}
		
		public String getLabel() {return label;}
		public void setLabel(String label) {this.label = label;} 
    	}

    private int scheduleNO;
    private String scheduleSubject;
    private int scheduleLikeCount;
    private boolean scheduleStatus;
    private Place place;

    // Reference
    private int userNO;

    public ScheduleVO() {
        this.scheduleNO = 0;
        this.scheduleSubject = null;
        this.scheduleLikeCount = 0;
        this.scheduleStatus = false;
        this.place = Place.SEOUL;

        // Reference
        this.userNO = 0;
    }

}
