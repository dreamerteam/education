<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教师管理菜单【左侧】</title>
</head>
<body>
<div class="well">
	<div id="accordion">
		<p>教师管理</p>
		<div style="padding: 5px 3px; overflow: hidden;">
			<ul class="nav nav-list">
				<li class="pagination-centered active"><a href="javascript:reloadMain('${pageContext.request.contextPath}/page/main/course/add')">列表</a></li>
				<li class="pagination-centered "><a href="#">新增</a></li>
			</ul>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript">
$(function() {
	$( "#accordion" ).accordion({
		collapsible: true
	}); 
});
</script>
</html>