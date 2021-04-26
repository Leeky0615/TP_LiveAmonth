package com.liveamonth.liveamonth.model.mapper.notUserMapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;

@Repository
@Mapper
public interface NotUserMapper {
	
	public ArrayList<OneToOneAskVO> getOneToOneAskReplyVOList() throws Exception;

	public void addOneToOneAskReply(OneToOneAskVO oneToOneAskVO) throws Exception;

	public OneToOneAskVO findOneToOneAskVO(int oneToOneAskNO)throws Exception;

}
