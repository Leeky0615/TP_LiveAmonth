package com.liveamonth.liveamonth.entity.vo;

import com.liveamonth.liveamonth.constants.EntityConstants.CityName;
import lombok.Data;

@Data
public class ScheduleVO {
    // Attributes
    private int scheduleNO;
    private String scheduleSubject;
    private int scheduleViewCount;
    private boolean scheduleStatus;
    private CityName schedulePlace;

    private int userNO; // Reference

    // Constructor
    public ScheduleVO() {
        this.scheduleNO = 0;
        this.scheduleSubject = null;
        this.scheduleViewCount = 0;
        this.scheduleStatus = false;
        this.schedulePlace = schedulePlace.SEOUL;

        this.userNO = 0;
    }
}
