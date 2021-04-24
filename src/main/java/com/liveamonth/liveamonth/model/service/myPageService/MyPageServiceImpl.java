package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.mapper.myPageMapper.MyPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private MyPageMapper myPageMapper;

    @Override
    public List<UserVO> getOtherScheduleUserInfo(List<ScheduleVO> scheduleVOList) throws Exception {

        int userNO = 0;
        List<UserVO> userVOList = new ArrayList<UserVO>();

        for (int i = 0; i < scheduleVOList.size(); i++) {
            userNO = scheduleVOList.get(i).getUserNO();
            UserVO userVo = myPageMapper.getOtherScheduleUserInfo(userNO);
            userVOList.add(userVo);
        }
        return userVOList;
    }

    @Override
    public UserVO getUserInfo(String userID) throws Exception {
        return myPageMapper.getUserInfo(userID);
    }

    @Override
    public void modifyUserInfo(UserVO userVO) throws Exception {
        myPageMapper.modifyUserInfo(userVO);
    }
}