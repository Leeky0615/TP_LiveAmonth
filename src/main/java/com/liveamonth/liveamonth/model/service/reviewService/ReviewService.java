package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.vo.ReviewVO;

import java.util.ArrayList;

public interface ReviewService {

    public ArrayList<ReviewVO> getAllReviewList() throws Exception;

    public ReviewVO getReviewVO(int reviewNO) throws Exception;

    public int addReview(ReviewVO reviewVO) throws Exception;
}
