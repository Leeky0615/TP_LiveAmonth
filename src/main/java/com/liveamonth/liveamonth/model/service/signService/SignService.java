package com.liveamonth.liveamonth.model.service.signService;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;


public interface SignService {

	public String checkID(String userID) throws Exception;

	public String checkNickName(String userNickname) throws Exception;

	public void insertUser(UserVO userVO) throws Exception;

	public String checkSign(String userID, String userPassword) throws Exception;

	public String findID(HttpServletResponse response, String userEmail) throws Exception;

	public String findID(String userEmail) throws Exception;

	public String findPW(HttpServletResponse response, String userID, String userEmail) throws Exception;

    
}
