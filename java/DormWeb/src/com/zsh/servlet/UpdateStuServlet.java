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
import com.zsh.pojo.DormManager;
import com.zsh.pojo.Student;

/**
 * Servlet implementation class UpdateStuServlet
 */
@WebServlet("/UpdateStuServlet")
public class UpdateStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		
		String stuNum=req.getParameter("stuNum");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String tel=req.getParameter("tel");
		String dormName=req.getParameter("dormName");
		int dormBuildId=Integer.parseInt(req.getParameter("dormBuildId"));
		//System.out.println("userName:"+userName+dormManId+dormBuildId);
		
		///
		Student stu=new Student();
		stu.setStuNum(stuNum);
		stu.setDormName(dormName);
		stu.setPassword(password);
		stu.setDormBuildId(dormBuildId);
		stu.setSex(sex);
		stu.setName(name);
		stu.setTel(tel);
		StuDaoImpl studaoimpl=new StuDaoImpl();
		if(studaoimpl.updateStuById(studentId, stu)){
			System.out.println("修改成功");
			out.print("修改成功");
		}else{
			System.out.println("修改失败");
			out.print("修改失败");
		}
		
		
		//System.out.println("dormManId:"+dormManId);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
