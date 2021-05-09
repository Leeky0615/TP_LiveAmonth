package com.liveamonth.liveamonth.entity.vo;

import com.liveamonth.liveamonth.constants.EntityConstants.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class ReviewVO {
    // Attributes
    private int reviewNO;
    private EReviewTypeName reviewType;
    private EReviewCategoryName reviewCategory;
    private String reviewSubject;
    private String reviewDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:MM:SS")
    private String reviewDate;
    private int reviewViewCount;
    private CityName reviewPlace;

    // Reference
    private int userNO;

    // Constructor
    public ReviewVO() {
        this.reviewNO = 0;
        this.reviewType = EReviewTypeName.FREE_BOARD;
        this.reviewCategory = null;
        this.reviewSubject = null;
        this.reviewDesc = null;
        this.reviewDate = null;
        this.reviewViewCount = 0;
        this.reviewPlace = CityName.SEOUL;

        // Reference
        this.userNO = 0;
    }
}
