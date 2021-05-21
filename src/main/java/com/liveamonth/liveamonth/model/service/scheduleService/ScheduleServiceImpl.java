package com.liveamonth.liveamonth.model.service.scheduleService;


import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleLikeVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.model.mapper.scheduleMapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import static com.liveamonth.liveamonth.constants.EntityConstants.EPage.DISPLAY_PAGE;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.SCHEDULE_NO;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleStaticInt.*;


@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public CalendarDTO showCalendar(CalendarDTO calendarDTO, int scheduleNO) throws Exception {
        Calendar cal = Calendar.getInstance();
        CalendarDTO calendarData;

        //검색 날짜
        if (calendarDTO.getDate().equals("") && calendarDTO.getMonth().equals("")) {
            calendarDTO = new CalendarDTO(String.valueOf(cal.get(Calendar.YEAR)), String.valueOf(cal.get(Calendar.MONTH)), String.valueOf(cal.get(Calendar.DATE)), null, null);
        }
        calendarDTO.setTodayInformation(calendarDTO.todayInformation(calendarDTO));
        calendarDTO.setDateList(new ArrayList<CalendarDTO>());

        //검색 날짜 end
        HashMap<String, Object> scheduleCalendarDTO = new HashMap<String, Object>();
        scheduleCalendarDTO.put("scheduleNO", scheduleNO);
        scheduleCalendarDTO.put("calendarDTO", calendarDTO);
        ArrayList<ScheduleContentVO> ScheduleList = scheduleMapper.scheduleContentList(scheduleCalendarDTO);

        //달력데이터에 넣기 위한 배열 추가
        ScheduleContentVO[][] scheduleDataArray = new ScheduleContentVO[32][4];
        if (ScheduleList.isEmpty() != true) {
            int j = 0;
            for (int i = 0; i < ScheduleList.size(); i++) {
                int date = Integer.parseInt(String.valueOf(ScheduleList.get(i).getScheduleContentDate()).substring(String.valueOf(ScheduleList.get(i).getScheduleContentDate()).length() - 2, String.valueOf(ScheduleList.get(i).getScheduleContentDate()).length()));
                if (i > 0) {
                    int dateBefore = Integer.parseInt(String.valueOf(ScheduleList.get(i - 1).getScheduleContentDate()).substring(String.valueOf(ScheduleList.get(i - 1).getScheduleContentDate()).length() - 2, String.valueOf(ScheduleList.get(i - 1).getScheduleContentDate()).length()));
                    if (dateBefore == date) {
                        j = j + 1;
                        scheduleDataArray[date][j] = ScheduleList.get(i);
                    } else {
                        j = 0;
                        scheduleDataArray[date][j] = ScheduleList.get(i);
                    }
                } else {
                    scheduleDataArray[date][j] = ScheduleList.get(i);
                }
            }
        }

        //실질적인 달력 데이터 리스트에 데이터 삽입 시작.
        //일단 시작 인덱스까지 아무것도 없는 데이터 삽입
        for (int i = 1; i < calendarDTO.getTodayInformation().get("start"); i++) {
            calendarData = new CalendarDTO(null, null, null, null, null);
            calendarDTO.getDateList().add(calendarData);
        }

        //날짜 삽입
        for (int i = calendarDTO.getTodayInformation().get("startDay"); i <= calendarDTO.getTodayInformation().get("endDay"); i++) {
            ScheduleContentVO[] scheduleDataArray3 = new ScheduleContentVO[4];
            scheduleDataArray3 = scheduleDataArray[i];

            if (i == calendarDTO.getTodayInformation().get("today")) {
                calendarData = new CalendarDTO(String.valueOf(calendarDTO.getYear()), String.valueOf(calendarDTO.getMonth()), String.valueOf(i), "today", scheduleDataArray3);
            } else {
                calendarData = new CalendarDTO(String.valueOf(calendarDTO.getYear()), String.valueOf(calendarDTO.getMonth()), String.valueOf(i), "normalDate", scheduleDataArray3);
            }
            calendarDTO.getDateList().add(calendarData);

        }

        //달력 빈 곳 빈 데이터로 삽입
        int index = 7 - calendarDTO.getDateList().size() % 7;

        if (calendarDTO.getDateList().size() % 7 != 0) {

            for (int i = 0; i < index; i++) {
                calendarData = new CalendarDTO(null, null, null, null, null);
                calendarDTO.getDateList().add(calendarData);
            }
        }
        return calendarDTO;
    }

    @Override
    public int beforeScheduleAddSearch(ScheduleContentVO scheduleContentVO) throws Exception {
        return scheduleMapper.beforeScheduleAddSearch(scheduleContentVO);
    }

    @Override
    public void addScheduleContent(ScheduleContentVO scheduleContentVO) throws Exception {
        Object LastNO = scheduleMapper.getLastScheduleContentNO();
        if(LastNO != null){
            scheduleContentVO.setScheduleContentNO(Integer.parseInt(String.valueOf(LastNO))+1);
        } else {
            scheduleContentVO.setScheduleContentNO(FIRST_SCHEDULECONTENT_NO.getText());
        }
        scheduleMapper.addScheduleContent(scheduleContentVO);
    }

    //otherList
    @Override
	public ArrayList<HashMap<String, Object>> getOtherScheduleList(HashMap<String, Object> filtersAndOrder) throws Exception{
		return scheduleMapper.getOtherScheduleList(filtersAndOrder);
	}


    @Override
    public ArrayList<ScheduleVO> getScheduleList(int userNO) throws Exception {
        return scheduleMapper.getScheduleList(userNO);
    }

    @Override
    public void deleteScheduleContent(int scheduleContentNO) throws Exception {
        scheduleMapper.deleteScheduleContent(scheduleContentNO);

    }

    @Override
    public void modifyScheduleContent(int scheduleContentNO, String scheduleContentSubject, String scheduleContentDesc,
    		int scheduleContentCost) throws Exception {
    	ScheduleContentVO scheduleContentVO = new ScheduleContentVO();
    	scheduleContentVO.setScheduleContentNO(scheduleContentNO);
    	scheduleContentVO.setScheduleContentSubject(scheduleContentSubject);
    	scheduleContentVO.setScheduleContentDesc(scheduleContentDesc);
    	scheduleContentVO.setScheduleContentCost(scheduleContentCost);
    	scheduleMapper.modifyScheduleContent(scheduleContentVO);

    }

    @Override
    public boolean addSchedule(HashMap<String, Object> scheduleVO) throws Exception {
        return scheduleMapper.addSchedule(scheduleVO);
    }
	
	public boolean modifySchedule(HashMap<String, Object> scheduleVO) throws Exception {
		return scheduleMapper.modifySchedule(scheduleVO);
	}

	@Override
	public boolean deleteSchedule(int scheduleNO) throws Exception {
		return scheduleMapper.deleteSchedule(scheduleNO);
	}

    @Override
	public ArrayList<HashMap<String, Object>> getScheduleReplyList(int scheduleNO, int page) throws Exception {
        int startNum = (page-1)*15;
        HashMap<String, Integer> scheduleNOAndPage = new HashMap<String, Integer>();
        scheduleNOAndPage.put(SCHEDULE_NO.getText(), scheduleNO);
        scheduleNOAndPage.put(START_NO.getText(), startNum);
        scheduleNOAndPage.put(DISPLAY_PAGE.getText(), STATIC_DISPLAY_PAGE_NUM.getText());

        ArrayList<HashMap<String, Object>> list = scheduleMapper.getScheduleReplyList(scheduleNOAndPage);

        return list;
    }

    @Override
    public boolean addScheduleReplyVO(ScheduleReplyVO scheduleReplyVO, int userNO) throws Exception {
        scheduleReplyVO.setUserNO(userNO);
        return scheduleMapper.addScheduleReplyVO(scheduleReplyVO);
    }

    @Override
    public boolean deleteScheduleReply(int scheduleReplyNO) throws Exception {
        return scheduleMapper.deleteScheduleReply(scheduleReplyNO);
    }

    @Override
    public boolean modifyScheduleReply(ScheduleReplyVO scheduleReplyVO) throws Exception {
        return scheduleMapper.modifyScheduleReply(scheduleReplyVO);
    }

    @Override
    public int getScheduleLikeStatus(ScheduleLikeVO scheduleLikeVO) throws Exception {
        return scheduleMapper.getScheduleLikeStatus(scheduleLikeVO);
    }

    @Override
    public HashMap<String, String> getScheduleAndLikeCount(int scheduleNO) throws Exception {
        return scheduleMapper.getScheduleAndLikeCount(scheduleNO);
    }

    @Override
    public HashMap<String, Integer> getScheduleLikeAndCount(ScheduleLikeVO scheduleLikeVO) throws Exception {
        HashMap<String, Integer> like = new HashMap<>();
        int likeStatus = scheduleMapper.getScheduleLikeStatus(scheduleLikeVO);
        if(likeStatus == 0){
           if(scheduleMapper.addScheduleLike(scheduleLikeVO)){
               like.put(LIKE_STATUS.getText(), 1);
           }
        } else if(likeStatus == 1){
            if(scheduleMapper.deleteScheduleLike(scheduleLikeVO)){
                like.put(LIKE_STATUS.getText(), 0);
            }
        }
        like.put(LIKE_COUNT.getText(), scheduleMapper.getScheduleLikeCount(scheduleLikeVO.getScheduleNO()));
        return like;
    }

    @Override
    public PagingDTO showPaging(int selectPage, int scheduleNO) throws Exception {
        PagingDTO paging = new PagingDTO();
        paging.setPage(selectPage);
        paging.setTotalCount(scheduleMapper.getScheduleReplyCount(scheduleNO));
        return paging;
    }

    @Override
    public void increaseScheduleViewCount(int scheduleNO) {
        scheduleMapper.increaseScheduleViewCount(scheduleNO);
    }

    @Override
    public int getScheduleDurationPay(String schedulePayStartDay, String schedulePayFinishDay, int scheduleNO) throws Exception {
        HashMap<String, Object> hash = new HashMap<String, Object>();
        hash.put("schedulePayStartDay", schedulePayStartDay);
        hash.put("schedulePayFinishDay", schedulePayFinishDay);
        hash.put("scheduleNO", scheduleNO);

        return scheduleMapper.getScheduleDurationPay(hash);
    }
}
