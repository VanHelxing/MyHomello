package com.homello.cache;

import java.util.Map;

import com.homello.core.LoginInfo;

public interface Cache {
	
	public final static String LOGIN_KEY = "LOGIN-";
	
	/**
	 * 获得登录信息
	 * @param key 键
	 * @return
	 */
	public LoginInfo getLoginInfo(String key);
	
	/**
	 * 将登录信息放入缓存中
	 * @param key 键
	 * @param info 登录信息
	 */
	public void put(String key, LoginInfo info);
	
	/**
	 * 更新登录超时时间
	 * @param key
	 */
	public void updateExpireTime(String key);
	
	/**
	 * 获得所有登录信息
	 * @return
	 */
	public Map<String, LoginInfo> getAllLoginInfo();
	
	/**
	 * 移除登录信息
	 * @param key
	 */
	public void removeLogin(String key);
}
