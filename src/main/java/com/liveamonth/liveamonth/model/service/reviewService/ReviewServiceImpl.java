package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.ReviewLikeVO;
import com.liveamonth.liveamonth.entity.vo.ReviewReplyVO;
import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import com.liveamonth.liveamonth.model.mapper.reviewMapper.ReviewMapper;
import com.liveamonth.liveamonth.model.service.noticeService.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import static com.liveamonth.liveamonth.constants.EntityConstants.EPage.DISPLAY_PAGE;
import static com.liveamonth.liveamonth.constants.EntityConstants.EReview.REVIEW_NO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleStaticInt.STATIC_DISPLAY_PAGE_NUM;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private ReviewMapper reviewMapper;

    @Autowired
    private NoticeService noticeService;

    @Override
    public ArrayList<HashMap<String, Object>> getMainPopularReviewList(int selectPage) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Integer> page = new HashMap<String, Integer>();
        page.put(START_NO.getText(), startNum);
        page.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());
        return reviewMapper.getMainPopularReviewList(page);
    }
    @Override
    public ArrayList<HashMap<String, Object>> getDefaultReviewList(String category) throws Exception {
        return reviewMapper.getDefaultReviewList(category);
    }

    @Override
    public ArrayList<HashMap<String, Object>> getCategoryReviewList(String category, int selectPage, String orderBy, String descAsc) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Object> categoryAndPage = new HashMap<String, Object>();
        categoryAndPage.put("category", category);
        categoryAndPage.put("orderBy", orderBy);
        categoryAndPage.put("descAsc", descAsc);
        categoryAndPage.put(START_NO.getText(), startNum);
        categoryAndPage.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());

        return reviewMapper.getCategoryReviewList(categoryAndPage);
    }
    @Override
    public ArrayList<HashMap<String, Object>> getSearchReviewList(int selectPage, String search,String searchDate, String searchCategory, String searchDetail) throws Exception {
        int startNum = (selectPage-1)*15;
        HashMap<String, Object> searchAndPage = new HashMap<String, Object>();
        searchAndPage.put("search",search);
        searchAndPage.put("searchDate",searchDate);
        searchAndPage.put("searchCategory",searchCategory);
        searchAndPage.put("searchDetail",searchDetail);
        searchAndPage.put(START_NO.getText(), startNum);
        searchAndPage.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());
        return reviewMapper.getSearchReviewList(searchAndPage);
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
        if(category.equals("popular")){
            paging.setTotalCount(15);
        }else{
            paging.setTotalCount(reviewMapper.getReviewListCount(category));
        }

        return paging;
    }

    @Override
    public PagingDTO showSearchPaging(int selectPage, String search,String searchDate, String searchCategory, String searchDetail) throws Exception {
        HashMap<String, Object> searchAndPage = new HashMap<String, Object>();
        searchAndPage.put("search",search);
        searchAndPage.put("searchDate",searchDate);
        searchAndPage.put("searchCategory",searchCategory);
        searchAndPage.put("searchDetail",searchDetail);

        PagingDTO paging = new PagingDTO();
        paging.setPage(selectPage);
        paging.setTotalCount(reviewMapper.getSearchReviewListCount(searchAndPage));
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
            int userNO = reviewMapper.getReviewWriterNO(reviewLikeVO.getReviewNO());
            int noticeNO = noticeService.addNotice(userNO, reviewLikeVO.getReviewLikeUserNO());
            noticeService.addRLNotice(noticeNO, reviewLikeVO.getReviewNO());
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
        long rowCount = reviewMapper.addReviewReply(reviewReplyVO);
        long reviewReplyNO = reviewReplyVO.getReviewReplyNO();

        int userNO = reviewMapper.getReviewWriterNO(reviewReplyVO.getReviewNO());
        int noticeNO = noticeService.addNotice(userNO, reviewReplyVO.getUserNO());
        noticeService.addRRNotice(noticeNO, (int)reviewReplyNO);
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
    public String orderByCategoryReview(String orderBy,String clickPage,String dateDescAsc, String likeDescAsc, String viewDescAsc) {
        String descAsc=null;

        switch (orderBy) {
            case "dateOrderBy":
                if(clickPage.equals("null")) {
                    if (dateDescAsc.equals("desc")) {
                        dateDescAsc = "asc";
                    } else {
                        dateDescAsc = "desc";
                    }
                }
                descAsc = dateDescAsc;
                break;
            case "likeOrderBy":
                if(clickPage.equals("null")) {
                    if (likeDescAsc.equals("desc")) {
                        likeDescAsc = "asc";
                    } else {
                        likeDescAsc = "desc";
                    }
                }
                descAsc = likeDescAsc;
                break;
            case "viewOrderBy":
                if(clickPage.equals("null")) {
                    if (viewDescAsc.equals("desc")) {
                        viewDescAsc = "asc";
                    } else {
                        viewDescAsc = "desc";
                    }
                }
                descAsc = viewDescAsc;
                break;
            default:
                break;
        }
        return descAsc;
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
