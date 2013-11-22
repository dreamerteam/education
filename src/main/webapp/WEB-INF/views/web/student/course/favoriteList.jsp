<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程收藏列表</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="container" style="height: 100%">
	<div class="well">
		<%-- <form action="${contextPath }/manage/course/list" class="form-search" id="searchForm">
			<input type="hidden" name="caudit" id="caudit" value="${param.caudit }" />
			<label>课程名称：</label><input type="text" name="cname" id="cname" class="input-medium search-query" value="${param.cname }">
			<button type="submit" class="btn btn-primary">查 找</button>
		</form> --%>
	</div>
	<div class="well">
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
				 	<th>序号</th>
				 	<th>名称</th>
				 	<th>类型</th>
				 	<th>热门度</th>
				 	<th>上课</th>
				 </tr>
			</thead>
			<tbody>
				 <c:forEach items="${page.resultRows }" var="course" varStatus="st">
				 	<tr>
				 		<td>${st.index + 1 }</td>
				 		<td><c:out value="${course.cname }"/></td>
				 		<td><c:out value="${course.ctypename }"/></td>
				 		<td><c:out value="${course.ihot }"/></td>
				 		<td>
				 			<c:choose>
				 				<c:when test="${'1' eq course.copen }">
				 					<c:choose>
				 						<c:when test="${empty course.ulessionid }">
									 		<button type="button" class="btn btn-primary" onclick="select('${course.uuid }')" >上 课</button>
				 						</c:when>
				 						<c:otherwise>
									 		<span class="label label-info">已选</span>
				 						</c:otherwise>
				 					</c:choose>
				 				</c:when>
				 				<c:otherwise>
							 		<span class="label label-reverse">未开课</span>
				 				</c:otherwise>
				 			</c:choose>
				 			<c:if test="${'1' eq course.copen }">
				 			</c:if>
				 		</td>
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