package com.liveamonth.liveamonth.model.service.signService;

import java.io.PrintWriter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.mapper.signMapper.SignMapper;

import javax.servlet.http.HttpServletResponse;


@Service
public class SignServiceImpl implements SignService {
	
	@Autowired
	private SignMapper signMapper;

	@Override
	public String checkID(String userID) throws Exception {
		return signMapper.checkID(userID);
	}

	@Override
	public String checkNickName(String userNickName) throws Exception {
		return signMapper.checkNickName(userNickName);
	}

	@Override
	public void insertUser(UserVO userVO) throws Exception {
		signMapper.insertUser(userVO);
	}

	@Override
	public String checkSign(String userID, String userPassword) throws Exception {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("userID", userID);
		hash.put("userPassword", userPassword);
		String userName = signMapper.checkSign(hash);

		return userName;
	}



	@Override
	public String findID(HttpServletResponse response, String userEmail) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = signMapper.findID(userEmail);

			return id;
		
	}

	

	// 鍮꾨�踰덊샇 李얘린
	@Override
	public String findPW(HttpServletResponse response, String userID, String userEmail) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("userID", userID);
		hash.put("userEmail", userEmail);

		String pw = signMapper.findPW(hash);

			return pw;
		
	}

	@Override
	public void dropUser(String userID) throws Exception {
		signMapper.dropUser(userID);
		
	}

}
