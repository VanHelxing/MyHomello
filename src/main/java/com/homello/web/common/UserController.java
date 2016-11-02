package com.homello.web.common;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.homello.domian.base.User;
import com.homello.service.base.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	
	//private static Logger log = Logger.getLogger(UserController.class);
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("user")
	public String user() {
		return "user/listUser";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "queryUserByName", method = RequestMethod.POST)
	public Object queryUserByName(@RequestParam("userName")String userName) {
		
		List<User> listUsers = userService.queryUserByName(userName);
		String stringJson = JSON.toJSONString(listUsers);
		
		return stringJson;
	}
}
