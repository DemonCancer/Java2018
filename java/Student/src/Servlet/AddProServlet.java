package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.ProfessionDaoImpl;
import entity.Profession;

@WebServlet("/AddProServlet")
public class AddProServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		///
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿数据
		String profession=req.getParameter("profession");
		System.out.println(profession);
		///
		Profession pro=new Profession();
		pro.setProfession(profession);
		
		ProfessionDaoImpl prodaoimpl=new ProfessionDaoImpl();
		
		if(prodaoimpl.addProfession(pro)){
			System.out.println("添加成功");
			out.print("添加成功");
		}else{
			System.out.println("添加失败");
			out.print("添加失败");
		}
		
		
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}
	

}
