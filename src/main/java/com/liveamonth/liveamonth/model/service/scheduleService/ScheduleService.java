package com.liveamonth.liveamonth.model.service.scheduleService;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.dto.Paging;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleLikeVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public interface ScheduleService {
    CalendarDTO showCalendar(CalendarDTO calendarDTO, int scheduleNO) throws Exception;

    int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO) throws Exception;

    void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;

    void deleteScheduleContent(int scheduleContentNO) throws Exception;

    void modifyScheduleContent(int scheduleContentNO, String scheduleContentSubject, String scheduleContentDesc, int scheduleContentCost) throws Exception;

    boolean addSchedule(ScheduleVO scheduleVO) throws Exception;

    ArrayList<ScheduleVO> getScheduleList(int userNO) throws Exception;

    int getMaxScheduleNO() throws Exception;

    boolean modifySchedule(ScheduleVO scheduleVO) throws Exception;

    boolean deleteSchedule(int scheduleNO) throws Exception;

    List<HashMap<String, Object>> getOtherScheduleList(HashMap<String, Object> filtersAndOrder) throws Exception;

    ArrayList<HashMap<String, Object>> getScheduleReplyList(int scheduleNO, int page) throws Exception;

    boolean addScheduleReplyVO(ScheduleReplyVO scheduleReplyVO, int userNO) throws Exception;

    boolean deleteScheduleReply(int scheduleReplyNO) throws Exception;

    boolean modifyScheduleReply(ScheduleReplyVO scheduleReplyVO) throws Exception;

    int getScheduleLikeStatus(ScheduleLikeVO scheduleLikeVO) throws Exception;

    HashMap<String, String> getScheduleAndLikeCount(int scheduleNO) throws Exception;

    HashMap<String, Integer> getScheduleLikeAndCount(ScheduleLikeVO scheduleLikeVO) throws Exception;

    Paging showPaging(int selectPage, int scheduleNO) throws Exception;

    void increaseScheduleViewCount(int scheduleNO);

    int getScheduleDurationPay(String schedulePayStartDay, String schedulePayFinishDay, int scheduleNO) throws Exception;
}
