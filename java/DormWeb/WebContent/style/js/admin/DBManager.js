$(document).ready(function(){
	$("#right_container").hide();
	$("#right_container").slideDown(800);
	//打开Modal
	
	$("button").click(function(){
		switch ($(this).attr("id")) {
		case "btn_edit":
			$("#edit_dormBuildId").val($(this).parent().siblings("td:first").text());
			var dormBuildId=$(this).parent().siblings("td:first").text();
			$("#edit_dormBuildId").val(dormBuildId);
			
			//alert(dormBuildId);
			$.ajax({
				type: "post",      
				url: "EditDBServlet", 
				dataType : "json",  
				data:
				{
					 "dormBuildId":dormBuildId
					 
				},
				success : function(Result)
				{
					//alert("ok");
					//alert(Result.data.length);
					for(var i=0;i<Result.data.length;i++){
						$("#edit_dormBuildName").val(Result.data[i].dormBuildName);
						$("#edit_dormBuildDetail").val(Result.data[i].dormBuildDetail);
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
				//$("#edit_db_form").submit();
				//alert($("#edit_dormBuildId").val());
				///拿值
				var dormBuildId=$("#edit_dormBuildId").val();
				var dormBuildName=$("#edit_dormBuildName").val();
				var dormBuildDetail=$("#edit_dormBuildDetail").text();
				alert(dormBuildId);
				///判断
				if(dormBuildName.length<3){
					showModal("警告","名称不能少于三位！");
					return;
				}
				if(dormBuildDetail.length<6){
					showModal("警告","基本信息不能少于六位！");
					return;
				}
				
				////
				$.ajax({
					type: "post",      
					url: "UpdateDBServlet", 
					//dataType : "json",  
					data:
					{
						 "dormBuildId":dormBuildId,
						 "dormBuildName":dormBuildName,
						 "dormBuildDetail":dormBuildDetail
					},
					success : function(Result)
					{
						if(Result=="修改成功"){
							showModal("提示","修改成功！");
							setTimeout(function(){
								window.location.href = "DBListServlet";
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
		case "btnAddDB":
			if(confirm("确认添加?")){
				///拿值
				var dormBuildId=$("#add_dormBuildId").val();
				var dormBuildName=$("#add_dormBuildName").val();
				var dormBuildDetail=$("#add_dormBuildDetail").val();
				var dormManId=$("#add_dormManId").val();
				alert(dormManId);
				
				///判断
				if(dormBuildName.length<3){
					showModal("警告","名称不能少于三位！");
					return;
				}
				if(dormBuildDetail.length<6){
					showModal("警告","基本信息不能少于六位！");
					return;
				}
				if(dormBuildDetail.dormManId<6){
					showModal("警告","基本信息不能少于六位！");
					return;
				}
				
				////
				$.ajax({
					type: "post",      
					url: "AddDBServlet", 
					//dataType : "json",  
					data:
					{
						 "dormBuildId":dormBuildId,
						 "dormBuildName":dormBuildName,
						 "dormManId":dormManId,
						 "dormBuildDetail":dormBuildDetail
					},
					success : function(Result)
					{
						if(Result=="添加成功"){
							showModal("提示","添加成功！");
							setTimeout(function(){
								window.location.href = "DBListServlet";
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
			$("#seacrch_db_form").submit();
			break;
		default:
			break;
		}
		
	});
	
});
function GetDMFun(e,id){
	//alert(id+e);
	$("#DMtbody").html("");
	$.ajax({
		type: "post",      
		url: "GetDMServlet", 
		dataType : "json",  
		data:
		{
			 "dormBuildId":id
		},
		success : function(Result)
		{
			//alert(Result.length);
			
			for(var i=0;i<Result.length;i++){
				var str="<tr>" +
						"<td>"+Result[i].dormBuildId+"</td>" +
						"<td>"+Result[i].dormManId+"</td>"+
						"<td>"+Result[i].userName+"</td>"+
						"<td>"+Result[i].password+"</td>"+
						"<td>"+Result[i].name+"</td>"+
						"<td>"+Result[i].sex+"</td>"+
						"<td>"+Result[i].tel+"</td>"+
						"<td ><button id='btndel' data-toggle='modal' data-target='#' class='btn btn-danger' " +
						"onclick='DelDM(this,"+Result[i].dormManId+")'>删除</button></td>"+
						"</tr>";
				
				$("#DMtbody").append(str);
				
			}
			str=null;
			
			
		},
		error : function()
		{
			//showModal("提示","没有数据");
			$("#DMtbody").append("<tr><td colspan='8'>没有数据！</td></tr>");
		}
	});
	
}

function deleteFun(e,id){
	if(confirm("确认删除?")){
		$.ajax({
			type: "post",      
			url: "DelDBServlet", 
			//dataType : "json",  
			data:
			{
				 "dormBuildId":id
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
				showModal("提示","没有数据");
			}
		});
	}
} 
////删除宿舍管理员
function DelDM(e,dormManId){
	//alert(e+dormManId);
	//$("#modalShowMsg_del").html("是否删除？？");
	if(confirm("确认删除?")){
		$.ajax({
			type: "post",      
			url: "DBDelDMServlet", 
			//dataType : "json",  
			data:
			{
				 "dormManId":dormManId
			},
			success : function(Result)
			{
				if(Result=="修改成功"){
					showModal("提示","删除成功！");
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
///获取空闲管理员
function FunGetDMan(e){
	/*$.ajax({
		type: "post",      
		url: "GetDManServlet", 
		//dataType : "json",  
		success : function(Result)
		{
			if(Result=="修改成功"){
				showModal("提示","删除成功！");
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
	});*/
}

///
function showModal(title,message){
	$('#myModal').modal('show');
	$("#myModalLabel").text(title);
	$("#modalShowMsg").text(message);
}