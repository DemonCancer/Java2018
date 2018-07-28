<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/login.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="logmessge">
	<button type="button" class="btn btn-lg " >
		用户名：<span id="adminUser"><%=session.getAttribute("adminUser") %></span>
      	登录时间：<span id="logTime"><%=session.getAttribute("logTime") %></span>
      	管理权限：<span id="adminRole"><%=session.getAttribute("adminRole")%></span>
	</button>
	<input type="hidden" value="<%=session.getAttribute("register")%>" id="isregister" />
</div>
<div id="nav">
	<ul id="nav_ul" class="nav nav-pills nav-justified">
      <li id="nav_ul_li1" role="presentation" ><a href="#">首页</a></li>
      <li id="nav_ul_li2" role="presentation" class="active"><a href="#">登录</a></li>
      <li id="nav_ul_li3" role="presentation"><a href="#">注册</a></li>
      <li id="nav_ul_li4" role="presentation"><a href="#">操作</a></li>
      <li id="nav_ul_li5" role="presentation"><a href="#">帮助</a></li>
      
	</ul>
</div>

<div id="warp" class="row">
	<div id="header">
		<span id="title" ><h4>学生管理系统登录</h4></span>
	</div>
	<form action="LoginServlet" method="post" name="login">
	<div id="main" >
	
		<table id="tbinput" class="table-responsive" border="0">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="pwd" name="pwd"/></td>
			</tr>
		</table>
	</div>
	<div id="footer">
		<input type="submit" id="submit" name="submit" value="登录" onClick="submit()"/>
		<input type="reset" id="exit" name="exit" value="返回"/>
	</div>
	</form>
</div>
</body>
</html>