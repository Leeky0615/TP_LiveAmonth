package com.liveamonth.liveamonth.model.mapper.scheduleMapper;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;

@Repository
public interface ScheduleMapper {

	public ArrayList<ScheduleContentVO> scheduleContentList(CalendarDTO calendarDTO) throws Exception;

	public int getLastScheduleContentNO() throws Exception;

	public void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;

	public int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO)  throws Exception;



	

}
