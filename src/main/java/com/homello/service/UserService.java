package com.homello.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.homello.dao.UserIDao;
import com.homello.domian.base.User;

@Service
public class UserService {

	@Resource
	private UserIDao userDao;
	
	
	public List<User> queryUserByName(String userName){
		
		List<User> listUsers = userDao.queryUserByName(userName);
		return listUsers;
	}
}
