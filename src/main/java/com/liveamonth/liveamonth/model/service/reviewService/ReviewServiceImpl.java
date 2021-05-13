package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import com.liveamonth.liveamonth.model.mapper.reviewMapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private ReviewMapper reviewMapper;

    @Override
    public ArrayList<HashMap<String, Object>> getAllReviewList() throws Exception {

        return reviewMapper.getAllReviewList();
    }

    @Override
    public ArrayList<HashMap<String, Object>> getFreeReviewList() throws Exception {
        return reviewMapper.getFreeReviewList();
    }

    @Override
    public ArrayList<HashMap<String, Object>> getPopularReviewList() throws Exception {
        return reviewMapper.getPopularReviewList();
    }

    @Override
    public ArrayList<HashMap<String, Object>> getCategoryReviewList(String category) throws Exception {
        return reviewMapper.getCategoryReviewList(category);
    }

    @Override
    public ReviewVO getReviewVO(int reviewNO) throws Exception {
        return reviewMapper.getReviewVO(reviewNO);
    }

    @Override
    public int addReview(ReviewVO reviewVO) throws Exception {
        long rowCount = reviewMapper.addReview(reviewVO);
        long reviewNO = reviewVO.getReviewNO();
        return (int)reviewNO;
    }
}
