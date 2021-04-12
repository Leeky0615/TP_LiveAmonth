package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.entity.vo.UserVO;

import java.util.List;

public interface MyPageService {
     List<UserVO> getOtherScheduleUserInfo() throws Exception;

}
