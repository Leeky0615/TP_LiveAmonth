package com.liveamonth.liveamonth.model.service.signService;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;


public interface SignService {

    String checkID(String userID) throws Exception;

    String checkNickName(String userNickname) throws Exception;

    void insertUser(UserVO userVO) throws Exception;

    UserVO checkSign(String userID, String userPassword) throws Exception;


    // public int checkSign2(String userID, String userPassword) throws Exception;

    String findID(String userName, String userEmail) throws Exception;

    String findPW(String userID, String userEmail) throws Exception;

	String checkEmail(String userEmail) throws Exception;


}
