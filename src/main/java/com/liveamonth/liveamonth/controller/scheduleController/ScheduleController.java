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

@Controller
public class ScheduleController{
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private MyPageService myPageService;

	private int scheduleContentNO;

	@RequestMapping(value="addSchedule")
	public String addSchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception{
		HttpSession session = request.getSession();
		Object session_UserID = session.getAttribute("userID");
		String userID = (String)session_UserID;

		String message = "";

		// 지역 선택 기능 구현시 수정
		scheduleVO.setPlace(ScheduleVO.Place.SEOUL);
		if(scheduleService.addSchedule(scheduleVO, userID)) {
			message = "스케줄이 추가되었습니다.";
		} else {
			message = "스케줄 추가에 실패하였습니다.";
		}

		rttr.addFlashAttribute("message", message);
		return "redirect:schedule";
	}

	@RequestMapping(value="addScheduleContent")
	public String addScheduleContent(HttpServletRequest request, ScheduleContentVO scheduleContentVO, RedirectAttributes rttr) throws Exception{
		HttpSession session = request.getSession();
		scheduleContentVO.setScheduleNO(Integer.parseInt((String) session.getAttribute("selectedScheduleNO")));
		int count = scheduleService.beforeScheduleAddSearch(scheduleContentVO);

		String message = "";

		if(count>=4){
			message="스케줄은 최대 4개만 등록 가능합니다.";
		}else{
			scheduleContentVO.setScheduleContentNO(scheduleService.getLastScheduleContentNO()+1);
			scheduleService.addScheduleContent(scheduleContentVO);
			message="스케줄이 등록되었습니다";
		}

		rttr.addFlashAttribute("message", message);
		return "redirect:schedule";
	}

	@RequestMapping(value="modifyScheduleContent")
	public String modifySchedule(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		String scheduleContentSubject = request.getParameter("modifyScheduleContentSubject");
		String scheduleContentDesc = request.getParameter("modifyScheduleContentDesc");
		int scheduleContentCost = Integer.parseInt(request.getParameter("modifyScheduleContentCost"));
		scheduleService.modifyScheduleContent(scheduleContentNO,scheduleContentSubject,scheduleContentDesc,scheduleContentCost);
		String message = "수정이 완료되었습니다.";

		rttr.addFlashAttribute("message", message);
		return "redirect:schedule";
	}


	@RequestMapping(value="deleteScheduleContent")
	public String deleteSchedule(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
		scheduleService.deleteScheduleContent(scheduleContentNO);
		String message = "삭제가 완료되었습니다.";

		rttr.addFlashAttribute("message", message);
		return "redirect:schedule";
	}



	@RequestMapping("/schedule")
	public String schedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
		HttpSession session = request.getSession();
		Object session_UserID = session.getAttribute("userID");
		String userID = (String)session_UserID;
		int scheduleNO;
		ArrayList<ScheduleVO> scheduleVOList = scheduleService.getScheduleList(userID);
		if(scheduleVOList.isEmpty()) {
			scheduleNO = scheduleService.getMaxScheduleNO() +1;
		}else {
			scheduleNO = scheduleVOList.get(0).getScheduleNO();
		}
		if(session.getAttribute("selectedScheduleNO") != null) {
			Object session_scheduleNO = session.getAttribute("selectedScheduleNO");
			scheduleNO = Integer.parseInt((String) session_scheduleNO);
		}

		CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);

		model.addAttribute("scheduleVOList", scheduleVOList);
		model.addAttribute("dateList", calendarDto.getDateList()); //날짜 데이터 배열
		model.addAttribute("todayInformation", calendarDto.getTodayInformation());
		return "scheduleView/Schedule";
	}


	@RequestMapping("/swapSchedule")
	public String swapSchedule(RedirectAttributes rttr, HttpServletRequest request, ScheduleVO scheduleVO) throws Exception{
		HttpSession session = request.getSession();
		session.setAttribute("selectedScheduleNO", request.getParameter("selectSchedule"));

		return "redirect:schedule";
	}

	@ResponseBody
	@RequestMapping(value = "/showScheduleContentList", method = RequestMethod.POST)
	public void showScheduleContentList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
		this.scheduleContentNO = Integer.parseInt(request.getParameter("scheduleContentNO"));
	}



	@RequestMapping("/otherScheduleList")
	public String otherScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
		List<ScheduleVO> ScheduleVOList = scheduleService.getOtherScheduleInfo();
		List<UserVO> UserVOList = myPageService.getOtherScheduleUserInfo();

		model.addAttribute("ScheduleVOList", ScheduleVOList);
		model.addAttribute("UserVOList", UserVOList);

		return "scheduleView/OtherScheduleList";
	}

	@RequestMapping("/otherSchedule")
	public String otherSchedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{

		return "scheduleView/otherSchedule";
	}
}