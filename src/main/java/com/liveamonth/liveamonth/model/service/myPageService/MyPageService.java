package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public interface MyPageService {
	UserVO getUserInfo(String userID) throws Exception;
	void modifyUserInfo(UserVO userVO) throws Exception;
	List<UserVO> getOtherScheduleUserInfo(List<ScheduleVO> scheduleVOList) throws Exception;
	void dropUser(String userID) throws Exception;
	ArrayList<OneToOneAskVO> getOneToOneAskVOList(int userNO) throws Exception;
	void addOneToOneAsk(OneToOneAskVO oneToOneAskVO, int userNO) throws Exception;
	OneToOneAskVO findOneToOneAskVO(int oneToOneAskNO) throws Exception;
	void deleteOneToOneAsk(int oneToOneAskNO) throws Exception;
    void modifyUserImg(String saveName, String userID);
}
