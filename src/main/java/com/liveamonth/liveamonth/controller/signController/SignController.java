package com.liveamonth.liveamonth.controller.signController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.liveamonth.liveamonth.model.service.signService.SignService;

import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMainPath.MAIN;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESignPath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.CITY_INTRO_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.CITY_NAME_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.ESignAttributes.FIRST_IN;

@Controller
public class SignController {
    private boolean firstIn;

    @Autowired
    private SignService signService;

    @Autowired
    private CityService cityService;

    @RequestMapping("/signIn")
    public String SignInPage(Model model) throws Exception {
        this.firstIn = true;
        model.addAttribute(FIRST_IN.getText(), this.firstIn);
        return SIGN_IN.getPath();
    }

    @RequestMapping("/logout")
    private String logout(HttpSession session, Model model) throws Exception {
        session.invalidate();
        List<String> cityNameList = cityService.getCityNameList();
        List<CityInfoVO> cityIntroList = cityService.getCityInfoListByCategory(INTRO.name());

        model.addAttribute(CITY_NAME_LIST.getText(), cityNameList);
        model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
        return MAIN.getPath();
    }

    @RequestMapping("/checkSign")
    private String checkSign(Model model, HttpServletRequest request) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        UserVO userVO = signService.checkSign(userID, userPassword);

        if (userVO == null) {
            this.firstIn = false;
            model.addAttribute(FIRST_IN.getText(), this.firstIn);
            return SIGN_IN.getPath();
        } else {
            HttpSession session = request.getSession();
            session.setAttribute(USER_VO.getText(), userVO);

            List<String> cityNameList = cityService.getCityNameList();
            List<CityInfoVO> cityIntroList = cityService.getCityInfoListByCategory(INTRO.name());

            model.addAttribute(CITY_NAME_LIST.getText(), cityNameList);
            model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
            return MAIN.getPath();
        }
    }

    @RequestMapping("/signUp")
    public String SignUpPage(Model model) throws Exception {
        return SIGN_UP.getPath();
    }

    @ResponseBody
    @RequestMapping(value = "/checkID", method = RequestMethod.POST)
    public int postCheckID(HttpServletRequest request) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String idCheck = signService.checkID(userID);

        int idExist = 0;
        if (idCheck != null) idExist = 1;
        return idExist;
    }

    @ResponseBody
    @RequestMapping(value = "/checkNickName", method = RequestMethod.POST)
    public int postNickNameCheck(HttpServletRequest request) throws Exception {
        String userNickname = request.getParameter(USER_NICKNAME.getText());
        String nickNameCheck = signService.checkNickName(userNickname);

        int nickNameExist = 0;
        if (nickNameCheck != null) nickNameExist = 1;
        return nickNameExist;
    }

    @ResponseBody
    @RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
    public int postCheckEmailCheck(HttpServletRequest request) throws Exception {
        String userEmail = request.getParameter(USER_EMAIL.getText());
        String emailCheck = signService.checkEmail(userEmail);

        int emailExist = 0;
        if (emailCheck != null) emailExist = 1;
        System.out.println(emailCheck);
        return emailExist;
    }

    @RequestMapping("/resultMentSignUp")
    private String resultMentSignUp(@ModelAttribute UserVO userVO) throws Exception {
        signService.insertUser(userVO);
        return RESULT_MENT_SIGN_UP.getPath();
    }

    @RequestMapping(value = "/resultMentFindID", method = RequestMethod.POST)
    public String findID(HttpServletResponse response, @RequestParam("userEmail")
            String userEmail, Model model) throws Exception {
        model.addAttribute(USER_ID.getText(), signService.findID(response, userEmail));
        return RESULT_MENT_FIND_ID.getPath();
    }

    @RequestMapping("/findID")
    private String findID(Model model) throws Exception {
        return FIND_ID.getPath();
    }

    @RequestMapping("/findPW")
    private String findPW(Model model) throws Exception {
        return FIND_PW.getPath();
    }


    @RequestMapping(value = "/ResultMentFindPW", method = RequestMethod.POST)
    public String findPW(HttpServletResponse response, @RequestParam("userID") String userID, @RequestParam("userEmail") String userEmail, Model model) throws Exception {
        model.addAttribute(USER_PASSWORD.getText(), signService.findPW(response, userID, userEmail));
        return RESULT_MENT_FIND_PW.getPath();
    }
}
