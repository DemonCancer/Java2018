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
 * Servlet implementation class SearchDMServlet
 */
@WebServlet("/SearchDMServlet")
public class SearchDMServlet extends HttpServlet {
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
		
		DMDaoImpl dmdaoimpl=new DMDaoImpl();
		//创建查询语句连接原来的SQL_SELECT
		String sql = "";
		/////创建参数
		List<DormManager> dmList=new ArrayList<DormManager>();

		//
		if(choose.equals("管理员昵称")&&txtsearch.length()>0){
			sql=" and userName like ?";
			String[] params = {"%"+txtsearch+"%"};
			dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql, params);
		}
		if(choose.equals("姓名")&&txtsearch.length()>0){
			sql=" and name like ?";
			String[] params = {"%"+txtsearch+"%"};
			dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql, params);
		}
		if(choose.equals("宿舍楼号")&&txtsearch.length()>0){
			sql=" and dormBuildId = ?";
			String[] params = {txtsearch};
			dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql, params);
		}
		if(choose.equals("电话")&&txtsearch.length()>0){
			sql=" and tel like ? ";
			String[] params ={"%"+txtsearch+"%"};
			dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql, params);
		}
		if(!(txtsearch.length()>0)){
			dmList=dmdaoimpl.getAllDormManager();
		}
		System.out.println(sql);
		
		
		//创建Student类型的list集合,进行查询
		
		if(dmList.size()>0){
			req.setAttribute("DMList",dmList);  
		}else{
			req.setAttribute("DMList",null);  
		}
		DBDaoImpl dbdaoimpl=new DBDaoImpl();
		List<DormBuild> dbList=dbdaoimpl.getAllDormBuild();
		if(dbList.size()>0){
			System.out.println("DBList成功！！");
			req.setAttribute("DBList",dbList);
			req.setAttribute("choose",choose);
		}else{
			resp.sendRedirect("jsp/admin/Index.jsp");
		}
		req.getRequestDispatcher("jsp/admin/DMManager.jsp").include(req, resp); 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
