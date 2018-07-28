package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.dap.impl.RecordDaoImpl;
import com.zsh.pojo.DormManager;
import com.zsh.pojo.Record;

/**
 * Servlet implementation class UpdateRCServlet
 */
@WebServlet("/UpdateRCServlet")
public class UpdateRCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		int recordId=Integer.parseInt(req.getParameter("recordId"));
		String studentNumber=req.getParameter("studentNumber");
		String studentName=req.getParameter("studentName");
		String detail=req.getParameter("detail");
		//System.out.println("userName:"+userName+dormManId+dormBuildId);
		
		///
		Record rc=new Record();
		rc.setStudentNumber(studentNumber);
		rc.setStudentName(studentName);
		rc.setDetail(detail);
		RecordDaoImpl rcdaoimpl=new RecordDaoImpl();
		if(rcdaoimpl.updateRecordById(recordId, rc)){
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
