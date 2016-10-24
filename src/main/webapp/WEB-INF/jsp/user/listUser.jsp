<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%=basePath%>">
	<title>用户信息查询</title>
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/forum.css">
	<script type="text/javascript" src="<%=basePath%>/js/jquery-1.8.0.min.js"></script>
</head>
<body>
	<div>
		<input type="text" name="userName">
		<span>
			<button class="query">查询</button>
		</span>
	</div>
	<table class="forum">
		<tr>
			<th>序号</th>
			<th>用户编号</th>
			<th>登录口令</th>
			<th>年龄</th>
			<th>性别</th>
		</tr>
	</table>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$(":button").click(function() {
				
				var userName = $("input[name='userName']").val();
				$.ajax({
					url  : "<%=basePath%>/user/queryUserByName.do",
					type : "POST",
					data : {"userName":userName},
					success : function(data) {
						alert("data: " + data);
					},
					error : function(data) {
						alert("请求失败!")
					}
				});
			});
				
			
			
		});
	</script>
</body>
</html>