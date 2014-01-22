<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ include file="/WEB-INF/views/include/tags.jsp" %>

<html>

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>top页面</title>

<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />

<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/top.css" />

<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />

</head>

<body>

<div class="navbar navbar-fixed-top" style="margin-bottom: 50px;">

	<div class="navbar-inner">

		<a class="brand" href="${contextPath }/web/index">万花</a>

		<ul class="nav">

			<li class=""><a href="${contextPath }/web/index">首页</a></li>

			<li class="divider-vertical"></li>

			<li><a href="${contextPath }/web/course/list">课程信息</a></li>

			<li class="divider-vertical"></li>

			<li><a href="${contextPath }/web/teacher/list">教师信息</a></li>

			<li class="divider-vertical"></li>

			<li><a href="${contextPath }/web/resource/list">资料</a></li>

			<c:if test="${not empty sessionScope.SESSION_CONTAINER_KEY}">

				<li class="divider-vertical"></li>

				<li><a href="${contextPath }/page/web/student/index">个人中心</a></li>

			</c:if>
			
			<li class="divider-vertical"></li>

			<li><a href="#modal-container"  data-toggle="modal">注册</a></li>
			
			<li class="divider-vertical"></li>

			<li><a href="#login"  data-toggle="modal">登录</a></li>

		</ul>

	</div>

</div>
<!-- 登录 -->
		<div class="row-fluid">
			<div class="span12">
				<div id="login" class="modal hide fade" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="modalTitle">登录</h3>
					</div>
					<div class="modal-body" style="overflow: hidden;">
						<form action="${contextPath }/student/login" method="post" class="form-horizontal" id="loginForm">
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
						</form>
					</div>
					<div class="modal-footer">
						<div align="center">
							 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
							 <button id="loginBtn" class="btn btn-primary" onclick="$('#loginForm').submit()">登录</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 注册 -->
		<div class="row-fluid">
			<div class="span12">
				<div id="modal-container" class="modal hide fade" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
						<h3 id="modalTitle">注册</h3>
					</div>
					<div class="modal-body" style="overflow: hidden;">
						<form action="${contextPath }/student/register" method="post" class="form-horizontal" id="registerForm">
							<div class="control-group">
								<label class="control-label"><div class="inline" style="color: red;"> * </div>用户名：</label>
								<div class="controls">
									<input type="text" name="regClogin" id="regClogin" placeholder="用户名" class="validate[required,minSize[6],maxSize3[36]]" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><div class="inline" style="color: red;"> * </div>密码：</label>
								<div class="controls">
									<input type="password" name="cpassword" id="regPsw" placeholder="密码" class="validate[required,maxSize3[36]]" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><div class="inline" style="color: red;"> * </div>密码确认：</label>
								<div class="controls">
									<input type="password" name="cpasswordConfirm" id="cpasswordConfirm" placeholder="密码确认" class="validate[required,maxSize3[36],funcCall[confirmPassword]]" />
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<div align="center">
							 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
							 <button id="registerBtn" class="btn btn-primary" onclick="$('#registerForm').submit()">注册</button>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>

<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>

<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>

<script type="text/javascript" src="${contextPath }/common/js/function.js" ></script>

<script type="text/javascript">

var contextPath = "${contextPath}";

var li = $(".nav li");

</script>
<script type="text/javascript">
$(".nav li").mouseover(function(){
	$(this).addClass("active");
}).mouseout(function(){
	$(this).removeClass("active");
});

</script>
<%-- <script type="text/javascript" src="${contextPath }/main/js/top.js" ></script> --%>
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

	/* 获取cookie */

	$.post(contextPath + "/student/login/getCookies", function(map){

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

		ajaxFormValidationURL : contextPath + '/student/login/validate',

		onBeforeAjaxFormValidation: function(form, options) {

			$("#loginBtn").attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-inverse"); // 禁用保存按钮，防止重复提交表单

		},

		onAjaxFormComplete: function(status, form, json, options) {

			if (status) {

				var params = {};

				params["clogin"] = $("#clogin").val();

				params["cpassword"] = $("#cpassword").val();

				params["captcha"] = $("#captcha").val();

				params["remember"] = $("#remember").is(":checked") ? "1" : "0";

				$.post(contextPath + "/student/login", params, function(data){

					if("success" == data.result){

						window.location.href = contextPath + "/page/web/student/index";

					} else {

						$("#loginBtn").removeAttr("disabled").removeClass("btn-inverse").addClass("btn-primary");

						alert(data.error);

					}

				});

			} else {

				$("#loginBtn").removeAttr("disabled").removeClass("btn-inverse").addClass("btn-primary");

			}

		}

	}); 

	/* 注册 */

	$("#registerForm").validationEngine({

		promptPosition : 'bottomRight',

		ajaxFormValidation : true,

		ajaxFormMethod : 'POST',

		ajaxFormValidationURL : contextPath + '/student/validate',

		onBeforeAjaxFormValidation: function(form, options) {

			$("#registerBtn").attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-inverse"); // 禁用保存按钮，防止重复提交表单

		},

		onAjaxFormComplete: function(status, form, json, options) {

			if (status) {

				var params = {};

				params["clogin"] = $("#regClogin").val();

				params["cpassword"] = $("#regPsw").val();

				$.post(contextPath + "/student/register", params, function(data){

					if("success" == data.result){

						alert("注册成功！请登录！");

						window.location.href = contextPath + "/page/web/student/index";

					} else {

						$("#registerBtn").removeAttr("disabled").removeClass("btn-inverse").addClass("btn-primary");

						alert(data.error);

					}

				});

			} else {

				$("#clogin").val("");

				$("#registerBtn").removeAttr("disabled").removeClass("btn-inverse").addClass("btn-primary");

			}

		}

	}); 

});

</script>

<script type="text/javascript" src="${contextPath }/web/js/index.js" ></script>

</html>