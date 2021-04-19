package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;

import java.util.List;

public interface MyPageService {
     UserVO getUserInfo(String userID) throws Exception;
     void modifyUserInfo(UserVO userVO) throws Exception;
     List<UserVO> getOtherScheduleUserInfo(List<ScheduleVO> scheduleVOList) throws Exception;
}
