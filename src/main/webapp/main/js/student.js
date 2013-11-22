// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 查看
 * @author broken_xie
 **/
function view(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/manage/student/view?uuid=' + check.getCheckValue();
	}
}