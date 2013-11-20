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
<div class="top_info">
	<p class="lead">
		<label class="ib">万花</label>
		<label class="ib pull-right">当前时间：<span id="time"></span><br>
			<a href="javascript:logout()">【退出】 </a>
		</label>
	</p>
</div>
<div class="navbar navbar-static-top">
	<div class="navbar-inner">
		<a class="brand" href="javascript:void(0)">万花</a>
		<ul class="nav">
			<li class="active"><a href="javascript:reloadLeft('${contextPath }/page/main/left_home')">首页</a></li>
			<li class="divider-vertical"></li>
			<li><a href="javascript:reloadLeft('${contextPath }/page/main/left_personal')">个人中心</a></li>
			<li class="divider-vertical"></li>
			<li><a href="javascript:reloadLeft('${contextPath }/page/main/left_course')">课程管理</a></li>
			<li class="divider-vertical"></li>
			<li><a href="javascript:reloadLeft('${contextPath }/page/main/left_teacher')">教师管理</a></li>
			<li class="divider-vertical"></li>
			<li><a href="javascript:reloadLeft('${contextPath }/page/main/left_student')">学生管理</a></li>
			<li class="divider-vertical"></li>
			<li><a href="javascript:reloadLeft('${contextPath }/page/main/left_resource')">资源管理</a></li>
		</ul>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/date.handler.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/function.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var li = $(".nav li");
function logout(){
	$.post(contextPath + "/manage/logout",function(){
		parent.document.location.href=contextPath+"/manage";
	});
}
</script>
<script type="text/javascript" src="${contextPath }/main/js/top.js" ></script>
</html>