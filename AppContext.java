package com.homello.core;

import java.util.Date;
import java.util.Map;

import com.homello.cache.Cache;
import com.homello.cache.impl.LocalCache;
import com.homello.cache.impl.MemCached;
import com.homello.util.Resources;

/**
 * @author vincent 2015-5-14
 * 
 */
public class AppContext {

	public final static int TIMEOUT = 30;

	private static ThreadLocal<Object> threadLocal = new ThreadLocal<Object>();

	private final static Cache cache;
	
	private final static AppContext instance = new AppContext();
	
	static{
		String flag = Resources.getProperty("cache.product", "local");
		if("local".equals(flag)){
			cache = new LocalCache();
		}else{
			cache = new MemCached(); 
		}
	}

	private AppContext() {}

	public static AppContext getInstance() {
		return instance;
	}

	public LoginInfo getLoginInfo(String key) {
		return cache.getLoginInfo(key);
	}

	public  void put(String key, LoginInfo info) {
		cache.put(key, info);
	}

	public void remove(String key) {
		cache.removeLogin(key);
	}

	// 更新时间
	public void updateExpireTime(String key) {
		cache.updateExpireTime(key);
	}
	
	public static Map<String, LoginInfo> getAllLoginInfo() {
		return cache.getAllLoginInfo();
	}

	public void cleanContext() {
		threadLocal.remove();
	}

	public void setContext(Object o) {
		threadLocal.set(o);
	}
	
	public LoginInfo getLoginInfo(){
		return (LoginInfo)threadLocal.get();
    }
	
	public static long getExpireTime() {
		long ms = AppContext.TIMEOUT * 60 * 1000;
		ms = ms + new Date().getTime();
		return ms;
	}
}
