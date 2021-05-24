package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class ScheduleVO {
    // Attributes
    private int scheduleNO;
    private String scheduleSubject;
    private int scheduleViewCount;
    private boolean scheduleStatus;
    private String schedulePlace;

    // Reference
    private int userNO;

    // Constructor
    public ScheduleVO() {
        this.scheduleNO = 0;
        this.scheduleSubject = null;
        this.scheduleViewCount = 0;
        this.scheduleStatus = false;
        this.schedulePlace = null;

        this.userNO = 0;
    }
}
