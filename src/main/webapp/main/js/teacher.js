// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 密码确认校验
 * @auth broken_xie
 * @returns {String}
 */
function confirmPassword(field, rules, i, options){
	if($("#cpassword").val() != field.val()){
		field.val("");
		return options.allrules.alertText = "* 两次输入的密码不一致！";
	}
}

/**
 * 查看
 * @author broken_xie
 **/
function view(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/teacher/view?uuid=' + check.getCheckValue();
	}
}

/**
 * 修改
 * @author broken_xie
 **/
function edit(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/teacher/edit?uuid=' + check.getCheckValue();
	}
}
