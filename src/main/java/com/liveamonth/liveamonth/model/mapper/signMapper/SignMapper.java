package com.liveamonth.liveamonth.model.mapper.signMapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.liveamonth.liveamonth.entity.vo.UserVO;

@Repository
@Mapper
public interface SignMapper {

    String checkID(String userID) throws Exception;
    String checkNickName(String userNickName) throws Exception;
    void insertUser(UserVO userVO) throws Exception;
    String checkSign(HashMap<String, Object> hash) throws Exception;
    String findID(String userEmail) throws Exception;
}
