// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

function edit(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/course/edit?uuid=' + check.getCheckValue();
	}
}

function view(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/course/view?uuid=' + check.getCheckValue();
	}
}

function del(){
	if(check.verifyCheck()){
		alert(contextPath + '/course/del?uuid=');
		window.location.href = contextPath + '/course/del?uuid=' + check.getCheckValue();
	}
}
