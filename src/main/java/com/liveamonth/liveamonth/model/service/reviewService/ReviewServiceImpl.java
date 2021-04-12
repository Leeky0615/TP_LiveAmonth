package com.liveamonth.liveamonth.model.service.reviewService;

import com.liveamonth.liveamonth.model.mapper.reviewMapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMapper reviewMapper;

}
