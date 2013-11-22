<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>top页面</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/top.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="container">
	<div class="top_info">
		<p class="lead">
			<label class="ib">万花</label>
			<label class="ib pull-right">当前时间：<span id="time"></span>
				<a href="${contextPath }/logout"> 【退出】 </a>
			</label>
		</p>
	</div>
	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="${contextPath }/web/index">万花</a>
			<ul class="nav">
				<li class="active dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">个人中心<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a href="javascript:reloadMain('${contextPath }/web/student/personal/view')">查看个人信息</a></li>
						<li><a href="javascript:reloadMain('${contextPath }/web/student/personal/perfect')">完善个人信息</a></li>
					</ul>
				</li>
				<li class="divider-vertical"></li>
				<li class="dropdown">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">课程<strong class="caret"></strong></a>
					<ul class="dropdown-menu">
						<li><a href="javascript:reloadMain('${contextPath }/web/student/course/favoriteList')">课程收藏</a></li>
						<li><a href="javascript:reloadMain('${contextPath }/web/student/course/lessionList')">上课列表</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/date.handler.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/function.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var li = $(".nav li");
</script>
<script type="text/javascript" src="${contextPath }/web/js/top.js" ></script>
</html>