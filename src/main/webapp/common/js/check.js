/**
 * 检查列表CheckBox是否正确选择及获得值控件
 * 依赖jquery,common库
 * 
 * @param {} options
 * 		- checkName#String : checkbox的name值，默认"check"。全选框的name值应设为该参数值+All，如默认值则全选框值为"checkAll"
 * 		- multiple#Boolean : 是否支持多选，默认false
 * 		- multipleValue#Array<String> : 当checkbox的值包含多个值的时候，使用拆分符号(splitChar)隔开
 * 										并按顺序以该字符串数组参数的对应下标值为属性名称，并存为一个Object
 * 										当该参数为null时，则始终认为checkbox值只有一个，默认为null
 * 		- splitChar#String : checkbox多值时的拆分符号，默认为","
 * 		- lineSelected#Boolean : 是否开启左键行选择，默认true
 * 		- contextMenu : 右键控件绑定参数，默认为null不绑定
 * 						参数类型：object，右键控件参数对象，包括
 * 								{
 * 									menu:     元素集合，每个元素都是一个对象,必须
 * 									[{
 * 										name: 元素名称（必须）
 * 										action： 元素点击事件（必须）
 * 										separator： boolean 是否有分割线
 * 										imgSrc：<img/>的SRC，当前按钮的图标URL
 * 										iconCls：<i/>的class，当前按钮基于i标签的图标样式，与imgSrc之间只能配置一个
 * 										children：子元素集合，同menu
 * 									}],
 * 									lineSelected: true,				是否开启右键行选择，默认true
 *									onShow: function() {},			当弹出层显示时触发的事件
 *									onSelect: function(e) {},		当弹出层的选项被选中时额外触发的事件
 *									onLoad: function() {},			当弹出层加载时触发的事件
 *									onHide: function() {}			当弹出层隐藏时触发的事件
 * 								}
 * 
 * @method verifyCheck 验证checkbox的选择是否符合要求，调用getCheckValue()方法前必须调用的方法
 * 		- @param isMultiple#Boolean : 可选，是否验证多选，当options.multiple=true时，该参数起效，且默认为true。false-验证单选
 * 		- @return Boolean
 * @method getCheckValue 获得选项框的值。请勿在调用过verifyCheck()方法后反复调用该方法，以免降低性能，同时会产生警告提示
 * 		- @param valueAttr#String : 可选，返回所选值在multipleValue参数配置中的valueAttr属性
 * 		- @param isArrayValue#Boolean : 可选，是否以数组形式返回多选的值，当multiple=true时，该参数起效，且默认为true。false-返回单个值或对象
 * 		- @return {String|Object|Array}
 * 				String: 当返回结果为非数组且multipleValue=null或valueAttr参数启用时的返回值类型
 * 				Object: 当返回结果为非数组且multipleValue有对象值，valueAttr参数未启用时的返回值类型
 * 				Array: 当返回结果为数组时的返回值类型。当multipleValue=null或valueAttr参数启用时，数组为String数组，否则为Object数组
 * 
 * @example
 * 		html: 
 * 			<input type="checkbox" name="check1" value="646DC9D3-632F-4800-B2CC-80F0E4D570A2,1,1,0" />
 * 		init: 
 * 			var check;
 * 			$(function(){
 * 				check = new InitCheck({checkName:'check1', multipleValue:["uid", "read", "edit", "delete"]});
 * 			});
 * 		call:
 * 			if (check.verifyCheck()) {
 * 				var o = check.getCheckValue();
 * 				alert(o.uid);
 * 				alert(o.read);
 * 				...
 * 			}
 * 
 */

