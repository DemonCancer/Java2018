<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>帮助页面</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="jquery/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/Help.js"></script>
<link href="css/Help.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="logmessge">
	<button type="button" class="btn btn-lg " >
		用户名：<span id="adminUser"><%=session.getAttribute("adminUser") %></span>
      	登录时间：<span id="logTime"><%=session.getAttribute("logTime") %></span>
      	管理权限：<span id="adminRole"><%=session.getAttribute("adminRole")%></span>
	</button>
</div>
<div id="nav">
	<ul id="nav_ul" class="nav nav-pills nav-justified">
      <li id="nav_ul_li1" role="presentation" ><a href="#">首页</a></li>
      <li id="nav_ul_li2" role="presentation" ><a href="#">登录</a></li>
      <li id="nav_ul_li3" role="presentation"><a href="#">注册</a></li>
      <li id="nav_ul_li4" role="presentation" ><a href="#">操作</a></li>
      <li id="nav_ul_li5" role="presentation" class="active"><a href="#">帮助</a></li>
	</ul>
</div>

<div id="warp" class="jumbotron row">
	<div class="container">
      <h1>学生管理系统帮助页面</h1>
      <p></p>
      <br/>
      <h2>如果你想知道怎么使用这个系统，<br/><p></p>请点击这里
      <img src="img/goto.png"></img>
      <a class="btn btn-primary btn-lg" href="#" data-toggle="modal" data-target="#Instruction">使用说明</a>&nbsp;&nbsp;&nbsp;&nbsp;
      </h2>
      <br>
      <h2 id="SclMess">如果你想修改学院的信息，<br/><p></p>请点击这里
      <img src="img/goto.png"></img>
      <a  class="btn btn-primary btn-lg" href="#" data-toggle="modal" data-target="#EditProMo">学院信息</a>&nbsp;&nbsp;&nbsp;&nbsp;ps:如果你有权限的话
      <img src="img/timg.jpg"></img>
      </h2>
      <br>
      <p></p>
      <h2>最后如果你想知道更多关于本系统的信息，<br/><p></p>请点击这里
      <img src="img/goto.png"></img>
      <a class="btn btn-primary btn-lg" href="#" data-toggle="modal" data-target="#MoreMess">更多信息</a>&nbsp;&nbsp;&nbsp;&nbsp;
      </h2>
      <br>
      <p></p>
      <h2><span id="spanfeel">觉得这个系统怎么样，评个分?</span><br/><p></p>
      <div class="row">
		     <div id="feel" class="col-md-12">
			      <ul id="star" >
				      	<li >
				      		<img id="star_img" src="img/star0.png"></img>
				      	</li>
				      	<li>
				      		<img id="star_img" src="img/star0.png"></img>
				      	</li>
				      	<li>
				      		<img id="star_img" src="img/star0.png"></img>
				      	</li>
				      	<li>
				      		<img id="star_img" src="img/star0.png"></img>
				      	</li>
				      	<li>
				      		<img id="star_img" src="img/star0.png"></img>
				      	</li>
			      </ul>
			      
		     </div>
		     <br/><p></p>
		     <a id="subfeel" class="btn btn-primary btn-lg col-md-3" href="#" >提交评分</a>
		    <p></p>
      </div>
      <br/><br/>
      </h2>
  	</div>
</div>


<!--说明书-->
<div class="row">
	<!--遮罩层-->
	<div class="modal fade " id="Instruction" tabindex="-1" role="dialog" aria-labelledby="InstructionTitle" aria-hidden="true">
	    <!-- /.modal -->
	    <div class="modal-dialog ">
	    	<!-- /.modal-主体 -->
	        <div id="modal-content" class="modal-content ">
	        
	            <div class="modal-header">
	            	<!--关闭按钮和标题-->
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="InstructionTitle">使用说明</h3>
	            </div>
	            <!--主体文本  -->
	            <div class="modal-body">
	            	<h3 id="incontent">
	            		关于本系统：本系统面向管理员，可以对学生信息进行增删改查，方便管理员的使用。
	            		<p></p>
	            		关于登录：为防止无关人员恶意登录本系统，本系统单独对管理员进行管理，若想登录，必须在本系统内有过登录记录或者注册账号。
	            		<p></p>
	            		关于注册：本系统可以对管理员进行信息的注册，注册后方可登陆本系统获得权限后可对本系统进行管理。
	            		<p></p>
	            		关于使用：根据页面上的文字提示或点击，或输入，傻瓜式操作，满足您的使用需求。
	            	</h3>
				</div>
	            <!--关闭按钮  -->
	            <div class="modal-footer">
	                <!-- <button id="conbtn" type="button" class="btn btn-default btn btn-primary btn-lg" >继续观看</button> -->
	                <button type="button" class="btn btn-default btn btn-primary btn-lg" data-dismiss="modal">我知道了</button>
	                <!--<button type="button" class="btn btn-primary">提交更改</button>-->
	            </div>
	            
	        </div><!-- /.modal-主体 -->
	        
	    </div><!-- /.modal -->
	    
	</div>
	
