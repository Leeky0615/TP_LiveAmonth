package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.ReviewVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReviewService {

    public ArrayList<HashMap<String, Object>> getAllReviewList(int selectPage) throws Exception;

    public ArrayList<HashMap<String, Object>> getFreeReviewList(int selectPage) throws Exception;

    public ArrayList<HashMap<String, Object>> getPopularReviewList(int selectPage) throws Exception;

    ArrayList<HashMap<String, Object>> getCategoryReviewList(String category,int selectPage) throws Exception;

    public ReviewVO getReviewVO(int reviewNO) throws Exception;

    public int addReview(ReviewVO reviewVO) throws Exception;


    public PagingDTO showPaging(int selectPage, String category) throws Exception;
}
