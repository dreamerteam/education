/**
 * 根据指定的格式格式化日期成为字符串
 * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
 * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
 * eg:
 * (new Date()).format("yyyy-MM-dd hh:mm:ss.S") ==> 2013-10-21 08:09:04.423
 * (new Date()).format("yyyy-MM-dd E HH:mm:ss") ==> 2013-10-21 二 20:09:04
 * (new Date()).format("yyyy-MM-dd EE hh:mm:ss") ==> 2013-10-21 周二 08:09:04
 * (new Date()).format("yyyy-MM-dd EEE hh:mm:ss") ==> 2013-10-21 星期二 08:09:04
 * (new Date()).format("yyyy-M-d h:m:s.S") ==> 2013-10-21 8:9:4.18
 * 
 * @param fmt 格式化字符串
 * @author broken_xie
 */
Date.prototype.format = function(fmt) {
	var o = {
		"M+" : this.getMonth() + 1, // 月份
		"d+" : this.getDate(), // 日
		"h+" : this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, // 小时
		"H+" : this.getHours(), // 小时
		"m+" : this.getMinutes(), // 分
		"s+" : this.getSeconds(), // 秒
		"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
		"S" : this.getMilliseconds() // 毫秒
	};
	var week = {
		"0" : "\u65e5",
		"1" : "\u4e00",
		"2" : "\u4e8c",
		"3" : "\u4e09",
		"4" : "\u56db",
		"5" : "\u4e94",
		"6" : "\u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f" : "\u5468") : "") + week[this.getDay() + ""]);
	}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
};


/**
 * 将日期字符串转换成日期
 * 支持格式:
 * 1.yyyy-MM-dd
 * 2.yyyy/MM/dd
 * 3.MM-dd-yyyy
 * 4.MM/dd/yyyy
 * 5.MM-dd-yy 该格式年份为19yy
 * 6.MM/dd/yy 该格式年份为19yy
 * @param dateStr 日期字符串
 * @author broken_xie
 **/
function toDate(dateStr) {
	try {
		if (/(^\d{4}([\-\/]\d{1,2}){2}$)|(^(\d{1,2}[\-\/]){2}\d{2,4}$)/.test(dateStr)) {
			return new Date(dateStr.replaceAll("-", "/"));
		} else {
			return null;
		}
	} catch (e) {
		alert("toDate:" + e.message);
	}
}