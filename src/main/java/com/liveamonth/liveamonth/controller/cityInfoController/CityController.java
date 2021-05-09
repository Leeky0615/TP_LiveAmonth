package com.liveamonth.liveamonth.controller.cityInfoController;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.CITY_INFO_GRID;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.CITY_INFO;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/city")
    public String city(Model model) throws Exception {
        List<CityInfoVO> cityIntroList = cityService.getCityInfoListByCategory(INTRO.name());
        model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
        model.addAttribute("cityName", "all");
        return "City";
    }

    @RequestMapping(value = "/cityInfo")
    public String cityInfo(Model model, @RequestParam("cityName") String cityName) throws Exception {
        if (!cityName.equals("all")) {
            List<CityInfoVO> cityIntro = cityService.getCityInfoList(cityName, INTRO.name());
            List<CityInfoVO> foodList = cityService.getCityInfoList(cityName, FOOD.name());
            List<CityInfoVO> viewList = cityService.getCityInfoList(cityName, VIEW.name());

            model.addAttribute(CITY_FOOD_LIST.getText(), foodList);
            model.addAttribute(CITY_INTRO.getText(), cityIntro.get(0));
            model.addAttribute(CITY_VIEW_LIST.getText(), viewList);
        }

        List<CityInfoVO> cityIntroList = cityService.getCityInfoListByCategory(INTRO.name());
        model.addAttribute(CITY_NAME.getText(), cityName);
        model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
        return CITY_INFO.getPath();
    }
}
