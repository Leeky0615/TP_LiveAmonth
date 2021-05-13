package com.liveamonth.liveamonth.model.mapper.reviewMapper;

import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface ReviewMapper {
    public ArrayList<HashMap<String, Object>> getAllReviewList() throws Exception;

    public ArrayList<HashMap<String, Object>> getFreeReviewList()throws Exception;

    public ArrayList<HashMap<String, Object>> getPopularReviewList()throws Exception;

    public ArrayList<HashMap<String, Object>> getCategoryReviewList(String category);

    public ReviewVO getReviewVO(int reviewNO) throws Exception;

    public int addReview(ReviewVO reviewVO)throws Exception;



}
