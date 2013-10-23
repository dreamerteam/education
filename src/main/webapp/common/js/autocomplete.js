/**
 * 数据下拉
 * @param click 鼠标点击是否触发【true：触发；false：不触发】
 * @param obj 数据下拉对象
 * @param items 数据
 * @param valueObj 存值对象
 * @param ilevelObj 等级对象
 * @author broken_xie
 **/
function autoComplete(click, obj, items, valueObj, ilevelObj){
	obj = standard(obj, items, valueObj, ilevelObj); 
	if (click) {
		obj.data("autocomplete").element.unbind("focus.autocomplete")
		.bind("focus.autocomplete click", function(event) {
			var self = $(this).data("autocomplete");
			if (event.type == 'click') self.element.val('');
			if ( self.options.disabled ) return;
			self.previous = self.element.val();
			if ( self.element.val() == '' ) {
				self.selectedItem = null;
				self.search( null, event );
			}
		});
	}
}

function standard(obj, items, valueObj, ilevelObj) {
	return obj.autocomplete({
		minLength : 0,
		source : function(request, response) {
			var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
			response($.grep(items, function(value) {
				return matcher.test(value.value) || (value.pinyin && matcher.test(value.pinyin));
			}));
		},
		select : function(event, ui) {
			$(this).val(ui.item.label);
			valueObj.val(ui.item.value);
			if(null != item.ilevel){
				ilevelObj.val(ui.item.ilevel + 1);
			}
			return false;
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
	}
});