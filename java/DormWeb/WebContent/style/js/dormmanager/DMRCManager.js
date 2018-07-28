var deleteId = null;
var deletePoint = null;
var deleteName = null;

$(document).ready(function(){
	$("#right_container").hide();
	$("#right_container").slideDown(800);
	$("button").click(function(){
		switch ($(this).attr("id")) {
		case "btn_edit":	
			break;

		case "btnUpdateRC":
			if(confirm("确认修改?")){
				//$("#edit_dm_form").submit();
				//alert($("#edit_dormManId").val());
				///拿值
				var recordId=$("#edit_recordId").val();
				var studentNumber=$("#edit_studentNumber").val();
				var studentName=$("#edit_studentName").val();
				var detail=$("#edit_detail").val();
			
				////
				$.ajax({
					type: "post",  
					url: "UpdateRCServlet",
					data:
					{
						 "recordId":recordId,
						 "studentNumber":studentNumber,
						 "studentName":studentName,
						 "detail":detail
					},
					success : function(Result)
					{

						if(Result=="修改成功"){
							setTimeout(function(){
								window.location.href = "RCListServlet?JspId=DMRCManager";
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
			
		case "btnAddRC":
			var stuNum=$("#add_studentNumber").val();
			//var stuName=$("#add_studentName").val();
			//var dormBuildId=$("#add_dormBuildId").val();
			var date=$("#add_date").val();
			var detail=$("#add_detail").val();
			$.ajax({
				type: "post",      
				url: "InsertRCServlet?JsAdd=DMRC", 
				data:
				{
					 "stuNum":stuNum,
					 /*"stuName":stuName,
					 "dormBuildId":dormBuildId,*/
					 "date":date,
					 "detail":detail
					 
				},
				success : function(Result)
				{
					if(Result=="添加成功"){
						setTimeout(function(){
							showModal("提示",Result);
							window.location.href = "RCListServlet?JspId=DMRCManager";
						}, 1000);
					}
					if(Result=="学号不存在"){
						showModal("提示",Result);
					}
				},
				error : function()
				{
					 alert("数据传输失败!");
				}
			});
			break;
		default:
			break;
		}
		
	});
//删除
$("#btn_deleteRC").click(function(){
	$.ajax({
		type: "post",      
		url: "DelRCServlet", 
		//dataType : "json",  
		data:
		{
			 "recordId":deleteId
		},
		success : function(Result)
		{
			showModal("提示","学生删除成功!");
		},
		error : function()
		{
			showModal("提示","网络断开");
		}
	});
	$(deletePoint).parent().parent().remove();
	//初始化数据
	deleteId = null;
	deletePoint = null;
	deleteStuName = null;
	
	
	
});


});
////查询
function SearchFun(e){
	var searchchoose=$("#searchchoose").val();
	var txtsearch=$("#txtsearch").val();
	var date=$("#txtdate").val();
	var date1=$("#txtdate1").val();
	if(date.length>0&&date1==""){
		showModal("提示","始末日期都要填!");
	}
	else if(date==""&&date1.length>0){
		showModal("提示","始末日期都要填!");
	}else{
		$("#seacrch_RC_form").submit();
	}
	
	
	
}
////
function editFun(e,recordId,studentNumber){
	var Id=recordId;
	var stuNum=studentNumber;
	//alert(Id+","+stuNum);
	$.ajax({
		type: "post",      
		url: "GetRCServlet", 
		dataType : "json",  
		data:
		{
			 "recordId":Id,
			 "stuNum":studentNumber
			 
		},
		success : function(Result)
		{
			for(var i=0;i<Result.length;i++){
				$("#edit_recordId").val(Result[i].recordId);
				$("#edit_studentNumber").val(Result[i].studentNumber);
				$("#edit_studentName").val(Result[i].studentName);
				$("#edit_detail").val(Result[i].detail);
			}
		},
		error : function()
		{
			 alert("数据传输失败!");
		}
	});
}

//4、删除前获取数据，并显示对话框

function deleteFun(e,RCid,delName){
	deleteId = RCid;
	deletePoint = e;
	deleteName = delName;
	
	$("#myDeleteModal").modal('show');
	$("#modalShowMsg_del").html("是否确认删除：" + delName);
}
///
function showModal(title,message){
	$('#myModal').modal('show');
	$("#myModalLabel").text(title);
	$("#modalShowMsg").text(message);
}


