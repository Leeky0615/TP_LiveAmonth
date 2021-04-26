package com.liveamonth.liveamonth.controller.cityInfoController;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.*;
import static com.liveamonth.liveamonth.constants.EntityConstants.ECityCategory.*;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.*;

@Controller
public class CityInfoController {
    @Autowired
    private CityInfoService cityInfoService;

    @GetMapping(value="/cityInfo")
    public String cityInfo(Model model){
        // 카테고리가 'INTRO'인 CityInfo를 받아옴
        List<CityInfoVO> cityIntroList = cityInfoService.getCityInfoListByCategory(CATEGORY_INTRO.getCategoryUppercase());
        // INTRO 카테고리에 있는 CityInfoName컬럼만 가져옴
        List<String> cityNameList = cityInfoService.getCityInfoNameList();

        model.addAttribute(CITY_NAME_LIST.getText(), cityNameList);
        model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
        return CITY_INFO.getPath();
    }
    @GetMapping(value = "selectCityInfo")
    public String selectCityInfo(RedirectAttributes rttr, HttpServletRequest request){
        /*
         * request에서 클릭한 메뉴의 페이지 정보를 가져옴(getParameter())
         * 받아온 파라미터를 사용해 해당 도시의 정보를 보냄.
         */
        this.setModel(rttr, request.getParameter("page"));
        return REDIRECT_CITY_INFO.getRedirectPath();
    }

    /*
    * Controller 내부에서 사용되는 Method
    */
    private void setModel(RedirectAttributes rttr, String cityName){
        // cityName과 cityCategory를 파라미터로 받아서 리스트에 담음
        List<CityInfoVO> cityIntro = cityInfoService.getCityInfoList(cityName,CATEGORY_INTRO.getCategoryUppercase());
        List<CityInfoVO> foodList = cityInfoService.getCityInfoList(cityName,CATEGORY_FOOD.getCategoryUppercase());
        List<CityInfoVO> viewList = cityInfoService.getCityInfoList(cityName,CATEGORY_VIEW.getCategoryUppercase());

        rttr.addFlashAttribute(CITY_NAME.getText(), cityName);
        rttr.addFlashAttribute(CATEGORY_INTRO.getCategoryLowerCase(), cityIntro.get(0));
        rttr.addFlashAttribute(CATEGORY_FOOD.getCategoryLowerCase(), foodList);
        rttr.addFlashAttribute(CATEGORY_VIEW.getCategoryLowerCase(), viewList);
    }
}
