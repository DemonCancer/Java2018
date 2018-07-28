package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.RecordDaoImpl;
import com.zsh.dap.impl.StuDaoImpl;
import com.zsh.pojo.Record;
import com.zsh.pojo.Student;

/**
 * Servlet implementation class InsertRCServlet
 */
@WebServlet("/InsertRCServlet")
public class InsertRCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值\
		String JsAdd=req.getParameter("JsAdd");
		if(JsAdd.equals("STU")){
			System.out.println("STU");
			String stuName=req.getParameter("stuName");
			String date =req.getParameter("date");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			ParsePosition pos = new ParsePosition(0);
			Date Date= formatter.parse(date, pos);
			String detail =req.getParameter("detail");
			String stuNum=req.getParameter("stuNum");

			int dormBuildId=Integer.parseInt(req.getParameter("dormBuildId"));
			
			Record rc=new Record();
			rc.setStudentNumber(stuNum);
			rc.setStudentName(stuName);
			
			rc.setDate(Date);
			rc.setDetail(detail);
			rc.setDormBuildId(dormBuildId);
			RecordDaoImpl rcdaoimpl=new RecordDaoImpl();
			if(rcdaoimpl.addRecord(rc)){
				System.out.println("添加成功");
				out.print("添加成功");
			}else{
				System.out.println("添加失败");
				out.print("添加失败");
			}
		}
		if(JsAdd.equals("DMRC")){
			System.out.println("DMRC");
			String date =req.getParameter("date");
			String detail =req.getParameter("detail");
			String stuNum=req.getParameter("stuNum");
			//int dormBuildId=Integer.parseInt(req.getParameter("dormBuildId"));
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			ParsePosition pos = new ParsePosition(0);
			Date Date= formatter.parse(date, pos);
			
			
			///判断有没有学号
			StuDaoImpl studaoimpl=new StuDaoImpl();
			List<Student> stuList=studaoimpl.getStuByNumer(stuNum);
			if(stuList.size()>0){
				System.out.println("");
				RecordDaoImpl rcdaoimpl=new RecordDaoImpl();
				Record rc=new Record();
				rc.setStudentNumber(stuNum);
				rc.setStudentName(stuList.get(0).getName());
				rc.setDormBuildId(stuList.get(0).getDormBuildId());
				rc.setDetail(detail);
				rc.setDate(Date);
				if(rcdaoimpl.addRecord(rc)){
					System.out.println("添加成功");
					out.print("添加成功");
				}else{
					System.out.println("添加失败");
					out.print("添加失败");
				}
			}else{
				out.print("学号不存在");
			}
			
			
			
		}
		
		
		
		
		
		
		//System.out.println(Date);
		
		
		
		
		//System.out.println("dormManId:"+dormManId);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
