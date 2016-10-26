package com.homello.filter;

import static com.homello.common.CommonConstant.*;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.homello.domian.base.User;


public class ForumFilter implements Filter {

	//private Logger log = Logger.getLogger(ForumFilter.class);
	
	private static final String FILTERED_REQUEST = "@@session_context_filtered_request";
	
	
	// 不需要登录即可访问的URI资源
	private static final String[] INHERENT_ESCAPE_URIS = {"/index.jsp", "/login.jsp", "/login/doLogin.do"};
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// 保证该过滤器在一次请求中只被调用一次
		if (request != null && request.getAttribute(FILTERED_REQUEST) != null) {
			chain.doFilter(request, response);
		} else {

			// 设置过滤标识, 防止一次请求多次过滤
			request.setAttribute(FILTERED_REQUEST, Boolean.TRUE);
			HttpServletRequest httpRequest = (HttpServletRequest) request;
			User userContext = getSessionUser(httpRequest);
			
			// 用户未登录,且当前URL资源需要登录才能访问
			if (userContext == null && ! isURLLogin(httpRequest.getRequestURI(), httpRequest)) {
			
				String toURL = httpRequest.getRequestURI().toString();
				String contextPath = httpRequest.getContextPath();
				toURL = toURL.substring(contextPath.length());
	
				if (!StringUtils.isEmpty(httpRequest.getQueryString())) {
					toURL += "?" + httpRequest.getQueryString();
				}
				
				//将用户的请求URL保存在session中，用于登录成功之后，跳到目标URL
				httpRequest.getSession().setAttribute(LOGIN_TO_URL, toURL);
				
				//转发到登录页面
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				return;
			}
			
			chain.doFilter(request, response);
		}
	}

	protected User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(USER_CONTEXT);
	}
	
	// 当前URL资源是否需要登录才能访问
	private boolean isURLLogin(String requestURL, HttpServletRequest request) {
		if (request.getContextPath().equalsIgnoreCase(requestURL)
				||(request.getContextPath() + "/").equalsIgnoreCase(requestURL))
			return true;
		for (String url : INHERENT_ESCAPE_URIS) {
			if (requestURL != null && requestURL.indexOf(url) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

	@Override
	public void destroy() {
		
	}
}
