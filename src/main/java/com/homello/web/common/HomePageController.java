package com.homello.web.common;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homePage")
public class HomePageController {

	
	/*
	 * 华美乐主页,列出所有模块
	 */
	@RequestMapping("/homePage")
	public String homePage(ModelMap modelMap) {
		
		// 功能待开发...
		
		return "homePage/homePage.page";
	}
	

}
