<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>上课列表</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="container" style="height: 100%">
	<div class="well">
		<%-- <form action="${contextPath }/course/list" class="form-search" id="searchForm">
			<label>课程名称：</label><input type="text" name="cname" id="cname" class="input-medium search-query">
			<button type="submit" class="btn btn-primary">查 找</button>
		</form> --%>
	</div>
	<div class="well">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
				 	<th>序号</th>
				 	<th>名称</th>
				 	<th>开课起始时间</th>
				 	<th>开课结束时间</th>
				 	<th>类型</th>
				 	<th>热门度</th>
				 </tr>
			</thead>
			<tbody>
				 <c:forEach items="${page.resultRows }" var="lession" varStatus="st">
				 	<tr>
				 		<td>${st.index + 1 }</td>
				 		<td><c:out value="${lession.ccoursename }"/></td>
				 		<td><c:out value="${lession.cperiod }"/>&nbsp;&nbsp;<fmt:formatDate value="${lession.dbgnlession }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
				 		<td><fmt:formatDate value="${lession.dendlession }" pattern="yyyy-MM-dd" /></td>
				 		<td><c:out value="${lession.ctypename }"/></td>
				 		<td><c:out value="${lession.ihot }"/></td>
				 	</tr>
				 </c:forEach>
			</tbody>
		</table>
		<%@ include file="/WEB-INF/views/include/page.jsp" %>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
</script>
<script type="text/javascript" src="${contextPath }/web/js/course.js" ></script>
</html>