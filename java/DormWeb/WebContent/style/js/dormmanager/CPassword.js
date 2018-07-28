$(document).ready(function(){
	$("#right_container").hide();
	$("#right_container").slideDown(1500);
	if($("#msg").html()=="null"){
			$("#msg").hide();
	}
	$("#btneditpwd").click(function(){
			
			var ppwd = $("#ppwd").val();
			var npwd = $("#npwd").val();
			var rnpwd = $("#rnpwd").val();
			//alert(ppwd+npwd+rnpwd);
			$("#msg").hide(300);
			//验证
			if(ppwd.length==0){
				$("#msg").html("*请正确填写！*");
				$("#msg").show(300);
				return ;
			}
			if(npwd.length==0){
				$("#msg").html("*请正确填写！*");
				$("#msg").show(300);
				return ;
			}
			if(rnpwd.length==0){
				$("#msg").html("*请正确填写！*");
				$("#msg").show(300);
				return ;
			}
			if(ppwd.length<6){
				$("#msg").html("*原密码不能少于六位！*");
	
				$("#msg").show(300);
				return ;
			}
			
			 if(npwd.length<6){
				$("#msg").html("*新密码不能少于六位！*");
				$("#msg").show(300);
				return ;
			 }
		 if(npwd!=rnpwd){
			 $("#msg").html("*两次密码不一致！");
				$("#msg").show(300);
				return;
			}
		 
			$("#formcp").submit();
			
		});
	
});
