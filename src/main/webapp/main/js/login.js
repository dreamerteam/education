// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 重新生成验证码
 * @author broken_xie
 **/
function reloadCaptcha(){
	var now = new Date();
	document.getElementById("captchaImg").src = contextPath + "/captcha?time="+ now;
}


