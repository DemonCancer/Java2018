package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DBDaoImpl;
import com.zsh.dap.impl.RecordDaoImpl;

/**
 * Servlet implementation class DelRCServlet
 */
@WebServlet("/DelRCServlet")
public class DelRCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelRCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		int recordId=Integer.parseInt(req.getParameter("recordId"));
		
		RecordDaoImpl rcdaoimpl=new RecordDaoImpl();
		if(rcdaoimpl.delRecordById(recordId)){
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

