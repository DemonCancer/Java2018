<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生管理系统注册页面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/register.js"></script>
<link rel="stylesheet" href="css/register.css">
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
      <li id="nav_ul_li1" role="presentation" ><a href="I#">首页</a></li>
      <li id="nav_ul_li2" role="presentation" ><a href="#">登录</a></li>
      <li id="nav_ul_li3" role="presentation" class="active"><a href="#">注册</a></li>
      <li id="nav_ul_li4" role="presentation" ><a href="#">操作</a></li>
      <li id="nav_ul_li5" role="presentation" ><a href="#">帮助</a></li>
      
	</ul>
</div>

<div id="warp">
<form action="RegisterServlet" method="post" name="register">
	<div id="header">
		<span id="title"><h4>学生管理系统注册</h4></span>
	</div>
	<div id="main">
		<table id="tbinput" border="0">
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="username" id="username" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" id="pwd" name="pwd"/></td>
			</tr>
            <tr>
				<td>确认密码：</td>
				<td><input type="password" id="repwd" name="repwd"/></td>
			</tr>
		</table>
	</div>
	<div id="footer">
		<input type="submit" id="submit" name="submit" value="注册" onClick="submit()"/>
		<input type="reset" id="exit" name="exit" value="返回"/>
	</div>
</form>
</div>

</body>
</html>