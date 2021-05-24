package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.ReviewLikeVO;
import com.liveamonth.liveamonth.entity.vo.ReviewReplyVO;
import com.liveamonth.liveamonth.entity.vo.ReviewVO;

import java.util.ArrayList;
import java.util.HashMap;

public interface ReviewService {
    public ArrayList<HashMap<String, Object>> getMainPopularReviewList(int selectPage) throws Exception;

    public ArrayList<HashMap<String, Object>> getDefaultReviewList(String category) throws Exception;

    public  ArrayList<HashMap<String, Object>> getSearchReviewList(int selectPage, String search,String searchDate, String searchCategory, String searchDetail) throws Exception;

    ArrayList<HashMap<String, Object>> getCategoryReviewList(String category, int selectPage, String orderBy, String descAsc) throws Exception;

    public ReviewVO getReviewVO(int reviewNO) throws Exception;

    public int addReview(ReviewVO reviewVO) throws Exception;

    public ArrayList<HashMap<String, Object>> getReviewReplyList(int reviewNO, int selectPage) throws Exception;

    public void increaseReviewViewCount(int reviewNO) throws Exception;

    public int getReviewLikeCount(int reviewNO) throws Exception;

    public int getReviewLikeStatus(ReviewLikeVO reviewLikeVO) throws Exception;

    public HashMap<String, Integer> getReviewLikeCountAndStatus(ReviewLikeVO reviewLikeVO) throws Exception;

    public PagingDTO showPaging(int selectPage, int reviewNO) throws Exception;

    public PagingDTO showPaging(int selectPage, String category) throws Exception;

    public PagingDTO showSearchPaging(int selectPage, String search,String searchDate, String searchCategory, String searchDetail) throws Exception;

    public void addReviewReply(ReviewReplyVO reviewReplyVO) throws Exception;

    public void modifyReviewReply(ReviewReplyVO reviewReplyVO) throws Exception;

    public void deleteReviewReply(int reviewReplyNO) throws Exception;

    public void deleteReview(int reviewNO) throws Exception;

    public void modifyReview(ReviewVO reviewVO) throws Exception;

    public String orderByCategoryReview(String orderBy,String clickPage,String dateDescAsc, String likeDescAsc, String viewDescAsc);



}
