package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DormDaoImpl;
import com.zsh.dap.impl.DormDaoImpl;
import com.zsh.dap.impl.StuDaoImpl;
import com.zsh.pojo.DormManager;
import com.zsh.pojo.Student;

/**
 * Servlet implementation class EditStuServlet
 */
@WebServlet("/EditStuServlet")
public class EditStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditStuServlet() {
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
		int studentId=Integer.parseInt(req.getParameter("studentId"));
		System.out.println("studentId:"+studentId);
		///
		
		StuDaoImpl studaoimpl=new StuDaoImpl();
		String sql=" and studentId=? ";
		//创建参数
		String[] params = { studentId+""};
		List<Student> stuList=studaoimpl.getStudentByDynamicWhere(sql, params);
		if(stuList.size()>0){
			///
			String Data="";
			String UserData="{'data':[";
			
			String str="";
			System.out.println(stuList.size());
			for(int i=0;i<stuList.size();i++){
				str=str+"{'stuNum':'"+stuList.get(i).getStuNum()
						+"','password':'"+stuList.get(i).getPassword()
						+"','name':'"+stuList.get(i).getName()
						+"','sex':'"+stuList.get(i).getSex()
						+"','dormBuildId':'"+stuList.get(i).getDormBuildId()
						+"','dormName':'"+stuList.get(i).getDormName()
						+"','tel':'"+stuList.get(i).getTel()+"'},";
			}
			
			if(stuList.size()>0){
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
