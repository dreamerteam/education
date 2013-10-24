<%@ page trimDirectiveWhitespaces="true" pageEncoding="UTF-8" %>
<%@ include file="tags.jsp"%>
<c:set var="_page" value="${empty page ? requestScope[param.pageName] : page}" />
<c:choose>
	<c:when test="${empty param.formName}">
		<c:set var="formName" value="${empty param.formNo ? 0 : param.formNo}" />
	</c:when>
	<c:otherwise>
		<c:set var="formName" value="'${param.formName}'" />
	</c:otherwise>
</c:choose>
<script type="text/javascript">
/**
 * 验证是否是正整数
 * @author broken_xie
 */
String.prototype.isUInteger = function() {
	var regx = /^\d+$/;
	return regx.test(this);
};

function subPage(pageid) {
	<c:choose>
		<c:when test="${empty param.formURL}">
			var url = document.forms["${formName}"].action;
		</c:when>
		<c:otherwise>
			var url = "${param.formURL}";
		</c:otherwise>
	</c:choose>
	if(document.forms["${formName}"]['currentPage']) {
		document.forms["${formName}"]['currentPage'].value = pageid;
	}else{
		var i = document.createElement('input');
		i.type = 'hidden';
		i.name = 'currentPage';
		i.value = pageid;
		document.forms["${formName}"].appendChild(i);
	}
	document.forms["${formName}"].action = url;
	document.forms["${formName}"].submit();
}

function inputpage(){
	var pageid = document.getElementById('pageidInput').value;
	if(pageid.isUInteger()){
		subPage(pageid);
	}
}	
</script>
<div class="pagination pagination-centered">
	共${_page.totalRow}条记录 平均${_page.pageSize}条/页
	当前第${_page.currentPage}/${_page.totalPage}页  
	<ul>
		<c:if test="${_page.hasPrePage}">
			<li><a href="javascript:subPage('1')">首页</a></li>
			<li><a href="javascript:subPage('${_page.prePage}')">上一页</a></li>
		</c:if>
		<c:forEach items="${_page.pageIndex}" var="pi" varStatus="pagevs">
			<c:if test="${pi eq _page.currentPage}"><li class="active"><a href="#">${pi}</a></li></c:if> 
			<c:if test="${pi ne _page.currentPage}"><li><a href="javascript:subPage('${pi}')">${pi}</a></li> </c:if>
		</c:forEach>
		<c:if test="${_page.hasNextPage}">
			<li><a href="javascript:subPage('${_page.nextPage}')">下一页</a></li>
			<li><a href="javascript:subPage('${_page.totalPage}')">末页</a></li>
		</c:if>
	</ul>
	前往第 <input type="text" id="pageidInput" style="width: 30px;" onkeydown="if(event.keyCode == 13){inputpage(); return false;}" /> 页&nbsp; <button class="btn btn-primary" onclick="inputpage();return false;">Go</button>
</div>