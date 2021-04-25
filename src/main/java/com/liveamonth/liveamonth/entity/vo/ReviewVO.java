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

	public int getReviewNO() {
		return reviewNO;
	}

	public void setReviewNO(int reviewNO) {
		this.reviewNO = reviewNO;
	}

	public String getReviewCategory() {
		return reviewCategory;
	}

	public void setReviewCategory(String reviewCategory) {
		this.reviewCategory = reviewCategory;
	}

	public String getReviewSubject() {
		return reviewSubject;
	}

	public void setReviewSubject(String reviewSubject) {
		this.reviewSubject = reviewSubject;
	}

	public String getReviewDesc() {
		return reviewDesc;
	}

	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}

	public int getReviewLikeCount() {
		return reviewLikeCount;
	}

	public void setReviewLikeCount(int reviewLikeCount) {
		this.reviewLikeCount = reviewLikeCount;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewViewCount() {
		return reviewViewCount;
	}

	public void setReviewViewCount(int reviewViewCount) {
		this.reviewViewCount = reviewViewCount;
	}

	public int getUserNO() {
		return userNO;
	}

	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}
    
    
}
