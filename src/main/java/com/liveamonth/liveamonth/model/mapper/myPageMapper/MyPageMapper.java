package com.liveamonth.liveamonth.model.mapper.myPageMapper;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface MyPageMapper {
	public UserVO getOtherScheduleUserInfo(int userNO) throws Exception;
}
