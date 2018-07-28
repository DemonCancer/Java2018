$(document).ready(function(){
	$("#right_container").hide();
	$("#right_container").slideDown(800);
	//打开Modal
	
	$("button").click(function(){
		switch ($(this).attr("id")) {
		case "btn_edit":
			$("#edit_dormManId").val($(this).parent().siblings("td:first").text());
			var dormManId=$(this).parent().siblings("td:first").text();
			$("#edit_dormManId").val(dormManId);
			
			//alert(dormManId);
			$.ajax({
				type: "post",      
				url: "EditDMServlet", 
				dataType : "json",  
				data:
				{
					 "dormManId":dormManId
					 
				},
				success : function(Result)
				{
					//alert("ok");
					//alert(Result.data.length);Map<String,List>
					for(var i=0;i<Result.data.length;i++){
						$("#edit_userName").val(Result.data[i].userName);
						$("#edit_password").val(Result.data[i].password);
						$("#edit_name").val(Result.data[i].name);
						$("#edit_tel").val(Result.data[i].tel);
						if(Result.data[i].sex=="男"){
							$("#edit_sex").find("option:contains('男')").attr("selected",true);
						}else{
							$("#edit_sex").find("option:contains('女')").attr("selected",true);
						}
						//$("#edit_dormBuildId").find("option[]").attr("selected",true);
						//alert(Result.data[i].dormBuildId);
						$("#edit_dormBuildId").val(""+Result.data[i].dormBuildId+"");
						
						
					}
				},
				error : function()
				{
					 alert("数据传输失败!");
				}
			});
			break;

		case "btnUpdateDB":
			if(confirm("确认修改?")){
				//$("#edit_dm_form").submit();
				//alert($("#edit_dormManId").val());
				///拿值
				var dormManId=$("#edit_dormManId").val();
				var userName=$("#edit_userName").val();
				var password=$("#edit_password").val();
				var dormBuildId=$("#edit_dormBuildId").val();
				var name=$("#edit_name").val();
				var sex="";
				if($("#edit_sex").val()=="0"){
					sex="女";
				}else{
					sex="男";
				}
				var tel=$("#edit_tel").val();
				
				///电话判断
				var reg_tel = /^[0-9]{1,11}$/;
				///判断
				if(name.length<3){
					showModal("警告","名称不能少于三位！");
					return;
				}
				if(userName.length<3){
					showModal("警告","名称不能少于三位！");
					return;
				}
				if(tel.length<6){
					showModal("警告","电话不能少于六位！");
					return;
				}
				if(password.length<3){
					showModal("警告","密码不能少于六位！");
					return;
				}
				if(!reg_tel.test(tel)){
					showModal("警告","电话格式不正确！");
					return;
				}
				
				////
				$.ajax({
					type: "post",      
					url: "UpdateDMServlet", 
					//dataType : "json",  
					data:
					{
						 "dormManId":dormManId,
						 "userName":userName,
						 "password":password,
						 "dormBuildId":dormBuildId,
						 "name":name,
						 "sex":sex,
						 "tel":tel 
					},
					success : function(Result)
					{
						if(Result=="修改成功"){
							showModal("提示","修改成功！");
							setTimeout(function(){
								window.location.href = "DMListServlet";
							}, 1000);
						}
						
						
					},
					error : function()
					{
						 alert("数据传输失败!");
					}
				});
				
			}
			break;
			
		case "btn_del":
			
			
			break;
		case "btnAddDB":
			if(confirm("确认添加?")){
				///拿值
				var dormManId=$("#add_dormManId").val();
				var userName=$("#add_userName").val();
				var password=$("#add_password").val();
				var repassword=$("#add_repassword").val();
				var dormBuildId=$("#add_dormBuildId").val();
				var name=$("#add_name").val();
				var sex="";
				if($("#add_sex").val()=="0"){
					sex="女";
				}else{
					sex="男";
				}
				var tel=$("#add_tel").val();
				
				///电话判断
				var reg_tel = /^[0-9]{1,11}$/;
				///判断
				if(password!=repassword){
					showModal("警告","两次密码不一致！");
					return;
				}
				if(name.length<3){
					showModal("警告","名称不能少于三位！");
					return;
				}
				if(userName.length<3){
					showModal("警告","名称不能少于三位！");
					return;
				}
				if(tel.length<6){
					showModal("警告","电话不能少于六位！");
					return;
				}
				if(password.length<3){
					showModal("警告","密码不能少于六位！");
					return;
				}
				if(!reg_tel.test(tel)){
					showModal("警告","电话格式不正确！");
					return;
				}
				
				////
				$.ajax({
					type: "post",      
					url: "AddDMServlet", 
					//dataType : "json",  
					data:
					{
						 "dormManId":dormManId,
						 "userName":userName,
						 "password":repassword,
						 "dormBuildId":dormBuildId,
						 "name":name,
						 "sex":sex,
						 "tel":tel 
					},
					success : function(Result)
					{
						if(Result=="添加成功"){
							showModal("提示","添加成功！");
							setTimeout(function(){
								window.location.href = "DMListServlet";
							}, 1000);
						}
						
						
					},
					error : function()
					{
						 alert("数据传输失败!");
					}
				});
				
			}
			break;
		case "btnsearch":
			
			var choose=$("#searchchoose").val();
			var txtsearch=$("#txtsearch").val();
			$("#seacrch_dm_form").submit();
			break;
		default:
			break;
		}
		
	});
	
});
function deleteFun(e,id){
	if(confirm("确认删除?")){
		var dormManId=$(this).parent().siblings("td:first").text();
		alert(dormManId);
		$.ajax({
			type: "post",      
			url: "DelDMServlet", 
			//dataType : "json",  
			data:
			{
				 "dormManId":id
			},
			success : function(Result)
			{
				if(Result=="删除成功"){
					showModal("提示",Result);
					//$("#modalShowMsg_del").html(Result+"!");
					setTimeout(function(){
						$(e).parent().parent().remove();
					}, 1000);
				}	
			},
			error : function()
			{
				 alert("数据传输失败!");
			}
		});
	}
} 
///
function showModal(title,message){
	$('#myModal').modal('show');
	$("#myModalLabel").text(title);
	$("#modalShowMsg").text(message);
}