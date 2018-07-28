package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Student;
import DaoImpl.StudentDaoImpl;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader("content-type", "text/html;charset=UTF-8");  
		resp.setCharacterEncoding("UTF-8");  
		req.setCharacterEncoding("UTF-8");  
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//获取数据
		String userno=req.getParameter("txtuserno");
		String username=req.getParameter("txtusername");
		String profession=req.getParameter("txtprofession");
		System.out.println(userno+","+username+","+profession);
		////
		StudentDaoImpl studaoimpl=new StudentDaoImpl();
		//
		//创建查询语句连接原来的SQL_SELECT
		String sql = "";
		/////创建参数
		List<String> sqlParams=new ArrayList<String>();
		if(userno!=null&&userno.length()>0){
			sql+=" and userno like ?";
			sqlParams.add("%"+userno+"%");
		}
		if(username!=null&&username.length()>0){
			sql+=" and username like ?";
			sqlParams.add("%"+username+"%");
		}
		if(profession!=null&&profession.length()>0){
			sql+=" and profession=?";
			sqlParams.add(profession);
		}
		//
		System.out.println(sql);
		
		//创建Student类型的list集合,进行查询
		List<Student> stulist=studaoimpl.getStudentByDynamicWhere(sql, sqlParams.toArray(new String[sqlParams.size()]));
		///
		HttpSession session = req.getSession();
		session.setAttribute("stuList", stulist);
		out.print(stulist);
		///
		resp.sendRedirect("StuList.jsp");
		
	}

}
