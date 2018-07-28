package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.pojo.DormManager;

/**
 * Servlet implementation class DBDelDMServlet
 */
@WebServlet("/DBDelDMServlet")
public class DBDelDMServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		int dormManId=Integer.parseInt(req.getParameter("dormManId"));
		System.out.println("dormManId:"+dormManId);
		
		List<DormManager> dmList=new ArrayList<DormManager>();
		///
		
		DMDaoImpl dmdaoimpl=new DMDaoImpl();
		///
		String  sql=" and dormManId = ? ";
		String[] sqlParams={dormManId+""};
		dmList=dmdaoimpl.getDormManagerByDynamicWhere(sql, sqlParams);
		if(dmList.size()==1){

			DormManager dm=new DormManager();
			dm.setDormBuildId(0);
			dm.setName(dmList.get(0).getName());
			dm.setPassword(dmList.get(0).getPassword());
			dm.setSex(dmList.get(0).getSex());
			dm.setTel(dmList.get(0).getTel());
			dm.setUserName(dmList.get(0).getUserName());
			//
			if(dmdaoimpl.updateDMById(dormManId, dm)){
				System.out.println("修改成功");
				out.print("修改成功");
			}else{
				System.out.println("修改失败");
				out.print("修改失败");
			}
			
		}else{
			out.print("修改失败");
		}
		
		
		
		
		
		
		//System.out.println("dormManId:"+dormManId);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
