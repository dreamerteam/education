<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>视频观看</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="well">
	<div class="thumbnails">
		<div class="thumbnail">
			<p align="center"><c:out value="${resource.cname }"/></p>
			<p class="ti2"><c:out value="${resource.cdescription}"/></p>
			<p align="center">
				<embed src="${resource.cpath }"
					allowFullScreen="true" quality="high" width="480" height="400"
					align="middle" allowScriptAccess="always"
					type="application/x-shockwave-flash">
				</embed>
			</p>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
</html>
