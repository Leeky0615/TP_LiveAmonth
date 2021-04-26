package com.liveamonth.liveamonth.controller.myPageController;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO.OneToOneAskCategory;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO.Place;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import com.liveamonth.liveamonth.model.service.signService.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMyPagePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EOneToOneAsk.ONE_TO_ONE_ASK_CATEGORY;
import static com.liveamonth.liveamonth.constants.EntityConstants.EOneToOneAsk.ONE_TO_ONE_ASK_VO_LIST;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EMyPageAttributes.CHECK_USER;
import static com.liveamonth.liveamonth.constants.LogicConstants.ESignAttributes.*;

import java.util.ArrayList;

@Controller
public class MyPageController {
    @Autowired
    private MyPageService myPageService;
    @Autowired
    private SignService signService;

    @GetMapping("/myPage")
    public String myPage(Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Object session_UserID = session.getAttribute(USER_ID.getText());
        String userID = (String)session_UserID;
        model.addAttribute(CHECK_USER.getText(), true);

        session.setAttribute(USER_VO.getText(), myPageService.getUserInfo(userID));
        return MY_PAGE.getPath();
    }

    @GetMapping("/reCheckUserPW")
    public String reCheckUserPW(Model model, HttpServletRequest request) throws Exception {
        model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));
        model.addAttribute(CHECK_USER.getText(), true);

        return RE_CHECK_USER_PW.getSectionPath();
    }

    @GetMapping("/goToModifyUserInfo")
    public String goToModifyUserInfo(Model model, HttpServletRequest request) throws Exception {
        model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));

        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        String userName = signService.checkSign(userID, userPassword);

        if (userName == null) {
            model.addAttribute(CHECK_USER.getText(), false);
            return RE_CHECK_USER_PW.getSectionPath();
        } else {
            model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));
            return MODIFY_USER_INFO.getSectionPath();
        }
    }

    @RequestMapping("/resultMentModifyUserInfo")
    public String resultMentModifyUserInfo(@ModelAttribute UserVO userVO) throws Exception {
        UserVO previousUser = myPageService.getUserInfo(userVO.getUserID());

        myPageService.modifyUserInfo(this.checkUserData(userVO, previousUser));
        return RESULT_MENT_MODIFY_USER_INFO.getSectionPath();
    }

    private UserVO checkUserData(UserVO changeData, UserVO previousData){
        UserVO checkedUserData = changeData;
        if(checkedUserData.getUserPassword().isEmpty()){
            checkedUserData.setUserPassword(previousData.getUserPassword());
        }
        if(checkedUserData.getUserNickname().isEmpty()){
            checkedUserData.setUserNickname(previousData.getUserNickname());
        }
        if(checkedUserData.getUserEmail().isEmpty()){
            checkedUserData.setUserEmail(previousData.getUserEmail());
        }
        return checkedUserData;
    }

    @RequestMapping(value="dropUser")
	public String dropUser(Model model) throws Exception{
    	 // this.firstIn = true; -> 바로 true로 넣어줌
         model.addAttribute(FIRST_IN.getText(), true);
    	return DROP_USER.getSectionPath();
	}

    @RequestMapping("/checkDropUserPassword")
    private String checkDropUserPassword(Model model, HttpServletRequest request,HttpSession session) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        String userName = signService.checkSign(userID, userPassword);

        if (userName == null) {
            // this.firstIn = false; -> 바로 false로 넣어줌
            model.addAttribute(FIRST_IN.getText(), false);
            return DROP_USER.getSectionPath();
        } else {
        	return FINALLY_ASK_DROP_USER.getSectionPath();

        }
    }

    @RequestMapping("/resultMentDropUser")
    private String resultMentDropUser(Model model, HttpServletRequest request,HttpSession session) throws Exception {
    	Object session_UserID = session.getAttribute(USER_ID.getText());
    	String userID = (String)session_UserID;
    	session.invalidate();
    	myPageService.dropUser(userID);
    	return RESULT_MENT_DROP_USER.getSectionPath();

    }

    @RequestMapping("/oneToOneAsk")
    private String oneToOneAsk(Model model, HttpServletRequest request) throws Exception {
    	ArrayList<OneToOneAskVO> oneToOneAskVOList = myPageService.getOneToOneAskVOList();
    	model.addAttribute(ONE_TO_ONE_ASK_VO_LIST.getText(),oneToOneAskVOList);
    	return ONE_TO_ONE_ASK.getSectionPath();

    }

    @RequestMapping("/oneToOneAskWrite")
    private String oneToOneAskWrite(Model model) throws Exception {
    	model.addAttribute(ONE_TO_ONE_ASK_CATEGORY.getText(), OneToOneAskCategory.values());
    	return ONE_TO_ONE_ASK_WRITE.getSectionPath();
    }

    @RequestMapping("/resultMentOneToOneAsk")
    private String resultMentOneToOneAsk(HttpSession session,OneToOneAskVO oneToOneAskVO) throws Exception {
        String userID = String.valueOf(session.getAttribute(USER_ID.getText()));
    	myPageService.addOneToOneAsk(oneToOneAskVO,userID);
    	return RESULT_MENT_ONE_TO_ONE_ASK.getPath();
    }


}
