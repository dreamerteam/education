// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

/**
 * 收藏
 * @param 课程id
 * @author broken_xie
 **/
function collect(ucourseid){
	$.post(contextPath + "/web/course/collect", {"ucourseid" : ucourseid}, function(data){
		if("success" == data.result){
			alert("收藏成功");
		} else {
			alert(data.error);
		}
	});
}

/**
 * 上课
 * @param 课程id
 * @author broken_xie
 **/
function select(ucourseid){
	$.post(contextPath + "/web/course/select", {"ucourseid" : ucourseid}, function(data){
		if("success" == data.result){
			window.location.reload();
		} else {
			alert(data.error);
		}
	});
}