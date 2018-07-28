package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.StudentDaoImpl;
import entity.Student;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet{

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
				String userno=req.getParameter("userno");
				String username=req.getParameter("username");
				boolean sex=Boolean.parseBoolean(req.getParameter("sex"));
				/*boolean sex ;
				if(req.getParameter("sex").equals("false")){
					sex=false;
				}
				else{
					sex=true;
				}*/
				int age=Integer.parseInt(req.getParameter("age"));
				
				//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				 
				Date birthday=Date.valueOf(req.getParameter("birthday"));
				
				
				//String birthday=req.getParameter("birthday");
				String profession=req.getParameter("profession");
				
				
				System.out.println(userno+username+sex+age+birthday+profession);
				
				////
				Student stu=new Student();
				stu.setUserno(userno);
				stu.setUsername(username);
				stu.setUserpass("123456");
				stu.setSex(sex);
				stu.setAge(age);
				stu.setBirthday(birthday);
				stu.setProfession(profession);
				//创建实现类对象
				StudentDaoImpl studaoimpl=new StudentDaoImpl();
				
				if(studaoimpl.addStudent(stu)){
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
