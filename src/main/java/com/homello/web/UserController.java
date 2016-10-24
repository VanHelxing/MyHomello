package com.homello.web;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.homello.domian.base.User;
import com.homello.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static Logger log = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("user")
	public String user() {
		return "user/listUser";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "queryUserByName")
	public String queryUserByName(@RequestParam("userName")String userName) {
		
		log.info("userName: " + userName);
		
		List<User> listUsers = userService.queryUserByName(userName);
		String Json = JSON.toJSONString(listUsers);
		
		return Json;
	}
}
