package com.zsh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zsh.dap.impl.DBDaoImpl;
import com.zsh.dap.impl.RecordDaoImpl;
import com.zsh.dap.impl.StuDaoImpl;
import com.zsh.pojo.DormBuild;
import com.zsh.pojo.Record;
import com.zsh.pojo.Student;

/**
 * Servlet implementation class RCListServlet
 */
@WebServlet("/RCListServlet")
public class RCListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RCListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//PrintWriter out = resp.getWriter();
		HttpSession session=request.getSession();
		//拿值
		String JspId=request.getParameter("JspId");
		System.out.println(JspId);
		RecordDaoImpl rcdaoimpl=new RecordDaoImpl();
		//创建Admin类型的list集合,进行查询
		if(JspId.equals("StuRCLook")){
			String sql=" and r.studentNumber= ? ";
			if(session.getAttribute("StuNum")!=null){
				String stuNum=(String) session.getAttribute("StuNum");
				String[] param={stuNum};
				List<Record> rcList1=rcdaoimpl.getRecordAndDormNameByDynamicWhere(sql, param);
				if(rcList1.size()>0){
					request.setAttribute("RCList",rcList1);
					request.getRequestDispatcher("jsp/student/StuRCLook.jsp").forward(request, response);
				}
				
				
			}
			
		}
		
		
		
		List<Record> rcList=rcdaoimpl.getAllRecordAndDormName();
		
		
		DBDaoImpl dbdaoimpl=new DBDaoImpl();
		
		List<DormBuild> dbList=dbdaoimpl.getAllDormBuild();
		//boolean role=false;
		//判断有没有值传回来
		
		if(dbList.size()>0){
			System.out.println("DBList成功！！");
			request.setAttribute("DBList",dbList);  
		}else{
			response.sendRedirect("jsp/admin/Index.jsp");
		}
		//判断有没有值传回来
		if(rcList.size()>0){
			System.out.println("rcList成功！！");
			request.setAttribute("RCList",rcList);
			if(JspId.equals("DMRCManager")){
				request.getRequestDispatcher("jsp/dormmanager/DMRCManager.jsp").forward(request, response); 
			}
			if(JspId.equals("RCManager")){
				request.getRequestDispatcher("jsp/admin/RCManager.jsp").forward(request, response); 
			}
			
		}else{
			System.out.println("rcList失败！！");
			if(JspId.equals("DMRCManager")){
				request.getRequestDispatcher("jsp/dormmanager/DMRCManager.jsp").forward(request, response); 
			}
			if(JspId.equals("RCManager")){
				request.getRequestDispatcher("jsp/admin/RCManager.jsp").forward(request, response); 
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
