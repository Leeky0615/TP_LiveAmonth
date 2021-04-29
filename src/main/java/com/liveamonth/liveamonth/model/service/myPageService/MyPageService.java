package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public interface MyPageService {
	public UserVO getUserInfo(String userID) throws Exception;
	public void modifyUserInfo(UserVO userVO) throws Exception;
	public List<UserVO> getOtherScheduleUserInfo(List<ScheduleVO> scheduleVOList) throws Exception;
	public void dropUser(String userID) throws Exception;
	public ArrayList<OneToOneAskVO> getOneToOneAskVOList(int userNO) throws Exception;
	public void addOneToOneAsk(OneToOneAskVO oneToOneAskVO, int userNO) throws Exception;
	public OneToOneAskVO findOneToOneAskVO(int oneToOneAskNO) throws Exception;
	public void deleteOneToOneAsk(int oneToOneAskNO) throws Exception;
}
