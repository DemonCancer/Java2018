package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.UserDaoImpl;
import entity.User;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet{

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
		//拿数据
		int id=Integer.parseInt(req.getParameter("id"));
		String username=req.getParameter("username");
		String userpass=req.getParameter("userpass");
		boolean role;
		if(req.getParameter("role").equals("有")){
			role=true;
		}else{
			role=false;
		}
		///
		System.out.println("要修改的数据："+id+username+userpass+role);
		User user=new User();
		user.setUsername(username);
		user.setUserpass(userpass);
		user.setRole(role);
		///
		UserDaoImpl userdaoimpl=new UserDaoImpl();
		if(userdaoimpl.updateUserById(id, user)){
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
		
		doGet(req,resp);
	}

}
