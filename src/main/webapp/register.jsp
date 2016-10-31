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
<title>注册页面</title>

	<link rel="stylesheet" type="text/css" href="${context}/css/register-login.css">
	
</head>
<body>
<div id="box"></div>
<div class="cent-box register-box">
	<div class="cent-box-header">
		<h1 class="main-title">Homello</h1>
		<h2 class="sub-title">&nbsp;&nbsp;&nbsp; - &nbsp;&nbsp;欢迎来到华美乐ERP系统</h2>
	</div>

	<div class="cont-main clearfix">
		<div class="index-tab">
			<div class="index-slide-nav">
				<a href="${context}/login.jsp">登录</a>
				<a href="${context}/register.jsp" class="active">注册</a>
				<div class="slide-bar slide-bar1"></div>			
			</div>
		</div>

		<div class="login form">
			<div class="group">
				<div class="group-ipt email">
					<input type="email" name="email" id="email" class="ipt" placeholder="邮箱地址" required>
				</div>
				<div class="group-ipt user">
					<input type="text" name="user" id="user" class="ipt" placeholder="选择一个用户名" required>
				</div>
				<div class="group-ipt password">
					<input type="password" name="password" id="password" class="ipt" placeholder="设置登录密码" required>
				</div>
				<div class="group-ipt password1">
					<input type="password" name="password1" id="password1" class="ipt" placeholder="重复密码" required>
				</div>
				<div class="group-ipt verify">
					<input type="text" name="verify" id="verify" class="ipt" placeholder="输入验证码" required>
					<img src="http://zrong.me/home/index/imgcode?id=" class="imgcode">
				</div>
			</div>
		</div>

		<div class="button">
			<button type="submit" class="login-btn register-btn" id="button">注册</button>
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
	$('.imgcode').hover(function(){
		layer.tips("看不清？点击更换", '.verify', {
        		time: 6000,
        		tips: [2, "#3c3c3c"]
    		})
	},function(){
		layer.closeAll('tips');
	}).click(function(){
		$(this).attr('src','http://zrong.me/home/index/imgcode?id=' + Math.random());
	})

	$(".login-btn").click(function(){
		var email = $("#email").val();
		var password = $("#password").val();
		var verify = $("#verify").val();
		// $.ajax({
		// url: 'http://www.zrong.me/home/index/userLogin',
		// type: 'post',
		// jsonp: 'jsonpcallback',
  //       jsonpCallback: "flightHandler",
		// async: false,
		// data: {
		// 	'email':email,
		// 	'password':password,
		// 	'verify':verify
		// },
		// success: function(data){
		// 	info = data.status;
		// 	layer.msg(info);
		// }
		// })

	})
	$("#remember-me").click(function(){
		var n = document.getElementById("remember-me").checked;
		if(n){
			$(".zt").show();
		}else{
			$(".zt").hide();
		}
	})
</script>
</body>
</html>