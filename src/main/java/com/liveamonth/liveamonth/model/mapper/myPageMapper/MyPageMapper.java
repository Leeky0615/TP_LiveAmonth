package com.liveamonth.liveamonth.model.mapper.myPageMapper;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyPageMapper {
    @Select("select * from user where userNO in (select userNO from schedule where schedule.scheduleStatus = true)")
    List<UserVO> getOtherScheduleUserInfo() throws Exception;

    @Select("SELECT * FROM user WHERE userID=#{userID}")
    UserVO getUserInfo(String userID) throws Exception;

    @Update("UPDATE user SET userPassword=#{userPassword}," +
            "userNickname=#{userNickname}," +
            "userEmail=#{userEmail}" +
            "WHERE userID=#{userID}")
    void modifyUserInfo(UserVO userVO)throws Exception;
}
