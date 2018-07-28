package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Profession;
import DaoImpl.ProfessionDaoImpl;

@WebServlet("/GetProServlet")
public class GetProServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//转码
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿数据
		//String str1=req.getParameter("str1");
		ProfessionDaoImpl prodaoimpl=new ProfessionDaoImpl();
		List<Profession> proList=prodaoimpl.getAllProfession();
		String profession="";
		String id="";
		for(Profession pro:proList){
			id=id+","+pro.getId();
			profession=profession+","+pro.getProfession();
			
			//System.out.println(pro.getProfession());
		}
		//System.out.println(str1);
		out.print(profession);
		/*String s="{'name': 'aaa'}";
		String s1=s.replaceAll("\'", "\"");*/
		//out.print(s1);
		  
	}

}
