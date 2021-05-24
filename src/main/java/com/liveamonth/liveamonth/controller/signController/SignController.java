package com.liveamonth.liveamonth.controller.signController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.constants.EntityConstants;
import com.liveamonth.liveamonth.constants.EntityConstants.EEmail;
import com.liveamonth.liveamonth.constants.LogicConstants;
import com.liveamonth.liveamonth.entity.dto.S3UploaderDTO;
import com.liveamonth.liveamonth.constants.EntityConstants.EEmail;
import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import com.liveamonth.liveamonth.model.service.reviewService.ReviewService;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import com.liveamonth.liveamonth.model.service.signService.SignService;
import com.sun.deploy.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.liveamonth.liveamonth.model.service.signService.SignService;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMainPath.MAIN;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESignPath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EEmail.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESignUp.EMAIL;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESignUp.EMAIL;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReview.POPULAR_REVIEW_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewImage.S3_UPLOAD_FOLDER;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.FITERED_OTHER_SCHEDULE_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleFilterAndOrders.SCHEDULE_FO_ORDER;
import static com.liveamonth.liveamonth.constants.LogicConstants.ESignAttributes.AT;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ESignAttributes.FIRST_IN;
import static com.liveamonth.liveamonth.constants.LogicConstants.ESignAttributes.AT;

@Controller
public class SignController {
    private boolean firstIn;
    @Autowired
    private S3UploaderDTO s3Uploader;

    @Autowired
    private SignService signService;

    @Autowired
    private CityService cityService;
    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ScheduleService scheduleService;

    //naver login api에 접속
    @RequestMapping("/signIn")
    public String SignInPage(Model model, HttpSession session) throws Exception {
        this.firstIn = true;

        String clientId = "mS20tLuLdThxAjEEr_yP";//애플리케이션 클라이언트 아이디값";
        String redirectURI = URLEncoder.encode("http://localhost:8080/naverLogin", "UTF-8");
        SecureRandom random = new SecureRandom();
        String state = new BigInteger(130, random).toString();
        String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
        apiURL += "&client_id=" + clientId;
        apiURL += "&redirect_uri=" + redirectURI;
        apiURL += "&state=" + state;
        session.setAttribute("state", state);

        model.addAttribute(FIRST_IN.getText(), this.firstIn);
        model.addAttribute("apiURL", apiURL);

        return SIGN_IN.getPath();
    }

