package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.pojo.DormManager;

/**
 * Servlet implementation class EditDMServlet
 */
@WebServlet("/EditDMServlet")
public class EditDMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EditDMServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//PrintWriter out = resp.getWriter();
		//拿值
		int dormManId=Integer.parseInt(req.getParameter("dormManId"));
		System.out.println("dormManId:"+dormManId);
		///
		DMDaoImpl dmdaoimpl=new DMDaoImpl();
		String sql=" and dormManId=? ";
		//创建参数
		String[] params = { dormManId+""};
		List<DormManager> dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql, params);
		if(dmList.size()>0){
			///
			String Data="";
			String UserData="{'data':[";
			
			String str="";
			System.out.println(dmList.size());
			for(int i=0;i<dmList.size();i++){
				str=str+"{'userName':'"+dmList.get(i).getUserName()
						+"','password':'"+dmList.get(i).getPassword()
						+"','name':'"+dmList.get(i).getName()
						+"','sex':'"+dmList.get(i).getSex()
						+"','dormBuildId':'"+dmList.get(i).getDormBuildId()
						+"','tel':'"+dmList.get(i).getTel()+"'},";
			}
			
			if(dmList.size()>0){
				str=str.substring(0,str.length()-1);
			}
			
			Data=UserData+str+"]}";
			Data=Data.replace("\'", "\"");
			System.out.println(Data);
			out.print(Data);
		}
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request,response);
	}

}
