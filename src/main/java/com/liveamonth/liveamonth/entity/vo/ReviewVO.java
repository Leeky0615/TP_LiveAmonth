package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@Data
public class ReviewVO {

    private int reviewNO;
    private String reviewCategory;
    private String reviewSubject;
    private String reviewDesc;
 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String reviewDate;
    private int reviewViewCount;
    private String reviewImage;
    // Reference
    private int userNO;

    public ReviewVO() {
        this.reviewNO = 0;
        this.reviewCategory = null;
        this.reviewSubject = null;
        this.reviewDesc = null;
        this.reviewDate = null;
        this.reviewViewCount = 0;
        this.reviewImage = null;

        // Reference
        this.userNO = 0;
    }

	
    
    
}
