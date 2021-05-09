package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import com.liveamonth.liveamonth.model.mapper.reviewMapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReviewServiceImpl implements ReviewService {

    @SuppressWarnings("unused")
	@Autowired
    private ReviewMapper reviewMapper;

    @Override
    public ArrayList<ReviewVO> getAllReviewList() throws Exception {
        return reviewMapper.getAllReviewList();
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
