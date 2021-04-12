package com.liveamonth.liveamonth.model.service.signService;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.springframework.stereotype.Service;


public interface SignService {

	public String checkID(String userID) throws Exception;

	public String checkNickName(String userNickname) throws Exception;

	public void insertUser(UserVO userVO) throws Exception;

	public String checkSign(String userID, String userPassword) throws Exception;

	public String findID(String userEmail) throws Exception;
}
