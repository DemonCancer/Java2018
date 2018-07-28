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

@WebServlet("/UpdateProServlet")
public class UpdateProServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//转码
				req.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				PrintWriter out = resp.getWriter();
				//拿数据
				int id=Integer.parseInt(req.getParameter("id"));
				String profession=req.getParameter("profession");
				
				Profession pro=new Profession();
				pro.setProfession(profession);
				System.out.println(id+profession);
				
				ProfessionDaoImpl prodaoimpl=new ProfessionDaoImpl();
				if(prodaoimpl.updateProById(id, pro)){
					System.out.println("修改成功");
					out.print("修改成功");
				}else{
					System.out.println("修改失败");
					out.print("修改失败");
				}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
