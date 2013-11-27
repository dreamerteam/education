<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教师个人信息查看</title>
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
					<td><c:out value="${teacher.cname }"/></td>
				</tr>
				<tr>
					<td>性别：</td>
					<td><c:out value="${teacher.csex }"/></td>
				</tr>
				<tr>
					<td>教师编号：</td>
					<td><c:out value="${teacher.cno }"/></td>
				</tr>
				<tr>
					<td>昵称：</td>
					<td><c:out value="${teacher.cnickname }"/></td>
				</tr>
				<tr>
					<td>身份证：</td>
					<td><c:out value="${teacher.cidcard }"/></td>
				</tr>
				<tr>
					<td>国籍：</td>
					<td><c:out value="${teacher.ccountry }"/></td>
				</tr>
				<tr>
					<td>籍贯：</td>
					<td><c:out value="${teacher.cnativeplace }"/></td>
				</tr>
				<tr>
					<td>学历：</td>
					<td><c:out value="${teacher.ceducation }"/></td>
				</tr>
				<tr>
					<td>生日：</td>
					<td><fmt:formatDate  value="${teacher.dbirthday }" pattern="yyyy-MM-dd"/></td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td><c:out value="${teacher.cmobile }"/></td>
				</tr>
				<tr>
					<td>固定电话：</td>
					<td><c:out value="${teacher.cfixedline }"/></td>
				</tr>
				<tr>
					<td>住址：</td>
					<td><c:out value="${teacher.caddress }"/></td>
				</tr>
				<tr>
					<td>QQ号：</td>
					<td><c:out value="${teacher.cqq }"/></td>
				</tr>
				<tr>
					<td>MSN号：</td>
					<td><c:out value="${teacher.cmsn }"/></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><c:out value="${teacher.cemail }"/></td>
				</tr>
				<tr>
					<td>自我介绍：</td>
					<td><c:out value="${teacher.cdescription }"/></td>
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
