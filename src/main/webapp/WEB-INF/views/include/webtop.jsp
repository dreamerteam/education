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
<div class="navbar navbar-fixed-top" style="margin-bottom: 50px;">
	<div class="navbar-inner">
		<a class="brand" href="${contextPath }/web/index">万花</a>
		<ul class="nav">
			<li class="active"><a href="${contextPath }/web/index">首页</a></li>
			<li class="divider-vertical"></li>
			<li><a href="${contextPath }/web/course/list">课程信息</a></li>
			<li class="divider-vertical"></li>
			<li><a href="${contextPath }/web/teacher/list">教师信息</a></li>
			<li class="divider-vertical"></li>
			<li><a href="${contextPath }/web/resource/list">资料</a></li>
			<c:if test="${not empty sessionScope.SESSION_CONTAINER_KEY}">
				<li class="divider-vertical"></li>
				<li><a href="${contextPath }/page/web/student/index">个人中心</a></li>
			</c:if>
		</ul>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/function.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var li = $(".nav li");
</script>
<%-- <script type="text/javascript" src="${contextPath }/main/js/top.js" ></script> --%>
</html>