<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>top页面</title>
<style type="text/css">
.top_info {height: 70px;}
</style>
</head>
<body>
<div class="top_info">
	<p class="lead">
		<label class="ib">梦想家</label> <label class="ib pull-right">当前时间：<span id="time"></span></label>
	</p>
</div>
<div class="navbar navbar-static-top">
	<div class="navbar-inner">
		<a class="brand" href="javascript:void(0)">梦想家</a>
		<ul class="nav">
			<li class="active"><a href="javascript:reloadLeft('left_home')">首页</a></li>
			<li class="divider-vertical"></li>
			<li><a href="javascript:reloadLeft('left_course')">课程管理</a></li>
			<li class="divider-vertical"></li>
			<li><a href="javascript:reloadLeft('left_teacher')">教师管理</a></li>
			<li class="divider-vertical"></li>
			<li><a href="javascript:reloadLeft('left_student')">学生管理</a></li>
		</ul>
	</div>
</div>
</body>
</html>