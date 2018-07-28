package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
/*import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;*/
import java.sql.Date;
/*import java.text.ParseException;
import java.text.SimpleDateFormat;*/

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.StudentDaoImpl;
import entity.Student;


@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet{

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
		String userno=req.getParameter("userno");
		String username=req.getParameter("username");
		String userpass=req.getParameter("userpass");
		//String sex=req.getParameter("sex");
		boolean sex ;
		if(req.getParameter("sex").equals("男")){
			sex=false;
		}
		else{
			sex=true;
		}
		int age=Integer.parseInt(req.getParameter("age"));
		
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		 
		Date birthday=Date.valueOf(req.getParameter("birthday"));
		
		
		//String birthday=req.getParameter("birthday");
		String profession=req.getParameter("profession");
		
		int id=Integer.parseInt(req.getParameter("id"));
		
		System.out.println(id+userno+username+userpass+sex+age+birthday+profession);
	
		//开始更新
		//吧要修改的数据，放进Student对象
		Student stu=new Student();
		stu.setUserno(userno);
		stu.setUsername(username);
		stu.setUserpass(userpass);
		stu.setSex(sex);
		stu.setAge(age);
		stu.setBirthday(birthday);
		stu.setProfession(profession);
		//创建实现类对象
		StudentDaoImpl studaoimpl=new StudentDaoImpl();
		
		if(studaoimpl.updateStudentById(id, stu)){
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
