function autoComplete(click, obj, items, nextObj, nextType){
	if (nextObj)
		obj = advance(obj, items, nextObj, nextType);
	else
		obj = standard(obj, items); 
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

function standard(obj, items) {
	return obj.autocomplete({
		minLength : 0,
		source : function(request, response) {
			var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
			response($.grep(items, function(value) {
				return matcher.test(value.value) || (value.pinyin && matcher.test(value.pinyin));
			}));
		}
	});
}

function advance(obj, items, nextObj, nextType) {
	return obj.autocomplete({
		minLength : 0,
		source : function(request, response) {
			var matcher = new RegExp($.ui.autocomplete.escapeRegex(request.term), "i");
			response($.grep(plat, function(value) {
				return matcher.test(value.value) || (value.pinyin && matcher.test(value.pinyin));
			}));
		},
		select : function(event, ui) {
			$(this).val(ui.item.value);
			$.get(contextPath + "/autocomplete?type="+nextType+"&isjson=1&param=" + encodeURIComponent(ui.item.value), function(source){
				nextObj.data("autocomplete").options.source = eval("("+source+")");
				nextObj.data("autocomplete")._initSource();
			});
			return false;
		}
	});
}

$.widget("info.autocomplete", $.ui.autocomplete, {
	__response : function(content) {
		if (!this.options.disabled && content && content.length) {
			content = this._normalize(content);
			this._suggest(content);
			this._trigger("open");
		} else {
			this.element.val(''); // 强制匹配
			this.close();
		}
	}
});