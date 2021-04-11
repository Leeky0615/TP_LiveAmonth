package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.model.mapper.myPageMapper.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private MyPageMapper myPageMapper;
}
