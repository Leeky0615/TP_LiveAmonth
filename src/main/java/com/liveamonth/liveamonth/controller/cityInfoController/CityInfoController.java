package com.liveamonth.liveamonth.controller.cityInfoController;

import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.liveamonth.liveamonth.constants.ControllerPathConstants.ECityInfoPath.*;

@Controller
public class CityInfoController {
    private final CityInfoService informationService;

    public CityInfoController(CityInfoService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/cityInfo")
    public String hello(Model model) {
        return CITY_INFO.getPath();
    }
}
