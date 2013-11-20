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
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/web/css/index.css" />
</head>
<body>
<div class="container">
	<!-- 导航条 -->
	<jsp:include page="/WEB-INF/views/include/webtop.jsp"></jsp:include>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<a class="brand" href="javascript:void(0)">万花</a>
			<ul class="nav">
				<li class="active"><a href="javascript:reloadLeft('${contextPath }/page/main/left_home')">首页</a></li>
				<li class="divider-vertical"></li>
				<li><a href="javascript:reloadLeft('${contextPath }/page/main/left_course')">课程管理</a></li>
				<li class="divider-vertical"></li>
				<li><a href="javascript:reloadLeft('${contextPath }/page/main/left_teacher')">教师管理</a></li>
				<li class="divider-vertical"></li>
				<li><a href="javascript:reloadLeft('${contextPath }/page/main/left_student')">学生管理</a></li>
			</ul>
		</div>
	</div>
	<!-- 轮播插件 -->
	<div class="carousel slide" id="carousel" style="margin-top: 50px;">
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
	<!-- 课程信息 -->
	<div class="well span4 pull-left">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="javascript:void(0)">课程</a>
				<a href="${contextPath }/web/course/list" class="pull-right" style="padding-top: 10px;">更多</a>
			</div>
			<ul class="thumbnails">
				<c:forEach items="${courses }" var="course">
					<li class="span2">
						<div class="thumbnail">
							<p align="center"><a href="#"><img src="${contextPath }/common/images/logo.png" class="img-rounded h100"></a></p>
							<p align="center"><c:out value="${course.cname }"/></p>
							<p style="text-indent: 2em;"><c:out value="${e:cut(course.cdescription, 20) }"/></p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- 教师信息 -->
	<div class="well span10">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="javascript:void(0)">教师</a>
				<a href="${contextPath }/web/teacher/list" class="pull-right" style="padding-top: 10px;">更多</a>
			</div>
			<ul class="thumbnails">
				<c:forEach items="${teachers }" var="teacher">
					<li class="span2">
						<div class="thumbnail">
							<p align="center"><a href="#"><img src="${contextPath }/common/images/logo.png" class="img-rounded h100"></a></p>
							<p align="center"><c:out value="${teacher.cname }"/></p>
							<p style="text-indent: 2em;"><%-- <c:out value="${e:cut(teacher.cdescription, 20) }"/> --%></p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- Demo -->
	<div class="well span10">
		<div class="navbar">
			<div class="navbar-inner">
				<a class="brand" href="javascript:void(0)">免费资料</a>
				<a href="${contextPath }/web/resource/listForFree" class="pull-right" style="padding-top: 10px;">更多</a>
			</div>
			<ul class="thumbnails">
				<c:forEach items="${resources }" var="resource">
					<li class="span3">
						<div class="thumbnail">
							<p align="center"><a href="${contextPath }/web/resource/view/${resource.uuid}" target="_blank"><img src="${contextPath }${resource.cpictureurl}" class="img-rounded h180"></a></p>
							<p align="center"><c:out value="${resource.cname }"/></p>
							<p style="text-indent: 2em;"><c:out value="${e:cut(resource.cdescription, 20) }"/></p>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript">
$(".container").css("width",document.body.scrollWidth - 3 + "px");
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
	$.post(contextPath + "/web/student/login/getCookies", function(map){
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
		ajaxFormValidationURL : contextPath + '/web/student/login/validate',
		onBeforeAjaxFormValidation: function(form, options) {
			$("#loginBtn").attr("disabled", "disabled").removeClass("btn-primary").addClass("btn-inverse"); // 禁用保存按钮，防止重复提交表单
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
				$.post(contextPath + "/web/student/login", params, function(data){
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
		ajaxFormValidationURL : contextPath + '/web/student/validate',
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