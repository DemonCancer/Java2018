var deleteId = null;
var deletePoint = null;
var deleteName = null;

$(document).ready(function(){
	$("#right_container").hide();
	$("#right_container").slideDown(800);
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

function showModal(title,message){
	$('#myModal').modal('show');
	$("#myModalLabel").text(title);
	$("#modalShowMsg").text(message);
}


