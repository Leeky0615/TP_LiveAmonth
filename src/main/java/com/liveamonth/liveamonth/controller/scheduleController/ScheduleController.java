package com.liveamonth.liveamonth.controller.scheduleController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;

import java.util.ArrayList;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESchedulePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EScheduleContent.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EAlertMessage.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.*;

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
        scheduleContentVO.setScheduleNO(Integer.parseInt((String) session.getAttribute(SELECTED_SCHEDULE_NO.getText())));
        int count = scheduleService.beforeScheduleAddSearch(scheduleContentVO);

        if(count>=4){
            rttr.addFlashAttribute(MESSAGE.getText(), MAXIMUM_SCHEDULE_CONTENT.getText());
        }else{
            scheduleContentVO.setScheduleContentNO(scheduleService.getLastScheduleContentNO()+1);
            scheduleService.addScheduleContent(scheduleContentVO);
            rttr.addFlashAttribute(MESSAGE.getText(), ADD_SCHEDULE_CONTENT.getText());
        }

        return REDIRECT_SCHEDULE.getPath();
    }


    @RequestMapping(value="addSchedule")
    public String addSchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();
        Object session_UserID = session.getAttribute(USER_ID.getText());
        String userID = (String)session_UserID;

        // 지역 선택 기능 구현시 수정
        scheduleVO.setPlace(ScheduleVO.Place.SEOUL);
        if(scheduleService.addSchedule(scheduleVO, userID)) {
            rttr.addFlashAttribute(MESSAGE.getText(), ADD_SCHEDULE.getText());
        } else {
            rttr.addFlashAttribute(MESSAGE.getText(), FAIL_TO_ADD_SCHEDULE.getText());
        }
        return REDIRECT_SCHEDULE.getPath();
    }


    @RequestMapping(value="deleteScheduleContent")
    public String deleteSchedule(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        scheduleService.deleteScheduleContent(scheduleContentNO);

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_DELETION.getText());
        return REDIRECT_SCHEDULE.getPath();
    }

    @RequestMapping(value="modifyScheduleContent")
    public String modifySchedule(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        String scheduleContentSubject = request.getParameter(MODIFY_SCHEDULE_CONTENT_SUBJECT.getText());
        String scheduleContentDesc = request.getParameter(MODIFY_SCHEDULE_CONTENT_DESC.getText());
        int scheduleContentCost = Integer.parseInt(request.getParameter(MODIFY_SCHEDULE_CONTENT_COST.getText()));
        scheduleService.modifyScheduleContent(scheduleContentNO,scheduleContentSubject,scheduleContentDesc,scheduleContentCost);

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_MODIFICATION.getText());
        return REDIRECT_SCHEDULE.getPath();
    }

    @RequestMapping("/schedule")
    public String schedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        HttpSession session = request.getSession();
        Object session_UserID = session.getAttribute(USER_ID.getText());
        String userID = (String)session_UserID;

        ArrayList<ScheduleVO> scheduleVOList = scheduleService.getScheduleList(userID);
        int scheduleNO = scheduleVOList.get(0).getScheduleNO();
        if(session.getAttribute(SELECTED_SCHEDULE_NO.getText()) != null) {
            Object session_scheduleNO = session.getAttribute(SELECTED_SCHEDULE_NO.getText());
            scheduleNO = Integer.parseInt((String) session_scheduleNO);
        }

        CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);

        model.addAttribute(SCHEDULE_VO_LIST.getText(), scheduleVOList);
        model.addAttribute(DATE_LIST.getText(), calendarDto.getDateList()); //날짜 데이터 배열
        model.addAttribute(TODAY_INFORMATION.getText(), calendarDto.getTodayInformation());
        return SCHEDULE.getPath();
    }


    @RequestMapping("/swapSchedule")
    public String swapSchedule(RedirectAttributes rttr, HttpServletRequest request, ScheduleVO scheduleVO) throws Exception{
        HttpSession session = request.getSession();
        session.setAttribute(SELECTED_SCHEDULE_NO.getText(), request.getParameter(SELECT_SCHEDULE.getText()));

        return REDIRECT_SCHEDULE.getPath();
    }

    @ResponseBody
    @RequestMapping(value = "/showScheduleContentList", method = RequestMethod.POST)
    public void showScheduleContentList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        this.scheduleContentNO = Integer.parseInt(request.getParameter(SCHEDULE_CONTENT_NO.getText()));
    }


    /// 네이밍 룰 수정 필요!
    @RequestMapping("/otherScheduleList")
    public String otherScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        List<ScheduleVO> ScheduleVOList = scheduleService.getOtherScheduleInfo();
        List<UserVO> UserVOList = myPageService.getOtherScheduleUserInfo();

        model.addAttribute("ScheduleVOList", ScheduleVOList);
        model.addAttribute("UserVOList", UserVOList);

        return OTHER_SCHEDULE_LIST.getPath();
    }

    @RequestMapping("/otherSchedule")
    public String otherSchedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{

        return OTHER_SCHEDULE.getPath();
    }
}