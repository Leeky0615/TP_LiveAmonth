package com.liveamonth.liveamonth.controller.scheduleController;

import com.liveamonth.liveamonth.constants.EntityConstants;
import com.liveamonth.liveamonth.constants.LogicConstants;
import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.dto.Paging;
import com.liveamonth.liveamonth.entity.vo.ScheduleLikeVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESchedulePath.*;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESchedulePath.REDIRECT_OTHER_SCHEDULE;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.SCHEDULE_NO;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.SCHEDULE_VO_LIST;
import static com.liveamonth.liveamonth.constants.EntityConstants.EScheduleReply.SCHEDULE_REPLY_NO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_NO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_VO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EAlertMessage.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EAlertMessage.FAIL_TO_DELETE_SCHEDULEREPLY;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.MESSAGE;

@Controller
public class OtherScheduleController {

        @Autowired
        private ScheduleService scheduleService;
        @Autowired
        private MyPageService myPageService;

    @RequestMapping("/otherScheduleList")
    public String otherScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception {
        String action = request.getParameter(SCHEDULE_ACTION.getText());

        List<ScheduleVO> scheduleVOList = null;

        if(action.contains(SCHEDULE_LIST.getText())) {
            scheduleVOList = scheduleService.getOtherScheduleList(0, 0, null, null);

        }else if(action.contains(SCHEDULE_FILTER.getText())) {
            int sex = Integer.parseInt((String) request.getParameter(SCHEDULE_SEX.getText()));
            int age = Integer.parseInt((String) request.getParameter(SCHEDULE_AGE.getText()));
            String place = request.getParameter(LogicConstants.EScheduleAttributes.SCHEDULE_PLACE.getText());
            String orderBy = request.getParameter(SCHEDULE_ORDERBY.getText());

            scheduleVOList = scheduleService.getOtherScheduleList(sex, age, place, orderBy);
        }

        List<UserVO> userVOList = myPageService.getOtherScheduleUserInfo(scheduleVOList);
        EntityConstants.CityName[] placeList = EntityConstants.CityName.values();

        model.addAttribute(SCHEDULE_VO_LIST.getText(), scheduleVOList);
        model.addAttribute(USER_VO_LIST.getText(), userVOList);
        model.addAttribute(PLACE_LIST.getText(), placeList);

        return OTHER_SCHEDULE_LIST.getPath();
    }
    @RequestMapping("/otherSchedule")
    public String otherSchedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO)session.getAttribute(USER_VO.getText());
        int scheduleNO = Integer.parseInt((String) request.getParameter(SCHEDULE_NO.getText()));

        CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);

        int page = 1;
        if(request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        Paging paging = new Paging();
        paging.setPage(page);
        paging.setTotalCount(scheduleService.getScheduleReplyCount(scheduleNO));

        if(session_UserVO != null){
            ScheduleLikeVO scheduleLikeVO = new ScheduleLikeVO();
            scheduleLikeVO.setScheduleNO(scheduleNO);
            scheduleLikeVO.setScheduleLikeUserNO(session_UserVO.getUserNO());
            model.addAttribute("likeStatus", scheduleService.getScheduleLikeStatus(scheduleLikeVO));
        }

        model.addAttribute("likeCount", scheduleService.getScheduleLikeCount(scheduleNO));
        model.addAttribute(SCHEDULEREPLY_VO_LIST.getText(), scheduleService.getScheduleReplyList(scheduleNO, page));
        model.addAttribute("paging", paging);
        model.addAttribute(SCHEDULE_NO.getText(), scheduleNO);
        model.addAttribute(DATE_LIST.getText(), calendarDto.getDateList()); //날짜 데이터 배열
        model.addAttribute(TODAY_INFORMATION.getText(), calendarDto.getTodayInformation());

        return OTHER_SCHEDULE.getPath();
    }

    @RequestMapping(value="addScheduleReply")
    public String addScheduleReply(HttpServletRequest request, ScheduleReplyVO scheduleReplyVO, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO)session.getAttribute(USER_VO.getText());
        int userNO = session_UserVO.getUserNO();

        String message = "";
        if(scheduleService.addScheduleReplyVO(scheduleReplyVO, userNO)) {
            message = ADD_SCHEDULEREPLY.getText();
        } else {
            message = FAIL_TO_ADD_SCHEDULEREPLY.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        rttr.addAttribute(SCHEDULE_NO.getText(), scheduleReplyVO.getScheduleNO());

        return REDIRECT_OTHER_SCHEDULE.getRedirectPath();
    }

    @RequestMapping("/deleteScheduleReply")
    public String deleteScheduleReply(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        int scheduleReplyNO = Integer.parseInt(String.valueOf(request.getParameter(SCHEDULE_REPLY_NO.getText())));
        int scheduleNO = Integer.parseInt(String.valueOf(request.getParameter(SCHEDULE_NO.getText())));

        String message = "";
        if(scheduleService.deleteScheduleReply(scheduleReplyNO)) {
            message = COMPLETE_SCHEDULEREPLY_DELETION.getText();
        } else {
            message = FAIL_TO_DELETE_SCHEDULEREPLY.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        rttr.addAttribute(SCHEDULE_NO.getText(), scheduleNO);

        return REDIRECT_OTHER_SCHEDULE.getRedirectPath();
    }

    @RequestMapping("modifyScheduleReply")
    public String modifyScheduleReply(RedirectAttributes rttr, ScheduleReplyVO scheduleReplyVO) throws Exception{

        String message = "";
        if(scheduleService.modifyScheduleReply(scheduleReplyVO)) {
            message = COMPLETE_SCHEDULEREPLY_MODIFICATION.getText();
        } else {
            message = FAIL_TO_MODIFY_SCHEDULEREPLY.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        rttr.addAttribute(SCHEDULE_NO.getText(), scheduleReplyVO.getScheduleNO());

        return REDIRECT_OTHER_SCHEDULE.getRedirectPath();
    }
    @ResponseBody
    @RequestMapping(value = "/updateScheduleLike", method = RequestMethod.GET)
    public HashMap<String, Integer> getScheduleLikeAndCount(HttpServletRequest request) throws Exception{
        int scheduleNO = Integer.parseInt(String.valueOf(request.getParameter(SCHEDULE_NO.getText())));
        int userNO = Integer.parseInt(String.valueOf(request.getParameter(USER_NO.getText())));
        ScheduleLikeVO scheduleLikeVO = new ScheduleLikeVO();
        scheduleLikeVO.setScheduleNO(scheduleNO);
        scheduleLikeVO.setScheduleLikeUserNO(userNO);

        return scheduleService.getScheduleLikeAndCount(scheduleLikeVO);
    }
}
