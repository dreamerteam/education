<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>资源列表</title>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
</head>
<body>
<div id="page">
	<%-- <div class="well">
		<form action="${contextPath }/course/list" class="form-search" id="searchForm">
			<label>课程名称：</label><input type="text" name="cname" id="cname" class="input-medium search-query">
			<button type="submit" class="btn btn-primary">查 找</button>
		</form>
	</div> --%>
	<div class="well">
		<div class="btn-group mb10">
			<button class="btn btn-primary" onclick="view()">查看</button>
			<button class="btn btn-primary" onclick="free(1)">免费</button>
			<button class="btn btn-primary" onclick="free(0)">取消免费</button>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th></th>
				 	<th>序号</th>
				 	<th>名称</th>
				 	<th>类型</th>
				 	<th>免费状态</th>
				 	<th>关键字</th>
				 	<th>创建时间</th>
				 </tr>
			</thead>
			<tbody>
				 <c:forEach items="${page.resultRows }" var="resource" varStatus="st">
				 	<tr>
				 		<td><input type="checkbox" name="check" value="<c:out value="${resource.uuid },${resource.cfree }"/>" /></td>
				 		<td>${st.index + 1 }</td>
				 		<td><c:out value="${resource.cname }"/></td>
				 		<td><c:out value="${resource.ctype }"/></td>
				 		<td><c:out value="${e:convert('free', resource.cfree) }"/></td>
				 		<td><c:out value="${resource.ckeyword }"/></td>
				 		<td><fmt:formatDate value="${resource.dcreate }" pattern="yyyy-MM-dd" /> </td>
				 	</tr>
				 </c:forEach>
			</tbody>
		</table>
		<%@ include file="/WEB-INF/views/include/page.jsp" %>
	</div>
</div>
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/check.js" ></script>
<script type="text/javascript">
var contextPath = "${contextPath}";
var check;
$(function(){
	check = new InitCheck({lineSelected: false, multipleValue:["uuid", "free"]});
});
</script>
<script type="text/javascript" src="${contextPath }/main/js/resource.js" ></script>
</html>