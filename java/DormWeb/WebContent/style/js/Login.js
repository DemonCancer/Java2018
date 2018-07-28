new WOW().init();
$(document).ready(function(){
	$("#bgimg").hide();
	var dh=$(window).height();
	var dw=$(window).width();
	////
	$("input[type='radio']").click(function(){
		//alert($(this).val());
	});
	$("#btnlogin").click(function(){
	});
	if($("#msg").html()=="null"){
		$("#msg").hide();
	}
	
	
	
});
$(window).resize(function(){
	$("#bgimg").hide();
	var dh=$(window).height();
	var dw=$(window).width();
	
	
});


$(function(){
	
	//点击登录
	$("#btnlogin").click(function(){
		
		var userName = $("#userName").val();
		var password = $("#password").val();
		//alert(userName+password);
		$("#msg").hide(300);
		//验证
		if(userName.length==0 || password.length==0){
			$("#msg").html("*请正确填写！*");
			$("#msg").show(300);
			return ;
		}
		else if(userName.length<3){
			$("#msg").html("*用户名不能少于三位！*");
			$("#msg").show(300);
			return ;
		}
		else if(password.length<3){
			$("#msg").html("*密码不能少于三位！*");
			$("#msg").show(300);
			return ;
		}
		$("form").submit();
		
		
	});
})
