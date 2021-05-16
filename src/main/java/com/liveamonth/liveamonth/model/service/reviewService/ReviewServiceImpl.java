package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import com.liveamonth.liveamonth.model.mapper.reviewMapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

import static com.liveamonth.liveamonth.constants.EntityConstants.EPage.DISPLAY_PAGE;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.SCHEDULE_NO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.START_NO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleStaticInt.STATIC_DISPLAY_PAGE_NUM;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
    private ReviewMapper reviewMapper;

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
    public PagingDTO showPaging(int selectPage,String category) throws Exception {
        PagingDTO paging = new PagingDTO();
        paging.setPage(selectPage);
        paging.setTotalCount(reviewMapper.getReviewListCount(category));
        System.out.println(category);
        System.out.println(paging.getTotalCount());
        return paging;
    }
}
