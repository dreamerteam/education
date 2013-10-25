// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 修改
 * @author broken_xie
 **/
function edit(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/courseType/edit?uuid=' + check.getCheckValue().uuid;
	}
}

/**
 * 查看
 * @author broken_xie
 **/
function view(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/courseType/view?uuid=' + check.getCheckValue().uuid;
	}
}

/**
 * 删除
 * @author broken_xie
 **/
function del(){
	if(check.verifyCheck()){
		alert(contextPath + '/courseType/del?ccode=');
		window.location.href = contextPath + '/courseType/del?ccode=' + check.getCheckValue().ccode;
	}
}
