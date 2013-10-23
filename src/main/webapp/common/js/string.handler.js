
/**
 * 字符串去掉前后空格
 * @author broken_xie
 **/
String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

/**
 * 字符串转HTML代码
 * @author broken_xie
 **/
String.prototype.convertToHTML = function() {
	return this.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
			.replaceAll(" ", "&nbsp;").replaceAll("	", "&nbsp;&nbsp;")
			.replaceAll("'",	"&#39;").replaceAll("\"", "&quot;")
			.replaceAll("\r\n", "<br/>").replaceAll("\r", "<br/>")
			.replaceAll("\n", "<br/>");
};

/**
 * 获得字符的字节长度（兼容oracle）【oracle一个中文字符等于三个字节】
 * @author broken_xie
 **/
String.prototype.getBytesLength = function() {
	var reg = /[^\x00-\xff]/g;
	return this.replace(reg, "***");
};

/**
 * 使用s2替换s1字符串
 * @param s1 需要替换的原字符串
 * @param s2 替换后的字符串
 * @author broken_xie
 **/
String.prototype.replaceAll = function(s1, s2) {
	return this.replace(new RegExp(s1, "gm"), s2);
};

/**
 * 是否包含某字符串
 * @param str 自定字符串
 * @author broken_xie
 **/
String.prototype.contains = function(str) {
	return this.indexOf(str) >= 0;
};

/**
 * 将字符串转换成指定字符串（）
 * @param src 原字符串
 * @param des 目的字符串
 * @author broken_xie
 **/
function defaultStr(src, des) {
	return src == null || src.trim() == "" ? (typeof(des) == "undefined" ? "" : des) : src;
}

/**
 * 将数字串转换整数，如果字符串不是数字则返回0
 * @param str 字符串
 * @author broken_xie
 **/
function str2Int(str) {
	return !(str+"").isInteger() ? 0 : parseInt(str, 10);
}

/**
 * 将数字串转换浮点数，如果字符串不是数字则返回0
 * @param str 字符串
 * @author broken_xie
 **/
function str2Float(str) {
	return !(str+"").isFloat() ? 0 : parseFloat(str);
}

