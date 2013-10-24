// 获取上下文
contextPath = typeof (contextPath) == "undefined" ? "" : contextPath;

$(function(){
	li.click(function(){
		li.removeClass("active");
		$(this).addClass("active");
	});
});
