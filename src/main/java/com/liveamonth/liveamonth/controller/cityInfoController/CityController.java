package com.liveamonth.liveamonth.controller.cityInfoController;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.CITY_INFO;
import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.REDIRECT_CITY_INFO;
import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping(value="/cityInfo")
    public String cityInfo(Model model) throws Exception{
        // INTRO 카테고리에 있는 가져옴
        List<String> cityNameList = cityService.getCityNameList();
        // 카테고리가 'INTRO'인 CityInfo를 받아옴
        List<CityInfoVO> cityIntroList = cityService.getCityInfoListByCategory(INTRO.name());

        model.addAttribute(CITY_NAME_LIST.getText(), cityNameList);
        model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
        return CITY_INFO.getPath();
    }
    @GetMapping(value = "selectCityInfo")
    public String selectCityInfo(RedirectAttributes rttr, HttpServletRequest request) throws Exception{
        /*
         * request에서 클릭한 메뉴의 페이지 정보를 가져옴(getParameter())
         * 받아온 파라미터를 사용해 해당 도시의 정보를 보냄
         */
        this.setModel(rttr, request.getParameter(PAGE.getText()));
        return REDIRECT_CITY_INFO.getRedirectPath();
    }

    /*
    * Controller 내부에서 사용되는 Method
    */
    private void setModel(RedirectAttributes rttr, String cityName)  throws Exception{
        // cityName과 cityCategory를 파라미터로 받아서 리스트에 담음
        List<CityInfoVO> cityIntro = cityService.getCityInfoList(cityName,INTRO.name());
        List<CityInfoVO> foodList = cityService.getCityInfoList(cityName,FOOD.name());
        List<CityInfoVO> viewList = cityService.getCityInfoList(cityName,VIEW.name());

        rttr.addFlashAttribute(CITY_NAME.getText(), cityName);
        rttr.addFlashAttribute(INTRO.getText(), cityIntro.get(0));
        rttr.addFlashAttribute(FOOD.getText(), foodList);
        rttr.addFlashAttribute(VIEW.getText(), viewList);
    }
}
