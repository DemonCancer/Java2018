package com.zsh.dap.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsh.dao.AdminDao;
import com.zsh.pojo.Admin;
import com.zsh.util.DBUtil;

public class AdminDaoImpl extends DBUtil implements AdminDao{

	String  SQL_SELECT= "select adminId,userName,password,name,sex,tel from t_admin ";
	String SQL_INSERT = "insert into t_admin(userName,password,name,sex,tel) values ( ?, ?, ?, ?, ? )";
	String SQL_UPDATE = "update t_admin set "
			+ "userName = ?, password = ?, name = ?, sex=?, tel=?  "
			+ " where adminId = ? ";
	String SQL_DELETE = "delete from t_admin where adminId = ?";
	
	/**
	 * 动态查询
	 */
	@Override
	public List<Admin> getAdminByDynamicWhere(String sql, String[] sqlParams) {
		//获取数据库连接
		DBUtil.getConnection();
		//创建集合储存自定义对象Admin
		List<Admin> adminlist=new ArrayList<Admin>();
		//创建SQL语句（重写）
		String SQL=SQL_SELECT+" WHERE 1=1 "+sql;
		//测试输出语句
		System.out.println(SQL);
		//查询结果放到ResultSet
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		///遍历，封装到List
		try {
			while (rs.next()){
				///创建对象
				Admin admin=new Admin();
				////属性赋值
				admin.setAdminId(rs.getInt("adminId"));
				admin.setUserName(rs.getString("userName"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setSex(rs.getString("sex"));
				admin.setTel(rs.getString("tel"));
				///添加到list
				adminlist.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			this.closeAll();
		}
		//返回list
		return adminlist;
	}
	/**
	 * 获取所有超级用户
	 */
	@Override
	public List<Admin> getAllAdmin() {
		DBUtil.getConnection();
		List<Admin> adminlist=new ArrayList<Admin>();
		ResultSet rs = this.executeQuery(SQL_SELECT, new String[] {});
		try {
			while (rs.next()){
				Admin admin=new Admin();
				admin.setAdminId(rs.getInt("adminId"));
				admin.setUserName(rs.getString("userName"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setSex(rs.getString("sex"));
				admin.setTel(rs.getString("tel"));
				adminlist.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return adminlist;
	}
	/**
	 * 根据姓名获取Admin
	 */
	@Override
	public Admin getAdminByAdminName(String username) {
		return null;
	}
	/**
	 * 添加Admin
	 */
	@Override
	public boolean addAdmin(Admin Admin) {
		
		DBUtil.getConnection();
		////创建动态参数
		String[] param={Admin.getUserName(),Admin.getPassword(),Admin.getName(),Admin.getSex(),Admin.getTel()};
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
	 * 根据Id更新Admin
	 */
	@Override
	public boolean updateAdminById(int id, Admin Admin) {
		DBUtil.getConnection();
		String[] param={Admin.getUserName(),Admin.getPassword(),Admin.getName(),Admin.getSex(),Admin.getTel(),id+""};
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
	 * 删除Admin根据Id
	 */
	@Override
	public boolean delAdminById(int id) {
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
	public boolean updateAdminPWDById(int id, Admin Admin) {
		DBUtil.getConnection();
		String sql="update t_admin set "
				+ "password = ?  "
				+ " where adminId = ? ";
		String[] param={Admin.getPassword(),id+""};
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
