// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 个人信息编辑
 * @param isEdit 是否转换成编辑【0：转换成view；1：转换成edit】
 * @author broken_xie
 **/
function toggleEdit(isEdit){
	if("1" == isEdit) {
		$(".forView").hide();
		$(".forEdit").show();
	} else {
		$(".forEdit").hide();
		$(".forView").show();
	}
}

/**
 * 密码确认校验
 * @auth broken_xie
 * @returns {String}
 */
function confirmPassword(field, rules, i, options){
	if($("#newPsw").val() != field.val()){
		field.val("");
		return options.allrules.alertText = "* 两次输入的密码不一致！";
	}
}

/**
 * 原密码确认校验
 * @auth broken_xie
 * @returns {String}
 */
function validatePsw(field, rules, i, options){
	var result = "";
	$.ajaxSetup({
		async : false
	}); 
	$.post(contextPath + "/manage/personal/validatePsw",{"psw" : field.val()}, function(data){
		result = data.result;
	});
	if("failure" == result){
		field.val("");
		return options.allrules.alertText = "* 原密码错误！";
	}
}

/**
 * 修改密码
 * @author broken_xie
 **/
function updatePsw(){
	$.post(contextPath + "/manage/personal/updatePsw", {"psw" : $("#newPsw").val()}, function(data){
		if("success" == data.result){
			window.location.reload();
		} else {
			alert(data.error);
		}
	});
}