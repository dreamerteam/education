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
</head>
<body id="page">
<div class="well">
	<form class="form-horizontal">
		<div class="control-group">
			<label class="control-label">课程名称：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${courseResponse.cname }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">课程类型：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${courseResponse.ctypename }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">搜索关键字：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${courseResponse.ckeyword }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">课程热门度：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${courseResponse.ihot }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">课程审核状态：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${e:convert('course_audit', courseResponse.caudit) }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">课程启用状态：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${e:convert('course_status', courseResponse.cstatus) }"/></label>
			</div>
		</div>
	</form>
	<c:if test="${not empty param.op }">
		<div align="center">
			<button type="button" class="btn btn-primary" onclick="window.location.href='${contextPath}/course/changeAudit?uuid=${param.uuid }&caudit=20&preaudit=10'">通过审核</button>
			<button type="button" class="btn btn-primary" onclick="window.location.href='${contextPath}/course/changeAudit?uuid=${param.uuid }&caudit=30&preaudit=10'">不通过审核</button>
		</div>
	</c:if>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
</html>
