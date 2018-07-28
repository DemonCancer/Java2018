// JavaScript Document
$(document).ready(function(){
	$("#logo").hide();
	$("#logo").show(2000);
	$("#videolist-ul").hide();
	$("#videolist-ul").slideDown(2000);
	$("#model-under").hide();
	$("#model-video").hide();
	//alert($(document).scrollTop());
	$("img").click(function(){
		//alert();
		var id=$(this).attr("id").toString();
		var dh=$(window).height();
		var dw=$(window).width();
		
		$("#model-under").width(dw);
		$("#model-under").height(dh);
		$("#model-under").slideDown(600);
		$("video").attr("src","video/"+id+".mp4");
		$("#model-video").slideDown(1000);
		
	});
	$("#close-img").click(function(){
		$("#model-under").hide();
		$("video").attr("src","");
		$("#model-video").hide();
	});
	$("#model-under")
	.click(function(){
		$("#model-under").hide();
		$("video").attr("src","");
		$("#model-video").hide();
	});
	
	
});
$(window).resize(function(){
	var dh=$(window).height();
		var dw=$(window).width();
		//alert(dh+""+dw);
		$("#model-under").width(dw);
		$("#model-under").height(dh);
});