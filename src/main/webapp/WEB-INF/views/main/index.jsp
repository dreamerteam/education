<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>梦想家</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/index.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body style="width: 1280px;overflow: hidden;">
<div class="topPage">
	<iframe name="topFrame" id="topFrame" src="${contextPath }/page/include/top" frameborder="0" width="100%" height="120px" scrolling="no"></iframe>
</div>
<div class="leftPage pull-left mt10">
	<iframe name="leftFrame" id="leftFrame" src="${contextPath }/page/main/left_home" frameborder="0" width="100%" scrolling="no"></iframe>
</div>
<div class="mainPage pull-left mt10">
	<iframe name="mainFrame" id="mainFrame" src="" frameborder="0" width="100%" scrolling="auto"></iframe>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/main/js/index.js" ></script>
</html>