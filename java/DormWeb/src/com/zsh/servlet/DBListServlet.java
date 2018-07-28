package com.zsh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DBDaoImpl;
import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.pojo.DormBuild;
import com.zsh.pojo.DormManager;

/**
 * Servlet implementation class DBListServlet
 */
@WebServlet("/DBListServlet")
public class DBListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码
				request.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				//PrintWriter out = resp.getWriter();
				//拿值
				
				
				//System.out.println(userName+password+role+test);
				
				//创建admindaoimpl对象
				DBDaoImpl dbdaoimpl=new DBDaoImpl();
				//创建查询语句连接原来的SQL_SELECT
				
				
				//创建Admin类型的list集合,进行查询
				List<DormBuild> dbList=dbdaoimpl.getAllDormBuild();
				//boolean role=false;
				if(dbList.size()>0){
					System.out.println("DBList成功！！");
					request.setAttribute("DBList",dbList);  
				}else{
					response.sendRedirect("jsp/admin/Index.jsp");
				}
				//获取空闲的管理员
				DMDaoImpl dmdaoimpl=new DMDaoImpl();
				String sql1=" and dormBuildId = ? ";
				String[] sqlParams = {0+""};
				List<DormManager> DManList=dmdaoimpl.getDormManagerByDynamicWhere(sql1, sqlParams);
				if(DManList.size()>0){
					System.out.println("DManList成功！！");
					request.setAttribute("DManList",DManList);  
				}else{
				}
				
				
				request.getRequestDispatcher("jsp/admin/DBManager.jsp").include(request, response); 
			}

			/**
			 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
			 */
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request,response);
			}
}