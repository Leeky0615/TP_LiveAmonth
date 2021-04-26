package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Getter
@Setter
public class ScheduleContentVO {

    private int scheduleContentNO;
    private String scheduleContentSubject;
    private String scheduleContentDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String scheduleContentDate;
    private int scheduleContentCost;

    // Reference
    private int scheduleNO;

    public ScheduleContentVO() {
        this.scheduleContentNO = 0;
        this.scheduleContentSubject = null;
        this.scheduleContentDesc = null;
        this.scheduleContentDate = null;
        this.scheduleContentCost = 0;

        // Reference
        this.scheduleNO = 0;
    }

    public int getScheduleContentNO() {
        return scheduleContentNO;
    }

    public void setScheduleContentNO(int scheduleContentNO) {
        this.scheduleContentNO = scheduleContentNO;
    }

    public String getScheduleContentSubject() {
        return scheduleContentSubject;
    }

    public void setScheduleContentSubject(String scheduleContentSubject) {
        this.scheduleContentSubject = scheduleContentSubject;
    }

    public String getScheduleContentDesc() {
        return scheduleContentDesc;
    }

    public void setScheduleContentDesc(String scheduleContentDesc) {
        this.scheduleContentDesc = scheduleContentDesc;
    }

    public String getScheduleContentDate() {
        return scheduleContentDate;
    }

    public void setScheduleContentDate(String scheduleContentDate) {
        this.scheduleContentDate = scheduleContentDate;
    }

    public int getScheduleContentCost() {
        return scheduleContentCost;
    }

    public void setScheduleContentCost(int scheduleContentCost) {
        this.scheduleContentCost = scheduleContentCost;
    }

    public int getScheduleNO() {
        return scheduleNO;
    }

    public void setScheduleNO(int scheduleNO) {
        this.scheduleNO = scheduleNO;
    }


}
