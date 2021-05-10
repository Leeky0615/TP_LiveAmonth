package com.liveamonth.liveamonth.controller.scheduleController;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.entity.dto.Paging;
import com.liveamonth.liveamonth.entity.vo.ScheduleLikeVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleReplyVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.liveamonth.liveamonth.entity.dto.CalendarDTO;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;

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
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleFilterAndOrders.*;

@Controller
public class OtherScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    private int checkOption(String option) {
        if (option != null) {
            if (!"null".equals(option)) {
                return Integer.parseInt(option);
            }
        }
        return -1;
    }

    private HashMap<String, Object> makeRequestList(HttpServletRequest request) {
        HashMap<String, Object> requestList = new HashMap<>();

        for (EScheduleFilterAndOrders eFO : EScheduleFilterAndOrders.values()) {
            if (eFO == SCHEDULE_FO_ORDER) {
                requestList.put(eFO.getText(), request.getParameter(eFO.getText()));
            } else {
                int option = this.checkOption(request.getParameter(eFO.getText()));

                requestList.put(eFO.getText(), option);
            }
        }
        return requestList;
    }

    private List<HashMap<String, Object>> makeOtherScheduleList(HttpServletRequest request, String action) throws Exception {
        HashMap<String, Object> filtersAndOrder = new HashMap<>();
        // action = list : 초기 헤더메뉴 클릭시
        System.out.println("action = " + action);
        if (action.equals(SCHEDULE_LIST.getText())) { // 기본값
            for (EScheduleFilterAndOrders eFO : EScheduleFilterAndOrders.values()) {
                if (eFO == SCHEDULE_FO_ORDER)
                    filtersAndOrder.put(eFO.getText(), "orderByNew");//("orderBy","orderVubByNexw)
                else filtersAndOrder.put(eFO.getText() + "Filter", false);
            }
            for (Map.Entry<String, Object> entry : filtersAndOrder.entrySet()) {
                System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
            }
        } else if (action.equals(SCHEDULE_FILTER.getText())) {// action = filter : OtherSchedule 페이지에서 필터 및 정렬 수행시
            // Hashmap에 필터/정렬 Object를 담는다.
            for (EScheduleFilterAndOrders eFO : EScheduleFilterAndOrders.values()) { // {userSex, userAge, schedulePlace, orderBy, userSexFilter}
                if (eFO == SCHEDULE_FO_ORDER) {
                    // orderBy인 경우 View에서 OrderBy의 value를 가져옴. {"orderByLiked" | "orderByNew" | "orderByView"}
                    filtersAndOrder.put(eFO.getText(), request.getParameter(SCHEDULE_FO_ORDER.getText()));
                } else {
                    // 나머지 경우는 받아온 parameter에 대해 int로 변환(CheckOption() -> null(기본값)인 경우 -1 return)
                    //null
                    int option = this.checkOption(request.getParameter(eFO.getText()));
                    //int option = this.checkOption(String.valueOf(request.getParameter(eFO.getText())));
                    // filter 설정 유무 -> 기본 : default
                    boolean optionStatus = false;
                    if (option != -1) {
                        optionStatus = true; // option이 null(-1)이 아니면 true
                        if (eFO == SCHEDULE_FO_PLACE) {
                            //schedulePlace는 HashMap에 값을 String으로 넣어 줘야하므로 CityNameList에서 option(int)에 해당하는 인덱스 값을 넣어줌.
                            filtersAndOrder.put(eFO.getText(), CityName.values()[option]);
                        } else {
                            // 나머지 경우는 그냥 option(int)를 넣어줌
                            filtersAndOrder.put(eFO.getText(), option);
                        }
                    }

                    // optionStatus를 HashMap에 저장 (attribute 값 : userSexFilter, userAgeFilter, schedulePlaceFilter)
                    filtersAndOrder.put(eFO.getText() + "Filter", optionStatus);

                }
            }
        }
        return scheduleService.getOtherScheduleList(filtersAndOrder);
    }

    @RequestMapping("/otherScheduleList")
    public String otherScheduleList(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception {
        List<HashMap<String, Object>> otherScheduleList = this.makeOtherScheduleList(request, request.getParameter(SCHEDULE_ACTION.getText()));
        HashMap<String, Object> requestList = makeRequestList(request);

        model.addAttribute(FITERED_OTHER_SCHEDULE_LIST.getText(), otherScheduleList);
        model.addAttribute(SCHEDULE_PLACE_LIST.getText(), CityName.values());
        model.addAttribute(REQUEST_LIST.getText(), requestList);
        return OTHER_SCHEDULE_LIST.getPath();
    }

    @RequestMapping("/otherSchedule")
    public String otherSchedule(Model model, HttpServletRequest request, CalendarDTO calendarDTO) throws Exception {
        HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());

        int scheduleNO = Integer.parseInt((String) request.getParameter(SCHEDULE_NO.getText()));
        System.out.println("scheduleNO" + scheduleNO);

        int selectPage = 1;
        if (request.getParameter(SELECTED_PAGE.getText()) != null) {
            selectPage = Integer.parseInt(request.getParameter(SELECTED_PAGE.getText()));
        }

        scheduleService.increaseScheduleViewCount(scheduleNO);

        CalendarDTO calendarDto = scheduleService.showCalendar(calendarDTO, scheduleNO);
        Paging paging = scheduleService.showPaging(selectPage, scheduleNO);

        //아직은 scheduleNO와 VIEW밖에 이용을 안해 VO째로 꺼내오지 않음. 만약 VO째로 꺼내오게 된다면 mapper의 resultMap을 수정.
        model.addAttribute(OTHER_SCHEDULE_AND_LIKE_COUNT.getText(), scheduleService.getScheduleAndLikeCount(scheduleNO));
        model.addAttribute(SCHEDULEREPLY_VO_LIST.getText(), scheduleService.getScheduleReplyList(scheduleNO, selectPage));
        model.addAttribute(PAIGING.getText(), paging);

        model.addAttribute(SCHEDULE_NO.getText(), scheduleNO);
        model.addAttribute(DATE_LIST.getText(), calendarDto.getDateList()); //날짜 데이터 배열
        model.addAttribute(TODAY_INFORMATION.getText(), calendarDto.getTodayInformation());

        if (session_UserVO != null) {
            ScheduleLikeVO scheduleLikeVO = new ScheduleLikeVO();
            scheduleLikeVO.setScheduleNO(scheduleNO);
            scheduleLikeVO.setScheduleLikeUserNO(session_UserVO.getUserNO());
            model.addAttribute(LIKE_STATUS.getText(), scheduleService.getScheduleLikeStatus(scheduleLikeVO));
        }

        return OTHER_SCHEDULE.getPath();
    }

    @RequestMapping(value = "addScheduleReply")
    public String addScheduleReply(HttpServletRequest request, ScheduleReplyVO scheduleReplyVO, RedirectAttributes rttr) throws Exception {
        HttpSession session = request.getSession();
        UserVO session_UserVO = (UserVO) session.getAttribute(USER_VO.getText());
        int userNO = session_UserVO.getUserNO();

        System.out.println("dd : " + scheduleReplyVO.getScheduleReplyDate());

        String message = "";
        if (scheduleService.addScheduleReplyVO(scheduleReplyVO, userNO)) {
            message = ADD_SCHEDULEREPLY.getText();
        } else {
            message = FAIL_TO_ADD_SCHEDULEREPLY.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        rttr.addAttribute(SCHEDULE_NO.getText(), scheduleReplyVO.getScheduleNO());

        return REDIRECT_OTHER_SCHEDULE.getRedirectPath();
    }

    @RequestMapping("/deleteScheduleReply")
    public String deleteScheduleReply(HttpServletRequest request, RedirectAttributes rttr) throws Exception {
        int scheduleReplyNO = Integer.parseInt(String.valueOf(request.getParameter(SCHEDULE_REPLY_NO.getText())));
        int scheduleNO = Integer.parseInt(String.valueOf(request.getParameter(SCHEDULE_NO.getText())));

        String message = "";
        if (scheduleService.deleteScheduleReply(scheduleReplyNO)) {
            message = COMPLETE_SCHEDULEREPLY_DELETION.getText();
        } else {
            message = FAIL_TO_DELETE_SCHEDULEREPLY.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        rttr.addAttribute(SCHEDULE_NO.getText(), scheduleNO);

        return REDIRECT_OTHER_SCHEDULE.getRedirectPath();
    }

    @RequestMapping("modifyScheduleReply")
    public String modifyScheduleReply(RedirectAttributes rttr, ScheduleReplyVO scheduleReplyVO) throws Exception {

        String message = "";
        if (scheduleService.modifyScheduleReply(scheduleReplyVO)) {
            message = COMPLETE_SCHEDULEREPLY_MODIFICATION.getText();
        } else {
            message = FAIL_TO_MODIFY_SCHEDULEREPLY.getText();
        }

        rttr.addFlashAttribute(MESSAGE.getText(), message);
        rttr.addAttribute(SCHEDULE_NO.getText(), scheduleReplyVO.getScheduleNO());

        return REDIRECT_OTHER_SCHEDULE.getRedirectPath();
    }

    @ResponseBody
    @RequestMapping(value = "/updateScheduleLike", method = RequestMethod.GET)
    public HashMap<String, Integer> getScheduleLikeAndCount(@ModelAttribute ScheduleLikeVO scheduleLikeVO) throws Exception {
        return scheduleService.getScheduleLikeAndCount(scheduleLikeVO);
    }
}
