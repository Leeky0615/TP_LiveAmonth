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
    UserVO getUserInfo(String userID) throws Exception;

    void modifyUserInfo(UserVO userVO)throws Exception;

    UserVO getOtherScheduleUserInfo(int userNO) throws Exception;

	void dropUser(String userID) throws Exception;

	ArrayList<OneToOneAskVO> getOneToOneAskVOList(int userNO) throws Exception;

	int getLastOneToOneAskNO() throws Exception;

	void addOneToOneAsk(OneToOneAskVO oneToOneAskVO) throws Exception;

	OneToOneAskVO findOneToOneAskVO(int oneToOneAskNO) throws Exception;

	void deleteOneToOneAsk(int oneToOneAskNO)  throws Exception;
	void modifyUserImg(String saveName, String userID);
}
