// JavaScript Document
function submit(){
	var name=document.getElementById("username");
	var pwd=document.getElementById("pwd");
	if(name.value.length<3||name.value.length>16){
		alert("用户名的长度在3-16位！");
	}
	else if(pwd.value.length==0){
		alert("密码不能为空！！");
	}
	else{
		alert("格式正确！");
	}
}
$(document).ready(function(){
	
	if($("#adminRole").text()=="true"){
		$("#adminRole").text("有");
	}else{
		$("#adminRole").text("无");
	}
  $("#nav_ul_li1").click(function (){
	  $(this).tab('show');
	  window.location.href = "Index.jsp";
	});
	$("#nav_ul_li2").click(function (){
		$(this).tab('show');
	});
	$("#nav_ul_li3").click(function (){
		if($("#adminUser").text()==null||$("#adminUser").text()=="null"){
			  alert("未登录账号,请注册后登录!");
			  window.location.href = "Register.jsp";
		  }else{
			  $(this).tab('show');
			  alert("已有账号!");
			  window.location.href = "StuList.jsp";
		  }
	});
	$("#nav_ul_li4").click(function (){
		if($("#adminUser").text()==null||$("#adminUser").text()=="null"){
			  alert("未登录!");
			  window.location.href = "Login.jsp";
		  }else{
			  $(this).tab('show');
			  window.location.href = "StuList.jsp";
		  }
	});
	$("#nav_ul_li5").click(function (){
		$(this).tab('show');
		window.location.href = "Help.jsp";
	});
});

