package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DaoImpl.ProfessionDaoImpl;
import entity.Profession;

@WebServlet("/GetProAllServlet")
public class GetProAllServlet extends HttpServlet{

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
		String test=req.getParameter("test");
		
		////
		ProfessionDaoImpl prodaoimpl=new ProfessionDaoImpl();
		List<Profession> proList=prodaoimpl.getAllProfession();
		//方式一
	    //String jsonString = JSON.toJSONString(proList);
	    //JSONArray jsonArray = JSONArray.parseArray(jsonString);
	    //System.out.println(jsonString);
		
		
		String profession="";
		String id="";
		
		String Data="";
		String ProData="{'data':[";
		
		String str="";
		System.out.println(proList.size());
		for(int i=0;i<proList.size();i++){
			str=str+"{'id':'"+proList.get(i).getId()
					+"','profession':'"+proList.get(i).getProfession()+"'},";
		}
		
		if(proList.size()>1){
			str=str.substring(0,str.length()-1);
		}
		
		Data=ProData+str+"]}";
		Data=Data.replace("\'", "\"");
		//System.out.println(Data+"\n"+"zzz");
		out.print(Data);
				
		
		
		
		
		//System.out.println(str1);
		
		/*out.print(id);
		out.print(profession);*/
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req,resp);
	}

}
