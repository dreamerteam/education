/**
 * 验证是否是整数
 * @author broken_xie
 */
String.prototype.isInteger = function() {
	var regx = /^[-]?\d+$/;
	return regx.test(this);
};

/**
 * 验证是否是正整数
 * @author broken_xie
 */
String.prototype.isUInteger = function() {
	var regx = /^\d+$/;
	return regx.test(this);
};

/**
 * 验证是否是浮点数
 * @author broken_xie
 */
String.prototype.isFloat = function() {
	var regx = /^[-]?\d+(\.\d+)?$/;
	return regx.test(this);
};

/**
 * 验证是否是正浮点数
 * @author broken_xie
 */
String.prototype.isUFloat = function() {
	var regx = /^\d+(\.\d+)?$/;
	return regx.test(this);
};

/**
 * 验证是否包含中文字符
 * @author broken_xie
 */
String.prototype.hasChinese = function() {
	var regx = /[\u4E00-\u9FA5\uF900-\uFA2D]/;
	return regx.test(this);
};

/**
 * 验证是否是邮箱地址
 * @author broken_xie
 */
String.prototype.isEmail = function() {
	var regx = /^[a-zA-Z0-9]+([\.\-_][a-zA-Z0-9]+)*@([a-zA-Z0-9]+[\.\-_]?)+[a-zA-Z0-9]+\.[A-Za-z]{2,5}$/;
	return regx.test(this);
};

/**
 * 验证是否是身份证
 * @param idCard 身份证
 * @author broken_xie
 */
function isIDCard(idCard) {
	if (null == card)
		return false;
	var xx = [2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7];
	var yy = ['1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'];
	var mm = 0;
	if (card.length == 15) {
		if (isBirthday(card)) {
			return true;
		} else {
			return false;
		}
	} else if (card.length == 18) {
		var gg = new Array;
		for (var i = 1; i < 18; i++) {
			var j = 17 - i;
			gg[i - 1] = parseInt(card.substring(j, j + 1), 10);
		}
		for (var i = 0; i < 17; i++) {
			mm += xx[i] * gg[i];
		}
		mm = mm % 11;
		var c = card.charAt(17);
		if (c.toUpperCase() == yy[mm] && isNewBirthday(card))
			return true;
		else
			return false;
	} else {
		return false;
	}
}