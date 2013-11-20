<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<%session.invalidate();%>
<jsp:include page="${param.wap eq 'true' ? 'wap/index.jsp' : 'login.jsp'}"></jsp:include>