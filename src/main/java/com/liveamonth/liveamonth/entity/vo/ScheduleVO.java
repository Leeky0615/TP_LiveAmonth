package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class ScheduleVO {
    // Attributes
    private int scheduleNO;
    private String scheduleSubject;
    private int scheduleViewCount;
    private boolean scheduleStatus;

    // Reference
    private int userNO;
    private int cityNO;

    // Constructor
    public ScheduleVO() {
        this.scheduleNO = 0;
        this.scheduleSubject = null;
        this.scheduleViewCount = 0;
        this.scheduleStatus = false;

        this.userNO = 0;
        this.cityNO = 0;
    }
}
