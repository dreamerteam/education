// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 查看
 * @author broken_xie
 **/
function view(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/resource/view?uuid=' + check.getCheckValue().uuid;
	}
}

/**
 * 设置免费
 * @param f 免费【0：非免费；1：免费】
 * @author broken_xie
 **/
function free(f){
	if(check.verifyCheck()){
		var o = check.getCheckValue();
		var uuid = o.uuid;
		var free = o.free;
		if(f == free){
			var str = "1" == f ? "免费" : "非免费";
			alert("该资源目前已为" + str + "状态");
		} else {
			var params = {};
			params["uuid"] = uuid;
			params["free"] = f;
			$.post(contextPath + '/resource/free', params, function(data){
				if("success" == data.result){
					window.location.reload();
				} else {
					alert("操作失败，请稍后再试");
				}
			});
		}
	}
}

/**
 * 视频链接修改触发事件
 * @param obj 对象
 * @author broken_xie
 **/
function changeVideo(obj) {
	if("" === obj.value) {
		$("#video").hide();
	} else {
		$("#video").hide();
		$("#video embed").attr("src", obj.value);
		$("#video").show();
	}
}