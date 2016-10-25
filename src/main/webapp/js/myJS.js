/**
 * 鼠标停留离开改变颜色
 */

$(document).ready(function(){
	
	$("tr:not(.title)").live('mouseenter',function(){
		$(this).css("background-color", "#66CCFF");
	}).live('mouseleave',function(){
		$(this).css("background-color", "#D8D8D8");
	});
	
});


