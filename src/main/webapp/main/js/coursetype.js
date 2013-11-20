// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 修改
 * @author broken_xie
 **/
function edit(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/course/edit?uuid=' + check.getCheckValue().uuid;
	}
}

/**
 * 查看
 * @author broken_xie
 **/
function view(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/course/view?uuid=' + check.getCheckValue().uuid;
	}
}

/**
 * 删除
 * @author broken_xie
 **/
function del(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/course/del?ccode=' + check.getCheckValue().ccode;
	}
}
