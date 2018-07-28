package com.zsh.dap.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zsh.dao.StuDao;
import com.zsh.pojo.Student;
import com.zsh.util.DBUtil;

public class StuDaoImpl extends DBUtil implements StuDao{
	String  SQL_SELECT= "select studentId,stuNum,password,name,dormName,dormBuildId,sex,tel from t_student ";
	String SQL_INSERT = "insert into t_student(stuNum,password,name,dormName,dormBuildId,sex,tel) values (?, ?, ?, ?, ?, ?, ? )";
	String SQL_UPDATE = "update t_student set "
			+ "stuNum = ?, password = ?, name = ?, dormName = ? ,dormBuildId = ? ,  sex = ?, tel = ?  "
			+ " where studentId = ? ";
	String SQL_DELETE = "delete from t_student where studentId = ?";
	
	/* (non-Javadoc)
	 * @see com.zsh.dao.StuDao#getStudentByDynamicWhere(java.lang.String, java.lang.String[])
	 */
	@Override
	public List<Student> getStudentByDynamicWhere(String sql, String[] sqlParams) {
		//类名调用，静态方法
		DBUtil.getConnection();
		List<Student> stulist=new ArrayList<Student>();
		String SQL=SQL_SELECT+" WHERE 1=1 "+sql;
		System.out.println(SQL);
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		try {
			while (rs.next()){
				Student stu=new Student();
				stu.setStudentId(rs.getInt("studentId"));
				stu.setStuNum(rs.getString("stuNum"));
				stu.setPassword(rs.getString("password"));
				stu.setDormName(rs.getString("dormName"));
				stu.setDormBuildId(rs.getInt("dormBuildId"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setTel(rs.getString("tel"));
				stulist.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return stulist;
	}
	/**
	 * 
	 */
	@Override
	public List<Student> getAllStudent() {
		DBUtil.getConnection();
		List<Student> stulist=new ArrayList<Student>();
		ResultSet rs = this.executeQuery(SQL_SELECT, new String[] {});
		try {
			while (rs.next()){
				Student stu=new Student();
				stu.setStudentId(rs.getInt("studentId"));
				stu.setStuNum(rs.getString("stuNum"));
				stu.setPassword(rs.getString("password"));
				stu.setDormName(rs.getString("dormName"));
				stu.setDormBuildId(rs.getInt("dormBuildId"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setTel(rs.getString("tel"));
				stulist.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return stulist;
	}
	/**
	 * 
	 */
	@Override
	public List<Student> getStuByNumer(String num) {
		DBUtil.getConnection();
		List<Student> stulist=new ArrayList<Student>();
		String sql=" and stuNum= ? ";
		String SQL=SQL_SELECT+" WHERE 1=1 "+sql;
		System.out.println(SQL);
		String[] sqlParams={num};
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		try {
			while (rs.next()){
				Student stu=new Student();
				stu.setStudentId(rs.getInt("studentId"));
				stu.setStuNum(rs.getString("stuNum"));
				stu.setPassword(rs.getString("password"));
				stu.setDormName(rs.getString("dormName"));
				stu.setDormBuildId(rs.getInt("dormBuildId"));
				stu.setName(rs.getString("name"));
				stu.setSex(rs.getString("sex"));
				stu.setTel(rs.getString("tel"));
				stulist.add(stu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return stulist;
	}
	/**
	 * 
	 */
	@Override
	public boolean addStudent(Student stu) {
		DBUtil.getConnection();
		////创建动态参数
		String[] param={stu.getStuNum(),stu.getPassword(),stu.getName(),
				stu.getDormName(),stu.getDormBuildId()+"",stu.getSex(),stu.getTel()};
		///执行更新，返回int
		int x=this.executeUpdate(SQL_INSERT,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}	
	}
	/**
	 * 
	 */
	@Override
	public boolean updateStuById(int id, Student stu) {
		DBUtil.getConnection();
		String[] param={stu.getStuNum(),stu.getPassword(),stu.getName(),
				stu.getDormName(),stu.getDormBuildId()+"",stu.getSex(),stu.getTel(),id+""};
		int x=this.executeUpdate(SQL_UPDATE,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * 
	 */
	@Override
	public boolean delStuById(int id) {
		DBUtil.getConnection();
		String[] param={id+""};
		int x=this.executeUpdate(SQL_DELETE,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public boolean updateStuPWDById(int id, Student stu) {
		String sql = "update t_student set "
				+ "password = ? "
				+ " where studentId = ? ";
		DBUtil.getConnection();
		String[] param={stu.getPassword(),id+""};
		int x=this.executeUpdate(sql,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}
	}

}
