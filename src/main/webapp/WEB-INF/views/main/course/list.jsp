<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程列表</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/validationEngine.jquery.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery-ui-timepicker-addon.css" />
</head>
<body>
<div id="page">
	<div class="well">
		<form action="${contextPath }/course/list" class="form-search" id="searchForm">
			<label>课程名称：</label><input type="text" name="cname" id="cname" class="input-medium search-query">
			<button type="submit" class="btn btn-primary">查 找</button>
		</form>
	</div>
	<div class="well">
		<div class="btn-group mb10">
			<button class="btn btn-primary" onclick="view()">查看</button>
			<!-- 未审核 -->
			<c:if test="${'0' eq param.caudit }">
				<button class="btn btn-primary" onclick="edit()">修 改</button>
				<button class="btn btn-primary" onclick="start(1)">启用</button>
				<button class="btn btn-primary" onclick="start(0)">停用</button>
				<button class="btn btn-primary" onclick="audit(10)">提交审核</button>
			</c:if>
			<!-- 待审 -->
			<c:if test="${'10' eq param.caudit }">
				<button class="btn btn-primary" onclick="toAudit()">审核</button>
			</c:if>
			<!-- 通过审核 -->
			<c:if test="${'20' eq param.caudit }">
				<button class="btn btn-primary" onclick="opens(1)">开课</button>
			</c:if>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th></th>
				 	<th>序号</th>
				 	<th>名称</th>
				 	<th>类型</th>
				 	<th>热门度</th>
				 	<th>审核状态</th>
				 	<th>启用状态</th>
				 	<c:if test="${'20' eq param.caudit }">
					 	<th>开课状态</th>
				 	</c:if>
				 </tr>
			</thead>
			<tbody>
				 <c:forEach items="${page.resultRows }" var="course" varStatus="st">
				 	<tr>
				 		<td><input type="checkbox" name="check" value="<c:out value="${course.uuid },${course.cstatus },${course.copen }"/>" /></td>
				 		<td>${st.index + 1 }</td>
				 		<td><c:out value="${course.cname }"/></td>
				 		<td><c:out value="${course.ctypename }"/></td>
				 		<td><c:out value="${course.ihot }"/></td>
				 		<td><c:out value="${e:convert('course_audit', course.caudit) }"/></td>
				 		<td><c:out value="${e:convert('course_status', course.cstatus) }"/></td>
				 		<c:if test="${'20' eq param.caudit }">
							<td><c:out value="${e:convert('open', course.copen) }"/></td>
						</c:if>
				 	</tr>
				 </c:forEach>
			</tbody>
		</table>
		<%@ include file="/WEB-INF/views/include/page.jsp" %>
	</div>
</div>
<div id="openCourse" class="modal hide fade" role="dialog" aria-labelledby="modalTitle" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="modalTitle">开课</h3>
	</div>
	<div class="modal-body" style="overflow: hidden;">
		<form action="" method="post" class="form-horizontal" id="openCourseForm">
			<input type="hidden" name="uuid" id="uuid" />
			<div class="control-group" >
				<label class="control-label">开课时间：</label>
				<div class="controls">
					<input type="text" name="dlession" id="dlession" placeholder="开课时间" class="form-control validate[required]"/>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer">
		<div align="center">
			 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> 
			 <button id="loginBtn" class="btn btn-primary" onclick="openCourse()">开课</button>
			</div>
		</div>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery-ui.custom.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery-ui-sliderAccess.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery-ui-timepicker-addon.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.validationEngine-zh_CN.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/check.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var check;
$(function(){
	check = new InitCheck({lineSelected: false, multipleValue:["uuid", "cstatus", "open"]});
	$("#dlession").datetimepicker({
		dateFormat: 'yy-mm-dd',
	    timeFormat: 'HH:mm'}).attr("readonly","readonly");
	$("#openCourseForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : false
	}); 
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/course.js" ></script>
</html>