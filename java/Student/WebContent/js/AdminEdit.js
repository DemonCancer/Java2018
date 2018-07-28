$(document).ready(function(){
//////
	if($("#adminRole").text()=="true"){
		$("#adminRole").text("有");
	}else{
		$("#adminRole").text("无");
	}
	//////
	$("#nav_ul_li1").click(function (){
		if(confirm("是否返回首页，您未保存的数据将会重置！！")){
			$(this).tab('show');
			window.location.href = "Index.jsp";
		}
	});
	$("#nav_ul_li2").click(function (){
		if(confirm("是否返回登录页面，您未保存的数据将会重置！！")){
			if($("#adminUser").text()!="null"){
				if(confirm("已经登录过,是否退出当前账号?")){
					$.ajax({
						type: "post",      
						url: "ExitloginServlet", 
						success : function(Result)
						{
							window.location.href = "Login.jsp";
							
						},
						error : function()
						{
							 alert("数据传输失败!");
						}
					});
				}
				
			}else{
				window.location.href = "Login.jsp";
			}
		}
	});
	$("#nav_ul_li3").click(function (){
		if(confirm("是否返回注册页面，您未保存的数据将会重置！！")){
			if($("#adminUser").text()!="null"){
				if(confirm("已经登录过,是否退出当前账号?")){
					$.ajax({
						type: "post",      
						url: "ExitloginServlet", 
						success : function(Result)
						{
							window.location.href = "Login.jsp";
							
						},
						error : function()
						{
							 alert("数据传输失败!");
						}
					});
				}
			}else{
				window.location.href = "Register.jsp";
			}
		}
	});
	$("#nav_ul_li4").click(function (){
		if(confirm("是否返回操作页面，您未保存的数据将会重置！！")){
			if($("#adminUser").text()==null||$("#adminUser").text()=="null"){
				  alert("未登录!");
				  window.location.href = "Login.jsp";
			  }else{
				  
				  if($("#adminRole").text()=="有"){
					  $(this).tab('show');
					  window.location.href = "StuList.jsp";
				  }else{
					  alert("没有权限!");
					  
				  }
				  
			  }
		}
	});
	$("#nav_ul_li5").click(function (){
		if(confirm("是否返回帮助页面，您未保存的数据将会重置！！")){
			$(this).tab('show');
			window.location.href = "Help.jsp";
		}
		
		
	});
	/////////
	GetUsers();
	/////////
	
});
////获取所有用户
function GetUsers(){
	$.ajax({
		//直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
		type: "post",
		//servlet文件名为Calculator，需要提前在web.xml里面注册
		url: "GetAllUserServlet", 
		//数据类型，可以为json，xml等等，自己百度
		dataType:"json",
		data:
		{
		},
		success : function(Result)
		{
			//alert(Result.data[0].username);
			///显示表格
			var str=""
			var role=""
			for(var i=0;i<Result.data.length;i++){
				if(Result.data[i].role=="false"){
					role="无";
				}else{
					role="有";
				}
				str="<tr><td>"+Result.data[i].id+"</td>" +
						"<td>"+Result.data[i].username+"</td>" +
						"<td>"+Result.data[i].userpass+"</td>"+
						"<td>"+role+"</td>"+
						"<td ><button id='btnedit' class='btn btn-info'>编辑</button></td>" +
						"<td ><button id='btndel' class='btn btn-info'>删除</button></td></tr>";
				$("#usertablist").append(str);
				
			}
			////点击按钮
			$("td button").click(function(){
				var	str = $(this).text();
				//如果是编辑
				if(str=="编辑"){
					$(this).text("确定");
					// 获取当前行的其他单元格
					$(this).parent().siblings("td").each(function() {  
			            var obj_text = $(this).find("input:text");
			            // 判断单元格下是否有文本框
						var str=$(this).text();
						// 如果没有文本框，则添加文本框使之可以编辑
			            if(!obj_text.length){
			            	//剔除id和删除按钮
			            	if($(this).index()==0||$(this).index()==5){
			            	}
			            	else{
			            		//加上input
			            		$(this).html("<input type='text' class='form-control myinput' value='"+str+"'/>");
			            	} 
						}else{
							$(this).html(obj_text.val());
						}
		        	});
				}
				/////如果是确定
				if(str=="确定"){
					if(confirm("确定更新?")){
						var id="";
						var arr=new Array();
						var row = $(this).parent().parent().index() + 1; // 行位
				        var col = $(this).parent().index() + 1; // 列位置
				        
				        //获取id$(this).parent().siblings(":first").html()
						id=$(this).parent().siblings(":first").text();
						//alert(id);
				        //获取文本框的值
						$(this).parent().siblings("td").find(".myinput").each(function(index,el){  
							// 获取当前行的其他单元格
			            	arr[index]=el.value;
						});
				        
				        //alert(arr);
				        
						
						//ajax数据
				        $.ajax({
							type: "post",      
							url: "UpdateUserServlet", 
							//dataType : "text",  
							data:
							{
								"id":id,
								"username":arr[0],
								"userpass":arr[1],
								"role":arr[2]
							},
							success : function(Result)
							{
								alert(Result);
								
							},
							error : function()
							{
								 alert("数据传输失败!");
							}
				        });
						
						$(this).parent().siblings("td").find(".myinput").each(function() {  // 获取当前行的其他单元格
			            	var text=$(this).val();
			            	///把文本框替换成文字
			            	$(this).replaceWith(text);
						});
						$(this).text("编辑");
					}else{
						window.location.reload();
					}
					
				}
				////删除
				if(str=="删除"){
					var id="";
					var row = $(this).parent().parent().index() + 1; // 行位
			        var col = $(this).parent().index() + 1; // 列位置
			        
			        //获取id$(this).parent().siblings(":first").html()
					id=$(this).parent().siblings(":first").text();
					//alert(id);
					///
					if(confirm("确定删除?")){
						$.ajax({
							type: "post",      
							url: "DelUserServlet", 
							//dataType : "text",  
							data:
							{
								 "id":id
								 
							},
							success : function(Result)
							{
								//alert(Result);
								$('table tr:eq('+row+')').remove();
								
							},
							error : function()
							{
								 alert("数据传输失败!");
							}
						});
					}
					////
				}
				////删除完成
			});
		},
		error : function()
		{
			 alert("数据传输失败!");
		}
	});
}