function InitCheck(options) {
	/**
	 * 默认值
	 * @type Object
	 */
	this.defaults = {
		checkName : "check",
		multiple : false,
		multipleValue : null,
		splitChar: ",",
		lineSelected: true,
		contextMenu : null
	};
	
	/**
	 * 当前已选的checkbox对象数组
	 * @type Array
	 */
	this.checked = null;
	
	var $this = this;

	$.extend(this.defaults, options);
	
	/**
	 * 所有需要处理的选择框对象
	 * @type Object JQuery
	 */
	this.checkboxs = $("input[name=" + this.defaults.checkName + "]");
	
	if (this.defaults.lineSelected) { // 是否启用左键行选择
		if (this.defaults.multiple) {
			// 为全选框添加全选事件
			$("input[name=" + this.defaults.checkName + "All]").click(function(){
				var $t = $(this);
				if ($t.is(":checked")) {
					$this.checkboxs.attr("checked", "checked");
				} else {
					$this.checkboxs.removeAttr("checked");
				}
			});
		}
		this.checkboxs.click(function(){invertSelect(this)});
		this.checkboxs.parentsUntil("tr").parent().click(function(){
			this.checked = $(this).find(":checkbox");
			invertSelect(this.checked);
			if (!$this.defaults.multiple) {
				singleCheck($this, this.checked);
			} else {
				resetChecked($this);
			}
		});
	} else {
		if (!this.defaults.multiple) {
			this.checkboxs.click(function(){singleCheck($this, this)});
		} else {
			this.checkboxs.click(function(){resetChecked($this, this)});
			$("input[name=" + this.defaults.checkName + "All]").click(function(){
				var $t = $(this);
				if ($t.is(":checked")) {
					$this.checkboxs.attr("checked", "checked");
				} else {
					$this.checkboxs.removeAttr("checked");
				}
			});
		}
	}
	
	if (this.defaults.contextMenu && this.checkboxs.length > 0 && (!$.browser.msie || $.browser.version > 7)) { // 判断是否启用右键控件
		var m = this.defaults.contextMenu;
		if (m.menu) {
			this.checkboxs.parents("tr").contextMenu({
				menu : m.menu,
				onShow : function() {
					if (m.lineSelected != false) {
						this.checked = $(this).find(":checkbox");
						if (!this.checked.is(":checked")) {
							$this.checkboxs.removeAttr("checked");
							this.checked.attr("checked", "checked");
						}
					}
					if (m.onShow) m.onShow.call(this);
				},
				onSelect : function(e) {
					if (m.onSelect) {
						m.onSelect.call(this, e);
					} else {
						eval(e);
					}
				},
				onLoad : function() {
					if (m.onLoad) m.onLoad.call(this);
				},
				onHide : function() {
					if (m.onHide) m.onHide.call(this);
				}
			});
		}
	}
	
	/**
	 * 单选方法，multiple=false时使用
	 */
	function singleCheck($t, o) {
		$o = $(o);
		if ($o.is(":checked")) {
			$t.checkboxs.removeAttr("checked");
			$o.attr("checked", "checked");
		}
		resetChecked($t);
	}
	
	/**
	 * 重设checked值，当checbox被选择时必须调用
	 */
	function resetChecked($t) {
		$t.checked = null;
	}
	
	/**
	 * 反选checkbox
	 */
	function invertSelect(o) {
		$o = $(o);
		if ($o.is(":checked")) {
			$o.removeAttr("checked");
		} else {
			$o.attr("checked", "checked");
		}
	}
	
	/**
	 * 初始化初始化对象属性方法
	 */
	if (!InitCheck._initialized) {
		$.extend(InitCheck.prototype, {
			/**
			 * 验证checkbox的选择是否符合要求，调用getCheckValue()方法前必须调用的方法
			 * @param {} isMultiple#Boolean 是否验证多选，当multiple=true时，该参数起效，且默认为true。false-验证单选
			 * @return {Boolean}
			 */
			verifyCheck: function(isMultiple) {
				this.checked = this.checkboxs.filter(":checked");
				if (this.checked.length == 0) {
					if (this.defaults.multiple) {
						isMultiple = isMultiple != false;
					}
					alert("提示:您必须选择" + (this.defaults.multiple && isMultiple ? "至少" : "") + "一条记录，才能执行当前操作！");
					return false;
				} else if (this.checked.length > 1 && (!this.defaults.multiple || isMultiple == false)) {
					alert("提示:您只能选择一条记录执行当前操作！");
					return false;
				} else if (this.defaults.multipleValue != null && this.defaults.multipleValue instanceof Array 
						&& this.checked.val().split(this.defaults.splitChar).length != this.defaults.multipleValue.length) {
					alert("错误：multipleValue与选项值不对应！");
					return false;
				}
				return true;
			},
			
			/**
			 * 获得选项框的值
			 * @param {} valueAttr#String 可选，返回所选值在multipleValue参数配置中的valueAttr属性
			 * @param {} isArrayValue#Boolean 可选，是否以数组形式返回多选的值，当multiple=true时，该参数起效，且默认为true。false-返回单个值或对象
			 * @return {String|Object|Array}
			 * 		String: 当返回结果为非数组且multipleValue=null或valueAttr参数启用时的返回值类型
			 * 		Object: 当返回结果为非数组且multipleValue有对象值，valueAttr参数未启用时的返回值类型
			 * 		Array: 当返回结果为数组时的返回值类型。当multipleValue=null或valueAttr参数启用时，数组为String数组，否则为Object数组
			 * 
			 */
			getCheckValue: function(valueAttr, isArrayValue) {
				if (this.checked == null) {
					alert("警告：调用getCheckValue()方法前未调用verifyCheck()进行验证！请勿在调用verifyCheck()后反复调用getCheckValue()方法");
					this.checked = this.checkboxs.filter(":checked");
				}
				if (typeof(valueAttr) == 'boolean') { // 当valueAttr未设置，isArrayValue被设置时的条件处理
					isArrayValue = valueAttr != false;
					valueAttr = '';
				};
				valueAttr = typeof(valueAttr) == 'undefined' ? '' : valueAttr;
				isArrayValue = isArrayValue != false;
				var valueIndex = -1;
				if (valueAttr != '') {
					$.each(this.defaults.multipleValue, function(i, e) {
						if(e == valueAttr) {
							valueIndex = i;
							return false;
						}
					});
					if (valueIndex == -1) {
						alert("参数值" + valueAttr + "不在指定属性[" + this.defaults.multipleValue + "]中！");
					}
				}
				if (this.defaults.multiple && isArrayValue) {
					var val = new Array(this.checked.length);
					if (this.defaults.multipleValue == null) { // 返回String数组
						$.each(this.checked, function(i, e) { val[i] = e.value; });
					} else { // 返回Object数组
						if (valueIndex > -1) {
							$.each(this.checked, (function(i, e) {
								var multiValue = e.value.split(this.defaults.splitChar);								
								val[i] = multiValue[valueIndex];
							}).domain(this));
						} else {
							$.each(this.checked, (function(i, e) {
								var multiValue = e.value.split(this.defaults.splitChar);
								var vo = {};
								for (var j = this.defaults.multipleValue.length - 1 ; j >= 0; j--) {
									vo[this.defaults.multipleValue[j]] = multiValue[j];
								}
								val[i] = vo;
							}).domain(this));
						}
					}
					resetChecked(this);
					return val;
				} else {
					if (this.defaults.multipleValue == null) { // 返回String
						var val = this.checked.val();
						resetChecked(this);
						return val;
					} else { // 返回Object
						var multiValue = this.checked.val().split(this.defaults.splitChar), val;
						if (valueIndex > -1) {
							val = multiValue[valueIndex];
						} else {
							var vo = {};
							for (var j = this.defaults.multipleValue.length - 1 ; j >= 0; j--) {
								vo[this.defaults.multipleValue[j]] = multiValue[j];
							}
							val = vo;
						}
						resetChecked(this);
						return val;
					}
				}
			}
		});
		InitCheck._initialized = true;
	}
}