    private void setMainPageAttributes(Model model) throws Exception {
        // 인기 REVIEW
        model.addAttribute(POPULAR_REVIEW_LIST.getText(), reviewService.getMainPopularReviewList(1));
        // 인기 SCHEDULE
        model.addAttribute(FITERED_OTHER_SCHEDULE_LIST.getText(), scheduleService.getMainOtherScheduleList());
        // MainCitySlide.jsp 사용
        model.addAttribute(RANDOM_CITY_INTRO_LIST.getText(), cityService.getRandomCityInfoListByCategory(INTRO.name()));
        // CityInfoGrid.jsp 사용
        model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));
    }

    @RequestMapping("/logout")
    private String logout(HttpSession session, Model model) throws Exception {
        session.invalidate();
        this.setMainPageAttributes(model);
        return MAIN.getPath();
    }

    @RequestMapping("/checkSign")
    public String checkSign(Model model, HttpServletRequest request, HttpSession session) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        UserVO userVO = signService.checkSign(userID, userPassword);

        if (userVO == null) {
            model.addAttribute(FIRST_IN.getText(), false);
            return SIGN_IN.getPath();
        } else {
            session.setAttribute(USER_VO.getText(), userVO);
            this.setMainPageAttributes(model);
            return MAIN.getPath();
        }
    }

    @RequestMapping("/signUp")
    public String SignUpPage(Model model) throws Exception {
        model.addAttribute(EMAIL.getText(), EEmail.values());
        return SIGN_UP.getPath();
    }

    @RequestMapping("/naverSignUp")
    public String naverSignUp(Model model) throws Exception {
        model.addAttribute(EMAIL.getText(), EEmail.values());
        return "signView/NaverSignUp";
    }

    @ResponseBody
    @PostMapping(value = "/checkID")
    public int postCheckID(HttpServletRequest request) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String idCheck = signService.checkID(userID);

        int idExist = 0;
        if (idCheck != null) idExist = 1;
        return idExist;
    }

    @ResponseBody
    @PostMapping(value = "/checkNickName")
    public int postNickNameCheck(HttpServletRequest request) throws Exception {
        String userNickname = request.getParameter(USER_NICKNAME.getText());
        String nickNameCheck = signService.checkNickName(userNickname);

        int nickNameExist = 0;
        if (nickNameCheck != null) nickNameExist = 1;
        return nickNameExist;
    }

    @ResponseBody
    @PostMapping(value = "/checkEmail")
    public int postCheckEmailCheck(HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter(USER_EMAIL.getText());
        String emailCheck = signService.checkEmail(userEmail);

        int emailExist = 0;
        if (emailCheck != null) emailExist = 1;
        System.out.println(emailCheck);
        return emailExist;
    }

    @RequestMapping("/resultMentSignUp")
    private String resultMentSignUp(@ModelAttribute UserVO userVO, HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter(USER_EMAIL.getText());
        String email = request.getParameter(EMAIL.getText());

        userVO.setUserEmail(userEmail + AT.getText() + email);

        signService.insertUser(userVO);
        return RESULT_MENT_SIGN_UP.getPath();
    }

    @RequestMapping("/resultMentNaverSignUp")
    private String resultMentNaverSignUp(@ModelAttribute UserVO userVO, HttpServletRequest request) throws Exception {
        //email을 갖고 있는 경우와 아닌 경우
        if(!userVO.getUserEmail().contains("@")){
            String userEmail = request.getParameter(USER_EMAIL.getText());
            String email = request.getParameter(EMAIL.getText());
            userVO.setUserEmail(userEmail + AT.getText() + email);
        }
        signService.updateNaverUser(userVO);

        return "signView/ResultMentSignUp";
    }

    @RequestMapping(value = "/resultMentFindID", method = RequestMethod.POST)
    public String findID(@RequestParam("userName")
                                 String userName, @RequestParam("userEmail") String userEmail, Model model) throws Exception {
        model.addAttribute(USER_ID.getText(), signService.findID(userName, userEmail));

        if (signService.findID(userName, userEmail) == null)
            this.firstIn = false;
        model.addAttribute(FIRST_IN.getText(), this.firstIn);

        return RESULT_MENT_FIND_ID.getPath();
    }


    @RequestMapping("/findID")
    private String findID(Model model) throws Exception {

        this.firstIn = true;
        model.addAttribute(FIRST_IN.getText(), this.firstIn);
        return FIND_ID.getPath();
    }


    @RequestMapping("/findPW")
    private String findPW() throws Exception {
        return FIND_PW.getPath();
    }


    @RequestMapping(value = "/ResultMentFindPW", method = RequestMethod.POST)
    public String findPW(@RequestParam("userID")
                                 String userID, @RequestParam("userEmail") String userEmail, Model model) throws Exception {
        model.addAttribute(USER_PASSWORD.getText(), signService.findPW(userID, userEmail));

        if (signService.findPW(userID, userEmail) == null)
            this.firstIn = false;
        model.addAttribute(FIRST_IN.getText(), this.firstIn);
        return RESULT_MENT_FIND_PW.getPath();
    }

    @RequestMapping("/naverLogin")
    private String naverLogin(HttpSession session, HttpServletRequest request, Model model) throws Exception {
        String clientId = "mS20tLuLdThxAjEEr_yP";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "CA3T9EN7Wo";//애플리케이션 클라이언트 시크릿값";

        String code = request.getParameter("code");
        String state = request.getParameter("state");
        String redirectURI = URLEncoder.encode("http://localhost:8080/Naver", "UTF-8");
        String access_token = "";

        StringBuffer apiURL = new StringBuffer();
        apiURL.append("https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&");
        apiURL.append("client_id=" + clientId);
        apiURL.append("&client_secret=" + clientSecret);
        apiURL.append("&redirect_uri=" + redirectURI);
        apiURL.append("&code=" + code);
        apiURL.append("&state=" + state);

        try {
            URL url = new URL(apiURL.toString());
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) { // 정상 호출
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {  // 에러 발생
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer res = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                res.append(inputLine);
            }
            br.close();
            if (responseCode == 200) {
                JSONParser parsing = new JSONParser();
                Object obj = parsing.parse(res.toString());
                JSONObject jsonObj = (JSONObject) obj;

                access_token = (String) jsonObj.get("access_token");
                session.setAttribute("access_token", access_token);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        UserVO naverUser = signService.setTokenInfo(access_token);
        String naverID = signService.checkNaverID(naverUser.getUserID());

        //회원, 비회원 체크
        if (naverID != null && !"null".equals(naverID)) {
            //session 변경해서 로그인 상태로 만들기
            session.setAttribute("userVO",naverUser);
            model.addAttribute(RANDOM_CITY_INTRO_LIST.getText(), cityService.getRandomCityInfoListByCategory(INTRO.name()));
            model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));
            return "Main";
        } else {
            session.setAttribute("naverUser", naverUser);
            return "signView/NewNaverMember";
        }
    }

    @RequestMapping("/NaverTest")
    private String NaverTest(Model model) throws Exception {
        return "signView/NaverTest";
    }
}
