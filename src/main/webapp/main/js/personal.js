// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 个人信息编辑
 * @author broken_xie
 **/
function toggleEdit(){
	$(".forView").hide();
	$(".forEdit").show();
}