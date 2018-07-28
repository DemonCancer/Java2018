package Servlet;

import java.io.IOException;
//import java.io.PrintWriter;

/*import java.text.SimpleDateFormat;
import java.util.Date;*/
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DaoImpl.UserDaoImpl;
import entity.User;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String username=req.getParameter("username");
		String userpass=req.getParameter("pwd");
		
		//SimpleDateFormat dateFormat = new SimpleDateFormat(
		//		"yyyy-MM-dd hh:mm:ss");
		//String regtime = dateFormat.format(new Date());
		
		User user=new User();
		user.setUsername(username);
		user.setUserpass(userpass);
		//user.setRegtime(regtime);
		
		UserDaoImpl userDao=new UserDaoImpl();
		//PrintWriter out=resp.getWriter();
		HttpSession session = req.getSession();
		
		if(userDao.addUser(user)){
			System.out.println("注册成功!请记住您的用户名和密码");
			session.setAttribute("register", "ok");
			resp.sendRedirect("Login.jsp");	
		}
		else{
			System.out.println("注册失败!");
			session.setAttribute("register", "no");
			resp.sendRedirect("Register.jsp");		
		}
			
		}

}
