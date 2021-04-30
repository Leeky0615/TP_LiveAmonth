package com.liveamonth.liveamonth.model.service.myPageService;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.mapper.myPageMapper.MyPageMapper;
import com.liveamonth.liveamonth.model.mapper.scheduleMapper.ScheduleMapper;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.util.*;
import java.text.*;

@Service
public class MyPageServiceImpl implements MyPageService {

    @Autowired
    private MyPageMapper myPageMapper;

    @Autowired
    private ScheduleMapper scheduleMapper;

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
    public UserVO getUserInfo(String userID) throws Exception {return myPageMapper.getUserInfo(userID);}

    @Override
    public void modifyUserInfo(UserVO userVO) throws Exception {myPageMapper.modifyUserInfo(userVO);}

    @Override
	public void dropUser(String userID) throws Exception {myPageMapper.dropUser(userID);}

	@Override
	public ArrayList<OneToOneAskVO> getOneToOneAskVOList(int userNO) throws Exception {
		return myPageMapper.getOneToOneAskVOList(userNO);

	}

	@Override
	public void addOneToOneAsk(OneToOneAskVO oneToOneAskVO, int userNO) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date currentTime = new Date();
		String dTime = formatter.format(currentTime);
		System.out.println(dTime);

		oneToOneAskVO.setOneToOneAskNO(myPageMapper.getLastOneToOneAskNO() + 1);
		oneToOneAskVO.setOneToOneAskDate(dTime);
		oneToOneAskVO.setUserNO(userNO);
		myPageMapper.addOneToOneAsk(oneToOneAskVO);
	}

	@Override
	public OneToOneAskVO findOneToOneAskVO(int oneToOneAskNO) throws Exception {
		return myPageMapper.findOneToOneAskVO(oneToOneAskNO);
	}

	@Override
	public void deleteOneToOneAsk(int oneToOneAskNO) throws Exception {
		myPageMapper.deleteOneToOneAsk(oneToOneAskNO);
		
	}
}
