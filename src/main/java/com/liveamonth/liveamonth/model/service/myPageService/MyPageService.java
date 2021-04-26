package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;

import java.util.List;

public interface MyPageService {
	public UserVO getUserInfo(String userID) throws Exception;
	public void modifyUserInfo(UserVO userVO) throws Exception;
	public List<UserVO> getOtherScheduleUserInfo(List<ScheduleVO> scheduleVOList) throws Exception;
	public void dropUser(String userID) throws Exception;
	public ArrayList<OneToOneAskVO> getOneToOneAskVOList() throws Exception;
	public void addOneToOneAsk(OneToOneAskVO oneToOneAskVO, String userID) throws Exception;
}
