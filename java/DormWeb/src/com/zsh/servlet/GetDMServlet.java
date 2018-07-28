package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.pojo.DormManager;

/**
 * Servlet implementation class GetDMServlet
 */
@WebServlet("/GetDMServlet")
public class GetDMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		///
		int dormBuildId=Integer.parseInt(req.getParameter("dormBuildId"));
		System.out.println(dormBuildId);
		String sql="";
		
		DMDaoImpl dmdaoimpl=new DMDaoImpl();
		sql = " and dormBuildId=? ";
		//创建参数
		String[] params = { dormBuildId+"" };
		List<DormManager> dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql, params);
		if(dmList.size()>0){
			String json = JSON.toJSONString(dmList);
			System.out.println(json);
			out.print(json);
		}else{
			out.print("未获取到");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
