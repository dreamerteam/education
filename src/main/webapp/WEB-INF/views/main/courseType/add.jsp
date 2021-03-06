<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程类型添加</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="well">
	<form action="${contextPath }/manage/courseType/add" method="post" class="form-horizontal" id="addForm">
		<input type="hidden" name="coperate" id="coperate" value="add" />
		<input type="hidden" name="ilevel" id="ilevel" value="0" />
		<input type="hidden" name="uparentid" id="uparentid" />
		<input type="hidden" name="cparentcode" id="cparentcode" />
		<div class="control-group">
			<label class="control-label"><div class="inline" style="color: red;"> * </div>课程类型名称：</label>
			<div class="controls">
				<input type="text" name="cname" id="cname" placeholder="课程类型名称" class="validate[required,maxSize3[36]]" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><div class="inline" style="color: red;"> * </div>课程类型代码：</label>
			<div class="controls">
				<input type="text" name="ccode" id="ccode" placeholder="课程类型代码" class="validate[required,maxSize3[20]]" data-original-title="建议使用课程类型名称拼音首字母"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上级课程类型：</label>
			<div class="controls">
				<input type="text" name="parenttype" id="parenttype" placeholder="上级课程类型" data-original-title="顶级课程类型不需要选课程类型"/>
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" id="submitBtn" class="btn btn-primary">添 加</button>
			</div>
		</div>
	</form>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
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
	$('#ccode,#parenttype').tooltip({trigger : "hover"});
	autoComplete(true, $("#parenttype"), courseType, $("#uparentid"), $("#ilevel"), $("#cparentcode"));
	
	$("#addForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : true,
		ajaxFormMethod : 'POST',
		ajaxFormValidationURL : contextPath + '/manage/courseType/validate',
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
<script type="text/javascript" src="${contextPath }/main/js/coursetype.js" ></script>
</html>
