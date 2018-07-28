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
import com.zsh.pojo.Admin;

/**
 * Servlet implementation class AdminCPServlet
 */
@WebServlet("/AdminCPServlet")
public class AdminCPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		///获取
		int AdminId=Integer.parseInt(req.getParameter("AdminId"));
		String ppwd=req.getParameter("ppwd");
		String npwd=req.getParameter("npwd");
		String rnpwd=req.getParameter("rnpwd");
		System.out.println(ppwd+npwd+rnpwd+AdminId);
		//根据ID获取password

		String sql1=" and adminId =? ";
		String[] params1={AdminId+""};
		
		
		AdminDaoImpl addaoimpl=new AdminDaoImpl();
		List<Admin> adminList=addaoimpl.getAdminByDynamicWhere(sql1, params1);
		//boolean role=false;
		//判断有没有值传回来
		HttpSession session = req.getSession();
		if(adminList.size()>0){
			if(adminList.get(0).getPassword().equals(ppwd)){
				///修改密码
				Admin ad=new Admin();
				ad.setPassword(rnpwd);
				if(addaoimpl.updateAdminPWDById(AdminId, ad)){
					System.out.println("修改密码成功！");
					session.setAttribute("AdminName",adminList.get(0).getUserName());
					session.setAttribute("AdminId",adminList.get(0).getAdminId());
					//session.setAttribute("LoginStaus","&nbsp;");
					resp.sendRedirect("jsp/Login.jsp");
				}else{
					req.setAttribute("rs","*网络断开404，稍后重试...！");
					req.getRequestDispatcher("jsp/admin/ChangePassword.jsp").forward(req, resp); 
				}
			}else{
				System.out.println("原密码不正确!");
				req.setAttribute("rs","*原密码不正确！");
				req.getRequestDispatcher("jsp/admin/ChangePassword.jsp").forward(req, resp); 
			}
		}else{
			req.setAttribute("rs","*网络断开500，稍后重试...！");
			req.getRequestDispatcher("jsp/admin/ChangePassword.jsp").forward(req, resp); 
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
