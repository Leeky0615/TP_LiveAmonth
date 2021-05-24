package com.liveamonth.liveamonth.controller;

import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.CITY_INTRO_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.RANDOM_CITY_INTRO_LIST;

@Controller
public class MainController {
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/")
	public String main(Model model)  throws Exception{
		// MainCitySlide.jsp 사용
		model.addAttribute(RANDOM_CITY_INTRO_LIST.getText(), cityService.getRandomCityInfoListByCategory(INTRO.name()));
		// CityInfoGrid.jsp 사용
		model.addAttribute(CITY_INTRO_LIST.getText(), cityService.getCityInfoListByCategory(INTRO.name()));
		return "Main";
	}
}