</div>
<!-- 更多信息 -->
<div class="row" id="moremessage">
<!--遮罩层-->
	<div class="modal fade " id="MoreMess" tabindex="-1" role="dialog" aria-labelledby="MoreMessTitle" aria-hidden="true">
	    <!-- /.modal -->
	    <div class="modal-dialog ">
	    	<!-- /.modal-主体 -->
	        <div id="modal-content" class="modal-content ">
	        
	            <div class="modal-header">
	            	<!--关闭按钮和标题-->
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="MoreMessTitle">更多信息</h3>
	            </div>
	            <!--主体文本  -->
	            <div class="modal-body">
	            	<h3 id="MoreMessspan">
	            		系统版权所有©2018ZSH
	            	</h3>
				</div>
	            <!--关闭按钮  -->
	            <div class="modal-footer">
	                <!-- <button id="conbtn" type="button" class="btn btn-default btn btn-primary btn-lg" >继续观看</button> -->
	                <button  type="button" class="btn btn-default btn btn-primary btn-lg" data-dismiss="modal">我知道了</button>
	                <!--<button type="button" class="btn btn-primary">提交更改</button>-->
	            </div>
	            
	        </div><!-- /.modal-主体 -->
	        
	    </div><!-- /.modal -->
	    
	</div>
</div>
<!-- 修改专业 -->
<div class="row" id="EditPro">
<!--遮罩层-->
	<div class="modal fade " id="EditProMo" tabindex="-1" role="dialog" aria-labelledby="EditProTitle" aria-hidden="true">
	    <!-- /.modal -->
	    <div class="modal-dialog ">
	    	<!-- /.modal-主体 -->
	        <div id="modal-content" class="modal-content ">
	        
	            <div class="modal-header">
	            	<!--关闭按钮和标题-->
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="EditProTitle">更多信息</h3>
	            </div>
	            <!--主体文本  -->
	            <div class="modal-body">
	            <h4>
	            		<table id="protab" class="table table-condensed table-hover table-responsive">
	            			<thead id="prolist">
								<tr >
									<th>ID</th>
									<th>专业</th>
								</tr>
							</thead>
							<tbody id="protablist"> 
							</tbody>
						</table>
	            	</h4>	
				</div>
	            <!--关闭按钮  -->
	            <div class="modal-footer">
	                <button id="btnadd" class="btn btn-default btn btn-primary btn-lg" data-toggle="modal" data-target="#AddPro">添加专业</button>
	                <button id="okadd" type="button" class="btn btn-default btn btn-primary btn-lg" data-dismiss="modal">我知道了</button>
	                <!--<button type="button" class="btn btn-primary">提交更改</button>-->
	            </div>
	            
	        </div><!-- /.modal-主体 -->
	        
	    </div><!-- /.modal -->
	    
	</div>
</div>
<!--  -->
<!-- 添加专业 -->
<div class="row" id="AddProDiv">
<div class="modal fade " id="AddPro" tabindex="-1" role="dialog" aria-labelledby="AddProTitle" aria-hidden="true">
	    <!-- /.modal -->
	    <div class="modal-dialog " id="adddia">
	    	<!-- /.modal-主体 -->
	        <div id="addcon" class="modal-content ">
	        	<div class="modal-header">
	            	<!--关闭按钮和标题-->
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h3 class="modal-title" id="AddProTitle">添加专业</h3>
	            </div>
	            <!--主体文本  -->
	            <div class="modal-body">
	            		<label class="">专业名称：</label>
	            		<input id="txtaddpro" type="text" class="form-control"/>
	            		<p></p>
				</div>
	            <!--关闭按钮  -->
	            <div class="modal-footer">
	            
					<label id="addres"></label>&nbsp;&nbsp;&nbsp;
					
	                <button id="btnokadd" class="btn btn-default btn btn-primary btn-lg" >确认添加</button>
	            </div>
	            
	        </div><!-- /.modal-主体 -->
	        
	    </div><!-- /.modal -->
	    
	</div>
</div>

</body>
</html>