$(document).ready(function(){
	///////
	//////
	if($("#adminRole").text()=="true"){
		$("#adminRole").text("有");
	}else{
		$("#adminRole").text("无");
	}
	//////
//////检验
	  $("#nav_ul_li1").click(function (){
			$(this).tab('show');
			window.location.href = "Index.jsp";
		});
		$("#nav_ul_li2").click(function (){
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
		});
		$("#nav_ul_li3").click(function (){
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
		});
		$("#nav_ul_li4").click(function (){
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
		});
		$("#nav_ul_li5").click(function (){
			$(this).tab('show');
			
		});
	/////评分
	$("#star li").mouseenter(function(){
		//alert("ok");
		if($(this).next().children().attr("src")=="img/star1.png"){
			//$(this).nextAll().children().attr("src","img/star0.png");
		}else{
			$(this).children().attr("src","img/star1.png");
			$(this).prevAll().children().attr("src","img/star1.png");
		}
		
		
		});
	/*$("#star li img").mouseleave(function(){
		$(this).attr("src","img/star0.png");
	});*/
	$("#star li").click(function(){
		/*$(this).attr("src","img/star1.png");*/
		$(this).nextAll().children().attr("src","img/star0.png");
		$(this).children().attr("src","img/star1.png");
		
		//$(this).children().attr("src","img/star1.png");
	});
	///添加啊
	$("#okadd").click(function(){
		//alert("ok");
		window.location.reload();
	});
	$("#btnokadd").click(function(){
		//alert($("#txtaddpro").val());
		var profession=$("#txtaddpro").val();
		if(profession!=""){
			
			$.ajax({
				type: "post",      
				url: "AddProServlet", 
				//dataType : "text",  
				data:
				{
					 "profession":profession
					 
				},
				success : function(Result)
				{
					//alert(Result);
					$("#addres").text(Result+"!");
					setTimeout(function() { $("#addres").text(""); }, 5000);
					str="<tr><td></td><td>"+profession+"</td>" +
					"<td ><button id='btnedit' class='btn btn-info'>编辑</button></td>" +
					"<td ><button id='btndel' class='btn btn-info'>删除</button></td></tr>";
					$("#protablist").append(str);
					
				},
				error : function()
				{
					 alert("数据传输失败!");
				}
			});
		}
		
		///最后清空
		$("#txtaddpro").val("");
	});
	/////向后台传输数据进行查询专业、
	//var arrprofession = new Array();
	
	
	GetProfession();
	if($("#adminRole").text()=="有"){
		$("#SclMess").show(); 	
		
	}else{
		$("#SclMess").hide(); 		
	}
	//获取专业存到数组里
	function GetProfession(){
		var test="aaa";
		$.ajax({
			//直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
			type: "post",
			//servlet文件名为Calculator，需要提前在web.xml里面注册
			url: "GetProAllServlet", 
			//数据类型，可以为json，xml等等，自己百度
			dataType:"json",
			data:
			{
				"test":test
			},
			success : function(Result)
			{
				//Result为后端post函数传递来的数据，这里写结果操作代码
				//alert(Result);
				//alert(Result.data[0].id);
				//$("#EditProspan").append("");
				var str=""
				for(var i=0;i<Result.data.length;i++){
					str="<tr><td>"+Result.data[i].id+"</td><td>"+Result.data[i].profession+"</td>" +
							"<td ><button id='btnedit' class='btn btn-info'>编辑</button></td>" +
							"<td ><button id='btndel' class='btn btn-info'>删除</button></td></tr>";
					$("#protablist").append(str);
					
				}
				//alert($("#protablist").html());
				////
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
				            	if($(this).index()==0||$(this).index()==3){
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
					//
					if(str=="确定"){
						var id="";
						var profession="";
						var row = $(this).parent().parent().index() + 1; // 行位
				        var col = $(this).parent().index() + 1; // 列位置
				        
				        //获取id
						id=$(this).parent().prev().prev().text();
						//alert(id);
				        //获取专业
				        profession=$(this).parent().prev().children().val();
				        //alert(profession);
						
						//ajax数据
						$.ajax({
								type: "post",      
								url: "UpdateProServlet", 
								//dataType : "text",  
								data:
								{
									 "profession":profession,
									 "id":id
									 
								},
								success : function(Result)
								{
									//alert(Result);
									
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
					}
					//
					if(str=="删除"){
						var id="";
						var row = $(this).parent().parent().index() + 1; // 行位
				        var col = $(this).parent().index() + 1; // 列位置
				        
				        //获取id
						id=$(this).parent().prev().prev().prev().text();
						//alert(id);
						///
						if(confirm("确定删除?")){
							$.ajax({
								type: "post",      
								url: "DelProServlet", 
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
				});
				/////
			},
			error : function()
			{
				 alert("数据传输失败!");
			}
		});
	}
	/////
	
	
	
	
	
	
});