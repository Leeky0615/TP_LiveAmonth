package com.liveamonth.liveamonth.controller.informationController;

import com.liveamonth.liveamonth.model.service.informationService.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InformationController{
    private final InformationService informationService;

    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping("/information")
    public String hello(Model model) {
        model.addAttribute("data", "CITY!!!");
        return "informationView/City";
    }
}
