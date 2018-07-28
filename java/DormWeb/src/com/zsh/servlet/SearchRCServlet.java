package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsh.dap.impl.RecordDaoImpl;
import com.zsh.pojo.Record;

/**
 * Servlet implementation class SearchRCServlet
 */
@WebServlet("/SearchRCServlet")
public class SearchRCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//
		String JspId=req.getParameter("JspId");
		if(JspId.equals("StuRC")){
			String txtDate=req.getParameter("txtdate");
			String txtDate1=req.getParameter("txtdate1");
			RecordDaoImpl rcdaoimpl=new RecordDaoImpl();
			HttpSession session=req.getSession();
			String stuNum=(String) session.getAttribute("StuNum");
			/////创建参数
			List<Record> rcList=new ArrayList<Record>();
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
	    	String date = txtDate;
	    	if(txtDate.length()>0){
	    		///如果有日期没有查询
				String sql = "";
				//根据dormBuildId和date
				
				sql=" and date >= ? and date <= ? and r.studentNumber= ? ";
				String[] params = {date,txtDate1,stuNum};
				rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, params);
	    	}else{
	    		///如果都没有
	    		String sql=" and r.studentNumber= ? ";
				String[] param={stuNum};
				rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, param);
	    	}
	    	if(rcList.size()>0){
				System.out.println("rcList成功！！");
				req.setAttribute("RCList",rcList);
			}else{
				System.out.println("rcList失败！！");
				req.setAttribute("RCList",rcList);

			}
	    	req.getRequestDispatcher("jsp/student/StuRCLook.jsp").forward(req, resp); 
	    	
		}else{
		
			//拿值
			String choose=req.getParameter("searchchoose");
			String txtsearch=req.getParameter("txtsearch");
			String txtDate=req.getParameter("txtdate");
			String txtDate1=req.getParameter("txtdate1");
			
			RecordDaoImpl rcdaoimpl=new RecordDaoImpl();
			
			/////创建参数
			List<Record> rcList=new ArrayList<Record>();
			SimpleDateFormat format= new SimpleDateFormat("yyyy-MM-dd");
	    	String date = txtDate;
			//如果输入框有字
			if(txtsearch.length()>0&&(txtDate.length()>0||!(txtDate.equals("")))){
				//如果两个都有
				//创建查询语句连接原来的SQL_SELECT
				String sql = "";
				//根据dormBuildId和date
				
				if(choose.equals("宿舍楼号")){
					sql=" and r.dormBuildId=? and date >= ? and date <= ?";
					int id=Integer.parseInt(txtsearch);
					String[] params = {id+"",date,txtDate1};
					rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, params);
				}
				if(choose.equals("学号")){
					sql=" and r.studentNumber like ? and date >= ? and date <= ?";
					String[] params = {"%"+txtsearch+"%",date,txtDate1};
					rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, params);
				}
				if(choose.equals("姓名")){
					sql=" and r.studentName like ? and date >= ? and date <= ?";
					String[] params = {"%"+txtsearch+"%",date,txtDate1};
					rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, params);
				}
				
				
				
			}else if(txtsearch.length()>0&&txtDate.equals("")){
				//如果有查询密友日期
				String sql = "";
				//根据dormBuildId和date
				if(choose.equals("宿舍楼号")){
					sql=" and r.dormBuildId=? ";
					int id=Integer.parseInt(txtsearch);
					String[] params = {id+""};
					rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, params);
				}
				if(choose.equals("学号")){
					sql=" and r.studentNumber like ? ";
					String[] params = {"%"+txtsearch+"%"};
					rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, params);
				}
				if(choose.equals("姓名")){
					sql=" and r.studentName like ?";
					String[] params = {"%"+txtsearch+"%"};
					rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, params);
				}
				
				
			}else if(txtsearch.equals("")&&txtDate.length()>0){
				///如果有日期没有查询
				String sql = "";
				//根据dormBuildId和date
				
				sql=" and date >= ? and date <= ? ";
				String[] params = {date,txtDate1};
				rcList=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, params);
	
				
			}else if(txtsearch.equals("")&&txtDate.equals("")){
				///如果都没有
				rcList=rcdaoimpl.getAllRecordAndDormName();
			}
			System.out.println(choose+","+txtsearch+","+txtDate);
			
			if(rcList.size()>0){
				System.out.println("rcList成功！！");
				req.setAttribute("RCList",rcList);
				req.setAttribute("choose",choose);
			}else{
				System.out.println("rcList失败！！");
				req.setAttribute("RCList",rcList);
	
			}
			if(JspId.equals("DMRC")){
				
				req.getRequestDispatcher("jsp/dormmanager/DMRCManager.jsp").forward(req, resp); 
			}
			if(JspId.equals("RC")){
				
				req.getRequestDispatcher("jsp/admin/RCManager.jsp").forward(req, resp); 
			}
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
