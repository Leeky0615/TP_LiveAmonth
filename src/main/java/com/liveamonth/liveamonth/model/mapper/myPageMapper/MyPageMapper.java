package com.liveamonth.liveamonth.model.mapper.myPageMapper;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Mapper
public interface MyPageMapper {
    @Select("SELECT * FROM user WHERE userID=#{userID}")
    UserVO getUserInfo(String userID) throws Exception;

    @Update("UPDATE user SET userPassword=#{userPassword}," +
            "userNickname=#{userNickname}," +
            "userEmail=#{userEmail}" +
            "WHERE userID=#{userID}")
    public void modifyUserInfo(UserVO userVO)throws Exception;

    public UserVO getOtherScheduleUserInfo(int userNO) throws Exception;
	
	public void dropUser(String userID) throws Exception;

	public ArrayList<OneToOneAskVO> getOneToOneAskVOList() throws Exception;

	public int getLastOneToOneAskNO() throws Exception;

	public void addOneToOneAsk(OneToOneAskVO oneToOneAskVO) throws Exception;
}


