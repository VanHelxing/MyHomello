package com.homello.web;

import static com.homello.common.CommonConstant.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.homello.domian.base.User;
import com.homello.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	//private Logger log = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserService userService;
	
	
	@RequestMapping("/doLogin")
	public ModelAndView login(HttpServletRequest request, User user){
		
		User dbUser = userService.getUserByUserName(user.getUserName());
		ModelAndView view = new ModelAndView();
		view.setViewName("forward:/login.jsp");
		if(dbUser == null) {
			view.addObject(ERROR_MSG_KEY, NAME_NOT_EXIST);
			
		} else if(!dbUser.getPassword().equals(user.getPassword())) {
			view.addObject(ERROR_MSG_KEY, ERROR_PASSWORD);
		} else {
			
			setSessionUser(request, dbUser);
			String toURL = (String) request.getSession().getAttribute(LOGIN_TO_URL);
			request.getSession().removeAttribute(LOGIN_TO_URL);
			
			//如果回话没有保存登陆之前的的请求URL,则直接跳转到主页
			if(StringUtils.isEmpty(toURL)) {
				toURL = "/homePage/homePage.do";
			}
			
			view.setViewName("redirect:" + toURL);
		}
		return view;
	}
}
