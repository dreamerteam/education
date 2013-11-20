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
		<form class="form-horizontal">
			<div class="control-group">
				<label class="control-label">姓名：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cname }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">性别：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.csex }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">学生编号：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cno }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">昵称：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cnickname }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">身份证：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cidcard }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">国籍：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.ccountry }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">籍贯：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cnativeplace }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">学历：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.ceducation }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">生日：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><fmt:formatDate  value="${student.dbirthday }" pattern="yyyy-MM-dd"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">手机号：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cmobile }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">固定电话：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cfixedline }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">住址：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.caddress }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">QQ号：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cqq }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">MSN号：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cmsn }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">邮箱：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${student.cemail }"/></label>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
</html>
