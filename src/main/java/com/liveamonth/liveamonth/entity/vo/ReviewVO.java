package com.liveamonth.liveamonth.entity.vo;

import com.liveamonth.liveamonth.constants.EntityConstants;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import static com.liveamonth.liveamonth.constants.EntityConstants.ImageURL;

@Data
public class ReviewVO {
    // Attributes
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

    // Constructor
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

    // Getter & Setter
    public int getReviewNO() {return reviewNO;}
    public void setReviewNO(int reviewNO) {this.reviewNO = reviewNO;}

    public String getReviewCategory() {return reviewCategory;}
    public void setReviewCategory(String reviewCategory) {this.reviewCategory = reviewCategory;}

    public String getReviewSubject() {return reviewSubject;}
    public void setReviewSubject(String reviewSubject) {this.reviewSubject = reviewSubject;}

    public String getReviewDesc() {return reviewDesc;}
    public void setReviewDesc(String reviewDesc) {this.reviewDesc = reviewDesc;}

    public String getReviewDate() {return reviewDate;}
    public void setReviewDate(String reviewDate) {this.reviewDate = reviewDate;}

    public int getReviewViewCount() {return reviewViewCount;}
    public void setReviewViewCount(int reviewViewCount) {this.reviewViewCount = reviewViewCount;}

    public String getReviewImage() {return reviewImage;}
    public void setReviewImage(String reviewImage) {this.reviewImage = reviewImage;}

    public int getUserNO() {return userNO;}
    public void setUserNO(int userNO) {this.userNO = userNO;}

    // Get URL
    public String getReviewImageURL(){
        return ImageURL+"review/"+this.getReviewImage();
    }
}
