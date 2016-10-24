package com.homello.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.homello.domian.base.User;

@Repository
public interface UserIDao {
	
	/*
	 * find user by user name.
	 *
	 * @param String
	 * @return User
	 */
	public List<User> queryUserByName(String userName);
	
}
