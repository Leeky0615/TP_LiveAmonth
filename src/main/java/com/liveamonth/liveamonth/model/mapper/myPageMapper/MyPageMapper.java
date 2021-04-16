package com.liveamonth.liveamonth.model.mapper.myPageMapper;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyPageMapper {
    List<UserVO> getOtherScheduleUserInfo() throws Exception;

    @Select("SELECT * FROM user WHERE userID=#{userID}")
    UserVO getUserInfo(String userID) throws Exception;
}
