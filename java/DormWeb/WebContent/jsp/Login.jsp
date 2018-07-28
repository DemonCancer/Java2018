<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>登录页面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/style/bootstrap/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/style/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/style/bootstrap/wow.min.js"></script>
<script src="${pageContext.request.contextPath }/style/js/Login.js"></script>
<link href="${pageContext.request.contextPath }/style/css/Login.css" rel="stylesheet" type="text/css">
</head>
<div  class="container col-md-offset-4 col-md-4 col-sm-offset-3 col-sm-6  wow fadeInRight">
	<div id="warp" class="panel panel-default" style="padding:0px;">
	    <div class="panel-heading hidden-md hidden-sm hidden-xs ">登陆界面</div>
	    <div class="panel-body">
	           <form class="form-signin  row" action="${pageContext.request.contextPath }/LoginServlet" method="post">
		        <h2 class="form-signin-heading">宿舍管理系统</h2>
		        
		        <label for="inputEmail" class="sr-only">Email address</label>
		        <input type="text" name="userName" id="userName" class="form-control" placeholder="请填写用户名" required autofocus>
		       
		        <label for="inputPassword" class="sr-only">Password</label>
		        <input type="password" name="password" id="password" class="form-control" placeholder="请填写密码" required>
		        
		        <div class="checkbox">
		        <label>
		            <input id="role" type="radio" id="role"  name="role" value="0" checked="checked"> 系统管理员
		          </label>
		          <label>
		            <input id="role" type="radio" id="role"  name="role" value="1"> 宿舍管理员
		          </label>
		          <label>
		            <input id="role" type="radio" id="role"  name="role" value="2"> 学生
		          </label>
		          <br>
		          <label>
		            <input id="remember-me" type="checkbox" value="remember-me"> 记住密码
		          </label>
		          <label id="msg"><%=session.getAttribute("LoginStaus") %></label>
		          
		          
		        </div>
		        <!-- <div class="form-group row" style="padding-left:15px;">
				    <input type="text" id="VerCode" class="form-control" placeholder="请填写验证码" required/>
				    <img id="VerCodeimg" alt="" src="../style/image/code.png" height="50px" width="90px">
				</div> -->
				
	
		        
		        <button class="btn btn-lg btn-primary  btn-block btn-info" type="reset">重置</button>
		        <button id="btnlogin" class="btn btn-lg btn-primary btn-block" type="button">登录</button>
		      </form>
	      </div>
	</div>
</div>
</body>
</html>