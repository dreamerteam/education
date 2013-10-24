var width = document.body.scrollWidth;
var height = document.body.scrollHeight;
var topHeight = $("#topFrame").attr("height");

$(function(){
	topHeight = topHeight.substring(0, topHeight.length-2);
	setHeight(height, topHeight);
	$(window).resize(function(){
		setHeight(height, topHeight);
	});
});

/**
 * 设置高度
 * @param height 浏览器全文高度
 * @param topHeight topFrame高度
 * @author broken_xie
 **/
function setHeight(height, topHeight){
	var h = (height - topHeight) + "px";
	$("#leftFrame").attr("height", h);
	$("#mainFrame").attr("height", h);
}