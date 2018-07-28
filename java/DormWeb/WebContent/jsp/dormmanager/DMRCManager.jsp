<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>缺勤记录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/style/bootstrap/animate.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/style/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath }/style/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/style/bootstrap/wow.min.js"></script>
<script src="${pageContext.request.contextPath }/style/js/dormmanager/Exit.js"></script>
<script src="${pageContext.request.contextPath}/style/js/dormmanager/DMRCManager.js"></script>
<link href="${pageContext.request.contextPath }/style/css/dormmanager/top-index.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/style/css/dormmanager/Index.css" rel="stylesheet" type="text/css">
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
            <li ><a href="${pageContext.request.contextPath }/jsp/dormmanager/Index.jsp">首页</a></li>
            <!--查看学生  -->
            <li><a href="${pageContext.request.contextPath }/StuLookListServlet">学生查看</a></li>
            <!-- 缺勤记录 -->
            <li class="active"><a href="${pageContext.request.contextPath}/RCListServlet?JspId=DMRCManager">缺勤记录</a></li>
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
                <li><a href="${pageContext.request.contextPath }/StuLookListServlet">学生查看</a></li>
                <li class="active"><a href="${pageContext.request.contextPath}/RCListServlet?JspId=DMRCManager">缺勤记录</a></li>
                <li><a href="${pageContext.request.contextPath }/jsp/dormmanager/ChangePassword.jsp">修改密码</a></li>
                <li><a id="exitLogin" href="javascript:void(0)">退出系统</a></li>
            </ul>
        </div>
        <!-- 右侧主体 -->
        <div class="col-md-10">
            <!--信息列表 -->
			<div id="right_container" class="container" style="margin-top: 20px;" >
			
				<div class="col-md-10 row ">
					<!-- col-lg-12 -->
					<div class="col-md-12">
						<div class="panel panel-info " >
							<!-- 面板头 -->
			                <div class="panel-heading table-responsive" style="font-size: 17px;font-weight: bold;">缺勤列表</div>
			                <form action="${pageContext.request.contextPath }/SearchRCServlet?JspId=DMRC" class="form-horizontal" id="seacrch_RC_form" method="post">
			                 <div class="panel-body row">
			                 	
			                 		<div class=" col-md-2 col-md-offset-1">
			                 			<input type="date" class="form-control" id="txtdate" name="txtdate"  placeholder="时间" style="font-size:12px;"/>
            						</div>
            						<div class=" col-md-2">
			                 			<input type="date" class="form-control" id="txtdate1" name="txtdate1"  placeholder="时间" style="font-size:12px;"/>
            						</div>
			                 		<div class="col-md-2 ">
			                 			<select class="form-control" id="searchchoose" name="searchchoose" style="font-size:12px;">
											<option value="宿舍楼号" <c:if test="${choose=='宿舍楼号'}">selected</c:if>>宿舍楼号</option>
											<option value="学号" <c:if test="${choose=='学号'}">selected</c:if>>学号</option>
											<option value="姓名" <c:if test="${choose=='姓名'}">selected</c:if>>姓名</option>											
			                 			</select>
            						</div>
            						<div class=" col-md-2">
			                 			<input type="text" class="form-control" id="txtsearch" name="txtsearch"  placeholder="查询条件" style="font-size:12px;"/>
            						</div>
            						

			                 		
            						<button type="button" id="btnsearch" onclick="SearchFun(this)" class=" btn btn-danger col-md-1 col-sm-6  col-xs-5 "  style="margin-left:5px ;">查询</button>
            						<button type="button" id="btnaddRC" onclick="AddRCFun(this)" class=" btn btn-info col-md-1 col-sm-6 col-xs-5 "  style="margin-left:5px ;" data-toggle="modal" data-target="#RCAddDialog">添加</button>
			                 		
			                 </div>
			                 </form>
			                 	<div class="table-responsive">
				                <table class="table table-bordered table-striped table-hover " style="text-align: center; border-top:0px;">
				                        <!-- 表头 -->
				                        <thead>
					                     	 <tr>
				                                <th style="text-align: center;">日期</th>
				                                <th style="text-align: center;">学号</th>
				                                <th style="text-align: center;">学生姓名</th>
				                                <th style="text-align: center;">宿舍楼</th>
				                                <th style="text-align: center;">寝室号</th>
				                                <th style="text-align: center;">详细信息</th>
				                                <th style="text-align: center;">删除</th>
				                            </tr>
				                        </thead>
				                        <!-- 表格数据 -->
				                        <tbody>
				                        <c:if test="${RCList.size()==null||RCList.size()==0}">
												<tr>
													<td colspan="9" style="text-align: center;"><span
														style="display: block; margin: 30px 0; color: red; font-weight: bold;">查询不到该访问信息</span>
													</td>
												</tr>
										</c:if>
				                        <c:forEach items="${RCList}" var="rc">
				                            <tr>
												<td>${rc.date}</td>
												<td>${rc.studentNumber }</td>
												<td>${rc.studentName }</td>
												<td>${rc.dormBuildId }</td>
												<td>${rc.dormName }</td>
												<td>${rc.detail }</td>
												<td> <button type="button" id="btn_edit" onclick="editFun(this,${rc.recordId },${rc.studentNumber })" class="btn btn-info btn-xs" data-toggle="modal" data-target="#RCGetDialog">修改</button></td>
												<td> <button type="button" id="btn_del" onclick="deleteFun(this,${rc.recordId },${rc.studentNumber })" class="btn btn-danger btn-xs" >删除</button></td>
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
        </div>
    </div><!--  -->
