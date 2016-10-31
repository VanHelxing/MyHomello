<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String context = request.getContextPath();
	request.setAttribute("context",context);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>共用页脚</title>
<style type="text/css">
	.foot {
		margin: 1px 0;
	}
	.foot .foot_box {
		color: #d9d9d9;
		float: left;
		margin: 0 40px;
	}
	.foot li {
		list-style: none;
		padding: 5px 0;
	}
	
	.foot .foot_box .title {
		font-size: 20px;
		font-weight: bold;
		padding: 10px 0;
	}
	
	a {
		text-decoration: none;
		color: #949494;
	}
	
	.footer .foot .foot_box a:hover {
		color: #CC6600;
	}
</style>
</head>
<body>
	<div class="footer">
		<div class="foot">
			<div class="foot_box">
				<ul>
					<li class="title">关于我们</li>
					<li><a href="javascript:void(0)">公司介绍</a></li>
					<li><a href="javascript:void(0)">联系我们</a></li>
					<li><a href="javascript:void(0)">招聘信息</a></li>
					<li><a href="javascript:void(0)">版权声明</a></li>
				</ul>
			</div>
			<div class="foot_box">
				<ul>
					<li class="title">帮助与支持</li>
					<li><a href="javascript:void(0)">帮助中心</a></li>
					<li><a href="javascript:void(0)">遇到问题</a></li>
				</ul>
			</div>
			<div class="foot_box">
				<ul>
					<li class="title">关注我们</li>
					<li><a href="javascript:void(0)">新浪微博</a></li>
					<li><a href="javascript:void(0)">微信公共号</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>