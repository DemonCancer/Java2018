<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=no">
<title>学生管理</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/style/bootstrap/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/style/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/style/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/style/bootstrap/wow.min.js"></script>
<script src="${pageContext.request.contextPath}/style/js/admin/Index.js"></script>
<script src="${pageContext.request.contextPath}/style/js/dormmanager/StuLook.js"></script>
<link href="${pageContext.request.contextPath}/style/css/admin/top-index.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/style/css/admin/Index.css" rel="stylesheet" type="text/css">
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
            <li ><a href="${pageContext.request.contextPath }/jsp/dormmanager/Index.jsp">首页</a></li>
            <!--查看学生  -->
            <li class="active"><a href="${pageContext.request.contextPath }/StuLookListServlet">学生查看</a></li>
            <!-- 缺勤记录 -->
            <li><a href="${pageContext.request.contextPath}/RCListServlet?JspId=DMRCManager">缺勤记录</a></li>
            <!-- 账号选项 -->
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">账号选项<span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="${pageContext.request.contextPath }/jsp/dormmanager/ChangePassword.jsp">修改密码</a></li>
                <li><a id="exitsys" href="javascript:void(0)">退出登录</a></li>
              </ul>
            </li>
            
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="${pageContext.request.contextPath }/jsp/Login.jsp"><%=session.getAttribute("DormMan") %><span class="sr-only">(current)</span></a></li>
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
                <li ><a href="${pageContext.request.contextPath }/jsp/dormmanager/Index.jsp">首页</a></li>
                <li class="active"><a href="${pageContext.request.contextPath }/StuLookListServlet">学生查看</a></li>
                <li><a href="${pageContext.request.contextPath}/RCListServlet?JspId=DMRCManager">缺勤记录</a></li>
                <li><a href="${pageContext.request.contextPath }/jsp/dormmanager/ChangePassword.jsp">修改密码</a></li>
                <li><a id="exitLogin" href="javascript:void(0)">退出系统</a></li>
            </ul>
        </div>
        <!-- 右侧主体 -->
        <div class="col-md-10 ">
            <!-- 学生信息列表 -->
			<div id="right_container" class="container" style="margin-top: 20px;" >
			
				<div class="col-md-10 row ">
					<!-- col-lg-12 -->
					<div class="col-md-12">
						<div class="panel panel-info " >
			                <div class="panel-heading" style="font-size: 17px;font-weight: bold;">宿舍管理员列表</div>
			                <form action="${pageContext.request.contextPath }/SearchStuLookServlet" class="form-horizontal" id="seacrch_stu_form" method="post">
			                 <div class="panel-body row">
			                 		
			                 		<div class="col-md-2 col-md-offset-5">
			                 			<select class="form-control" id="searchchoose" name="searchchoose">
			                 				<option value="学号" <c:if test="${choose=='学号'}">selected</c:if>>学号</option>
											<option value="宿舍楼号" <c:if test="${choose=='宿舍楼号'}">selected</c:if>>宿舍楼号</option>
											<option value="寝室号" <c:if test="${choose=='寝室号'}">selected</c:if>>寝室号</option>
											<option value="姓名" <c:if test="${choose=='姓名'}">selected</c:if>>姓名</option>
											<option value="电话" <c:if test="${choose=='电话'}">selected</c:if>>电话</option>
			                 			</select>
            						</div>
            						<div class="col-md-3">
			                 			<input type="text" class="form-control" id="txtsearch" name="txtsearch"  placeholder="请输入查询条件"/>
            						</div>
            						<button type="button" id="btnsearch" class="btn btn-danger col-md-1" style="margin-left: 5px;">查询</button>
			                 		
			                 </div>
			                 </form>
			                 <div class="table-responsive">
				                <table class="table table-bordered table-striped table-hover table-responsive" style="text-align: center;">
				                        <thead>	
					                            <tr>
					                                <th style="text-align: center;">学生ID</th>
					                                <th style="text-align: center;">学号</th>
					                                <th style="text-align: center;">密码</th>
					                                <th style="text-align: center;">姓名</th>
					                                <th style="text-align: center;">寝室号</th>
					                                <th style="text-align: center;">宿舍楼号</th>
					                                <th style="text-align: center;">性别</th>
					                                <th style="text-align: center;">电话</th>
					                                <th style="text-align: center;">添加到缺勤</th>
					                            </tr>
				                           
				                        </thead>
				                        <tbody>
				                        
				                        <c:if test="${StuList.size()==null||StuList.size()==0}">
												<tr>
													<td colspan="10" style="text-align: center;"><span
														style="display: block; margin: 30px 0; color: red; font-weight: bold;">查询不到该访问信息</span>
													</td>
												</tr>
										</c:if>
				                        <c:forEach items="${StuList}" var="stu">
				                            <tr>
				                            	<td>${stu.studentId }</td>
												<td>${stu.stuNum }</td>										
												<td>${stu.password }</td>
												<td>${stu.name }</td>
												<td>${stu.dormName }</td>
												<td>${stu.dormBuildId }</td>
												<td>${stu.sex }</td>
												<td>${stu.tel }</td>
												<td> <button type="button" id="btn_edit" onclick="FunGetData(this,${stu.studentId })" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#StuEditDialog">添加到缺勤</button></td>
											</tr>
										 </c:forEach>	
												
				                        </tbody>
				                    </table>
			                    </div>
			            </div><!-- panel panel-default -->
			        	    
			        </div><!-- col-lg-12 -->
					
					
					<!-- 分页 -->
		            <div>
		                <nav aria-label="..." style="text-align:center;">
		                  <ul class="pagination" style="margin:-10px 0px 10px 0px;">
		                    <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
		                      <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
		                      <li><a href="#">2<span class="sr-only">(current)</span></a></li>
		                      <li><a href="#">3<span class="sr-only">(current)</span></a></li>
		                      <li><a href="#">4<span class="sr-only">(current)</span></a></li>
		                      <li><a href="#">5<span class="sr-only">(current)</span></a></li>
		                  </ul>
		                </nav>
		            </div>
		            <!-- 分页 -->
				</div>
			    
			</div><!-- container -->
		</div><!-- right -->
	</div><!-- row -->
