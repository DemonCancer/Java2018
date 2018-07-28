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
import com.zsh.dap.impl.StuDaoImpl;
import com.zsh.pojo.DormBuild;
import com.zsh.pojo.Student;

/**
 * Servlet implementation class SearchStuLookServlet
 */
@WebServlet("/SearchStuLookServlet")
public class SearchStuLookServlet extends HttpServlet {
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
		
		StuDaoImpl studaoimpl=new StuDaoImpl();
		//创建查询语句连接原来的SQL_SELECT
		String sql = "";
		/////创建参数
		List<Student> stuList=new ArrayList<Student>();

		//
		if(choose.equals("学号")&&txtsearch.length()>0){
			sql=" and stuNum like ?";
			String[] params = {"%"+txtsearch+"%"};
			stuList=studaoimpl.getStudentByDynamicWhere(sql, params);
		}
		if(choose.equals("姓名")&&txtsearch.length()>0){
			sql=" and name like ?";
			String[] params = {"%"+txtsearch+"%"};
			stuList=studaoimpl.getStudentByDynamicWhere(sql, params);
		}
		if(choose.equals("宿舍楼号")&&txtsearch.length()>0){
			sql=" and dormBuildId = ?";
			String[] params = {txtsearch+""};
			stuList=studaoimpl.getStudentByDynamicWhere(sql, params);
		}
		if(choose.equals("电话")&&txtsearch.length()>0){
			sql=" and tel like ? ";
			String[] params = {"%"+txtsearch+"%"};
			stuList=studaoimpl.getStudentByDynamicWhere(sql, params);
		}
		if(choose.equals("寝室号")&&txtsearch.length()>0){
			sql=" and dormName like ? ";
			String[] params = {"%"+txtsearch+"%"};
			stuList=studaoimpl.getStudentByDynamicWhere(sql, params);
		}
		if(!(txtsearch.length()>0)){
			stuList=studaoimpl.getAllStudent();
		}
		System.out.println(sql);
		
		
		//创建Student类型的list集合,进行查询
		
		if(stuList.size()>0){
			req.setAttribute("StuList",stuList);  
		}else{
			req.setAttribute("StuList",null);  
		}
		DBDaoImpl dbdaoimpl=new DBDaoImpl();
		List<DormBuild> dbList=dbdaoimpl.getAllDormBuild();
		if(dbList.size()>0){
			System.out.println("DBList成功！！");
			req.setAttribute("DBList",dbList);
			req.setAttribute("choose",choose);
		}else{
			req.setAttribute("DBList",dbList);
			req.setAttribute("choose",choose);
		}
		req.getRequestDispatcher("jsp/dormmanager/StuLook.jsp").include(req, resp); 
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
