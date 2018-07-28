package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DBDaoImpl;

/**
 * Servlet implementation class DelDBServlet
 */
@WebServlet("/DelDBServlet")
public class DelDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		int dormBuildId=Integer.parseInt(req.getParameter("dormBuildId"));
		
		DBDaoImpl dbdaoimpl=new DBDaoImpl();
		if(dbdaoimpl.delDBById(dormBuildId)){
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

