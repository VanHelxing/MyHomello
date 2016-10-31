<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String context = request.getContextPath();
	request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>共用页头</title>
<style type="text/css">
	.head .logo {
		float: left;
		margin: 5px 200px;
		padding: 0;
	}
	
	.head .nav_items {
		float: right;
		margin: 5px 200px;
		padding: 0;
	}
	
	.head li {
		list-style: none;
		margin: 30px 10px;
		padding: 0 20px;
		float: left;
	}
	
	a {
		text-decoration: none;
		color: #454544;
		font-size: 16px;
		font-family: fantasy;
	}
	
	.header .head a:hover{
		color: #CC6600;
	}
	
	#user {
		position: absolute;
		top: 78px;
		color: #454544;
		font-size: 14px;
		right: 20px;
	}
	
	#user a {
		font-size: 14px;
		color: #454544;
	}
	
	#user a:hover {
		color: #CC6600;
	}
</style>
</head>
<body>
	<div class="header">
		<div class="head">
			<h1 class="logo">
				<a href="javascript:void(0)"><img src="${context}/img/logo.jpg"></a>
			</h1>
			<ul class="nav_items">
				<li>
					<a href="javascript:void(0)">首页</a>
				</li>
				<li>
					<a href="javascript:void(0)">功能</a>
				</li>
				<li>
					<a href="javascript:void(0)">日志</a>
				</li>
				<li>
					<a href="javascript:void(0)">论坛</a>
				</li>
			</ul>
		</div>
		<div id="user">
			${USER_CONTEXT.userName}
			<span style="font-size: 12px;">&nbsp;|&nbsp;</span>
			<span><a href="javascript:void(0)">注销</a></span>
		</div>
	</div>
</body>
</html>