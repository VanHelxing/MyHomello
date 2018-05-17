package com.homello.cache.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jxl.common.Logger;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.homello.cache.Cache;
import com.homello.core.LoginInfo;
import com.homello.util.Resources;

public class MemCached implements Cache {
	private static Logger logger = Logger.getLogger(MemCached.class);
	
	private static MemCachedClient cachedClient = new MemCachedClient(); // memcached客户端单例	
	/**
	 * 初始化连接池
	 */
	static {
		logger.info("初始化连接池");
		// 获取连接池的实例
		SockIOPool pool = SockIOPool.getInstance();
		// 设置服务器信息
		pool.setServers(getServers());
		// 服务器列表及其权重
		pool.setWeights(getWeights());
		// 设置初始连接数、最小连接数、最大连接数、最大处理时间
		pool.setInitConn(new Integer(Resources.getProperty("cache.initConn", "10")));
		pool.setMinConn(new Integer(Resources.getProperty("cache.minConn", "10")));
		pool.setMaxConn(new Integer(Resources.getProperty("cache.maxConn", "1000")));
		// pool.setMaxIdle(1000 * 60 * 60);
		pool.setMaxIdle(new Integer(Resources.getProperty("cache.maxIdle", "3600000")));
		// 设置主线程睡眠时间，每3秒苏醒一次，维持连接池大小
		// maintSleep 千万不要设置成30，访问量一大就出问题，单位是毫秒，推荐30000毫秒。
		pool.setMaintSleep(new Integer(Resources.getProperty("cache.maintSleep", "30000")));
		// 关闭套接字缓存
		pool.setNagle(new Boolean(Resources.getProperty("cache.nagle", "false")));
		// 连接建立后的超时时间
		pool.setSocketTO(new Integer(Resources.getProperty("cache.socketTO", "3000")));
		// 连接建立时的超时时间
		pool.setSocketConnectTO(new Integer(Resources.getProperty("cache.socketConnectTO", "0")));
		// 初始化并启动连接池
		pool.initialize();
		// 压缩设置，超过指定大小的都压缩
		/*String compressEnable = pro.getProperty("cache.compressEnable");
		if(compressEnable != null && !"".equals(compressEnable)){
			cachedClient.setCompressEnable(new Boolean(compressEnable));
		}
		String compressThreshold = pro.getProperty("cache.compressThreshold", "1048576");
		if(compressThreshold != null && !"".equals(compressThreshold)){
			cachedClient.setCompressThreshold(new Integer(compressThreshold));
		}//*/
	}
	
	private static String[] getServers(){
		return Resources.getProperty("cache.servers", "192.168.0.16:11211").split(",");
	}
	
	private static Integer[] getWeights(){
		Integer[] weights;
		String[] arr = Resources.getProperty("cache.weights", "3").split(",");
		weights = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++){
			weights[i] = new Integer(arr[i]);
		}
		return weights;
	}
	
	/**
	 * 获得所有登录信息
	 */
	public Map<String, LoginInfo> getAllLoginInfo() {
		Map<String, LoginInfo> map = new HashMap<String, LoginInfo>();
		List<String> list = getLoginKey();
		for(String key : list){
			LoginInfo info = (LoginInfo)cachedClient.get(key);
			if(info != null) map.put(info.getSessionId(),  info);
		}
		return map;
	}

	/**
	 * 获得登录信息
	 */
	public LoginInfo getLoginInfo(String key) {
		return (LoginInfo)cachedClient.get(Cache.LOGIN_KEY+key);
	}

	/**
	 * 放入登录信息
	 */
	public void put(String key, LoginInfo info) {
		long ms = getExpireTime();
		info.setExpireTime(new Date().getTime()+ms);
		cachedClient.set(Cache.LOGIN_KEY+key, info, new Date(ms));
	}

	/**
	 * 更新超时时间
	 */
	public void updateExpireTime(String key) {
		LoginInfo info = getLoginInfo(key);
		long ms = getExpireTime();
		info.setExpireTime(new Date().getTime()+ms);
		cachedClient.replace(Cache.LOGIN_KEY+key, info, new Date(ms));
	}

	/**
	 * 移除登录信息
	 */
	public void removeLogin(String key) {
		cachedClient.delete(Cache.LOGIN_KEY+key);
	}
	
	public boolean add(String key, Object value) {
		return cachedClient.add(key, value);
	}

	public boolean add(String key, Object value, Integer expire) {
		return cachedClient.add(key, value, expire);
	}

	public boolean add(String key, Object value, Date expireDate) {
		return cachedClient.add(key, value, expireDate);
	}

	public boolean flushAll() {
		return cachedClient.flushAll();
	}

	public Object get(String key) {
		return cachedClient.get(key);
	}

	public boolean replace(String key, Object value) {
		return cachedClient.replace(key, value);
	}

	public boolean replace(String key, Object value, Integer expire) {
		return cachedClient.replace(key, value, expire);
	}

	public boolean replace(String key, Object value, Date expireDate) {
		return cachedClient.replace(key, value, expireDate);
	}

	public boolean set(String key, Object value) {
		return cachedClient.set(key, value);
	}

	public boolean set(String key, Object value, Integer expire) {
		return cachedClient.set(key, value, expire);
	}

	public boolean set(String key, Object value, Date expireDate) {
		return cachedClient.set(key, value, expireDate);
	}

	public List<String> getLoginKey(){
		List<String> keyList = new ArrayList<String>();
		Map<String, Map<String, String>> map = cachedClient.statsItems();
		for(Map.Entry<String, Map<String, String>> entry : map.entrySet()){
			Map<String, String> m = entry.getValue();
			for(Map.Entry<String, String> innerEntry : m.entrySet()){
				String key = innerEntry.getKey();
				String value = innerEntry.getValue();
				if(key.endsWith("number")){
					String[] arr = key.split(":");
					int slabNumber = Integer.valueOf(arr[1].trim());
					int limit = Integer.valueOf(value.trim());
					Map<String, Map<String, String>> dump = cachedClient.statsCacheDump(slabNumber, limit);
					for(Iterator<String> dumpIt = dump.keySet().iterator(); dumpIt.hasNext();){
						String dumpKey = dumpIt.next();
						Map<String, String> allMap = dump.get(dumpKey);
						for(Iterator<String> allIt = allMap.keySet().iterator(); allIt.hasNext();){
							String allKey = allIt.next();
							if(allKey.startsWith("LOGIN-"))
								keyList.add(allKey);
						}
					}
					
				}
			}
		}
		
		return keyList;
	}
	
	public long getExpireTime() {
		long ms = 30 * 60 * 1000;
//		ms = ms + new Date().getTime();
		return ms;
	}
}
