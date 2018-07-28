<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/index.js"></script>
<link href="css/index.css" rel="stylesheet" type="text/css">
</head>

<body>
<div id="logmessge">
	<button type="button" class="btn btn-lg " id="adminpage">
		用户名：<span id="adminUser"><%=session.getAttribute("adminUser") %></span>
      	登录时间：<span id="logTime"><%=session.getAttribute("logTime") %></span>
      	管理权限：<span id="adminRole"><%=session.getAttribute("adminRole")%></span>
	</button>
</div>
<div id="nav">
	<ul id="nav_ul" class="nav nav-pills nav-justified">
      <li id="nav_ul_li1" role="presentation" class="active"><a href="#">首页</a></li>
      <li id="nav_ul_li2" role="presentation" ><a href="#">登录</a></li>
      <li id="nav_ul_li3" role="presentation"><a href="#">注册</a></li>
      <li id="nav_ul_li4" role="presentation" ><a href="#">操作</a></li>
      <li id="nav_ul_li5" role="presentation"><a href="#">帮助</a></li>
	</ul>
</div>

<div id="warp" class="jumbotron">
	<div class="container">
      <h1>学生管理系统</h1>
      <h2>Student Management System</h2>
      <br>
      <p>欢迎使用本系统！！<br>Welcome to my System！！
		</p>
      <p><a id="gowhere" class="btn btn-primary btn-lg" href="#" role="button">去登录</a></p>
  	</div>
</div>

</body>
</html>
