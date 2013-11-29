// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 密码确认校验
 * @auth broken_xie
 * @returns {String}
 */
function confirmPassword(field, rules, i, options){
	if($("#regPsw").val() != field.val()){
		field.val("");
		return options.allrules.alertText = "* 两次输入的密码不一致！";
	}
}

/**
 * 重新生成验证码
 * @author broken_xie
 **/
function reloadCaptcha(){
	var now = new Date();
	document.getElementById("captchaImg").src = contextPath + "/captcha?time="+ now;
}