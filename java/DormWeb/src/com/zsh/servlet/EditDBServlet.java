package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class EditDBServlet
 */
@WebServlet("/EditDBServlet")
public class EditDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//PrintWriter out = resp.getWriter();
		//拿值
		int dormBuildId=Integer.parseInt(req.getParameter("dormBuildId"));
		System.out.println("dormBuildId:"+dormBuildId);
		///
		DBDaoImpl dbdaoimpl=new DBDaoImpl();
		String sql=" and dormBuildId=? ";
		//创建参数
		String[] params = { dormBuildId+""};
		List<DormBuild> dbList=dbdaoimpl.getDormBuildByDynamicWhere(sql, params);
		if(dbList.size()>0){
			///
			String Data="";
			String UserData="{'data':[";
			
			String str="";
			System.out.println(dbList.size());
			for(int i=0;i<dbList.size();i++){
				str=str+"{'dormBuildName':'"+dbList.get(i).getDormBuildName()
						+"','dormBuildId':'"+dbList.get(i).getDormBuildId()
						+"','dormBuildDetail':'"+dbList.get(i).getDormBuildDetail()+"'},";
			}
			
			if(dbList.size()>0){
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
