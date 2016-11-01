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
<title>首页</title>
<link rel="stylesheet" type="text/css" href="${context}/css/menu.css">
<script type="text/javascript" src="${context}/js/jquery.min.js"></script>
<script type="text/javascript" src="${context}/js/menu.js"></script>
</head>
<body>

<div class="forum" style="width: 100%;height: 800px;">
	<div class="menu">
		<h1>基本资料</h1>
		<div>
			<ul>
				<li>基本信息</li>
				<li>供应商资料</li>
				<li>商品资料</li>
				<li>客户管理</li>
				<li>促销活动</li>
			</ul>
		</div>
		
		<h1>营采管理</h1>
		<div>
			<ul>
				<li>商品采购</li>
				<li>商品调价</li>
				<li>商品促销</li>
				<li>采购调整</li>
			</ul>
		</div>
		
		<h1>销售管理</h1>
		<div>
			<ul>
				<li>商品销售</li>
				<li>家装卡管理</li>
				<li>销售计划</li>
				<li>委外加工</li>
				<li>分销管理</li>
			</ul>
		</div>
		
		<h1>装饰管理</h1>
		<div>
			<ul>
				<li>模板管理</li>
				<li>客户中心</li>
				<li>预算管理</li>
				<li>工程管理</li>
				<li>结算管理</li>
			</ul>
		</div>
		
		<h1>配送管理</h1>
		<div>
			<ul>
				<li>基础资料</li>
				<li>业务管理</li>
				<li>调拨作业</li>
			</ul>
		</div>
		
		<h1>库存管理</h1>
		<div>
			<ul>
				<li>盘点作业</li>
				<li>仓库作业</li>
				<li>库存数据</li>
			</ul>
		</div>
		
		<h1>财务管理</h1>
		<div>
			<ul>
				<li>应付帐单</li>
				<li>应收帐单</li>
				<li>财务凭证</li>
			</ul>
		</div>
		
		<h1>售后管理</h1>
		<div>
			<ul>
				<li>客诉管理</li>
				<li>安装管理</li>
				<li>测量管理</li>
				<li>派单管理</li>
				<li>厂送跟踪</li>
				<li>回访管理</li>
			</ul>
		</div>
		<h1>系统维护</h1>
		<div>
			<ul>
				<li>期末结算</li>
				<li>日志管理</li>
				<li>安全控制</li>
				<li>系统设置</li>
			</ul>
		</div>
		
		<h1>报表管理</h1>
		<div>
			<ul>
				<li>基本资料</li>
				<li>营采报表</li>
				<li>库存报表</li>
				<li>销售报表</li>
				<li>配送管理</li>
				<li>财务报表</li>
				<li>业绩报表</li>
				<li>数据分析</li>
				<li>装饰报表</li>
				<li>售后管理</li>
			</ul>
		</div>
	</div>

	<div class="forum_body">
		
	</div>

</div>
	

<script>
	$(document).ready(function(){
		$(".menu").menu();
		
		var forumName = "defaultForum";
		$(".forum_body").load("${context}/homePage/forum/" + forumName + ".do");
	
	});
</script>
	
</body>
</html>