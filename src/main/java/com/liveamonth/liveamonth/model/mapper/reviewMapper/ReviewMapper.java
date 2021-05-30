package com.liveamonth.liveamonth.model.mapper.reviewMapper;

import com.liveamonth.liveamonth.entity.vo.ReviewLikeVO;
import com.liveamonth.liveamonth.entity.vo.ReviewReplyVO;
import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface ReviewMapper {
    public ArrayList<HashMap<String, Object>> getDefaultReviewList(String category) throws Exception;

    public ArrayList<HashMap<String, Object>> getCategoryReviewList(HashMap<String, Object> CategoryAndPage) throws Exception;

    public ArrayList<HashMap<String, Object>> getSearchReviewList(HashMap<String, Object> searchAndPage) throws Exception;
    public ArrayList<HashMap<String, Object>> getMainPopularReviewList(HashMap<String, Integer> page) throws Exception;


    public ReviewVO getReviewVO(int reviewNO) throws Exception;

    public int addReview(ReviewVO reviewVO) throws Exception;

    public ArrayList<HashMap<String, Object>> getReviewReplyList(HashMap<String, Integer> reviewNOAndPage) throws Exception;

    public void increaseReviewViewCount(int reviewNO) throws Exception;

    public int getReviewLikeCount(int reviewNO) throws Exception;

    public int getReviewListCount(String category) throws Exception;

    public int getReviewLikeStatus(ReviewLikeVO reviewLikeVO);

    public void addReviewLike(ReviewLikeVO reviewLikeVO) throws Exception;

    public void deleteReviewLike(ReviewLikeVO reviewLikeVO) throws Exception;

    public int getReviewReplyCount(int reviewNO) throws Exception;

    public int addReviewReply(ReviewReplyVO reviewReplyVO) throws Exception;

    public void modifyReviewReply(ReviewReplyVO reviewReplyVO) throws Exception;

    public void deleteReviewReply(int reviewReplyNO) throws Exception;

    public void deleteReview(int reviewNO) throws Exception;

    public void modifyReview(ReviewVO reviewVO) throws Exception;

    public int getSearchReviewListCount(HashMap<String, Object> searchAndPage) throws Exception;

    public ReviewReplyVO getReviewReply(int reviewReplyNO) throws Exception;

    public int getReviewWriterNO(int reviewNO) throws Exception;
}
