package com.liveamonth.liveamonth.controller.signController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.constants.EntityConstants;
import com.liveamonth.liveamonth.constants.EntityConstants.EEmail;
import com.liveamonth.liveamonth.entity.dto.S3UploaderDTO;
import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
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
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMainPath.MAIN;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESignPath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EEmail.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESignUp.EMAIL;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewImage.S3_UPLOAD_FOLDER;
import static com.liveamonth.liveamonth.constants.LogicConstants.ESignAttributes.AT;
import static com.liveamonth.liveamonth.constants.LogicConstants.ESignAttributes.FIRST_IN;
@Controller
public class SignController {
    private boolean firstIn;
    @Autowired
    private S3UploaderDTO s3Uploader;

    @Autowired
    private SignService signService;

    @Autowired
    private CityService cityService;

    @GetMapping("/signIn")
    public String SignInPage(Model model) throws Exception {
        model.addAttribute(FIRST_IN.getText(), true);
        return SIGN_IN.getPath();
    }

    @RequestMapping("/logout")
    private String logout(HttpSession session, Model model) throws Exception {
        session.invalidate();
        // MainCitySlide.jsp 사용
        model.addAttribute(RANDOM_CITY_INTRO_LIST.getText(), cityService.getRandomCityInfoListByCategory(INTRO.name()));
        // CityInfoGrid.jsp 사용
        model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));
        return MAIN.getPath();
    }

    @RequestMapping("/checkSign")
    public String checkSign(Model model, HttpServletRequest request,HttpSession session) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        UserVO userVO = signService.checkSign(userID, userPassword);

        if (userVO == null) {
            model.addAttribute(FIRST_IN.getText(), false);
            return SIGN_IN.getPath();
        } else {
            session.setAttribute(USER_VO.getText(), userVO);
            // MainCitySlide.jsp 사용
            model.addAttribute(RANDOM_CITY_INTRO_LIST.getText(), cityService.getRandomCityInfoListByCategory(INTRO.name()));
            // CityInfoGrid.jsp 사용
            model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));
            return MAIN.getPath();
        }
    }

    @RequestMapping("/signUp")
    public String SignUpPage(Model model) throws Exception {
        model.addAttribute(EMAIL.getText(), EEmail.values());
        return SIGN_UP.getPath();
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
    private String resultMentSignUp(@ModelAttribute UserVO userVO,HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter(USER_EMAIL.getText());
        String email = request.getParameter(EMAIL.getText());

        userVO.setUserEmail(userEmail + AT.getText() + email);

        signService.insertUser(userVO);
        return RESULT_MENT_SIGN_UP.getPath();
    }

    @RequestMapping(value = "/resultMentFindID", method = RequestMethod.POST)
    public String findID(@RequestParam("userName")
       	String userName,@RequestParam("userEmail")String userEmail, Model model) throws Exception {
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
    public String findPW( @RequestParam("userID")
    	String userID, @RequestParam("userEmail") String userEmail, Model model) throws Exception {
        model.addAttribute(USER_PASSWORD.getText(), signService.findPW(userID, userEmail));

        if (signService.findPW(userID, userEmail) == null)
        this.firstIn = false;
        model.addAttribute(FIRST_IN.getText(), this.firstIn);
        return RESULT_MENT_FIND_PW.getPath();
    }

    @RequestMapping("/callback")
    private String callback(Model model) throws Exception {
        System.out.println("controller callback");
        return "signView/callback";
    }
}
