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

/**
 * 重新加载页面
 * @param url 对象
 * @param url 地址
 * @author broken_xie
 **/
function reloadPage(obj, url){
	obj.load(url);
}

/**
 * 从身份证获取出生日期
 * @param {} idCard 身份证
 * @author broken_xie
 */
function getBirthdayByIDCard(idCard) {
	var len = idCard.length;
	if (len == 0) {
		return "";
	} else if (len == 15) {
		return "19" + idCard.substr(6, 2) + "-" + idCard.substr(8, 2) + "-" + idCard.substr(10, 2);
	} else if (len == 18) {
		return idCard.substr(6, 4) + "-" + idCard.substr(10, 2) + "-" + idCard.substr(12, 2);
	}
}


/**
 * 从身份证获取性别
 * @param {} idCard 身份证
 * @author broken_xie
 */
function getSexByIDCard(idCard) {
	var len = idCard.length;
	if (len == 0) {
		return "";
	} else if (len == 15) {
		return idCard.substr(14, 1) % 2 ? "男" : "女";
	} else if (len == 18) {
		return idCard.substr(16, 1) % 2 ? "男" : "女";
	}
}