package com.liveamonth.liveamonth.controller.myPageController;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MyPageController {
    private final MyPageService myPageService;
    private UserVO userVO;

    public MyPageController(MyPageService myPageService) {
        this.myPageService = myPageService;
    }

    @GetMapping("/myPage")
    public String myPage(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Object session_UserID = session.getAttribute("userID");
        String userID = (String) session_UserID;

        this.userVO = myPageService.getUserInfo(userID);
        model.addAttribute("userVO", userVO);

        return "myPageView/MyPage";
    }

    @GetMapping("/modifyUserInfo")
    public String modifyUserInfo(Model model) throws Exception {
        model.addAttribute("userVO", this.userVO);

        return "myPageView/ModifyUserInfo";
    }
}
