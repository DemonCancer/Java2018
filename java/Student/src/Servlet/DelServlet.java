package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.StudentDaoImpl;

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setHeader("content-type", "text/html;charset=UTF-8");  
		resp.setCharacterEncoding("UTF-8");  
		req.setCharacterEncoding("UTF-8");  
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		///
		int id= Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		
		//
		StudentDaoImpl studaoimpl=new StudentDaoImpl();
		
		if(studaoimpl.delStudentById(id)){
			System.out.println("删除成功");
			out.print("删除成功");
		}else{
			System.out.println("删除失败");
			out.print("删除失败");
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
