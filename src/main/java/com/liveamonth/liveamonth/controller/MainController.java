package com.liveamonth.liveamonth.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	@RequestMapping(value = "/")
	public String main(HttpServletRequest request) {
		return "Main";
	}
}
