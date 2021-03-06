<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教师列表</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="container">
	<!-- 导航条 -->
	<jsp:include page="/WEB-INF/views/include/webtop.jsp"></jsp:include>
	<div class="well" style="margin-top: 50px">
		<%-- <form action="${contextPath }/course/list" class="form-search" id="searchForm">
			<label>课程名称：</label><input type="text" name="cname" id="cname" class="input-medium search-query">
			<button type="submit" class="btn btn-primary">查 找</button>
		</form> --%>
	</div>
	<div class="well">
		<div class="navbar">
			<div class="navbar-inner">
				<p class="brand">教师信息</p>
			</div>
			<ul class="thumbnails">
				<c:forEach items="${page.resultRows }" var="teacher">
					<li class="span3">
						<div class="thumbnail">
							<p align="center"><a href="#"><img src="${contextPath }/common/images/logo.png" class="img-rounded h100"></a></p>
							<p align="center"><c:out value="${teacher.cname }"/></p>
							<p class="ti2"><%-- <c:out value="${e:cut(teacher.cdescription, 20) }"/> --%></p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<%@ include file="/WEB-INF/views/include/page.jsp" %>
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