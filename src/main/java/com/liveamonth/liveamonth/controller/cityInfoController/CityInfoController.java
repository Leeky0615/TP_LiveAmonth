package com.liveamonth.liveamonth.controller.cityInfoController;

import com.liveamonth.liveamonth.constants.ControllerPathConstants;
import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.entity.vo.ScheduleVO;
import com.liveamonth.liveamonth.entity.vo.UserVO;
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
    public String cityInfo(Model model) throws Exception{
       List<CityInfoVO> cityInfoList = cityInfoService.getCityInfoList();
       System.out.println("리스트 개수: "+cityInfoList.size());

       model.addAttribute("cityInfoList", cityInfoList);

       return CITY_INFO.getPath();
   }

}
