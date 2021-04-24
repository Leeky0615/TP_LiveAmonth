package com.liveamonth.liveamonth.controller.cityInfoController;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.*;

@Controller
public class CityInfoController {
    @Autowired
    private CityInfoService cityInfoService;

    @GetMapping("/cityInfo")
    public String cityInfo(Model model) throws Exception {
        /*
         컨트롤러     ->        서비스         ->        매퍼
               service.@@()              mapper.@@@()
         */
        List<CityInfoVO> cityInfoList = cityInfoService.getAllCityInfoList();
        System.out.println("리스트 개수: " + cityInfoList.size());

        model.addAttribute("cityInfoList", cityInfoList);
        return CITY_INFO.getPath();
    }

    @GetMapping("/seoulInfo")
    public String seoulInfo(Model model) throws Exception {
        List<CityInfoVO> seoulInfoList = cityInfoService.getCityInfoList("서울");
        CityInfoVO seoulInfo = new CityInfoVO();
        List<CityInfoVO> seoulFoodList = new ArrayList<>();
        List<CityInfoVO> seoulViewList = new ArrayList<>();
        for(CityInfoVO cityInfoVO : seoulInfoList){
            if(cityInfoVO.getCityCategory().equals("CITYINFO")) seoulInfo = cityInfoVO;
            else if(cityInfoVO.getCityCategory().equals("FOOD")) seoulFoodList.add(cityInfoVO);
            else if(cityInfoVO.getCityCategory().equals("VIEW")) seoulViewList.add(cityInfoVO);
        }

        System.out.println("리스트 개수: " + seoulInfo.getCityName());
        System.out.println("리스트 개수: " + seoulInfoList.size());
        System.out.println("리스트 개수: " + seoulViewList.size());

        model.addAttribute("seoulInfo", seoulInfo);
        model.addAttribute("seoulFoodList", seoulFoodList);
        model.addAttribute("seoulViewList", seoulViewList);
        return SEOUL_INFO.getPath();
    }
}
