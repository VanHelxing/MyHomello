package com.homello.cache.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.homello.cache.Cache;
import com.homello.core.AppContext;
import com.homello.core.LoginInfo;
import com.homello.core.SpringContext;
import com.homello.po.sys.User;
import com.homello.service.sys.UserService;

public class LocalCache implements Cache {
	private final static Logger logger = Logger.getLogger(LocalCache.class);
	private final static Map<String, LoginInfo> properties = new HashMap<String, LoginInfo>();

	public LocalCache(){
//		Thread th = new Thread(new Work());
//		th.start();
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			public void run() {
				removeSession();
			}
		}, 100, 1*60*1000);
		logger.info("start app context thread");
	}
	
	
	public Map<String, LoginInfo> getAllLoginInfo() {
		return properties;
	}

	public LoginInfo getLoginInfo(String key) {
		return properties.get(key);
	}

	public void put(String key, LoginInfo info) {
		properties.put(key, info);
		updateExpireTime(key);
	}

	public void updateExpireTime(String key) {
		LoginInfo info = properties.get(key);
		info.setExpireTime(AppContext.getExpireTime());
	}
	
	public void removeLogin(String key) {
		properties.remove(key);
	}
	
	/*private class Work implements Runnable {
			int timeout = 1;
		
			public void run() {
				while (true) {
					try {
						removeSession();
						Thread.sleep(timeout * 60 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}//*/
	
	private void removeSession() {
//		logger.info("==========>remove session doing<===========");
		Iterator<Entry<String, LoginInfo>> ite = properties
				.entrySet().iterator();
		while (ite.hasNext()) {
			Entry<String, LoginInfo> entry = ite.next();
			LoginInfo info = entry.getValue();
			if (info.isExpire()) {
				UserService userService = (UserService)SpringContext.getBean("userService");
				User user = userService.getUserBySuId(info.getUid());
				ite.remove();
				if(user != null){
					user.setOnline("0");
					user.setStopDate(new Date());
					userService.update(user);
				}
				logger.info("==========>remove session<===========");
			}
		}
	}
	
}
