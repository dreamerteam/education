<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程管理菜单【左侧】</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="well">
	<div id="accordion">
		<p>课程类型管理</p>
		<div style="padding: 5px 3px; overflow: hidden;">
			<ul class="nav nav-list">
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/courseType/list')">列表</a></li>
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/page/main/courseType/add')">新增</a></li>
			</ul>
		</div>
		<p>课程管理</p>
		<div style="padding: 5px 3px; overflow: hidden;">
			<ul class="nav nav-list">
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/course/list')">课程列表</a></li>
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/course/lessionList')">开课列表</a></li>
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/course/list?caudit=0')">未审核</a></li>
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/course/list?caudit=10')">待审核</a></li>
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/course/list?caudit=20')">通过审核</a></li>
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/course/list?caudit=30')">未通过审核</a></li>
				<li class="pagination-centered"><a href="javascript:reloadMain('${contextPath}/page/main/course/add')">新增</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.core.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.widget.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.position.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.menu.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.accordion.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/function.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var li = $(".nav li");
$(function() {
	$( "#accordion" ).accordion({
		collapsible: true
	}); 
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/left.js" ></script>
</html>