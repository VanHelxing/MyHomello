package com.homello.web.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import com.homello.common.CommonConstant;
import com.homello.domian.base.User;

public class BaseController {
	
	protected static final String ERROR_MSG_KEY = "errorMsg";
	protected static final String NAME_NOT_EXIST = "0";
	protected static final String ERROR_PASSWORD = "1";
	protected static final String NAME_LOCKED = "2";
	
	
	/*
	 * 获取保存在Session中的对象
	 */
	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(CommonConstant.USER_CONTEXT);
	}
	
	/*
	 * 将用户对象保存在Session中
	 */
	protected void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}
	
	/*
	 * 获取基于应用程序的url绝对路径
	 */
	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "必须以/开头");
		return request.getContextPath() + url;
	}
}
