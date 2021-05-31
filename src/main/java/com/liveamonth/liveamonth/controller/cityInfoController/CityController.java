package com.liveamonth.liveamonth.controller.cityInfoController;

import com.liveamonth.liveamonth.entity.vo.CityTransportVO;
import com.liveamonth.liveamonth.entity.vo.CityWeatherVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.CITY_INFO;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/cityInfo")
    public String cityInfo(Model model, @RequestParam("cityName") String cityName) throws Exception {
        if (!cityName.equals("all")) {
            model.addAttribute(SELECTED_CITY_INFOS.getText(), cityService.getSelectedCityList(cityName));
        }
        model.addAttribute("currentMonthTempList",cityService.getAVGTempList());
        model.addAttribute("cityTransportGradeList", cityService.getCityTransportGradeList());
        model.addAttribute(CITY_NAME.getText(), cityName);
        model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));
        return CITY_INFO.getPath();
    }

}
