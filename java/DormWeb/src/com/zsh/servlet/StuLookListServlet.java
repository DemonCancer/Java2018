package com.zsh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DBDaoImpl;
import com.zsh.dap.impl.StuDaoImpl;
import com.zsh.pojo.DormBuild;
import com.zsh.pojo.Student;

/**
 * Servlet implementation class StuLookListServlet
 */
@WebServlet("/StuLookListServlet")
public class StuLookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = resp.getWriter();
		//拿值
		
		
		//System.out.println(userName+password+role+test);
		
		//创建admindaoimpl对象
		StuDaoImpl studaoimpl=new StuDaoImpl();
		DBDaoImpl dbdaoimpl=new DBDaoImpl();
		//创建查询语句连接原来的SQL_SELECT
		
		
		//创建Admin类型的list集合,进行查询
		List<Student> stuList=studaoimpl.getAllStudent();
		List<DormBuild> dbList=dbdaoimpl.getAllDormBuild();
		//boolean role=false;
		//判断有没有值传回来
		if(stuList.size()>0){
			System.out.println("stuList成功！！");
			request.setAttribute("StuList",stuList);
			 
			//response..sendRedirect("jsp/admin/DMManager.jsp");
			
		}else{
			System.out.println("stuList失败！！");
			response.sendRedirect("jsp/dormmanager/Index.jsp");
		}
		if(dbList.size()>0){
			System.out.println("DBList成功！！");
			request.setAttribute("DBList",dbList);  
		}else{
			response.sendRedirect("jsp/dormmanager/Index.jsp");
		}
		request.getRequestDispatcher("jsp/dormmanager/StuLook.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
