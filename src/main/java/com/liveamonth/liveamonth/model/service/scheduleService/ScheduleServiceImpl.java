package com.liveamonth.liveamonth.model.service.scheduleService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.model.mapper.scheduleMapper.ScheduleMapper;


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
        scheduleMapper.addScheduleContent(scheduleContentVO);

    }

    @Override
    public int getLastScheduleContentNO() throws Exception {
        return scheduleMapper.getLastScheduleContentNO();
    }

    @Override
	public ArrayList<HashMap<String, Object>> getOtherScheduleList(HashMap<String, Object> filtersAndOrder) {
		HashMap<String, String> sqlParameter = new HashMap<String, String>();
		return null;
	}

    @Override
    public boolean addSchedule(ScheduleVO scheduleVO, int userNO) throws Exception {
        scheduleVO.setScheduleNO(scheduleMapper.getMaxScheduleNO() + 1);
       // scheduleVO.setScheduleLikeCount(0);
        scheduleVO.setUserNO(userNO);

        if (scheduleMapper.addSchedule(scheduleVO)) {
            return true;
        }
        return false;
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
	public int getMaxScheduleNO() throws Exception {
		// TODO Auto-generated method stub
		return scheduleMapper.getMaxScheduleNO();
	}
	
	public boolean modifySchedule(ScheduleVO scheduleVO) throws Exception {
		if(scheduleMapper.modifySchedule(scheduleVO)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteSchedule(int scheduleNO) throws Exception {
		if(scheduleMapper.deleteSchedule(scheduleNO)) {
			return true;
		}
		return false;
	}

    @Override
	public ArrayList<HashMap<String, Object>> getScheduleReplyList(int scheduleNO) throws Exception {
        return scheduleMapper.getScheduleReplyList(scheduleNO);
    }

    @Override
    public boolean addScheduleReplyVO(ScheduleReplyVO scheduleReplyVO, int userNO) throws Exception {
        String MaxNO = String.valueOf(scheduleMapper.getMaxScheduleReplyNO());
        if(MaxNO == "null") {
            scheduleReplyVO.setScheduleReplyNO(4001);
        } else {
            scheduleReplyVO.setScheduleReplyNO(Integer.parseInt(MaxNO) + 1);
        }
        scheduleReplyVO.setUserNO(userNO);

        return scheduleMapper.addScheduleReplyVO(scheduleReplyVO);
    }

    @Override
    public boolean deleteScheduleReply(int scheduleReplyNO) throws Exception {
        if(scheduleMapper.deleteScheduleReply(scheduleReplyNO)){
            return true;
        }
        return false;
    }
}