</div>

<!-- 编辑对话框 -->
	<div class="modal fade" id="StuEditDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_edit">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel_edit">添加缺勤信息</h4>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath }/InsertRCServlet" class="form-horizontal" id="edit_stu_form" method="post">
						<!-- Id -->
						<input type="hidden" name="studentId" id="edit_studentId">
						<!-- 头像  左右 -->
						<div class="container">
							<div class="row">
							</div>
						</div>
						<!-- 头像下 -->
						<!--  -->
						<div class="form-group">
							<label for="edit_gender" style="float: left; padding: 20px 15px 0 27px;">学号</label>
							<div class="col-sm-12">
								<input type="text" class="form-control" value="" id="edit_stuNum" name="stuNum" placeholder="请输入学号"/>
							</div>
						</div>
						
						<!--  -->
						<div class="form-group">
							<label for="edit_name" style="float: left; padding: 20px 15px 0 27px;">姓名</label>
							<div class="col-sm-12">
								<input type="text" class="form-control" value="" id="edit_name" name="stuname" placeholder="请输入姓名"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_gender" style="float: left; padding: 20px 15px 0 27px;">日期</label>
							<div class="col-sm-12">
								<input type="date" class="form-control" value="" id="edit_date" name="date" placeholder="请输入时间"/>
							</div>
						</div>
						<div class="form-group" style="margin-top: 10px;">
							<label for="edit_deptId" style="float: left; padding: 7px 15px 0 27px;">宿舍楼</label>
							<div class="col-sm-12">
								<select class="form-control" id="edit_dormBuildId" name="dormBuildId">
									<c:forEach items="${DBList}" var="db">
										<option value="${db.dormBuildId}">${db.dormBuildName}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_gender" style="float: left; padding: 20px 15px 0 27px;">详细信息</label>
							<div class="col-sm-12">
								<textarea class="form-control" value="" id="edit_detail" name="detail" placeholder="请输入备注"></textarea>
							</div>
						</div>
						<!--  -->		
					</form><!--  -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary btn-info" onclick="Funsubmit(this)" id="btnInsertRc">添加</button>
				</div><!-- footer -->
			</div>
		</div>
	</div>
	<!-- /#wrapper -->
	<!-- 提示模态框 -->
	
	<div class="modal fade bs-example-modal-sm" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog  modal-sm" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel"></h4>
	      </div>
	      <div class="modal-body">
	        <div style="text-align: center;margin: 10px 0;" id="modalShowMsg"></div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" id="btnHideModal" class="btn btn-primary" data-dismiss="modal">确定</button>
	      </div>
	    </div>
	  </div>
	</div>
	<!-- Modal -->



</body>
</html>