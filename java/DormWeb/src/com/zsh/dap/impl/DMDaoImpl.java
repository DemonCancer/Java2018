package com.zsh.dap.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zsh.dao.DMDao;
import com.zsh.pojo.DormManager;
import com.zsh.util.DBUtil;

public class DMDaoImpl extends DBUtil implements DMDao{

	String  SQL_SELECT= "select dormManId,userName,password,dormBuildId,name,sex,tel from t_dormmanager ";
	String SQL_INSERT = "insert into t_dormmanager(userName,password,dormBuildId,name,sex,tel) values ( ?, ?, ?, ?, ?, ? )";
	String SQL_UPDATE = "update t_dormmanager set "
			+ "userName = ?, password = ?, dormBuildId = ? , name = ?, sex = ?, tel = ?  "
			+ " where dormManId = ? ";
	String SQL_DELETE = "delete from t_dormmanager where dormManId = ?";
	
	@Override
	public List<DormManager> getDormManagerByDynamicWhere(String sql, String[] sqlParams) {
		
		DBUtil.getConnection();
		List<DormManager> dmlist=new ArrayList<DormManager>();
		String SQL=SQL_SELECT+" WHERE 1=1 "+sql;
		System.out.println(SQL);
		ResultSet rs = this.executeQuery(SQL, sqlParams);
		try {
			while (rs.next()){
				DormManager dm=new DormManager();
				dm.setDormManId(rs.getInt("dormManId"));
				dm.setUserName(rs.getString("userName"));
				dm.setPassword(rs.getString("password"));
				dm.setDormBuildId(rs.getInt("dormBuildId"));
				dm.setName(rs.getString("name"));
				dm.setSex(rs.getString("sex"));
				dm.setTel(rs.getString("tel"));
				dmlist.add(dm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return dmlist;
	}
	/**
	 * 获取所有
	 */
	@Override
	public List<DormManager> getAllDormManager() {
		DBUtil.getConnection();
		List<DormManager> dmlist=new ArrayList<DormManager>();
		ResultSet rs = this.executeQuery(SQL_SELECT, new String[] {});
		try {
			while (rs.next()){
				DormManager dm=new DormManager();
				dm.setDormManId(rs.getInt("dormManId"));
				dm.setUserName(rs.getString("userName"));
				dm.setPassword(rs.getString("password"));
				dm.setDormBuildId(rs.getInt("dormBuildId"));
				dm.setName(rs.getString("name"));
				dm.setSex(rs.getString("sex"));
				dm.setTel(rs.getString("tel"));
				dmlist.add(dm);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭连接
			this.closeAll();
		}
		return dmlist;
	}
	/**
	 * 根据姓名获取DM
	 */
	@Override
	public DormManager getDMByName(String username) {
		
		return null;
	}
	/**
	 * 添加DM
	 */
	@Override
	public boolean addDormManager(DormManager dm) {
		DBUtil.getConnection();
		////创建动态参数
		String[] param={dm.getUserName(),dm.getPassword(),dm.getDormBuildId()+"",dm.getName(),dm.getSex(),dm.getTel()};
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
	public boolean updateDMById(int id, DormManager dm) {
		DBUtil.getConnection();
		String[] param={dm.getUserName(),dm.getPassword(),
				dm.getDormBuildId()+"",dm.getName(),dm.getSex(),dm.getTel(),id+""};
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
	public boolean delDMById(int id) {
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
	public boolean updateDBIDById(int id, DormManager dm) {
		DBUtil.getConnection();
		String sql="update t_dormmanager set "
				+ " dormBuildId = ? "
				+ " where dormManId = ? ";
		String[] param={dm.getDormBuildId()+"",id+""};
		int x=this.executeUpdate(sql,param);
		this.closeAll();
		if(x>0){
			return true;
		}
		else{
			return false;
		}
	}
	@Override
	public boolean updateDMPWDById(int id, DormManager dm) {
		DBUtil.getConnection();
		String sql="update t_dormmanager set "
				+ " password = ? "
				+ " where dormManId = ? ";
		String[] param={dm.getPassword(),id+""};
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
