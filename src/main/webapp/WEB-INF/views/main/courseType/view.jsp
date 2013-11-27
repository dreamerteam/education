<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程类型查看</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body id="page">
<div class="well">
	<table class="table table-bordered .table-hover">
		<tbody>
			<tr>
				<td width="200px">课程类型名称：</td>
				<td><c:out value="${courseTypeResponse.cname }"/></td>
			</tr>
			<tr>
				<td>课程类型代码：</td>
				<td><c:out value="${courseTypeResponse.ccode }"/></td>
			</tr>
			<tr>
				<td>上级课程类型名称：</td>
				<td><c:out value="${courseTypeResponse.cparentname }"/></td>
			</tr>
		</tbody>
	</table>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
</html>
