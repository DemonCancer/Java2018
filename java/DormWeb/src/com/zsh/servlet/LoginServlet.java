package com.zsh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsh.dap.impl.AdminDaoImpl;
import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.dap.impl.StuDaoImpl;
import com.zsh.pojo.Admin;
import com.zsh.pojo.DormManager;
import com.zsh.pojo.Student;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//PrintWriter out = resp.getWriter();
		//拿值
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		String role=req.getParameter("role");
		String test=req.getParameter("test");
		System.out.println(userName+password+role+test);
		
		String sql="";
		HttpSession session = req.getSession();
		switch (role) {
		case "0":
			System.out.println("进入admin");
			System.out.println("username:"+userName+"pwd:"+password);
			//创建admindaoimpl对象
			AdminDaoImpl admindaoimpl=new AdminDaoImpl();
			//创建查询语句连接原来的SQL_SELECT
			sql = " and userName=? and password=?";
			//创建参数
			String[] params = { userName, password };
			//创建Admin类型的list集合,进行查询
			List<Admin> adminList=admindaoimpl.getAdminByDynamicWhere(sql, params);
			//boolean role=false;
			//判断有没有值传回来
			
			if(adminList.size()>0){
				System.out.println("登陆成功！！");
				session.setAttribute("AdminName",userName);
				session.setAttribute("AdminId",adminList.get(0).getAdminId());
				session.setAttribute("LoginStaus","&nbsp;");
				resp.sendRedirect("jsp/admin/Index.jsp");
				
			}else{
				System.out.println("登录失败！！");
				session.setAttribute("LoginStaus","*用户名或密码错误*");
				resp.sendRedirect("jsp/Login.jsp");
			}
			break;
		case "1":
			System.out.println("进入dormManager");
			System.out.println("username:"+userName+"pwd:"+password);
			//创建admindaoimpl对象
			DMDaoImpl dmdaoimpl=new DMDaoImpl();
			//创建查询语句连接原来的SQL_SELECT
			sql= " and userName=? and password=?";
			//创建参数
			String[] params1 = { userName, password };
			//创建Admin类型的list集合,进行查询
			List<DormManager> dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql, params1);
			//boolean role=false;
			//判断有没有值传回来
			if(dmList.size()>0){
				System.out.println("登陆成功！！");
				session.setAttribute("DormMan",userName);
				session.setAttribute("DMId",dmList.get(0).getDormManId());
				session.setAttribute("LoginStaus","&nbsp;");
				resp.sendRedirect("jsp/dormmanager/Index.jsp");
				
			}else{
				System.out.println("登录失败！！");
				session.setAttribute("LoginStaus","*用户名或密码错误*");
				resp.sendRedirect("jsp/Login.jsp");
			}
			break;
		case "2":
			System.out.println("进入student");
			System.out.println("username:"+userName+"pwd:"+password);
			//创建admindaoimpl对象
			StuDaoImpl studaoimpl=new StuDaoImpl();
			//创建查询语句连接原来的SQL_SELECT
			sql = " and stuNum=? and password=?";
			//创建参数
			String[] params2 = { userName, password };
			//创建Admin类型的list集合,进行查询
			List<Student> stuList=studaoimpl.getStudentByDynamicWhere(sql, params2);
			//boolean role=false;
			//判断有没有值传回来
			if(stuList.size()>0){
				System.out.println("登陆成功！！");
				session.setAttribute("StuNum",userName);
				session.setAttribute("STUId",stuList.get(0).getStudentId());
				session.setAttribute("LoginStaus","&nbsp;");
				resp.sendRedirect("jsp/student/Index.jsp");
				
			}else{
				System.out.println("登录失败！！");
				session.setAttribute("LoginStaus","*用户名或密码错误*");
				resp.sendRedirect("jsp/Login.jsp");
			}
			break;

		default:
			break;
		}
		
		/*if(role.equals("0")){
			
			
		}else if(role.equals("1")){
			
			System.out.println("进入dorm");
			resp.sendRedirect("jsp/dormmanager/Index.jsp");
		}else if(role.equals("2")){
			
		}else{
			
		}*/
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
		
				
	}

}
