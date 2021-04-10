package com.liveamonth.liveamonth.model.service.signService;

import org.springframework.stereotype.Service;


public interface SignService {

	String checkID(String userID) throws Exception;
	String checkNickName(String userNickname) throws Exception;
	void insertUser(String userID, String userPassword, String userName, String userNickname, int userAge,
			String userSex, String userEmail) throws Exception;
	String checkSign(String userID, String userPassword) throws Exception;
	String findID(String userEmail) throws Exception;
}
