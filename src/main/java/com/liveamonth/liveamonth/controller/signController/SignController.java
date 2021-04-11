package com.liveamonth.liveamonth.controller.signController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liveamonth.liveamonth.model.service.signService.SignService;

@Controller
public class SignController{
	private final SignService signService;

	private boolean firstIn;

	public SignController(SignService signService) {
		this.signService = signService;
	}

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
		HttpSession session = request.getSession();
		//		session.setMaxInactiveInterval(3);
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		String userName = signService.checkSign(userID, userPassword);
		if (userName == null) {
			this.firstIn = false;

			model.addAttribute("firstIn", this.firstIn);
			return "signView/SignIn";
		} else {
			session.setAttribute("userName", userName);
			return "Main";
		}

	}
//
//	@RequestMapping("/TestPage")
//	private String TestPage(Model model, HttpServletRequest request) throws Exception {
//		return "TestPage";
//	}
	
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
	private String ResultMentSignUp(HttpServletResponse response,HttpServletRequest request,Model model) throws Exception{
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		String userName = request.getParameter("userName");
		String userNickname = request.getParameter("userNickname");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userSex = request.getParameter("userSex");
		String userEmail = request.getParameter("userEmail");
		
		signService.insertUser(userID,userPassword,userName,userNickname,userAge,userSex,userEmail);
		
		return "signView/ResultMentSignUp";
		
	}
	
	@RequestMapping(value ="/findID")
	private String IDFind(Model model)throws Exception{
		return "signView/FindID";
	}
	
	// �븘�씠�뵒 李얘린
	@RequestMapping(value = "/resultMentFindID", method = RequestMethod.POST)
	public String IDFind(HttpServletResponse response, @RequestParam("userEmail")
	String userEmail, Model model) throws Exception{
		model.addAttribute("userID", signService.findID(userEmail));
		return "signView/ResultMentFindID";
	}
}
