<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教师信息修改</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div class="container" style="height: 100%">
	<div class="well">
		<form action="${contextPath }/manage/teacher/update" method="post" id="editForm" class="form-horizontal">
			<input type="hidden" name="uuid" id="uuid" value="<c:out value="${teacher.uuid }"/>" />
			<div class="control-group">
				<label class="control-label">姓名：</label>
				<div class="controls">
					<input type="text" name="cname" id="cname" placeholder="姓名" class="validate[maxSize3[36]]" value="<c:out value="${teacher.cname }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">性别：</label>
				<div class="controls">
					<input type="radio" name="csex" value="男" ${empty teacher.csex ? 'checked="checked"' : ('男' eq teacher.csex ? 'checked="checked"' : '')}/>男
					<input type="radio" name="csex" value="女" ${'女' eq teacher.csex ? 'checked="checked"' : ''}/>女
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">昵称：</label>
				<div class="controls">
					<input type="text" name="cnickname" id="cnickname" placeholder="昵称" class="validate[maxSize3[36]]" value="<c:out value="${teacher.cnickname }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">身份证：</label>
				<div class="controls">
					<input type="text" name="cidcard" id="cidcard" placeholder="身份证" class="validate[maxSize3[18]]" value="<c:out value="${teacher.cidcard }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">国籍：</label>
				<div class="controls">
					<input type="text" name="ccountry" id="ccountry" placeholder="国籍" class="validate[maxSize3[36]]" value="<c:out value="${teacher.ccountry }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">籍贯：</label>
				<div class="controls">
					<input type="text" name="cnativeplace" id="cnativeplace" placeholder="籍贯" class="validate[maxSize3[36]]" value="<c:out value="${teacher.cnativeplace }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">学历：</label>
				<div class="controls">
					<input type="text" name="ceducation" id="ceducation" placeholder="学历" class="validate[maxSize3[36]]" value="<c:out value="${teacher.ceducation }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">生日：</label>
				<div class="controls">
					<input type="text" name="dbirthday" id="dbirthday" placeholder="生日" value="<fmt:formatDate  value="${teacher.dbirthday }" pattern="yyyy-MM-dd"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">手机号：</label>
				<div class="controls">
					<input type="text" name="cmobile" id="cmobile" placeholder="手机号" class="validate[maxSize3[11]]" value="<c:out value="${teacher.cmobile }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">固定电话：</label>
				<div class="controls">
					<input type="text" name="cfixedline" id="cfixedline" placeholder="固定电话" class="validate[maxSize3[36]]" value="<c:out value="${teacher.cfixedline }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">住址：</label>
				<div class="controls">
					<input type="text" name="caddress" id="caddress" placeholder="住址" class="validate[maxSize3[255]]" value="<c:out value="${teacher.caddress }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">QQ号：</label>
				<div class="controls">
					<input type="text" name="cqq" id="cqq" placeholder="QQ号" class="validate[maxSize3[36]]" value="<c:out value="${teacher.cqq }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">MSN号：</label>
				<div class="controls">
					<input type="text" name="cmsn" id="cmsn" placeholder="MSN号" class="validate[maxSize3[36]]" value="<c:out value="${teacher.cmsn }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">邮箱：</label>
				<div class="controls">
					<input type="text" name="cemail" id="cemail" placeholder="邮箱" class="validate[maxSize3[100]]" value="<c:out value="${teacher.cemail }"/>"/>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label">自我介绍：</label>
				<div class="controls">
					<textarea name="cdescription" id="cdescription" placeholder="自我介绍" class="validate[maxSize3[500]]"><c:out value="${teacher.cdescription }"/></textarea>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button type="submit" id="submitBtn" class="btn btn-primary">保 存</button>
				</div>
			</div>
		</form>
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
	$("#editForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : false
	}); 
});
</script>
</html>
