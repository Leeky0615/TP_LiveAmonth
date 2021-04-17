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

}
