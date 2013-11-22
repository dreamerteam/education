<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教师查看</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="container">
	<!-- 导航条 -->
	<jsp:include page="/WEB-INF/views/include/webtop.jsp"></jsp:include>
	<div class="thumbnails" style="margin-top: 50px">
		<div class="thumbnail">
			<h3 align="center"><c:out value="${teacher.cname }"/></h3>
			<%-- <p style="text-indent: 2em;"><c:out value="${teacher.cdescription}"/></p> --%>
			<p align="center"><a href="#"><img src="${contextPath }/common/images/logo.png" class="img-rounded h100"></a></p>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript">
$(".container").css("width",document.body.scrollWidth - 3 + "px");
</script>
</html>
