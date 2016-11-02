package com.homello.dao.base;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.homello.domian.base.User;

@Repository
public interface UserIDao {
	
	/*
	 * find user by user name.
	 *
	 * @param String
	 * @return List<User>
	 */
	public List<User> queryUserByName(String userName);
	
	
	/*
	 * check login user
	 * 
	 * @param String
	 * @return User
	 */
	public User getUserByUserName(String userName);
	
}
