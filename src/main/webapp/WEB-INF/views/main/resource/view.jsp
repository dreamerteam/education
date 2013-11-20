<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>资源查看</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body id="page">
<div class="well">
	<form class="form-horizontal">
		<div class="control-group">
			<label class="control-label">名称：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${resource.cname }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类型：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${resource.ctype }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">搜索关键字：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${resource.ckeyword }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">简介：</label>
			<div class="controls">
				<label style="padding-top: 5px;"><c:out value="${resource.cdescription }"/></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">视频：</label>
			<div class="controls">
				<embed src="${resource.cpath }"
					allowFullScreen="true" quality="high" width="480" height="400"
					align="middle" allowScriptAccess="always"
					type="application/x-shockwave-flash">
				</embed>
			</div>
		</div>
	</form>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
</html>
