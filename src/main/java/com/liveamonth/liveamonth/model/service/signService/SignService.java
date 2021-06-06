package com.liveamonth.liveamonth.model.service.signService;

import com.liveamonth.liveamonth.entity.vo.UserVO;


public interface SignService {

    String checkID(String userID) throws Exception;

    String checkNickName(String userNickname) throws Exception;

    void insertUser(UserVO userVO) throws Exception;

    UserVO checkSign(String userID, String userPassword) throws Exception;

    String findID(String userName, String userEmail) throws Exception;

    String findPW(String userID, String userEmail) throws Exception;
    
    String updatePW(String userID, String userEmail) throws Exception;
    
	String checkEmail(String userEmail) throws Exception;

    UserVO setTokenInfo(String access_token) throws Exception;

    String checkNaverID(String naverID) throws Exception;

    int setNewNaverMember(UserVO newNaverUser) throws Exception;

    void updateNaverUser(UserVO userVO) throws Exception;

    UserVO getNaverUser(String naverID) throws Exception;
} 
