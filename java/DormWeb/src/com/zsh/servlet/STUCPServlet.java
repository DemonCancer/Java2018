package com.zsh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsh.dap.impl.StuDaoImpl;
import com.zsh.pojo.DormManager;
import com.zsh.pojo.Student;

/**
 * Servlet implementation class STUCPServlet
 */
@WebServlet("/STUCPServlet")
public class STUCPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		///获取
		int STUId=Integer.parseInt(req.getParameter("STUId"));
		String ppwd=req.getParameter("ppwd");
		String npwd=req.getParameter("npwd");
		String rnpwd=req.getParameter("rnpwd");
		System.out.println(ppwd+npwd+rnpwd+STUId);
		//根据ID获取password

		String sql1=" and studentId =? ";
		String[] params1={STUId+""};
		
		
		StuDaoImpl studaoimpl=new StuDaoImpl();
		List<Student> stuList=studaoimpl.getStudentByDynamicWhere(sql1, params1);
		//boolean role=false;
		//判断有没有值传回来
		HttpSession session = req.getSession();
		if(stuList.size()>0){
			if(stuList.get(0).getPassword().equals(ppwd)){
				///修改密码
				Student stu=new Student();
				stu.setPassword(rnpwd);
				if(studaoimpl.updateStuPWDById(STUId, stu)){
					System.out.println("修改密码成功！");
					session.setAttribute("StuName",stuList.get(0).getStuNum());
					session.setAttribute("STUId",stuList.get(0).getStudentId());
					session.setAttribute("LoginStaus","*密码修改成功*");
					resp.sendRedirect("jsp/Login.jsp");
				}else{
					req.setAttribute("rs","*网络断开404，稍后重试...！");
					req.getRequestDispatcher("jsp/student/ChangePassword.jsp").forward(req, resp); 
				}
			}else{
				System.out.println("原密码不正确!");
				req.setAttribute("rs","*原密码不正确！");
				req.getRequestDispatcher("jsp/student/ChangePassword.jsp").forward(req, resp); 
			}
		}else{
			req.setAttribute("rs","*网络断开500，稍后重试...！");
			req.getRequestDispatcher("jsp/student/ChangePassword.jsp").forward(req, resp); 
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
