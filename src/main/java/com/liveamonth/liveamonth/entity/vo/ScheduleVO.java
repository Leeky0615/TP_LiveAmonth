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

    // Getter & setter
    public int getScheduleNO() {return scheduleNO;}
    public void setScheduleNO(int scheduleNO) {this.scheduleNO = scheduleNO;}

    public String getScheduleSubject() {return scheduleSubject;}
    public void setScheduleSubject(String scheduleSubject) {this.scheduleSubject = scheduleSubject;}

    public int getScheduleViewCount() {return scheduleViewCount;}
    public void setScheduleViewCount(int scheduleViewCount) {this.scheduleViewCount = scheduleViewCount;}

    public boolean isScheduleStatus() {return scheduleStatus;}
    public void setScheduleStatus(boolean scheduleStatus) {this.scheduleStatus = scheduleStatus;}

    public CityName getSchedulePlace() {return schedulePlace;}
    public void setSchedulePlace(CityName schedulePlace) {this.schedulePlace = schedulePlace;}

    public int getUserNO() {return userNO;}
    public void setUserNO(int userNO) {this.userNO = userNO;}
}
