package com.liveamonth.liveamonth.model.mapper.scheduleMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;

@Repository
@Mapper
public interface ScheduleMapper {
    ArrayList<ScheduleContentVO> scheduleContentList(HashMap<String, Object> scheduleCalendarDTO) throws Exception;

    int getLastScheduleContentNO() throws Exception;

    void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;

    int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO) throws Exception;


    List<ScheduleVO> getOtherScheduleInfo();


    void deleteScheduleContent(int scheduleContentNO) throws Exception;

    void modifyScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;

    int getLastScheduleNO() throws Exception;

    boolean addSchedule(ScheduleVO scheduleVO) throws Exception;

    ArrayList<ScheduleVO> getScheduleList(String userID) throws Exception;

    int findUserIDToUserNO(String userID) throws Exception;
}
