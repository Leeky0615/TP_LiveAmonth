package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@Data
@Getter
@Setter
public class ReviewVO {

    private int reviewNO;
    private String reviewCategory;
    private String reviewSubject;
    private String reviewDesc;
    private int reviewLikeCount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String reviewDate;
    private int reviewViewCount;

    // Reference
    private int userNO;

    public ReviewVO() {
        this.reviewNO = 0;
        this.reviewCategory = null;
        this.reviewSubject = null;
        this.reviewDesc = null;
        this.reviewLikeCount=0;
        this.reviewDate = null;
        this.reviewViewCount = 0;

        // Reference
        this.userNO = 0;
    }
}
