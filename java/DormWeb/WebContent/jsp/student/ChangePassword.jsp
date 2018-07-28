<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>修改密码</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/style/bootstrap/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/style/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/style/bootstrap/wow.min.js"></script>
<script src="${pageContext.request.contextPath }/style/js/student/Index.js"></script>
<script src="${pageContext.request.contextPath}/style/js/student/CPassword.js"></script>
<link href="${pageContext.request.contextPath}/style/css/admin/CPassword.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/style/css/student/top-index.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/style/css/student/Index.css" rel="stylesheet" type="text/css">
</head>
<style type="text/css">
    /* Custom Styles */
    ul.nav-tabs{
        margin-top: 20px;
        border-radius: 4px;
        border: 1px solid #ddd;
        box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
    }
    ul.nav-tabs li{
        margin: 0;
        border-top: 1px solid #ddd;
    }
    ul.nav-tabs li:first-child{
        border-top: none;
    }
    ul.nav-tabs li a{
        margin: 0;
        padding: 8px 16px;
        border-radius: 0;
    }
    ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover{
        color: #fff;
        background: #0088cc;
        border: 1px solid #0088cc;
    }
    ul.nav-tabs li:first-child a{
        border-radius: 4px 4px 0 0;
    }
    ul.nav-tabs li:last-child a{
        border-radius: 0 0 4px 4px;
    }
    ul.nav-tabs.affix{
        /*top: 30px;*/ /* Set the top position of pinned element */
    }
</style>

</head>


<body data-spy="scroll" data-target="#myScrollspy">

<!-- Fixed navbar -->
<!-- 导航栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand wow rubberBand" href="#">宿舍管理系统</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li ><a href="${pageContext.request.contextPath }/jsp/student/Index.jsp">首页</a></li>
            <li><a href="${pageContext.request.contextPath}/RCListServlet?JspId=StuRCLook">缺勤记录</a></li>
            
            
            <!-- 账号选项 -->
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账号选项<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li class="active"><a href="${pageContext.request.contextPath }/jsp/student/ChangePassword.jsp">修改密码</a></li>
                <li><a id="exitsys" href="javascript:void(0)">退出登录</a></li>
              </ul>
            </li>
            
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <!-- <li><a href="#">注册</a></li>
            <li><a href="#">退出</a></li> -->
            <li class="active"><a href="${pageContext.request.contextPath }/jsp/Login.jsp"><%=session.getAttribute("StuNum") %><span class="sr-only">(current)</span></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

<!-- 主体 -->
<div class="container">
    <div class="row">
    	<!-- 左侧附加导航 -->
        <div class="col-md-2 wow fadeInLeft" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" id="myNav">
                <li ><a href="${pageContext.request.contextPath }/jsp/student/Index.jsp">首页</a></li>
                <li ><a href="${pageContext.request.contextPath}/RCListServlet?JspId=StuRCLook">缺勤记录</a></li>
                <li class="active"><a href="${pageContext.request.contextPath }/jsp/student/ChangePassword.jsp">修改密码</a></li>
                <li><a id="exitLogin" href="javascript:void(0)">退出系统</a></li>
            </ul>
        </div>
        <!-- 右侧主体 -->
        <!--信息列表 -->
		<div id="right_container" class="container col-md-offset-2 col-md-6 wow fadeInRight" style="margin-top: 20px;" >
			<div id="warp" class="panel panel-default" style="padding:0px;">
		    <div class="panel-heading">修改密码界面</div>
		    <div class="panel-body row">
	           <form class="form-signin  col-sm-offset-3 col-sm-6" id="formcp" action="${pageContext.request.contextPath }/STUCPServlet" method="post">
					<input type="hidden" id="STUId" name="STUId" value="<%=session.getAttribute("STUId") %>" /> 
		           	<label for="inputEmail" class="">*原密码</label>
			        <input type="text" name="ppwd" id="ppwd" class="form-control" placeholder="请填写原密码" required autofocus>
			       
			        <label for="inputPassword" class="">*填写新密码</label>
			        <input type="password" name="npwd" id="npwd" class="form-control" placeholder="请填写新密码" required>
			        
			        <label for="inputPassword" class="">*再次填写新密码</label>
			        <input type="password" name="rnpwd" id="rnpwd" class="form-control" placeholder="请再次填写新密码" required>
			        <div class="checkbox">
			          <label id="msg"><%=request.getAttribute("rs") %></label>         
			        </div>
					
			        <button class="btn btn-lg btn-primary  btn-block btn-info" type="reset">重置</button>
			        <button id="btneditpwd" class="btn btn-lg btn-primary btn-block" type="button">修改密码</button>
		        	
	           </form>
		    </div>
		</div>
				
				    
				</div><!-- container -->
			</div><!-- right -->
		</div><!-- row -->

</body>
</html>