package com.liveamonth.liveamonth.controller.scheduleController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;

@Controller
public class ScheduleController{
	private final ScheduleService scheduleService;

	public ScheduleController(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@RequestMapping(value="addSchedule")
	public String addSchedule(HttpServletRequest request, ScheduleContentVO scheduleContentVO, RedirectAttributes rttr) throws Exception{
		
		int count = scheduleService.beforeScheduleAddSearch(scheduleContentVO);
		
		String message = "";
		System.out.println(count);

		if(count>=4){
			message="스케쥴은 최대 4개만 등록 가능합니다.";
		}else{
			scheduleContentVO.setScheduleContentNO(scheduleService.getLastScheduleContentNO()+1);
			scheduleService.addScheduleContent(scheduleContentVO);
			message="스케줄이 등록되었습니다";
		}

		rttr.addFlashAttribute("message", message);
		return "redirect:schedule";
	}


	@RequestMapping("/schedule")
	public String schedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
		CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO);
		
		model.addAttribute("dateList", calendarDto.getDateList()); //날짜 데이터 배열
		model.addAttribute("todayInformation", calendarDto.getTodayInformation());
		return "scheduleView/Schedule";
	}

}
