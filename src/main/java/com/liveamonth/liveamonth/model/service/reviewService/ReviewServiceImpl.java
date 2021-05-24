package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.ReviewLikeVO;
import com.liveamonth.liveamonth.entity.vo.ReviewReplyVO;
import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import com.liveamonth.liveamonth.model.mapper.reviewMapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import static com.liveamonth.liveamonth.constants.EntityConstants.EPage.DISPLAY_PAGE;
import static com.liveamonth.liveamonth.constants.EntityConstants.EReview.REVIEW_NO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleStaticInt.STATIC_DISPLAY_PAGE_NUM;

import static com.liveamonth.liveamonth.constants.EntityConstants.EPage.DISPLAY_PAGE;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.SCHEDULE_NO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.START_NO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleStaticInt.STATIC_DISPLAY_PAGE_NUM;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private ReviewMapper reviewMapper;
    @Override
    public ArrayList<HashMap<String, Object>> getMainPopularReviewList(int selectPage) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Integer> page = new HashMap<String, Integer>();
        page.put(START_NO.getText(), startNum);
        page.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());
        return reviewMapper.getMainPopularReviewList(page);
    }
    @Override
    public ArrayList<HashMap<String, Object>> getAllReviewList(int selectPage) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Integer> page = new HashMap<String, Integer>();
        page.put(START_NO.getText(), startNum);
        page.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());

        return reviewMapper.getAllReviewList(page);
    }

    @Override
    public ArrayList<HashMap<String, Object>> getFreeReviewList(int selectPage) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Integer> page = new HashMap<String, Integer>();
        page.put(START_NO.getText(), startNum);
        page.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());


        return reviewMapper.getFreeReviewList(page);
    }

    @Override
    public ArrayList<HashMap<String, Object>> getPopularReviewList(int selectPage) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Integer> page = new HashMap<String, Integer>();
        page.put(START_NO.getText(), startNum);
        page.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());

        return reviewMapper.getPopularReviewList(page);
    }

    @Override
    public ArrayList<HashMap<String, Object>> getCategoryReviewList(String category, int selectPage) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Object> CategoryAndPage = new HashMap<String, Object>();
        CategoryAndPage.put("category", category);
        CategoryAndPage.put(START_NO.getText(), startNum);
        CategoryAndPage.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());

        return reviewMapper.getCategoryReviewList(CategoryAndPage);
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

    @Override
    public PagingDTO showPaging(int selectPage, int reviewNO) throws Exception {
        PagingDTO paging = new PagingDTO();
        paging.setPage(selectPage);
        paging.setTotalCount(reviewMapper.getReviewReplyCount(reviewNO));
        return paging;
    }
    @Override
    public PagingDTO showPaging(int selectPage,String category) throws Exception {
        PagingDTO paging = new PagingDTO();
        paging.setPage(selectPage);
        paging.setTotalCount(reviewMapper.getReviewListCount(category));
        System.out.println(category);
        System.out.println(paging.getTotalCount());
        return paging;
    }
    @Override
    public ArrayList<HashMap<String, Object>> getReviewReplyList(int reviewNO, int selectPage) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Integer> reviewNOAndPage = new HashMap<String, Integer>();
        reviewNOAndPage.put(REVIEW_NO.getText(), reviewNO);
        reviewNOAndPage.put(START_NO.getText(), startNum);
        reviewNOAndPage.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());

        ArrayList<HashMap<String, Object>> list = reviewMapper.getReviewReplyList(reviewNOAndPage);

        return list;
    }

    @Override
    public void increaseReviewViewCount(int reviewNO) throws Exception {
        reviewMapper.increaseReviewViewCount(reviewNO);
    }

    public HashMap<String, Integer> getReviewLikeCountAndStatus(ReviewLikeVO reviewLikeVO) throws Exception{
        HashMap<String, Integer> countAndStatus = new HashMap<String, Integer>();

        int likeStatus = reviewMapper.getReviewLikeStatus(reviewLikeVO);
        if(likeStatus == 0){
            reviewMapper.addReviewLike(reviewLikeVO);
            likeStatus = 1;
        } else if (likeStatus == 1){
            reviewMapper.deleteReviewLike(reviewLikeVO);
            likeStatus = 0;
        }
        int likeCount = reviewMapper.getReviewLikeCount(reviewLikeVO.getReviewNO());

        countAndStatus.put(LIKE_STATUS.getText(), likeStatus);
        countAndStatus.put(LIKE_COUNT.getText(), likeCount);

        return countAndStatus;
    }

    @Override
    public void addReviewReply(ReviewReplyVO reviewReplyVO) throws Exception {
        reviewMapper.addReviewReply(reviewReplyVO);
    }

    @Override
    public void modifyReviewReply(ReviewReplyVO reviewReplyVO) throws Exception {
        reviewMapper.modifyReviewReply(reviewReplyVO);
    }

    @Override
    public void deleteReviewReply(int reviewReplyNO) throws Exception {
        reviewMapper.deleteReviewReply(reviewReplyNO);
    }

    @Override
    public void deleteReview(int reviewNO) throws Exception {
        reviewMapper.deleteReview(reviewNO);
    }

    @Override
    public void modifyReview(ReviewVO reviewVO) throws Exception {
        reviewMapper.modifyReview(reviewVO);
    }


    @Override
    public int getReviewLikeCount(int reviewNO) throws Exception {
        return reviewMapper.getReviewLikeCount(reviewNO);
    }

    @Override
    public int getReviewLikeStatus(ReviewLikeVO reviewLikeVO) throws Exception {
        return reviewMapper.getReviewLikeStatus(reviewLikeVO);
    }
}
