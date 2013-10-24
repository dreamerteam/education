// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 修改
 * @author broken_xie
 **/
function edit(){
	if(check.verifyCheck()){
		$.post(contextPath +'/courseType/edit', {"uuid" : check.getCheckValue()});
	}
}
