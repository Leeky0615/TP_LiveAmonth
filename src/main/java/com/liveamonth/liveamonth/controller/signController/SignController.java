package com.liveamonth.liveamonth.controller.signController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.liveamonth.liveamonth.model.service.signService.SignService;

@Controller
public class SignController {
    private boolean firstIn;

    @Autowired
    private SignService signService;

    @RequestMapping("/signIn")
    public String SignInPage(Model model) throws Exception {
        this.firstIn = true;
        model.addAttribute("firstIn", this.firstIn);
        return "signView/SignIn";
    }

    @RequestMapping("/logout")
    private String logout(HttpSession session) throws Exception {
        session.invalidate();
        return "Main";
    }

    @RequestMapping("/checkSign")
    private String checkSign(Model model, HttpServletRequest request) throws Exception {
        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        String userName = signService.checkSign(userID, userPassword);

        if (userName == null) {
            this.firstIn = false;
            model.addAttribute("firstIn", this.firstIn);
            return "signView/SignIn";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("userID", userID);
            session.setAttribute("userName", userName);
            return "Main";
        }
    }

    @RequestMapping("/signUp")
    public String SignUpPage(Model model)throws Exception{
        return "signView/SignUp";
    }
    @ResponseBody
    @RequestMapping(value = "/checkID", method = RequestMethod.POST)
    public int postIdCheck(HttpServletRequest request) throws Exception {
        String userID = request.getParameter("userID");

        String idCheck =  signService.checkID(userID);

        int idExist = 0;

        if(idCheck != null) {
            idExist = 1;
        }

        return idExist;
    }
    @ResponseBody
    @RequestMapping(value = "/checkNickName", method = RequestMethod.POST)
    public int postnickNameCheck(HttpServletRequest request) throws Exception {
        String userNickname = request.getParameter("userNickname");

        String nickNameCheck =  signService.checkNickName(userNickname);

        int nickNameExist = 0;

        if(nickNameCheck != null) {
            nickNameExist = 1;
        }
        return nickNameExist;
    }

    @RequestMapping("/ResultMentSignUp")
    private String ResultMentSignUp(@ModelAttribute UserVO userVO) throws Exception{
        signService.insertUser(userVO);
        return "signView/ResultMentSignUp";
    }

    @RequestMapping(value = "/resultMentFindID", method = RequestMethod.POST)
    public String IDFind(HttpServletResponse response, @RequestParam("userEmail")
            String userEmail, Model model) throws Exception{
        model.addAttribute("userID", signService.IDFind(response, userEmail));
        return "signView/ResultMentFindID";
    }



    @RequestMapping(value ="/findID")
    private String IDFind(Model model)throws Exception{
        return "signView/FindID";
    }



    @RequestMapping(value ="/PWFind")
    private String PWFind(Model model)throws Exception{
        return "signView/PWFind";
    }

    // 비밀번호 찾기

    @RequestMapping(value = "/ResultMentPWFind", method = RequestMethod.POST)
    public String PWFind(HttpServletResponse response, @RequestParam("userID")String userID, @RequestParam("userEmail") String userEmail, Model model) throws Exception{
        model.addAttribute("userPassword", signService.PWFind(response, userID, userEmail));
        return "signView/ResultMentPWFind";
    }
}
