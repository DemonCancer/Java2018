$(document).ready(function(){
	$("#right_container").hide();
	$("#right_container").slideDown(800);
	//打开Modal
	
	$("button").click(function(){
		switch ($(this).attr("id")) {
		case "btn_edit":
			$("#edit_studentId").val($(this).parent().siblings("td:first").text());
			var studentId=$(this).parent().siblings("td:first").text();
			$("#edit_studentId").val(studentId);
			
			//alert(dormManId);
			$.ajax({
				type: "post",      
				url: "EditStuServlet", 
				dataType : "json",  
				data:
				{
					 "studentId":studentId
					 
				},
				success : function(Result)
				{
					//alert("ok");
					//alert(Result.data.length);
					for(var i=0;i<Result.data.length;i++){
						$("#edit_stuNum").val(Result.data[i].stuNum);
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
						$("#edit_dormName").val(Result.data[i].dormName);
						
						
					}
				},
				error : function()
				{
					 alert("数据传输失败!");
				}
			});
			break;

		case "btnUpdateStu":
			if(confirm("确认修改?")){
				//$("#edit_dm_form").submit();
				alert($("#edit_studentId").val());
				///拿值
				var studentId=$("#edit_studentId").val();
				var stuNum=$("#edit_stuNum").val();
				var password=$("#edit_password").val();
				var dormBuildId=$("#edit_dormBuildId").val();
				var dormName=$("#edit_dormName").val();
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
				if(stuNum.length<3){
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
					url: "UpdateStuServlet", 
					//dataType : "json",  
					data:
					{
						 "studentId":studentId,
						 "stuNum":stuNum,
						 "password":password,
						 "dormBuildId":dormBuildId,
						 "dormName":dormName,
						 "name":name,
						 "sex":sex,
						 "tel":tel 
					},
					success : function(Result)
					{
						if(Result=="修改成功"){
							showModal("提示","修改成功！");
							setTimeout(function(){
								window.location.href = "StuListServlet";
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
		case "btnAddStu":
			if(confirm("确认添加?")){
				///拿值
				var studentId=$("#add_studentId").val();
				var stuNum=$("#add_stuNum").val();
				var password=$("#add_password").val();
				var repassword=$("#add_repassword").val();
				var dormBuildId=$("#add_dormBuildId").val();
				var dormName=$("#add_dormName").val();
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
				if(stuNum.length<3){
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
					url: "AddStuServlet", 
					//dataType : "json",  
					data:
					{
						 "studentId":studentId,
						 "stuNum":stuNum,
						 "password":repassword,
						 "dormBuildId":dormBuildId,
						 "dormName":dormName,
						 "name":name,
						 "sex":sex,
						 "tel":tel 
					},
					success : function(Result)
					{
						if(Result=="添加成功"){
							showModal("提示","添加成功！");
							setTimeout(function(){
								window.location.href = "StuListServlet";
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
			$("#seacrch_stu_form").submit();
			break;
		default:
			break;
		}
		
	});
	
});
////
function deleteFun(e,id){
	if(confirm("确认删除?")){
		var studentId=$(this).parent().siblings("td:first").text();
		//alert(studentId);
		$.ajax({
			type: "post",      
			url: "DelStuServlet", 
			//dataType : "json",  
			data:
			{
				 "studentId":id
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