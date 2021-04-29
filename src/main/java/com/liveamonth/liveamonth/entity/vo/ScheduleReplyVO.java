package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class ScheduleReplyVO {
	// Attributes
    private int scheduleReplyNO;
    private String scheduleReplyDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:SS")
    private String scheduleReplyDate;

    // References
    private int scheduleReplyRefNO;
    private int userNO;
    private int scheduleNO;

    // Constructor
    public ScheduleReplyVO() {
        this.scheduleReplyNO = 0;
        this.scheduleReplyDesc = null;
        this.scheduleReplyDate = null;

        this.scheduleReplyRefNO = 0;
        this.userNO = 0;
        this.scheduleNO = 0;
    }

    // Getter & Setter
	public int getScheduleReplyNO() {return scheduleReplyNO;}
	public void setScheduleReplyNO(int scheduleReplyNO) {this.scheduleReplyNO = scheduleReplyNO;}

	public String getScheduleReplyDesc() {return scheduleReplyDesc;}
	public void setScheduleReplyDesc(String scheduleReplyDesc) {this.scheduleReplyDesc = scheduleReplyDesc;}

	public String getScheduleReplyDate() {return scheduleReplyDate;}
	public void setScheduleReplyDate(String scheduleReplyDate) {this.scheduleReplyDate = scheduleReplyDate;}

	public int getScheduleReplyRefNO() {return scheduleReplyRefNO;}
	public void setScheduleReplyRefNO(int scheduleReplyRefNO) {this.scheduleReplyRefNO = scheduleReplyRefNO;}

	public int getUserNO() {return userNO;}
	public void setUserNO(int userNO) {this.userNO = userNO;}

	public int getScheduleNO() {return scheduleNO;}
	public void setScheduleNO(int scheduleNO) {this.scheduleNO = scheduleNO;}
}
