package com.liveamonth.liveamonth.model.service.signService;

import org.springframework.stereotype.Service;


public interface SignService {

	public String checkID(String userID) throws Exception;

	public String checkNickName(String userNickname) throws Exception;

	public void insertUser(String userID, String userPassword, String userName, String userNickname, int userAge,
			String userSex, String userEmail) throws Exception;

	public String checkSign(String userID, String userPassword) throws Exception;

	public String findID(String userEmail) throws Exception;

}
