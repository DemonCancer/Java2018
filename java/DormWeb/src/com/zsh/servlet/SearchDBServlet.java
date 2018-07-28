package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DBDaoImpl;
import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.pojo.DormBuild;
import com.zsh.pojo.DormManager;

/**
 * Servlet implementation class SearchDBServlet
 */
@WebServlet("/SearchDBServlet")
public class SearchDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		String choose=req.getParameter("searchchoose");
		String txtsearch=req.getParameter("txtsearch");
		System.out.println(choose+","+txtsearch);
		
		DBDaoImpl dbdaoimpl=new DBDaoImpl();
		//创建查询语句连接原来的SQL_SELECT
		String sql = "";
		/////创建参数
		List<DormBuild> dbList=new ArrayList<DormBuild>();

		//
		if(choose.equals("宿舍楼名称")&&txtsearch.length()>0){
			sql=" and dormBuildName like ?";
			String[] params = {"%"+txtsearch+"%"};
			dbList=dbdaoimpl.getDormBuildByDynamicWhere(sql, params);
		}
		if(choose.equals("宿舍楼号")&&txtsearch.length()>0){
			sql=" and dormBuildId = ?";
			String[] params = {txtsearch+""};
			dbList=dbdaoimpl.getDormBuildByDynamicWhere(sql, params);
		}
		if(!(txtsearch.length()>0)){
			dbList=dbdaoimpl.getAllDormBuild();
		}
		System.out.println(sql);
		
		
		//创建Student类型的list集合,进行查询
		
		if(dbList.size()>0){
			req.setAttribute("DBList",dbList);
			req.setAttribute("choose",choose);
		}else{
			req.setAttribute("DBList",null);  
		}

		req.getRequestDispatcher("jsp/admin/DBManager.jsp").include(req, resp); 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
