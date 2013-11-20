<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教师信息列表</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div id="page">
	<div class="well">
		<form action="${contextPath }/teacher/list" class="form-search" id="searchForm">
			<!-- <label>课程名称：</label><input type="text" name="cname" id="cname" class="input-medium search-query">
			<button type="submit" class="btn btn-primary">查 找</button> -->
		</form>
	</div>
	<div class="well">
		<div class="btn-group mb10">
			<button class="btn btn-primary" onclick="edit()">修 改</button>
			<button class="btn btn-primary" onclick="view()">查看</button>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th></th>
				 	<th>序号</th>
				 	<th>编号</th>
				 	<th>姓名</th>
				 	<th>性别</th>
				 	<th>学历</th>
				 	<th>手机号</th>
				 	<th>QQ号</th>
				 	<th>国籍</th>
				 </tr>
			</thead>
			<tbody>
				 <c:forEach items="${page.resultRows }" var="teacher" varStatus="st">
				 	<tr>
				 		<td><input type="checkbox" name="check" value="<c:out value="${teacher.uuid }"/>" /></td>
				 		<td>${st.index + 1 }</td>
				 		<td><c:out value="${teacher.cno }"/></td>
				 		<td><c:out value="${teacher.cname }"/></td>
				 		<td><c:out value="${teacher.csex }"/></td>
				 		<td><c:out value="${teacher.ceducation }"/></td>
				 		<td><c:out value="${teacher.cmobile }"/></td>
				 		<td><c:out value="${teacher.cqq }"/></td>
				 		<td><c:out value="${teacher.ccountry }"/></td>
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
<script type="text/javascript" src="${contextPath }/common/js/check.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var check;
$(function(){
	check = new InitCheck({lineSelected: false});
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/teacher.js" ></script>
</html>