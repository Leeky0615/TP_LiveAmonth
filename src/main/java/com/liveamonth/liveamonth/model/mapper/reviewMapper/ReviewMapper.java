package com.liveamonth.liveamonth.model.mapper.reviewMapper;

import com.liveamonth.liveamonth.entity.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface ReviewMapper {
    public ArrayList<ReviewVO> getAllReviewList() throws Exception;

    public ReviewVO getReviewVO(int reviewNO) throws Exception;
}
