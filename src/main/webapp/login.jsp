<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String context = request.getContextPath();
	request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
	
	<link rel="stylesheet" type="text/css" href="${context}/css/register-login.css">

</head>
<body>
<div id="box"></div>
<div class="cent-box">
	<div class="cent-box-header">
		<h1 class="main-title">Homello</h1>
		<h2 class="sub-title">&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;欢迎来到华美乐ERP系统</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="${context}/login.jsp" class="active">登录</a>
				<a href="${context}/register.jsp">注册</a>
				<div class="slide-bar"></div>				
			</div>
		</div>

		<div class="login form">
			<form action="${context}/login/doLogin.do" method="post">
				<div class="group">
					<div class="group-ipt user">
						<input type="text" name="userName" id="user" class="ipt" placeholder="您的用户姓名" required>
						<c:if test="${not empty errorMsg && errorMsg == '0'}">
							<label class="errorUserName is-visible">用户名不存在</label>
						</c:if>
					</div>
					<div class="group-ipt password">
						<input type="password" name="password" id="password" class="ipt" placeholder="输入您的登录密码" required>
						<c:if test="${not empty errorMsg && errorMsg == '1'}">
							<label class="errorPassword is-visible">密码错误</label>
						</c:if>
					</div>
					<div class="group-ipt verify">
						<input type="text" name="verify" id="verify" class="ipt" placeholder="输入验证码" required>
						<img src="http://zrong.me/home/index/imgcode?id=" class="imgcode">
					</div>
				</div>
			</form>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">登录</button>
		</div>

		<div class="remember clearfix">
			<label class="remember-me"><span class="icon"><span class="zt"></span></span><input type="checkbox" name="remember-me" id="remember-me" class="remember-mecheck" checked>记住我</label>
			<label class="forgot-password">
				<a href="#">忘记密码？</a>
			</label>
		</div>
	</div>
</div>

<div class="footer">
	<p>范海辛 - Van Helsing</p>
	<p>Power By VanHelsing &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  2016-10-29</p>
</div>

<script src='${context}/js/particles.js' type="text/javascript"></script>
<script src='${context}/js/background.js' type="text/javascript"></script>
<script src='${context}/js/jquery.min.js' type="text/javascript"></script>
<script src='${context}/js/layer/layer.js' type="text/javascript"></script>
<script>
	$(".login-btn").click(function() {
		$("form").submit();
	});
	
	$("#user").focus(function(){
	   	$(".errorUserName").html("");
	});
	
	$("#password").focus(function(){
	   	$(".errorPassword").html("");
	});
	
	$("#verify").focus(function(){
	
	});



	$('.imgcode').hover(function(){
		layer.tips("看不清？点击更换", '.verify', {
        		time: 6000,
        		tips: [2, "#3c3c3c"]
    		})
	},function(){
		layer.closeAll('tips');
	}).click(function(){
		$(this).attr('src','http://zrong.me/home/index/imgcode?id=' + Math.random());
	});
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	});
</script>
</body>
</html>