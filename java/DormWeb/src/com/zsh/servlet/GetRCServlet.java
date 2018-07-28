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
import com.zsh.dap.impl.RecordDaoImpl;
import com.zsh.pojo.DormManager;
import com.zsh.pojo.Record;

/**
 * Servlet implementation class GetRcServlet
 */
@WebServlet("/GetRCServlet")
public class GetRCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRCServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		///
		int recordId=Integer.parseInt(req.getParameter("recordId"));
		System.out.println("recordId:"+recordId);
		String sql="";
		
		RecordDaoImpl rcdaoimpl=new RecordDaoImpl();
		sql = " and recordId=? ";
		//创建参数
		String[] params = { recordId+"" };
		List<Record> rcList=rcdaoimpl.getRecordByDynamicWhere(sql, params);
		if(rcList.size()>0){
			String json = JSON.toJSONString(rcList);
			System.out.println(json);
			out.print(json);
		}else{
			out.print("未获取到");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
