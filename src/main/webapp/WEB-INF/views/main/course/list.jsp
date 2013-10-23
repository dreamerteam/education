<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程类型列表</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div id="page">
	<div class="well">
		<form action="${contextPath }/courseType/list" class="form-search" id="searchForm">
			<label>课程类型名称：</label><input type="text" name="cname" class="input-medium search-query">
			<button type="submit" class="btn btn-primary">查 找</button>
		</form>
	</div>
	<div class="well">
	
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.core.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.widget.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.position.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.menu.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.autocomplete.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/autocomplete.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath}/autoComplete/courseType" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
$(function(){
	autoComplete(true, $("#cname"), courseType);
	
	$("#searchForm").validationEngine({
		onAjaxFormComplete: function(status, form, json, options) {
			if (status) {
				reloadMain(contextPath + '/page/common/success');
			} else {
				$("#submitBtn").removeAttr("disabled").removeClass("btn-inverse").addClass("btn-primary");
			}
		}
	}); 
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/coursetype.js" ></script>
</html>