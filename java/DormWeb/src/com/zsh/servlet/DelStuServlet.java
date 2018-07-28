package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.dap.impl.StuDaoImpl;

/**
 * Servlet implementation class DelStuServlet
 */
@WebServlet("/DelStuServlet")
public class DelStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		
		StuDaoImpl studaoimpl=new StuDaoImpl();
		if(studaoimpl.delStuById(studentId)){
			System.out.println("删除成功");
			out.print("删除成功");
		}else{
			System.out.println("删除失败");
			out.print("删除失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}

