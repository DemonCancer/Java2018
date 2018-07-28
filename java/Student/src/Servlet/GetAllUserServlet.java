package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import DaoImpl.UserDaoImpl;

@WebServlet("/GetAllUserServlet")
public class GetAllUserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//转码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		///获取数据库数据
		UserDaoImpl userdaoImpl=new UserDaoImpl();
		List<User> userlist=userdaoImpl.getAllUser();
		
		
		///
		String Data="";
		String UserData="{'data':[";
		
		String str="";
		System.out.println(userlist.size());
		for(int i=0;i<userlist.size();i++){
			str=str+"{'id':'"+userlist.get(i).getId()
					+"','username':'"+userlist.get(i).getUsername()
					+"','userpass':'"+userlist.get(i).getUserpass()
					+"','role':'"+userlist.get(i).isRole()+"'},";
		}
		
		if(userlist.size()>1){
			str=str.substring(0,str.length()-1);
		}
		
		Data=UserData+str+"]}";
		Data=Data.replace("\'", "\"");
		//System.out.println(Data+"\n"+"zzz");
		out.print(Data);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
