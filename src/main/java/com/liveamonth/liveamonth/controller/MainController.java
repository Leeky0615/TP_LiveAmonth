package com.liveamonth.liveamonth.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.liveamonth.liveamonth.constants.ControllerPathConstants;
import com.liveamonth.liveamonth.constants.LogicConstants;
import com.liveamonth.liveamonth.entity.dto.PagingDTO;
import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import com.liveamonth.liveamonth.model.service.reviewService.ReviewService;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.*;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.EMyPagePath.MANAGE_SCHEDULE;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ETemplatePath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.EntityConstants.EUser.USER_VO;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EMyPageAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EMyPageAttributes.MANAGE_SCHEDULE_CATEGORY;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.PAIGING;
import static com.liveamonth.liveamonth.constants.LogicConstants.EPaging.SELECTED_PAGE;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReview.POPULAR_REVIEW_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleAttributes.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.EScheduleFilterAndOrders.SCHEDULE_FO_CITY_NAME;
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
    public String main(Model model,HttpSession session, HttpServletRequest request) throws Exception {
        ArrayList<HashMap<String, Object>> popularReviewList = reviewService.getMainPopularReviewList(1);
        model.addAttribute(POPULAR_REVIEW_LIST.getText(), popularReviewList);

        HashMap<String, Object> filtersAndOrder = new HashMap<>();
        for (LogicConstants.EScheduleFilterAndOrders eFO : LogicConstants.EScheduleFilterAndOrders.values()) {
            if (eFO == SCHEDULE_FO_ORDER)
                filtersAndOrder.put(eFO.getText(), "orderByLiked");//("orderBy","orderVubByNew)
            else filtersAndOrder.put(eFO.getText() + "Filter", false);
        }
        List<HashMap<String, Object>> otherScheduleList = scheduleService.getOtherScheduleList(filtersAndOrder);
        model.addAttribute(FITERED_OTHER_SCHEDULE_LIST.getText(), otherScheduleList);
        // MainCitySlide.jsp 사용
        model.addAttribute(RANDOM_CITY_INTRO_LIST.getText(), cityService.getRandomCityInfoListByCategory(INTRO.name()));
        // CityInfoGrid.jsp 사용
        model.addAttribute("currentMonthTempList",cityService.getAVGTempList());
        model.addAttribute("cityTransportGradeList", cityService.getCityTransportGradeList());
        model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));

            UserVO userVO = (UserVO)session.getAttribute(USER_VO.getText());
        if(userVO != null){
            String manageScheduleCategory = String.valueOf(request.getParameter(MANAGE_SCHEDULE_CATEGORY.getText()));
            String[] myScheduleCheckbox=request.getParameterValues(MY_SCHEDULE_CHECK_BOX.getText());

            if(myScheduleCheckbox !=null){
                int[] scheduleNO_OR_scheduleReplyNOList = Arrays.stream(myScheduleCheckbox).mapToInt(Integer::parseInt).toArray();

                scheduleService.deleteScheduleList(scheduleNO_OR_scheduleReplyNOList,manageScheduleCategory);
            }

            int selectPage = 1;
            if (request.getParameter(SELECTED_PAGE.getText()) != null) {
                selectPage = Integer.parseInt(request.getParameter(SELECTED_PAGE.getText()));
            }
            PagingDTO paging = scheduleService.showMySchedulePaging(selectPage,manageScheduleCategory,userVO.getUserNO());
            model.addAttribute(PAIGING.getText(), paging);
            ArrayList<HashMap<String, Object>> scheduleList = scheduleService.getMyScheduleList(selectPage, userVO.getUserNO(),manageScheduleCategory);
            model.addAttribute( MY_SCHEDULE_LIST.getText(), scheduleList);
            model.addAttribute(MANAGE_SCHEDULE_CATEGORY.getText(), manageScheduleCategory);
        }


        return MAIN.getPath();
    }

}
