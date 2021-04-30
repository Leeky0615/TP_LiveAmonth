package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
@Data
public class ReviewReplyVO {
	// Attributes
    private int reviewReplyNO;
    private String reviewReplyDesc;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String reviewReplyDate;

    // References
    private int reviewReplyRefNO;
    private int userNO;
    private int reviewNO;

    // Constructor
    public ReviewReplyVO() {
        this.reviewReplyNO = 0;
        this.reviewReplyDesc = null;
        this.reviewReplyDate = null;

        this.reviewReplyRefNO = 0;
        this.userNO = 0;
        this.userNO = 0;
    }


    // Getter & Setter
	public int getReviewReplyNO() {
		return reviewReplyNO;
	}
	public void setReviewReplyNO(int reviewReplyNO) {
		this.reviewReplyNO = reviewReplyNO;
	}

	public String getReviewReplyDesc() {
		return reviewReplyDesc;
	}
	public void setReviewReplyDesc(String reviewReplyDesc) {
		this.reviewReplyDesc = reviewReplyDesc;
	}

	public String getReviewReplyDate() {
		return reviewReplyDate;
	}
	public void setReviewReplyDate(String reviewReplyDate) {
		this.reviewReplyDate = reviewReplyDate;
	}

	public int getReviewReplyRefNO() {
		return reviewReplyRefNO;
	}
	public void setReviewReplyRefNO(int reviewReplyRefNO) {
		this.reviewReplyRefNO = reviewReplyRefNO;
	}

	public int getUserNO() {
		return userNO;
	}
	public void setUserNO(int userNO) {
		this.userNO = userNO;
	}

	public int getReviewNO() {
		return reviewNO;
	}
	public void setReviewNO(int reviewNO) {
		this.reviewNO = reviewNO;
	}
}
