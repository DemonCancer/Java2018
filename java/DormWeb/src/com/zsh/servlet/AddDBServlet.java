package com.zsh.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsh.dap.impl.DBDaoImpl;
import com.zsh.dap.impl.DMDaoImpl;
import com.zsh.pojo.DormBuild;
import com.zsh.pojo.DormManager;

/**
 * Servlet implementation class AddDBServlet
 */
@WebServlet("/AddDBServlet")
public class AddDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		//拿值
		int dormManId=Integer.parseInt(req.getParameter("dormManId"));
		String dormBuildName=req.getParameter("dormBuildName");
		String dormBuildDetail=req.getParameter("dormBuildDetail");
		System.out.println("dormManId:"+dormManId);
		
		
		///
		DormBuild db=new DormBuild();
		db.setDormBuildName(dormBuildName);
		db.setDormBuildDetail(dormBuildDetail);
		
		DBDaoImpl dbdaoimpl=new DBDaoImpl();
		if(dbdaoimpl.addDormBuild(db)){
			System.out.println("添加成功");
			///修改管理员
			if(dormManId+""!=null){
				//根据姓名查询DB数据获取Id
				String sql=" and dormBuildName = ?";
				String[] sqlParams={dormBuildName};
				System.out.println("getDormBuildId"+dormBuildName);
				DBDaoImpl dbdaoimpl1=new DBDaoImpl();
				List<DormBuild> dbList=dbdaoimpl1.getDormBuildByDynamicWhere(sql, sqlParams);
				System.out.println("getDormBuildId"+dbList.size());
				///根据dormManId修改getDormBuildId
				DormManager dm=new DormManager();
				System.out.println("getDormBuildId:"+dbList.get(0).getDormBuildId());
				dm.setDormBuildId(dbList.get(0).getDormBuildId());
				DMDaoImpl dmdaoimpl=new DMDaoImpl();
				if(dmdaoimpl.updateDBIDById(dormManId, dm)){
					System.out.println("修改DMID成功");
				}else{
					System.out.println("修改DMID成功");
				}
				
			}
			
			out.print("添加成功");
		}else{
			System.out.println("添加失败");
			out.print("添加失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
