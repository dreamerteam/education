<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/tags.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Demo</title>
<%-- <link rel="stylesheet" type="text/css" href="${contextPath }/common/css/base.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/css/content.css" /> --%>
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery.ui.all.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/jquery-ui-timepicker-addon.css" />
<link rel="stylesheet" type="text/css" href="${contextPath }/common/jquery/jquery-ui/themes/demos.css" />
<%-- <link rel="stylesheet" type="text/css" href="${contextPath }/common/bootstrap/css/bootstrap.css" /> --%>
</head>
<body>
<!-- <input id="tags"/>
<input type="checkbox" value="sssssss" id="check" checked="checked" /> -->
<input type="text" id="timePicker"/>
<form>
	<div id="radio">
		<input type="radio" id="radio1" name="radio" /><label for="radio1">Choice 1</label>
		<input type="radio" id="radio2" name="radio" checked="checked" /><label for="radio2">Choice 2</label>
		<input type="radio" id="radio3" name="radio" /><label for="radio3">Choice 3</label>
	</div>
</form>
</body>
<!-- <script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.min.js"></script> -->
<!-- <script type="text/javascript" src="http://code.jquery.com/ui/1.10.3/jquery-ui.min.js"></script> -->
<script type="text/javascript" src="${contextPath }/common/jquery/jquery.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery-ui.custom.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery-ui-sliderAccess.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery-ui-timepicker-addon.js" ></script>
<%-- <script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.position.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.menu.js" ></script>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.autocomplete.js" ></script>
<script type="text/javascript" src="${contextPath }/common/js/autocomplete.js" ></script> --%>
<script type="text/javascript" src="${contextPath }/common/jquery/jquery-ui/jquery.ui.button.js" ></script>

<%-- <script type="text/javascript" src="${contextPath }/common/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript" src="${contextPath }/common/bootstrap/js/html5shiv.js" ></script>
<script type="text/javascript" src="${contextPath}/autoComplete/courseType" ></script> --%>
<script type="text/javascript">
$(function() {
	$('#timePicker').datetimepicker({
		dateFormat: 'yy-mm-dd',
	    timeFormat: 'HH:mm'});
	/* $( "#radio" ).buttonset();
	$.post("${contextPath}/demo/test2",function(data){
		console.log(data);
		alert(data.clogin);
	});
	$("#check").removeAttr("checked");
	$("#check").attr("checked","checked");
	
	var availableTags = [
	                     "ActionScript",
	                     "AppleScript",
	                     "Asp",
	                     "BASIC",
	                     "C",
	                     "C++",
	                     "Clojure",
	                     "COBOL",
	                     "ColdFusion",
	                     "Erlang",
	                     "Fortran",
	                     "Groovy",
	                     "Haskell",
	                     "Java",
	                     "JavaScript",
	                     "Lisp",
	                     "Perl",
	                     "PHP",
	                     "Python",
	                     "Ruby",
	                     "Scala",
	                     "  Scheme"
	                   ]; */
	                   /* $( "#tags" ).autocomplete({
 	                     source: "${contextPath}/demo/test" 
	                     source: function( request, response ) {
	                         var matcher = new RegExp( "^" + $.ui.autocomplete.escapeRegex( request.term ), "i" );
	                         console.log(matcher);
	                         response( $.grep( courseType, function( item ){
	                        	 console.log(item);
	                             return matcher.test( item );
	                         }) );
	                     }
	                   }); */
	                   /* autoComplete(true, $("#tags"), courseType); */
});
</script>
</html>