<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>资源添加</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="well">
	<form action="${contextPath }/manage/resource/add" method="post" class="form-horizontal" id="addForm" enctype="multipart/form-data">
		<input type="hidden" name="coperate" id="coperate" value="add" />
		<div class="control-group">
			<label class="control-label"><div class="inline" style="color: red;"> * </div>视频名称：</label>
			<div class="controls">
				<input type="text" name="cname" id="cname" placeholder="资源名称" class="validate[required,maxSize3[36]]" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><div class="inline" style="color: red;"> * </div>视频链接：</label>
			<div class="controls">
				<input type="text" name="cpath" id="cpath" placeholder="视频链接" class="validate[required,maxSize3[500]]" onblur="changeVideo(this)" />
			</div>
		</div>
		<div class="control-group" style="display: none;" id="video">
			<div class="controls">
				<embed src="" 
					quality="high" width="480" height="400" align="middle"
					allowScriptAccess="always" allowFullScreen="true"
					mode="transparent" type="application/x-shockwave-flash">
				</embed>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label"><div class="inline" style="color: red;"> * </div>视频图片：</label>
			<div class="controls">
				<input type="file" name="videoImg" id="videoImg" placeholder="视频图片" class="validate[required]"/>
			</div>
		</div>
		<div class="control-group" style="display: none;">
			<div class="controls">
				<img src="${contextPath }/common/images/logo.png" width="200px" height="200px" class="img-rounded">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">搜索关键字：</label>
			<div class="controls">
				<input type="text" name="ckeyword" id="ckeyword" placeholder="搜索关键字" class="validate[maxSize3[255]]" />
				<span style="color: red;">&nbsp;&nbsp;多个搜索关键字请用逗号（,）分隔</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">视频简介：</label>
			<div class="controls">
				<textarea rows="" cols="" name="cdescription" id="cdescription"></textarea>
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
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/function.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
$(function(){
	$("#addForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : true,
		ajaxFormMethod : 'POST',
		ajaxFormValidationURL : contextPath + '/manage/resource/validate',
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
<script type="text/javascript" src="${contextPath }/main/js/resource.js" ></script>
</html>
