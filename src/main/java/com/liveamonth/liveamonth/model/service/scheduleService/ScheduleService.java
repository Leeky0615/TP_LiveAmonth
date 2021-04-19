package com.liveamonth.liveamonth.model.service.scheduleService;

import java.util.ArrayList;
import java.util.List;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;


public interface ScheduleService {
    CalendarDTO showCalendar(CalendarDTO calendarDTO, int scheduleNO) throws Exception;

    int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO) throws Exception;

    void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;

    int getLastScheduleContentNO() throws Exception;

    List<ScheduleVO> getOtherScheduleInfo() throws Exception;

    void deleteScheduleContent(int scheduleContentNO) throws Exception;

    void modifyScheduleContent(int scheduleContentNO, String scheduleContentSubject, String scheduleContentDesc, int scheduleContentCost) throws Exception;

    boolean addSchedule(ScheduleVO scheduleVO, String userID) throws Exception;

    ArrayList<ScheduleVO> getScheduleList(String userID) throws Exception;

	boolean modifySchedule(ScheduleVO scheduleVO) throws Exception;

	boolean deleteSchedule(int scheduleNO) throws Exception;

}
