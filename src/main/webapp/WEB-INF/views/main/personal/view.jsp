<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>个人信息查看</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
<style type="text/css">
.controls .forEdit{
	display: none;
}
</style>
</head>
<body>
<div class="container" style="height: 100%">
	<div class="well">
		<div class="btn-group mb10">
			<button class="btn btn-primary" onclick="toggleEdit(1)">修改个人信息</button>
			<button class="btn btn-primary" onclick="$('#updatePsw').modal('show')">修改密码</button>
		</div>
		<hr>
		<form action="${contextPath }/manage/personal/update" method="post" id="updateForm" class="form-horizontal">
			<input type="hidden" name="uuid" id="uuid" value="<c:out value="${personal.uuid }"/>" />
			<div class="control-group">
				<label class="control-label">姓名：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${personal.cname }"/></label>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">性别：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${personal.csex }"/></label>
				</div>
			</div>
			<c:if test="${'manager' != authority }">
				<div class="control-group">
					<label class="control-label">编号：</label>
					<div class="controls">
						<label style="padding-top: 5px;"><c:out value="${personal.cno }"/></label>
					</div>
				</div>
			</c:if>
			<c:if test="${'manager' != authority }">
				<div class="control-group">
					<label class="control-label">昵称：</label>
					<div class="controls">
						<label class="forView" style="padding-top: 5px;"><c:out value="${personal.cnickname }"/></label>
						<input type="text" name="cnickname" id="cnickname" placeholder="昵称" class="forEdit validate[maxSize3[36]]" value="<c:out value="${personal.cnickname }"/>"/>
					</div>
				</div>
			</c:if>
			<div class="control-group">
				<label class="control-label">身份证：</label>
				<div class="controls">
					<label style="padding-top: 5px;"><c:out value="${personal.cidcard }"/></label>
					<input type="text" name="cidcard" id="cidcard" placeholder="身份证" class="forEdit validate[maxSize3[18]]" value="<c:out value="${personal.cidcard }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">国籍：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.ccountry }"/></label>
					<input type="text" name="ccountry" id="ccountry" placeholder="国籍" class="forEdit validate[maxSize3[36]]" value="<c:out value="${personal.ccountry }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">籍贯：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.cnativeplace }"/></label>
					<input type="text" name="cnativeplace" id="cnativeplace" placeholder="籍贯" class="forEdit validate[maxSize3[36]]" value="<c:out value="${personal.cnativeplace }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">学历：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.ceducation }"/></label>
					<input type="text" name="ceducation" id="ceducation" placeholder="学历" class="forEdit validate[maxSize3[36]]" value="<c:out value="${personal.ceducation }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">生日：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><fmt:formatDate  value="${personal.dbirthday }" pattern="yyyy-MM-dd"/></label>
					<input type="text" name="dbirthday" id="dbirthday" placeholder="生日" value="<fmt:formatDate  value="${personal.dbirthday }" pattern="yyyy-MM-dd"/>" class="forEdit"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">手机号：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.cmobile }"/></label>
					<input type="text" name="cmobile" id="cmobile" placeholder="手机号" class="forEdit validate[maxSize3[11]]" value="<c:out value="${personal.cmobile }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">固定电话：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.cfixedline }"/></label>
					<input type="text" name="cfixedline" id="cfixedline" placeholder="固定电话" class="forEdit validate[maxSize3[36]]" value="<c:out value="${personal.cfixedline }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">住址：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.caddress }"/></label>
					<input type="text" name="caddress" id="caddress" placeholder="住址" class="forEdit validate[maxSize3[255]]" value="<c:out value="${personal.caddress }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">QQ号：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.cqq }"/></label>
					<input type="text" name="cqq" id="cqq" placeholder="QQ号" class="forEdit validate[maxSize3[36]]" value="<c:out value="${personal.cqq }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">MSN号：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.cmsn }"/></label>
					<input type="text" name="cmsn" id="cmsn" placeholder="MSN号" class="forEdit validate[maxSize3[36]]" value="<c:out value="${personal.cmsn }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">邮箱：</label>
				<div class="controls">
					<label class="forView" style="padding-top: 5px;"><c:out value="${personal.cemail }"/></label>
					<input type="text" name="cemail" id="cemail" placeholder="邮箱" class="forEdit validate[maxSize3[100]]" value="<c:out value="${personal.cemail }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" id="submitBtn" class="forEdit btn btn-primary">保 存</button>
					<button type="button" id="cancelBtn" class="forEdit btn btn-primary" onclick="toggleEdit(0)" style="margin-left: 20px;">取 消</button>
				</div>
			</div>
		</form>
	</div>
</div>
<div id="updatePsw" class="modal hide fade" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="modalTitle">修改密码</h3>
	</div>
	<div class="modal-body" style="overflow: hidden;">
		<form action="" method="post" class="form-horizontal" id="updatePswForm">
			<div class="control-group" >
				<label class="control-label">原密码：</label>
				<div class="controls">
					<input type="password" name="oldPsw" id="oldPsw" placeholder="原密码" class="form-control validate[required,funcCall[validatePsw]]"/>
				</div>
			</div>
			<div class="control-group" >
				<label class="control-label">新密码：</label>
				<div class="controls">
					<input type="password" name="newPsw" id="newPsw" placeholder="新密码" class="form-control validate[required]"/>
				</div>
			</div>
			<div class="control-group" >
				<label class="control-label">确认密码：</label>
				<div class="controls">
					<input type="password" name="confirmPsw" id="confirmPsw" placeholder="确认密码" class="form-control validate[required,funcCall[confirmPassword]]"/>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer">
		<div align="center">
			 <button class="btn" data-dismiss="modal" aria-hidden="true">关 闭</button> 
			 <button id="updateBtn" class="btn btn-primary" onclick="updatePsw()">修 改</button>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.core.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.widget.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.datepicker.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
$(function(){
	$("#dbirthday").datepicker({dateFormat : "yy-mm-dd"}).attr("readonly","readonly");
	$("#updatePswForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : false
	}); 
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/personal.js" ></script>
</html>
