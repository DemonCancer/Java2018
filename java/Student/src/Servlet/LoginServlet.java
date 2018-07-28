package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;
import DaoImpl.UserDaoImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		String username = req.getParameter("username");
		String userpass = req.getParameter("pwd");
		
		System.out.println("username:"+username+"pwd:"+userpass);
		//创建stuimpl对象
		//StudentDaoImpl studaoimpl=new StudentDaoImpl();
		UserDaoImpl userdaoimpl=new UserDaoImpl();
		//创建查询语句连接原来的SQL_SELECT
		String sql = " and username=? and userpass=?";
		//创建参数
		String[] params = { username, userpass };
		//创建Student类型的list集合,进行查询
		List<User> userList=userdaoimpl.getUserByDynamicWhere(sql, params);
		boolean role=false;
		//判断有没有值传回来
		if(userList.size()>0){
			
			for(User user:userList){
				role=user.isRole();
			}
			System.out.println("登陆成功！！");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String logtime = dateFormat.format(new Date());
			HttpSession session = req.getSession();
			session.setAttribute("adminRole", role);
			session.setAttribute("adminUser", username);
			session.setAttribute("logTime", logtime);
			System.out.println("权限："+role);
			System.out.println("登录时间："+logtime);
			
			resp.sendRedirect("Index.jsp");
		}else{
			System.out.println("登录失败！！");
			resp.sendRedirect("Login.jsp");
		}
		//----------------------测试-------------------------------
		/*try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn =
					DriverManager.getConnection
					("jdbc:mysql://localhost:3306/test1105?useUnicode=true&characterEncoding=utf8",
					"root", "rootroot");
			Statement stmt=conn.createStatement();
			String sql="select * from userdetail where username='"+username+"' and "
					+ "userpass='"+userpass+"'";
			System.out.println(sql);
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next()){
				System.out.println("登陆成功！！");
				resp.sendRedirect("index.html");
			}else{
				System.out.println("登录失败！！");
				resp.sendRedirect("Login.html");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
			
		
				
				
				
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
