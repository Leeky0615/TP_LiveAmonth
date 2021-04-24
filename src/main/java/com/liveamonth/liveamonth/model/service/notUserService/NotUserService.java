package com.liveamonth.liveamonth.model.service.notUserService;

import java.util.ArrayList;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;

public interface NotUserService {

	public ArrayList<OneToOneAskVO> getOneToOneAskReplyVOList() throws Exception;

	public void addOneToOneAskReply(OneToOneAskVO oneToOneAskVO) throws Exception;
	
	public void postOneToOneAskReplyFromEmail(OneToOneAskVO oneToOneAskVO); //unused throws Exception

	public OneToOneAskVO findOneToOneAskVO(int oneToOneAskNO) throws Exception;

	


}
