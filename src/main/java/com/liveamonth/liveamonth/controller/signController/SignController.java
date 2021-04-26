package com.liveamonth.liveamonth.controller.signController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.constants.LogicConstants;
import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.liveamonth.liveamonth.model.service.signService.SignService;

import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMainPath.MAIN;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESignPath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.ECityCategory.CATEGORY_INTRO;
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
    private CityInfoService cityInfoService;

    @RequestMapping("/signIn")
    public String SignInPage(Model model) throws Exception {
        this.firstIn = true;
        model.addAttribute(FIRST_IN.getText(), this.firstIn);
        return SIGN_IN.getPath();
    }

    @RequestMapping("/logout")
    private String logout(HttpSession session, Model model) throws Exception {
        session.invalidate();
        List<CityInfoVO> cityIntroList = cityInfoService.getCityInfoListByCategory(CATEGORY_INTRO.getCategoryUppercase());
        List<String> cityNameList = cityInfoService.getCityInfoNameList();

        model.addAttribute(CITY_NAME_LIST.getText(), cityNameList);
        model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
        return MAIN.getPath();
    }

    @RequestMapping("/checkSign")
    private String checkSign(Model model, HttpServletRequest request) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        String userName = signService.checkSign(userID, userPassword);
        int userNO = signService.checkSign2(userID, userPassword);

        if (userName == null) {
            this.firstIn = false;
            model.addAttribute(FIRST_IN.getText(), this.firstIn);
            return SIGN_IN.getPath();
        } else {
            HttpSession session = request.getSession();
            session.setAttribute(USER_ID.getText(), userID);
            session.setAttribute(USER_NAME.getText(), userName);
            session.setAttribute(USER_NO.getText(), userNO);

            List<CityInfoVO> cityIntroList = cityInfoService.getCityInfoListByCategory(CATEGORY_INTRO.getCategoryUppercase());
            List<String> cityNameList = cityInfoService.getCityInfoNameList();

            model.addAttribute(CITY_NAME_LIST.getText(), cityNameList);
            model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);

            return MAIN.getPath();
        }
    }

    @RequestMapping("/signUp")
    public String SignUpPage(Model model)throws Exception{
        return SIGN_UP.getPath();
    }
    @ResponseBody
    @RequestMapping(value = "/checkID", method = RequestMethod.POST)
    public int postIdCheck(HttpServletRequest request) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String idCheck =  signService.checkID(userID);

        int idExist = 0;
        if(idCheck != null) idExist = 1;
        return idExist;
    }
    @ResponseBody
    @RequestMapping(value = "/checkNickName", method = RequestMethod.POST)
    public int postnickNameCheck(HttpServletRequest request) throws Exception {
        String userNickname = request.getParameter(USER_NICKNAME.getText());
        String nickNameCheck =  signService.checkNickName(userNickname);

        int nickNameExist = 0;
        if(nickNameCheck != null) nickNameExist = 1;
        return nickNameExist;
    }

    @RequestMapping("/resultMentSignUp")
    private String resultMentSignUp(@ModelAttribute UserVO userVO) throws Exception{
        signService.insertUser(userVO);
        return RESULT_MENT_SIGN_UP.getPath();
    }

    @RequestMapping(value = "/resultMentFindID", method = RequestMethod.POST)
    public String findID(HttpServletResponse response, @RequestParam("userEmail")
            String userEmail, Model model) throws Exception{
        model.addAttribute(USER_ID.getText(),signService.findID(response, userEmail));
        return RESULT_MENT_FIND_ID.getPath();
    }

    @RequestMapping("/findID")
    private String findID(Model model)throws Exception{
        return FIND_ID.getPath();
    }

    @RequestMapping("/findPW")
    private String findPW(Model model)throws Exception{
        return FIND_PW.getPath();
    }


    @RequestMapping(value = "/ResultMentFindPW", method = RequestMethod.POST)
    public String findPW(HttpServletResponse response, @RequestParam("userID")String userID, @RequestParam("userEmail") String userEmail, Model model) throws Exception{
        model.addAttribute(USER_PASSWORD.getText(), signService.findPW(response, userID, userEmail));
        return RESULT_MENT_FIND_PW.getPath();
    }
}
