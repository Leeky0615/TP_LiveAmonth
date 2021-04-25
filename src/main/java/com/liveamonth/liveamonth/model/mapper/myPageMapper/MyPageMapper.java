package com.liveamonth.liveamonth.model.mapper.myPageMapper;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MyPageMapper {
    @Select("SELECT * FROM user WHERE userID=#{userID}")
    public UserVO getUserInfo(String userID) throws Exception;

    @Update("UPDATE user SET userPassword=#{userPassword}," +
            "userNickname=#{userNickname}," +
            "userEmail=#{userEmail}" +
            "WHERE userID=#{userID}")
    public void modifyUserInfo(UserVO userVO)throws Exception;

	public UserVO getOtherScheduleUserInfo(int userNO) throws Exception;
}