$(document).ready(function(){
	$("#right_container").hide();
	$("#right_container").slideDown(800);
	//打开Modal
	//$("#edit_dormBuildId").val(""+Result.data[i].dormBuildId+"");
	$("button").click(function(){
		switch ($(this).attr("id")) {
		case "btn_edit":
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
function Funsubmit(e){
	var stuNum=$("#edit_stuNum").val();
	var stuName=$("#edit_name").val();
	var dormBuildId=$("#edit_dormBuildId").val();
	var date=$("#edit_date").val();
	var detail=$("#edit_detail").val();
	alert(date);
	$.ajax({
		type: "post",      
		url: "InsertRCServlet?JsAdd=STU", 
		data:
		{
			 "stuNum":stuNum,
			 "stuName":stuName,
			 "dormBuildId":dormBuildId,
			 "date":date,
			 "detail":detail
			 
		},
		success : function(Result)
		{
			if(Result=="添加成功"){
				showModal("提示","添加成功！");
				setTimeout(function(){
					window.location.href = "StuLookListServlet";
				}, 1000);
			}
		},
		error : function()
		{
			 alert("数据传输失败!");
		}
	});
	//$("#edit_stu_form").submit();
}
////
function FunGetData(e,stuId){
	var studentId=stuId;
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
				$("#edit_name").val(Result.data[i].name);
				$("#edit_dormBuildId").val(""+Result.data[i].dormBuildId+"");
			}
		},
		error : function()
		{
			 alert("数据传输失败!");
		}
	});
	
}
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