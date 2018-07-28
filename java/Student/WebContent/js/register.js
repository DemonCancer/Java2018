// JavaScript Document
$(document).ready(function(){
	if($("#adminRole").text()=="true"){
		$("#adminRole").text("有");
	}else{
		$("#adminRole").text("无");
	}
  $("#nav_ul_li1").click(function (){
		$(this).tab('show');
	});
	$("#nav_ul_li2").click(function (){
		if($("#adminUser").text()==null||$("#adminUser").text()=="null"){
			  alert("未登录!");
			  window.location.href = "Login.jsp";
		  }else{
			  $(this).tab('show');
			  alert("已经登录!");
			  window.location.href = "StuList.jsp";
		  }
	});
	$("#nav_ul_li3").click(function (){
		$(this).tab('show');
		
	});
	$("#nav_ul_li4").click(function (){
		if($("#adminUser").text()==null||$("#adminUser").text()=="null"){
			  alert("未注册!");
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
function submit(){
	var name=document.getElementById("username");
	var pwd=document.getElementById("pwd");
	var repwd=document.getElementById("repwd");
	if(name.value.length<3||name.value.length>16){
		alert("用户名的长度在3-16位！");
	}
	else if(pwd.value.length==0){
		alert("密码不能为空！！");
	}
	else if(repwd.value!=pwd.value){
		alert("两次密码不一致！！");
	}
	else{
		alert("格式正确！");
	}
}