// JavaScript Document
$(document).ready(function(){
	///获取专业
	var arrprofession = new Array();
	GetProfession();
	//隐藏遮罩层和添加页面
	var Stop=$(document.body).scrollTop();
	var Sheight=$(document.body).height();
	var Swidth=$(document.body).width();
	$("#mask").css("width",Swidth+"px");
	$("#mask").css("height",Sheight+"px");
	$("#mask,#addpage").hide();
	
	////
	////
	if($("#adminRole").text()=="true"){
		$("#adminRole").text("有");
	}else{
		$("#adminRole").text("无");
	}
	//////
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
		$(this).tab('show');
	});
	$("#nav_ul_li5").click(function (){
		$(this).tab('show');
		window.location.href = "Help.jsp";
	});
	///////编辑
	$("td button").click(function(){
		var	str = $(this).text();
		if(str=="编辑"){
			$(this).text("确定");
			//alert($(this).parent().siblings("td").first().text());
			$(this).parent().siblings("td").each(function() {  // 获取当前行的其他单元格
	            var obj_text = $(this).find("input:text");
	            // 判断单元格下是否有文本框
				var str=$(this).text();
				// 如果没有文本框，则添加文本框使之可以编辑
	            if(!obj_text.length){
	            	//剔除id和删除按钮
	            	if($(this).index()==0||$(this).index()==9){
	            	}
	            	////////添加专业
	            	else if($(this).index()==7){
	            		
	            		$(this).html("<select class='form-control myinput myselect'>");
	            		$(".myselect").append("<option value='"+str+"'>"+str+"</option>");
	            		for(var i=0;i<arrprofession.length;i++){
	            			if(i==0){
	            				//去除第一个
	            			}else{
	            				$(".myselect").append("<option value='"+arrprofession[i]+"'>"+arrprofession[i]+"</option>");
	            			}
	        
        				}
	            		$(".myselect").append("</select>");
	            		
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
		if(str=="确定"){
			//创建数组
			var arr=new Array();
			var row = $(this).parent().parent().index() + 1; // 行位
	        var col = $(this).parent().index() + 1; // 列位置
	        
	        //
	        $(this).parent().siblings("td").find(".myinput").each(function(index,el) {  // 获取当前行的其他单元格
	            	arr[index]=el.value;
        	});
			//把class=myinput的标签里的值放到arr里
	        /*$(this).find(".myinput").each(function(index,el){
				arr[index]=el.value;
			});*/
			//获取id放到arr
			arr.push($(this).parent().siblings(":first").html());
			//ajax数据
			$.ajax({
					//直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
					type: "post",      
					//servlet文件名为Calculator，需要提前在web.xml里面注册
					url: "UpdateServlet", 
					//数据类型，可以为json，xml等等，自己百度
					//dataType : "text",  
					data:
					{
						 "userno" : arr[0],
						 "username":arr[1],
						 "userpass":arr[2],
						 "sex":arr[3],
						 "age":arr[4],
						 "birthday":arr[5],
						 "profession":arr[6],
						 "id":arr[7]
						 
					},
					success : function(Result)
					{
						//Result为后端post函数传递来的数据，这里写结果操作代码
						alert(Result);
						
					},
					error : function()
					{
						 alert("数据传输失败!");
					}
			});
			//alert(arr[3]);
			$(this).parent().siblings("td").find(".myinput").each(function() {  // 获取当前行的其他单元格
            	var text=$(this).val();
            	///把文本框替换成文字
            	$(this).replaceWith(text);
			});
			$(this).text("编辑");
			//测试：遍历放进字符串
			/*var s="";
			for(var i=0;i<arr.length;i++){
				s=s+arr[i]+"--";
			}
			alert(s);*/	
		}
		////删除
		if(str=="删除"){
			var row = $(this).parent().parent().index() + 1; // 行位
			var rs;
			if(confirm('确定要删除该行信息?')){
				//alert("删除");
				alert("要删除的ID:"+$(this).parent().siblings("td").first().text());
				var id=$(this).parent().siblings("td").first().text();
				$.ajax({
					//直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
					type: "post",      
					//servlet文件名为Calculator，需要提前在web.xml里面注册
					url: "DelServlet", 
					//数据类型，可以为json，xml等等，自己百度
					//dataType : "text",  
					data:
					{
						 "id":id
						 
					},
					success : function(Result)
					{
						//Result为后端post函数传递来的数据，这里写结果操作代码
						
						//找到本行
						//alert(row);
						$('table tr:eq('+row+')').remove();
					},
					error : function()
					{
						 alert("数据传输失败!");
					}
				});
				////
				//$(this).parent().parent().remove();

				
		    }else{
		    	alert("取消");
		    }
		}
		

	});
	///查询
	$("#search").click(function (){
		var userno=$("#txtuserno").val();
		var username=$("#txtusername").val();
		var profession=$("#txtprofession").val();
		
		//传值
		$.ajax({
			//直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
			type: "post",      
			//servlet文件名为Calculator，需要提前在web.xml里面注册
			url: "SearchServlet", 
			//数据类型，可以为json，xml等等，自己百度
			//dataType : "text",  
			data:
			{
				 "txtuserno" : userno,
				 "txtusername":username,
				 "txtprofession":profession				 
			},
			success : function()
			{
				//Result为后端post函数传递来的数据，这里写结果操作代码
				window.location.reload();
			},
			error : function()
			{
				 alert("数据传输失败!");
			}
		});
	
	});
	///
	$("#addstu").click(function(){
		//获取网页长度宽度
		$("#mask,#addpage").show();
		
	});
	$("#btnexit").click(function(){
		$("#mask,#addpage").hide();
		window.location.reload();
	});
	$("#mask").click(function(){
		$("#mask,#addpage").hide();
		window.location.reload();
		
	});
	////
	$("#btnadd").click(function (){
		var userno=$("#adduserno").val();
		var username=$("#addusername").val();
		var sex;
		if($("input:radio[name='sex']:checked").val()==""){
			alert("性别不能为空");
		}else{
			sex=$("input:radio[name='sex']:checked").val();
		}
		var age=$("#addage").val();
		var birthday=$("#addbirthday").val();
		var profession=$("#addprofession").val();
		//alert(userno+","+username+","+sex+","+age+","+birthday+","+profession);
		/////
		//ajax数据
		$.ajax({
				//直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
				type: "post",      
				//servlet文件名为Calculator，需要提前在web.xml里面注册
				url: "AddServlet", 
				//数据类型，可以为json，xml等等，自己百度
				//dataType : "text",  
				data:
				{
					 "userno" : userno,
					 "username":username,
					 "sex":sex,
					 "age":age,
					 "birthday":birthday,
					 "profession":profession
				},
				success : function(Result)
				{
					//Result为后端post函数传递来的数据，这里写结果操作代码
					alert(Result);
					$("#adduserno").val("");
					$("#addusername").val("");
					$("input:radio[name='sex']:checked").val()==""
					$("#addage").val("");
					$("#addbirthday").val("");
					$("#addprofession").val("");
					
					
				},
				error : function()
				{
					 alert("数据传输失败!");
				}
		});
		//////
		
		
		
	});
	
	///
	function GetProfession(){
		var str1="data1";
		var str2="data2";
		$.ajax({
			//直接"post"或者"get",不需要"doPost","doGet"，该函数到后端接收缓冲区会自动匹配
			type: "post",      
			//servlet文件名为Calculator，需要提前在web.xml里面注册
			url: "GetProServlet", 
			//数据类型，可以为json，xml等等，自己百度
			//dataType : "text",  
			data:
			{
				 "str1" :str1,
				 "str2" :str2
			},
			success : function(Result)
			{
				//Result为后端post函数传递来的数据，这里写结果操作代码
				//alert(Result);
				var str=Result;
				
				arrprofession=str.split(',');
				
				for(var i=0;i<arrprofession.length;i++){
					$("#txtprofession").append("<option value='"+arrprofession[i]+"'>"+arrprofession[i]+"</option>");
					$("#addprofession").append("<option value='"+arrprofession[i]+"'>"+arrprofession[i]+"</option>");
					//alert(arr[i]);
				}
				
			},
			error : function()
			{
				 alert("数据传输失败!");
			}
	});
	}
	
	////
	
});