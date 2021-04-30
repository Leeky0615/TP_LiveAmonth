package com.liveamonth.liveamonth.controller;

import javax.servlet.http.HttpServletRequest;

import com.liveamonth.liveamonth.entity.vo.CityInfoVO;
import com.liveamonth.liveamonth.model.service.cityInfoService.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.liveamonth.liveamonth.constants.EntityConstants.CityInfoCategory.INTRO;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.CITY_INTRO_LIST;
import static com.liveamonth.liveamonth.constants.LogicConstants.ECityInfoAttributes.CITY_NAME_LIST;

@Controller
public class MainController {
	@Autowired
	private CityService cityService;

	@RequestMapping(value = "/")
	public String main(Model model, HttpServletRequest request)  throws Exception{
		// INTRO 카테고리에 있는 가져옴
		List<String> cityNameList = cityService.getCityNameList();
		// 카테고리가 'INTRO'인 CityInfo를 받아옴
		List<CityInfoVO> cityIntroList = cityService.getCityInfoListByCategory(INTRO.name());

		model.addAttribute(CITY_NAME_LIST.getText(), cityNameList);
		model.addAttribute(CITY_INTRO_LIST.getText(), cityIntroList);
		return "Main";
	}

}
