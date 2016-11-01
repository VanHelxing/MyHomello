<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>华美乐首页</title>
	
	<style type="text/css">
		* {
			margin: 0;
			padding: 0;
		}
		#common_head {
			width: 100%;
			height: 100px;
			background-color: #F0F8FF;
			display: block;
		}
		#common_body {
			width: 100%;
			height: 800px;
			background-color: #99CCFF;
			display: block;
		}
		#common_foot {
			width: 100%;
			height: 200px;
			background-color: #303030;
			display: block;
		}
	</style>
</head>
<body>
	
	<div id="common_head"><tiles:insertAttribute name="common_head"/></div>
	<div id="common_body"><tiles:insertAttribute name="common_body"/></div>
	<div id="common_foot"><tiles:insertAttribute name="common_foot"/></div>
	
</body>
</html>