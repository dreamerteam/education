// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

$(function(){
	setInterval(setTime, 1000);
	li.click(function(){
		li.removeClass("active");
		$(this).addClass("active");
	});
});

/**
 * 设置时间
 * @author broken_xie
 **/
function setTime(){
	$("#time").text(new Date().format("yyyy年MM月dd日 hh:mm:ss"));
}