// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 修改
 * @author broken_xie
 **/
function edit(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/course/edit?uuid=' + check.getCheckValue().uuid;
	}
}

/**
 * 查看
 * @author broken_xie
 **/
function view(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/course/view?uuid=' + check.getCheckValue().uuid;
	}
}

/**
 * 启用/停用
 * @param status 状态【0：停用；1：启用】
 * @author broken_xie
 **/
function start(status){
	if(check.verifyCheck()){
		var o = check.getCheckValue();
		if(o.cstatus == status){
			if('1' == status) alert("该课程已启用");
			else if('0' == status) alert("该课程已停用");
		} else {
			window.location.href = contextPath + '/course/start?uuid=' + o.uuid + '&cstatus=' + status;
		}
	}
}

/**
 * 提交审核
 * @param caudit 下一审核状态
 * @author broken_xie
 **/
function audit(caudit){
	if(check.verifyCheck()){
		var o = check.getCheckValue();
		if("10" == caudit && "0" == o.cstatus){
			alert("请先启用该课程再提交审核");
			return;
		}
		window.location.href = contextPath + '/course/changeAudit?uuid=' + o.uuid + '&caudit=' + caudit;
	}
}

/**
 * 审核
 * @author broken_xie
 **/
function toAudit(){
	if(check.verifyCheck()){
		window.location.href = contextPath + '/course/view?uuid=' + check.getCheckValue().uuid + '&op=audit';
	}
}

/**
 * 设置开课时间
 * @param copen 是否开课【0：待开课；1：开课】
 * @author broken_xie
 **/
function opens(copen){
	if(check.verifyCheck()){
		var o = check.getCheckValue();
		if(copen == o.open){
			if("1" == copen) alert("该课程已开课，无法继续开课");
			else alert("该课程已停课，无法继续停课");
			return;
		} else {
			$("#uuid").val(o.uuid);
			$("#openCourse").modal('show');
		}
	}
}

/**
 * 开课
 * @author broken_xie
 **/
function openCourse(){
	var params = {};
	params["uuid"] = $("#uuid").val();
	params["dlession"] = $("#dlession").val();
	$.post(contextPath + "/course/open", params, function(data){
		if("success" == data.result){
			window.location.reload();
		} else {
			alert("操作失败，请稍后再试");
		}
	});
}
