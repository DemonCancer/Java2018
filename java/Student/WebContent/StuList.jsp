
    <%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
    <%@ page import="entity.Student,java.util.List,DaoImpl.StudentDaoImpl" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生列表</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/StuList.js"></script>
<link href="css/StuList.css" rel="stylesheet" type="text/css">
</head>

<body>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	List<Student> stulist=(List<Student>)session.getAttribute("stuList");
	if(stulist==null){
		StudentDaoImpl studaoimpl=new StudentDaoImpl();
		stulist=studaoimpl.getAllStudent();
	}
%>
<div id="logmessge">
	<button type="button" class="btn btn-lg " >
		用户名：<span id="adminUser"><%=session.getAttribute("adminUser") %></span>
      	登录时间：<span id="logTime"><%=session.getAttribute("logTime") %></span>
      	管理权限：<span id="adminRole"><%=session.getAttribute("adminRole")%></span>
	</button>
</div>
<div id="nav">
	<ul id="nav_ul" class="nav nav-pills nav-justified">
      <li id="nav_ul_li1"  ><a href="#">首页</a></li>
      <li id="nav_ul_li2"  ><a href="#">登录</a></li>
      <li id="nav_ul_li3" ><a href="#">注册</a></li>
      <li id="nav_ul_li4"  class="active"><a href="#">操作 </a></li>
      <li id="nav_ul_li5" ><a href="#">帮助</a></li>
      <%-- <li id="nav_ul_li6" ><a id="logname" href="#">
      			用户名：<%=session.getAttribute("adminUser") %>
      			登录时间：<%=session.getAttribute("logTime") %>
      </a></li> --%>
	</ul>
</div>
<div id="warp">
	<div id="top">
    	<div action="SearchServlet" name="search" class="form-inline">
	          <div id="search_userno" class="form-group">
	            <label for="userno">学号：</label>
	            <input type="text" class="form-control" name="txtuserno" id="txtuserno" placeholder="请输入学号">
	          </div>
	          <div id="search_username" class="form-group">
	            <label for="username">姓名：</label>
	            <input type="text" class="form-control" name="txtusername" id="txtusername" placeholder="请输入姓名">
	          </div>
	          <div id="search_profession" class="form-group">
	            <label for="profession">专业：</label>
	            <select class="form-control" name="txtprofession" id="txtprofession" placeholder="请选择专业">
	                  <option value=""></option>
	                  <option value="计算机">计算机</option>
	                  <option value="英语">英语</option>
	                  <option value="物理光电">物理光电</option>
	                  
	            </select>      
	          </div>
				<button id="search" type="submit" class="btn btn-info btn-primary">查询</button>
				<button id="addstu" type="submit" class="btn btn-info btn-primary">添加学生</button>
		</div>
		
		
    </div>
    
	<div id="bottom" class="table-responsive">
    	<table id="stutab" class="table table-hover table-striped" border="0">
        	<thead>
        		<tr>
	            	<th>ID</th>
	                <th>学号</th>
	                <th>姓名</th>
	                <th>密码</th>
	                <th>性别</th>
	                <th>年龄</th>
	                <th>出生日期</th>
	                <th>专业</th>
	                
                </tr>
            </thead>
            
            <%
				//利用jsp脚本实现
				//遍历list，并显示
				int i=0;
            		
				for(Student stu:stulist){
					
                	String str="";
                	if(stu.isSex()==false){
                		str="男";
                	}else{
                		str="女";
                	}
                	
			%>
            
            <tr id="stulist">
            <!-- <form action="UpdateServlet" method="post"> -->
            	<td id="stu<%=stu.getId() %>" class="stuid"><%=stu.getId() %></td>
                <td ><%=stu.getUserno() %></td>
                <td ><%=stu.getUsername() %></td>
                <td ><%=stu.getUserpass() %></td>
                <td ><%=str %></td>
                <td ><%=stu.getAge() %></td>
                <td ><%=stu.getBirthday() %></td>
                <td ><%=stu.getProfession() %></td>
                <td ><button id="btnedit" type="button" class="btn btn-info">编辑</button></td>
                <td ><button id="btndel" type="submit" class="btn btn-info">删除</button></td>
            <!-- </form> -->
            </tr>
            
            <%
            }
			%>
            
        </table>
    	
    </div>
    
</div>
<div id="footer">
<span id="footer_span">版权所有</span>
</div>

<!--添加学生遮罩层  -->
<div class="row">
	<div class="modal fade" id="mask" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
	<!--添加页面  -->
	<div id="addpage" class=" " >
		<div id="addtab">
				<div class="col-md-6">

					    <label >学号：</label><br/>
					    <input type="text" class="form-control" id="adduserno" placeholder="请输入学号">

				</div>
				<div class="col-md-6">

					    <label >姓名：</label>
					    <input type="text" class="form-control" id="addusername" placeholder="请输入姓名">

				</div>
			
				<div class="col-md-6">

					    <label >性别：</label><br/>
					    <label>
					  		<input type="radio" name="sex" id="addmale" value="false" >男
						</label>
						<label>
						  <input type="radio" name="sex" id="addfemale" value="true">女
						</label>

				</div>
				<div class="col-md-6">

					    <label >年龄：</label>
					    <input type="text" class="form-control" id="addage" placeholder="请输入年龄">

				</div>
		  		<div class="col-md-6">

					    <label >出生日期：</label>
					    <input type="text" class="form-control" id="addbirthday" placeholder="请输入出生日期">

		  		</div>
		  		<div class="col-md-6">

					    <label for="profession">专业：</label>
					    <select class="form-control" name="addprofession" id="addprofession" placeholder="请选择专业">
					          <option value=""></option>
					          <option value="计算机">计算机</option>
					          <option value="英语">英语</option>
					          <option value="物理光电">物理光电</option>
					          
					    </select>      

		  		</div>
		  		<div class="col-md-6">
		  			<button id="btnadd" type="button" class="btn btn-default btn-info" >添加</button>
		  		</div>
		  		<div class="col-md-6">
		  			<button id="btnexit" type="button" class="btn btn-default btn-info" >取消</button>
		  		</div>
		  </div>
	</div>
</div>


</body>
</html>