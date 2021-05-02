package com.liveamonth.liveamonth.model.service.scheduleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;


public interface ScheduleService {
    public CalendarDTO showCalendar(CalendarDTO calendarDTO, int scheduleNO) throws Exception;

    public int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO) throws Exception;

    public void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;

    public int getLastScheduleContentNO() throws Exception;

    public void deleteScheduleContent(int scheduleContentNO) throws Exception;

    public void modifyScheduleContent(int scheduleContentNO, String scheduleContentSubject, String scheduleContentDesc, int scheduleContentCost) throws Exception;

    public boolean addSchedule(ScheduleVO scheduleVO, int userNO) throws Exception;

    public ArrayList<ScheduleVO> getScheduleList(int userNO) throws Exception;

    public int getMaxScheduleNO() throws Exception;

    boolean modifySchedule(ScheduleVO scheduleVO) throws Exception;

	boolean deleteSchedule(int scheduleNO) throws Exception;
	
	public ArrayList<HashMap<String, Object>> getOtherScheduleList(HashMap<String, Object> filtersAndOrder) throws Exception;

    public List<HashMap<String, Object>> getScheduleReplyList(int scheduleNO) throws Exception;

    public boolean addScheduleReplyVO(ScheduleReplyVO scheduleReplyVO, int userNO) throws Exception;

    public boolean deleteScheduleReply(int scheduleReplyNO) throws Exception;
}
