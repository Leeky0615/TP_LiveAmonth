package com.liveamonth.liveamonth.controller;

import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.constants.EntityConstants.Month;
import com.liveamonth.liveamonth.constants.LogicConstants;
import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import com.liveamonth.liveamonth.model.service.reviewService.ReviewService;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ETemplatePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.SCHEDULE_NO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_VO;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EMyPageAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EMyPageAttributes.MANAGE_SCHEDULE_CATEGORY;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.PAIGING;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReview.POPULAR_REVIEW_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReviewAttribute.REVIEW_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleFilterAndOrders.SCHEDULE_FO_ORDER;

@Controller
public class MainController {
    @Autowired
    private CityService cityService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/")
    public String main(Model model,HttpSession session,CalendarDTO calendarDTO) throws Exception {
        ArrayList<HashMap<String, Object>> popularReviewList = reviewService.getMainPopularReviewList(1);
        model.addAttribute(POPULAR_REVIEW_LIST.getText(), popularReviewList);

        HashMap<String, Object> filtersAndOrder = new HashMap<>();
        for (LogicConstants.EScheduleFilterAndOrders eFO : LogicConstants.EScheduleFilterAndOrders.values()) {
            if (eFO == SCHEDULE_FO_ORDER)
                filtersAndOrder.put(eFO.getText(), ORDER_BY_LIKED.getText());//("orderBy","orderVubByNew)
            else filtersAndOrder.put(eFO.getText() + FILTER.getText(), false);
        }
        List<HashMap<String, Object>> otherScheduleList = scheduleService.getOtherScheduleList(filtersAndOrder, 1);
        model.addAttribute(FITERED_OTHER_SCHEDULE_LIST.getText(), otherScheduleList);

        // 달력 표시
        List<CalendarDTO> CalendarDTOList = new ArrayList<>();
        List<List<CalendarDTO>> CalendarDTODateList = new ArrayList<>();
        List<HashMap<String, Integer>> CalendarDTOTodayInformationList = new ArrayList<>();
        for(HashMap<String, Object> otherSchedule : otherScheduleList){
            int scheduleNO = (int)otherSchedule.get(SCHEDULE_NO.getText());
            calendarDTO = scheduleService.setManyContentsDate(scheduleNO,calendarDTO); // 컨텐츠가 많은 달을 가져옴
            CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);
            CalendarDTOList.add(calendarDto);
            CalendarDTODateList.add(calendarDto.getDateList());
            CalendarDTOTodayInformationList.add((HashMap)calendarDto.getTodayInformation());
        }
        model.addAttribute(MONTH_LIST.getText(), Month.values());
        model.addAttribute(CALENDAR_DTO_DATE_LIST.getText(), CalendarDTODateList); //날짜 데이터 배열 DATE_LIST
        model.addAttribute(CALENDAR_DTO_TODAY_INFORMATION_LIST.getText(), CalendarDTOTodayInformationList);

        // MainCitySlide.jsp 사용
        model.addAttribute(RANDOM_CITY_INTRO_LIST.getText(), cityService.getRandomCityInfoListByCategory(INTRO.name()));
        // CityInfoGrid.jsp 사용
        model.addAttribute(CURRENT_MONTH_TEMP_LIST.getText(),cityService.getAVGTempList());
        model.addAttribute(CITY_TRANSPORT_GRADE_LIST.getText(), cityService.getCityTransportGradeList());
        model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));

        UserVO userVO = (UserVO)session.getAttribute(USER_VO.getText());
        if(userVO != null){
            // 내 스케줄
            PagingDTO schedudlePaging = scheduleService.showMySchedulePaging(1,MANAGE_SCHEDULE_CATEGORY.getText(),userVO.getUserNO());
            model.addAttribute(PAIGING.getText(), schedudlePaging);
            ArrayList<HashMap<String, Object>> scheduleList = scheduleService.getMyScheduleList(1, userVO.getUserNO(),MANAGE_SCHEDULE_CATEGORY.getText());
            model.addAttribute(MY_SCHEDULE_LIST.getText(), scheduleList);
            model.addAttribute(MANAGE_SCHEDULE_CATEGORY.getText(), MANAGE_SCHEDULE_CATEGORY.getText());
            // 내 게시글
            PagingDTO reviewPaging = reviewService.showMyReviewPaging(1,MANAGE_REVIEW_CATEGORY.getText(),userVO.getUserNO());
            model.addAttribute(PAIGING.getText(), reviewPaging);
            ArrayList<HashMap<String, Object>> reviewList = reviewService.getMyReviewList(1, userVO.getUserNO(),MANAGE_REVIEW_CATEGORY.getText());
            model.addAttribute(REVIEW_LIST.getText(), reviewList);
            model.addAttribute(MANAGE_REVIEW_CATEGORY.getText(), MANAGE_REVIEW_CATEGORY.getText());
        }

        return MAIN.getPath();
    }

}
