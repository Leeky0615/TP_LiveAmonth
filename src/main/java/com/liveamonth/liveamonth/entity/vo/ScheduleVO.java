package com.liveamonth.liveamonth.entity.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleVO {
    //should add more city
    public enum Place {SEOUL, JEJU}

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
