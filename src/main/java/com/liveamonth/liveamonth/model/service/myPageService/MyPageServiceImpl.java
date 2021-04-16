package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.mapper.myPageMapper.MyPageMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private MyPageMapper myPageMapper;

    @Override
    public List<UserVO> getOtherScheduleUserInfo() throws Exception {
        return myPageMapper.getOtherScheduleUserInfo();
    }

    @Override
    public UserVO getUserInfo(String userID) throws Exception {
        return myPageMapper.getUserInfo(userID);
    }
}
