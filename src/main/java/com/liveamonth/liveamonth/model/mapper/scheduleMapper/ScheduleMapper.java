package com.liveamonth.liveamonth.model.mapper.scheduleMapper;

import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleLikeVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository
@Mapper
public interface ScheduleMapper {

    ArrayList<ScheduleContentVO> scheduleContentList(HashMap<String, Object> scheduleCalendarDTO) throws Exception;

    Object getLastScheduleContentNO() throws Exception;

    void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception;

    int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO)  throws Exception;

    ArrayList<HashMap<String, Object>> getOtherScheduleList(HashMap<String, Object> filtersAndOrder) throws Exception;
    
    void deleteScheduleContent(int scheduleContentNO)  throws Exception;

    void modifyScheduleContent(ScheduleContentVO scheduleContentVO)  throws Exception;

    boolean addSchedule(HashMap<String, Object> scheduleVO) throws Exception;

    ArrayList<ScheduleVO> getScheduleList(int userNO)throws Exception;

	boolean modifySchedule(HashMap<String, Object> scheduleVO) throws Exception;

	boolean deleteSchedule(int scheduleNO) throws Exception;

    ArrayList<HashMap<String, Object>> getScheduleReplyList(HashMap<String, Integer> scheduleNOAndPage) throws Exception;

    int addScheduleReplyVO(ScheduleReplyVO scheduleReplyVO) throws Exception;

    boolean deleteScheduleReply(int scheduleReplyNO) throws Exception;

    boolean modifyScheduleReply(ScheduleReplyVO scheduleReplyVO) throws Exception;

    int getScheduleReplyCount(int scheduleNO) throws Exception;

    int getScheduleLikeStatus(ScheduleLikeVO scheduleLikeVO) throws Exception;

    int getScheduleLikeCount(int scheduleNO)throws Exception;

    boolean addScheduleLike(ScheduleLikeVO scheduleLikeVO)throws Exception;

    boolean deleteScheduleLike(ScheduleLikeVO scheduleLikeVO)throws Exception;

    HashMap<String, String> getScheduleAndLikeCount(int scheduleNO) throws Exception;

    void increaseScheduleViewCount(int scheduleNO);

    int getScheduleDurationPay(HashMap<String, Object> hash) throws Exception;

    int getMyScheduleListCount(HashMap<String, Object> myScheduleAndPage) throws Exception;

    ArrayList<HashMap<String, Object>> getMyScheduleList(HashMap<String, Object> myScheduleAndPage)throws Exception;

    void deleteScheduleList(HashMap<String, Object> listAndCategory)throws Exception;

    ScheduleVO getScheduleVO(int scheduleNO) throws Exception;

    ScheduleReplyVO getScheduleReply(int scheduleReplyNO) throws Exception;

    int getScheduleWriterNO(int scheduleNO) throws Exception;

    int getOtherScheduleCount(HashMap<String, Object> filtersAndOrder) throws Exception;
}
