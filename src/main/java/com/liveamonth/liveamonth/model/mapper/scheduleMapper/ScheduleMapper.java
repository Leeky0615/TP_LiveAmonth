package com.liveamonth.liveamonth.model.mapper.scheduleMapper;

import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleLikeVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
public interface ScheduleMapper {

    public ArrayList<ScheduleContentVO> scheduleContentList(HashMap<String, Object> scheduleCalendarDTO) throws Exception;

    public Object getLastScheduleContentNO() throws Exception;

    public void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;

    public int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO)  throws Exception;

    public List<ScheduleVO> getOtherScheduleList(HashMap<String, String> sqlParameter);
    
    public void deleteScheduleContent(int scheduleContentNO)  throws Exception;

    public void modifyScheduleContent(ScheduleContentVO scheduleContentVO)  throws Exception;

    public boolean addSchedule(ScheduleVO scheduleVO)throws Exception;

    public ArrayList<ScheduleVO> getScheduleList(int userNO)throws Exception;

	public Object getMaxScheduleNO() throws Exception;
	
	public boolean modifySchedule(ScheduleVO scheduleVO) throws Exception;

	public boolean deleteSchedule(int scheduleNO) throws Exception;

    public ArrayList<HashMap<String, Object>> getScheduleReplyList(HashMap<String, Integer> scheduleNOAndPage) throws Exception;

    public Object getMaxScheduleReplyNO() throws Exception;

    public boolean addScheduleReplyVO(ScheduleReplyVO scheduleReplyVO) throws Exception;

    public boolean deleteScheduleReply(int scheduleReplyNO) throws Exception;

    public boolean modifyScheduleReply(ScheduleReplyVO scheduleReplyVO) throws Exception;

    public int getScheduleReplyCount(int scheduleNO) throws Exception;

    public int getScheduleLikeStatus(ScheduleLikeVO scheduleLikeVO) throws Exception;

    public int getScheduleLikeCount(int scheduleNO)throws Exception;

    public boolean addScheduleLike(ScheduleLikeVO scheduleLikeVO)throws Exception;

    public boolean deleteScheduleLike(ScheduleLikeVO scheduleLikeVO)throws Exception;

    public HashMap<String, String> getScheduleAndLikeCount(int scheduleNO) throws Exception;

    public void increaseScheduleViewCount(int scheduleNO);
}
