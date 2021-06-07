package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.ReviewLikeVO;
import com.liveamonth.liveamonth.entity.vo.ReviewReplyVO;
import com.liveamonth.liveamonth.entity.vo.ReviewVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface ReviewService {
    List<HashMap<String, Object>> getPopularReviewListForMain() throws Exception;

    ArrayList<HashMap<String, Object>> getDefaultReviewList(String category) throws Exception;

    ArrayList<HashMap<String, Object>> getSearchReviewList(int selectPage, String search, String searchDate, String searchCategory, String searchDetail) throws Exception;

    ArrayList<HashMap<String, Object>> getCategoryReviewList(String category, int selectPage, String orderBy, String descAsc) throws Exception;

    ArrayList<HashMap<String, Object>> getMyReviewList(int selectPage, int userNO, String manageReviewCategory) throws Exception;

    ReviewVO getReviewVO(int reviewNO) throws Exception;

    int addReview(ReviewVO reviewVO) throws Exception;

    ArrayList<HashMap<String, Object>> getReviewReplyList(int reviewNO, int selectPage) throws Exception;

    void increaseReviewViewCount(int reviewNO) throws Exception;

    int getReviewLikeCount(int reviewNO) throws Exception;

    int getReviewLikeStatus(ReviewLikeVO reviewLikeVO) throws Exception;

    HashMap<String, Integer> getReviewLikeCountAndStatus(ReviewLikeVO reviewLikeVO) throws Exception;

    PagingDTO showPaging(int selectPage, int reviewNO) throws Exception;

    PagingDTO showPaging(int selectPage, String category) throws Exception;

    PagingDTO showSearchPaging(int selectPage, String search, String searchDate, String searchCategory, String searchDetail) throws Exception;

    PagingDTO showMyReviewPaging(int selectPage, String manageReviewCategory, int userNO) throws Exception;

    void addReviewReply(ReviewReplyVO reviewReplyVO) throws Exception;

    void modifyReviewReply(ReviewReplyVO reviewReplyVO) throws Exception;

    void deleteReviewReply(int reviewReplyNO) throws Exception;

    void deleteReview(int reviewNO) throws Exception;

    void deleteReviewList(int[] reviewNO_OR_reviewReplyNOList, String manageReviewCategory) throws Exception;

    void modifyReview(ReviewVO reviewVO) throws Exception;

    String orderByCategoryReview(String orderBy, String clickPage, String dateDescAsc, String likeDescAsc, String viewDescAsc);


}
