package com.liveamonth.liveamonth.controller.scheduleController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import com.liveamonth.liveamonth.model.service.myPageService.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.entity.vo.ScheduleContentVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ESchedulePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.ESchedule.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EScheduleContent.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EScheduleReply.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EAlertMessage.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleFilterAndOrders.*;

@Controller
public class ScheduleController{
    @Autowired
    private ScheduleService scheduleService;

    private int scheduleContentNO;

    @RequestMapping(value="addScheduleContent")
    public String addScheduleContent(HttpServletRequest request, ScheduleContentVO scheduleContentVO, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();
        scheduleContentVO.setScheduleNO(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))));
        int count = scheduleService.beforeScheduleAddSearch(scheduleContentVO);

        String message = "";
        if(count>=4){
            message = MAXIMUM_SCHEDULE_CONTENT.getText();
        }else{
            scheduleContentVO.setScheduleContentNO(scheduleService.getLastScheduleContentNO()+1);
            scheduleService.addScheduleContent(scheduleContentVO);
            message = ADD_SCHEDULE_CONTENT.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(),message);
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value="deleteScheduleContent")
    public String deleteScheduleContent(RedirectAttributes rttr) throws Exception{
        scheduleService.deleteScheduleContent(scheduleContentNO);

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_DELETION.getText());
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value="modifyScheduleContent")
    public String modifyScheduleContent(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        String scheduleContentSubject = request.getParameter(MODIFY_SCHEDULE_CONTENT_SUBJECT.getText());
        String scheduleContentDesc = request.getParameter(MODIFY_SCHEDULE_CONTENT_DESC.getText());
        int scheduleContentCost = Integer.parseInt(request.getParameter(MODIFY_SCHEDULE_CONTENT_COST.getText()));
        scheduleService.modifyScheduleContent(scheduleContentNO,scheduleContentSubject,scheduleContentDesc,scheduleContentCost);

        rttr.addFlashAttribute(MESSAGE.getText(), COMPLETE_SCHEDULE_MODIFICATION.getText());
        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping("/schedule")
    public String schedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
    	HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO)session.getAttribute(USER_VO.getText());
        int userNO = session_UserVO.getUserNO();

        ArrayList<ScheduleVO> scheduleVOList = scheduleService.getScheduleList(userNO);

        int scheduleNO;

		if(scheduleVOList.isEmpty()) {
			scheduleNO = scheduleService.getMaxScheduleNO() +1;
		} else {
			scheduleNO = scheduleVOList.get(0).getScheduleNO();
		}

        if(session.getAttribute(SELECTED_SCHEDULE_NO.getText()) != null) {
        	scheduleNO = Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText())));
        } else {
        	session.setAttribute(SELECTED_SCHEDULE_NO.getText(), scheduleNO);
        }

        CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);

        model.addAttribute(SCHEDULE_VO_LIST.getText(), scheduleVOList);
        model.addAttribute(DATE_LIST.getText(), calendarDto.getDateList()); //날짜 데이터 배열
        model.addAttribute(TODAY_INFORMATION.getText(), calendarDto.getTodayInformation());
        model.addAttribute(SCHEDULE_PLACE_LIST.getText(), CityName.values());
        return SCHEDULE.getPath();
    }


    @RequestMapping("/swapSchedule")
    public String swapSchedule(HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        session.setAttribute(SELECTED_SCHEDULE_NO.getText(), request.getParameter(SELECT_SCHEDULE.getText()));
        return REDIRECT_SCHEDULE.getRedirectPath();
    }
    @RequestMapping(value="addSchedule")
    public String addSchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO)session.getAttribute(USER_VO.getText());
        int userNO = session_UserVO.getUserNO();

        String message = "";
        if(scheduleService.addSchedule(scheduleVO, userNO)) {
            message = ADD_SCHEDULE.getText();
        } else {
            message = FAIL_TO_ADD_SCHEDULE.getText();
        }
        rttr.addFlashAttribute(MESSAGE.getText(), message);
        return REDIRECT_SCHEDULE.getRedirectPath();
    }


    @RequestMapping(value="modifySchedule")
    public String modifySchedule(HttpServletRequest request, ScheduleVO scheduleVO, RedirectAttributes rttr) throws Exception{
    	HttpSession session = request.getSession();
    	scheduleVO.setScheduleNO(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))));

        String message = "";
        if(scheduleService.modifySchedule(scheduleVO)) {
            message = COMPLETE_SCHEDULE_MODIFICATION.getText();
        } else {
            message = FAIL_TO_MODIFY_SCHEDULE.getText();
        }
        rttr.addFlashAttribute(MESSAGE.getText(), message);

        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @RequestMapping(value="deleteSchedule")
    public String deleteSchedule(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        HttpSession session = request.getSession();

        String message = "";
        if(scheduleService.deleteSchedule(Integer.parseInt(String.valueOf(session.getAttribute(SELECTED_SCHEDULE_NO.getText()))))) {
            session.setAttribute(SELECTED_SCHEDULE_NO.getText(), null);
            message = COMPLETE_SCHEDULE_DELETION.getText();
        } else {
            message = FAIL_TO_DELETE_SCHEDULE.getText();
        }
        rttr.addFlashAttribute(MESSAGE.getText(), message);

        return REDIRECT_SCHEDULE.getRedirectPath();
    }

    @ResponseBody
    @RequestMapping(value = "/showScheduleContentList", method = RequestMethod.POST)
    public void showScheduleContentList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        this.scheduleContentNO = Integer.parseInt(request.getParameter(SCHEDULE_CONTENT_NO.getText()));
    }
    private int checkOption(String option){
        if(!option.equals("null")) return Integer.parseInt(option);
        else return -1;
    }
    private List<HashMap<String, Object>> makeOtherScheduleList(HttpServletRequest request, String action) throws Exception {
        HashMap<String, Object> filtersAndOrder = new HashMap<>();
        // action = list : 초기 헤더메뉴 클릭시
        System.out.println("action = " + action);
        if(action.equals(SCHEDULE_LIST.getText())){
            for(EScheduleFilterAndOrders eFO : EScheduleFilterAndOrders.values()){
                if(eFO == SCHEDULE_FO_ORDER) filtersAndOrder.put(eFO.getText(),"orderByNew");
                else filtersAndOrder.put(eFO.getText()+"Filter",false);
            }
        } else if(action.equals(SCHEDULE_FILTER.getText())) {// action = filter : OtherSchedule 페이지에서 필터 및 정렬 수행시
            // Hashmap에 필터/정렬 Object를 담는다.
            for(EScheduleFilterAndOrders eFO : EScheduleFilterAndOrders.values()){ // {userSex, userAge, schedulePlace, orderBy}
                if(eFO == SCHEDULE_FO_ORDER) {
                    // orderBy인 경우 View에서 OrderBy의 value를 가져옴. {"orderByLiked" | "orderByNew" | "orderByView"}
                    filtersAndOrder.put(eFO.getText(), request.getParameter(SCHEDULE_FO_ORDER.getText()));
                }else{
                    // 나머지 경우는 받아온 parameter에 대해 int로 변환(CheckOption() -> null(기본값)인 경우 -1 return)
                    int option = this.checkOption(request.getParameter(eFO.getText()));
                    // filter 설정 유무 -> 기본 : default
                    boolean optionStatus = false;
                    if (option != -1) {
                        optionStatus = true; // option이 null(-1)이 아니면 true
                        if(eFO == SCHEDULE_FO_PLACE) {
                            //schedulePlace는 HashMap에 값을 String으로 넣어 줘야하므로 CityNameList에서 option(int)에 해당하는 인덱스 값을 넣어줌.
                            filtersAndOrder.put(eFO.getText(), CityName.values()[option]);
                        }else{
                            // 나머지 경우는 그냥 option(int)를 넣어줌
                            filtersAndOrder.put(eFO.getText(), option);
                        }
                    }

                    // optionStatus를 HashMap에 저장 (attribute 값 : userSexFilter, userAgeFilter, schedulePlaceFilter)
                    filtersAndOrder.put(eFO.getText()+"Filter",optionStatus);
                }
            }
        }
        return scheduleService.getOtherScheduleList(filtersAndOrder);
    }
    @RequestMapping("/otherScheduleList")
    public String otherScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception {
        List<HashMap<String, Object>> otherScheduleList = this.makeOtherScheduleList(request,request.getParameter(SCHEDULE_ACTION.getText()));

        model.addAttribute(FITERED_OTHER_SCHEDULE_LIST.getText(), otherScheduleList);
        model.addAttribute(SCHEDULE_PLACE_LIST.getText(), CityName.values());
        return OTHER_SCHEDULE_LIST.getPath();
    }
    @RequestMapping("/otherSchedule")
    public String otherSchedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception{
        int scheduleNO = Integer.parseInt((String) request.getParameter(SCHEDULE_NO.getText()));

        CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);

        model.addAttribute(SCHEDULEREPLY_VO_LIST.getText(), scheduleService.getScheduleReplyList(scheduleNO));
        model.addAttribute(SCHEDULE_NO.getText(), scheduleNO);
        model.addAttribute(DATE_LIST.getText(), calendarDto.getDateList()); //날짜 데이터 배열
        model.addAttribute(TODAY_INFORMATION.getText(), calendarDto.getTodayInformation());

        return OTHER_SCHEDULE.getPath();
    }

    @RequestMapping(value="addScheduleReply")
    public String addScheduleReply(HttpServletRequest request, ScheduleReplyVO scheduleReplyVO, RedirectAttributes rttr) throws Exception{
    	HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO)session.getAttribute(USER_VO.getText());
        int userNO = session_UserVO.getUserNO();

        String message = "";
        if(scheduleService.addScheduleReplyVO(scheduleReplyVO, userNO)) {
            message = ADD_SCHEDULEREPLY.getText();
        } else {
            message = FAIL_TO_ADD_SCHEDULEREPLY.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        rttr.addAttribute(SCHEDULE_NO.getText(), scheduleReplyVO.getScheduleNO());

        return REDIRECT_OTHER_SCHEDULE.getRedirectPath();
    }

    @RequestMapping("/deleteScheduleReply")
    public String deleteScheduleReply(HttpServletRequest request, RedirectAttributes rttr) throws Exception{
        int scheduleReplyNO = Integer.parseInt(String.valueOf(request.getParameter(SCHEDULE_REPLY_NO.getText())));
        int scheduleNO = Integer.parseInt(String.valueOf(request.getParameter(SCHEDULE_NO.getText())));

        String message = "";
        if(scheduleService.deleteScheduleReply(scheduleReplyNO)) {
            message = COMPLETE_SCHEDULEREPLY_DELETION.getText();
        } else {
            message = FAIL_TO_DELETE_SCHEDULEREPLY.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        rttr.addAttribute(SCHEDULE_NO.getText(), scheduleNO);

        return REDIRECT_OTHER_SCHEDULE.getRedirectPath();
    }
}