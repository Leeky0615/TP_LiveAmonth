package com.liveamonth.liveamonth.model.mapper.scheduleMapper;

import java.util.ArrayList;
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
    public ArrayList<ScheduleContentVO> scheduleContentList(CalendarDTO calendarDTO) throws Exception;
    public int getLastScheduleContentNO() throws Exception;
    public void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;
    public int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO) throws Exception;
    public List<ScheduleVO> getOtherScheduleInfo();
}
