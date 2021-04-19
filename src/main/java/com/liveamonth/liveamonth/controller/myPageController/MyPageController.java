package com.liveamonth.liveamonth.controller.myPageController;

import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import com.liveamonth.liveamonth.model.service.signService.SignService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyPageController {
	@Autowired
    private final MyPageService myPageService;
	@Autowired
	private final SignService signService;
	
	private boolean firstIn;

    public MyPageController(MyPageService myPageService,SignService signService) {
        this.myPageService = myPageService;
		this.signService = signService;
    }

    @GetMapping("/myPage")
    public String hello(Model model,HttpServletRequest request, RedirectAttributes rttr) {
    	
        return "myPageView/MyPage";
    }
    
    @RequestMapping(value="dropUser")
	public String modifySchedule(Model model) throws Exception{
    	 this.firstIn = true;
         model.addAttribute("firstIn", this.firstIn);
    	return "myPageView/DropUser";
	}
    
    @RequestMapping("/checkDropUserPassword")
    private String checkSign(Model model, HttpServletRequest request,HttpSession session) throws Exception {
        String userID = request.getParameter("userID");
        String userPassword = request.getParameter("userPassword");
        String userName = signService.checkSign(userID, userPassword);

        if (userName == null) {
            this.firstIn = false;
            model.addAttribute("firstIn", this.firstIn);
            return "myPageView/DropUser";
        } else {
        	session.invalidate();
        	signService.dropUser(userID);
            return "myPageView/ResultMentDropUser";
        }
    }
    
    
}
