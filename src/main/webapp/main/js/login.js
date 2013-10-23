// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

$(function(){
	/*验证码*/
	if(captchaImg){
		reloadCaptcha(); // 验证码初始化
		captchaImg.click(function(){ // 验证码点击事件
			reloadCaptcha();
		});
		captchaImg.show();
	}
	/*登录表单*/
	$("#loginForm").validationEngine({
		promptPosition : 'bottomRight',
		ajaxFormValidation : true,
		ajaxFormMethod : 'POST',
		ajaxFormValidationURL : contextPath + '/login/validate',
		onBeforeAjaxFormValidation: function(form, options) {
			/* submitBtn.removeClass().addClass('operateBtnPre').attr("disabled", "disabled"); // 禁用保存按钮，防止重复提交表单
			backBtn.removeClass().addClass('operateBtnPre').attr('disabled', 'disabled'); */
		},
		onAjaxFormComplete: function(status, form, json, options) {
			/* if (status) {
				form.validationEngine('detach').submit();
			} else {
				submitBtn.removeClass().addClass('operateBtn').removeAttr("disabled");
				backBtn.removeClass().addClass('operateBtn').removeAttr("disabled");
			} */
		}
	}); 
});

/**
 * 重新生成验证码
 * @author broken_xie
 **/
function reloadCaptcha(){
	var now = new Date();
	captchaSessionID.val(now);
	document.getElementById("captchaImg").src = contextPath + "/captcha/"+ now;
}


