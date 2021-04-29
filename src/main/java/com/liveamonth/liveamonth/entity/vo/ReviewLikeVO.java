package com.liveamonth.liveamonth.entity.vo;

import lombok.Data;

@Data
public class ReviewLikeVO {
	// Attributes
	private int reviewLikeUserNO;

	private int reviewNO; // Reference

	// Constructor
	public ReviewLikeVO() {
		this.reviewNO = 0;

		this.reviewLikeUserNO = 0;
	}

	// Getter & Setter
	public int getReviewNO() {return reviewNO;}
	public void setReviewNO(int reviewNO) {this.reviewNO = reviewNO;}

	public int getReviewLikeUserNO() {return reviewLikeUserNO;}
	public void setReviewLikeUserNO(int reviewLikeUserNO) {this.reviewLikeUserNO = reviewLikeUserNO;}
}
