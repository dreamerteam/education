<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>万花网站首页</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/web/css/index.css" />
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="carousel slide" id="carousel">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0" data-target="#carousel"></li>
						<li data-slide-to="1" data-target="#carousel"></li>
						<li data-slide-to="2" data-target="#carousel"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<div align="center"><img src="${contextPath }/web/images/home1.jpg" /></div>
							<div class="carousel-caption">
								<h4>棒球</h4>
								<p>棒球运动是一种以棒打球为主要特点，集体性、对抗性很强的球类运动项目，在美国、日本尤为盛行。</p>
							</div>
						</div>
						<div class="item">
							<div align="center"><img src="${contextPath }/web/images/home2.jpg" /></div>
							<div class="carousel-caption">
								<h4>冲浪</h4>
								<p>冲浪是以海浪为动力，利用自身的高超技巧和平衡能力，搏击海浪的一项运动。运动员站立在冲浪板上，或利用腹板、跪板、充气的橡皮垫、划艇、皮艇等驾驭海浪的一项水上运动。</p>
							</div>
						</div>
						<div class="item">
							<div align="center"><img src="${contextPath }/web/images/home3.jpg" /></div>
							<div class="carousel-caption">
								<h4>自行车</h4>
								<p>以自行车为工具比赛骑行速度的体育运动。1896年第一届奥林匹克运动会上被列为正式比赛项目。环法赛为最著名的世界自行车锦标赛。</p>
							</div>
						</div>
					</div>
					<a data-slide="prev" href="#carousel" class="left carousel-control">‹</a> 
					<a data-slide="next" href="#carousel" class="right carousel-control">›</a>
				</div>
			</div>
		</div>
		<!-- 链接图片 -->
		<div class="row-fluid">
			<div class="span4" align="center">
				 <a id="modal" href="#modal-container" role="button" data-toggle="modal">
				 	<img src="${contextPath }/web/images/home1.jpg"/>
				 </a>
			</div>
			<div class="span4" align="center">
				 <a href="#login" data-toggle="modal">
				 	<img src="${contextPath }/web/images/home2.jpg"/>
				 </a>
			</div>
			<div class="span4" align="center">
				 <a href="${contextPath }/web/index">
				 	<img src="${contextPath }/web/images/home3.jpg"/>
				 </a>
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
									<input type="text" name="clogin" id="clogin" placeholder="用户名" class="validate[required,minSize[6],maxSize3[36]]" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><div class="inline" style="color: red;"> * </div>密码：</label>
								<div class="controls">
									<input type="password" name="cpassword" id="cpassword" placeholder="密码" class="validate[required,maxSize3[36]]" />
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
	</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
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
				form.validationEngine('detach').submit();
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