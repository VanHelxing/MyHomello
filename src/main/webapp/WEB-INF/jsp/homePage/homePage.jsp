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
<link rel="stylesheet" type="text/css" href="${context}/css/forum.css">
<script type="text/javascript" src="${context}/js/jquery.min.js"></script>
<script type="text/javascript" src="${context}/js/google-maps.js"></script>
<script>$(document).ready(function(){$(".vertical-nav").verticalnav({speed: 400,align: "left"});});</script>
</head>
<body>
<div class="menu">
	<div class="kePublic">
		<!--效果html开始-->
		<div class="content">
			<ul class="vertical-nav dark red">
				<li class="active"><a href="javascript:void(0)">首页</a></li>
				<li><a href="javascript:void(0)">基本资料
					<span class="submenu-icon"></span></a>
					<ul>
						<li><a href="javascript:void(0)">基本信息
							<span class="submenu-icon"></span></a>
							<ul>
								<li><a href="javascript:void(0)">机构资料</a></li>
								<li><a href="javascript:void(0)">部分资料</a></li>
								<li><a href="javascript:void(0)">仓库资料 </a></li>
								<li><a href="javascript:void(0)">仓库库位资料</a></li>
								<li><a href="javascript:void(0)">员工资料</a></li>
								<li><a href="javascript:void(0)">商铺资料</a></li>
								<li><a href="javascript:void(0)">品牌资料</a></li>
								<li><a href="javascript:void(0)">机构品牌信息</a></li>
								<li><a href="javascript:void(0)">品牌考核信息维护</a></li>
							</ul>	
						</li>
						<li><a href="javascript:void(0)">供应商信息
							<span class="submenu-icon"></span></a>
							<ul>
								<li><a href="javascript:void(0)">三级导航</a></li>
								<li><a href="javascript:void(0)">三级导航</a></li>
								<li><a href="javascript:void(0)">三级导航 </a></li>
								<li><a href="javascript:void(0)">三级导航</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">商品资料
							<span class="submenu-icon"></span></a>
							<ul>
								<li><a href="javascript:void(0)">三级导航</a></li>
								<li><a href="javascript:void(0)">三级导航</a></li>
								<li><a href="javascript:void(0)">三级导航 </a></li>
								<li><a href="javascript:void(0)">三级导航</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">客户管理
							<span class="submenu-icon"></span></a>
							<ul>
								<li><a href="javascript:void(0)">三级导航</a></li>
								<li><a href="javascript:void(0)">三级导航</a></li>
								<li><a href="javascript:void(0)">三级导航 </a></li>
								<li><a href="javascript:void(0)">三级导航</a></li>
							</ul>
						</li>
						<li><a href="javascript:void(0)">促销活动
							<span class="submenu-icon"></span></a>
							<ul>
								<li><a href="javascript:void(0)">三级导航</a></li>
								<li><a href="javascript:void(0)">三级导航</a></li>
								<li><a href="javascript:void(0)">三级导航 </a></li>
								<li><a href="javascript:void(0)">三级导航</a></li>
							</ul>
						</li>
					</ul>
				</li>
				<li><a href="javascript:void(0)">营采管理
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">商品采购</a></li>
							<li><a href="javascript:void(0)">商品调价</a></li>
							<li><a href="javascript:void(0)">商品促销</a></li>
							<li><a href="javascript:void(0)">采购调整</a></li>
						</ul>
				</li>
				<li><a href="javascript:void(0)">销售管理
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">商品销售</a></li>
							<li><a href="javascript:void(0)">家装卡管理</a></li>
							<li><a href="javascript:void(0)">销售计划</a></li>
							<li><a href="javascript:void(0)">委外加工</a></li>
							<li><a href="javascript:void(0)">分销管理</a></li>
						</ul>
					</li>
				<li><a href="javascript:void(0)">装饰管理
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">模板管理</a></li>
							<li><a href="javascript:void(0)">客户中心</a></li>
							<li><a href="javascript:void(0)">预算管理</a></li>
							<li><a href="javascript:void(0)">工程管理</a></li>
							<li><a href="javascript:void(0)">结算管理</a></li>
						</ul>
					</li>
				<li><a href="javascript:void(0)">配送管理
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">基础资料</a></li>
							<li><a href="javascript:void(0)">业务管理</a></li>
							<li><a href="javascript:void(0)">调拨作业</a></li>
						</ul>
					</li>
				<li><a href="javascript:void(0)">库存管理
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">盘点作业</a></li>
							<li><a href="javascript:void(0)">仓库作业</a></li>
							<li><a href="javascript:void(0)">库存数据</a></li>
						</ul>
					</li>
				<li><a href="javascript:void(0)">财务管理
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">应付帐单</a></li>
							<li><a href="javascript:void(0)">应收帐单</a></li>
							<li><a href="javascript:void(0)">财务凭证</a></li>
						</ul>
					</li>
				<li><a href="javascript:void(0)">售后管理
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">客诉管理</a></li>
							<li><a href="javascript:void(0)">安装管理</a></li>
							<li><a href="javascript:void(0)">测量管理</a></li>
							<li><a href="javascript:void(0)">派单管理</a></li>
							<li><a href="javascript:void(0)">厂送跟踪</a></li>
							<li><a href="javascript:void(0)">回访管理</a></li>
						</ul>
					</li>
				<li><a href="javascript:void(0)">系统维护
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">期末结算</a></li>
							<li><a href="javascript:void(0)">日志管理</a></li>
							<li><a href="javascript:void(0)">安全控制</a></li>
							<li><a href="javascript:void(0)">系统设置</a></li>
						</ul>
					</li>
				<li><a href="javascript:void(0)">报表管理
					<span class="submenu-icon"></span></a>
						<ul>
							<li><a href="javascript:void(0)">基本资料</a></li>
							<li><a href="javascript:void(0)">营采报表</a></li>
							<li><a href="javascript:void(0)">库存报表</a></li>
							<li><a href="javascript:void(0)">销售报表</a></li>
							<li><a href="javascript:void(0)">配送管理</a></li>
							<li><a href="javascript:void(0)">销售报表</a></li>
							<li><a href="javascript:void(0)">财务报表</a></li>
							<li><a href="javascript:void(0)">业绩报表</a></li>
							<li><a href="javascript:void(0)">数据分析</a></li>
							<li><a href="javascript:void(0)">售后管理</a></li>
						</ul>
					</li>
				<li><a href="javascript:void(0)">联系我们</a></li>
			</ul>
		</div>
		<!--效果html结束-->
		<div class="clear"></div>
	</div>
</div>

<div class="forum_body">
	<iframe src="" name="iframe_forum"></iframe>
</div>

<script>
	$(document).ready(function(){
		
		//var forumName = "defaultForum";
		//$(".forum_body").load("${context}/homePage/forum/" + forumName + ".do");
		
		
	
	});
</script>
</body>
</html>