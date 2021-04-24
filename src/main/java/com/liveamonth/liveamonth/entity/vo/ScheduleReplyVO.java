package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Getter
@Setter
public class ScheduleReplyVO {
    private int scheduleReplyNO;
    private String scheduleReplyDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String scheduleReplyDate;

    // Reference
    private int scheduleReplyRefNO;
    private int userNO;
    private int scheduleNO;

    public ScheduleReplyVO() {
        this.scheduleReplyNO = 0;
        this.scheduleReplyDesc = null;
        this.scheduleReplyDate = null;

        // Reference
        this.scheduleReplyRefNO = 0;
        this.userNO = 0;
        this.userNO = 0;
    }

	public int getScheduleReplyNO() {
		return scheduleReplyNO;
	}

	public void setScheduleReplyNO(int scheduleReplyNO) {
		this.scheduleReplyNO = scheduleReplyNO;
	}

	public String getScheduleReplyDesc() {
		return scheduleReplyDesc;
	}

	public void setScheduleReplyDesc(String scheduleReplyDesc) {
		this.scheduleReplyDesc = scheduleReplyDesc;
	}

	public String getScheduleReplyDate() {
		return scheduleReplyDate;
	}

	public void setScheduleReplyDate(String scheduleReplyDate) {
		this.scheduleReplyDate = scheduleReplyDate;
	}

	public int getScheduleReplyRefNO() {
		return scheduleReplyRefNO;
	}

	public void setScheduleReplyRefNO(int scheduleReplyRefNO) {
		this.scheduleReplyRefNO = scheduleReplyRefNO;
	}

	public int getUserNO() {
		return userNO;
	}

	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}

	public int getScheduleNO() {
		return scheduleNO;
	}

	public void setScheduleNO(int scheduleNO) {
		this.scheduleNO = scheduleNO;
	}
    
    

}
