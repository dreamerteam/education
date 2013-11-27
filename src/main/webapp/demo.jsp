<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Demo</title>
</head>
<body>
	<input id="fileupload" type="file" name="fileupload"/>
	<input id="f" type="file" name="f" />
	<img src="" width="200px" height="200px" class="img-rounded">
</body>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-1.8.3.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.core.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.widget.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.position.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.menu.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-file-upload/js/jquery.fileupload.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-file-upload/js/jquery.iframe-transport.js"></script>
<script type="text/javascript">
$(function () {
	$('#fileupload').change(function(e){
		var $this = $(this);
		$('#f').fileupload({
	    	url : "${contextPath}/demo/getImg",
	    	fileInput: $this, 
	        done: function (e, data) {
	        	$("img").attr("src", "data:image/png;base64," + data.result);
	        }
	    });
	});
		/* $('#f').fileupload({
	    	url : "${contextPath}/demo/getImg",
	        add : function (e, data) {
	        	alert("ss");
	        	this.fileInput = $(this);
	        	console.log(this.fileInput);
	            data.submit();
	        },
	        done: function (e, data) {
	        	$("#courseImgShow img").attr("src", "data:image/png;base64," + data.result);
	            $("#courseImgShow").show();
	            this.fileInput = $(this);
	        }
	    }); 
	}); 
	$('#fileupload').bind('change', function (e) {
	    $('#f').fileupload('add', {
	        fileInput: $(this)
	    });
	}); */
}); 
</script>
</html>