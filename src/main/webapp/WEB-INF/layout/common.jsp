<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>共用主页面</title>
	
	<style type="text/css">
		#common_head {
			width: 100%;
			height: 400px;
			background-color: #CCCCFF;
			display: block;
		}
		#common_body {
			width: 100%;
			height: auto;
			background-color: #99CCFF;
			display: block;
		}
		#common_foot {
			width: 100%;
			height: 400px;
			background-color: #CCCCFF;
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