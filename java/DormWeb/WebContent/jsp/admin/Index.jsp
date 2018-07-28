<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>首页</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/style/bootstrap/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.css">

<script
	src="${pageContext.request.contextPath }/style/js/jquery-3.3.1.min.js"></script>
<script
	src="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/style/bootstrap/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/style/js/admin/Exit.js"></script>
<link
	href="${pageContext.request.contextPath }/style/css/admin/top-index.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath }/style/css/admin/Index.css"
	rel="stylesheet" type="text/css">
</head>
<style type="text/css">
/* Custom Styles */
ul.nav-tabs {
	margin-top: 20px;
	border-radius: 4px;
	border: 1px solid #ddd;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
}

ul.nav-tabs li {
	margin: 0;
	border-top: 1px solid #ddd;
}

ul.nav-tabs li:first-child {
	border-top: none;
}

ul.nav-tabs li a {
	margin: 0;
	padding: 8px 16px;
	border-radius: 0;
}

ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover {
	color: #fff;
	background: #0088cc;
	border: 1px solid #0088cc;
}

ul.nav-tabs li:first-child a {
	border-radius: 4px 4px 0 0;
}

ul.nav-tabs li:last-child a {
	border-radius: 0 0 4px 4px;
}

ul.nav-tabs.affix {
	top: 30px; /* Set the top position of pinned element */
}
</style>

</head>
<body data-spy="scroll" data-target="#myScrollspy">

	<!-- Fixed navbar -->
	<!-- 导航栏 -->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand wow rubberBand" href="#">宿舍管理系统</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath}/jsp/admin/Index.jsp">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/RCListServlet?JspId=RCManager">缺勤记录</a></li>

				<!-- 管理选项 -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">管理选项<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath }/DMListServlet">宿舍管理员管理</a></li>
						<li><a
							href="${pageContext.request.contextPath }/StuListServlet">学生管理</a></li>
						<li><a
							href="${pageContext.request.contextPath }/DBListServlet">宿舍楼管理</a></li>
						
					</ul></li>
				<!-- 账号选项 -->
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账号选项<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath }/jsp/admin/ChangePassword.jsp">修改密码</a></li>
						<li><a id="exitsys" href="#">退出系统</a></li>
					</ul></li>

			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a
					href="${pageContext.request.contextPath }/jsp/Login.jsp"><%=session.getAttribute("AdminName")%><span
						class="sr-only">(current)</span></a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>

	<!-- 主体 -->
	<div class="container">
		<div class="row">
			<!-- 左侧附加导航 -->
			<div class="col-md-2 wow fadeInLeft" id="myScrollspy">
				<ul class="nav nav-tabs nav-stacked" id="myNav">
					<li class="active"><a href="${pageContext.request.contextPath}/jsp/admin/Index.jsp">首页</a></li>
					<li><a
						href="${pageContext.request.contextPath }/DMListServlet">宿舍管理员管理</a></li>
					<li><a
						href="${pageContext.request.contextPath }/StuListServlet">学生管理</a></li>
					<li><a
						href="${pageContext.request.contextPath }/DBListServlet">宿舍楼管理</a></li>
					<li><a href="${pageContext.request.contextPath}/RCListServlet?JspId=RCManager">缺勤记录</a></li>
					<li><a href="${pageContext.request.contextPath }/jsp/admin/ChangePassword.jsp">修改密码</a></li>
					<li><a id="exitLogin" href="#">退出系统</a></li>
				</ul>
			</div>
			<!-- 右侧主体 -->
			<div class="col-md-10 wow slideInDown rubberBand">
				<h1 id="title" class="">欢迎您，系统管理员</h1>
			</div>
		</div>
		<!--  -->
	</div>

</body>
</html>