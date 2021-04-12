package com.liveamonth.liveamonth.model.service.scheduleService;

import java.util.ArrayList;
import java.util.List;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;


public interface ScheduleService {
	public CalendarDTO showCalendar(CalendarDTO calendarDTO) throws Exception;
	public int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO) throws Exception;
	public void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;
	public int getLastScheduleContentNO() throws Exception;
	public ArrayList<ScheduleContentVO> scheduleContentList(CalendarDTO calendarDTO) throws Exception;
	public List<ScheduleVO> getOtherScheduleInfo() throws Exception;;
}
