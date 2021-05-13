package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.vo.ReviewVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReviewService {

    public ArrayList<HashMap<String, Object>> getAllReviewList() throws Exception;

    public ArrayList<HashMap<String, Object>> getFreeReviewList() throws Exception;

    public ArrayList<HashMap<String, Object>> getPopularReviewList() throws Exception;

    ArrayList<HashMap<String, Object>> getCategoryReviewList(String category) throws Exception;

    public ReviewVO getReviewVO(int reviewNO) throws Exception;

    public int addReview(ReviewVO reviewVO) throws Exception;


}
