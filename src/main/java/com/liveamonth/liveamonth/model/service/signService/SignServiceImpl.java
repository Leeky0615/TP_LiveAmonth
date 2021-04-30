package com.liveamonth.liveamonth.model.service.signService;

import java.io.PrintWriter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.mapper.signMapper.SignMapper;

import javax.servlet.http.HttpServletResponse;


@Service
public class SignServiceImpl implements SignService {

    @Autowired
    private SignMapper signMapper;

    @Override
    public String checkID(String userID) throws Exception {
        return signMapper.checkID(userID);
    }

    @Override
    public String checkNickName(String userNickName) throws Exception {
        return signMapper.checkNickName(userNickName);
    }

    @Override
    public void insertUser(UserVO userVO) throws Exception {
        signMapper.insertUser(userVO);
    }

    @Override
    public UserVO checkSign(String userID, String userPassword) throws Exception {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        hash.put("userID", userID);
        hash.put("userPassword", userPassword);
        UserVO userVO = signMapper.checkSign(hash);

        return userVO;
    }

//    @Override
//    public int checkSign2(String userID, String userPassword) throws Exception {
//        HashMap<String, Object> hash = new HashMap<String, Object>();
//        hash.put("userID", userID);
//        hash.put("userPassword", userPassword);
//        int userNO = signMapper.checkSign2(hash);
//
//        return userNO;
//    }

    @Override
    public String findID(HttpServletResponse response, String userEmail) throws Exception {
        return signMapper.findID(userEmail);
    }

    // 비밀번호 찾기
    @Override
    public String findPW(HttpServletResponse response, String userID, String userEmail) throws Exception {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        hash.put("userID", userID);
        hash.put("userEmail", userEmail);
        return signMapper.findPW(hash);
    }

    @Override
    public String checkEmail(String userEmail) throws Exception {
        System.out.println(signMapper.checkEmail(userEmail));
        return signMapper.checkEmail(userEmail);
    }

}
