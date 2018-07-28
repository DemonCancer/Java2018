var deleteId = null;
var deletePoint = null;
var deleteName = null;

$(document).ready(function(){
	$("#right_container").hide();
	$("#right_container").slideDown(800);
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


//4、删除前获取数据，并显示对话框

function deleteFun(e,RCid,delName){
	deleteId = RCid;
	deletePoint = e;
	deleteName = delName;
	
	$("#myDeleteModal").modal('show');
	$("#modalShowMsg_del").html("是否确认删除：" + delName);
}


