package com.liveamonth.liveamonth.model.service.signService;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;


public interface SignService {

    String checkID(String userID) throws Exception;

    String checkNickName(String userNickname) throws Exception;

    void insertUser(UserVO userVO) throws Exception;

    String checkSign(String userID, String userPassword) throws Exception;

    String findID(HttpServletResponse response, String userEmail) throws Exception;

    String IDFind(HttpServletResponse response, String userEmail) throws Exception;

    String PWFind(HttpServletResponse response, String userID, String userEmail) throws Exception;

    String findID(String userEmail) throws Exception;
}
