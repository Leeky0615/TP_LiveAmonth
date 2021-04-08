package com.liveamonth.liveamonth.model.mapper.signMapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.liveamonth.liveamonth.entity.vo.UserVO;

@Repository
public interface SignMapper {

	public String checkID(String userID)throws Exception;

	public String checkNickName(String userNickName) throws Exception;

	public void insertUser(UserVO userVO) throws Exception;

	public String checkSign(HashMap<String, Object> hash) throws Exception;

	public String findID(String userEmail) throws Exception;

	

}
