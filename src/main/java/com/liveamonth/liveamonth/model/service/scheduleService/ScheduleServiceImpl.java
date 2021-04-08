package com.liveamonth.liveamonth.model.service.scheduleService;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.model.mapper.scheduleMapper.ScheduleMapper;


@Service
public class ScheduleServiceImpl implements ScheduleService{
	@Autowired
	private ScheduleMapper scheduleMapper;
	
	@Override
	public CalendarDTO showCalendar(CalendarDTO calendarDTO) throws Exception {
		Calendar cal = Calendar.getInstance();
		CalendarDTO calendarData;
		
		//검색 날짜
		if(calendarDTO.getDate().equals("")&&calendarDTO.getMonth().equals("")){
			calendarDTO = new CalendarDTO(String.valueOf(cal.get(Calendar.YEAR)),String.valueOf(cal.get(Calendar.MONTH)),String.valueOf(cal.get(Calendar.DATE)),null,null);
		}
		calendarDTO.setTodayInformation(calendarDTO.todayInformation(calendarDTO));
		calendarDTO.setDateList(new ArrayList<CalendarDTO>());
		
		//검색 날짜 end
		ArrayList<ScheduleContentVO> ScheduleList =  scheduleMapper.scheduleContentList(calendarDTO);

		//달력데이터에 넣기 위한 배열 추가
		ScheduleContentVO[][] scheduleDataArray = new ScheduleContentVO[32][4];
		if(ScheduleList.isEmpty()!=true){
			int j = 0;
			for(int i=0; i<ScheduleList.size(); i++){
				int date = Integer.parseInt(String.valueOf(ScheduleList.get(i).getScheduleContentDate()).substring(String.valueOf(ScheduleList.get(i).getScheduleContentDate()).length()-2,String.valueOf(ScheduleList.get(i).getScheduleContentDate()).length()));
				if(i>0){
					int dateBefore = Integer.parseInt(String.valueOf(ScheduleList.get(i-1).getScheduleContentDate()).substring(String.valueOf(ScheduleList.get(i-1).getScheduleContentDate()).length()-2,String.valueOf(ScheduleList.get(i-1).getScheduleContentDate()).length()));
					if(dateBefore==date){
						j=j+1;
						scheduleDataArray[date][j] = ScheduleList.get(i);
					}else{
						j=0;
						scheduleDataArray[date][j] = ScheduleList.get(i);
					}
				}else{
					scheduleDataArray[date][j] = ScheduleList.get(i);
				}
			}
		}
		
		//실질적인 달력 데이터 리스트에 데이터 삽입 시작.
		//일단 시작 인덱스까지 아무것도 없는 데이터 삽입
		for(int i=1; i<calendarDTO.getTodayInformation().get("start"); i++){
			calendarData= new CalendarDTO(null, null, null, null, null);
			calendarDTO.getDateList().add(calendarData);
		}

		//날짜 삽입
		for (int i = calendarDTO.getTodayInformation().get("startDay"); i <= calendarDTO.getTodayInformation().get("endDay"); i++) {
			ScheduleContentVO[] scheduleDataArray3 = new ScheduleContentVO[4];
			scheduleDataArray3 = scheduleDataArray[i];

			if(i==calendarDTO.getTodayInformation().get("today")){
				calendarData= new CalendarDTO(String.valueOf(calendarDTO.getYear()), String.valueOf(calendarDTO.getMonth()), String.valueOf(i), "today", scheduleDataArray3);
			}else{
				calendarData= new CalendarDTO(String.valueOf(calendarDTO.getYear()), String.valueOf(calendarDTO.getMonth()), String.valueOf(i), "normalDate", scheduleDataArray3);
			}
			calendarDTO.getDateList().add(calendarData);

		}

		//달력 빈 곳 빈 데이터로 삽입
		int index = 7-calendarDTO.getDateList().size()%7;

		if(calendarDTO.getDateList().size()%7!=0){

			for (int i = 0; i < index; i++) {
				calendarData= new CalendarDTO(null, null, null, null, null);
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
	public ArrayList<ScheduleContentVO> scheduleContentList(CalendarDTO calendarDTO) throws Exception {
		
		return scheduleMapper.scheduleContentList(calendarDTO);
	}
}
