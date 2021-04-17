package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@Getter
@Setter
public class ReviewReplyVO {

    private int reviewReplyNO;
    private String reviewReplyDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String reviewReplyDate;

    // Reference
    private int reviewReplyRefNO;
    private int userNO;
    private int reviewNO;

    public ReviewReplyVO() {
        this.reviewReplyNO = 0;
        this.reviewReplyDesc = null;
        this.reviewReplyDate = null;

        // Reference
        this.reviewReplyRefNO = 0;
        this.userNO = 0;
        this.userNO = 0;
    }
}