</div>
<!--  -->
	<div class="modal fade" id="RCAddDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_edit">
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
						<input type="hidden" name="recordId" id="add_recordId">
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
								<input type="text" class="form-control" value="" id="add_studentNumber" name="studentNumber" placeholder="请输入学号"/>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="edit_gender" style="float: left; padding: 20px 15px 0 27px;">日期</label>
							<div class="col-sm-12">
								<input type="date" class="form-control" value="" id="add_date" name="date" placeholder="请输入时间"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="edit_gender" style="float: left; padding: 20px 15px 0 27px;">详细信息</label>
							<div class="col-sm-12">
								<textarea class="form-control" value="" id="add_detail" name="detail" placeholder="请输入备注"></textarea>
							</div>
						</div>
						<!--  -->		
					</form><!--  -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary btn-info" onclick="Funsubmit(this)" id="btnAddRC">添加</button>
				</div><!-- footer -->
			</div>
		</div>
	</div>
	<!-- /#wrapper -->
	
	<!-- /#wrapper -->
<!-- 编辑对话框 -->
	<!-- 编辑对话框 -->
	<div class="modal fade" id="RCGetDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_edit">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel_edit">修改缺勤信息</h4>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath }/UpdateRCServlet" class="form-horizontal" id="edit_dm_form" method="post">
						<!-- Id -->
						<input type="hidden" name="recordId" id="edit_recordId">
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
								<input type="text" class="form-control" value="" id="edit_studentNumber" name="studentNumber" placeholder="请输入学号"/>
							</div>
						</div>
						<!--  -->
						<div class="form-group">
							<label for="edit_gender" style="float: left; padding: 20px 15px 0 27px;">学生姓名</label>
							<div class="col-sm-12">
								<input type="text" class="form-control" value="" id="edit_studentName" name="studentName" placeholder="请输入学生姓名"/>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_name" style="float: left; padding: 20px 15px 0 27px;">备注</label>
							<div class="col-sm-12">
								<textarea class="form-control" value="" id="edit_detail" name="detail" placeholder="请输入备注"></textarea>
							</div>
						</div>	
						<!--  -->		
					</form><!--  -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="btnUpdateRC">保存修改</button>
				</div><!-- footer -->
			</div>
		</div>
	</div>
	<!-- /#wrapper -->
<!-- 编辑对话框 -->
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
<!-- 删除模态框 -->
<!-- Modal -->
<div class="modal fade bs-example-modal-sm" id="myDeleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel_delete">
  <div class="modal-dialog  modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel_delete">提示</h4>
      </div>
      <div class="modal-body">
        <div style="text-align: center;margin: 10px 0;" id="modalShowMsg_del"></div>
      </div>
      <div class="modal-footer">
        <button type="button"  class="btn btn-primary" data-dismiss="modal">取消</button>
        <button type="button" id="btn_deleteRC" class="btn btn-primary" data-dismiss="modal">确定</button>
      </div>
    </div>
  </div>
</div>
<!--  -->

</body>
</html>