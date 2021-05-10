package com.liveamonth.liveamonth.controller.myPageController;

import com.liveamonth.liveamonth.constants.EntityConstants;
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

import java.util.ArrayList;


@Controller
public class MyPageController {
    @Autowired
    private MyPageService myPageService;
    @Autowired
    private SignService signService;

    private Boolean checkUser;

    @GetMapping("/myPage")
    public String myPage(Model model, HttpSession session) throws Exception {
        this.checkUser = true;
        model.addAttribute(CHECK_USER.getText(),  this.checkUser);
        model.addAttribute(USER_VO.getText(), session.getAttribute(USER_VO.getText()));
        return "MyPage";
    }

    // 회원정보 수정 : 비밀번호 재확인
    @RequestMapping("/reCheckPassword")
    public String reCheckPassword(Model model, HttpSession session, @RequestParam("page") String page) throws Exception {
        model.addAttribute(USER_VO.getText(), session.getAttribute(USER_VO.getText()));
        model.addAttribute(CHECK_USER.getText(), true);
        if(page.equals("modify")){
            model.addAttribute("page", "modify");
            model.addAttribute("title", "회원정보 수정 : 비밀번호 재확인");
            model.addAttribute("text", "개인정보 변경에서는 비밀번호 변경, 이메일 변경 등의 정보를 확인, 수정하실 수 있습니다.");
        }else if(page.equals("dropUser")){
            model.addAttribute("page", "dropUser");
            model.addAttribute("title", "회원 탈퇴 : 비밀번호 재확인");
            model.addAttribute("text", "회원 해지시, 회원님의 정보는 삭제되며 복구 불가능합니다.");
        }
        return RE_CHECK_PASSWORD.getPath();
    }
    // 비밀번호 확인 -> 확인 시 : 회원정보 수정페이지 | 틀릴 시 : 비밀번호 재확인
    @RequestMapping("/confirmPassword")
    public String confirmPassword(Model model, HttpServletRequest request) throws Exception {
        String page = request.getParameter("page");

        String userID = request.getParameter(USER_ID.getText());
        String userPassword = request.getParameter(USER_PASSWORD.getText());
        UserVO userVO = signService.checkSign(userID, userPassword);
        System.out.println("userID = " + userID);
        System.out.println("userPassword = " + userPassword);
        model.addAttribute(USER_VO.getText(), request.getAttribute(USER_VO.getText()));
        String path = RE_CHECK_PASSWORD.getPath();
        if (userVO == null) {
            model.addAttribute(CHECK_USER.getText(), false);
            if(page.equals("modify")){
                model.addAttribute("page", "modify");
                model.addAttribute("title", "회원정보 수정 : 비밀번호 재확인");
                model.addAttribute("text", "개인정보 변경에서는 비밀번호 변경, 이메일 변경 등의 정보를 확인, 수정하실 수 있습니다.");
            }else if(page.equals("dropUser")){
                model.addAttribute("page", "dropUser");
                model.addAttribute("title", "회원 탈퇴 : 비밀번호 재확인");
                model.addAttribute("text", "회원 해지시, 회원님의 정보는 삭제되며 복구 불가능합니다.");
            }
        } else {
            if(page.equals("modify")){
                model.addAttribute("page", "modify");
                path = MODIFY_USER_INFO.getPath();
            }else if(page.equals("dropUser")){
                model.addAttribute("page", "dropUser");
                path = FINALLY_ASK_DROP_USER.getPath();
            }
        }
        return path;
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

    // 회원정보 수정 결과 페이지
    @RequestMapping("/resultMent")
    public String resultMent(@RequestParam("page") String page,
                             @ModelAttribute UserVO userVO,
                             @ModelAttribute OneToOneAskVO oneToOneAskVO,
                             Model model, HttpSession session) throws Exception {
        UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
        if(page.equals("modify") && userVO != null){
            UserVO previousUser = myPageService.getUserInfo(userVO.getUserID());
            myPageService.modifyUserInfo(this.checkUserData(userVO, previousUser));
            model.addAttribute("page", "modify");
            model.addAttribute("title", "회원정보 수정완료");
            model.addAttribute("text", "회원정보 수정이 완료되었습니다.");
        }else if(page.equals("dropUser")){
            model.addAttribute("title", "회원탈퇴 완료");
            model.addAttribute("text", "그동안 저희 서비스를 이용해 주셔서 진심으로 감사합니다.");
            myPageService.dropUser(session_UserVO.getUserID());
            session.invalidate();
        }else if(page.equals("oneToOneAsk") && oneToOneAskVO != null){
            myPageService.addOneToOneAsk(oneToOneAskVO, session_UserVO.getUserNO());
            model.addAttribute("page", "oneToOneAsk");
            model.addAttribute("title", "1:1문의 완료");
            model.addAttribute("text", "문의내용을 확인한 뒤 신속한 답변드리겠습니다. 감사합니다.");
        }else if(page.equals("deleteOneToOneAsk") && oneToOneAskVO != null){
            int oneToOneAskNO = oneToOneAskVO.getOneToOneAskNO();
            myPageService.deleteOneToOneAsk(oneToOneAskNO);
            model.addAttribute("page", "deleteOneToOneAsk");
            model.addAttribute("title", "문의내용 삭제 완료");
            model.addAttribute("text", "고객님을 위해 항상 최선을 다하겠습니다. 감사합니다.");
        }
        return RESULT_MENT.getPath();
    }


    @RequestMapping("/oneToOneAsk")
    private String oneToOneAsk(Model model, HttpSession session) throws Exception {
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
    private String writeOneToOneAsk(Model model) throws Exception {
        model.addAttribute(ONE_TO_ONE_ASK_CATEGORY.getText(), OneToOneAskCategory.values());
        return Write_ONE_TO_ONE_ASK.getPath();
    }

    @RequestMapping("/deleteOneToOneAsk")
    private String deleteOneToOneAsk(HttpServletRequest request) throws Exception {
        int oneToOneAskNO = Integer.parseInt(request.getParameter(ONE_TO_ONE_ASK_NO.getText()));
        myPageService.deleteOneToOneAsk(oneToOneAskNO);
        return RESULT_MENT_DELETE_ONE_TO_ONE_ASK.getPath();
    }

    @RequestMapping("/personalTerms")
    private String personalTerms(){
        return PERSONAL_TERMS.getPath();
    }
    @RequestMapping("/faq")
    private String faq(HttpServletRequest request) throws Exception {
        return FAQ.getPath();
    }


}
