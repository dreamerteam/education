/**
 * 数据下拉
 * @param click 鼠标点击是否触发【true：触发；false：不触发】
 * @param obj 数据下拉对象
 * @param items 数据
 * @param valueObj 存值对象
 * @param ilevelObj 等级对象
 * @param parentcodeObj 父级代码对象
 * @author broken_xie
 **/
function autoComplete(click, obj, items, valueObj, ilevelObj, parentcodeObj){
	obj = standard(obj, items, valueObj, ilevelObj, parentcodeObj); 
	if (click) {
		obj.data("autocomplete").element.unbind("focus.autocomplete")
		.bind("focus.autocomplete click", function(event) {
			var self = $(this).data("autocomplete");
			if (event.type == 'click') {
				self.element.val('');
			}
			if ( self.options.disabled ) return;
			self.previous = self.element.val();
			if ( self.element.val() == '' ) {
				self.selectedItem = null;
				self.search( null, event );
			}
		});
	}
}

function standard(obj, items, valueObj, ilevelObj, parentcodeObj) {
	return obj.autocomplete({
		minLength : 0,
		valueObj : valueObj, // 存值对象
		ilevelObj : ilevelObj, // 等级对象
		parentcodeObj : parentcodeObj, // 父级代码对象
		source : function(request, response) {
			var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
			response($.grep(items, function(value) {
				return matcher.test(value.label) || (value.pinyin && matcher.test(value.pinyin));
			}));
		},
		select : function(event, ui) {
			$(this).val(ui.item.label);
			if(typeof valueObj != "undefined") valueObj.val(ui.item.value);
			if(null != ui.item.ilevel && typeof ilevelObj != "undefined") ilevelObj.val(ui.item.ilevel + 1);
			if(null != ui.item.ccode && typeof parentcodeObj != "undefined") parentcodeObj.val(ui.item.ccode);
			return false;
		},
		clear : function(event){
			if(typeof valueObj != "undefined") valueObj.val('');
			if(typeof ilevelObj != "undefined") ilevelObj.val(0);
			if(typeof parentcodeObj != "undefined") parentcodeObj.val('');
		}
	});
}

$.widget("dreamer.autocomplete", $.ui.autocomplete, {
	__response : function(content) {
		if (!this.options.disabled && content && content.length) {
			content = this._normalize(content);
			this._suggest(content);
			this._trigger("open");
		} else {
			this.element.val(''); //
			this.close();
		}
	},
	
	_renderItem: function( ul, item ) {
		var space = 0;
		if(null != item.ilevel){
			space = item.ilevel;
		}
		return $( "<li>" )
			.append( $( "<a style='padding-left:"+space+"em'>" ).text( item.label ) )
			.appendTo( ul );
	},
	
	_change: function( event ) {
		if("" == this._value()){
			this._trigger( "clear", event);
		}
		if ( this.previous !== this._value() ) {
			this._trigger( "change", event, { item: this.selectedItem } );
		}
	}
});
