package com.liveamonth.liveamonth.model.service.signService;

import java.io.PrintWriter;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.mapper.signMapper.SignMapper;

import javax.servlet.http.HttpServletResponse;

import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewImage.S3_UPLOAD_FOLDER;


@Service
public class SignServiceImpl implements SignService {

	@Autowired
	private MailSender mailsender;
	
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
    public UserVO checkSign(String userID, String userPassword) throws Exception {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        hash.put("userID", userID);
        hash.put("userPassword", userPassword);
        UserVO userVO = signMapper.checkSign(hash);

        return userVO;
    }

//    @Override
//    public int checkSign2(String userID, String userPassword) throws Exception {
//        HashMap<String, Object> hash = new HashMap<String, Object>();
//        hash.put("userID", userID);
//        hash.put("userPassword", userPassword);
//        int userNO = signMapper.checkSign2(hash);
//
//        return userNO;
//    }

    @Override
    public String findID( String userName, String userEmail) throws Exception {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        hash.put("userName", userName);
        hash.put("userEmail", userEmail);
        return signMapper.findID(hash);
    }


    
  @Override
  public String findPW(String userID, String userEmail) throws Exception {
      HashMap<String, Object> hash = new HashMap<String, Object>();
      hash.put("userID", userID);
      hash.put("userEmail", userEmail);

      String pw = "";
		for (int i = 0; i < 8; i++) {
			pw += (char) ((Math.random() * 26) + 97);
		}
		
		SimpleMailMessage message = new SimpleMailMessage();
	      message.setTo(userEmail);
	      //message.setFrom();
	      message.setSubject("임시 비밀번호입니다.");
	      message.setText(pw);
	      
	      
	      mailsender.send(message);
	      return signMapper.findPW(hash);
	}  
  
  
  @Transactional
	public String updatePW(String userID, String userEmail) throws Exception {
	      HashMap<String, Object> hash = new HashMap<String, Object>();
	      hash.put("userID", userID);
	      hash.put("userEmail", userEmail);
		return signMapper.updatePW(hash);
	}



  
  
    @Override
    public String checkEmail(String userEmail) throws Exception {
        System.out.println(signMapper.checkEmail(userEmail));
        return signMapper.checkEmail(userEmail);
    }

}
