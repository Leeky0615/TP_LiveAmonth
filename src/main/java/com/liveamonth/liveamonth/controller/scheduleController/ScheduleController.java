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
        scheduleContentVO.setScheduleNO(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))));
        int count = scheduleService.beforeScheduleAddSearch(scheduleContentVO);

        String message = "";
        System.out.println(count);

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
    public String deleteScheduleContent(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        scheduleService.deleteScheduleContent(scheduleContentNO);
        String message = "삭제가 완료되었습니다.";

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_DELETION.getText());
        return REDIRECT_SCHEDULE.getPath();
    }

    @RequestMapping(value="modifyScheduleContent")
    public String modifyScheduleContent(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
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
        model.addAttribute("schedulePlace", Place.values());
        return SCHEDULE.getPath();
    }


    @RequestMapping("/swapSchedule")
    public String swapSchedule(RedirectAttributes rttr, HttpServletRequest request, ScheduleVO scheduleVO) throws Exception{
        HttpSession session = request.getSession();
        session.setAttribute(SELECTED_SCHEDULE_NO.getText(), request.getParameter(SELECT_SCHEDULE.getText()));
        session.setAttribute("selectedScheduleNO", request.getParameter("selectSchedule"));
        return "redirect:schedule";
    }

    @RequestMapping(value="addSchedule")
    public String addSchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();
        String userID = String.valueOf(session.getAttribute("userID"));

        String message = "";

        return REDIRECT_SCHEDULE.getPath();
        if(scheduleService.addSchedule(scheduleVO, userID)) {
            message = Constants.ADD_SCHEDULE_SUCCESS;
        } else {
            message = Constants.ADD_SCHEDULE_FAIL;
        }

        rttr.addFlashAttribute("message", message);
        return "redirect:schedule";
    }

    @RequestMapping(value="modifySchedule")
    public String modifySchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception{
    	HttpSession session = request.getSession();
    	scheduleVO.setScheduleNO(Integer.parseInt((String)session.getAttribute("selectedScheduleNO")));
        String message = "";

        if(scheduleService.modifySchedule(scheduleVO)) {
//        	session.setAttribute(message, scheduleService.getScheduleList(String.valueOf(session.getAttribute("userID")).get));
            message = Constants.MODIFY_SCHEDULE_SUCCESS;
        } else {
            message = Constants.MODIFY_SCHEDULE_FAIL;
        }

        rttr.addFlashAttribute("message", message);
        return "redirect:schedule";
    }

    @RequestMapping(value="deleteSchedule")
    public String deleteSchedule(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();

        String message = "";

        if(scheduleService.deleteSchedule(Integer.parseInt(String.valueOf(session.getAttribute("selectedScheduleNO"))))) {
            message = Constants.DELETE_SCHEDULE_SUCCESS;
        } else {
            message = Constants.DELETE_SCHEDULE_FAIL;
        }

        rttr.addFlashAttribute("message", message);
        return "redirect:schedule";
    }


    @ResponseBody
    @RequestMapping(value = "/showScheduleContentList", method = RequestMethod.POST)
    public void showScheduleContentList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        this.scheduleContentNO = Integer.parseInt(request.getParameter(SCHEDULE_CONTENT_NO.getText()));
    }

	@RequestMapping("/otherSchedule")
	   public String otherSchedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
	      int useNO =  Integer.parseInt((String) request.getParameter("useNO"));
	      int scheduleNO = Integer.parseInt((String) request.getParameter("scheduleNO"));

	      CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);

	      model.addAttribute("dateList", calendarDto.getDateList()); //날짜 데이터 배열
	      model.addAttribute("todayInformation", calendarDto.getTodayInformation());

	      return "scheduleView/OtherSchedule";
	   }

	   @RequestMapping("/filteringScheduleList")
	   public String filteringScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
	      int sex = Integer.parseInt((String)request.getParameter("sex"));
	      int age = Integer.parseInt((String) request.getParameter("age"));
	      String place = request.getParameter("place");

	      List<ScheduleVO> ScheduleVOList = scheduleService.getOtherScheduleInfo();
	      List<UserVO> UserVOList = myPageService.getOtherScheduleUserInfo(ScheduleVOList);

	      model.addAttribute("scheduleVOList", ScheduleVOList);
	      model.addAttribute("userVOList", UserVOList);

	      return "redirect:otherScheduleList";
	   }


	   @RequestMapping("/otherScheduleList")
	   public String otherScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
	      List<ScheduleVO> scheduleVOList = scheduleService.getOtherScheduleInfo();
	      List<UserVO> userVOList = myPageService.getOtherScheduleUserInfo(scheduleVOList);
	      Place[] placeList = Place.values();
    /// 네이밍 룰 수정 필요!
    @RequestMapping("/otherScheduleList")
    public String otherScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        List<ScheduleVO> ScheduleVOList = scheduleService.getOtherScheduleInfo();
        List<UserVO> UserVOList = myPageService.getOtherScheduleUserInfo();

	      model.addAttribute("scheduleVOList", scheduleVOList);
	      model.addAttribute("userVOList", userVOList);
	      model.addAttribute("placeList", placeList);

	      return "scheduleView/OtherScheduleList";
	   }

        model.addAttribute("ScheduleVOList", ScheduleVOList);
        model.addAttribute("UserVOList", UserVOList);

        return OTHER_SCHEDULE_LIST.getPath();
    }

    @RequestMapping("/otherSchedule")
    public String otherSchedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{

        return OTHER_SCHEDULE.getPath();
    }
}