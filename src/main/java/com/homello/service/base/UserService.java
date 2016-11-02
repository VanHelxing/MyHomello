package com.homello.service.base;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.homello.dao.base.UserIDao;
import com.homello.domian.base.User;

@Service
public class UserService {

	@Resource
	private UserIDao userDao;
	
	
	public List<User> queryUserByName(String userName){
		
		List<User> listUsers = userDao.queryUserByName(userName);
		return listUsers;
	}
	
	
	public User getUserByUserName(String userName) {
		
		User user = userDao.getUserByUserName(userName);
		return user;
	}
}
