<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>梦想家</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="well">
	<form action="${contextPath }/courseType/add" method="post" class="form-horizontal" id="addForm">
		<input type="hidden" name="ilevel" value="1" />
		<input type="hidden" name="uparentid" value="" />
		<div class="control-group">
			<label class="control-label"><div class="inline" style="color: red;"> * </div>课程类型名称：</label>
			<div class="controls">
				<input type="text" name="cname" id="cname" placeholder="课程类型名称" class="validate[required,maxSize[36]]" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上级课程类型：</label>
			<div class="controls">
				<input type="text" name="parenttype" id="parenttype" placeholder="上级课程类型" />
			</div>
		</div>
		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn btn-primary">添 加</button>
			</div>
		</div>
	</form>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.core.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.widget.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery-ui.custom.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/common.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
$(function(){
	$("#parenttype").autocomplete({
		source : "${contextPath}/autoComplete/courseType"
	});
	
	$("#addForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : true,
		ajaxFormMethod : 'POST',
		ajaxFormValidationURL : contextPath + '/courseType/validate',
		onBeforeAjaxFormValidation: function(form, options) {
			/* submitBtn.removeClass().addClass('operateBtnPre').attr("disabled", "disabled"); // 禁用保存按钮，防止重复提交表单
			backBtn.removeClass().addClass('operateBtnPre').attr('disabled', 'disabled'); */
		},
		onAjaxFormComplete: function(status, form, json, options) {
			/* if (status) {
				form.validationEngine('detach').submit();
			} else {
				submitBtn.removeClass().addClass('operateBtn').removeAttr("disabled");
				backBtn.removeClass().addClass('operateBtn').removeAttr("disabled");
			} */
		}
	}); 
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/coursetype.js" ></script>
</html>