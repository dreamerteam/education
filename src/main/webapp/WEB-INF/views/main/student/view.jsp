<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>学生个人信息查看</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="container" style="height: 100%">
	<div class="well">
		<table class="table table-bordered table-hover">
			<tbody>
				<tr>
					<td>姓名：</td>
					<td><c:out value="${student.cname }"/></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><c:out value="${student.csex }"/></td>
				</tr>
				<tr>
					<td>学生编号：</td>
					<td><c:out value="${student.cno }"/></td>
				</tr>
				<tr>
					<td>昵称：</td>
					<td><c:out value="${student.cnickname }"/></td>
				</tr>
				<tr>
					<td>身份证：</td>
					<td><c:out value="${student.cidcard }"/></td>
				</tr>
				<tr>
					<td>国籍：</td>
					<td><c:out value="${student.ccountry }"/></td>
				</tr>
				<tr>
					<td>籍贯：</td>
					<td><c:out value="${student.cnativeplace }"/></td>
				</tr>
				<tr>
					<td>学历：</td>
					<td><c:out value="${student.ceducation }"/></td>
				</tr>
				<tr>
					<td>生日：</td>
					<td><fmt:formatDate  value="${student.dbirthday }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><c:out value="${student.cmobile }"/></td>
				</tr>
				<tr>
					<td>固定电话：</td>
					<td><c:out value="${student.cfixedline }"/></td>
				</tr>
				<tr>
					<td>住址：</td>
					<td><c:out value="${student.caddress }"/></td>
				</tr>
				<tr>
					<td>QQ号：</td>
					<td><c:out value="${student.cqq }"/></td>
				</tr>
				<tr>
					<td>MSN号：</td>
					<td><c:out value="${student.cmsn }"/></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><c:out value="${student.cemail }"/></td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
</html>
