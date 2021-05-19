package com.liveamonth.liveamonth.model.service.signService;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.mapper.signMapper.SignMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


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
        return signMapper.findPW(hash);
    }

    @Override
    public String checkEmail(String userEmail) throws Exception {
        System.out.println(signMapper.checkEmail(userEmail));
        return signMapper.checkEmail(userEmail);
    }

    @Override
    public UserVO setTokenInfo(String access_token) throws Exception {
        UserVO naverUserVO = new UserVO();

        String header = "Bearer " + access_token;
        String apiurl = "https://openapi.naver.com/v1/nid/me";
        URL url = new URL(apiurl);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", header);
        int responseCode = con.getResponseCode();
        BufferedReader br;
        StringBuffer res = new StringBuffer();

        if(responseCode==200) { // 정상 호출
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                res.append(inputLine);
            }

            JSONParser parsing = new JSONParser();
            Object obj = parsing.parse(res.toString());
            JSONObject jsonObj = (JSONObject)obj;
            JSONObject resObj = (JSONObject)jsonObj.get("response");

            String naverID = (String)resObj.get("id");
            String email = (String)resObj.get("email");
            String name = (String)resObj.get("name");
            String stringGender = (String)resObj.get("gender");
            String birthyear = (String)resObj.get("birthyear");
            String nickname = (String)resObj.get("nickname");

            boolean gender;

            if(stringGender.equals("M")){
                gender = false;
            }else{
                gender = true;
            }
            naverUserVO.setUserID(naverID);
            naverUserVO.setUserAge(Integer.parseInt(birthyear));
            naverUserVO.setUserEmail(email);
            naverUserVO.setUserName(name);
            naverUserVO.setUserSex(gender);
            naverUserVO.setUserNickname(nickname);

        } else {  // 에러 발생
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        br.close();
        return naverUserVO;
    }

    @Override
    public String checkNaverID(String naverID) throws Exception {
        return this.signMapper.checkNaverID(naverID);
    }

    @Override
    public int setNewNaverMember(UserVO newNaverUser) throws Exception {
        return this.signMapper.setNewNaverMember(newNaverUser);
    }

}
