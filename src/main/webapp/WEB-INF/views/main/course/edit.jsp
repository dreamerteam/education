<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程编辑</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body id="page">
<div class="well">
	<form action="${contextPath }/course/update" method="post" class="form-horizontal" id="editForm">
		<input type="hidden" name="coperate" id="coperate" value="update" />
		<input type="hidden" name="coldname" id="coldname" value="<c:out value="${courseResponse.cname }"/>" />
		<input type="hidden" name="uuid" id="uuid" value="<c:out value="${courseResponse.uuid }"/>" />
		<input type="hidden" name="utypeid" id="utypeid" value="<c:out value="${courseResponse.utypeid }"/>"/>
		<div class="control-group">
			<label class="control-label"><div class="inline" style="color: red;"> * </div>课程名称：</label>
			<div class="controls">
				<input type="text" name="cname" id="cname" placeholder="课程名称" class="validate[required,maxSize3[36]]" value="<c:out value="${courseResponse.cname }"/>"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><div class="inline" style="color: red;"> * </div>课程类型：</label>
			<div class="controls">
				<input type="text" name="courseType" id="courseType" placeholder="课程类型" class="validate[required]" value="<c:out value="${courseResponse.ctypename }"/>"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">搜索关键字：</label>
			<div class="controls">
				<input type="text" name="ckeyword" id="ckeyword" placeholder="搜索关键字" class="validate[maxSize3[255]]"  value="<c:out value="${courseResponse.ckeyword }"/>"/>
				<span style="color: red;">&nbsp;&nbsp;多个搜索关键字请用逗号（,）分隔</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">课程简介：</label>
			<div class="controls">
				<textarea rows="" cols="" name="cdescription" id="cdescription" class="validate[maxSize3[500]]"><c:out value="${courseResponse.cdescription }"/></textarea>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" id="submitBtn" class="btn btn-primary">保 存</button>
			</div>
		</div>
	</form>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.core.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.widget.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.position.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.menu.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.autocomplete.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/autocomplete.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/function.js" ></script>
<script type="text/javascript" src="${contextPath}/autoComplete/courseType" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var page = $("#page");
$(function(){
	autoComplete(true, $("#courseType"), courseType, $("#utypeid"));
	
	$("#editForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : true,
		ajaxFormMethod : 'POST',
		ajaxFormValidationURL : contextPath + '/course/validate',
		onBeforeAjaxFormValidation: function(form, options) {
			$("#submitBtn").attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-inverse"); // 禁用保存按钮，防止重复提交表单
		},
		onAjaxFormComplete: function(status, form, json, options) {
			if (status) {
				form.validationEngine('detach').submit();
			} else {
				$("#submitBtn").removeAttr("disabled").removeClass("btn-inverse").addClass("btn-primary");
			}
		}
	}); 
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/course.js" ></script>
</html>
