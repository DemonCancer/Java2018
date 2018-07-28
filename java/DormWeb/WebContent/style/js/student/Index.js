new WOW().init();
$(document).ready(function(){
	$("#exitsys,#exitLogin").click(function(){
		if(confirm("是否退出当前账号?")){
			$.ajax({
				type: "post",      
				url: "../../ExitloginServlet", 
				success : function(Result)
				{
					window.location.href = "../Login.jsp";
				},
				error : function()
				{
					 alert("数据传输失败!");
				}
			});
		}
	});
});