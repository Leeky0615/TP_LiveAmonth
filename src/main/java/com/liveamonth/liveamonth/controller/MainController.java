package com.liveamonth.liveamonth.controller;

import com.liveamonth.liveamonth.constants.LogicConstants;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import com.liveamonth.liveamonth.model.service.reviewService.ReviewService;
import com.liveamonth.liveamonth.model.service.scheduleService.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ETemplatePath.MAIN;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.CITY_INTRO_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.RANDOM_CITY_INTRO_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.EReview.POPULAR_REVIEW_LIST;
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
    public String main(Model model) throws Exception {
        ArrayList<HashMap<String, Object>> popularReviewList = reviewService.getMainPopularReviewList(1);
        model.addAttribute(POPULAR_REVIEW_LIST.getText(), popularReviewList);

        HashMap<String, Object> filtersAndOrder = new HashMap<>();
        for (LogicConstants.EScheduleFilterAndOrders eFO : LogicConstants.EScheduleFilterAndOrders.values()) {
            if (eFO == SCHEDULE_FO_ORDER)
                filtersAndOrder.put(eFO.getText(), "orderByLiked");//("orderBy","orderVubByNew)
            else filtersAndOrder.put(eFO.getText() + "Filter", false);
        }
//        List<HashMap<String, Object>> otherScheduleList = scheduleService.getOtherScheduleList(filtersAndOrder, 0);
//        model.addAttribute(FITERED_OTHER_SCHEDULE_LIST.getText(), otherScheduleList);
        // MainCitySlide.jsp 사용
        model.addAttribute(RANDOM_CITY_INTRO_LIST.getText(), cityService.getRandomCityInfoListByCategory(INTRO.name()));
        // CityInfoGrid.jsp 사용
        model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));
        return MAIN.getPath();
    }

}
