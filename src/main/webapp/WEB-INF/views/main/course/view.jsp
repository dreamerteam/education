<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程查看</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
<style type="text/css">
.table th {
	width: 150px;
}
</style>
</head>
<body>
<div class="well">
	<table class="table table-bordered table-hover">
		<tbody>
			<tr>
				<th>课程名称：</th>
				<td><c:out value="${courseResponse.cname }"/></td>
			</tr>
			<tr>
				<th>课程类型：</th>
				<td><c:out value="${courseResponse.ctypename }"/></td>
			</tr>
			<tr>
				<th>搜索关键字：</th>
				<td><c:out value="${courseResponse.ckeyword }"/></td>
			</tr>
			<tr>
				<th>课程热门度：</th>
				<td><c:out value="${courseResponse.ihot }"/></td>
			</tr>
			<tr>
				<th>课程审核状态：</th>
				<td><c:out value="${e:convert('course_audit', courseResponse.caudit) }"/></td>
			</tr>
			<tr>
				<th>课程启用状态：</th>
				<td><c:out value="${e:convert('course_status', courseResponse.cstatus) }"/></td>
			</tr>
			<tr>
				<th>课程图片：</th>
				<td>
					<img src="${contextPath }/<c:out value="${courseResponse.cpath}"/>" class="img-rounded" width="100px" height="100px">
			</tr>
		</tbody>
	</table>
	<c:if test="${not empty param.op }">
		<div align="center">
			<button type="button" class="btn btn-primary" onclick="window.location.href='${contextPath}/manage/course/changeAudit?uuid=${param.uuid }&caudit=20&preaudit=10'">通过审核</button>
			<button type="button" class="btn btn-primary" onclick="window.location.href='${contextPath}/manage/course/changeAudit?uuid=${param.uuid }&caudit=30&preaudit=10'">不通过审核</button>
		</div>
	</c:if>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
</html>
