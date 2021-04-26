package com.liveamonth.liveamonth.model.service.notUserService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.model.mapper.notUserMapper.NotUserMapper;

@Service
public class NotUserServiceImpl implements NotUserService{
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	private NotUserMapper notUserMapper;
	
	@Override
	public ArrayList<OneToOneAskVO> getOneToOneAskReplyVOList() throws Exception {
		return notUserMapper.getOneToOneAskReplyVOList();

	}

	@Override
	public void addOneToOneAskReply(OneToOneAskVO oneToOneAskVO) throws Exception {
		notUserMapper.addOneToOneAskReply(oneToOneAskVO);
		
	}

	@Override
	public OneToOneAskVO findOneToOneAskVO(int oneToOneAskNO) throws Exception {
		return notUserMapper.findOneToOneAskVO(oneToOneAskNO);
		
	}

	@Override
	public void postOneToOneAskReplyFromEmail(OneToOneAskVO oneToOneAskVO) {//unused throws exception
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(oneToOneAskVO.getOneToOneAskUserEmail());
        //message.setFrom();
        message.setSubject("한달살기 문의 답변");
        message.setText(oneToOneAskVO.getOneToOneAskReply());
        
        //밑에 문장 주석풀면 메일전송감.
        mailSender.send(message);
		
	}
}
