// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

$(function(){
	setInterval(setTime, 1000);
	li.click(function(){
		li.removeClass("active");
		$(this).addClass("active");
	});
	reloadLeft("left_home");
});

/**
 * 设置时间
 * @author broken_xie
 **/
function setTime(){
	$("#time").text(new Date().format("yyyy年MM月dd日 hh:mm:ss"));
}

/**
 * 重新加载左侧页面
 * @param page 左侧页面名称
 * @author broken_xie
 **/
function reloadLeft(page){
	left.load(contextPath + '/page/main/'+page);
}

/**
 * 重新加载主页面
 * @param url 地址
 * @author broken_xie
 **/
function reloadMain(url){
	main.load(url);
}