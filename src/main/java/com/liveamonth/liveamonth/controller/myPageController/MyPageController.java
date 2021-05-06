package com.liveamonth.liveamonth.controller.myPageController;

import com.liveamonth.liveamonth.entity.vo.OneToOneAskVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import com.liveamonth.liveamonth.model.service.signService.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMyPagePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EOneToOneAsk.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
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
    public String myPage(Model model, HttpSession session) throws Exception {
        model.addAttribute(CHECK_USER.getText(), true);
        model.addAttribute(USER_VO.getText(), session.getAttribute(USER_VO.getText()));
        return "MyPage";
    }

    // 회원정보 수정 : 비밀번호 재확인
    @RequestMapping("/reCheckForModifyUserInfo")
    public String reCheckForModifyUserInfo(Model model, HttpSession session) throws Exception {
        model.addAttribute(USER_VO.getText(), session.getAttribute(USER_VO.getText()));
        model.addAttribute(CHECK_USER.getText(), true);
        return RE_CHECK_MODIFY_USER.getPath();
    }

    // 비밀번호 확인 -> 확인 시 : 회원정보 수정페이지 | 틀릴 시 : 비밀번호 재확인
    @RequestMapping("/checkModifyUserInfoPassword")
    public String checkModifyUserInfoPassword(Model model, HttpServletRequest request) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        UserVO userVO = signService.checkSign(userID, userPassword);
        System.out.println("userID = " + userID);
        System.out.println("userPassword = " + userPassword);
        model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));
        if (userVO == null) {
            model.addAttribute(CHECK_USER.getText(), false);
            return RE_CHECK_MODIFY_USER.getPath();
        } else {
            return MODIFY_USER_INFO.getPath();
        }
    }

    // 회원정보 수정 결과 페이지
    @RequestMapping("/resultMentModifyUserInfo")
    public String resultMentModifyUserInfo(@ModelAttribute UserVO userVO) throws Exception {
        UserVO previousUser = myPageService.getUserInfo(userVO.getUserID());

        myPageService.modifyUserInfo(this.checkUserData(userVO, previousUser));
        return RESULT_MENT_MODIFY_USER_INFO.getPath();
    }

    private UserVO checkUserData(UserVO changeData, UserVO previousData) {
        UserVO checkedUserData = changeData;
        if (checkedUserData.getUserPassword().isEmpty()) {
            checkedUserData.setUserPassword(previousData.getUserPassword());
        }
        if (checkedUserData.getUserNickname().isEmpty()) {
            checkedUserData.setUserNickname(previousData.getUserNickname());
        }
        if (checkedUserData.getUserEmail().isEmpty()) {
            checkedUserData.setUserEmail(previousData.getUserEmail());
        }
        return checkedUserData;
    }

    // 회원 탈퇴 : 비밀번호 재확인
    @RequestMapping(value = "/reCheckForDropUser")
    public String reCheckForDropUser(Model model,HttpServletRequest request) throws Exception {
        model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));
        model.addAttribute(CHECK_USER.getText(), true);
        return RE_CHECK_DROP_USER.getPath();
    }
    // 비밀번호 확인 -> 확인 시 : 회원탈퇴 페이지 | 틀릴 시 : 비밀번호 재확인
    @RequestMapping("/checkDropUserPassword")
    private String checkDropUserPassword(Model model, HttpServletRequest request, HttpSession session) throws Exception {
        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        UserVO userVO = signService.checkSign(userID, userPassword);

        if (userVO == null) {
            model.addAttribute(FIRST_IN.getText(), false);
            return RE_CHECK_DROP_USER.getPath();
        } else {
            // 회원 탈퇴 결정 재확인
            return FINALLY_ASK_DROP_USER.getPath();
        }
    }

    // 회원탈퇴 수정 결과 페이지
    @RequestMapping("/resultMentDropUser")
    private String resultMentDropUser(HttpServletRequest request, HttpSession session) throws Exception {
        UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
        myPageService.dropUser(session_UserVO.getUserID());
        session.invalidate();
        return RESULT_MENT_DROP_USER.getPath();

    }

    @RequestMapping("/oneToOneAsk")
    private String oneToOneAsk(Model model, HttpServletRequest request, HttpSession session) throws Exception {
        UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
        int userNO = session_UserVO.getUserNO();

        ArrayList<OneToOneAskVO> oneToOneAskVOList = myPageService.getOneToOneAskVOList(userNO);
        model.addAttribute(ONE_TO_ONE_ASK_VO_LIST.getText(), oneToOneAskVOList);
        return ONE_TO_ONE_ASK.getPath();

    }

    @RequestMapping("/showOneToOneAsk")
    private String showOneToOneAsk(Model model, HttpServletRequest request) throws Exception {
        OneToOneAskVO oneToOneAskVO = myPageService.findOneToOneAskVO(Integer.parseInt(request.getParameter(ONE_TO_ONE_ASK_NO.getText())));
        model.addAttribute("oneToOneAskVO", oneToOneAskVO);
        return SHOW_ONE_TO_ONE_ASK.getPath();

    }

    @RequestMapping("/writeOneToOneAsk")
    private String oneToOneAskWrite(Model model) throws Exception {
        model.addAttribute(ONE_TO_ONE_ASK_CATEGORY.getText(), OneToOneAskCategory.values());
        return Write_ONE_TO_ONE_ASK.getPath();
    }

    @RequestMapping("/resultMentOneToOneAsk")
    private String resultMentOneToOneAsk(HttpSession session, OneToOneAskVO oneToOneAskVO) throws Exception {

        UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
        int userNO = session_UserVO.getUserNO();

        myPageService.addOneToOneAsk(oneToOneAskVO, userNO);
        return RESULT_MENT_ONE_TO_ONE_ASK.getPath();
    }

    @RequestMapping("/deleteOneToOneAsk")
    private String deleteOneToOneAsk(HttpServletRequest request) throws Exception {
        int oneToOneAskNO = Integer.parseInt(request.getParameter(ONE_TO_ONE_ASK_NO.getText()));
        myPageService.deleteOneToOneAsk(oneToOneAskNO);
        return RESULT_MENT_DELETE_ONE_TO_ONE_ASK.getPath();
    }


}
