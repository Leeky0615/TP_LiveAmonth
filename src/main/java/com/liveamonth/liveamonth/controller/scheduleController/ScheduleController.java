package com.liveamonth.liveamonth.controller.scheduleController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.constants.EntityConstants;
import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes;
import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;

import java.util.ArrayList;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESchedulePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EScheduleContent.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EScheduleReply.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EAlertMessage.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.SCHEDULE_PLACE;
import static com.liveamonth.liveamonth.entity.vo.ScheduleVO.*;

@Controller
public class ScheduleController{
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private MyPageService myPageService;

    private int scheduleContentNO;

    @RequestMapping(value="addScheduleContent")
    public String addScheduleContent(HttpServletRequest request, ScheduleContentVO scheduleContentVO, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();
        scheduleContentVO.setScheduleNO(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))));
        int count = scheduleService.beforeScheduleAddSearch(scheduleContentVO);

        String message = "";
        if(count>=4){
            message = MAXIMUM_SCHEDULE_CONTENT.getText();
        }else{
            scheduleContentVO.setScheduleContentNO(scheduleService.getLastScheduleContentNO()+1);
            scheduleService.addScheduleContent(scheduleContentVO);
            message = ADD_SCHEDULE_CONTENT.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(),message);
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value="deleteScheduleContent")
    public String deleteScheduleContent(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        scheduleService.deleteScheduleContent(scheduleContentNO);

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_DELETION.getText());
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value="modifyScheduleContent")
    public String modifyScheduleContent(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        String scheduleContentSubject = request.getParameter(MODIFY_SCHEDULE_CONTENT_SUBJECT.getText());
        String scheduleContentDesc = request.getParameter(MODIFY_SCHEDULE_CONTENT_DESC.getText());
        int scheduleContentCost = Integer.parseInt(request.getParameter(MODIFY_SCHEDULE_CONTENT_COST.getText()));
        scheduleService.modifyScheduleContent(scheduleContentNO,scheduleContentSubject,scheduleContentDesc,scheduleContentCost);

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_MODIFICATION.getText());
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping("/schedule")
    public String schedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        HttpSession session = request.getSession();
        String userID = String.valueOf(session.getAttribute(USER_ID.getText()));

        ArrayList<ScheduleVO> scheduleVOList = scheduleService.getScheduleList(userID);

        int scheduleNO;

		if(scheduleVOList.isEmpty()) {
			scheduleNO = scheduleService.getMaxScheduleNO() +1;
		} else {
			scheduleNO = scheduleVOList.get(0).getScheduleNO();
		}

        if(session.getAttribute(SELECTED_SCHEDULE_NO.getText()) != null) {
        	scheduleNO = Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText())));
        } else {
        	session.setAttribute(SELECTED_SCHEDULE_NO.getText(), scheduleNO);
        }

        CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);

        model.addAttribute(SCHEDULE_VO_LIST.getText(), scheduleVOList);
        model.addAttribute(DATE_LIST.getText(), calendarDto.getDateList()); //날짜 데이터 배열
        model.addAttribute(TODAY_INFORMATION.getText(), calendarDto.getTodayInformation());
        model.addAttribute(SCHEDULE_PLACE.getText(), Place.values());
        return SCHEDULE.getPath();
    }


    @RequestMapping("/swapSchedule")
    public String swapSchedule(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.setAttribute(SELECTED_SCHEDULE_NO.getText(), request.getParameter(SELECT_SCHEDULE.getText()));
        return REDIRECT_SCHEDULE.getRedirectPath();
    }
    @RequestMapping(value="addSchedule")
    public String addSchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();
        String userID = String.valueOf(session.getAttribute(USER_ID.getText()));

        String message = "";
        if(scheduleService.addSchedule(scheduleVO, userID)) {
            message = ADD_SCHEDULE.getText();
        } else {
            message = FAIL_TO_ADD_SCHEDULE.getText();
        }
        rttr.addFlashAttribute(MESSAGE.getText(), message);
        return REDIRECT_SCHEDULE.getRedirectPath();
    }


    @RequestMapping(value="modifySchedule")
    public String modifySchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception{
    	HttpSession session = request.getSession();
    	scheduleVO.setScheduleNO(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))));

        String message = "";
        if(scheduleService.modifySchedule(scheduleVO)) {
            message = COMPLETE_SCHEDULE_MODIFICATION.getText();
        } else {
            message = FAIL_TO_MODIFY_SCHEDULE.getText();
        }
        rttr.addFlashAttribute(MESSAGE.getText(), message);

        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value="deleteSchedule")
    public String deleteSchedule(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();

        String message = "";
        if(scheduleService.deleteSchedule(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))))) {
            session.setAttribute(SELECTED_SCHEDULE_NO.getText(), null);
            message = COMPLETE_SCHEDULE_DELETION.getText();
        } else {
            message = FAIL_TO_DELETE_SCHEDULE.getText();
        }
        rttr.addFlashAttribute(MESSAGE.getText(), message);

        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @ResponseBody
    @RequestMapping(value = "/showScheduleContentList", method = RequestMethod.POST)
    public void showScheduleContentList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        this.scheduleContentNO = Integer.parseInt(request.getParameter(SCHEDULE_CONTENT_NO.getText()));
    }

    @RequestMapping("/otherScheduleList")
    public String otherScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception {
    	String action = request.getParameter(SCHEDULE_ACTION.getText());

    	List<ScheduleVO> scheduleVOList = null;

    	if(action.contains(SCHEDULE_LIST.getText())) {
    		scheduleVOList = scheduleService.getOtherScheduleList(0, 0, null, null);

    	}else if(action.contains(SCHEDULE_FILTER.getText())) {
    		int sex = Integer.parseInt((String) request.getParameter(SCHEDULE_SEX.getText()));
            int age = Integer.parseInt((String) request.getParameter(SCHEDULE_AGE.getText()));
            String place = request.getParameter(EScheduleAttributes.SCHEDULE_PLACE.getText());
            String orderBy = request.getParameter(SCHEDULE_ORDERBY.getText());

            scheduleVOList = scheduleService.getOtherScheduleList(sex, age, place, orderBy);
    	}

        List<UserVO> userVOList = myPageService.getOtherScheduleUserInfo(scheduleVOList);
        Place[] placeList = Place.values();

        model.addAttribute(SCHEDULE_VO_LIST.getText(), scheduleVOList);
        model.addAttribute(USER_VO_LIST.getText(), userVOList);
        model.addAttribute(PLACE_LIST.getText(), placeList);

        return OTHER_SCHEDULE_LIST.getPath();
    }
    @RequestMapping("/otherSchedule")
    public String otherSchedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        int scheduleNO = Integer.parseInt((String) request.getParameter(SCHEDULE_NO.getText()));

        CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);

        model.addAttribute(SCHEDULEREPLY_VO_LIST.getText(), scheduleService.getScheduleReplyList(scheduleNO));
        model.addAttribute(SCHEDULE_NO.getText(), scheduleNO);
        model.addAttribute(DATE_LIST.getText(), calendarDto.getDateList()); //날짜 데이터 배열
        model.addAttribute(TODAY_INFORMATION.getText(), calendarDto.getTodayInformation());

        return OTHER_SCHEDULE.getPath();
    }

    @RequestMapping(value="addScheduleReply")
    public String addScheduleReply(HttpServletRequest request, ScheduleReplyVO scheduleReplyVO, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();
        String userID = String.valueOf(session.getAttribute(USER_ID.getText()));

        String message = "";
        if(scheduleService.addScheduleReplyVO(scheduleReplyVO, userID)) {
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

        return REDIRECT_OTHER_SCHEDULE.getPath();
    }
}