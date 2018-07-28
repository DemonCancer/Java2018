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
import com.zsh.pojo.Admin;
import com.zsh.pojo.DormManager;

/**
 * Servlet implementation class DMCPServlet
 */
@WebServlet("/DMCPServlet")
public class DMCPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		///获取
		int DMId=Integer.parseInt(req.getParameter("DMId"));
		String ppwd=req.getParameter("ppwd");
		String npwd=req.getParameter("npwd");
		String rnpwd=req.getParameter("rnpwd");
		System.out.println(ppwd+npwd+rnpwd+DMId);
		//根据ID获取password

		String sql1=" and dormManId =? ";
		String[] params1={DMId+""};
		
		
		DMDaoImpl dmdaoimpl=new DMDaoImpl();
		List<DormManager> dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql1, params1);
		//boolean role=false;
		//判断有没有值传回来
		HttpSession session = req.getSession();
		if(dmList.size()>0){
			if(dmList.get(0).getPassword().equals(ppwd)){
				///修改密码
				DormManager dm=new DormManager();
				dm.setPassword(rnpwd);
				if(dmdaoimpl.updateDMPWDById(DMId, dm)){
					System.out.println("修改密码成功！");
					session.setAttribute("DormMan",dmList.get(0).getUserName());
					session.setAttribute("DMId",dmList.get(0).getDormManId());
					//session.setAttribute("LoginStaus","&nbsp;");
					resp.sendRedirect("jsp/Login.jsp");
				}else{
					req.setAttribute("rs","*网络断开404，稍后重试...！");
					req.getRequestDispatcher("jsp/dormmanager/ChangePassword.jsp").forward(req, resp); 
				}
			}else{
				System.out.println("原密码不正确!");
				req.setAttribute("rs","*原密码不正确！");
				req.getRequestDispatcher("jsp/dormmanager/ChangePassword.jsp").forward(req, resp); 
			}
		}else{
			req.setAttribute("rs","*网络断开500，稍后重试...！");
			req.getRequestDispatcher("jsp/dormmanager/ChangePassword.jsp").forward(req, resp); 
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
