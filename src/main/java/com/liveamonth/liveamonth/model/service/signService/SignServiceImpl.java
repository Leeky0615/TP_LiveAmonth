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
    public String findID(String userEmail) throws Exception {
        return signMapper.findID(userEmail);
    }

    @Override
    public String findID(HttpServletResponse response, String userEmail) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = signMapper.IDFind(userEmail);

        if (id == null) {
            out.println("<script>");
            out.println("alert('가입된 아이디가 없습니다.');");
            out.println("history.go(-1);");
            out.println("</script>");
            out.close();
            return null;
        } else {
            return id;
        }
    }

    // 비밀번호 찾기
    @Override
    public String findPW(HttpServletResponse response, String userID, String userEmail) throws Exception {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HashMap<String, Object> hash = new HashMap<String, Object>();
        hash.put("userID", userID);
        hash.put("userEmail", userEmail);

        String pw = signMapper.PWFind(hash);
        if (pw == null) {
            out.println("<script>");
            out.println("alert('가입하지 않은 아이디이거나, 잘못된 이메일입니다.');");
            out.println("history.go(-1);");
            out.println("</script>");
            out.close();
            return null;
        } else {
            return pw;
        }
    }

	@Override
	public String checkEmail(String userEmail) throws Exception {
		System.out.println(signMapper.checkEmail(userEmail));
		return signMapper.checkEmail(userEmail);
	}


}
