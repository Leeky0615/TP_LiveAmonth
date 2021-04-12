package com.liveamonth.liveamonth.controller.informationController;

import com.liveamonth.liveamonth.model.service.cityInfoService.CityInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformationController{
    private final CityInfoService informationService;

    public InformationController(CityInfoService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/information")
    public String hello(Model model) {
        return "informationView/City";
    }
}
