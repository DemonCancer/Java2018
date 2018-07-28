package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.pojo.DormManager;

/**
 * Servlet implementation class UpdateDMServlet
 */
@WebServlet("/UpdateDMServlet")
public class UpdateDMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		int dormManId=Integer.parseInt(req.getParameter("dormManId"));
		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		String name=req.getParameter("name");
		String sex=req.getParameter("sex");
		String tel=req.getParameter("tel");
		int dormBuildId=Integer.parseInt(req.getParameter("dormBuildId"));
		System.out.println("userName:"+userName+dormManId+dormBuildId);
		
		///
		DormManager dm=new DormManager();
		dm.setUserName(userName);
		dm.setPassword(password);
		dm.setDormBuildId(dormBuildId);
		dm.setSex(sex);
		dm.setName(name);
		dm.setTel(tel);
		DMDaoImpl dmdaoimpl=new DMDaoImpl();
		if(dmdaoimpl.updateDMById(dormManId, dm)){
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
