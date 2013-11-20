<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>梦想家登录</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/login.css" />
</head>
<body>
<div class="login_body">
	<div class="login_img"></div>
	<form action="" id="loginForm" method="post" class="form-horizontal"  style="margin-top: 125px;margin-left: 15px;">
		<div class="control-group" >
			<label class="control-label">用户名：</label>
			<div class="controls">
				<input type="text" name="clogin" id="clogin" class="form-control validate[required]" placeholder="用户名"/>
			</div>
		</div>
		<div class="control-group" >
			<label class="control-label">密码：</label>
			<div class="controls">
				<input type="password" name="cpassword" id="cpassword" class="form-control validate[required]" placeholder="密码"/>
			</div>
		</div>
		<div class="control-group" >
			<label class="control-label">验证码：</label>
			<div class="controls">
				<input type="text" name="captcha" id="captcha" class="form-control validate[required]" placeholder="验证码"/>
			</div>
		</div>
		<div class="control-group" style="margin: -8px 0 0 120px">
				<img class="img-rounded cursor-pointer" id="captchaImg" src="" >
				<label style="display: inline;margin-left: 50px;"><input type="checkbox" name="remember" id="remember" value="1" /> 记住我</label>
		</div>
		<div class="control-group" >
			<div class="controls" style="margin-top: 25px;">
				<input type="submit" class="btn btn-primary btn-lg btn-block" id="submitBtn" value="登录"/>
			</div>
		</div>
	</form>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine-zh_CN.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var captchaImg = $("#captchaImg");
$(function(){
	/*验证码*/
	if(captchaImg){
		reloadCaptcha(); // 验证码初始化
		captchaImg.click(function(){ // 验证码点击事件
			reloadCaptcha();
		});
		captchaImg.show();
	}
	$.post(contextPath + "/manage/login/getCookies", function(map){
		if(null != map){
			$("#clogin").val(map.clogin);
			if("1" == map.remember){
				$("#remember").attr("checked", "checked");
			} else {
				$("#remember").removeAttr("checked");
			}
		}
	});
	/*登录表单*/
	$("#loginForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : true,
		ajaxFormMethod : 'POST',
		ajaxFormValidationURL : contextPath + '/manage/login/validate',
		onBeforeAjaxFormValidation: function(form, options) {
			$("#submitBtn").attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-inverse"); // 禁用保存按钮，防止重复提交表单
		},
		onAjaxFormComplete: function(status, form, json, options) {
			if (status) {
				/* $("#remember").val($("#remember").is(":checked") ? "1" : "0");
				form.validationEngine('detach').submit(); */
				var params = {};
				params["clogin"] = $("#clogin").val();
				params["cpassword"] = $("#cpassword").val();
				params["captcha"] = $("#captcha").val();
				params["remember"] = $("#remember").is(":checked") ? "1" : "0";
				$.post(contextPath + "/manage/login", params, function(data){
					if("success" == data.result){
						window.location.href = contextPath + "/page/main/index";
					} else {
						$("#loginBtn").removeAttr("disabled").removeClass("btn-inverse").addClass("btn-primary");
						alert(data.error);
					}
				});
			} else {
				$("#submitBtn").removeAttr("disabled").removeClass("btn-inverse").addClass("btn-primary");
			}
		}
	}); 
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/login.js" ></script>
</html>