package com.liveamonth.liveamonth.model.mapper.signMapper;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Mapper
public interface SignMapper {
    String checkID(String userID) throws Exception;

    String checkNickName(String userNickName) throws Exception;

    void insertUser(UserVO userVO) throws Exception;

    UserVO checkSign(HashMap<String, Object> hash) throws Exception;

    String findID(String userName, String userEmail) throws Exception;

    String findPW(String userID, String userName, String userEmail) throws Exception;

    void updatePW(String userID, String password) throws Exception;

    String checkEmail(String userEmail)  throws Exception;

    String checkNaverID(String naverID) throws Exception;

    int setNewNaverMember(UserVO newNaverUser) throws Exception;

    void updateNaverUser(UserVO userVO) throws Exception;

    UserVO getNaverUser(String naverID) throws Exception;

    UserVO searchUserById(String userID);
} 
